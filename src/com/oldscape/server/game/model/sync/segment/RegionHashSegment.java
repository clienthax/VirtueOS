package com.oldscape.server.game.model.sync.segment;

import com.oldscape.shared.model.Position;

/**
 * A {@link SynchronizationSegment} which removes a npc.
 *
 * @author Graham
 */
public final class RegionHashSegment extends SynchronizationSegment {

    /**
     * The position.
     */
    private final Position position;

    private final int regionHash;

    /**
     * Creates the remove npc segment.
     */
    public RegionHashSegment(Position position, int regionHash) {
        super(EMPTY_BLOCK_SET);
        this.position = position;
        this.regionHash = regionHash;
    }

    /**
     * Gets the position.
     *
     * @return The position.
     */
    public Position getPosition() {
        return position;
    }

    public int getRegionHash() {
        return regionHash;
    }

    @Override
    public SegmentType getType() {
        return SegmentType.REGION_HASH;
    }

}