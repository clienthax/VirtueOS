package com.oldscape.server.game.model.sync.segment;

/**
 * A {@link SynchronizationSegment} which removes a npc.
 *
 * @author Graham
 */
public final class CycleStartSegment extends SynchronizationSegment {

    /**
     * Creates the remove npc segment.
     */
    public CycleStartSegment() {
        super(EMPTY_BLOCK_SET);
    }

    @Override
    public SegmentType getType() {
        return SegmentType.CYCLE_START;
    }

}