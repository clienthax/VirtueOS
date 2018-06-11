package com.oldscape.client.reference;

public final class GameObject {
    static int cameraZ;
    public Renderable renderable;
    public int hash;
    int plane;
    int height;
    int x;
    int y;
    int orientation;
    int relativeX;
    int offsetX;
    int relativeY;
    int offsetY;
    int drawPriority;
    int cycle;
    int flags;

    GameObject() {
        this.hash = 0;
        this.flags = 0;
    }

    static void method3083(final Player var0, final int var1, final int var2) {
        if (var0.animation == var1 && var1 != -1) {
            final int var3 = CombatInfo1.getAnimation(var1).replyMode;
            if (var3 == 1) {
                var0.actionFrame = 0;
                var0.actionFrameCycle = 0;
                var0.actionAnimationDisable = var2;
                var0.field1193 = 0;
            }

            if (var3 == 2) {
                var0.field1193 = 0;
            }
        } else if (var1 == -1 || var0.animation == -1 || CombatInfo1.getAnimation(var1).forcedPriority >= CombatInfo1.getAnimation(var0.animation).forcedPriority) {
            var0.animation = var1;
            var0.actionFrame = 0;
            var0.actionFrameCycle = 0;
            var0.actionAnimationDisable = var2;
            var0.field1193 = 0;
            var0.field1216 = var0.queueSize;
        }

    }
}
