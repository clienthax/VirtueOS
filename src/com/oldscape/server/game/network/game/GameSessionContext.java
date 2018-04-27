package com.oldscape.server.game.network.game;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.oldscape.server.game.Server;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.network.SessionEventContext;
import com.oldscape.shared.event.Event;

import io.netty.channel.Channel;

/**
 * Created by sean on 22/07/14.
 */
public final class GameSessionContext extends SessionEventContext {

	/**
	 * The limit of the amount of events that can be decoded per cycle.
	 */
	private static final int EVENTS_TO_HANDLE_LIMIT_PER_CYCLE = 15;

	/**
	 * The {@link com.oldscape.server.game.model.player.Player}.
	 */
	private final Player player;

	/**
	 * The {@link java.util.Queue} of pending
	 * {@link com.oldscape.shared.event.Event}s to decode.
	 */
	private final Queue<Event> pendingEventsToHandle = new ConcurrentLinkedQueue<>();

	/**
	 * @see com.oldscape.server.game.network.SessionEventContext#SessionEventContext(io.netty.channel.Channel,
	 *      com.oldscape.server.game.Server)
	 * @param player
	 *            The {@link com.oldscape.server.game.model.player.Player}.
	 */
	public GameSessionContext(Channel channel, Server server, Player player) {
		super(channel, server);
		this.player = player;
		player.setSessionContext(this);
	}

	/**
	 * Ticks every 600ms
	 */
	public void pulse() {

		int totalHandled = 0;
		Event eventToHandle;
		while ((totalHandled < EVENTS_TO_HANDLE_LIMIT_PER_CYCLE)
				&& (eventToHandle = pendingEventsToHandle.poll()) != null) {
			server.getGameEventHub().publish(eventToHandle, this);
			totalHandled++;
		}
	}

	/**
	 * Handles the disconnection of a
	 * {@link com.oldscape.server.game.model.player.Player}.
	 */
	public void onDisconnection() {
		player.setActive(false);
		server.getGameWorld().unregisterPlayer(player);
	}

	/**
	 * Adds a {@link com.oldscape.shared.event.Event} to the
	 * {@code pendingEventsToHandle}.
	 * 
	 * @param event
	 *            The {@link com.oldscape.shared.event.Event} to
	 *            registerLobbyPlayer.
	 */
	public void add(Event event) {
		this.pendingEventsToHandle.add(event);
	}

	/**
	 * Adds a {@link com.oldscape.shared.event.Event} to the {@link java.util.Queue}
	 * of {@link com.oldscape.shared.event.Event}s.
	 * 
	 * @param event
	 *            The {@link com.oldscape.shared.event.Event} to registerLobbyPlayer
	 *            to the {@code pendingEventsToWrite}.
	 */
	public void write(Event event) {
		channel.writeAndFlush(event);
	}

	/**
	 * Gets the {@link com.oldscape.server.game.model.player.Player}.
	 * 
	 * @return The{@code player}.
	 */
	public Player getPlayer() {
		return player;
	}
}
