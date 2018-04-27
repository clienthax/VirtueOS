package com.oldscape.client;

public class WorldMapType1 implements WorldMapSectionBase {
   int field435;
   int field438;
   int field429;
   int field431;
   int field440;
   int field432;
   int field427;
   int field434;
   int field428;
   int field436;

   public void vmethod767(WorldMapData var1) {
      if(var1.minX > this.field427) {
         var1.minX = this.field427;
      }

      if(var1.field455 < this.field428) {
         var1.field455 = this.field428;
      }

      if(var1.minY > this.field434) {
         var1.minY = this.field434;
      }

      if(var1.field457 < this.field436) {
         var1.field457 = this.field436;
      }

   }

   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field435 && var1 < this.field438 + this.field435?var2 >> 6 >= this.field429 && var2 >> 6 <= this.field440 && var3 >> 6 >= this.field431 && var3 >> 6 <= this.field432:false;
   }

   public boolean vmethod768(int var1, int var2) {
      return var1 >> 6 >= this.field427 && var1 >> 6 <= this.field428 && var2 >> 6 >= this.field434 && var2 >> 6 <= this.field436;
   }

   public int[] vmethod753(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field427 * 64 - this.field429 * 64 + var2, var3 + (this.field434 * 64 - this.field431 * 64)};
         return var4;
      }
   }

   public Coordinates vmethod758(int var1, int var2) {
      if(!this.vmethod768(var1, var2)) {
         return null;
      } else {
         int var3 = this.field429 * 64 - this.field427 * 64 + var1;
         int var4 = this.field431 * 64 - this.field434 * 64 + var2;
         return new Coordinates(this.field435, var3, var4);
      }
   }

   public void vmethod754(Buffer var1) {
      this.field435 = var1.readUnsignedByte();
      this.field438 = var1.readUnsignedByte();
      this.field429 = var1.readUnsignedShort();
      this.field431 = var1.readUnsignedShort();
      this.field440 = var1.readUnsignedShort();
      this.field432 = var1.readUnsignedShort();
      this.field427 = var1.readUnsignedShort();
      this.field434 = var1.readUnsignedShort();
      this.field428 = var1.readUnsignedShort();
      this.field436 = var1.readUnsignedShort();
      this.method288();
   }

   void method288() {
   }

   static String method309(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   static void method308(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1683()?1:0;
                     var12 = var8.method1683()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1683()?1:0;
                     var12 = var8.method1683()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method308(var0, var1, var6, var3, var4);
         method308(var0, var6 + 1, var2, var3, var4);
      }

   }
}
