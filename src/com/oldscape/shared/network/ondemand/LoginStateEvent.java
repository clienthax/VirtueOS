package com.oldscape.shared.network.ondemand;

import com.oldscape.shared.event.Event;

/**
 * 
 * @author Graham
 * 
 */
public final class LoginStateEvent implements Event {

	/**
	 * The priority of the file requested.
	 */
	private final boolean loggedIn;

	private int value;

	/**
	 * Creates a new FileRequest.
	 * 
	 * @param priority
	 *            The priority of the file.
	 * @param type
	 *            The type of file.
	 * @param file
	 *            The file id requested.
	 */
	public LoginStateEvent(boolean logged, int val) {
		this.loggedIn = logged;
		this.value = val;
	}

	/**
	 * Gets the file id.
	 * 
	 * @return The file.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Is the file a priority or not.
	 * 
	 * @return The priority.
	 */
	public boolean isLoggedInt() {
		return loggedIn;
	}
}
