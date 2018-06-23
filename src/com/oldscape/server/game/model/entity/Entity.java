package com.oldscape.server.game.model.entity;

import com.oldscape.server.game.model.Node;
import com.oldscape.server.game.model.map.Position;

public abstract class Entity extends Node {

    protected int id;

    /**
     * The Position of this Entity.
     */
    protected Position position;

    /**
     * Creates the Entity.
     */
    public Entity(int id, Position position) {
        super(id);
        this.id = id;
        this.position = position;
    }

    @Override
    public abstract boolean equals(Object obj);

    /**
     * Gets the {@link Position} of this Entity.
     *
     * @return The Position.
     */
    public final Position getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    /**
     * Gets the {@link EntityType} of this Entity.
     *
     * @return The EntityType.
     */
    public abstract EntityType getEntityType();

    @Override
    public abstract int hashCode();

}