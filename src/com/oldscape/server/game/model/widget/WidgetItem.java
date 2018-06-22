package com.oldscape.server.game.model.widget;

import com.oldscape.server.game.model.entity.item.ItemId;

/**
 * An item that is being represented in a {@link Widget}.
 */
public class WidgetItem {

    private final int id;

    private final int quantity;

    private final int index;

    public WidgetItem(int id, int quantity, int index) {
        this.id = id;
        this.quantity = quantity;
        this.index = index;
    }

    /**
     * Gets the ID of the item represented.
     *
     * @return the items ID
     * @see ItemId
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the quantity of the represented item.
     *
     * @return the items quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the index position of this WidgetItem inside its parents
     * WidgetItem array.
     *
     * @return the index in the parent widget
     * @see Widget#getWidgetItems()
     */
    public int getIndex() {
        return index;
    }


}
