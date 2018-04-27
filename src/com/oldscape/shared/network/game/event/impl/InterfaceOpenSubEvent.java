package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public final class InterfaceOpenSubEvent implements Event {

	private int rootInterfaceId;
	private int childId;
	private int interfaceId;
	private boolean clickable;

	/**
	 * The xtea key for the interface.
	 */
	private final int[] key;

	public InterfaceOpenSubEvent(int rootInterfaceId, int childId, int interfaceId,
								 boolean clickable) {
		this(rootInterfaceId, childId, interfaceId, clickable, new int[4]);
	}

	public InterfaceOpenSubEvent(int rootInterfaceId, int childId, int interfaceId,
								 boolean clickable, int[] keys) {
		this.rootInterfaceId = rootInterfaceId;
		this.childId = childId;
		this.interfaceId = interfaceId;
		this.clickable = clickable;
		this.key = keys;
	}

	public int getRootInterfaceId() {
		return rootInterfaceId;
	}

	public int getChildId() {
		return childId;
	}

	public int getInterfaceId() {
		return interfaceId;
	}

	public boolean isClickable() {
		return clickable;
	}

	/**
	 * Gets a piece of the xtea key based on the index.
	 * 
	 * @param index
	 *            The index.
	 * @return Part of the xtea key based on the index.
	 */
	public int getKey(int index) {
		return key[index];
	}

	/**
	 * Gets the xtea key.
	 * 
	 * @return The {@code key}.
	 */
	public int[] getKey() {
		return key;
	}
}
