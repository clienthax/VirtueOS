package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

/**
 * @author Sean
 */
public final class WidgetSetRootEvent implements Event {

    /**
     * The id of the root interface.
     */
    private final int widgetId;

    /**
     * The xtea key for the interface.
     */
    private final int[] key;

    /**
     * Can the interface can be clicked through.
     */
    private boolean clickThrough;

    /**
     * Creates a new
     * {@link WidgetSetRootEvent}.
     *
     * @param id  The id of the root interface.
     * @param key The xtea key.
     */
    public WidgetSetRootEvent(int id, int[] key, boolean clickThrough) {
        this.widgetId = id;
        this.key = key;
        this.clickThrough = clickThrough;
    }

    /**
     * Creates a new
     * {@link WidgetSetRootEvent} with
     * no xtea key.
     *
     * @param id           The root interface id.
     * @param clickThrough Can the interface be clicked through.
     */
    public WidgetSetRootEvent(int id, boolean clickThrough) {
        this(id, new int[4], clickThrough);
    }

    /**
     * Creates a new
     * {@link WidgetSetRootEvent} with
     * no xtea key and without the ability to be clicked through.
     *
     * @param id The root interface id.
     */
    public WidgetSetRootEvent(int id) {
        this(id, false);
    }

    /**
     * Gets the id of the interface.
     *
     * @return The {@code widgetId}.
     */
    public int getWidgetId() {
        return widgetId;
    }

    /**
     * Gets a piece of the xtea key based on the index.
     *
     * @param index The index.
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

    /**
     * Can the interface be clicked through.
     *
     * @return {@code clickThrough}.
     */
    public boolean canClickThrough() {
        return clickThrough;
    }
}
