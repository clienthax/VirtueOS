package com.oldscape.server.game.model.widget;

/**
 * Utility class used for defining options to be used on the click mask
 * of a {@link Widget}.
 *
 * @see Widget#getClickMask()
 */
public class WidgetConfig {

    /**
     * Enables displaying a ninth option on a menu.
     */
    public static final int SHOW_MENU_OPTION_NINE = 1 << 9;
    /**
     * Controls whether or not a widget can have another dragged onto it.
     */
    public static final int DRAG_ON = 1 << 17;
    /**
     * Controls whether or not a widget can be dragged around.
     */
    public static final int DRAG = 1 << 20;

}