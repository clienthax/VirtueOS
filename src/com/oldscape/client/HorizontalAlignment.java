package com.oldscape.client;

public enum HorizontalAlignment implements Enumerated {
   field3698(2, 0),
   field3702(0, 1),
   field3699(1, 2);

   static int field3697;
   public final int value;
   final int field3701;

   HorizontalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3701 = var4;
   }

   public int rsOrdinal() {
      return this.field3701;
   }
}
