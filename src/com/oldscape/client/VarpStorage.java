package com.oldscape.client;

class VarpStorage {

   static final int[] varpsMasks;
   static final int[] serverVarps;
   public static final int[] clientVarps;
   static IndexedSprite[] slArrowSprites;

   static {
      varpsMasks = new int[32];
      int mask = 2;

      for(int idx = 0; idx < 32; ++idx) {
         varpsMasks[idx] = mask - 1;
         mask += mask;
      }

      serverVarps = new int[2000];
      clientVarps = new int[2000];
   }
}
