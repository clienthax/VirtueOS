package com.oldscape.server.game.model.sync.segment;

import com.oldscape.server.game.model.sync.block.SynchronizationBlockSet;
import com.oldscape.server.game.model.map.Position;

/**
 * A {@link SynchronizationSegment} which adds a account.
 *
 * @author Graham
 */
public final class PlayerAdditionSegment extends SynchronizationSegment {

    /**
     * The position.
     */
    private final Position position;

    private final boolean update;

    private final int regionHash;

    /**
     * Creates the add account segment.
     *
     * @param blockSet The block set.
     * @param position The position.
     */
    public PlayerAdditionSegment(SynchronizationBlockSet blockSet, Position position) {
        super(blockSet);
        this.position = position;
        this.update = false;
        this.regionHash = -1;
    }

    /**
     * Creates the add account segment.
     *
     * @param blockSet The block set.
     * @param position The position.
     * @param regionHash The map.
     */
    public PlayerAdditionSegment(SynchronizationBlockSet blockSet, Position position, int regionHash) {
        super(blockSet);
        this.position = position;
        this.update = true;
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

    public boolean isUpdate() {
        return update;
    }

    public int getRegionHash() {
        return regionHash;
    }

    @Override
    public SegmentType getType() {
        return SegmentType.ADD_MOB;
    }

}