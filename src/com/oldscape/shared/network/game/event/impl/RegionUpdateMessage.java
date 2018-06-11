package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.network.game.event.Message;

public abstract class RegionUpdateMessage extends Message implements Comparable<RegionUpdateMessage> {

    /**
     * The integer value indicating this RegionUpdateMessage is a high-priority message.
     */
    protected static final int HIGH_PRIORITY = 0;

    /**
     * The integer value indicating this RegionUpdateMessage is a low-priority message.
     */
    protected static final int LOW_PRIORITY = 1;

    @Override
    public final int compareTo(RegionUpdateMessage other) {
        return Integer.compare(priority(), other.priority());
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

    /**
     * Gets the priority of this RegionUpdateMessage, to use when sorting.
     *
     * @return The priority. Should be either 1 (low) or 0 (high).
     */
    public abstract int priority();

}