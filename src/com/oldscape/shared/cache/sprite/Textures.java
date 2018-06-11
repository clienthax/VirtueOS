/**
 * Copyright (c) Kyle Fricilone
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.shared.cache.sprite;

import com.oldscape.shared.cache.Archive;
import com.oldscape.shared.cache.Cache;
import com.oldscape.shared.cache.Container;
import com.oldscape.shared.cache.ReferenceTable;
import com.oldscape.shared.cache.ReferenceTable.ChildEntry;
import com.oldscape.shared.cache.ReferenceTable.Entry;
import com.oldscape.shared.cache.type.CacheIndex;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kyle Friz
 * @since Jan 27, 2016
 */
public class Textures {

    private static Logger logger = Logger.getLogger(Textures.class.getName());

    private static int[] colors;

    public static void initialize(Cache cache) {
        int count = 0;
        try {
            ReferenceTable table = cache.getReferenceTable(CacheIndex.TEXTURES);
            Entry entry = table.getEntry(0);
            Archive archive = Archive.decode(cache.read(CacheIndex.TEXTURES, 0).getData(), entry.size());

            int[] ids = new int[entry.capacity()];
            colors = new int[entry.capacity()];
            for (int id = 0; id < entry.capacity(); id++) {
                ChildEntry child = entry.getEntry(id);
                if (child == null)
                    continue;

                ByteBuffer buffer = archive.getEntry(child.index());
                Texture texture = Texture.decode(buffer);
                ids[id] = texture.getIds(0);
                count++;
            }

            table = cache.getReferenceTable(CacheIndex.SPRITES);
            for (int id = 0; id < entry.capacity(); id++) {
                int file = ids[id];

                Entry e = table.getEntry(file);
                if (e == null)
                    continue;

                Container containers = cache.read(8, file);
                Sprite sprite = Sprite.decode(containers.getData());
                BufferedImage img = sprite.getFrame(0);
                int width = img.getWidth();
                int height = img.getHeight();
                int[] pixels = new int[width * height];
                PixelGrabber pixelgrabber = new PixelGrabber(img, 0, 0, width, height, pixels, 0, width);
                try {
                    pixelgrabber.grabPixels();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                colors[id] = averageColorForPixels(pixels);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error Loading Texture(s)!", e);
        }
        logger.info("Loaded " + count + " Texture(s)!");
    }

    private static int averageColorForPixels(int[] pixels) {
        int redTotal = 0;
        int greenTotal = 0;
        int blueTotal = 0;
        int totalPixels = pixels.length;

        for (int i = 0; i < totalPixels; i++) {
            if (pixels[i] == 0xff00ff) {
                totalPixels--;
                continue;
            }

            redTotal += pixels[i] >> 16 & 0xff;
            greenTotal += pixels[i] >> 8 & 0xff;
            blueTotal += pixels[i] & 0xff;
        }

        int averageRGB = (redTotal / totalPixels << 16) + (greenTotal / totalPixels << 8) + blueTotal / totalPixels;
        if (averageRGB == 0) {
            averageRGB = 1;
        }

        return averageRGB;
    }

    public static int getColors(int i) {
        return colors[i];
    }

}
