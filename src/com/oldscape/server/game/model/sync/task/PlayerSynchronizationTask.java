package com.oldscape.server.game.model.sync.task;

import com.oldscape.server.game.Server;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.model.player.Viewport;
import com.oldscape.server.game.model.sync.reference.Direction;
import com.oldscape.server.game.model.sync.segment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@link SynchronizationTask} which synchronizes the specified {@link Player}
 * .
 *
 * @author Graham
 */
public final class PlayerSynchronizationTask extends SynchronizationTask {

    /**
     * The maximum number of players to load per cycle. This prevents the update
     * packet from becoming too large (the client uses a 5000 byte buffer) and
     * also stops old spec PCs from crashing when they login or teleport.
     */
    private static final int NEW_PLAYERS_PER_CYCLE = 15;
    /**
     * The player.
     */
    private final Player player;
    /**
     * The {@link com.oldscape.server.game.Server} reference.
     */
    protected Server server;

    /**
     * Creates the {@link PlayerSynchronizationTask} for the specified player.
     *
     * @param player The player.
     */
    public PlayerSynchronizationTask(Server server, Player player) {
        this.server = server;
        this.player = player;
    }

    public List<SynchronizationSegment> getSegments() {
        Viewport viewport = player.getViewport();

        if (!viewport.initialized())
            return new ArrayList<>();

        if (player.hasRegionChanged()) {
            player.setRegion(server.getRegionManager().lookup(player.getPosition().getRegionID()));
        }

        List<SynchronizationSegment> segments = new ArrayList<>();

        int skipCount = 0;

        segments.add(new CycleStartSegment());

        for (int index = 0; index < viewport.getLocalPlayersIndexesCount(); index++) {
            int playerIndex = viewport.getLocalPlayersIndex(index);

            if ((0x1 & viewport.getSlotFlag(playerIndex)) != 0) {
                continue;
            }

            if (skipCount > 0) {
                skipCount--;
                viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
                continue;
            }

            Player p = viewport.getLocalPlayer(playerIndex);
            if (p == null || !p.isActive()
                    || p.getPosition().getLongestDelta(player.getPosition()) > viewport.getViewingDistance()
                    || !p.getPosition().withinDistance(player.getPosition(), viewport.getViewingDistance())) {

                boolean update = viewport.regionUpdate(playerIndex, p.getPosition().toRegionPacked());
                if (update) {
                    segments.add(new PlayerRemovalSegment(p.getPosition(), viewport.getRegionHash(playerIndex)));
                    viewport.setRegionHash(playerIndex, p.getPosition().toRegionPacked());
                } else {
                    segments.add(new PlayerRemovalSegment(p.getPosition()));
                }

                viewport.setLocalPlayer(index, null);
            } else {
                if (p.isTeleporting()) {
                    segments.add(new TeleportSegment(p.getBlockSet(), p.getLastPosition(), p.getPosition()));
                } else if (!p.getFirstDirection().equals(Direction.NONE) || p.getBlockSet().size() > 0) {
                    segments.add(new MovementSegment(p.getBlockSet(), p.getDirections()));
                } else {
                    for (int idx = index + 1; idx < viewport.getLocalPlayersIndexesCount(); idx++) {
                        int playerIdx = viewport.getLocalPlayersIndex(idx);
                        if ((0x1 & viewport.getSlotFlag(playerIdx)) != 0) {
                            continue;
                        }

                        Player pl = viewport.getLocalPlayer(playerIdx);
                        if (pl == null || !pl.isActive()
                                || pl.getPosition().getLongestDelta(player.getPosition()) > viewport.getViewingDistance()
                                || !pl.getPosition().withinDistance(player.getPosition(), viewport.getViewingDistance())
                                || !pl.getFirstDirection().equals(Direction.NONE) || pl.isTeleporting()) {
                            break;
                        }

                        skipCount++;
                    }
                    segments.add(new PlayerSkipSegment(skipCount));

                    viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
                }
            }
        }


        segments.add(new CycleEndSegment());

        skipCount = 0;

        segments.add(new CycleStartSegment());

        for (int index = 0; index < viewport.getLocalPlayersIndexesCount(); index++) {
            int playerIndex = viewport.getLocalPlayersIndex(index);

            if ((0x1 & viewport.getSlotFlag(playerIndex)) == 0) {
                continue;
            }

            if (skipCount > 0) {
                skipCount--;
                viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
                continue;
            }

            Player p = viewport.getLocalPlayer(playerIndex);
            if (p == null || !p.isActive()
                    || p.getPosition().getLongestDelta(player.getPosition()) > viewport.getViewingDistance()
                    || !p.getPosition().withinDistance(player.getPosition(), viewport.getViewingDistance())) {
                boolean update = viewport.regionUpdate(playerIndex, p.getPosition().toRegionPacked());
                if (update) {
                    segments.add(new PlayerRemovalSegment(p.getPosition(), viewport.getRegionHash(playerIndex)));
                    viewport.setRegionHash(playerIndex, p.getPosition().toRegionPacked());
                } else {
                    segments.add(new PlayerRemovalSegment(p.getPosition()));
                }

                viewport.setLocalPlayer(index, null);
            } else {
                if (p.isTeleporting()) {
                    segments.add(new TeleportSegment(p.getBlockSet(), p.getLastPosition(), p.getPosition()));
                } else if (!p.getFirstDirection().equals(Direction.NONE) || p.getBlockSet().size() > 0) {
                    segments.add(new MovementSegment(p.getBlockSet(), p.getDirections()));
                } else {
                    for (int idx = index + 1; idx < viewport.getLocalPlayersIndexesCount(); idx++) {
                        int playerIdx = viewport.getLocalPlayersIndex(idx);
                        if ((0x1 & viewport.getSlotFlag(playerIdx)) == 0) {
                            continue;
                        }

                        Player pl = viewport.getLocalPlayer(playerIdx);
                        if (pl == null || !pl.isActive()
                                || pl.getPosition().getLongestDelta(player.getPosition()) > viewport.getViewingDistance()
                                || !pl.getPosition().withinDistance(player.getPosition(), viewport.getViewingDistance())
                                || !pl.getFirstDirection().equals(Direction.NONE) || pl.isTeleporting()) {
                            break;
                        }

                        skipCount++;
                    }
                    segments.add(new PlayerSkipSegment(skipCount));
                    viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
                }
            }
        }

        segments.add(new CycleEndSegment());

        skipCount = 0;

        segments.add(new CycleStartSegment());

        for (int index = 0; index < viewport.getOutPlayersIndexesCount(); index++) {
            int playerIndex = viewport.getOutPlayersIndex(index);
            if ((0x1 & viewport.getSlotFlag(playerIndex)) == 0) {
                continue;
            }

            if (skipCount > 0) {
                skipCount--;
                viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
                continue;
            }
            Player p = server.getGameWorld().getPlayers().get(playerIndex);
            boolean update = p == null ? false : viewport.regionUpdate(playerIndex, p.getPosition().toRegionPacked());
            if (p != null && p != player && p.isActive()
                    && p.getPosition().withinDistance(player.getPosition(), viewport.getViewingDistance())) {
                if (update) {
                    segments.add(new PlayerAdditionSegment(p.getBlockSet(), p.getPosition(), viewport.getRegionHash(playerIndex)));
                    viewport.setRegionHash(playerIndex, p.getPosition().toRegionPacked());
                } else {
                    segments.add(new PlayerAdditionSegment(p.getBlockSet(), p.getPosition()));
                }

                viewport.setLocalPlayer(playerIndex, p);
                viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
            } else {
                if (update) {
                    segments.add(new RegionHashSegment(p.getPosition(), viewport.getRegionHash(playerIndex)));
                    viewport.setRegionHash(playerIndex, p.getPosition().toRegionPacked());
                } else {
                    for (int idx = index + 1; idx < viewport.getOutPlayersIndexesCount(); idx++) {
                        int playerIdx = viewport.getOutPlayersIndex(idx);
                        if ((0x1 & viewport.getSlotFlag(playerIdx)) == 0) {
                            continue;
                        }

                        Player pl = server.getGameWorld().getPlayers().get(playerIdx);
                        if (pl != null && pl != player && pl.isActive()
                                && pl.getPosition().withinDistance(player.getPosition(), viewport.getViewingDistance())
                                && !viewport.regionUpdate(playerIdx, pl.getPosition().toRegionPacked())) {
                            break;
                        }

                        skipCount++;
                    }
                    segments.add(new PlayerSkipSegment(skipCount));
                    viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
                }
            }
        }

        segments.add(new CycleEndSegment());

        skipCount = 0;

        segments.add(new CycleStartSegment());


        for (int index = 0; index < viewport.getOutPlayersIndexesCount(); index++) {
            int playerIndex = viewport.getOutPlayersIndex(index);
            if ((0x1 & viewport.getSlotFlag(playerIndex)) != 0)
                continue;

            if (skipCount > 0) {
                skipCount--;
                viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
                continue;
            }

            Player p = server.getGameWorld().getPlayers().get(playerIndex);
            boolean update = p == null ? false : viewport.regionUpdate(playerIndex, p.getPosition().toRegionPacked());

            if (p != null && p != player && p.isActive() && p.getPosition().withinDistance(player.getPosition(), viewport.getViewingDistance())) {
                if (update) {
                    segments.add(new PlayerAdditionSegment(p.getBlockSet(), p.getPosition(), viewport.getRegionHash(playerIndex)));
                    viewport.setRegionHash(playerIndex, p.getPosition().toRegionPacked());
                } else {
                    segments.add(new PlayerAdditionSegment(p.getBlockSet(), p.getPosition()));
                }

                viewport.setLocalPlayer(playerIndex, p);
                viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
            } else {
                if (update) {
                    segments.add(new RegionHashSegment(p.getPosition(), viewport.getRegionHash(playerIndex)));
                    viewport.setRegionHash(playerIndex, p.getPosition().toRegionPacked());
                } else {//Problem in here?

                    for (int idx = index + 1; idx < viewport.getOutPlayersIndexesCount(); idx++) {
                        int playerIdx = viewport.getOutPlayersIndex(idx);
                        if ((0x1 & viewport.getSlotFlag(playerIdx)) != 0) {
                            continue;
                        }

                        Player pl = server.getGameWorld().getPlayers().get(playerIdx);
                        if (pl != null && pl != player && pl.isActive()
                                && pl.getPosition().withinDistance(player.getPosition(), viewport.getViewingDistance())
                                && !viewport.regionUpdate(playerIdx, pl.getPosition().toRegionPacked())) {
                            break;
                        }

                        skipCount++;
                    }
                    segments.add(new PlayerSkipSegment(skipCount));
                    viewport.setSlotFlag(playerIndex, (byte) (viewport.getSlotFlag(playerIndex) | 0x2));
                }
            }
        }

        segments.add(new CycleEndSegment());
        return segments;
    }

    @Override
    public void run() {
        player.sendPlayerSynchronization(getSegments());
    }

}