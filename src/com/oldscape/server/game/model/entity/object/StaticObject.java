package com.oldscape.server.game.model.entity.object;


import com.oldscape.server.game.GameWorld;
import com.oldscape.server.game.model.entity.Entity;
import com.oldscape.server.game.model.entity.EntityType;
import com.oldscape.server.game.model.region.Position;
import com.oldscape.shared.cache.type.objects.ObjectType;

public class StaticObject extends Entity {

    ObjectType object;

    public StaticObject(GameWorld world, Position position, ObjectType object) {
        super(world, position);
        this.object = object;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: add.
        return false;
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.STATIC_OBJECT;
    }

    @Override
    public int hashCode() {
        // TODO: add.
        return 0;
    }

    public ObjectType getObjectType() {
        return object;
    }

}
