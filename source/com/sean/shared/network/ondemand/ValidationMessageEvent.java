package com.sean.shared.network.ondemand;

import com.sean.shared.event.Event;

/**
 * 
 * @author Graham
 * @author Sean
 * 
 */
public final class ValidationMessageEvent implements Event {

	/**
	 * The version of the client
	 */
	private final int version;

	/**
	 * Creates a new UpdateValidationMessage.
	 * 
	 * @param version
	 *            The version of the client.
	 */
	public ValidationMessageEvent(int version) {
		this.version = version;
	}

	/**
	 * Gets the version of the client.
	 * 
	 * @return The version.
	 */
	public int getVersion() {
		return version;
	}
}
