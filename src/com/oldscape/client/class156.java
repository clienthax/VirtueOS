package com.oldscape.client;

class class156 extends class297 {
   static IndexDataBase field2167;
   private final boolean field2165;

   public class156(final boolean var1) {
      this.field2165 = var1;
   }

   private int method3167(final ChatPlayer var1, final ChatPlayer var2) {
      return var2.rank != var1.rank?(this.field2165?var1.rank - var2.rank:var2.rank - var1.rank):this.doCompare(var1, var2);
   }

   public int compare(final Object var1, final Object var2) {
      return this.method3167((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
