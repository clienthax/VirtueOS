package com.oldscape.client;

final class class2 implements class0 {
   public static int field11;
   static Widget field17;
   static int field16;

   public static boolean method3(final IndexDataBase var0, final IndexDataBase vorbisIndex, final IndexDataBase var2, final class230 var3) {
      class229.field2688 = var0;
      class229.vorbisIdxRef = vorbisIndex;
      class229.field2689 = var2;
      class229.field2690 = var3;
      return true;
   }

   static void requestNetFile(final IndexData indexData, final int parent, final int child, final int crc, final byte padding, final boolean var5) {
      final long var6 = ((parent << 16) + child);
      FileRequest var8 = (FileRequest)class264.NetCache_pendingPriorityWrites.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class264.NetCache_pendingWrites.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class264.NetCache_pendingPriorityWrites.put(var8, var6);
                  --class264.NetCache_pendingWritesCount;
                  ++class264.NetCache_pendingPriorityWritesCount;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class264.NetCache_pendingResponses.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = indexData;
               var8.crc = crc;
               var8.padding = padding;
               if(var5) {
                  class264.NetCache_pendingPriorityWrites.put(var8, var6);
                  ++class264.NetCache_pendingPriorityWritesCount;
               } else {
                  class264.NetCache_pendingWritesQueue.push(var8);
                  class264.NetCache_pendingWrites.put(var8, var6);
                  ++class264.NetCache_pendingWritesCount;
               }

            }
         }
      }
   }

   static void method2(int var0, int var1, final int var2, final int var3, final int var4, final int var5) {
      final int var6 = var2 - var0;
      final int var7 = var3 - var1;
      final int var8 = var6 >= 0?var6:-var6;
      final int var9 = var7 >= 0?var7:-var7;
      int var10 = var8;
      if(var8 < var9) {
         var10 = var9;
      }

      if(var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if(var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         final int var13 = var5 * var12 >> 17;
         final int var14 = var5 * var12 + 1 >> 17;
         final int var15 = var5 * var11 >> 17;
         final int var16 = var5 * var11 + 1 >> 17;
         var0 -= Rasterizer2D.draw_region_x;
         var1 -= Rasterizer2D.drawingAreaTop;
         final int var17 = var0 + var13;
         final int var18 = var0 - var14;
         final int var19 = var0 + var6 - var14;
         final int var20 = var0 + var13 + var6;
         final int var21 = var15 + var1;
         final int var22 = var1 - var16;
         final int var23 = var7 + var1 - var16;
         final int var24 = var7 + var15 + var1;
         Graphics3D.setRasterClippingEnabled(var17, var18, var19);
         Graphics3D.rasterFlat(var21, var22, var23, var17, var18, var19, var4);
         Graphics3D.setRasterClippingEnabled(var17, var19, var20);
         Graphics3D.rasterFlat(var21, var23, var24, var17, var19, var20, var4);
      }
   }
}
