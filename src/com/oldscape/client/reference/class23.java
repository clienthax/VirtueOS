package com.oldscape.client.reference;

import java.awt.*;

class class23 {
    static Client clientInstance;
    static int baseY;

    static void method186(final Component var0) {
        var0.setFocusTraversalKeysEnabled(false);
        var0.addKeyListener(KeyFocusListener.keyboard);
        var0.addFocusListener(KeyFocusListener.keyboard);
    }

    public static void method189(final IndexDataBase var0) {
        InvType.field3449 = var0;
    }

    static void method187(final int var0, final boolean var1, final int var2, final boolean var3) {
        if (World.worldList != null) {
            class81.method1848(0, World.worldList.length - 1, var0, var1, var2, var3);
        }

    }

    static void method190(final boolean var0) {
        Client.field1016 = var0;
    }
}
