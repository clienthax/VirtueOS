package com.oldscape.client;

import java.util.Comparator;

public class class321 implements Comparator {
   static SpritePixels field3938;
   final boolean field3937;

   public class321(boolean var1) {
      this.field3937 = var1;
   }

   int method5655(Nameable var1, Nameable var2) {
      return this.field3937?var1.vmethod5448(var2):var2.vmethod5448(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method5655((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
