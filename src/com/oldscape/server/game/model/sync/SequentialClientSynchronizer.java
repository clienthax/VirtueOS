package com.oldscape.server.game.model.sync;

import com.oldscape.server.game.Server;
import com.oldscape.server.game.model.entity.npc.Npc;
import com.oldscape.server.game.model.entity.player.Player;
import com.oldscape.server.game.model.sync.task.*;
import com.oldscape.shared.utility.MobList;

/**
 * An implementation of {@link ClientSynchronizer} which runs in a single thread
 * (the {@link GameService} thread from which this is called). Each client is
 * processed sequentially. Therefore this class will work well on machines with
 * a single core/processor. The {@link ParallelClientSynchronizer} will work
 * better on machines with multiple cores/processors, however, both classes will
 * work.
 *
 * @author Graham
 * @author Major
 */
public final class SequentialClientSynchronizer extends ClientSynchronizer {

    /**
     * Creates the sequential client synchronizer
     */
    public SequentialClientSynchronizer(Server server) {
        super(server);
    }

    @Override
    public void synchronize() {
        MobList<Player> players = server.getGameWorld().getPlayers();
        MobList<Npc> npcs = server.getGameWorld().getNpcs();

        for (Player player : players) {
            SynchronizationTask task = new PrePlayerSynchronizationTask(player);
            task.run();
        }

        for (Npc npc : npcs) {
            SynchronizationTask task = new PreNpcSynchronizationTask(npc);
            task.run();
        }

        for (Player player : players) {
            SynchronizationTask task = new PlayerSynchronizationTask(server, player);
            task.run();
        }

        for (Player player : players) {
            SynchronizationTask task = new NpcSynchronizationTask(server, player);
            task.run();
        }

        for (Player player : players) {
            SynchronizationTask task = new PostPlayerSynchronizationTask(player);
            task.run();
        }

        for (Npc npc : npcs) {
            SynchronizationTask task = new PostNpcSynchronizationTask(npc);
            task.run();
        }
    }

}