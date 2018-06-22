package com.oldscape.server.game.model.entity.player.account;

/**
 * Created by Sean on 13/08/2014.
 */
public enum Subscription {

    /**
     * A non member.
     */
    NON_MEMBER(0),

    /**
     * An unsubscribed member.
     */
    UNSUBSCRIPTED_MEMBER(0x1),

    /**
     * An subscripted member.
     */
    SUBSCRIPTED_MEMBER(0x2);

    /**
     * The subscription type.
     */
    private final int type;

    /**
     * Creates a new Subscription defined by an id.
     *
     * @param type The subscription type.
     */
    Subscription(int type) {
        this.type = type;
    }

    /**
     * Gets the subscription type.
     *
     * @return the type.
     */
    public int getType() {
        return type;
    }
}
