package com.oldscape.client.reference;

class ScriptState {
    static int field755;
    static int[] field762;
    static int field761;
    static int menuY;
    Script invokedFromScript;
    int invokedFromPc;
    int[] savedLocalInts;
    String[] savedLocalStrings;

    ScriptState() {
        this.invokedFromPc = -1;
    }

    static int method1110(final World var0, final World var1, final int var2, final boolean var3) {
        if (var2 == 1) {
            int var4 = var0.playerCount;
            int var5 = var1.playerCount;
            if (!var3) {
                if (var4 == -1) {
                    var4 = 2001;
                }

                if (var5 == -1) {
                    var5 = 2001;
                }
            }

            return var4 - var5;
        } else {
            return var2 == 2 ? var0.location - var1.location : (var2 == 3 ? (var0.activity.equals("-") ? (var1.activity.equals("-") ? 0 : (var3 ? -1 : 1)) : (var1.activity.equals("-") ? (var3 ? 1 : -1) : var0.activity.compareTo(var1.activity))) : (var2 == 4 ? (var0.method1686() ? (var1.method1686() ? 0 : 1) : (var1.method1686() ? -1 : 0)) : (var2 == 5 ? (var0.method1684() ? (var1.method1684() ? 0 : 1) : (var1.method1684() ? -1 : 0)) : (var2 == 6 ? (var0.method1685() ? (var1.method1685() ? 0 : 1) : (var1.method1685() ? -1 : 0)) : (var2 == 7 ? (var0.method1683() ? (var1.method1683() ? 0 : 1) : (var1.method1683() ? -1 : 0)) : var0.id - var1.id)))));
        }
    }

    static void method1108(final IndexData var0, final String var1) {
        final class64 var2 = new class64(var0, var1);
        Client.field871.add(var2);
    }

    static void method1109() {
        for (int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
            final int var2 = Client.menuTypes[var0];
            final boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
            if (var1) {
                if (var0 < Client.menuOptionCount - 1) {
                    for (int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                        Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                        Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                        Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                        Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                        Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                        Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                        Client.menuBooleanArray[var3] = Client.menuBooleanArray[var3 + 1];
                    }
                }

                --Client.menuOptionCount;
            }
        }

    }
}
