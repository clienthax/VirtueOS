package com.oldscape.server.game.model.map.movement.path;

import java.util.ArrayDeque;
import java.util.Deque;

public class Path {

    /**
     * If the path was found.
     */
    private boolean succesful;

    /**
     * If we have to move near the destination (as we can't reach it).
     */
    private boolean moveNear;

    /**
     * The points to walk.
     */
    private Deque<Point> points = new ArrayDeque<Point>();

    /**
     * Constructs a new {@code Path} {@code Object}.
     */
    public Path() {
        /*
         * empty.
         */
    }

    /**
     * Gets the succesful.
     * @return The succesful.
     */
    public boolean isSuccessful() {
        return succesful;
    }

    /**
     * Sets the succesful.
     * @param succesful The succesful to set.
     */
    public void setSuccesful(boolean succesful) {
        this.succesful = succesful;
    }

    /**
     * Gets the points.
     * @return The points.
     */
    public Deque<Point> getPoints() {
        return points;
    }

    /**
     * Sets the points.
     * @param points The points to set.
     */
    public void setPoints(Deque<Point> points) {
        this.points = points;
    }

    /**
     * Gets the moveNear.
     * @return The moveNear.
     */
    public boolean isMoveNear() {
        return moveNear;
    }

    /**
     * Sets the moveNear.
     * @param moveNear The moveNear to set.
     */
    public void setMoveNear(boolean moveNear) {
        this.moveNear = moveNear;
    }

}