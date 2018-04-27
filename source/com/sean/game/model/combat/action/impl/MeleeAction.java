package com.sean.game.model.combat.action.impl;

import com.sean.game.model.MobileEntity;
import com.sean.game.model.combat.action.CombatAction;

/**
 * MeleeAction Class
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 11, 2015
 */
public class MeleeAction extends CombatAction {

	@Override
	public void attack(MobileEntity attacker, MobileEntity defender,
			boolean successful) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defend(MobileEntity defender, MobileEntity attacker,
			boolean successful) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSuccessful(MobileEntity attacker, MobileEntity defender) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
