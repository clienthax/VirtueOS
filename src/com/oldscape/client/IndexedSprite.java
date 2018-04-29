package com.oldscape.client;

public final class IndexedSprite extends Rasterizer2D {
   public byte[] pixels;
   public int[] palette;
   public int width;
   public int height;
   public int offsetX;
   public int offsetY;
   public int originalWidth;
   public int originalHeight;

   static void decodeSprite(final byte[] data) {
      final Buffer buffer = new Buffer(data);
      buffer.offset = data.length - 2;
      class332.indexedSpriteCount = buffer.readUnsignedShort();
      class332.indexedSpriteOffsetXs = new int[class332.indexedSpriteCount];
      class332.indexedSpriteOffsetYs = new int[class332.indexedSpriteCount];
      class332.indexSpriteWidths = new int[class332.indexedSpriteCount];
      class332.indexedSpriteHeights = new int[class332.indexedSpriteCount];
      class332.spritePixels = new byte[class332.indexedSpriteCount][];
      buffer.offset = data.length - 7 - class332.indexedSpriteCount * 8;
      class332.indexedSpriteWidth = buffer.readUnsignedShort();
      class332.indexedSpriteHeight = buffer.readUnsignedShort();
      final int var2 = (buffer.readUnsignedByte() & 255) + 1;

      int idx;
      for(idx = 0; idx < class332.indexedSpriteCount; ++idx) {
         class332.indexedSpriteOffsetXs[idx] = buffer.readUnsignedShort();
      }

      for(idx = 0; idx < class332.indexedSpriteCount; ++idx) {
         class332.indexedSpriteOffsetYs[idx] = buffer.readUnsignedShort();
      }

      for(idx = 0; idx < class332.indexedSpriteCount; ++idx) {
         class332.indexSpriteWidths[idx] = buffer.readUnsignedShort();
      }

      for(idx = 0; idx < class332.indexedSpriteCount; ++idx) {
         class332.indexedSpriteHeights[idx] = buffer.readUnsignedShort();
      }

      buffer.offset = data.length - 7 - class332.indexedSpriteCount * 8 - (var2 - 1) * 3;
      class332.indexedSpritePalette = new int[var2];

      for(idx = 1; idx < var2; ++idx) {
         class332.indexedSpritePalette[idx] = buffer.read24BitInt();
         if(class332.indexedSpritePalette[idx] == 0) {
            class332.indexedSpritePalette[idx] = 1;
         }
      }

      buffer.offset = 0;

      for(idx = 0; idx < class332.indexedSpriteCount; ++idx) {
         final int var4 = class332.indexSpriteWidths[idx];
         final int var5 = class332.indexedSpriteHeights[idx];
         final int var6 = var4 * var5;
         final byte[] var7 = new byte[var6];
         class332.spritePixels[idx] = var7;
         final int var8 = buffer.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = buffer.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = buffer.readByte();
               }
            }
         }
      }

   }

    static IndexedSprite method4486(final IndexDataBase var0, final int var1) {
       final byte[] var3 = var0.takeRecordFlat(var1);
       final boolean var2;
       if(var3 == null) {
          var2 = false;
       } else {
          decodeSprite(var3);
          var2 = true;
       }

       return !var2?null:method3159();
    }

    static IndexedSprite method3159() {
       final IndexedSprite indexedSprite = new IndexedSprite();
       indexedSprite.originalWidth = class332.indexedSpriteWidth;
       indexedSprite.originalHeight = class332.indexedSpriteHeight;
       indexedSprite.offsetX = class332.indexedSpriteOffsetXs[0];
       indexedSprite.offsetY = class332.indexedSpriteOffsetYs[0];
       indexedSprite.width = class332.indexSpriteWidths[0];
       indexedSprite.height = class332.indexedSpriteHeights[0];
       indexedSprite.palette = class332.indexedSpritePalette;
       indexedSprite.pixels = class332.spritePixels[0];
       class332.clearSprites();
       return indexedSprite;
    }

    void normalize() {
      if(this.width != this.originalWidth || this.height != this.originalHeight) {
         final byte[] var1 = new byte[this.originalWidth * this.originalHeight];
         int var2 = 0;

         for(int var3 = 0; var3 < this.height; ++var3) {
            for(int var4 = 0; var4 < this.width; ++var4) {
               var1[var4 + (var3 + this.offsetY) * this.originalWidth + this.offsetX] = this.pixels[var2++];
            }
         }

         this.pixels = var1;
         this.width = this.originalWidth;
         this.height = this.originalHeight;
         this.offsetX = 0;
         this.offsetY = 0;
      }
   }

   void method5824(final int var1, final int var2, final int var3) {
      for(int var4 = 0; var4 < this.palette.length; ++var4) {
         int var5 = this.palette[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.palette[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.palette[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.palette[var4] = var7 + (var6 << 8) + (var5 << 16);
      }

   }

   void method5825(int x, int y) {
      x += this.offsetX;
      y += this.offsetY;
      int var3 = x + y * Rasterizer2D.graphicsPixelsWidth;
      int var4 = 0;
      int var5 = this.height;
      int var6 = this.width;
      int var7 = Rasterizer2D.graphicsPixelsWidth - var6;
      int var8 = 0;
      int var9;
      if(y < Rasterizer2D.drawingAreaTop) {
         var9 = Rasterizer2D.drawingAreaTop - y;
         var5 -= var9;
         y = Rasterizer2D.drawingAreaTop;
         var4 += var9 * var6;
         var3 += var9 * Rasterizer2D.graphicsPixelsWidth;
      }

      if(var5 + y > Rasterizer2D.drawingAreaRight) {
         var5 -= var5 + y - Rasterizer2D.drawingAreaRight;
      }

      if(x < Rasterizer2D.draw_region_x) {
         var9 = Rasterizer2D.draw_region_x - x;
         var6 -= var9;
         x = Rasterizer2D.draw_region_x;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 + x > Rasterizer2D.drawingAreaBottom) {
         var9 = var6 + x - Rasterizer2D.drawingAreaBottom;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method5826(Rasterizer2D.graphicsPixels, this.pixels, this.palette, var4, var3, var6, var5, var7, var8);
      }
   }

   public void method5827(int var1, int var2, int var3, int var4) {
      final int var5 = this.width;
      final int var6 = this.height;
      int var7 = 0;
      int var8 = 0;
      final int var9 = this.originalWidth;
      final int var10 = this.originalHeight;
      final int var11 = (var9 << 16) / var3;
      final int var12 = (var10 << 16) / var4;
      int var13;
      if(this.offsetX > 0) {
         var13 = (var11 + (this.offsetX << 16) - 1) / var11;
         var1 += var13;
         var7 += var13 * var11 - (this.offsetX << 16);
      }

      if(this.offsetY > 0) {
         var13 = (var12 + (this.offsetY << 16) - 1) / var12;
         var2 += var13;
         var8 += var13 * var12 - (this.offsetY << 16);
      }

      if(var5 < var9) {
         var3 = (var11 + ((var5 << 16) - var7) - 1) / var11;
      }

      if(var6 < var10) {
         var4 = (var12 + ((var6 << 16) - var8) - 1) / var12;
      }

      var13 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
      int var14 = Rasterizer2D.graphicsPixelsWidth - var3;
      if(var2 + var4 > Rasterizer2D.drawingAreaRight) {
         var4 -= var2 + var4 - Rasterizer2D.drawingAreaRight;
      }

      int var15;
      if(var2 < Rasterizer2D.drawingAreaTop) {
         var15 = Rasterizer2D.drawingAreaTop - var2;
         var4 -= var15;
         var13 += var15 * Rasterizer2D.graphicsPixelsWidth;
         var8 += var12 * var15;
      }

      if(var3 + var1 > Rasterizer2D.drawingAreaBottom) {
         var15 = var3 + var1 - Rasterizer2D.drawingAreaBottom;
         var3 -= var15;
         var14 += var15;
      }

      if(var1 < Rasterizer2D.draw_region_x) {
         var15 = Rasterizer2D.draw_region_x - var1;
         var3 -= var15;
         var13 += var15;
         var7 += var11 * var15;
         var14 += var15;
      }

      method5837(Rasterizer2D.graphicsPixels, this.pixels, this.palette, var7, var8, var13, var14, var3, var4, var11, var12, var5);
   }

   private static void method5826(final int[] var0, final byte[] var1, final int[] var2, int var3, int var4, int var5, final int var6, final int var7, final int var8) {
      final int var9 = -(var5 >> 2);
      var5 = -(var5 & 3);

      for(int var10 = -var6; var10 < 0; ++var10) {
         int var11;
         byte var12;
         for(var11 = var9; var11 < 0; ++var11) {
            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }

            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }

            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }

            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }
         }

         for(var11 = var5; var11 < 0; ++var11) {
            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   private static void method5837(final int[] var0, final byte[] var1, final int[] var2, int var3, int var4, int var5, final int var6, final int var7, final int var8, final int var9, final int var10, final int var11) {
      final int var12 = var3;

      for(int var13 = -var8; var13 < 0; ++var13) {
         final int var14 = var11 * (var4 >> 16);

         for(int var15 = -var7; var15 < 0; ++var15) {
            final byte var16 = var1[(var3 >> 16) + var14];
            if(var16 != 0) {
               var0[var5++] = var2[var16 & 255];
            } else {
               ++var5;
            }

            var3 += var9;
         }

         var4 += var10;
         var3 = var12;
         var5 += var6;
      }

   }
}
