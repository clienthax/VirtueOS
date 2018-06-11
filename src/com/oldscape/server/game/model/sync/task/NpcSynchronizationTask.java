package com.oldscape.server.game.model.sync.task;

import com.oldscape.server.game.Server;
import com.oldscape.server.game.model.npc.Npc;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.model.sync.segment.MovementSegment;
import com.oldscape.server.game.model.sync.segment.NpcAdditionSegment;
import com.oldscape.server.game.model.sync.segment.NpcRemovalSegment;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.model.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A {@link SynchronizationTask} which synchronizes npcs with the specified
 * {@link Player}.
 *
 * @author Major
 */
public final class NpcSynchronizationTask extends SynchronizationTask {

    /**
     * The maximum number of npcs to load per cycle. This prevents the update
     * packet from becoming too large (the client uses a 5000 byte buffer) and
     * also stops old spec PCs from crashing when they login or teleport.
     */
    private static final int NEW_NPCS_PER_CYCLE = 20;
    /**
     * The player.
     */
    private final Player player;
    /**
     * The {@link com.oldscape.server.game.Server} reference.
     */
    protected Server server;

    /**
     * Creates the {@link NpcSynchronizationTask} for the specified player.
     *
     * @param player The player.
     */
    public NpcSynchronizationTask(Server server, Player player) {
        this.server = server;
        this.player = player;
    }

    @Override
    public void run() {
        List<Npc> localNpcs = player.getViewport().getLocalNpcs();

        List<SynchronizationSegment> segments = new ArrayList<>();
        int oldLocalNpcs = localNpcs.size();
        final Position playerPosition = player.getPosition();

        //in screen npcs
        for (Iterator<Npc> it = localNpcs.iterator(); it.hasNext(); ) {
            Npc npc = it.next();
            if (!npc.isActive() || npc.isTeleporting() || npc.getPosition().getLongestDelta(playerPosition) > player.getViewport().getViewingDistance()) {
                it.remove();
                segments.add(new NpcRemovalSegment());
            } else {
                segments.add(new MovementSegment(npc.getBlockSet(), npc.getDirections()));
            }
        }


        //new npcs
        int added = 0;
        for (Npc npc : server.getGameWorld().getNpcs()) {
            if (localNpcs.size() >= 255) {
                player.getViewport().flagExcessiveNpcs();
                break;
            } else if (added >= NEW_NPCS_PER_CYCLE) {
                break;
            }

            Position npcPosition = npc.getPosition();
            if (npcPosition.withinDistance(playerPosition, player.getViewport().getViewingDistance())
                    && !localNpcs.contains(npc) && npcPosition.getHeight() == playerPosition.getHeight()) {
                localNpcs.add(npc);
                added++;
                npc.turnTo(npc.getFacingPosition());
                segments.add(new NpcAdditionSegment(npc.getBlockSet(), npc.getIndex(), npcPosition, npc.getId()));
            }
        }

        player.sendNpcSynchronization(playerPosition, segments, oldLocalNpcs);
    }

}