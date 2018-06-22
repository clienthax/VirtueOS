package com.oldscape.shared.network.login;

import com.oldscape.server.game.model.entity.player.Player;
import com.oldscape.shared.event.Event;
import com.oldscape.server.game.network.login.Response;

/**
 * Created by sean on 23/07/14.
 */
public final class LoginResponseEvent implements Event {

    /**
     * The {@link {@link Response }.
     */
    private final Response response;

    private final Player player;

    /**
     * Creates a new {@link com.oldscape.shared.network.login.LoginResponseEvent}.
     *
     * @param response The type of {@link Response}.
     * @param payload  The payload of the response.
     */
    public LoginResponseEvent(Response response) {
        this(response, null);
    }

    /**
     * Creates a new {@link com.oldscape.shared.network.login.LoginResponseEvent}
     * with the {@link Response} set to use
     * {@link Response#LOGIN_OK}.
     *
     * @param payload The payload of the response.
     */
    public LoginResponseEvent(Player player) {
        this(Response.LOGIN_OK, player);
    }

    /**
     * Creates a new {@link com.oldscape.shared.network.login.LoginResponseEvent}
     * with the {@link Response} set to use
     * {@link Response#LOGIN_OK}.
     *
     * @param payload The payload of the response.
     */
    private LoginResponseEvent(Response response, Player player) {
        this.response = response;
        this.player = player;
    }

    /**
     * Gets the {@link Response}.
     *
     * @return The {@code response}.
     */
    public Response getResponse() {
        return response;
    }

    public Player getPlayer() {
        return player;
    }

}
