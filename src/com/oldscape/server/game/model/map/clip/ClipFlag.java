package com.oldscape.server.game.model.map.clip;

public final class ClipFlag {

    public static final int CORNERLOC_NORTHWEST = 0x1;//bit=0

    public static final int WALL_NORTH = 0x2;//bit=1

    public static final int CORNERLOC_NORTHEAST = 0x4;//bit=2

    public static final int WALL_EAST = 0x8;//bit=3

    public static final int CORNERLOC_SOUTHEAST = 0x10;//bit=4

    public static final int WALL_SOUTH = 0x20;//bit=5

    public static final int CORNERLOC_SOUTHWEST = 0x40;//bit=6

    public static final int WALL_WEST = 0x80;//bit=7

    public static final int LOC = 0x100;//bit=8

    public static final int CORNERLOC_NORTHWEST_BLOCKSFLY = 0x200;//bit=9

    public static final int WALL_NORTH_BLOCKSFLY = 0x400;//bit=10

    public static final int CORNERLOC_NORTHEAST_BLOCKSFLY = 0x800;//bit=11

    public static final int WALL_EAST_BLOCKSFLY = 0x1000;//bit=12

    public static final int CORNERLOC_SOUTHEAST_BLOCKSFLY = 0x2000;//bit=13

    public static final int WALL_SOUTH_BLOCKSFLY = 0x4000;//bit=14

    public static final int CORNERLOC_SOUTHWEST_BLOCKSFLY = 0x8000;//bit=15

    public static final int WALL_WEST_BLOCKSFLY = 0x10_000;//bit=16

    public static final int LOC_BLOCKSFLY = 0x20_000;//bit=17

    public static final int FLOORDECO_BLOCKSWALK = 0x40_000;//bit=18

    public static final int UNKNOWN_19 = 0x80_000;

    public static final int UNKNOWN_20 = 0x100_000;

    public static final int FLOOR_BLOCKSWALK = 0x200_000;//bit=21

    public static final int CORNERLOC_NORTHWEST_BLOCKSWALK_ALTERNATIVE = 0x400_000;//bit=22

    public static final int WALL_NORTH_BLOCKSWALK_ALTERNATIVE = 0x800_000;//bit=23

    public static final int CORNERLOC_NORTHEAST_BLOCKSWALK_ALTERNATIVE = 0x1_000_000;//bit=24

    public static final int WALL_EAST_BLOCKSWALK_ALTERNATIVE = 0x2_000_000;//bit=25

    public static final int CORNERLOC_SOUTHEAST_BLOCKSWALK_ALTERNATIVE = 0x4_000_000;//bit=26

    public static final int WALL_SOUTH_BLOCKSWALK_ALTERNATIVE = 0x8_000_000;//bit=27

    public static final int CORNERLOC_SOUTHWEST_BLOCKSWALK_ALTERNATIVE = 0x10_000_000;//bit=28

    public static final int WALL_WEST_BLOCKSWALK_ALTERNATIVE = 0x20_000_000;//bit=29

    public static final int LOC_BLOCKSWALK_ALTERNATIVE = 0x40_000_000;//bit=30

    public static final int CHECK_SOUTH = FLOOR_BLOCKSWALK | FLOORDECO_BLOCKSWALK | LOC | WALL_SOUTH;

    public static final int CHECK_WEST = FLOOR_BLOCKSWALK | FLOORDECO_BLOCKSWALK | LOC | WALL_WEST;

    public static final int CHECK_NORTH = FLOOR_BLOCKSWALK | FLOORDECO_BLOCKSWALK | LOC | WALL_NORTH;

    public static final int CHECK_EAST = FLOOR_BLOCKSWALK | FLOORDECO_BLOCKSWALK | LOC | WALL_EAST;

    public static final int CHECK_SOUTHWEST = CHECK_SOUTH | CHECK_WEST | CORNERLOC_SOUTHWEST;

    public static final int CHECK_NORTHWEST = CHECK_NORTH | CHECK_WEST | CORNERLOC_NORTHWEST;

