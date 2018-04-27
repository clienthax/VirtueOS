package com.oldscape.server.game.model.sync.block;

import com.oldscape.server.game.model.sync.reference.ChatMessage;
import com.oldscape.shared.model.player.Permission;

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
	 * The {@link PrivilegeLevel}.
	 */
	private final Permission privilegeLevel;
	
	/**
	 * Creates the chat block.
	 * 
	 * @param privilegeLevel
	 *            The {@link PrivilegeLevel} of the player who said the message.
	 * @param chatMessage
	 *            The {@link ChatMessage}.
	 */
	ChatBlock(Permission privilegeLevel, ChatMessage chatMessage) {
		this.privilegeLevel = privilegeLevel;
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
	 * Gets the {@link PrivilegeLevel} of the player who said the message.
	 * 
	 * @return The privilege level.
	 */
	public Permission getPrivilegeLevel() {
		return privilegeLevel;
	}

	/**
	 * Gets the text color.
	 * 
	 * @return The text color.
	 */
	public int getTextColor() {
		return chatMessage.getTextColor();
	}

	/**
	 * Gets the text effects.
	 * 
	 * @return The text effects.
	 */
	public int getTextEffects() {
		return chatMessage.getTextEffects();
	}
	
	/**
	 * Gets if this message is a quick chat
	 * 
	 * @return The {@link quickChat}
	 */
	public boolean isQuickChat() {
		return chatMessage.isQuickChat();
	}
	
	/* (non-Javadoc)
	 * @see com.oldscape.server.game.model.sync.block.SynchronizationBlock#getType()
	 */
	@Override
	public BlockType getType() {
		return BlockType.CHAT;
	}

}