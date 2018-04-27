package com.oldscape.client;

public enum Permission implements Enumerated {
   field3350(0, -1, true, false, true),
   field3344(1, 0, true, true, true),
   field3345(2, 1, true, true, false),
   field3346(3, 2, false, false, true),
   field3347(4, 3, false, false, true),
   field3349(5, 10, false, false, true);

   final int field3343;
   public final int field3348;
   public final boolean field3351;
   public final boolean field3352;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3343 = var3;
      this.field3348 = var4;
      this.field3351 = var6;
      this.field3352 = var7;
   }

   public int rsOrdinal() {
      return this.field3343;
   }

   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }
}
