package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public class CameraRepositionEvent implements Event {

    public int x;

    public int y;

    public int z;

    public int pitch;

    public int yaw;

    public CameraRepositionEvent(int x, int y, int z, int pitch, int yaw) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
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

    public int getPitch() {
        return pitch;
    }

    public int getYaw() {
        return yaw;
    }
}
