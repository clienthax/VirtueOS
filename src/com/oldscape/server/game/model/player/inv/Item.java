package com.oldscape.server.game.model.player.inv;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.oldscape.shared.cache.type.TypeListManager;
import com.oldscape.shared.cache.type.items.ItemType;

/**
 * Represents a single item.
 *
 * @author Graham
 */
public final class Item {

    /**
     * The amount of items in the stack.
     */
    private final int amount;

    /**
     * The item definition.
     */
    private final ItemType itemType;

    /**
     * The item's id.
     */
    private final int id;

    /**
     * Creates an item with an amount of {@code 1}.
     *
     * @param id The item's id.
     */
    public Item(int id) {
        this(id, 1);
    }

    /**
     * Creates an item with the specified the amount.
     *
     * @param id     The item's id.
     * @param amount The amount.
     * @throws IllegalArgumentException If the amount is negative.
     */
    public Item(int id, int amount) {
        Preconditions.checkArgument(amount >= 0, "Amount cannot be negative.");
        this.id = id;
        this.amount = amount;
        this.itemType = TypeListManager.lookupItem(id);
    }

    /**
     * Gets the amount.
     *
     * @return The amount.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Gets the {@link ItemDefinition} that describes this item.
     *
     * @return The definition.
     */
    public ItemType getItemType() {
        return itemType;
    }

    /**
     * Gets the id.
     *
     * @return The id.
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id)
                .add("amount", amount).toString();
    }

}