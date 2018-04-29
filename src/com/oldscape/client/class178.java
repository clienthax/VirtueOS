package com.oldscape.client;

abstract class class178 {
   public int field2296;
   public int field2293;
   public int field2294;
   public int field2295;

   protected abstract boolean vmethod3428(int var1, int var2, int var3, CollisionData collisionData);

   static Script method3431(final class245 var0, final int var1, final int var2) {
      final int var3 = (var1 << 8) + var0.ordinal;
      Script var5 = WorldMapType3.method233(var3);
       if (var5 == null) {
           final int var6 = var0.ordinal + (var2 + 40000 << 8);
           var5 = WorldMapType3.method233(var6);
       }
       return var5;
   }

}
