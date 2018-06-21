package com.oldscape.shared.model;

/**
 * Created by sean on 18/07/14.
 */
public enum Response {

    LOGIN_CONTINUE(0),

    LOGIN_OK(2),

    INVALID_PASSWORD(3),

    DISABLED_ACCOUNT(4),

    ACCOUNT_LOGGED_IN(5),

    SERVER_UPDATED(6),

    WORLD_FULL(7),

    LOGIN_SERVER_OFFLINE(8),

    TO_MANY_CONNECTIONS(9),

    BAD_SESSION_ID(10),

    LOGIN_SERVER_REJECTED(11),

    MEMBERS_WORLD(12),

    LOGIN_INCOMPLETE(13),

    SERVER_UPDATE(14),

    LOGIN_EXCEEDED(16),

    IN_MEMBERS_AREA(17),

    INVALID_LOGIN_SERVER_REQUEST(20),

    JUST_LEFT_WORLD(21),

    AUTHENTICATOR(56);

    /**
     * The id of the response.
     */
    private final int response;

    /**
     * Creates a new {@link com.oldscape.shared.model.Response}.
     *
     * @param response The response.
     */
    Response(int response) {
        this.response = response;
    }

    /**
     * Gets the response id.
     *
     * @return The {@code response}.
     */
    public int getResponse() {
        return response;
    }
}
