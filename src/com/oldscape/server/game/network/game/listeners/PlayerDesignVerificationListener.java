package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.GameWorld;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.model.sync.reference.Appearance;
import com.oldscape.server.game.model.sync.reference.Appearance.Gender;
import com.oldscape.shared.network.game.event.impl.MessageHandler;
import com.oldscape.shared.network.game.event.impl.PlayerDesignEvent;

public final class PlayerDesignVerificationListener extends MessageHandler<PlayerDesignEvent> {

	/**
	 * Creates the PlayerDesignVerificationHandler.
	 *
	 * @param world
	 *            The {@link World} the {@link PlayerDesignMessage} occurred in.
	 */
	public PlayerDesignVerificationListener(GameWorld world) {
		super(world);
	}

	@Override
	public void handle(Player player, PlayerDesignEvent message) {
		if (!valid(message.getAppearance())) {
			message.terminate();
		}
	}

	/**
	 * Checks if an appearance combination is valid.
	 *
	 * @param appearance
	 *            The appearance combination.
	 * @return {@code true} if so, {@code false} if not.
	 */
	private boolean valid(Appearance appearance) {
		int[] colors = appearance.getColors();
		int[] maxColors = new int[] { 11, 15, 15, 5, 7 };

		for (int i = 0; i < colors.length; i++) {
			if (colors[i] < 0 || colors[i] > maxColors[i]) {
				return false;
			}
		}

		switch (appearance.getGender()) {
		case FEMALE:
			return validFemaleStyle(appearance);
		case MALE:
			return validMaleStyle(appearance);
		}

		throw new IllegalArgumentException("Player can only be either male or female.");
	}

	/**
	 * Checks if a {@link Gender#FEMALE} style combination is valid.
	 *
	 * @param appearance
	 *            The appearance combination.
	 * @return {@code true} if so, {@code false} if not.
	 */
	private boolean validFemaleStyle(Appearance appearance) {
		int[] styles = appearance.getStyle();
		int[] minStyles = new int[] { 45, 255, 56, 61, 67, 70, 79 };
		int[] maxStyles = new int[] { 54, 255, 60, 65, 68, 77, 80 };

		for (int i = 0; i < styles.length; i++) {
			if (styles[i] < minStyles[i] || styles[i] > maxStyles[i]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Checks if a {@link Gender#MALE} style combination is valid.
	 *
	 * @param appearance
	 *            The appearance combination.
	 * @return {@code true} if so, {@code false} if not.
	 */
	private boolean validMaleStyle(Appearance appearance) {
		int[] styles = appearance.getStyle();
		int[] minStyles = new int[] { 0, 10, 18, 26, 33, 36, 42 };
		int[] maxStyles = new int[] { 8, 17, 25, 31, 34, 40, 43 };

		for (int i = 0; i < styles.length; i++) {
			if (styles[i] < minStyles[i] || styles[i] > maxStyles[i]) {
				return false;
			}
		}

		return true;
	}

}
