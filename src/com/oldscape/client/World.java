package com.oldscape.client;

class World {
   static World[] worldList;
   static int worldCount;
   static int field1228;
   static int[] field1229;
   static int[] field1230;
   static IndexedSprite[] slStarSprites;
   int id;
   int mask;
   int playerCount;
   String address;
   String activity;
   int location;
   int index;

   static {
      worldCount = 0;
      field1228 = 0;
      field1229 = new int[]{1, 1, 1, 1};
      field1230 = new int[]{0, 1, 2, 3};
   }

   boolean method1683() {
      return (1 & this.mask) != 0;
   }

   boolean method1684() {
      return (2 & this.mask) != 0;
   }

   boolean method1685() {
      return (4 & this.mask) != 0;
   }

   boolean method1686() {
      return (8 & this.mask) != 0;
   }

   boolean method1687() {
      return (536870912 & this.mask) != 0;
   }

   boolean method1688() {
      return (33554432 & this.mask) != 0;
   }

   public static void method1723(final Model var0, final int var1, final int var2, final int var3) {
      if(Model.boundingBox3DContainsMouse(var0, var1, var2, var3)) {
         class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, -65281));
      } else if(class7.boundingBox3DDrawMode == BoundingBox3DDrawMode.ALWAYS) {
         class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, -16776961));
      }

   }

   public static int method1701(final int var0, final int var1) {
      final int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   public static void method1724(final boolean var0) {
      if(var0 != class158.isMembersWorld) {
         ItemComposition.items.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         class158.isMembersWorld = var0;
      }

   }

   static boolean method1722() {
      return (Client.playerNameMask & 2) != 0;
   }
}
