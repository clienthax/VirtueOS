package com.oldscape.server.game.model.sync.task;

import com.oldscape.server.game.model.entity.player.Player;

/**
 * A {@link SynchronizationTask} which does pre-synchronization work for the
 * specified {@link Player}.
 *
 * @author Graham
 */
public final class PrePlayerSynchronizationTask extends SynchronizationTask {

    /**
     * The account.
     */
    private final Player player;

    /**
     * Creates the {@link PrePlayerSynchronizationTask} for the specified
     * account.
     *
     * @param player The account.
     */
    public PrePlayerSynchronizationTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        player.getWalkingQueue().pulse();

        if (player.isTeleporting()) {
            player.getViewport().resetViewingDistance();
        }

        player.getWalkingQueue().handleRegionChange();
    }

}