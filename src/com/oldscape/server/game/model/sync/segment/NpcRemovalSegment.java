package com.oldscape.server.game.model.sync.segment;

/**
 * A {@link SynchronizationSegment} which removes a npc.
 *
 * @author Graham
 */
public final class NpcRemovalSegment extends SynchronizationSegment {

    /**
     * Creates the remove npc segment.
     */
    public NpcRemovalSegment() {
        super(EMPTY_BLOCK_SET);
    }

    @Override
    public SegmentType getType() {
        return SegmentType.REMOVE_MOB;
    }

}