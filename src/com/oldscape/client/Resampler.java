package com.oldscape.client;

class Resampler {
   static int field1629;
   static String[] field1627;
   private int storedSampleRateRatio;
   private int playbackSampleRateRatio;
   private int[][] resampleTable;

   public Resampler(int var1, int var2) {
      if(var2 != var1) {
         final int var3 = method538(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.storedSampleRateRatio = var1;
         this.playbackSampleRateRatio = var2;
         this.resampleTable = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            final int[] var5 = this.resampleTable[var4];
            final double var6 = 6.0D + (double)var4 / var1;
            int var8 = (int)Math.floor(var6 - 7.0D + 1.0D);
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
            if(var9 > 14) {
               var9 = 14;
            }

            for(final double var10 = (double)var2 / var1; var8 < var9; ++var8) {
               final double var12 = 3.141592653589793D * (var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * (var8 - var6));
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   static int method538(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   byte[] resampleIfNecessary(byte[] var1) {
      if(this.resampleTable != null) {
         final int var2 = (int)((long)this.playbackSampleRateRatio * var1.length / this.storedSampleRateRatio) + 14;
         final int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            final byte var7 = var1[var6];
            final int[] var8 = this.resampleTable[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.playbackSampleRateRatio;
            var9 = var5 / this.storedSampleRateRatio;
            var4 += var9;
            var5 -= var9 * this.storedSampleRateRatio;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            final int var10 = var3[var6] + 32768 >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   int method2302(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)this.playbackSampleRateRatio * var1 / this.storedSampleRateRatio);
      }

      return var1;
   }

   int method2303(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)this.playbackSampleRateRatio * var1 / this.storedSampleRateRatio) + 6;
      }

      return var1;
   }
}
