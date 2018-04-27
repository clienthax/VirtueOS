package com.oldscape.client;

public class Size {
   public static final Size field371;
   public static final Size field363;
   public static final Size field368;
   public static CacheFile[] idxFiles;
   static int field369;
   static IndexData configsIndex;
   static Task field364;
   final String field365;
   final int field362;
   final int field367;
   final int field372;

   static {
      field371 = new Size("SMALL", 1, 0, 4);
      field363 = new Size("MEDIUM", 0, 1, 2);
      field368 = new Size("LARGE", 2, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field365 = var1;
      this.field362 = var2;
      this.field367 = var3;
      this.field372 = var4;
   }

   boolean method192(float var1) {
      return var1 >= (float)this.field372;
   }

   static Size method195(int var0) {
      Size[] var1 = new Size[]{field368, field371, field363};
      Size[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Size var4 = var2[var3];
         if(var0 == var4.field367) {
            return var4;
         }
      }

      return null;
   }

   static final void method199() {
      Object var10000 = null;
      String var0 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
      class57.sendGameMessage(30, "", var0);
   }

   static void method198() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuBooleanArray[0] = false;
      Client.menuOptionCount = 1;
   }
}