    public static final int CHECK_SOUTHEAST = CHECK_SOUTH | CHECK_EAST | CORNERLOC_SOUTHEAST;

    public static final int CHECK_NORTHEAST = CHECK_NORTH | CHECK_EAST | CORNERLOC_NORTHEAST;

    public static final int CHECK_SOUTH_VARIABLE = CHECK_SOUTHWEST | CHECK_SOUTHEAST;

    public static final int CHECK_WEST_VARIABLE = CHECK_SOUTHWEST | CHECK_NORTHEAST;

    public static final int CHECK_NORTH_VARIABLE = CHECK_NORTHWEST | CHECK_NORTHEAST;

    public static final int CHECK_EAST_VARIABLE = CHECK_SOUTHEAST | CHECK_NORTHEAST;

    //(original=0x12c0102, client=0x40A40000)
    public static final int TRAVERSABLE_SOUTH = FLOORDECO_BLOCKSWALK | FLOOR_BLOCKSWALK
            | WALL_NORTH_BLOCKSWALK_ALTERNATIVE | LOC_BLOCKSWALK_ALTERNATIVE;

    //(original=0x12c0108, client=0x42240000)
    public static final int TRAVERSABLE_WEST = FLOORDECO_BLOCKSWALK | FLOOR_BLOCKSWALK
            | WALL_EAST_BLOCKSWALK_ALTERNATIVE | LOC_BLOCKSWALK_ALTERNATIVE;

    //(original=0x12c0120, client=0x48240000)
    public static final int TRAVERSABLE_NORTH = FLOORDECO_BLOCKSWALK | FLOOR_BLOCKSWALK
            | WALL_SOUTH_BLOCKSWALK_ALTERNATIVE | LOC_BLOCKSWALK_ALTERNATIVE;

    //(original=0x12c0180, client=0x60240000)
    public static final int TRAVERSABLE_EAST = FLOORDECO_BLOCKSWALK | FLOOR_BLOCKSWALK
            | WALL_WEST_BLOCKSWALK_ALTERNATIVE | LOC_BLOCKSWALK_ALTERNATIVE;

    //(original=0x12c010e, client=0x43a40000)
    public static final int TRAVERSABLE_SOUTHWEST = TRAVERSABLE_SOUTH | TRAVERSABLE_WEST |
            CORNERLOC_SOUTHWEST_BLOCKSWALK_ALTERNATIVE;

    //(original=0x12c0138, client=0x4e240000)
    public static final int TRAVERSABLE_NORTHWEST = TRAVERSABLE_NORTH | TRAVERSABLE_WEST
            | CORNERLOC_NORTHWEST_BLOCKSWALK_ALTERNATIVE;

    //(original=0x12c0183, client=0x40a40000)
    public static final int TRAVERSABLE_SOUTHEAST = TRAVERSABLE_SOUTH | TRAVERSABLE_EAST
            | CORNERLOC_SOUTHEAST_BLOCKSWALK_ALTERNATIVE;

    //(original=0x12c01e0, client=0x78240000)
    public static final int TRAVERSABLE_NORTHEAST = TRAVERSABLE_NORTH | TRAVERSABLE_EAST
            | CORNERLOC_NORTHEAST_BLOCKSWALK_ALTERNATIVE;

    //(original=0x12c018f, client=0x63e40000)
    public static final int TRAVERSABLE_SOUTH_VARIABLE = TRAVERSABLE_SOUTHWEST | TRAVERSABLE_SOUTHEAST;

    //(original=0x12c013e, client=0x4fa40000)
    public static final int TRAVERSABLE_WEST_VARIABLE = TRAVERSABLE_SOUTHWEST | TRAVERSABLE_NORTHWEST;

    //(original=0x12c01f8, client=0x7e240000)
    public static final int TRAVERSABLE_NORTH_VARIABLE = TRAVERSABLE_NORTHWEST | TRAVERSABLE_NORTHEAST;

    //(original=0x12c01e3, client=0x78e40000)
    public static final int TRAVERSABLE_EAST_VARIABLE = TRAVERSABLE_SOUTHEAST | TRAVERSABLE_NORTHEAST;

}