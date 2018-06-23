package com.oldscape.server.game.model.map;

import com.oldscape.server.game.model.Node;
import com.oldscape.server.game.model.entity.object.ObjectShape;
import com.oldscape.shared.cache.type.TypeListManager;
import com.oldscape.shared.cache.type.objects.ObjectType;

public class ObjectLocation extends Node {

    public static ObjectLocation createBase (int id, Position tile, ObjectShape shape, int rotation) {
        ObjectLocation location = new ObjectLocation(id, tile, shape, rotation);
        location.replacement = false;
        return location;
    }

    public static ObjectLocation create (int id, Position tile, ObjectShape shape, int rotation) {
        ObjectLocation location = new ObjectLocation(id, tile, shape, rotation);
        return location;
    }

    private final ObjectShape shape;

    private final int rotation;

    private boolean replacement = true;

    private ObjectType locType;

    protected ObjectLocation (int id, Position tile, ObjectShape shape, int rotation) {
        super(id);
        super.currentTile = tile;
        this.shape = shape;
        this.rotation = rotation;
        if (id >= 0) {
            if ((rotation & 2) == 0) {
                super.setSizeX(getLocType().getSizeX());
                super.setSizeY(getLocType().getSizeY());
            } else {
                super.setSizeX(getLocType().getSizeY());
                super.setSizeY(getLocType().getSizeX());
            }
        }
    }

    @Override
    public String getName() {
        return getLocType().getName();
    }

    /**
     * Gets the id for this scene location
     * @return The id
     */
    public int getID () {
        return id;
    }

    /**
     * Checks whether this location is a replacement for a static location on the map
     * If true, the location will be sent to new players as they enter the map square
     * @return True if the location is a replacement, false if it is from the map archive
     */
    public boolean isReplacement() {
        return replacement;
    }

    /**
     * Gets the {@link Position} on which this location sits
     * @return The tile
     */
    public Position getTile () {
        return currentTile;
    }

    public Position getMiddleTile () {
        int x = (currentTile.getX()*2 + getLocType().getSizeX())/2;
        int y = (currentTile.getY()*2 + getLocType().getSizeY())/2;
        return new Position(x, y, currentTile.getZ());
    }

    /**
     * Gets the shape of this location (eg wall, door, stand-alone, etc)
     * @return The shape
     */
    public ObjectShape getShape () {
        return shape;
    }

    /**
     * Gets the cache definition for this location
     * @return The cache definition
     */
    public ObjectType getLocType () {
        if (locType == null) {
            //TODO: Simplify this line (by giving the config provider or something)
            locType = TypeListManager.lookupObject(id);
        }
        return locType;
    }

    /**
     * Gets the current rotation of the scene location
     * @return
     */
    public int getRotation () {
        return rotation;
    }

//    /**
//     * Checks whether or not the specified option can be handled from a distance
//     * @param option The option to check
//     * @return True if the option can be handled from a distance, false otherwise.
//     */
//    public boolean distanceOption (OptionButton option) {
//        return OptionButton.SIX.equals(option);
//    }

    /**
     * Returns whether the coords are directly adjacent to this location
     * @param coords The coords to check
     * @return True if the tile is adjacent, false otherwise
     */
    public boolean isAdjacentTo (Position coords) {
        int tileX = coords.getX();
        int minX = currentTile.getX();
        int maxX = minX + getLocType().getSizeX() - 1;
        int dx;
        if (tileX < minX) {
            dx = minX - tileX;
        } else if (tileX > maxX) {
            dx = tileX - maxX;
        } else {
            dx = 0;
        }
        int tileY = coords.getY();
        int minY = currentTile.getY();
        int maxY = minY + getLocType().getSizeY() - 1;
        int dy;
        if (tileY < minY) {
            dy = minY - tileY;
        } else if (tileY > maxY) {
            dy = tileY - maxY;
        } else {
            dy = 0;
        }
        if (dx == 0 && dy == 0) {
            return false;//Entity is on the same tile
        } else if ((dx == 1 && dy == 0) || (dx == 0 && dy == 1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStandingOn (Position coords) {
        int coordX = coords.getX();
        int minX = currentTile.getX();
        int maxX = minX + getLocType().getSizeX() - 1;
        int coordY = coords.getY();
        int minY = currentTile.getY();
        int maxY = minY + getLocType().getSizeY() - 1;
        if (coordX >= minX && coordX <= maxX
                && coordY >= minY && coordY <= maxY) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((currentTile == null) ? 0 : currentTile.hashCode());
        result = prime * result + id;
        result = prime * result + rotation;
        result = prime * result + ((shape == null) ? 0 : shape.hashCode());
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
        ObjectLocation other = (ObjectLocation) obj;
        if (currentTile == null) {
            if (other.currentTile != null)
                return false;
        } else if (!currentTile.equals(other.currentTile))
            return false;
        if (id != other.id)
            return false;
        if (rotation != other.rotation)
            return false;
        if (shape != other.shape)
            return false;
        return true;
    }

    @Override
    public String toString () {
        return "Location[type="+id+", shape="+shape+", rotation="+rotation+", name="+getLocType().getName()+", coord="+currentTile+"]";
    }
}
