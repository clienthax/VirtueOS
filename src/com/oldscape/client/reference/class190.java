package com.oldscape.client.reference;

class class190 {
    static IndexData indexScripts;

    static void method3488() {
        class95.field1449 = new int[2000];
        int var0 = 0;
        int var1 = 240;

        int var3;
        for (final byte var2 = 12; var0 < 16; var1 -= var2) {
            var3 = class27.method248((var1 / 360.0F), 0.9998999834060669D, (var0 * 0.425F / 16.0F + 0.075F));
            class95.field1449[var0] = var3;
            ++var0;
        }

        var1 = 48;

        for (final int var5 = var1 / 6; var0 < class95.field1449.length; var1 -= var5) {
            var3 = var0 * 2;

            for (final int var4 = class27.method248((var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < class95.field1449.length; ++var0) {
                class95.field1449[var0] = var4;
            }
        }

    }
}
