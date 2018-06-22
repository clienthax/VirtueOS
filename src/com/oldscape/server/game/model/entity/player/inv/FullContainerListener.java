package com.oldscape.server.game.model.entity.player.inv;

import com.oldscape.server.game.model.entity.player.Player;

/**
 * An {@link ContainerListener} which sends a message to a account when an
 * inventory has run out of space.
 *
 * @author Graham
 */
public final class FullContainerListener extends ContainerAdapter {

    /**
     * The message to send when the capacity has been exceeded.
     */
    // private final Message message;

    /**
     * The account.
     */
    @SuppressWarnings("unused")
    private final Player player;

    /**
     * Creates the empty inventory listener.
     *
     * @param player  The account.
     * @param message The message to send when the inventory is empty.
     */
    public FullContainerListener(Player player, String message) {
        this.player = player;
        // this.message = new ServerChatMessage(message);
    }

    @Override
    public void capacityExceeded(ItemContainer inventory) {
        // account.send(message);
    }

}