package com.oldscape.shared.network.game.event.impl;

import com.oldscape.server.game.GameWorld;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.shared.network.game.event.Message;

public abstract class MessageHandler<M extends Message> {

    /**
     * The World the Message occurred in.
     */
    protected final GameWorld world;

    /**
     * Creates the MessageListener.
     *
     * @param world The {@link World} the {@link Message} occurred in.
     */
    public MessageHandler(GameWorld world) {
        this.world = world;
    }

    /**
     * Handles the Message that was received.
     *
     * @param player  The player to handle the Message for.
     * @param message The Message.
     */
    public abstract void handle(Player player, M message);


}