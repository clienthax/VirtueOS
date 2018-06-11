package com.oldscape.client.reference;

public class BoundingBox3DDrawMode {
    public static final BoundingBox3DDrawMode ON_MOUSEOVER;
    public static final BoundingBox3DDrawMode ALWAYS;
    static long field270;
    static IndexedSprite[] slFlagSprites;
    static SpritePixels[] headIconsHint;
    static int plane;

    static {
        ON_MOUSEOVER = new BoundingBox3DDrawMode();
        ALWAYS = new BoundingBox3DDrawMode();
    }

    static void method55(final class33 var0, final int var1, final int var2) {
        final class213 var3 = WorldMapRegion.field480;
        final long var5 = (var1 << 8 | var2);
        var3.method3935(var0, var5);
    }

    static void method54(final int var0, final int var1, final int var2, final int var3) {
        for (int var4 = var1; var4 <= var3 + var1; ++var4) {
            for (int var5 = var0; var5 <= var0 + var2; ++var5) {
                if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
                    class297.field3831[0][var5][var4] = 127;
                    if (var0 == var5 && var5 > 0) {
                        class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 - 1][var4];
                    }

                    if (var0 + var2 == var5 && var5 < 103) {
                        class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 + 1][var4];
                    }

                    if (var4 == var1 && var4 > 0) {
                        class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 - 1];
                    }

                    if (var4 == var3 + var1 && var4 < 103) {
                        class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 + 1];
                    }
                }
            }
        }

    }

    static void method53(final String var0, final String var1, final String var2) {
        class90.loginMessage1 = var0;
        class90.loginMessage2 = var1;
        class90.loginMessage3 = var2;
    }
}
