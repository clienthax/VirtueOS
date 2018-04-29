package com.oldscape.client;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

class class185 {

   public static SpritePixels method3448(final byte[] var0) {
      final BufferedImage var1;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         final int width = var1.getWidth();
         final int height = var1.getHeight();
         final int[] pixels = new int[height * width];
         final PixelGrabber pixelGrabber = new PixelGrabber(var1, 0, 0, width, height, pixels, 0, width);
         pixelGrabber.grabPixels();
         return new SpritePixels(pixels, width, height);
      } catch (final IOException | InterruptedException ignored) {
      }

       return new SpritePixels(0, 0);
   }

   public static char method3443(final char var0) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
