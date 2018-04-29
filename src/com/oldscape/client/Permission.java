package com.oldscape.client;

public enum Permission implements Enumerated {
   field3350(0, -1, false, true),
   field3344(1, 0, true, true),
   field3345(2, 1, true, false),
   field3346(3, 2, false, true),
   field3347(4, 3, false, true),
   field3349(5, 10, false, true);

   final int field3343;
   public final int field3348;
   public final boolean field3351;
   public final boolean field3352;

   Permission(final int var3, final int var4, final boolean var6, final boolean var7) {
      this.field3343 = var3;
      this.field3348 = var4;
      this.field3351 = var6;
      this.field3352 = var7;
   }

   public int rsOrdinal() {
      return this.field3343;
   }

}
