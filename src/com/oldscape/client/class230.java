package com.oldscape.client;

public class class230 extends TaskDataNode {
   private final HashTable field2720;
   private int field2695;
   private final int field2696;
   private final int[] field2697;
   private final int[] field2698;
   private final int[] field2699;
   private final int[] field2700;
   private final int[] field2701;
   private final int[] field2694;
   private final int[] field2703;
   private final int[] field2704;
   private final int[] field2702;
   final int[] field2716;
   private final int[] field2708;
   private final int[] field2717;
   final int[] field2709;
   private final int[] field2718;
   final int[] field2711;
   private final class231[][] field2712;
   private final class231[][] field2713;
   private final class232 field2706;
   private boolean field2715;
   private int field2705;
   private int field2707;
   private long field2710;
   private long field2719;
   private final class234 field2714;

   public class230() {
      this.field2695 = 256;
      this.field2696 = 1000000;
      this.field2697 = new int[16];
      this.field2698 = new int[16];
      this.field2699 = new int[16];
      this.field2700 = new int[16];
      this.field2701 = new int[16];
      this.field2694 = new int[16];
      this.field2703 = new int[16];
      this.field2704 = new int[16];
      this.field2702 = new int[16];
      this.field2716 = new int[16];
      this.field2708 = new int[16];
      this.field2717 = new int[16];
      this.field2709 = new int[16];
      this.field2718 = new int[16];
      this.field2711 = new int[16];
      this.field2712 = new class231[16][128];
      this.field2713 = new class231[16][128];
      this.field2706 = new class232();
      this.field2714 = new class234(this);
      this.field2720 = new HashTable(128);
      this.method4138();
   }

   public synchronized void method4134(final int var1) {
      this.field2695 = var1;
   }

   public int method4250() {
      return this.field2695;
   }

