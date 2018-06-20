package com.oldscape.client.reference;

public enum ChatCrownType implements Enumerated {
    PLAYER(0, -1, false, true),
    PLAYER_MODERATOR(1, 0, true, true),
    STAFF_MODERATOR(2, 1, true, false),
    IRONMAN(3, 2, false, true),
    ULTIMATE_IRONMAN(4, 3, false, true),
    HARDCORE_IRONMAN(5, 10, false, true);

    public final int icon;
    public final boolean moderator;
    public final boolean ignorable;
    final int id;

    ChatCrownType(final int var3, final int var4, final boolean var6, final boolean var7) {
        this.id = var3;
        this.icon = var4;
        this.moderator = var6;
        this.ignorable = var7;
    }

    public int rsOrdinal() {
        return this.id;
    }

}
