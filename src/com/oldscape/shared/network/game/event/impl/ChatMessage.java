package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public abstract class ChatMessage implements Event {
	
	/**
	 * The message.
	 */
	private final String message;

	/**
	 * The compressed message.
	 */
	private final byte[] compressedMessage;

	/**
	 * Creates a new chat message.
	 *
	 * @param message The message.
	 * @param compressedMessage The compressed message.
	 */
	public ChatMessage(String message, byte[] compressedMessage) {
		this.message = message;
		this.compressedMessage = compressedMessage.clone();
	}

	/**
	 * Gets the compressed message.
	 *
	 * @return The compressed message.
	 */
	public final byte[] getCompressedMessage() {
		return compressedMessage.clone();
	}

	/**
	 * Gets the message.
	 *
	 * @return The message.
	 */
	public final String getMessage() {
		return message;
	}
	
	

}
