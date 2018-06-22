package com.oldscape.server.game.model.sync.block;

import com.oldscape.server.game.model.sync.reference.ChatMessage;
import com.oldscape.server.game.model.entity.player.account.Permission;

/**
 * The chat {@link SynchronizationBlock}. Only players can utilise this block.
 *
 * @author Graham
 */
public final class ChatBlock extends SynchronizationBlock {

    /**
     * The {@link ChatMessage}.
     */
    private final ChatMessage chatMessage;

    /**
     * The {@link Permission}.
     */
    private final Permission crownType;

    /**
     * Creates the chat block.
     *
     * @param crownType The {@link Permission} of the account who said the message.
     * @param chatMessage    The {@link ChatMessage}.
     */
    ChatBlock(Permission crownType, ChatMessage chatMessage) {
        this.crownType = crownType;
        this.chatMessage = chatMessage;
    }

    /**
     * Gets the compressed message.
     *
     * @return The compressed message.
     */
    public byte[] getCompressedMessage() {
        return chatMessage.getCompressedMessage();
    }

    /**
     * Gets the message.
     *
     * @return The message.
     */
    public String getMessage() {
        return chatMessage.getMessage();
    }

    /**
     * Gets the {@link Permission} of the account who said the message.
     *
     * @return The privilege level.
     */
    public Permission getCrownType() {
        return crownType;
    }

    /**
     * Gets the text color.
     *
     * @return The color.
     */
    public int getTextColor() {
        return chatMessage.getTextColor();
    }

    /**
     * Gets the text effects.
     *
     * @return The effects.
     */
    public int getTextEffects() {
        return chatMessage.getTextEffects();
    }

    /**
     * Gets if this message is a quick chat
     *
     * @return The autoChat
     */
    public boolean isAutoChat() {
        return chatMessage.isAutoChat();
    }

    @Override
    public BlockType getType() {
        return BlockType.CHAT;
    }

}