package com.oldscape.server.game.model.entity.object;

import com.oldscape.server.game.model.entity.Entity;
import com.oldscape.server.game.model.entity.EntityType;
import com.oldscape.server.game.model.map.Position;
import com.oldscape.shared.cache.type.TypeListManager;
import com.oldscape.shared.cache.type.objects.ObjectType;

public class DynamicObject extends Entity {

    private int object;

    private int direction;

    private int type;

    public DynamicObject(Position position, int object, int direction, int type) {
        super(object, position);

        this.object = object;
        this.direction = direction;
        this.type = type;
        this.position = position;
    }


    @Override
    public boolean equals(Object obj) {
        // TODO: add this.
        return false;
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.DYNAMIC_OBJECT;
    }

    @Override
    public int hashCode() {
        // TODO: add this.
        return 0;
    }

    public int getObject() {
        return object;
    }

    public int getDirection() {
        return direction;
    }

    public int getType() {
        return type;
    }

    public ObjectType getObjectType() {
        return TypeListManager.lookupObject(getObject());
    }

    @Override
    public String getName() {
        return getObjectType().getName();
    }
}
