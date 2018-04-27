package com.sean.shared.network;

import io.netty.handler.codec.UnsupportedMessageTypeException;

import com.sean.shared.event.Event;

/**
 * Created by sean on 22/07/14.
 */
public final class HandshakeEvent implements Event {

	/**
	 * The {@link com.sean.shared.network.HandshakeEvent.HandshakeState}.
	 */
	private final HandshakeState state;

	/**
	 * Creates a new {@link com.sean.shared.network.HandshakeEvent}.
	 * 
	 * @param state
	 *            The {@link com.sean.shared.network.HandshakeEvent.HandshakeState}.
	 */
	public HandshakeEvent(HandshakeState state) {
		this.state = state;
	}

	/**
	 * Gets the {@link com.sean.shared.network.HandshakeEvent.HandshakeState}.
	 * 
	 * @return The {@code value}.
	 */
	public HandshakeState getState() {
		return state;
	}

	/**
	 * Created by sean on 22/07/14.
	 */
	public static enum HandshakeState {

		/**
		 * The login value.
		 */
		LOGIN,

		/**
		 * The ondemand value.
		 */
		ON_DEMAND;

		/**
		 * The id of the login handshake.
		 */
		private static final int LOGIN_ID = 14;

		/**
		 * The id of the on demand handshake.
		 */
		private static final int ONDEMAND_ID = 15;

		/**
		 * Gets the
		 * {@link com.sean.shared.network.HandshakeEvent.HandshakeState} based
		 * on the id.
		 * 
		 * @param id
		 *            The id of the handshake.
		 * @return The
		 *         {@link com.sean.shared.network.HandshakeEvent.HandshakeState}
		 *         based on the id.
		 */
		public static HandshakeState getState(int id) {
			switch (id) {
			case LOGIN_ID:
				return LOGIN;

			case ONDEMAND_ID:
				return ON_DEMAND;

			default:
				throw new UnsupportedMessageTypeException("No handshake by id: " + id);
			}
		}

	}

}
