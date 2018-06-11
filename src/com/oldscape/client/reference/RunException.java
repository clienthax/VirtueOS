package com.oldscape.client.reference;

import java.applet.Applet;

public class RunException extends RuntimeException {
    public static Applet field2198;
    public static String field2194;
    public static int revision;
    final Throwable parent;
    String field2197;

    RunException(final Throwable var1, final String var2) {
        this.field2197 = var2;
        this.parent = var1;
    }

    static boolean method3215(final IndexDataBase var0, final int var1, final int var2) {
        final byte[] var3 = var0.getConfigData(var1, var2);
        if (var3 == null) {
            return false;
        } else {
            IndexedSprite.decodeSprite(var3);
            return true;
        }
    }
}
