package com.oldscape.server.game.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Message Types, credit to Team RuneLite.
 */
public enum MessageType {

    /**
     * A message received from the server.
     */
    SERVER(0),
    /**
     * A message in the public chat from a moderator
     */
    PUBLIC_MOD(1),
    /**
     * A message in the public chat.
     */
    PUBLIC(2),
    /**
     * A private message from another account.
     */
    PRIVATE_MESSAGE_RECEIVED(3),
    /**
     * A trade request received.
     */
    TRADE_RECEIVED(4),
    /**
     * A message received when a friend logs in or out.
     */
    PRIVATE_MESSAGE_INFO(5),
    /**
     * A private message sent to another account.
     */
    PRIVATE_MESSAGE_SENT(6),
    /**
     * A private message received from a moderator.
     */
    PRIVATE_MESSAGE_RECEIVED_MOD(7),
    /**
     * A message received in clan chat.
     */
    CLANCHAT(9),
    /**
     * A message received with information about the current clan chat.
     */
    CLANCHAT_INFO(11),
    /**
     * A trade request being sent.
     */
    TRADE_SENT(12),
    /**
     * An abuse report submitted.
     */
    ABUSE_REPORT(26),
    /**
     * Examine item description.
     */
    EXAMINE_ITEM(27),
    /**
     * Examine NPC description.
     */
    EXAMINE_NPC(28),
    /**
     * Examine object description.
     */
    EXAMINE_OBJECT(29),
    /**
     * Adding account to friend list.
     */
    FRIENDS_LIST_ADD(30),
    /**
     * Adding account to ignore list.
     */
    IGNORE_LIST_ADD(31),
    /**
     * An autochat message from a account.
     */
    AUTOCHAT(90),
    /**
     * A game message (ie. when a setting is changed).
     */
    GAME(99),
    /**
     * A message received when somebody sends a trade offer.
     */
    TRADE(101),
    /**
     * A message received when somebody sends a duel offer.
     */
    DUEL(103),
    /**
     * A message that was filtered.
     */
    FILTERED(105),
    /**
     * A message about an action.
     */
    ACTION(109),
    /**
     * An unknown message type.
     */
    UNKNOWN(-1);

    private final int type;

    private static final Map<Integer, MessageType> MESSAGE_TYPES = new HashMap<>();

    MessageType(int type) {
        this.type = type;
    }

    static {
        for (MessageType messageType : values()) {
            MESSAGE_TYPES.put(messageType.type, messageType);
        }
    }

    public static MessageType of(int type) {
        return MESSAGE_TYPES.getOrDefault(type, UNKNOWN);
    }

    public int getType() {
        return type;
    }

}
