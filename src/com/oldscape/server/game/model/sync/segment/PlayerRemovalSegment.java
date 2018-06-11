package com.oldscape.server.game.model.sync.segment;

import com.oldscape.shared.model.Position;

/**
 * A {@link SynchronizationSegment} which removes a player.
 *
 * @author Graham
 */
public final class PlayerRemovalSegment extends SynchronizationSegment {

    /**
     * The position.
     */
    private final Position position;

    private final boolean update;

    private final int regionHash;

    /**
     * Creates the remove player segment.
     */
    public PlayerRemovalSegment(Position position) {
        super(EMPTY_BLOCK_SET);
        this.position = position;
        this.update = false;
        this.regionHash = -1;
    }

    /**
     * Creates the remove player segment.
     */
    public PlayerRemovalSegment(Position position, int regionHash) {
        super(EMPTY_BLOCK_SET);
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
        return SegmentType.REMOVE_MOB;
    }

}