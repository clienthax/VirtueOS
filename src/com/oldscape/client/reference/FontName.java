package com.oldscape.client.reference;

public class FontName {
    public static final FontName FontName_plain11;
    public static final FontName FontName_plain12;
    public static final FontName FontName_bold12;
    public static final FontName FontName_verdana_plain11;
    public static final FontName FontName_verdana_plain13;
    public static final FontName FontName_verdana_plain15;
    static int[] landRegionFileIds;

    static {
        FontName_plain11 = new FontName("PLAIN11", "p11_full");
        FontName_plain12 = new FontName("PLAIN12", "p12_full");
        FontName_bold12 = new FontName("BOLD12", "b12_full");
        FontName_verdana_plain11 = new FontName("VERDANA11", "verdana_11pt_regular");
        FontName_verdana_plain13 = new FontName("VERDANA13", "verdana_13pt_regular");
        FontName_verdana_plain15 = new FontName("VERDANA15", "verdana_15pt_regular");
    }

    private final String field3884;
    String fileName;

    private FontName(final String var1, final String var2) {
        this.field3884 = var1;
        this.fileName = var2;
    }

    public static Font method5488(final IndexDataBase var0, final IndexDataBase var1, final int var2, final int var3) {
        return !RunException.method3215(var0, var2, var3) ? null : class57.method868(var1.getConfigData(var2, var3));
    }

    public static Widget getWidgetChild(final int var0, final int var1) {
        final Widget var2 = class44.getWidget(var0);
        return var1 == -1 ? var2 : (var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null);
    }

    static void method5490(final Widget var0) {
        if (var0.loopCycle == Client.field1071) {
            Client.field1072[var0.boundsIndex] = true;
        }

    }

    static String method5489(String var0) {
        final ChatCrownType[] var2 = {ChatCrownType.STAFF_MODERATOR, ChatCrownType.PLAYER_MODERATOR, ChatCrownType.IRONMAN, ChatCrownType.HARDCORE_IRONMAN, ChatCrownType.PLAYER, ChatCrownType.ULTIMATE_IRONMAN};

        for (final ChatCrownType var4 : var2) {
            if (var4.icon != -1) {
                final int var7 = var4.icon;
                final String var6 = "<img=" + var7 + ">";
                if (var0.startsWith(var6)) {
                    var0 = var0.substring(6 + Integer.toString(var4.icon).length());
                    break;
                }
            }
        }

        return var0;
    }
}
