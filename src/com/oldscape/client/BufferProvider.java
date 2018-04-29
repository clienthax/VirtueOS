package com.oldscape.client;

public abstract class BufferProvider {
   public int[] pixels;
   public int width;
   public int height;

   public abstract void drawFull(int x, int y);

   public abstract void draw(int clipX, int clipY, int clipWidth, int clipHeight);

   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}
