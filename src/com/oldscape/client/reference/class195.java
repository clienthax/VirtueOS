package com.oldscape.client.reference;

class class195 {
    static final byte[][] field2580;
    static final byte[][] field2581;
    static final byte[][] field2585;
    static int field2583;
    static int field2579;
    static int field2578;
    static int[] field2584;

    static {
        field2583 = 0;
        field2579 = 0;
        field2578 = 0;
        field2580 = new byte[1000][];
        field2581 = new byte[250][];
        field2585 = new byte[50][];
    }

    static synchronized byte[] method3729(final int var0) {
        final byte[] var2;
        if (var0 != 100) {
            if (var0 < 100) {
            }
        } else if (field2583 > 0) {
            var2 = field2580[--field2583];
            field2580[field2583] = null;
            return var2;
        }

        if (var0 != 5000) {
            if (var0 < 5000) {
            }
        } else if (field2579 > 0) {
            var2 = field2581[--field2579];
            field2581[field2579] = null;
            return var2;
        }

        if (var0 != 30000) {
            if (var0 < 30000) {
            }
        } else if (field2578 > 0) {
            var2 = field2585[--field2578];
            field2585[field2578] = null;
            return var2;
        }

        if (class319.field3930 != null) {
            for (int var4 = 0; var4 < field2584.length; ++var4) {
                if (field2584[var4] != var0) {
                    if (var0 < field2584[var4]) {
                    }
                } else if (OwnWorldComparator.field866[var4] > 0) {
                    final byte[] var3 = class319.field3930[var4][--OwnWorldComparator.field866[var4]];
                    class319.field3930[var4][OwnWorldComparator.field866[var4]] = null;
                    return var3;
                }
            }
        }

        return new byte[var0];
    }

    static void method3741() {
        final int var0 = class55.menuX;
        final int var1 = ScriptState.menuY;
        final int var2 = class245.field2975;
        final int var3 = Script.field1455;
        final int var4 = 6116423;
        Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
        Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
        Rasterizer2D.drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
        MessageNode.fontBold12.method5510("Choose Option", var0 + 3, var1 + 14, var4, -1);
        final int var5 = MouseInput.mouseLastX;
        final int var6 = MouseInput.mouseLastY;

        int var7;
        int var8;
        int var9;
        for (var7 = 0; var7 < Client.menuOptionCount; ++var7) {
            var8 = (Client.menuOptionCount - 1 - var7) * 15 + var1 + 31;
            var9 = 16777215;
            if (var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
                var9 = 16776960;
            }

            final Font var10 = MessageNode.fontBold12;
            final String var11;
            if (var7 < 0) {
                var11 = "";
            } else if (!Client.menuTargets[var7].isEmpty()) {
                var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
            } else {
                var11 = Client.menuOptions[var7];
            }

            var10.method5510(var11, var0 + 3, var8, var9, 0);
        }

        var7 = class55.menuX;
        var8 = ScriptState.menuY;
        var9 = class245.field2975;
        final int var12 = Script.field1455;

        for (int var13 = 0; var13 < Client.widgetCount; ++var13) {
            if (Client.widgetPositionX[var13] + Client.widgetBoundsWidth[var13] > var7 && Client.widgetPositionX[var13] < var7 + var9 && Client.widgetPositionY[var13] + Client.widgetBoundsHeight[var13] > var8 && Client.widgetPositionY[var13] < var8 + var12) {
                Client.field1073[var13] = true;
            }
        }

    }
}
