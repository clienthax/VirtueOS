package com.oldscape.client;

import java.util.HashMap;

public class class265 {
   static JagexGame field3435;
   private final HashMap<Integer, SpritePixels> field3438;
   private final Bounds field3437;
   private final int[] field3434;
   private final int[] field3433;
   private int field3436;

   public class265() {
      this.field3438 = new HashMap<>();
      this.field3437 = new Bounds(0, 0);
      this.field3434 = new int[2048];
      this.field3433 = new int[2048];
      this.field3436 = 0;
      class190.method3488();
   }

   private void method4685(final int var1) {
      final int var2 = var1 * 2 + 1;
      final double var4 = (var1 / 3.0F);
      final int var6 = var1 * 2 + 1;
      final double[] var7 = new double[var6];
      int var8 = -var1;

      for(int var9 = 0; var8 <= var1; ++var9) {
         final double var16 = (var8) / var4;
         final double var14 = Math.exp(var16 * -var16 / 2.0D) / Math.sqrt(6.283185307179586D);
         final double var12 = var14 / var4;
         var7[var9] = var12;
         ++var8;
      }

      final double var19 = var7[var1] * var7[var1];
      final int[] var21 = new int[var2 * var2];
      boolean var22 = false;

      for(int var11 = 0; var11 < var2; ++var11) {
         for(int var23 = 0; var23 < var2; ++var23) {
            final int var13 = var21[var23 + var11 * var2] = (int)(var7[var23] * var7[var11] / var19 * 256.0D);
            if(!var22 && var13 > 0) {
               var22 = true;
            }
         }
      }

      final SpritePixels var24 = new SpritePixels(var21, var2, var2);
      this.field3438.put(var1, var24);
   }

   private SpritePixels method4686(final int var1) {
      if(!this.field3438.containsKey(var1)) {
         this.method4685(var1);
      }

      return this.field3438.get(var1);
   }

   public final void method4703(final int var1, final int var2) {
      if(this.field3436 < this.field3434.length) {
         this.field3434[this.field3436] = var1;
         this.field3433[this.field3436] = var2;
         ++this.field3436;
      }
   }

   public final void method4688() {
      this.field3436 = 0;
   }

   public final void method4689(final int var1, final int var2, final SpritePixels pixels, final float var4) {
      final int var5 = (int)(var4 * 18.0F);
      final SpritePixels spritePixels = this.method4686(var5);
      final int var7 = var5 * 2 + 1;
      final Bounds spriteBounds = new Bounds(0, 0, pixels.width, pixels.height);
      final Bounds var9 = new Bounds(0, 0);
      this.field3437.method5676(var7, var7);
      System.nanoTime();

      int var10;
      int var11;
      int var12;
      for(var10 = 0; var10 < this.field3436; ++var10) {
         var11 = this.field3434[var10];
         var12 = this.field3433[var10];
         final int var13 = (int)((var11 - var1) * var4) - var5;
         final int var14 = (int)(pixels.height - var4 * (var12 - var2)) - var5;
         this.field3437.method5675(var13, var14);
         this.field3437.method5680(spriteBounds, var9);
         this.method4690(spritePixels, pixels, var9);
      }

      System.nanoTime();
      System.nanoTime();

      for(var10 = 0; var10 < pixels.pixels.length; ++var10) {
         if(pixels.pixels[var10] == 0) {
            pixels.pixels[var10] = 0xff000000;
         } else {
            var11 = (pixels.pixels[var10] + 64 - 1) / 256;
            if(var11 <= 0) {
               pixels.pixels[var10] = 0xff000000;
            } else {
               if(var11 > class95.field1449.length) {
                  var11 = class95.field1449.length;
               }

               var12 = class95.field1449[var11 - 1];
               pixels.pixels[var10] = 0xff000000 | var12;
            }
         }
      }

      System.nanoTime();
   }

   private void method4690(final SpritePixels var1, final SpritePixels var2, final Bounds var3) {
      if(var3.field3942 != 0 && var3.field3944 != 0) {
         int var4 = 0;
         int var5 = 0;
         if(var3.field3943 == 0) {
            var4 = var1.width - var3.field3942;
         }

         if(var3.field3941 == 0) {
            var5 = var1.height - var3.field3944;
         }

         int var6 = var4 + var5 * var1.width;
         int var7 = var3.field3943 + var2.width * var3.field3941;

         for(int var8 = 0; var8 < var3.field3944; ++var8) {
            for(int var9 = 0; var9 < var3.field3942; ++var9) {
               final int var10001 = var7++;
               var2.pixels[var10001] += var1.pixels[var6++];
            }

            var6 += var1.width - var3.field3942;
            var7 += var2.width - var3.field3942;
         }

      }
   }

}
