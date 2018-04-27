package com.oldscape.client;

public class NanoTimer extends Timer {
   long nanoTime;

   public NanoTimer() {
      this.nanoTime = System.nanoTime();
   }

   public void vmethod3326() {
      this.nanoTime = System.nanoTime();
   }

   public int vmethod3328(int var1, int var2) {
      long var3 = (long)var2 * 1000000L;
      long var5 = this.nanoTime - System.nanoTime();
      if(var5 < var3) {
         var5 = var3;
      }

      ScriptVarType.method11(var5 / 1000000L);
      long var7 = System.nanoTime();

      int var9;
      for(var9 = 0; var9 < 10 && (var9 < 1 || this.nanoTime < var7); this.nanoTime += (long)var1 * 1000000L) {
         ++var9;
      }

      if(this.nanoTime < var7) {
         this.nanoTime = var7;
      }

      return var9;
   }
}
