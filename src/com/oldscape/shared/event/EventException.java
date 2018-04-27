package com.oldscape.shared.event;

/**
 * Created by sean on 16/07/14.
 */
public final class EventException extends Exception {

	/**
	 * The default generated serial version uid.
	 */
	private static final long serialVersionUID = 6338837951979827823L;

	/**
	 * Creates a new {@link com.oldscape.shared.event.EventException}.
	 *
	 * @param error
	 *            The error to display.
	 */
	public EventException(String error) {
		super(error);
	}
}
