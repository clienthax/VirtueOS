package com.oldscape.client;

public class ItemContainer extends Node {
   static HashTable itemContainers;
   static int[] landMapFileIds;
   int[] itemIds;
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   static final int method1131(int var0, int var1) {
      int var2 = WallObject.getSmoothNoise(var0 + 45365, var1 + 91923, 4) - 128 + (WallObject.getSmoothNoise(10294 + var0, 37821 + var1, 2) - 128 >> 1) + (WallObject.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
