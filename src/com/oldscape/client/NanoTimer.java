package com.oldscape.client;

public class NanoTimer extends Timer {
   private long nanoTime;

   public NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   public void vmethod3326() {
      this.nanoTime = System.nanoTime();
   }

   public int vmethod3328(final int var1, final int var2) {
      final long var3 = var2 * 1000000L;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      ScriptVarType.method11(var5 / 1000000L);
      final long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.nanoTime < var7); this.nanoTime += var1 * 1000000L) {
         ++var9;
      }

      if(this.nanoTime < var7) {
         this.nanoTime = var7;
      }

      return var9;
   }
}
