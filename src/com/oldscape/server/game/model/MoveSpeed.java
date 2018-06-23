package com.oldscape.server.game.model;

public enum MoveSpeed {

    STATIONARY(0, (byte) -1),

    WALK(1, (byte) 0),

    RUN(2, (byte) 1),

    INSTANT(3, (byte) 2);

    private byte id;

    MoveSpeed(int i, byte id) {
        this.id = id;
    }

    public byte getId () {
        return id;
    }

    public static MoveSpeed getById (int id) {
        for (MoveSpeed s : values()) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }
}