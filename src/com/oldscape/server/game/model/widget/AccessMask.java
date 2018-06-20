package com.oldscape.server.game.model.widget;

public class AccessMask {

    public static final int CONTINUE = 1 << 0;

    public static final int CLICK_OP1 = 1 << 1;

    public static final int CLICK_OP2 = 1 << 2;

    public static final int CLICK_OP3 = 1 << 3;

    public static final int CLICK_OP4 = 1 << 4;

    public static final int CLICK_OP5 = 1 << 5;

    public static final int CLICK_OP6 = 1 << 6;

    public static final int CLICK_OP7 = 1 << 7;

    public static final int CLICK_OP8 = 1 << 8;

    public static final int CLICK_OP9 = 1 << 9;

    public static final int CLICK_OP10 = 1 << 10;

    public static final int USE_ON_GROUND_ITEMS = 1 << 11;

    public static final int USE_ON_NPCS = 1 << 12;

    public static final int USE_ON_OBJECTS = 1 << 13;

    public static final int USE_ON_PLAYERS = 1 << 14;

    public static final int USE_ON_INVENTORY = 1 << 15;

    public static final int USE_ON_UNKNOWN = 1 << 16;

    public static final int DRAG_DEPTH1 = 1 << 17;

    public static final int DRAG_DEPTH2 = 2 << 17;

    public static final int DRAG_DEPTH3 = 3 << 17;

    public static final int DRAG_DEPTH4 = 4 << 17;

    public static final int DRAG_DEPTH5 = 5 << 17;

    public static final int DRAG_DEPTH6 = 6 << 17;

    public static final int DRAG_DEPTH7 = 7 << 17;

    public static final int DRAG_TARGETABLE = 1 << 20;

    public static final int USE_ON_COMPONENT = 1 << 21;

}