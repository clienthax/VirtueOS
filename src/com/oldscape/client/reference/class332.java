package com.oldscape.client.reference;

class class332 {
    static int indexedSpriteCount;
    static int indexedSpriteWidth;
    static int indexedSpriteHeight;
    static int[] indexedSpriteOffsetXs;
    static int[] indexedSpriteHeights;
    static int[] indexedSpritePalette;
    static byte[][] spritePixels;
    static int[] indexedSpriteOffsetYs;
    static int[] indexSpriteWidths;

    public static SpritePixels method817(final IndexDataBase var0, final int var1, final int var2) {
        if (!RunException.method3215(var0, var1, var2)) {
            return null;
        } else {
            final SpritePixels spritePixels = new SpritePixels();
            spritePixels.maxWidth = indexedSpriteWidth;
            spritePixels.maxHeight = indexedSpriteHeight;
            spritePixels.offsetX = indexedSpriteOffsetXs[0];
            spritePixels.offsetY = indexedSpriteOffsetYs[0];
            spritePixels.width = indexSpriteWidths[0];
            spritePixels.height = indexedSpriteHeights[0];
            final int var5 = spritePixels.width * spritePixels.height;
            final byte[] var6 = class332.spritePixels[0];
            spritePixels.pixels = new int[var5];

            for (int var7 = 0; var7 < var5; ++var7) {
                spritePixels.pixels[var7] = indexedSpritePalette[var6[var7] & 255];
            }

            clearSprites();
            return spritePixels;
        }
    }

    static void clearSprites() {
        indexedSpriteOffsetXs = null;
        indexedSpriteOffsetYs = null;
        indexSpriteWidths = null;
        indexedSpriteHeights = null;
        indexedSpritePalette = null;
        spritePixels = null;
    }

}
