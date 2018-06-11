package com.oldscape.client.reference;

import java.net.URL;

class CombatInfoListHolder extends Node {
    static int field1310;
    final CombatInfo2 combatInfo2;
    private final CombatInfoList combatInfo1;

    CombatInfoListHolder(final CombatInfo2 var1) {
        this.combatInfo1 = new CombatInfoList();
        this.combatInfo2 = var1;
    }

    static void method1871(final int var0, final IndexFile var1, final IndexData var2) {
        byte[] var3 = null;
        synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            for (FileSystem var5 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var5 != null; var5 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
                if (var5.hash == var0 && var1 == var5.index && var5.type == 0) {
                    var3 = var5.field3367;
                    break;
                }
            }
        }

        if (var3 != null) {
            var2.load(var1, var0, var3, true);
        } else {
            final byte[] var8 = var1.read(var0);
            var2.load(var1, var0, var8, true);
        }
    }

    static void method1870() {
        class62.tileUnderlayIds = null;
        class62.tileOverlayIds = null;
        class62.tileOverlayPath = null;
        class62.overlayRotations = null;
        GZipDecompressor.field2520 = null;
        class297.field3831 = null;
        Client.field1354 = null;
        class55.floorHues = null;
        class183.floorSaturations = null;
        Client.field3314 = null;
        class36.floorMultiplier = null;
        Client.field1356 = null;
    }

    public static boolean method1865(final String var0, final int var1, final String var2) {
        if (var1 == 0) {
            try {
                if (!class57.field667.startsWith("win")) {
                    throw new Exception();
                } else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
                    throw new Exception();
                } else {
                    final String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

                    for (int var4 = 0; var4 < var0.length(); ++var4) {
                        if (var10.indexOf(var0.charAt(var4)) == -1) {
                            throw new Exception();
                        }
                    }

                    Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
                    return true;
                }
            } catch (final Throwable var5) {
                return false;
            }
        } else if (var1 == 1) {
            try {
                final Object var3 = class53.method820(class57.field674, var2, new Object[]{(new URL(class57.field674.getCodeBase(), var0)).toString()});
                return var3 != null;
            } catch (final Throwable var6) {
                return false;
            }
        } else if (var1 == 2) {
            try {
                class57.field674.getAppletContext().showDocument(new URL(class57.field674.getCodeBase(), var0), "_blank");
                return true;
            } catch (final Exception var7) {
                return false;
            }
        } else if (var1 == 3) {
            try {
                class53.method824(class57.field674, "loggedout");
            } catch (final Throwable ignored) {
            }

            try {
                class57.field674.getAppletContext().showDocument(new URL(class57.field674.getCodeBase(), var0), "_top");
                return true;
            } catch (final Exception var8) {
                return false;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    void method1859(final int var1, final int var2, final int var3, final int var4) {
        CombatInfo1 var5 = null;
        int var6 = 0;

        for (CombatInfo1 var7 = (CombatInfo1) this.combatInfo1.last(); var7 != null; var7 = (CombatInfo1) this.combatInfo1.previous()) {
            ++var6;
            if (var7.cycle == var1) {
                var7.set(var1, var2, var3, var4);
                return;
            }

            if (var7.cycle <= var1) {
                var5 = var7;
            }
        }

        if (var5 == null) {
            if (var6 < 4) {
                this.combatInfo1.addLast(new CombatInfo1(var1, var2, var3, var4));
            }

        } else {
            CombatInfoList.method3987(new CombatInfo1(var1, var2, var3, var4), var5);
            if (var6 >= 4) {
                this.combatInfo1.last().unlink();
            }

        }
    }

    CombatInfo1 method1860(final int var1) {
        CombatInfo1 var2 = (CombatInfo1) this.combatInfo1.last();
        if (var2 != null && var2.cycle <= var1) {
            for (CombatInfo1 var3 = (CombatInfo1) this.combatInfo1.previous(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1) this.combatInfo1.previous()) {
                var2.unlink();
                var2 = var3;
            }

            if (this.combatInfo2.field3522 + var2.int2 + var2.cycle > var1) {
                return var2;
            } else {
                var2.unlink();
                return null;
            }
        } else {
            return null;
        }
    }

    boolean method1858() {
        return this.combatInfo1.isEmpty();
    }
}
