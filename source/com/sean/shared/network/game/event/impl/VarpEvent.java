package com.sean.shared.network.game.event.impl;

import com.sean.shared.event.Event;

/**
 * Created by Sean on 11/08/2014.
 */
public final class VarpEvent implements Event {

	private final int id;
	private final int state;
	private final boolean bit;

	public VarpEvent(int id, int state) {
		this(id, state, false);
	}

	public VarpEvent(int id, int state, boolean bit) {
		this.state = state;
		this.id = id;
		this.bit = bit;
	}

	public int getId() {
		return id;
	}

	public int getState() {
		return state;
	}

	public boolean isBit() {
		return bit;
	}
}
