package com.oldscape.client;

import java.io.File;
import java.io.IOException;

public class class110 {
   static int field1607;
   private final IndexDataBase sfx_index;
   private final IndexDataBase vorbis_index;
   private final HashTable field1604;
   private final HashTable field1601;

   public class110(final IndexDataBase var1, final IndexDataBase var2) {
      this.field1604 = new HashTable(256);
      this.field1601 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   private RawAudioNode method2273(final int var1, final int var2, final int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      final long var5 = var4;
      RawAudioNode var7 = (RawAudioNode)this.field1601.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         final SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2124();
            this.field1601.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }

   private RawAudioNode method2274(final int var1, final int var2, final int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      final long var5 = var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1601.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         Instrument var8 = (Instrument)this.field1604.get(var5);
         if(var8 == null) {
            var8 = Instrument.getInstrument(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1604.put(var8, var5);
         }

         var7 = var8.method2138(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1601.put(var7, var5);
            return var7;
         }
      }
   }

   public RawAudioNode method2275(final int var1, final int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2273(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2273(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public RawAudioNode method2276(final int var1, final int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2274(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2274(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   static void method2284(final File var0, final File var1) {
      try {
         final FileOnDisk var2 = new FileOnDisk(class167.jagexClDat, "rw", 10000L);
         final Buffer var3 = new Buffer(500);
         var3.putByte(3);
         var3.putByte(var1 != null?1:0);
         var3.putCESU8(var0.getPath());
         if(var1 != null) {
            var3.putCESU8("");
         }

         var2.write(var3.payload, 0, var3.offset);
         var2.close();
      } catch (final IOException var4) {
         var4.printStackTrace();
      }

   }

   static void method2272(final Widget var0, final ItemComposition var1, final int var2, final int var3, final boolean var4) {
      final String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         final String var9 = class45.getColTags(16748608) + var1.name;
         final int var11 = var1.id;
         final int var13 = var0.id;
         if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var7;
            Client.menuTargets[Client.menuOptionCount] = var9;
            Client.menuTypes[Client.menuOptionCount] = var6;
            Client.menuIdentifiers[Client.menuOptionCount] = var11;
            Client.menuActionParams0[Client.menuOptionCount] = var2;
            Client.menuActionParams1[Client.menuOptionCount] = var13;
            Client.menuBooleanArray[Client.menuOptionCount] = var4;
            ++Client.menuOptionCount;
         }
      }

   }
}
