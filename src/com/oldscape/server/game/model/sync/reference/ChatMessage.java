package com.oldscape.server.game.model.sync.reference;

/**
 * A {@link ChatMessage} sent by the client to send a public chat message to other
 * players.
 *
 * @author Graham
 */
public final class ChatMessage {

    /**
     * The text color.
     */
    private final int color;

    /**
     * The compressed message.
     */
    private final byte[] compressedMessage;

    /**
     * The text effects.
     */
    private final int effects;

    /**
     * The message.
     */
    private final String message;

    /**
     * If this is a quick chat message
     */
    private final boolean autoChat;

    /**
     * Creates a new chat message.
     *
     * @param message           The message.
     * @param compressedMessage The compressed message.
     * @param color             The text color.
     * @param effects           The text effects.
     * @param autoChat                If this is a quick chat message.
     */
    public ChatMessage(String message, byte[] compressedMessage, int color, int effects, boolean autoChat) {
        this.message = message;
        this.compressedMessage = compressedMessage;
        this.color = color;
        this.effects = effects;
        this.autoChat = autoChat;
    }

    /**
     * Gets the compressed message.
     *
     * @return The compressed message.
     */
    public byte[] getCompressedMessage() {
        return compressedMessage;
    }

    /**
     * Gets the message.
     *
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the text color.
     *
     * @return The color.
     */
    public int getTextColor() {
        return color;
    }

    /**
     * Gets the text effects.
     *
     * @return The effects.
     */
    public int getTextEffects() {
        return effects;
    }

    /**
     * Gets if this message is a auto chat.
     *
     * @return the autoChat
     */
    public boolean isAutoChat() {
        return autoChat;
    }

}