package com.oldscape.server.game.model.widget;

public enum AccessMaskType {

    CONTINUE(1 << 0),

    CLICK_OP1(1 << 1),

    CLICK_OP2(1 << 2),

    CLICK_OP3(1 << 3),

    CLICK_OP4(1 << 4),

    CLICK_OP5(1 << 5),

    CLICK_OP6(1 << 6),

    CLICK_OP7(1 << 7),

    CLICK_OP8(1 << 8),

    CLICK_OP9(1 << 9),

    CLICK_OP10(1 << 10),

    USE_ON_GROUND_ITEMS(1 << 11),

    USE_ON_NPCS(1 << 12),

    USE_ON_OBJECTS(1 << 13),

    USE_ON_PLAYERS(1 << 14),

    USE_ON_INVENTORY(1 << 15),

    USE_ON_UNKNOWN(1 << 16),

    DRAG_DEPTH1(1 << 17),

    DRAG_DEPTH2(2 << 17),

    DRAG_DEPTH3(3 << 17),

    DRAG_DEPTH4(4 << 17),

    DRAG_DEPTH5(5 << 17),

    DRAG_DEPTH6(6 << 17),

    DRAG_DEPTH7(7 << 17),

    DRAG_TARGETABLE(1 << 20),

    USE_ON_COMPONENT(1 << 21);

    private final int type;

    AccessMaskType(int type) {
        this.type = type;
    }

    public int getID() {
        return (byte) type;
    }

}