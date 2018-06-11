package com.oldscape.shared.event.hubs;

import com.oldscape.shared.event.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sean on 16/07/14.
 */
public final class DefaultEventHub<C extends EventContext> extends EventHub<C> {

    /**
     * The {@link java.util.Map} of event handlers.
     */
    private final Map<Class<?>, List<EventListener<?, ?>>> eventMap;

    /**
     * Creates a new DefaultEventHub.
     *
     * @param eventMap The type of {@link Map} for the event hub.
     */
    public DefaultEventHub(Map<Class<?>, List<EventListener<?, ?>>> eventMap) {
        this.eventMap = eventMap;
    }

    /**
     * Creates a new DefaultEventHub which uses a {@link java.util.HashMap} by
     * default.
     */
    public DefaultEventHub() {
        this(new HashMap<Class<?>, List<EventListener<?, ?>>>());
    }

    @Override
    public void subscribe(Class<? extends Event> clazz, EventListener<?, ?> listener) {
        List<EventListener<?, ?>> eventHandlerList = eventMap.get(clazz);
        if (eventHandlerList == null) {
            eventHandlerList = new LinkedList<>();
            eventMap.put(clazz, eventHandlerList);
        }
        eventHandlerList.add(listener);
    }

    @Override
    public <E extends Event> void unsubscribe(Class<E> clazz) throws EventException {
        if (eventMap.get(clazz.getClass()) == null)
            throw new EventException("Event " + clazz + " has no event listeners.");

        eventMap.remove(clazz);
    }

    @Override
    public int size() {
        return eventMap.size();
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <E extends Event> void publish(ContextualEvent contextualEvent) {

        Event event = contextualEvent.getEvent();
        List<EventListener<?, ?>> eventHandlers = eventMap.get(event.getClass());

        if (eventHandlers == null) {
            return;//TODO not a bloody issue!
            //throw new IllegalArgumentException("No event listeners bound to " + event.getClass());
        }

        eventHandlers.forEach((EventListener listener) -> {
            listener.onEvent(contextualEvent.getEvent(), contextualEvent.getContext());
        });

    }

    @Override
    public int size(Class<Event> clazz) {
        List<EventListener<?, ?>> eventHandlers = eventMap.get(clazz);
        if (eventHandlers == null)
            throw new IllegalArgumentException("Event " + clazz + " has no event listeners ");
        return eventHandlers.size();
    }
}
