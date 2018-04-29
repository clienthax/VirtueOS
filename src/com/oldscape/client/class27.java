package com.oldscape.client;

public enum class27 implements Enumerated {
   field400(3, (byte)0),
   field401(1, (byte)1),
   field399(0, (byte)2),
   field402(2, (byte)3);

   final int field403;
   final byte rsOrdinal;

   class27(final int var3, final byte var4) {
      this.field403 = var3;
      this.rsOrdinal = var4;
   }

   public int rsOrdinal() {
      return this.rsOrdinal;
   }

   public static int method248(final double var0, final double var2, final double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(var2 != 0.0D) {
         final double var12;
         if(var4 < 0.5D) {
            var12 = (var2 + 1.0D) * var4;
         } else {
            var12 = var4 + var2 - var2 * var4;
         }

         final double var14 = var4 * 2.0D - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(6.0D * var16 < 1.0D) {
            var6 = (var12 - var14) * 6.0D * var16 + var14;
         } else if(2.0D * var16 < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = var14 + (0.6666666666666666D - var16) * (var12 - var14) * 6.0D;
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = var14 + var0 * 6.0D * (var12 - var14);
         } else if(var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = (var12 - var14) * (0.6666666666666666D - var0) * 6.0D + var14;
         } else {
            var8 = var14;
         }

         if(6.0D * var20 < 1.0D) {
            var10 = (var12 - var14) * 6.0D * var20 + var14;
         } else if(2.0D * var20 < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = var14 + 6.0D * (0.6666666666666666D - var20) * (var12 - var14);
         } else {
            var10 = var14;
         }
      }

      final int var22 = (int)(256.0D * var6);
      final int var13 = (int)(var8 * 256.0D);
      final int var23 = (int)(256.0D * var10);
       return var23 + (var13 << 8) + (var22 << 16);
   }

   static int method247(final int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   static class27[] method243() {
      return new class27[]{field399, field401, field400, field402};
   }

   static void method245(final int var0, final int var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
      final int[] var7 = Region.method2905(var0, var1, var2);
      final int[] var8 = Region.method2905(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   static boolean method246(final Widget widget) {
      if(widget.tableActions == null) {
         return false;
      } else {
         for(int idx = 0; idx < widget.tableActions.length; ++idx) {
            final int var2 = class308.method5486(widget, idx);
            final int var3 = widget.field2936[idx];
            if(widget.tableActions[idx] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(widget.tableActions[idx] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(widget.tableActions[idx] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   static void method239(final Widget widget, final int var1, final int var2) {
      if(Client.draggedWidget == null && !Client.isMenuOpen) {
         if(widget != null && WorldMapRegion.method533(widget) != null) {
            Client.draggedWidget = widget;
            Client.field937 = WorldMapRegion.method533(widget);
            Client.field1042 = var1;
            Client.field1114 = var2;
            class55.field660 = 0;
            Client.draggingWidget = false;
            final int var3 = Client.menuOptionCount - 1;
            if(var3 != -1) {
               class22.method184(var3);
            }

         }
      }
   }
}
