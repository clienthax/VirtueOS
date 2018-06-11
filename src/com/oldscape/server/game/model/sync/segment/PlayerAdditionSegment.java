package com.oldscape.server.game.model.sync.segment;

import com.oldscape.server.game.model.sync.block.SynchronizationBlockSet;
import com.oldscape.shared.model.Position;

/**
 * A {@link SynchronizationSegment} which adds a player.
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
     * Creates the add player segment.
     *
     * @param blockSet The block set.
     * @param index    The player's index.
     * @param position The position.
     */
    public PlayerAdditionSegment(SynchronizationBlockSet blockSet, Position position) {
        super(blockSet);
        this.position = position;
        this.update = false;
        this.regionHash = -1;
    }

    /**
     * Creates the add player segment.
     *
     * @param blockSet The block set.
     * @param index    The player's index.
     * @param position The position.
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