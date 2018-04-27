package com.oldscape.server.game.model.combat.action;

import com.oldscape.server.game.model.MobileEntity;

/**
 * CombatAction Class
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 11, 2015
 */
public abstract class CombatAction {
	
	/**
	 * This method is called before {@link #defend(Entity, Entity)} for attacking
	 * the specified {@code defender} with the specified {@code attacker}.
	 * 
	 * @param attacker the attacking entity
	 * @param defender the defending entity
	 * @param successful 
	 */
	public abstract void attack(MobileEntity attacker, MobileEntity defender, boolean successful);
	
	/**
	 * This method is called after {@link #attack(Entity, Entity)} and the combat ticks
	 * pass the delay from {@link #getHitDelay(boolean)}.
	 * 
	 * @param defender the defending entity
	 * @param attacker the attacking entity
	 * @param successful false is the defender blocked the hit; false otherwise
	 */
	public abstract void defend(MobileEntity defender, MobileEntity attacker, boolean successful);
	
	/**
	 * Returns true if the next hit is going to be successful between the specified
	 * {@code attacker} and the specified {@code defender}.
	 * 
	 * @param attacker the attacking entity
	 * @param defender the defending entity
	 * @return true if the net hit is successful; return false otherwise
	 */
	public abstract boolean isSuccessful(MobileEntity attacker, MobileEntity defender);
	
	/**
	 * Returns the max distance of this {@code CombatAction}.
	 * 
	 * @return the max distance
	 */
	public abstract int getDistance();

}
