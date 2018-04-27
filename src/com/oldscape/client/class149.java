package com.oldscape.client;

import java.util.Comparator;

public class class149 implements Comparator {
   final boolean field2141;

   public class149(boolean var1) {
      this.field2141 = var1;
   }

   int method3099(ChatPlayer var1, ChatPlayer var2) {
      return this.field2141?var1.field3845 - var2.field3845:var2.field3845 - var1.field3845;
   }

   public int compare(Object var1, Object var2) {
      return this.method3099((ChatPlayer)var1, (ChatPlayer)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public static final void method3104(int var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox2D(var0, var1, var2, var3, var4));
   }
}
