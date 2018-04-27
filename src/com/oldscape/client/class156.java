package com.oldscape.client;

public class class156 extends class297 {
   static IndexDataBase field2167;
   final boolean field2165;

   public class156(boolean var1) {
      this.field2165 = var1;
   }

   int method3167(ChatPlayer var1, ChatPlayer var2) {
      return var2.rank != var1.rank?(this.field2165?var1.rank - var2.rank:var2.rank - var1.rank):this.method5282(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3167((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
