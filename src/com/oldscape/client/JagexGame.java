package com.oldscape.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

public enum JagexGame implements Enumerated {
   field3362("runescape", "RuneScape", 0),
   field3364("stellardawn", "Stellar Dawn", 1),
   field3361("game3", "Game 3", 2),
   field3360("game4", "Game 4", 3),
   field3363("game5", "Game 5", 4),
   field3366("oldscape", "RuneScape 2007", 5);

   public final String name;
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   public int rsOrdinal() {
      return this.id;
   }

   public static void method4522(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class281.field3585 = var0;
      class5.field35 = var1;
      class156.field2167 = var2;
   }

   static String method4521(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof RunException) {
         RunException var2 = (RunException)var0;
         var1 = var2.field2197 + " | ";
         var0 = var2.parent;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }
}
