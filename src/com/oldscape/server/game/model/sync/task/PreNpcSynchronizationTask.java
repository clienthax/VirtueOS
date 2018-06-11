package com.oldscape.server.game.model.sync.task;

import com.oldscape.server.game.model.npc.Npc;

/**
 * A {@link SynchronizationTask} which does pre-synchronization work for the
 * specified npc.
 *
 * @author Major
 */
public final class PreNpcSynchronizationTask extends SynchronizationTask {

    /**
     * The npc.
     */
    private final Npc npc;

    /**
     * Creates the {@link PreNpcSynchronizationTask} for the specified npc.
     *
     * @param npc The npc.
     */
    public PreNpcSynchronizationTask(Npc npc) {
        this.npc = npc;
    }

    @Override
    public void run() {
        npc.getWalkingQueue().pulse();
    }

}