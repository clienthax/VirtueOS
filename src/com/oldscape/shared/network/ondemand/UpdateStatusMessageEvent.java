package com.oldscape.shared.network.ondemand;

import com.oldscape.shared.event.Event;

/**
 * 
 * @author Graham
 * 
 */
public final class UpdateStatusMessageEvent implements Event {

	public static final int STATUS_OK = 0;
	public static final int STATUS_OUT_OF_DATE = 6;
	public static final int STATUS_SERVER_FULL = 7;

	private final int status;

	public UpdateStatusMessageEvent(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