   public synchronized boolean method4136(final Track1 var1, final IndexDataBase var2, final class110 var3, final int var4) {
      var1.method4337();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2770.first(); var7 != null; var7 = (ByteArrayNode)var1.field2770.next()) {
         final int var8 = (int)var7.hash;
         class233 var9 = (class233)this.field2720.get(var8);
         if(var9 == null) {
            var9 = WorldMapRegion.method536(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2720.put(var9, var8);
         }

         if(!var9.method4307(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4338();
      }

      return var5;
   }

   public synchronized void method4137() {
      for(class233 var1 = (class233)this.field2720.first(); var1 != null; var1 = (class233)this.field2720.next()) {
         var1.method4308();
      }

   }

   public synchronized void method4141() {
      for(class233 var1 = (class233)this.field2720.first(); var1 != null; var1 = (class233)this.field2720.next()) {
         var1.unlink();
      }

   }

   protected synchronized TaskDataNode vmethod4330() {
      return this.field2714;
   }

   protected synchronized TaskDataNode vmethod4321() {
      return null;
   }

   protected synchronized int vmethod4314() {
      return 0;
   }

   protected synchronized void vmethod4317(final int[] var1, int var2, int var3) {
      if(this.field2706.method4269()) {
         final int var4 = this.field2706.field2743 * this.field2696 / AbstractSoundSystem.sampleRate;

         do {
            final long var5 = (long)var3 * var4 + this.field2710;
            if(this.field2719 - var5 >= 0L) {
               this.field2710 = var5;
               break;
            }

            final int var7 = (int)((var4 + (this.field2719 - this.field2710) - 1L) / var4);
            this.field2710 += (long)var4 * var7;
            this.field2714.vmethod4317(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4230();
         } while(this.field2706.method4269());
      }

      this.field2714.vmethod4317(var1, var2, var3);
   }

   public synchronized void method4139(final Track1 var1, final boolean var2) {
      this.method4140();
      this.field2706.method4298(var1.field2769);
      this.field2715 = var2;
      this.field2710 = 0L;
      final int var3 = this.field2706.method4270();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2706.method4271(var4);
         this.field2706.method4274(var4);
         this.field2706.method4272(var4);
      }

      this.field2705 = this.field2706.method4279();
      this.field2707 = this.field2706.field2753[this.field2705];
      this.field2719 = this.field2706.method4296(this.field2707);
   }

   protected synchronized void vmethod4319(int var1) {
      if(this.field2706.method4269()) {
         final int var2 = this.field2706.field2743 * this.field2696 / AbstractSoundSystem.sampleRate;

         do {
            final long var3 = this.field2710 + (long)var1 * var2;
            if(this.field2719 - var3 >= 0L) {
               this.field2710 = var3;
               break;
            }

            final int var5 = (int)((this.field2719 - this.field2710 + var2 - 1L) / var2);
            this.field2710 += (long)var2 * var5;
            this.field2714.vmethod4319(var5);
            var1 -= var5;
            this.method4230();
         } while(this.field2706.method4269());
      }

      this.field2714.vmethod4319(var1);
   }

   public synchronized void method4140() {
      this.field2706.method4268();
      this.method4138();
   }

   public synchronized boolean method4151() {
      return this.field2706.method4269();
   }

   public synchronized void method4191(final int var1, final int var2) {
      this.method4241(var1, var2);
   }

   private void method4241(final int var1, final int var2) {
      this.field2700[var1] = var2;
      this.field2694[var1] = var2 & -128;
      this.method4143(var1, var2);
   }

   private void method4143(final int var1, final int var2) {
      if(var2 != this.field2701[var1]) {
         this.field2701[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2713[var1][var3] = null;
         }
      }

   }

   private void method4144(final int var1, final int var2, final int var3) {
      this.method4153(var1, var2, 64);
      if((this.field2716[var1] & 2) != 0) {
         for(class231 var4 = (class231)this.field2714.field2765.getTail(); var4 != null; var4 = (class231)this.field2714.field2765.getPrevious()) {
            if(var4.field2734 == var1 && var4.field2740 < 0) {
               this.field2712[var1][var4.field2726] = null;
               this.field2712[var1][var2] = var4;
               final int var5 = (var4.field2721 * var4.field2730 >> 12) + var4.field2733;
               var4.field2733 += var2 - var4.field2726 << 8;
               var4.field2730 = var5 - var4.field2733;
               var4.field2721 = 4096;
               var4.field2726 = var2;
               return;
            }
         }
      }

      final class233 var9 = (class233)this.field2720.get(this.field2701[var1]);
      if(var9 != null) {
         final RawAudioNode var8 = var9.field2757[var2];
         if(var8 != null) {
            final class231 var6 = new class231();
            var6.field2734 = var1;
            var6.field2722 = var9;
            var6.field2729 = var8;
            var6.field2724 = var9.field2763[var2];
            var6.field2725 = var9.field2761[var2];
            var6.field2726 = var2;
            var6.field2727 = var3 * var3 * var9.field2756[var2] * var9.field2762 + 1024 >> 11;
            var6.field2728 = var9.field2760[var2] & 255;
            var6.field2733 = (var2 << 8) - (var9.field2759[var2] & 32767);
            var6.field2732 = 0;
            var6.field2731 = 0;
            var6.field2735 = 0;
            var6.field2740 = -1;
            var6.field2736 = 0;
            if(this.field2709[var1] == 0) {
               var6.field2739 = class115.method2318(var8, this.method4158(var6), this.method4159(var6), this.method4226(var6));
            } else {
               var6.field2739 = class115.method2318(var8, this.method4158(var6), 0, this.method4226(var6));
               this.method4145(var6, var9.field2759[var2] < 0);
            }

            if(var9.field2759[var2] < 0) {
               var6.field2739.method2320(-1);
            }

            if(var6.field2725 >= 0) {
               final class231 var7 = this.field2713[var1][var6.field2725];
               if(var7 != null && var7.field2740 < 0) {
                  this.field2712[var1][var7.field2726] = null;
                  var7.field2740 = 0;
               }

               this.field2713[var1][var6.field2725] = var6;
            }

            this.field2714.field2765.addFront(var6);
            this.field2712[var1][var2] = var6;
         }
      }
   }

   void method4145(final class231 var1, final boolean var2) {
      int var3 = var1.field2729.audioBuffer.length;
      int var4;
      if(var2 && var1.field2729.field1548) {
         final int var5 = var3 + var3 - var1.field2729.startPosition;
         var4 = (int)((long)this.field2709[var1.field2734] * var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2739.method2327();
         }
      } else {
         var4 = (int)((long)this.field2709[var1.field2734] * var3 >> 6);
      }

      var1.field2739.method2315(var4);
   }

   private void method4153(final int var1, final int var2, final int var3) {
      final class231 var4 = this.field2712[var1][var2];
      if(var4 != null) {
         this.field2712[var1][var2] = null;
         if((this.field2716[var1] & 2) != 0) {
            for(class231 var5 = (class231)this.field2714.field2765.getFront(); var5 != null; var5 = (class231)this.field2714.field2765.getNext()) {
               if(var5.field2734 == var4.field2734 && var5.field2740 < 0 && var5 != var4) {
                  var4.field2740 = 0;
                  break;
               }
            }
         } else {
            var4.field2740 = 0;
         }

      }
   }

   private void method4147(final int var1, final int var2, final int var3) {
   }

   private void method4238(final int var1, final int var2) {
   }

   private void method4149(final int var1, final int var2) {
      this.field2703[var1] = var2;
   }

   private void method4187(final int var1) {
      for(class231 var2 = (class231)this.field2714.field2765.getFront(); var2 != null; var2 = (class231)this.field2714.field2765.getNext()) {
         if(var1 < 0 || var2.field2734 == var1) {
            if(var2.field2739 != null) {
               var2.field2739.method2363(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2739.method2335()) {
                  this.field2714.field2766.method2059(var2.field2739);
               }

               var2.method4262();
            }

            if(var2.field2740 < 0) {
               this.field2712[var2.field2734][var2.field2726] = null;
            }

            var2.unlink();
         }
      }

   }

   private void method4235(int var1) {
      if(var1 >= 0) {
         this.field2697[var1] = 12800;
         this.field2698[var1] = 8192;
         this.field2699[var1] = 16383;
         this.field2703[var1] = 8192;
         this.field2704[var1] = 0;
         this.field2702[var1] = 8192;
         this.method4154(var1);
         this.method4155(var1);
         this.field2716[var1] = 0;
         this.field2708[var1] = 32767;
         this.field2717[var1] = 256;
         this.field2709[var1] = 0;
         this.method4164(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4235(var1);
         }

      }
   }

   private void method4152(final int var1) {
      for(class231 var2 = (class231)this.field2714.field2765.getFront(); var2 != null; var2 = (class231)this.field2714.field2765.getNext()) {
         if((var1 < 0 || var2.field2734 == var1) && var2.field2740 < 0) {
            this.field2712[var2.field2734][var2.field2726] = null;
            var2.field2740 = 0;
         }
      }

   }

   private void method4138() {
      this.method4187(-1);
      this.method4235(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2701[var1] = this.field2700[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2694[var1] = this.field2700[var1] & -128;
      }

   }

   private void method4154(final int var1) {
      if((this.field2716[var1] & 2) != 0) {
         for(class231 var2 = (class231)this.field2714.field2765.getFront(); var2 != null; var2 = (class231)this.field2714.field2765.getNext()) {
            if(var2.field2734 == var1 && this.field2712[var1][var2.field2726] == null && var2.field2740 < 0) {
               var2.field2740 = 0;
            }
         }
      }

   }

   private void method4155(final int var1) {
      if((this.field2716[var1] & 4) != 0) {
         for(class231 var2 = (class231)this.field2714.field2765.getFront(); var2 != null; var2 = (class231)this.field2714.field2765.getNext()) {
            if(var2.field2734 == var1) {
               var2.field2741 = 0;
            }
         }
      }

   }

   private void method4181(final int var1) {
      int var2 = var1 & 240;
      final int var3;
      final int var4;
      final int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4153(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4144(var3, var4, var5);
         } else {
            this.method4153(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4147(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2694[var3] = (var5 << 14) + (this.field2694[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2694[var3] = (var5 << 7) + (this.field2694[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2704[var3] = (var5 << 7) + (this.field2704[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2704[var3] = var5 + (this.field2704[var3] & -128);
         }

         if(var4 == 5) {
            this.field2702[var3] = (var5 << 7) + (this.field2702[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2702[var3] = var5 + (this.field2702[var3] & -128);
         }

         if(var4 == 7) {
            this.field2697[var3] = (var5 << 7) + (this.field2697[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2697[var3] = var5 + (this.field2697[var3] & -128);
         }

         if(var4 == 10) {
            this.field2698[var3] = (var5 << 7) + (this.field2698[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2698[var3] = var5 + (this.field2698[var3] & -128);
         }

         if(var4 == 11) {
            this.field2699[var3] = (var5 << 7) + (this.field2699[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2699[var3] = var5 + (this.field2699[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2716[var3] |= 1;
            } else {
               this.field2716[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2716[var3] |= 2;
            } else {
               this.method4154(var3);
               this.field2716[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2708[var3] = (var5 << 7) + (this.field2708[var3] & 127);
         }

         if(var4 == 98) {
            this.field2708[var3] = (this.field2708[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2708[var3] = (var5 << 7) + (this.field2708[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2708[var3] = (this.field2708[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4187(var3);
         }

         if(var4 == 121) {
            this.method4235(var3);
         }

         if(var4 == 123) {
            this.method4152(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2708[var3];
            if(var6 == 16384) {
               this.field2717[var3] = (var5 << 7) + (this.field2717[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2708[var3];
            if(var6 == 16384) {
               this.field2717[var3] = var5 + (this.field2717[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2709[var3] = (var5 << 7) + (this.field2709[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2709[var3] = var5 + (this.field2709[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2716[var3] |= 4;
            } else {
               this.method4155(var3);
               this.field2716[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4164(var3, (var5 << 7) + (this.field2718[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4164(var3, var5 + (this.field2718[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4143(var3, var4 + this.field2694[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4238(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4149(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4138();
         }
      }
   }

   private void method4164(final int var1, final int var2) {
      this.field2718[var1] = var2;
      this.field2711[var1] = (int)(2097152.0D * Math.pow(2.0D, var2 * 5.4931640625E-4D) + 0.5D);
   }

   private int method4158(final class231 var1) {
      int var2 = (var1.field2730 * var1.field2721 >> 12) + var1.field2733;
      var2 += (this.field2703[var1.field2734] - 8192) * this.field2717[var1.field2734] >> 12;
      final class228 var3 = var1.field2724;
      int var4;
      if(var3.field2683 > 0 && (var3.field2682 > 0 || this.field2704[var1.field2734] > 0)) {
         var4 = var3.field2682 << 2;
         final int var5 = var3.field2678 << 1;
         if(var1.field2737 < var5) {
            var4 = var4 * var1.field2737 / var5;
         }

         var4 += this.field2704[var1.field2734] >> 7;
         final double var6 = Math.sin(0.01227184630308513D * (var1.field2738 & 511));
         var2 += (int)(var6 * var4);
      }

      var4 = (int)((var1.field2729.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * var2) / AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   private int method4159(final class231 var1) {
      final class228 var2 = var1.field2724;
      int var3 = this.field2697[var1.field2734] * this.field2699[var1.field2734] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2727 + 16384 >> 15;
      var3 = var3 * this.field2695 + 128 >> 8;
      if(var2.field2676 > 0) {
         var3 = (int)(var3 * Math.pow(0.5D, var2.field2676 * 1.953125E-5D * var1.field2732) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2680 != null) {
         var4 = var1.field2731;
         var5 = var2.field2680[var1.field2735 + 1];
         if(var1.field2735 < var2.field2680.length - 2) {
            var6 = (var2.field2680[var1.field2735] & 255) << 8;
            var7 = (var2.field2680[var1.field2735 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2680[var1.field2735 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2740 > 0 && var2.field2684 != null) {
         var4 = var1.field2740;
         var5 = var2.field2684[var1.field2736 + 1];
         if(var1.field2736 < var2.field2684.length - 2) {
            var6 = (var2.field2684[var1.field2736] & 255) << 8;
            var7 = (var2.field2684[var1.field2736 + 2] & 255) << 8;
            var5 += (var2.field2684[var1.field2736 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   private int method4226(final class231 var1) {
      final int var2 = this.field2698[var1.field2734];
      return var2 < 8192?var2 * var1.field2728 + 32 >> 6:16384 - ((128 - var1.field2728) * (16384 - var2) + 32 >> 6);
   }

   private void method4230() {
      int var1 = this.field2705;
      int var2 = this.field2707;

      long var3;
      for(var3 = this.field2719; var2 == this.field2707; var3 = this.field2706.method4296(var2)) {
         while(var2 == this.field2706.field2753[var1]) {
            this.field2706.method4271(var1);
            final int var5 = this.field2706.method4275(var1);
            if(var5 == 1) {
               this.field2706.method4273();
               this.field2706.method4272(var1);
               if(this.field2706.method4280()) {
                  if(!this.field2715 || var2 == 0) {
                     this.method4138();
                     this.field2706.method4268();
                     return;
                  }

                  this.field2706.method4285(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4181(var5);
            }

            this.field2706.method4274(var1);
            this.field2706.method4272(var1);
         }

         var1 = this.field2706.method4279();
         var2 = this.field2706.field2753[var1];
      }

      this.field2705 = var1;
      this.field2707 = var2;
      this.field2719 = var3;
   }

   boolean method4167(final class231 var1) {
      if(var1.field2739 == null) {
         if(var1.field2740 >= 0) {
            var1.unlink();
            if(var1.field2725 > 0 && var1 == this.field2713[var1.field2734][var1.field2725]) {
               this.field2713[var1.field2734][var1.field2725] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   boolean method4146(final class231 var1, final int[] var2, final int var3, final int var4) {
      var1.field2723 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2740 < 0 || var1.field2739 != null && !var1.field2739.method2399()) {
         int var5 = var1.field2721;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * this.field2702[var1.field2734]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2721 = var5;
         }

         var1.field2739.method2332(this.method4158(var1));
         final class228 var6 = var1.field2724;
         boolean var7 = false;
         ++var1.field2737;
         var1.field2738 += var6.field2683;
         final double var8 = 5.086263020833333E-6D * ((var1.field2726 - 60 << 8) + (var1.field2721 * var1.field2730 >> 12));
         if(var6.field2676 > 0) {
            if(var6.field2681 > 0) {
               var1.field2732 += (int)(128.0D * Math.pow(2.0D, var6.field2681 * var8) + 0.5D);
            } else {
               var1.field2732 += 128;
            }
         }

         if(var6.field2680 != null) {
            if(var6.field2679 > 0) {
               var1.field2731 += (int)(128.0D * Math.pow(2.0D, var8 * var6.field2679) + 0.5D);
            } else {
               var1.field2731 += 128;
            }

            while(var1.field2735 < var6.field2680.length - 2 && var1.field2731 > (var6.field2680[var1.field2735 + 2] & 255) << 8) {
               var1.field2735 += 2;
            }

            if(var6.field2680.length - 2 == var1.field2735 && var6.field2680[var1.field2735 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2740 >= 0 && var6.field2684 != null && (this.field2716[var1.field2734] & 1) == 0 && (var1.field2725 < 0 || var1 != this.field2713[var1.field2734][var1.field2725])) {
            if(var6.field2677 > 0) {
               var1.field2740 += (int)(128.0D * Math.pow(2.0D, var6.field2677 * var8) + 0.5D);
            } else {
               var1.field2740 += 128;
            }

            while(var1.field2736 < var6.field2684.length - 2 && var1.field2740 > (var6.field2684[var1.field2736 + 2] & 255) << 8) {
               var1.field2736 += 2;
            }

            if(var6.field2684.length - 2 == var1.field2736) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2739.method2363(var1.field2723);
            if(var2 != null) {
               var1.field2739.vmethod4317(var2, var3, var4);
            } else {
               var1.field2739.vmethod4319(var4);
            }

            if(var1.field2739.method2335()) {
               this.field2714.field2766.method2059(var1.field2739);
            }

            var1.method4262();
            if(var1.field2740 >= 0) {
               var1.unlink();
               if(var1.field2725 > 0 && var1 == this.field2713[var1.field2734][var1.field2725]) {
                  this.field2713[var1.field2734][var1.field2725] = null;
               }
            }

            return true;
         } else {
            var1.field2739.method2330(var1.field2723, this.method4159(var1), this.method4226(var1));
            return false;
         }
      } else {
         var1.method4262();
         var1.unlink();
         if(var1.field2725 > 0 && var1 == this.field2713[var1.field2734][var1.field2725]) {
            this.field2713[var1.field2734][var1.field2725] = null;
         }

         return true;
      }
   }
}
