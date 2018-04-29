package com.oldscape.client;

public final class BoundingBox2D extends BoundingBox {
   static SpritePixels minimapSprite;
   static int field248;
   private final int xMin;
   private final int yMin;
   private final int xMax;
   private final int yMax;
   private final int color;

   BoundingBox2D(final int xMin, final int yMin, final int xMax, final int yMax, final int color) {
      this.xMin = xMin;
      this.yMin = yMin;
      this.xMax = xMax;
      this.yMax = yMax;
      this.color = color;
   }

   public final void vmethod46() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   static LoginPacket[] method37() {
      return new LoginPacket[]{LoginPacket.field2485, LoginPacket.field2486, LoginPacket.field2483, LoginPacket.field2488};
   }

   static void method36() {
      if(class71.soundSystem1 != null) {
         class71.soundSystem1.method2197();
      }

      if(Client.soundSystem0 != null) {
         Client.soundSystem0.method2197();
      }

   }

   static void method32() {
      if(Client.field960 == 1) {
         Client.field1061 = true;
      }

   }
}
