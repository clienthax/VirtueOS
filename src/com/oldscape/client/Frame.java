package com.oldscape.client;

public class Frame {
   static int[] field1817;
   static int[] field1814;
   static int[] field1822;
   static int[] field1818;
   FrameMap skin;
   int transformCount;
   int[] transformTypes;
   int[] translator_x;
   int[] translator_y;
   int[] translator_z;
   boolean showing;

   static {
      field1817 = new int[500];
      field1814 = new int[500];
      field1822 = new int[500];
      field1818 = new int[500];
   }

   Frame(byte[] var1, FrameMap var2) {
      this.skin = null;
      this.transformCount = -1;
      this.showing = false;
      this.skin = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.readUnsignedByte();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var5 + var3.offset;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.readUnsignedByte();
         if(var9 > 0) {
            if(this.skin.types[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.skin.types[var10] == 0) {
                     field1817[var7] = var10;
                     field1814[var7] = 0;
                     field1822[var7] = 0;
                     field1818[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1817[var7] = var8;
            short var11 = 0;
            if(this.skin.types[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1814[var7] = var4.readShortSmart();
            } else {
               field1814[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1822[var7] = var4.readShortSmart();
            } else {
               field1822[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1818[var7] = var4.readShortSmart();
            } else {
               field1818[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.skin.types[var8] == 5) {
               this.showing = true;
            }
         }
      }

      if(var1.length != var4.offset) {
         throw new RuntimeException();
      } else {
         this.transformCount = var7;
         this.transformTypes = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.transformTypes[var8] = field1817[var8];
            this.translator_x[var8] = field1814[var8];
            this.translator_y[var8] = field1822[var8];
            this.translator_z[var8] = field1818[var8];
         }

      }
   }
}
