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

   public static String method3061(Buffer var0) {
      String var1;
      try {
         int var2 = var0.getUSmart();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class313.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = ChatPlayer.getString(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }

   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class254.getSmoothNoise2D(var3, var5);
      int var8 = class254.getSmoothNoise2D(var3 + 1, var5);
      int var9 = class254.getSmoothNoise2D(var3, var5 + 1);
      int var10 = class254.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var11 = AbstractSoundSystem.method2246(var7, var8, var4, var2);
      int var12 = AbstractSoundSystem.method2246(var9, var10, var4, var2);
      return AbstractSoundSystem.method2246(var11, var12, var6, var2);
   }
}
