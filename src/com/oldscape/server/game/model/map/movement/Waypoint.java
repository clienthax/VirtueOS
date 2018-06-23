package com.oldscape.server.game.model.map.movement;

import com.oldscape.server.game.model.CompassPoint;
import com.oldscape.server.game.model.MoveSpeed;

public final class Waypoint {

    /**
     * The x-coordinate.
     */
    private final int x;

    /**
     * The y-coordinate.
     */
    private final int y;

    /**
     * The difference x between previous and current point.
     */
    private final int diffX;

    /**
     * The difference y between previous and current point.
     */
    private final int diffY;

    /**
     * The speed to travel at to this point
     */
    private final MoveSpeed speed;

    /**
     * Constructs a new {@code Point} {@code Object}.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param speed The movement speed
     */
    public Waypoint(int x, int y, MoveSpeed speed) {
        this(x, y, speed, 0, 0);
    }

    /**
     * Constructs a new {@code Point} {@code Object}.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param diffX The difference x between previous and current point.
     * @param diffY The difference y between previous and current point.
     */
    public Waypoint(int x, int y, MoveSpeed speed, int diffX, int diffY) {
        this.x = x;
        this.y = y;
        this.diffX = diffX;
        this.diffY = diffY;
        this.speed = speed;
    }

    /**
     * Gets the direction from the specified position to the new position
     * @param oldX The x-coordinate of the old position
     * @param oldY The y-coordinate of the old position
     * @return The direction
     */
    public CompassPoint getDirection (int oldX, int oldY) {
        return CompassPoint.forDelta(x - oldX, y - oldY);
    }

    /**
     * Gets the x.
     * @return The x.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y.
     * @return The y.
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the diffX.
     * @return The diffX.
     */
    public int getDiffX() {
        return diffX;
    }

    /**
     * Gets the diffY.
     * @return The diffY.
     */
    public int getDiffY() {
        return diffY;
    }

    public MoveSpeed getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return (x >> 6) + "," + (y >> 6) + "," + (x & 0x3f) + "," + (y & 0x3f);
    }

}