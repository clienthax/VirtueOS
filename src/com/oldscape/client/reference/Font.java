package com.oldscape.client.reference;

public final class Font extends FontTypeFace {
    public Font(final byte[] var1, final int[] var2, final int[] var3, final int[] var4, final int[] var5, final byte[][] var7) {
        super(var1, var2, var3, var4, var5, var7);
    }

    public Font(final byte[] var1) {
        super(var1);
    }

    final void renderRGB(final byte[] var1, int var2, int var3, int var4, int var5, final int var6) {
        int var7 = var3 * graphicsPixelsWidth + var2;
        int var8 = graphicsPixelsWidth - var4;
        int var9 = 0;
        int var10 = 0;
        int var11;
        if (var3 < drawingAreaTop) {
            var11 = drawingAreaTop - var3;
            var5 -= var11;
            var3 = drawingAreaTop;
            var10 += var11 * var4;
            var7 += var11 * graphicsPixelsWidth;
        }

        if (var3 + var5 > drawingAreaRight) {
            var5 -= var3 + var5 - drawingAreaRight;
        }

        if (var2 < draw_region_x) {
            var11 = draw_region_x - var2;
            var4 -= var11;
            var2 = draw_region_x;
            var10 += var11;
            var7 += var11;
            var9 += var11;
            var8 += var11;
        }

        if (var2 + var4 > drawingAreaBottom) {
            var11 = var2 + var4 - drawingAreaBottom;
            var4 -= var11;
            var9 += var11;
            var8 += var11;
        }

        if (var4 > 0 && var5 > 0) {
            render(graphicsPixels, var1, var6, var10, var7, var4, var5, var8, var9);
        }
    }

    final void renderRGBA(final byte[] var1, int var2, int var3, int var4, int var5, final int var6, final int var7) {
        int var8 = var3 * graphicsPixelsWidth + var2;
        int var9 = graphicsPixelsWidth - var4;
        int var10 = 0;
        int var11 = 0;
        int var12;
        if (var3 < drawingAreaTop) {
            var12 = drawingAreaTop - var3;
            var5 -= var12;
            var3 = drawingAreaTop;
            var11 += var12 * var4;
            var8 += var12 * graphicsPixelsWidth;
        }

        if (var3 + var5 > drawingAreaRight) {
            var5 -= var3 + var5 - drawingAreaRight;
        }

        if (var2 < draw_region_x) {
            var12 = draw_region_x - var2;
            var4 -= var12;
            var2 = draw_region_x;
            var11 += var12;
            var8 += var12;
            var10 += var12;
            var9 += var12;
        }

        if (var2 + var4 > drawingAreaBottom) {
            var12 = var2 + var4 - drawingAreaBottom;
            var4 -= var12;
            var10 += var12;
            var9 += var12;
        }

        if (var4 > 0 && var5 > 0) {
            renderRGBA(graphicsPixels, var1, var6, var11, var8, var4, var5, var9, var10, var7);
        }
    }
}
