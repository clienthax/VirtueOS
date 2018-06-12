package com.oldscape.server.game.model.widget;

import java.util.Collection;

/**
 * Represents an on-screen UI element that is drawn on the canvas.
 * For a more complete idea of what is classified as a widget, see {@link WidgetId}.
 */
public interface Widget {

    /**
     * Gets the widgets ID.
     *
     * @return the widget ID
     * @see WidgetId
     */
    int getId();

    /**
     * Gets the type of the widget.
     *
     * @return the widget type
     */
    int getType();

    /**
     * Sets the type of the widget.
     *
     * @param type the new widget type
     */
    void setType(int type);

    /**
     * Gets the type of content displayed by the widget.
     *
     * @return the content type
     */
    int getContentType();

    /**
     * Sets the type of content displayed by the widget.
     *
     * @param contentType the new content type
     */
    void setContentType(int contentType);

    /**
     * Gets the current click configuration of the widget.
     *
     * @return the click configuration
     */
    int getClickMask();

    /**
     * Sets the click configuration of the widget.
     *
     * @param mask the new configuration
     */
    void setClickMask(int mask);

    /**
     * Gets the parent widget, if this widget is a child.
     *
     * @return the parent widget, or null
     */
    Widget getParent();

    /**
     * Gets the ID of the parent widget.
     *
     * @return the parent ID, or -1 if this widget is not a child
     */
    int getParentId();

    /**
     * Safely gets a child widget at a specific index from {@link #getChildren}.
     *
     * @param index the raw index into the array
     * @return child widget, or null if the index does not exist
     */
    Widget getChild(int index);

    /**
     * Gets all children of this widget.
     *
     * @return the widgets children
     */
    Widget[] getChildren();

    /**
     * Gets all dynamic children.
     *
     * @return the dynamic children
     */
    Widget[] getDynamicChildren();

    /**
     * Gets all static children.
     *
     * @return the static children
     */
    Widget[] getStaticChildren();

    /**
     * Gets all nested children.
     *
     * @return the nested children
     */
    Widget[] getNestedChildren();

    /**
     * Gets the text displayed on this widget.
     *
     * @return the displayed text
     */
    String getText();

    /**
     * Sets the text displayed on this widget.
     *
     * @param text the text to display
     */
    void setText(String text);

    /**
     * Gets the name of the widget.
     * <p>
     * The name of the widget is used in the tooltip when an action is
     * available. For example, the widget that activates quick prayers
     * has the name "Quick-prayers" so when hovering there is a tooltip
     * that says "Activate Quick-prayers".
     *
     * @return the name
     */
    String getName();

    /**
     * Sets the name of the widget.
     *
     * @param name the new name
     */
    void setName(String name);

    /**
     * Gets the model ID displayed in the widget.
     *
     * @return the model ID
     */
    int getModelId();

    /**
     * Checks whether this widget or any of its parents are hidden.
     *
     * @return true if this widget or any parent is hidden, false otherwise
     */
    boolean isHidden();

    /**
     * Sets the hidden state of this widget.
     *
     * @param hidden new hidden state
     */
    void setHidden(boolean hidden);

    /**
     * Checks whether this widget is hidden, not taking into account
     * any parent hidden states.
     *
     * @return true if this widget is hidden, false otherwise
     */
    boolean isSelfHidden();

    /**
     * Gets any items that are being displayed in the widget.
     *
     * @return any items displayed, or null if there are no items
     */
    Collection<WidgetItem> getWidgetItems();

    /**
     * Gets a widget item at a specific index.
     *
     * @param index index of the item
     * @return the widget item at index, or null if an item at index
     * does not exist
     */
    WidgetItem getWidgetItem(int index);

    /**
     * Gets the item ID displayed by the widget.
     *
     * @return the item ID
     */
    int getItemId();

    /**
     * Gets the quantity of the item displayed by the widget.
     *
     * @return the item quantity
     */
    int getItemQuantity();

    /**
     * Gets the actions available on the widget.
     *
     * @return the actions
     */
    String[] getActions();
}