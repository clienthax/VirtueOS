package com.oldscape.client;

public class ChatPlayer extends Nameable {
   public int world;
   public int field3845;
   public int rank;

   ChatPlayer() {
      this.world = -1;
   }

   void method5389(int var1, int var2) {
      this.world = var1;
      this.field3845 = var2;
   }

   public int method5390() {
      return this.world;
   }

   public boolean method5391() {
      return this.world > 0;
   }

   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class314.cp1252AsciiExtension[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }
}
