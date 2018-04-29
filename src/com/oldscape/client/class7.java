package com.oldscape.client;

class class7 {

   static boolean drawBoundingBoxes3D;
   static final boolean drawBoundingBoxes2D;
   static final boolean drawObjectGeometry2D;
   static BoundingBox3DDrawMode boundingBox3DDrawMode;
   static final CombatInfoList boundingBoxes;

   static SpritePixels compass;
   static Widget field234;

   static {
      drawBoundingBoxes3D = false;
      drawBoundingBoxes2D = false;
      drawObjectGeometry2D = false;
      boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
      boundingBoxes = new CombatInfoList();
   }

   public static boolean method27(final CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      final int var5 = var0.length();
      int var6 = 0;

      final boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label84: {
            final char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == '-') {
                  var2 = true;
                  break label84;
               }

               if(var7 == '+') {
                  break label84;
               }
            }

            int var9;
            if(var7 >= '0' && var7 <= '9') {
               var9 = var7 - '0';
            } else if(var7 >= 'A' && var7 <= 'Z') {
               var9 = var7 - '7';
            } else {
               if(var7 < 'a' || var7 > 'z') {
                  var1 = false;
                  break;
               }

               var9 = var7 - 'W';
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            final int var8 = var9 + var4 * 10;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   public static void method29(final IndexDataBase var0) {
      class279.field3552 = var0;
   }
}
