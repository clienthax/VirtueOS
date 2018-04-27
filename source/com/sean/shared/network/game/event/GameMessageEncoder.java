package com.sean.shared.network.game.event;

import io.netty.buffer.ByteBufAllocator;

import com.sean.shared.event.Event;
import com.sean.shared.network.game.GameFrame;

/**
 * Created by sean on 09/08/14.
 */
public interface GameMessageEncoder<E extends Event> {

	/**
	 * Encodes a type of {@link com.sean.shared.event.Event} into a
	 * {@link com.sean.shared.network.game.GameFrame}.
	 * 
	 * @param alloc
	 *            The {@link io.netty.buffer.ByteBufAllocator}.
	 * @param event
	 *            The type of {@link com.sean.shared.event.Event} to encode.
	 * @return The encoded {@link com.sean.shared.event.Event} as a
	 *         {@link com.sean.shared.network.game.GameFrame}.
	 */
	public GameFrame encode(ByteBufAllocator alloc, E event);

}
