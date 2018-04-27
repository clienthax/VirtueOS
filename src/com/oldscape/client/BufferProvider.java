package com.oldscape.client;

public abstract class BufferProvider {
   public int[] pixels;
   public int width;
   public int height;

   public abstract void drawFull(int var1, int var2);

   public abstract void draw(int var1, int var2, int var3, int var4);

   public final void setRaster() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }
}
