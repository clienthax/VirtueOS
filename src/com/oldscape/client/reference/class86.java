package com.oldscape.client.reference;

class class86 {
    public static int field1330;

    static RenderOverview method1892() {
        return Preferences.renderOverview;
    }

    static void method1889(final Widget[] var0, final Widget var1, final boolean var2) {
        final int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
        final int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
        KeyFocusListener.method787(var0, var1.id, var3, var4, var2);
        if (var1.children != null) {
            KeyFocusListener.method787(var1.children, var1.id, var3, var4, var2);
        }

        final WidgetNode var5 = (WidgetNode) Client.componentTable.get(var1.id);
        if (var5 != null) {
            class44.method666(var5.id, var3, var4, var2);
        }

        if (var1.contentType == 1337) {
        }

    }
}
