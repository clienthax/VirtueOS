package com.oldscape.client.reference;

public enum BaseVarType implements Enumerated {
    INTEGER(1, 0, Integer.class, new class2()),
    LONG(2, 1, Long.class, new class3()),
    STRING(0, 2, String.class, new class5());

    public static class265 field25;
    final int id2;
    final int id;

    BaseVarType(final int var3, final int var4, final Class var5, final class0 var6) {
        this.id2 = var3;
        this.id = var4;
    }

    static void method9(final Player player, final int var1, final int var2, final byte var3) {
        final int var4 = player.pathX[0];
        final int var5 = player.pathY[0];
        final int var6 = player.getSize();
        if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
            if (var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
                final int var7 = class171.method3325(var4, var5, player.getSize(), WorldMapType2.method578(var1, var2), Client.collisionMaps[player.plane], Client.field1034, Client.field1131);
                if (var7 >= 1) {
                    for (int var8 = 0; var8 < var7 - 1; ++var8) {
                        player.method1186(Client.field1034[var8], Client.field1131[var8], var3);
                    }

                }
            }
        }
    }

    public int rsOrdinal() {
        return this.id;
    }
}
