package com.oldscape.server.game.model.region.clip;

public final class CollisionDataFlag {

    public static final int BLOCK_MOVEMENT_NORTH_WEST = 0x1;

    public static final int BLOCK_MOVEMENT_NORTH = 0x2;

    public static final int BLOCK_MOVEMENT_NORTH_EAST = 0x4;

    public static final int BLOCK_MOVEMENT_EAST = 0x8;

    public static final int BLOCK_MOVEMENT_SOUTH_EAST = 0x10;

    public static final int BLOCK_MOVEMENT_SOUTH = 0x20;

    public static final int BLOCK_MOVEMENT_SOUTH_WEST = 0x40;

    public static final int BLOCK_MOVEMENT_WEST = 0x80;

    public static final int BLOCK_MOVEMENT_OBJECT = 0x100;

    public static final int BLOCK_MOVEMENT_FLOOR_DECORATION = 0x40000;

    public static final int BLOCK_MOVEMENT_FLOOR = 0x200000;

    public static final int BLOCK_LINE_OF_SIGHT_NORTH_WEST = BLOCK_MOVEMENT_NORTH_WEST << 9;

    public static final int BLOCK_LINE_OF_SIGHT_NORTH = BLOCK_MOVEMENT_NORTH << 9;

    public static final int BLOCK_LINE_OF_SIGHT_NORTH_EAST = BLOCK_MOVEMENT_NORTH_EAST << 9;

    public static final int BLOCK_LINE_OF_SIGHT_EAST = BLOCK_MOVEMENT_EAST << 9;

    public static final int BLOCK_LINE_OF_SIGHT_SOUTH_EAST = BLOCK_MOVEMENT_SOUTH_EAST <<9;

    public static final int BLOCK_LINE_OF_SIGHT_SOUTH = BLOCK_MOVEMENT_SOUTH << 9;

    public static final int BLOCK_LINE_OF_SIGHT_SOUTH_WEST = BLOCK_MOVEMENT_SOUTH_WEST << 9;

    public static final int BLOCK_LINE_OF_SIGHT_WEST = BLOCK_MOVEMENT_WEST << 9;

    public static final int BLOCK_LINE_OF_SIGHT_FULL = 0x20000;

}