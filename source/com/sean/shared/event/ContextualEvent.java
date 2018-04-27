package com.sean.shared.event;

/**
 * Created by sean on 16/07/14.
 */
public final class ContextualEvent {

	/**
	 * The {@link com.sean.shared.event.Event}.
	 */
	private final Event event;

	/**
	 * The {@link com.sean.shared.event.EventContext}.
	 */
	private final EventContext context;

	/**
	 * Creates a new {@link com.sean.shared.event.ContextualEvent}.
	 * 
	 * @param event
	 *            The {@link com.sean.shared.event.Event}.
	 * @param context
	 *            The {@link com.sean.shared.event.EventContext}.
	 */
	public ContextualEvent(Event event, EventContext context) {
		this.event = event;
		this.context = context;
	}

	/**
	 * Gets the {@link com.sean.shared.event.Event}.
	 * 
	 * @return The {@code event}.
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Gets the {@link com.sean.shared.event.EventContext}.
	 * 
	 * @return The {@code context}.
	 */
	public EventContext getContext() {
		return context;
	}
}
