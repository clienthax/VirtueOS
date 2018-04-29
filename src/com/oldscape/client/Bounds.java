package com.oldscape.client;

class Bounds {
   static int field3945;
   public int field3943;
   public int field3941;
   public int field3942;
   public int field3944;

   public Bounds(final int x1, final int y1, final int x2, final int y2) {
      this.method5675(x1, y1);
      this.method5676(x2, y2);
   }

   public Bounds(final int x, final int y) {
      this(0, 0, x, y);
   }

   public void method5675(final int x, final int y) {
      this.field3943 = x;
      this.field3941 = y;
   }

   public void method5676(final int x, final int y) {
      this.field3942 = x;
      this.field3944 = y;
   }

   public void method5680(final Bounds bounds, final Bounds bounds1) {
      this.method5678(bounds, bounds1);
      this.method5694(bounds, bounds1);
   }

   private void method5678(final Bounds var1, final Bounds var2) {
      var2.field3943 = this.field3943;
      var2.field3942 = this.field3942;
      if(this.field3943 < var1.field3943) {
         var2.field3942 -= var1.field3943 - this.field3943;
         var2.field3943 = var1.field3943;
      }

      if(var2.method5683() > var1.method5683()) {
         var2.field3942 -= var2.method5683() - var1.method5683();
      }

      if(var2.field3942 < 0) {
         var2.field3942 = 0;
      }

   }

   private void method5694(final Bounds var1, final Bounds var2) {
      var2.field3941 = this.field3941;
      var2.field3944 = this.field3944;
      if(this.field3941 < var1.field3941) {
         var2.field3944 -= var1.field3941 - this.field3941;
         var2.field3941 = var1.field3941;
      }

      if(var2.method5681() > var1.method5681()) {
         var2.field3944 -= var2.method5681() - var1.method5681();
      }

      if(var2.field3944 < 0) {
         var2.field3944 = 0;
      }

   }

   private int method5683() {
      return this.field3942 + this.field3943;
   }

   private int method5681() {
      return this.field3941 + this.field3944;
   }

   public String toString() {
      return null;
   }
}
