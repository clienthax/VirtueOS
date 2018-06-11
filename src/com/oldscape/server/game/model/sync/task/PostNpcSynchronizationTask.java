package com.oldscape.server.game.model.sync.task;

import com.oldscape.server.game.model.npc.Npc;

/**
 * A {@link SynchronizationTask} which does post-synchronization work for the
 * specified {@link Npc}.
 *
 * @author Major
 */
public final class PostNpcSynchronizationTask extends SynchronizationTask {

    /**
     * The npc.
     */
    private final Npc npc;

    /**
     * Creates the {@link PostNpcSynchronizationTask} for the specified player.
     *
     * @param npc The npc.
     */
    public PostNpcSynchronizationTask(Npc npc) {
        this.npc = npc;
    }

    @Override
    public void run() {
        npc.setTeleporting(false);
        npc.resetBlockSet();
    }

}