package com.oldscape.client;

public class class237 {
   static int[] varpsMasks;
   public static int[] serverVarps;
   public static int[] clientVarps;
   static IndexedSprite[] slArrowSprites;

   static {
      varpsMasks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         varpsMasks[var1] = var0 - 1;
         var0 += var0;
      }

      serverVarps = new int[2000];
      clientVarps = new int[2000];
   }
}
