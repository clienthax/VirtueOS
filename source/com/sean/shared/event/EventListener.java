package com.sean.shared.event;

/**
 * Created by sean on 16/07/14.
 */
public interface EventListener<E extends Event, C extends EventContext> {

	/**
	 * Handles a specific type of {@link Event}
	 * 
	 * @param event
	 *            The {@link com.sean.shared.event.Event} to handle.
	 * @param context
	 *            The {@link com.sean.shared.event.EventContext} of the type of
	 *            {@link com.sean.shared.event.EventHub}.
	 */
	public void onEvent(E event, C context);
}
