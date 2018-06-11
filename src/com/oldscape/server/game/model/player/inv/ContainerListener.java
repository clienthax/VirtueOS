package com.oldscape.server.game.model.player.inv;

/**
 * An interface which listens to events from an {@link ItemContainer}.
 *
 * @author Graham
 */
public interface ContainerListener {

    /**
     * Called when the capacity of an inventory has been exceeded.
     *
     * @param inventory The inventory.
     */
    public void capacityExceeded(ItemContainer inventory);

    /**
     * Called when items have been updated in bulk.
     *
     * @param inventory The inventory.
     */
    public void itemsUpdated(ItemContainer inventory);

    /**
     * Called when an item has been updated.
     *
     * @param inventory The inventory.
     * @param slot      The slot.
     * @param item      The new item, or {@code null} if there is no new item.
     */
    public void itemUpdated(ItemContainer inventory, int slot, Item item);

}