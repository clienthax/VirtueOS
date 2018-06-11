package com.oldscape.shared.network.ondemand;

import com.oldscape.shared.event.Event;

/**
 * @author Graham
 */
public final class InitConnectionEvent implements Event {

    private final int val;

    public InitConnectionEvent(int val) {
        this.val = val;
    }

    public int getValue() {
        return val;
    }

}
