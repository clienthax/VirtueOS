package com.oldscape.shared.event;

/**
 * Created by sean on 16/07/14.
 */
public abstract class EventHub<C extends EventContext> {

	/**
	 * Executes a type of {@link com.oldscape.shared.event.ContextualEvent}.
	 *
	 * @param event
	 *            The {@link com.oldscape.shared.event.ContextualEvent} to handle.
	 */
	public abstract <E extends Event> void publish(ContextualEvent event);

	/**
	 * Executes a type of {@link com.oldscape.shared.event.Event}.
	 *
	 * @param event
	 *            The {@link com.oldscape.shared.event.Event} to handle.
	 * @param context
	 *            The type of {@link com.oldscape.shared.event.EventContext}.
	 */
	public <E extends Event> void publish(E event, C context) {
		publish(new ContextualEvent(event, context));
	}

	/**
	 * Subscribes a type of {@link com.oldscape.shared.event.Event} with its
	 * {@link com.oldscape.shared.event.EventListener} to the {@link EventHub}.
	 * 
	 * @param clazz
	 *            The {@link com.oldscape.shared.event.Event} to subscribe a
	 *            {@link com.oldscape.shared.event.EventListener} to.
	 * @param listener
	 *            The {@link com.oldscape.shared.event.EventListener} to add.
	 */
	public abstract void subscribe(Class<? extends Event> clazz, EventListener<?, ?> listener);

	/**
	 * Removes a {@link Event} from the {@link EventHub}.
	 *
	 * @param clazz
	 *            The {@link com.oldscape.shared.event.Event}
	 *            {@link java.lang.Class}.
	 * @param <E>
	 *            The {@link com.oldscape.shared.event.Event} type.
	 * @throws EventException
	 *             The exception thrown if ane error occurs removing an
	 *             {@link com.oldscape.shared.event.Event}.
	 */
	public abstract <E extends Event> void unsubscribe(Class<E> clazz) throws EventException;

	/**
	 * Returns the number of {@link com.oldscape.shared.event.Event}s in the
	 * {@link com.oldscape.shared.event.EventHub}.
	 * 
	 * @return The amount of {@link com.oldscape.shared.event.Event}s in the
	 *         {@link com.oldscape.shared.event.EventHub}.
	 */
	public abstract int size();

	/**
	 * Returns the number of {@link com.oldscape.shared.event.EventListener}s
	 * associated to a type of {@link com.oldscape.shared.event.Event}.
	 *
	 * @return The amount of {@link com.oldscape.shared.event.EventListener}s
	 *         associated with a {@link com.oldscape.shared.event.EventHub}.
	 */
	public abstract int size(Class<Event> clazz);

}
