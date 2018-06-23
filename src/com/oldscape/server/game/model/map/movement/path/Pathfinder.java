package com.oldscape.server.game.model.map.movement.path;

import com.oldscape.server.game.model.map.Position;

public interface Pathfinder {

    /**
     * Finds a path from the location to the end location.
     * @param startCoords The start coordinates.
     * @param size The mover size.
     * @param end The end location.
     * @param sizeX The x-size of the destination node.
     * @param sizeY The y-size of the destination node.
     * @param rotation The location rotation.
     * @param shape The location shape.
     * @param surroundings The location surroundings.
     * @param near If we should find the nearest tile if a path can't be found.
     * @return The path.
     */
    public abstract Path find(Position startCoords, int size, Position end, int sizeX, int sizeY, int rotation, int shape, int surroundings, boolean near);
}