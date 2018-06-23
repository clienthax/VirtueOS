package com.oldscape.server.game.model.map.movement.path;

public final class Point {

    /**
     * The x-coordinate.
     */
    private final int x;

    /**
     * The y-coordinate.
     */
    private final int y;

    /**
     * Constructs a new {@code Point} {@code Object}.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return x +","+y;
    }

}
