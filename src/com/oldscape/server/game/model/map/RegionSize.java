package com.oldscape.server.game.model.map;

public enum RegionSize {

    DEFAULT(104),

    LARGE(120),

    XLARGE(136),

    XXLARGE(168);

    private final int size;

    RegionSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}