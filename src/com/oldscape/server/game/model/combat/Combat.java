package com.oldscape.server.game.model.combat;

import com.oldscape.server.game.model.MobileEntity;
import com.oldscape.server.game.model.player.Player;

/**
 * Combat Class
 *
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 11, 2015
 */
public class Combat {

    /**
     * The mobile entity class
     */
    @SuppressWarnings("unused")
    private final MobileEntity entity;

    /**
     * The current hitPoints for this Entity.
     */
    private int hitPoints;

    /**
     * The maximum amount of hitPoints this Entity can have.
     */
    private int maxHitpoints;

    /**
     * Special attack amount.
     */
    private int specialEnergy;


    public Combat(MobileEntity entity) {
        this.entity = entity;
        if (entity instanceof Player) {
            //hitPoints = ((Player) entity).getSkills().getCurrentLevel(Skills.HITPOINTS);
            //maxHitpoints = ((Player) entity).getSkills().getBaseLevel(Skills.HITPOINTS);
            specialEnergy = 100;
        } else {
            specialEnergy = 0;
        }
    }


    /**
     * @return the hitPoints
     */
    public int getHitPoints() {
        return hitPoints;
    }


    /**
     * @param hitPoints the hitPoints to set
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }


    /**
     * @return the maxHitpoints
     */
    public int getMaxHitpoints() {
        return maxHitpoints;
    }


    /**
     * @param maxHitpoints the maxHitpoints to set
     */
    public void setMaxHitpoints(int maxHitpoints) {
        this.maxHitpoints = maxHitpoints;
    }


    /**
     * @return the specialEnergy
     */
    public int getSpecialEnergy() {
        return specialEnergy;
    }


    /**
     * @param specialEnergy the specialEnergy to set
     */
    public void setSpecialEnergy(int specialEnergy) {
        this.specialEnergy = specialEnergy;
    }

}
