package com.oldscape.server.game.model.entity;

import com.oldscape.server.game.GameWorld;
import com.oldscape.shared.model.EntityType;
import com.oldscape.shared.model.Position;

public abstract class Entity {

    /**
     * The World containing this Entity.
     */
    protected final GameWorld world;
    /**
     * The Position of this Entity.
     */
    protected Position position;

    /**
     * Creates the Entity.
     *
     * @param world    The {@link World} containing the Entity.
     * @param position The {@link Position} of the Entity.
     */
    public Entity(GameWorld world, Position position) {
        this.world = world;
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

    /**
     * Gets the {@link World} this Entity is in.
     *
     * @return The World.
     */
    public GameWorld getWorld() {
        return world;
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