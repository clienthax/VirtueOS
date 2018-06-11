/**
 * Copyright (c) 2015 Kyle Friz & Kayla Friz
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.shared.network.game.event.impl;

import com.oldscape.server.game.model.player.inv.Item;
import com.oldscape.shared.event.Event;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 27, 2015
 */
public class ItemsUpdateEvent implements Event {

    private final int interfaceID;
    private final int channelID;
    private final Item[] items;

    public ItemsUpdateEvent(int id, int channel, Item[] items) {
        this.interfaceID = id;
        this.channelID = channel;
        this.items = items;
    }

    public int getInterfaceID() {
        return interfaceID;
    }

    public int getChannelID() {
        return channelID;
    }

    public Item[] getItems() {
        return items;
    }
}
