package com.oldscape.shared.network.ondemand;

import com.oldscape.shared.event.Event;

/**
 * @author Sean
 */
public class UpdateEncryptionMessageEvent implements Event {

    /**
     * The key
     */
    private final int key;

    /**
     * Creates a new UpdateEncryptionMessage.
     *
     * @param key The key.
     */
    public UpdateEncryptionMessageEvent(int key) {
        this.key = key;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public int getKey() {
        return key;
    }
}
