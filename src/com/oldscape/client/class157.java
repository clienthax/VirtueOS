package com.oldscape.client;

class class157 extends class297 {
   private final boolean field2168;

   public class157(final boolean var1) {
      this.field2168 = var1;
   }

   private int doCompare(final ChatPlayer var1, final ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2168?var1.getCurrentName().compareCleanName(var2.getCurrentName()):var2.getCurrentName().compareCleanName(var1.getCurrentName())): this.doCompare(var1, var2);
   }

   public int compare(final Object var1, final Object var2) {
      return this.doCompare((ChatPlayer)var1, (ChatPlayer)var2);
   }
}
