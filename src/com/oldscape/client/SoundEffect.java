package com.oldscape.client;

public class SoundEffect {
   private final AudioInstrument[] instruments;
   private int start;
   private int end;

   private SoundEffect(final Buffer buffer) {
      this.instruments = new AudioInstrument[10];

      for(int idx = 0; idx < 10; ++idx) {
         final int var3 = buffer.readUnsignedByte();
         if(var3 != 0) {
            --buffer.offset;
            this.instruments[idx] = new AudioInstrument();
            this.instruments[idx].decode(buffer);
         }
      }

      this.start = buffer.readUnsignedShort();
      this.end = buffer.readUnsignedShort();
   }

   public RawAudioNode method2124() {
      final byte[] mix = this.mix();
      return new RawAudioNode(22050, mix, this.start * 22050 / 1000, this.end * 22050 / 1000);
   }

   public final int calculateDelay() {
      int var1 = 9999999;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.instruments[var2] != null && this.instruments[var2].offset / 20 < var1) {
            var1 = this.instruments[var2].offset / 20;
         }
      }

      if(this.start < this.end && this.start / 20 < var1) {
         var1 = this.start / 20;
      }

      if(var1 != 9999999 && var1 != 0) {
         for(var2 = 0; var2 < 10; ++var2) {
            if(this.instruments[var2] != null) {
               this.instruments[var2].offset -= var1 * 20;
            }
         }

         if(this.start < this.end) {
            this.start -= var1 * 20;
            this.end -= var1 * 20;
         }

         return var1;
      } else {
         return 0;
      }
   }

   private byte[] mix() {
      int var1 = 0;

      int var2;
      for(var2 = 0; var2 < 10; ++var2) {
         if(this.instruments[var2] != null && this.instruments[var2].duration + this.instruments[var2].offset > var1) {
            var1 = this.instruments[var2].duration + this.instruments[var2].offset;
         }
      }

      if(var1 == 0) {
         return new byte[0];
      } else {
         var2 = var1 * 22050 / 1000;
         final byte[] var3 = new byte[var2];

         for(int var4 = 0; var4 < 10; ++var4) {
            if(this.instruments[var4] != null) {
               final int var5 = this.instruments[var4].duration * 22050 / 1000;
               final int var6 = this.instruments[var4].offset * 22050 / 1000;
               final int[] var7 = this.instruments[var4].synthesize(var5, this.instruments[var4].duration);

               for(int var8 = 0; var8 < var5; ++var8) {
                  int var9 = (var7[var8] >> 8) + var3[var8 + var6];
                  if((var9 + 128 & -256) != 0) {
                     var9 = var9 >> 31 ^ 127;
                  }

                  var3[var8 + var6] = (byte)var9;
               }
            }
         }

         return var3;
      }
   }

   public static SoundEffect getTrack(final IndexDataBase var0, final int var1, final int var2) {
      final byte[] var3 = var0.getConfigData(var1, var2);
      return var3 == null?null:new SoundEffect(new Buffer(var3));
   }
}
