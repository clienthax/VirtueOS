package com.oldscape.client;

public class BoundingBox3DDrawMode {
   public static final BoundingBox3DDrawMode ON_MOUSEOVER;
   public static final BoundingBox3DDrawMode ALWAYS;
   static long field270;
   static IndexedSprite[] slFlagSprites;
   static SpritePixels[] headIconsHint;
   static int plane;

   static {
      ON_MOUSEOVER = new BoundingBox3DDrawMode();
      ALWAYS = new BoundingBox3DDrawMode();
   }

   static void method55(class33 var0, int var1, int var2) {
      class213 var3 = WorldMapRegion.field480;
      long var5 = (long)(0 | var1 << 8 | var2);
      var3.method3935(var0, var5);
   }

   static final void method54(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class297.field3831[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class62.tileHeights[0][var5][var4] = class62.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   static void method53(String var0, String var1, String var2) {
      class90.loginMessage1 = var0;
      class90.loginMessage2 = var1;
      class90.loginMessage3 = var2;
   }
}
