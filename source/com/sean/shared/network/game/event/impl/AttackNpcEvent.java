package com.sean.shared.network.game.event.impl;

import com.sean.shared.event.Event;

public class AttackNpcEvent implements Event {
	
	private boolean bool;
	private int npcIndex;

	public AttackNpcEvent(boolean bool, int npcIndex) {
		this.bool = bool;
		this.npcIndex = npcIndex;
	}

	public boolean isBool() {
		return bool;
	}

	public int getNpcIndex() {
		return npcIndex;
	}

}
