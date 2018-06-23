package com.oldscape.server.game.model.map.movement;

import com.oldscape.server.game.model.entity.Entity;

public interface EntityTarget {

    /**
     * Gets the target entity
     * @return The target entity
     */
    public Entity getEntity ();

    /**
     * Gets the allowable range for the entity to "reach" the target.
     * Note that there must be no clipped walls between the entity and the target in order to be in range
     * @return An integer representing the minimum allowed distance.
     */
    public int getRange ();

    /**
     * Called when the player/npc is within the specified range of the target
     * @return True if the target should be cleared, false if it should remain (eg following)
     */
    public boolean onReachTarget ();
}