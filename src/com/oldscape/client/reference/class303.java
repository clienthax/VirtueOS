package com.oldscape.client.reference;

public class class303 {
    public static final class303 field3851;
    public static final class303 field3850;
    public static final class303 field3849;

    static {
        field3851 = new class303();
        field3850 = new class303();
        field3849 = new class303();
    }

    public static String method5406(final String var0) {
        final int var1 = var0.length();
        final char[] var2 = new char[var1];
        byte var3 = 2;

        for (int var4 = 0; var4 < var1; ++var4) {
            char var5 = var0.charAt(var4);
            if (var3 == 0) {
                var5 = Character.toLowerCase(var5);
            } else if (var3 == 2 || Character.isUpperCase(var5)) {
                var5 = class81.method1849(var5);
            }

            if (Character.isLetter(var5)) {
                var3 = 0;
            } else if (var5 != '.' && var5 != '?' && var5 != '!') {
                if (Character.isSpaceChar(var5)) {
                    if (var3 != 2) {
                        var3 = 1;
                    }
                } else {
                    var3 = 1;
                }
            } else {
                var3 = 2;
            }

            var2[var4] = var5;
        }

        return new String(var2);
    }
}
