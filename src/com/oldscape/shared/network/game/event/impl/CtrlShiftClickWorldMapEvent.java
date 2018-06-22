package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public class CtrlShiftClickWorldMapEvent implements Event {

    private int x;

    private int y;

    private int z;

    public CtrlShiftClickWorldMapEvent(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

}
