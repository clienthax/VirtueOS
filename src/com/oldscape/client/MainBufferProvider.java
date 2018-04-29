package com.oldscape.client;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class MainBufferProvider extends BufferProvider {
   private Component component;
   private final Image image;

   MainBufferProvider(final int width, final int height, final Component component) {
      super.width = width;
      super.height = height;
      super.pixels = new int[height * width + 1];
      final DataBufferInt dataBufferInt = new DataBufferInt(super.pixels, super.pixels.length);
      final DirectColorModel directColorModel = new DirectColorModel(32, 16711680, 65280, 255);
      final WritableRaster writableRaster = Raster.createWritableRaster(directColorModel.createCompatibleSampleModel(super.width, super.height), dataBufferInt, null);
      this.image = new BufferedImage(directColorModel, writableRaster, false, new Hashtable());
      this.replaceComponent(component);
      this.setRaster();
   }

   final void replaceComponent(final Component component) {
      this.component = component;
   }

   public final void drawFull(final int x, final int y) {
      this.draw(this.component.getGraphics(), x, y);
   }

   public final void draw(final int clipX, final int clipY, final int clipWidth, final int clipHeight) {
      this.drawSub(this.component.getGraphics(), clipX, clipY, clipWidth, clipHeight);
   }

   private void draw(final Graphics graphics, final int x, final int y) {
      try {
         graphics.drawImage(this.image, x, y, this.component);
      } catch (final Exception e) {
         this.component.repaint();
      }

   }

   private void drawSub(final Graphics graphics, final int clipX, final int clipY, final int clipWidth, final int clipHeight) {
      try {
         final Shape clip = graphics.getClip();
         graphics.clipRect(clipX, clipY, clipWidth, clipHeight);
         graphics.drawImage(this.image, 0, 0, this.component);
         graphics.setClip(clip);
      } catch (final Exception e) {
         this.component.repaint();
      }

   }
}
