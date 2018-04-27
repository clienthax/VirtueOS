package com.oldscape.server.game.network;

import com.oldscape.server.game.GameWorld;
import com.oldscape.server.game.Server;
import com.oldscape.shared.event.EventContext;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

/**
 * Created by sean on 17/07/14.
 */
public class SessionEventContext implements EventContext {

	/**
	 * The {@link io.netty.channel.Channel} reference.
	 */
	protected final Channel channel;

	/**
	 * The {@link com.oldscape.server.game.GameWorld} reference.
	 */
	protected final GameWorld world;

	/**
	 * The {@link com.oldscape.server.game.Server} reference.
	 */
	protected final Server server;

	/**
	 * Creates a new {@link com.oldscape.server.game.network.SessionEventContext}.
	 * 
	 * @param channel
	 *            The {@link io.netty.channel.Channel}.
	 * @param server
	 *            The {@link com.oldscape.server.game.Server}.
	 */
	public SessionEventContext(Channel channel, Server server) {
		this.channel = channel;
		this.world = server.getGameWorld();
		this.server = server;
	}

	/**
	 * Writes a {@link java.lang.Object} which improves performance because the
	 * void promise is allocated statically (one per channel) so it doesn't need
	 * to allocate a new promise.
	 * 
	 * @param obj
	 *            The {@link java.lang.Object} to write.
	 */
	public void writeWithoutFuture(Object obj) {
		channel.writeAndFlush(obj, channel.voidPromise());
	}

	/**
	 * Writes an {@link java.lang.Object} to an encoder.
	 * 
	 * @param obj
	 *            The {@link java.lang.Object} to write.
	 */
	public ChannelFuture write(Object obj) {
		return channel.writeAndFlush(obj);
	}

	/**
	 * Gets the {@link io.netty.channel.Channel}.
	 * 
	 * @return The {@code channel}.
	 */
	public Channel getChannel() {
		return channel;
	}

	/**
	 * Gets the {@link io.netty.buffer.ByteBufAllocator}.
	 * 
	 * @return The {@code alloc}.
	 */
	public ByteBufAllocator getAlloc() {
		return channel.alloc();
	}

	/**
	 * Gets the {@link com.oldscape.server.game.GameWorld}.
	 * 
	 * @return The {@code world}.
	 */
	public GameWorld getWorld() {
		return world;
	}

	/**
	 * Gets the {@link com.oldscape.server.game.Server}.
	 * 
	 * @return The {@code server}.
	 */
	public Server getServer() {
		return server;
	}
}
