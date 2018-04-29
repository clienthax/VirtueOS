package com.oldscape.client;

class class153 extends class297 {
   private final boolean field2155;

   public class153(final boolean var1) {
      this.field2155 = var1;
   }

   private int method3141(final ChatPlayer var1, final ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2155?var1.field3845 - var2.field3845:var2.field3845 - var1.field3845):this.doCompare(var1, var2);
   }

   public int compare(final Object var1, final Object var2) {
      return this.method3141((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
