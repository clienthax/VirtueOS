package com.oldscape.server.game.model.sync.task;

import com.oldscape.server.game.model.player.Player;

/**
 * A {@link SynchronizationTask} which does pre-synchronization work for the
 * specified {@link Player}.
 *
 * @author Graham
 */
public final class PrePlayerSynchronizationTask extends SynchronizationTask {

    /**
     * The player.
     */
    private final Player player;

    /**
     * Creates the {@link PrePlayerSynchronizationTask} for the specified
     * player.
     *
     * @param player The player.
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
    }

}