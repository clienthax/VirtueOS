package com.oldscape.client;

public class Friend extends ChatPlayer {
   static IndexDataBase field3864;
   boolean field3862;
   boolean field3861;

   private int method5445(final Friend var1) {
      return super.world == Client.world && Client.world != var1.world?-1:(Client.world == var1.world && super.world != Client.world?1:(super.world != 0 && var1.world == 0?-1:(var1.world != 0 && super.world == 0?1:(this.field3862 && !var1.field3862?-1:(!this.field3862 && var1.field3862?1:(this.field3861 && !var1.field3861?-1:(!this.field3861 && var1.field3861?1:(super.world != 0?super.field3845 - var1.field3845:var1.field3845 - super.field3845))))))));
   }

   public int doCompare(final Nameable var1) {
      return this.method5445((Friend)var1);
   }

   public int compareTo(final Object var1) {
      return this.method5445((Friend)var1);
   }
}
