package com.oldscape.server.game.network.login;

import com.oldscape.server.game.model.player.Player;

/**
 * Created by sean on 17/07/14.
 */
public class PlayerLoginContextPair {

	/**
	 * The {@link com.oldscape.server.game.model.player.Player} of the succesfull login.
	 */
	private final Player player;

	/**
	 * The {@link com.oldscape.server.game.network.login.LoginSessionContext}.
	 */
	private final LoginSessionContext context;

	/**
	 * Creates a new {@link com.oldscape.server.game.network.login.PlayerLoginContextPair}
	 * 
	 * @param composition
	 *            The {@link com.oldscape.server.game.model.player.Player}.
	 * @param context
	 *            The {@link com.oldscape.server.game.network.login.LoginSessionContext}.
	 */
	public PlayerLoginContextPair(Player composition, LoginSessionContext context) {
		this.player = composition;
		this.context = context;
	}

	/**
	 * Gets the {@link com.oldscape.server.game.network.login.LoginSessionContext}.
	 * 
	 * @return The {@code context}.
	 */
	public LoginSessionContext getContext() {
		return context;
	}

	/**
	 * Gets the {@link com.oldscape.server.game.model.player.Player}.
	 * 
	 * @return The {@code player}.
	 */
	public Player getPlayer() {
		return player;
	}
}
