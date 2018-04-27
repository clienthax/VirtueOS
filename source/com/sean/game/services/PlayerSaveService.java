package com.sean.game.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.common.util.concurrent.AbstractService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sean.game.model.player.Player;
import com.sean.shared.gson.PlayerSerializer;

/**
 * 
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 25, 2015
 */
public class PlayerSaveService extends AbstractService implements Runnable {

	/**
	 * THe {@link java.util.concurrent.ExecutorService} set with the amount of
	 * available processors the computer has.
	 */
	private final ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	/**
	 * A {@link java.util.concurrent.BlockingDeque} of pending
	 * {@link com.sean.game.model.player.Player}s.
	 */
	private final BlockingDeque<Player> pendingSaves = new LinkedBlockingDeque<>();

	/**
	 * The {@link java.util.concurrent.atomic.AtomicBoolean} for the running of
	 * the service.
	 */
	private final AtomicBoolean running = new AtomicBoolean(true);

	/**
	 * The {@link com.google.gson.Gson} for the JSON Parsing.
	 */
	private final Gson gson;

	public PlayerSaveService() {
		/**
		 * The {@link com.google.gson.GsonBuilder}.
		 */
		GsonBuilder builder = new GsonBuilder();

		/**
		 * Sets the builder into pretty printing mode for saving i.e indents,
		 * spaces, etc
		 */
		builder.setPrettyPrinting();

		/**
		 * Registers adapters for the parsing.
		 */
		builder.registerTypeAdapter(Player.class, new PlayerSerializer());

		/**
		 * Creates the {@link com.google.gson.Gson}.
		 */
		this.gson = builder.create();
	}

	@Override
	protected void doStart() {
		service.submit(this);
	}

	@Override
	public void run() {
		while (running.get()) {
			try {
				Player player = pendingSaves.take();
				try (BufferedWriter writer = new BufferedWriter(
						new FileWriter("./repository/characters/" + player.getCredentials().getUserName() + ".json"))) {
					writer.write(gson.toJson(player));
					writer.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	protected void doStop() {
		running.set(false);
		service.shutdownNow();
	}

	/**
	 * Adds a {@link com.sean.game.model.player.Player} to the
	 * {@code pendingContexts}.
	 * 
	 * @param player
	 *            The {@link com.sean.game.model.player.Player} to
	 *            registerLobbyPlayer.
	 */
	public void addPlayerSave(Player player) {
		pendingSaves.add(player);
	}

}
