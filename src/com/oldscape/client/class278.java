package com.oldscape.client;

public class class278 extends CacheableNode {
   public static IndexDataBase field3547;
   static NodeCache field3546;
   static int field3551;
   char field3548;
   public int field3545;
   public String field3549;
   boolean field3550;

   static {
      field3546 = new NodeCache(64);
   }

   class278() {
      this.field3550 = true;
   }

   void method4900() {
   }

   void method4901(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4902(var1, var2);
      }
   }

   void method4902(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class314.cp1252AsciiExtension[var5 - 128];
            if(var6 == 0) {
               var6 = '?';
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3548 = var3;
      } else if(var2 == 2) {
         this.field3545 = var1.readInt();
      } else if(var2 == 4) {
         this.field3550 = false;
      } else if(var2 == 5) {
         this.field3549 = var1.readString();
      }

   }

   public boolean method4916() {
      return this.field3548 == 's';
   }

   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field951 != 0) {
         if(var0.field3759 != null && var1 < var0.field3759.length) {
            int var4 = var0.field3759[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var5;
               Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var6;
               Client.unknownSoundValues2[Client.queuedSoundEffectCount] = 0;
               Client.audioEffects[Client.queuedSoundEffectCount] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.soundLocations[Client.queuedSoundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.queuedSoundEffectCount;
            }
         }
      }
   }
}
