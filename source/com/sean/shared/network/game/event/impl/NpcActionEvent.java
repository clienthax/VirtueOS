package com.sean.shared.network.game.event.impl;

import com.sean.shared.event.Event;

public class NpcActionEvent implements Event {
	
	/**
	 * The option number.
	 */
	private final int option;

	/**
	 * The index of the clicked npc.
	 */
	private final int index;

	/**
	 * Creates an npc action message.
	 *
	 * @param option The option number.
	 * @param index The index of the npc.
	 */
	public NpcActionEvent(int option, int index) {
		this.option = option;
		this.index = index;
	}

	/**
	 * Gets the menu action number (i.e. the action message 'option') clicked.
	 *
	 * @return The option number.
	 */
	public int getOption() {
		return option;
	}

	/**
	 * Gets the index of the npc clicked.
	 *
	 * @return The npc index.
	 */
	public int getIndex() {
		return index;
	}
	
}
