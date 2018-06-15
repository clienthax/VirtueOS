package com.oldscape.shared.network.game.event.impl;

import java.util.OptionalInt;

public class MagicOnItemMessage extends WidgetItemMessage {

    /**
     * The spell id.
     */
    private final int spell;

    /**
     * Creates a new magic on item message.
     *
     * @param widgetId The interface id.
     * @param id       The item id.
     * @param slot     The item slot.
     * @param spell    The spell id.
     */
    public MagicOnItemMessage(int widgetId, int id, int slot, int spell) {
        super(OptionalInt.empty(), widgetId, id, slot);
        this.spell = spell;
    }

    /**
     * Gets the spell id.
     *
     * @return The spell id.
     */
    public int getSpellId() {
        return spell;
    }

}