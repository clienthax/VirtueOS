package com.oldscape.server.game.model;

import com.oldscape.server.game.model.map.Position;

/**
 * Created by sean on 16/07/14.
 */
public abstract class Node {

    /**
     * The node id.
     */
    protected int id;

    /**
     * The current location.
     */
    protected Position currentTile;

    /**
     * The horizontal size.
     */
    private int sizeX = 1;

    /**
     * The vertical size of the node.
     */
    private int sizeY = 1;

    /**
     * Constructs a new {@code Node} {@code Object}.
     * @param id The node.
     */
    public Node(int id) {
        this.id = id;
    }

    /**
     * Gets the center tile of this node.
     * @return The tile in the center of the node (rather than the traditional south-west corner tile).
     */
    public Position getCenterTile() {
        return currentTile.copyNew(sizeX >> 1, sizeY >> 1, 0);
    }

    /**
     * Sets the size.
     * @param size The sizE.
     */
    public void setSize(int size) {
        sizeX = sizeY = size;
    }

    /**
     * Gets the size.
     * @return The size.
     */
    public int getSize() {
        return sizeX;
    }

    /**
     * Cheap fix for scripts using getID..
     * @return The id.
     */
    public int getID() {
        return getId();
    }

    /**
     * Gets the id value.
     * @return The id.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name value.
     * @return The name.
     */
    public abstract String getName();

    /**
     * Gets the currentTile value.
     * @return The currentTile.
     */
    public Position getCurrentTile() {
        return currentTile;
    }

    /**
     * Sets the currentTile value.
     * @param currentTile The currentTile to set.
     */
    public void setCurrentTile(Position currentTile) {
        this.currentTile = currentTile;
    }

    /**
     * Gets the sizeX value.
     * @return The sizeX.
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     * Sets the sizeX value.
     * @param sizeX The sizeX to set.
     */
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    /**
     * Gets the sizeY value.
     * @return The sizeY.
     */
    public int getSizeY() {
        return sizeY;
    }

    /**
     * Sets the sizeY value.
     * @param sizeY The sizeY to set.
     */
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

}
