package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public final class WidgetOpenSubEvent implements Event {

    /**
     * The xtea key for the interface.
     */
    private final int[] key;
    private int rootWidgetId;
    private int childId;
    private int widgetId;
    private boolean clickable;

    public WidgetOpenSubEvent(int rootWidgetId, int childId, int widgetId, boolean clickable) {
        this(rootWidgetId, childId, widgetId, clickable, new int[4]);
    }

    public WidgetOpenSubEvent(int rootWidgetId, int childId, int widgetId,
                              boolean clickable, int[] keys) {
        this.rootWidgetId = rootWidgetId;
        this.childId = childId;
        this.widgetId = widgetId;
        this.clickable = clickable;
        this.key = keys;
    }

    public int getRootWidgetId() {
        return rootWidgetId;
    }

    public int getChildId() {
        return childId;
    }

    public int getWidgetId() {
        return widgetId;
    }

    public boolean isClickable() {
        return clickable;
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
}
