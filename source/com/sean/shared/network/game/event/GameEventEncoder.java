package com.sean.shared.network.game.event;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

import com.sean.shared.event.Event;

/**
 * Created by sean on 09/08/14.
 */
public final class GameEventEncoder extends MessageToMessageEncoder<Event> {

	/**
	 * The {@link com.sean.shared.network.game.event.GameEventRepository}.
	 */
	private final GameEventRepository repository;

	/**
	 * Creates a new {@link GameEventEncoder}.
	 * 
	 * @param repository
	 *            The {@link com.sean.shared.network.game.event.GameEventRepository}.
	 */
	public GameEventEncoder(GameEventRepository repository) {
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void encode(ChannelHandlerContext ctx, Event msg, List<Object> out) throws Exception {
		GameMessageEncoder<Event> encoder = (GameMessageEncoder<Event>) repository.getMessageEncoder(msg.getClass());
		if (encoder != null) {
			out.add(encoder.encode(ctx.alloc(), msg));
		}
	}
}
