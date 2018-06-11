package com.oldscape.client.reference;

import java.io.*;

public enum JagexGame implements Enumerated {
    RUNESCAPE("runescape", "RuneScape", 0),
    STELLARDAWN("stellardawn", "Stellar Dawn", 1),
    GAME3("game3", "Game 3", 2),
    GAME4("game4", "Game 4", 3),
    GAME5("game5", "Game 5", 4),
    OLDSCAPE("oldscape", "RuneScape 2007", 5);

    public final String name;
    final int id;

    JagexGame(final String var3, final String var4, final int var5) {
        this.name = var3;
        this.id = var5;
    }

    public static JagexGame[] method4506() {
        return new JagexGame[]{STELLARDAWN, GAME4, GAME3, GAME5, RUNESCAPE, OLDSCAPE};
    }

    public static void method4522(final IndexDataBase var0, final IndexDataBase var1, final IndexDataBase var2) {
        class281.field3585 = var0;
        class5.field35 = var1;
        class156.field2167 = var2;
    }

    static String method4521(Throwable var0) throws IOException {
        final StringBuilder var1;
        if (var0 instanceof RunException) {
            final RunException var2 = (RunException) var0;
            var1 = new StringBuilder(var2.field2197 + " | ");
            var0 = var2.parent;
        } else {
            var1 = new StringBuilder();
        }

        final StringWriter var12 = new StringWriter();
        final PrintWriter var3 = new PrintWriter(var12);
        var0.printStackTrace(var3);
        var3.close();
        final String var4 = var12.toString();
        final BufferedReader var5 = new BufferedReader(new StringReader(var4));
        final String var6 = var5.readLine();

        while (true) {
            while (true) {
                String var7 = var5.readLine();
                if (var7 == null) {
                    var1.append("| ").append(var6);
                    return var1.toString();
                }

                final int var8 = var7.indexOf(40);
                final int var9 = var7.indexOf(41, var8 + 1);
                if (var8 >= 0 && var9 >= 0) {
                    String var10 = var7.substring(var8 + 1, var9);
                    final int var11 = var10.indexOf(".java:");
                    if (var11 >= 0) {
                        var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                        var1.append(var10).append(' ');
                        continue;
                    }

                    var7 = var7.substring(0, var8);
                }

                var7 = var7.trim();
                var7 = var7.substring(var7.lastIndexOf(32) + 1);
                var7 = var7.substring(var7.lastIndexOf(9) + 1);
                var1.append(var7).append(' ');
            }
        }
    }

    public int rsOrdinal() {
        return this.id;
    }
}
