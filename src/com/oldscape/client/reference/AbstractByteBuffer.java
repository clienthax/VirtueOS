package com.oldscape.client.reference;

abstract class AbstractByteBuffer {
    static boolean directBufferUnavailable;

    static {
        directBufferUnavailable = false;
    }

    public static void method3757(final String[] var0, final short[] var1, final int var2, final int var3) {
        if (var2 < var3) {
            final int var4 = (var3 + var2) / 2;
            int var5 = var2;
            final String var6 = var0[var4];
            var0[var4] = var0[var3];
            var0[var3] = var6;
            final short var7 = var1[var4];
            var1[var4] = var1[var3];
            var1[var3] = var7;

            for (int var8 = var2; var8 < var3; ++var8) {
                if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
                    final String var9 = var0[var8];
                    var0[var8] = var0[var5];
                    var0[var5] = var9;
                    final short var10 = var1[var8];
                    var1[var8] = var1[var5];
                    var1[var5++] = var10;
                }
            }

            var0[var3] = var0[var5];
            var0[var5] = var6;
            var1[var3] = var1[var5];
            var1[var5] = var7;
            method3757(var0, var1, var2, var5 - 1);
            method3757(var0, var1, var5 + 1, var3);
        }

    }

    abstract byte[] get();

    abstract void put(byte[] var1);
}
