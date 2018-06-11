package com.oldscape.server.game.model.sync.reference;

/**
 * Represents a single movement direction.
 *
 * @author Graham
 */
public enum Direction {

    /**
     * No movement.
     */
    NONE(-1),

    /**
     * South west movement.
     */
    SOUTH_WEST(0),

    /**
     * South movement.
     */
    SOUTH(1),

    /**
     * South east movement.
     */
    SOUTH_EAST(2),

    /**
     * West movement.
     */
    WEST(3),

    /**
     * East movement.
     */
    EAST(4),

    /**
     * North west movement.
     */
    NORTH_WEST(5),

    /**
     * North movement.
     */
    NORTH(6),

    /**
     * North east movement.
     */
    NORTH_EAST(7);

    /**
     * An empty direction array.
     */
    public static final Direction[] EMPTY_DIRECTION_ARRAY = new Direction[0];
    /**
     * The direction as an integer.
     */
    private final int intValue;

    /**
     * Creates the direction.
     *
     * @param intValue The direction as an integer.
     */
    private Direction(int intValue) {
        this.intValue = intValue;
    }

    /**
     * Creates a direction from the differences between X and Y.
     *
     * @param deltaX The difference between two X coordinates.
     * @param deltaY The difference between two Y coordinates.
     * @return The direction.
     */
    public static Direction fromDeltas(int deltaX, int deltaY) {
        if (deltaY == 1) {
            if (deltaX == 1) {
                return Direction.NORTH_EAST;
            } else if (deltaX == 0) {
                return Direction.NORTH;
            }
            return Direction.NORTH_WEST;
        } else if (deltaY == -1) {
            if (deltaX == 1) {
                return Direction.SOUTH_EAST;
            } else if (deltaX == 0) {
                return Direction.SOUTH;
            }
            return Direction.SOUTH_WEST;
        } else {
            if (deltaX == 1) {
                return Direction.EAST;
            } else if (deltaX == -1) {
                return Direction.WEST;
            }
        }

        return Direction.NONE;
    }

    /**
     * Checks if the direction represented by the two delta values can connect
     * two points together in a single direction.
     *
     * @param deltaX The difference in X coordinates.
     * @param deltaY The difference in X coordinates.
     * @return {@code true} if so, {@code false} if not.
     */
    public static boolean isConnectable(int deltaX, int deltaY) {
        return Math.abs(deltaX) == Math.abs(deltaY) || deltaX == 0 || deltaY == 0;
    }

    /**
     * Gets the direction as an integer which the client can understand.
     *
     * @return The movement as an integer.
     */
    public int toInteger() {
        return intValue;
    }

}