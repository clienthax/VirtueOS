package com.oldscape.server.game.model.sync.task;

import com.oldscape.server.game.model.entity.player.Player;

/**
 * A {@link SynchronizationTask} which does post-synchronization work for the
 * specified {@link Player}.
 *
 * @author Graham
 */
public final class PostPlayerSynchronizationTask extends SynchronizationTask {

    /**
     * The account.
     */
    private final Player player;

    /**
     * Creates the {@link PostPlayerSynchronizationTask} for the specified
     * account.
     *
     * @param player The account.
     */
    public PostPlayerSynchronizationTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        if (player.isTeleporting()) {
            player.setTeleporting(false);
        }

        player.setRegionChange(false);

        player.resetBlockSet();

        player.getViewport().refresh();
    }

}