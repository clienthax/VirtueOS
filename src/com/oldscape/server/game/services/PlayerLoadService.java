package com.oldscape.server.game.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

import org.joda.time.DateTime;

import com.google.common.util.concurrent.AbstractService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.network.login.LoginSessionContext;
import com.oldscape.server.game.network.login.LoginTransaction;
import com.oldscape.server.game.network.login.PlayerLoginContextPair;
import com.oldscape.shared.gson.PlayerSerializer;
import com.oldscape.shared.model.Response;
import com.oldscape.shared.model.player.AccountCredentials;
import com.oldscape.shared.model.player.DisplayMode;
import com.oldscape.shared.model.player.Permission;
import com.oldscape.shared.model.player.SubscriptionType;
import com.oldscape.shared.network.login.LoginEvent;
import com.oldscape.shared.utility.FNVHash;
import com.oldscape.shared.utility.NameUtils;

/**
 * 
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 25, 2015
 */
public class PlayerLoadService extends AbstractService implements Runnable {

	/**
	 * THe {@link java.util.concurrent.ExecutorService} set with the amount of
	 * available processors the computer has.
	 */
	private final ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	/**
	 * A {@link java.util.concurrent.BlockingDeque} of pending
	 * {@link com.oldscape.server.game.network.login.LoginSessionContext}s.
	 */
	private final BlockingDeque<LoginTransaction> pendingTransactions = new LinkedBlockingDeque<>();

	/**
	 * The {@link java.util.concurrent.atomic.AtomicBoolean} for the running of the
	 * service.
	 */
	private final AtomicBoolean running = new AtomicBoolean(true);

	/**
	 * The {@link com.google.gson.Gson} for the JSON Parsing.
	 */
	private final Gson gson;

	public PlayerLoadService() {
		/**
		 * The {@link com.google.gson.GsonBuilder}.
		 */
		GsonBuilder builder = new GsonBuilder();

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
				LoginTransaction transaction = pendingTransactions.take();
				LoginEvent event = transaction.getEvent();
				LoginSessionContext context = transaction.getContext();

				String protocol = NameUtils.protocol(event.getUserName());

				Player player = null;

				File character = new File("./repository/characters/" + protocol + ".json");
				if (character.exists()) {

					/**
					 * Reads the properties file from the resource.
					 */
					try (BufferedReader reader = new BufferedReader(
							new InputStreamReader(new FileInputStream(character)))) {

						/**
						 * Creates a new {@link com.oldscape.server.rs3.game.ServerContext} from the
						 * properties file.
						 */
						player = gson.fromJson(reader, Player.class);

						/**
						 * Closes the reader
						 */
						reader.close();

						if (!player.getCredentials().getPassword().equals(FNVHash.fnv1a_64(event.getPassword()))) {
							context.sendLoginFailure(Response.INVALID_PASSWORD);
							player = null;
							continue;
						}

						if (context.getWorld().contains(player.getCredentials().getUserName())) {
							context.sendLoginFailure(Response.ACCOUNT_LOGGED_IN);
							player = null;
							continue;
						}

						if (context.getWorld().full()) {
							context.sendLoginFailure(Response.WORLD_FULL);
							player = null;
							continue;
						}

						/*
						 * if (player.getCredentials().isAurthenticated()) {
						 * context.sendLoginFailure(Response.AUTHENTICATOR); player = null; continue; }
						 */
					}
				} else {
					// Fake a new player for now.
					player = new Player(1, new AccountCredentials(
							/* Account creation date. */
							Date.from(Instant.now()),
							/* Last Logged in */
							Date.from(Instant.now()),
							/* Username */
							protocol,
							/* Display name */
							NameUtils.display(event.getUserName()),
							/* Email address */
							"test@log.in",
							/* Password */
							FNVHash.fnv1a_64(event.getPassword()),
							/* Unread Messages */
							0,
							/* Last IP Address */
							"127.0.0.1",
							/* Membership expiry date */
							new DateTime().plusDays(90).toDate(),
							/* Subscription type */
							SubscriptionType.SUBSCRIPTED_MEMBER,
							/* Permission */
							Permission.ADMINISTRATOR,
							/* Email Verified */
							true,
							/* Authenticator */
							false), DisplayMode.FIXED);
				}

				player.setEncodingRandom(event.getEncodingRandom());
				player.setDecodingRandom(event.getDecodingRandom());

				context.getWorld().getPlayersAwaitingLogin().add(new PlayerLoginContextPair(player, context));

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
	 * Adds a {@link com.oldscape.server.game.network.login.LoginSessionContext} to
	 * the {@code pendingContexts}.
	 * 
	 * @param transaction
	 *            The
	 *            {@link com.oldscape.server.game.network.login.LoginSessionContext}
	 *            to registerLobbyPlayer.
	 */
	public void addLoginTransaction(LoginTransaction transaction) {
		pendingTransactions.add(transaction);
	}

}
