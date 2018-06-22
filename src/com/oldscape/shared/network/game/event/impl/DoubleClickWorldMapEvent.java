package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public class DoubleClickWorldMapEvent implements Event {

    private int bitPack;

    public DoubleClickWorldMapEvent(int bitPack) {
        this.bitPack = bitPack;
    }

    private int getBitPack() {
        return bitPack;
    }

    public int getX() {
        return getBitPack() >> 14 & 0x3FFF;
    }

    public int getY() {
        return getBitPack() & 0x3FFF;
    }

    public int getZ() {
        return getBitPack() >> 28;
    }
}
