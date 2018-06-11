package com.oldscape.client.reference;

class class248 {
    public static final boolean[] field3011;
    public static final int[] field3012;
    static SpritePixels[] crossSprites;

    static {//Skills?
        field3011 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
        field3012 = new int[99];
        int var0 = 0;

        for (int var1 = 0; var1 < 99; ++var1) {
            final int var2 = var1 + 1;
            final int var3 = (int) (var2 + 300.0D * Math.pow(2.0D, var2 / 7.0D));
            var0 += var3;
            field3012[var1] = var0 / 4;
        }

    }

    public static int method4500(final int var0) {
        return Integer.compare(var0, 0);
    }
}
