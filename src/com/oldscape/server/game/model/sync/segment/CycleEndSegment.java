package com.oldscape.server.game.model.sync.segment;

/**
 * A {@link SynchronizationSegment} which removes a npc.
 *
 * @author Graham
 */
public final class CycleEndSegment extends SynchronizationSegment {

    /**
     * Creates the remove npc segment.
     */
    public CycleEndSegment() {
        super(EMPTY_BLOCK_SET);
    }

    @Override
    public SegmentType getType() {
        return SegmentType.CYCLE_END;
    }

}