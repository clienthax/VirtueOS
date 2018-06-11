package com.oldscape.client.reference;

final class PendingSpawn extends Node {
    int level;
    int type;
    int x;
    int y;
    int field1146;
    int field1144;
    int field1147;
    int id;
    int orientation;
    int field1151;
    int delay;
    int hitpoints;

    PendingSpawn() {
        this.delay = 0;
        this.hitpoints = -1;
    }

    static String method1653(final int var0, final int var1) {
        final int var2 = var1 - var0;
        if (var2 < -9) return class45.getColTags(16711680);
        else if (var2 < -6) return class45.getColTags(16723968);
        else if (var2 < -3) return class45.getColTags(16740352);
        else if (var2 < 0) return class45.getColTags(16756736);
        else if (var2 > 9) return class45.getColTags(65280);
        else if (var2 > 6) return class45.getColTags(4259584);
        else if (var2 > 3) return class45.getColTags(8453888);
        else if (var2 > 0) return class45.getColTags(12648192);
        else return class45.getColTags(16776960);
    }
}
