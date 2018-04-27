package com.oldscape.client;

public final class BoundingBox2D extends BoundingBox {
   static SpritePixels minimapSprite;
   static int field248;
   public static short[] field246;
   final int xMin;
   final int yMin;
   final int xMax;
   final int yMax;
   final int color;

   BoundingBox2D(int var1, int var2, int var3, int var4, int var5) {
      this.xMin = var1;
      this.yMin = var2;
      this.xMax = var3;
      this.yMax = var4;
      this.color = var5;
   }

   public final void vmethod46() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   static LoginPacket[] method37() {
      return new LoginPacket[]{LoginPacket.field2485, LoginPacket.field2486, LoginPacket.field2483, LoginPacket.field2488};
   }

   static final void method36() {
      if(class71.soundSystem1 != null) {
         class71.soundSystem1.method2197();
      }

      if(class155.soundSystem0 != null) {
         class155.soundSystem0.method2197();
      }

   }

   static void method32() {
      if(Client.field960 == 1) {
         Client.field1061 = true;
      }

   }
}
