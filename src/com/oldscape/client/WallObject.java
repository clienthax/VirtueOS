package com.oldscape.client;

public final class WallObject {
   int floor;
   int x;
   int y;
   int orientationA;
   int orientationB;
   public Renderable renderable1;
   public Renderable renderable2;
   public int hash;
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   public static String method3061(final Buffer var0) {
      String var1;
      try {
         int var2 = var0.getUSmart();
         if(var2 > 32767) {
            var2 = 32767;
         }

         final byte[] var3 = new byte[var2];
         var0.offset += class313.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
          var1 = ChatPlayer.getString(var3, 0, var2);
      } catch (final Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }

   static int getSmoothNoise(final int var0, final int var1, final int var2) {
      final int var3 = var0 / var2;
      final int var4 = var0 & var2 - 1;
      final int var5 = var1 / var2;
      final int var6 = var1 & var2 - 1;
      final int var7 = class254.getSmoothNoise2D(var3, var5);
      final int var8 = class254.getSmoothNoise2D(var3 + 1, var5);
      final int var9 = class254.getSmoothNoise2D(var3, var5 + 1);
      final int var10 = class254.getSmoothNoise2D(var3 + 1, var5 + 1);
      final int var11 = AbstractSoundSystem.method2246(var7, var8, var4, var2);
      final int var12 = AbstractSoundSystem.method2246(var9, var10, var4, var2);
      return AbstractSoundSystem.method2246(var11, var12, var6, var2);
   }
}
