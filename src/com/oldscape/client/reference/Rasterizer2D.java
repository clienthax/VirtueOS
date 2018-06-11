package com.oldscape.client.reference;

class Rasterizer2D extends CacheableNode {
    public static int[] graphicsPixels;
    public static int graphicsPixelsWidth;
    public static int graphicsPixelsHeight;
    public static int drawingAreaTop;
    public static int drawingAreaRight;
    public static int draw_region_x;
    static int drawingAreaBottom;

    static {
        drawingAreaTop = 0;
        drawingAreaRight = 0;
        draw_region_x = 0;
        drawingAreaBottom = 0;
    }

    public static void setRasterBuffer(final int[] var0, final int var1, final int var2) {
        graphicsPixels = var0;
        graphicsPixelsWidth = var1;
        graphicsPixelsHeight = var2;
        setDrawRegion(0, 0, var1, var2);
    }

    public static void noClip() {
        draw_region_x = 0;
        drawingAreaTop = 0;
        drawingAreaBottom = graphicsPixelsWidth;
        drawingAreaRight = graphicsPixelsHeight;
    }

    public static void setDrawRegion(int var0, int var1, int var2, int var3) {
        if (var0 < 0) {
            var0 = 0;
        }

        if (var1 < 0) {
            var1 = 0;
        }

        if (var2 > graphicsPixelsWidth) {
            var2 = graphicsPixelsWidth;
        }

        if (var3 > graphicsPixelsHeight) {
            var3 = graphicsPixelsHeight;
        }

        draw_region_x = var0;
        drawingAreaTop = var1;
        drawingAreaBottom = var2;
        drawingAreaRight = var3;
    }

    public static void setInnerDrawRegion(final int var0, final int var1, final int var2, final int var3) {
        if (draw_region_x < var0) {
            draw_region_x = var0;
        }

        if (drawingAreaTop < var1) {
            drawingAreaTop = var1;
        }

        if (drawingAreaBottom > var2) {
            drawingAreaBottom = var2;
        }

        if (drawingAreaRight > var3) {
            drawingAreaRight = var3;
        }

    }

    public static void copyDrawRegion(final int[] var0) {
        var0[0] = draw_region_x;
        var0[1] = drawingAreaTop;
        var0[2] = drawingAreaBottom;
        var0[3] = drawingAreaRight;
    }

    public static void setDrawRegion(final int[] var0) {
        draw_region_x = var0[0];
        drawingAreaTop = var0[1];
        drawingAreaBottom = var0[2];
        drawingAreaRight = var0[3];
    }

    public static void reset() {
        int var0 = 0;

        int var1;
        for (var1 = graphicsPixelsWidth * graphicsPixelsHeight - 7; var0 < var1; graphicsPixels[var0++] = 0) {
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
            graphicsPixels[var0++] = 0;
        }

        for (var1 += 7; var0 < var1; graphicsPixels[var0++] = 0) {
        }

    }

    private static void method5719(final int var0, int var1, int var2, final int var3) {
        if (var2 == 0) {
            Rasterizer2D_setPixel(var0, var1, var3);
        } else {
            if (var2 < 0) {
                var2 = -var2;
            }

            int var4 = var1 - var2;
            if (var4 < drawingAreaTop) {
                var4 = drawingAreaTop;
            }

            int var5 = var2 + var1 + 1;
            if (var5 > drawingAreaRight) {
                var5 = drawingAreaRight;
            }

            int var6 = var4;
            final int var7 = var2 * var2;
            int var8 = 0;
            int var9 = var1 - var4;
            int var10 = var9 * var9;
            int var11 = var10 - var9;
            if (var1 > var5) {
                var1 = var5;
            }

            int var12;
            int var13;
            int var14;
            int var15;
            while (var6 < var1) {
                while (var11 <= var7 || var10 <= var7) {
                    var10 = var10 + var8 + var8;
                    var11 += var8++ + var8;
                }

                var12 = var0 - var8 + 1;
                if (var12 < draw_region_x) {
                    var12 = draw_region_x;
                }

                var13 = var0 + var8;
                if (var13 > drawingAreaBottom) {
                    var13 = drawingAreaBottom;
                }

                var14 = var12 + var6 * graphicsPixelsWidth;

                for (var15 = var12; var15 < var13; ++var15) {
                    graphicsPixels[var14++] = var3;
                }

                ++var6;
                var10 -= var9-- + var9;
                var11 -= var9 + var9;
            }

            var8 = var2;
            var9 = var6 - var1;
            var11 = var7 + var9 * var9;
            var10 = var11 - var2;

            for (var11 -= var9; var6 < var5; var10 += var9++ + var9) {
                while (var11 > var7 && var10 > var7) {
                    var11 -= var8-- + var8;
                    var10 -= var8 + var8;
                }

                var12 = var0 - var8;
                if (var12 < draw_region_x) {
                    var12 = draw_region_x;
                }

                var13 = var0 + var8;
                if (var13 > drawingAreaBottom - 1) {
                    var13 = drawingAreaBottom - 1;
                }

                var14 = var12 + var6 * graphicsPixelsWidth;

                for (var15 = var12; var15 <= var13; ++var15) {
                    graphicsPixels[var14++] = var3;
                }

                ++var6;
                var11 = var11 + var9 + var9;
            }

        }
    }

    public static void method5720(final int var0, int var1, int var2, final int var3, final int var4) {
        if (var4 != 0) {
            if (var4 == 256) {
                method5719(var0, var1, var2, var3);
            } else {
                if (var2 < 0) {
                    var2 = -var2;
                }

                final int var5 = 256 - var4;
                final int var6 = (var3 >> 16 & 255) * var4;
                final int var7 = (var3 >> 8 & 255) * var4;
                final int var8 = var4 * (var3 & 255);
                int var12 = var1 - var2;
                if (var12 < drawingAreaTop) {
                    var12 = drawingAreaTop;
                }

                int var13 = var2 + var1 + 1;
                if (var13 > drawingAreaRight) {
                    var13 = drawingAreaRight;
                }

                int var14 = var12;
                final int var15 = var2 * var2;
                int var16 = 0;
                int var17 = var1 - var12;
                int var18 = var17 * var17;
                int var19 = var18 - var17;
                if (var1 > var13) {
                    var1 = var13;
                }

                int var9;
                int var10;
                int var11;
                int var20;
                int var21;
                int var22;
                int var23;
                int var24;
                while (var14 < var1) {
                    while (var19 <= var15 || var18 <= var15) {
                        var18 = var18 + var16 + var16;
                        var19 += var16++ + var16;
                    }

                    var20 = var0 - var16 + 1;
                    if (var20 < draw_region_x) {
                        var20 = draw_region_x;
                    }

                    var21 = var0 + var16;
                    if (var21 > drawingAreaBottom) {
                        var21 = drawingAreaBottom;
                    }

                    var22 = var20 + var14 * graphicsPixelsWidth;

                    for (var23 = var20; var23 < var21; ++var23) {
                        var9 = var5 * (graphicsPixels[var22] >> 16 & 255);
                        var10 = (graphicsPixels[var22] >> 8 & 255) * var5;
                        var11 = var5 * (graphicsPixels[var22] & 255);
                        var24 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                        graphicsPixels[var22++] = var24;
                    }

                    ++var14;
                    var18 -= var17-- + var17;
                    var19 -= var17 + var17;
                }

                var16 = var2;
                var17 = -var17;
                var19 = var15 + var17 * var17;
                var18 = var19 - var2;

                for (var19 -= var17; var14 < var13; var18 += var17++ + var17) {
                    while (var19 > var15 && var18 > var15) {
                        var19 -= var16-- + var16;
                        var18 -= var16 + var16;
                    }

                    var20 = var0 - var16;
                    if (var20 < draw_region_x) {
                        var20 = draw_region_x;
                    }

                    var21 = var0 + var16;
                    if (var21 > drawingAreaBottom - 1) {
                        var21 = drawingAreaBottom - 1;
                    }

                    var22 = var20 + var14 * graphicsPixelsWidth;

                    for (var23 = var20; var23 <= var21; ++var23) {
                        var9 = var5 * (graphicsPixels[var22] >> 16 & 255);
                        var10 = (graphicsPixels[var22] >> 8 & 255) * var5;
                        var11 = var5 * (graphicsPixels[var22] & 255);
                        var24 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                        graphicsPixels[var22++] = var24;
                    }

                    ++var14;
                    var19 = var19 + var17 + var17;
                }

            }
        }
    }

    public static void fillRectangle(int var0, int var1, int var2, int var3, int var4, final int var5) {
        if (var0 < draw_region_x) {
            var2 -= draw_region_x - var0;
            var0 = draw_region_x;
        }

        if (var1 < drawingAreaTop) {
            var3 -= drawingAreaTop - var1;
            var1 = drawingAreaTop;
        }

        if (var0 + var2 > drawingAreaBottom) {
            var2 = drawingAreaBottom - var0;
        }

        if (var3 + var1 > drawingAreaRight) {
            var3 = drawingAreaRight - var1;
        }

        var4 = (var5 * (var4 & 16711935) >> 8 & 16711935) + (var5 * (var4 & 65280) >> 8 & 65280);
        final int var6 = 256 - var5;
        final int var7 = graphicsPixelsWidth - var2;
        int var8 = var0 + graphicsPixelsWidth * var1;

        for (int var9 = 0; var9 < var3; ++var9) {
            for (int var10 = -var2; var10 < 0; ++var10) {
                int var11 = graphicsPixels[var8];
                var11 = ((var11 & 16711935) * var6 >> 8 & 16711935) + (var6 * (var11 & 65280) >> 8 & 65280);
                graphicsPixels[var8++] = var11 + var4;
            }

            var8 += var7;
        }

    }

    public static void Rasterizer2D_fillRectangle(int var0, int var1, int var2, int var3, final int var4) {
        if (var0 < draw_region_x) {
            var2 -= draw_region_x - var0;
            var0 = draw_region_x;
        }

        if (var1 < drawingAreaTop) {
            var3 -= drawingAreaTop - var1;
            var1 = drawingAreaTop;
        }

        if (var0 + var2 > drawingAreaBottom) {
            var2 = drawingAreaBottom - var0;
        }

        if (var3 + var1 > drawingAreaRight) {
            var3 = drawingAreaRight - var1;
        }

        final int var5 = graphicsPixelsWidth - var2;
        int var6 = var0 + graphicsPixelsWidth * var1;

        for (int var7 = -var3; var7 < 0; ++var7) {
            for (int var8 = -var2; var8 < 0; ++var8) {
                graphicsPixels[var6++] = var4;
            }

            var6 += var5;
        }

    }

    public static void method5723(int var0, int var1, int var2, int var3, final int var4, final int var5, final int var6, final int var7) {
        if (var2 > 0 && var3 > 0) {
            int var8 = 0;
            final int var9 = var5 == var4 && var7 == var6 ? -1 : 65536 / var3;
            int var10 = var6;
            int var11 = 256 - var6;
            int var12 = var4;
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var1 < drawingAreaTop) {
                var8 += (drawingAreaTop - var1) * var9;
                var3 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            if (var3 + var1 > drawingAreaRight) {
                var3 = drawingAreaRight - var1;
            }

            final int var13 = graphicsPixelsWidth - var2;
            int var14 = var0 + graphicsPixelsWidth * var1;

            for (int var15 = -var3; var15 < 0; ++var15) {
                int var16;
                int var17;
                for (var16 = -var2; var16 < 0; ++var16) {
                    var17 = graphicsPixels[var14];
                    final int var18 = var12 + var17;
                    final int var19 = (var12 & 16711935) + (var17 & 16711935);
                    final int var20 = (var19 & 16777472) + (var18 - var19 & 65536);
                    if (var11 == 0) {
                        graphicsPixels[var14++] = var18 - var20 | var20 - (var20 >>> 8);
                    } else {
                        final int var21 = var18 - var20 | var20 - (var20 >>> 8);
                        graphicsPixels[var14++] = ((var21 & 16711935) * var10 >> 8 & 16711935) + ((var17 & 16711935) * var11 >> 8 & 16711935) + (var10 * (var21 & 65280) >> 8 & 65280) + (var11 * (var17 & 65280) >> 8 & 65280);
                    }
                }

                if (var9 > 0) {
                    var8 += var9;
                    var16 = 65536 - var8 >> 8;
                    var17 = var8 >> 8;
                    if (var7 != var6) {
                        var10 = (65536 - var8) * var6 + var8 * var7 >> 16;
                        var11 = 256 - var10;
                    }

                    if (var5 != var4) {
                        var12 = (var17 * (var5 & 16711935) + var16 * (var4 & 16711935) & -16711936) + (var17 * (var5 & 65280) + var16 * (var4 & 65280) & 16711680) >>> 8;
                    }
                }

                var14 += var13;
            }

        }
    }

    public static void method5742(int var0, int var1, int var2, int var3, final int var4, final int var5, final int var6, final int var7) {
        if (var2 > 0 && var3 > 0) {
            int var8 = 0;
            final int var9 = var5 == var4 && var7 == var6 ? -1 : 65536 / var3;
            int var10 = var6;
            int var11 = 256 - var6;
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var1 < drawingAreaTop) {
                var8 += (drawingAreaTop - var1) * var9;
                var3 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            if (var3 + var1 > drawingAreaRight) {
                var3 = drawingAreaRight - var1;
            }

            int var12 = var4 >> 16;
            int var13 = (var4 & 65280) >> 8;
            int var14 = var4 & 255;
            final int var18 = graphicsPixelsWidth - var2;
            int var19 = var0 + graphicsPixelsWidth * var1;

            for (int var20 = 0; var20 < var3; ++var20) {
                int var21;
                int var22;
                int var23;
                for (var21 = -var2; var21 < 0; ++var21) {
                    var22 = graphicsPixels[var19];
                    var23 = var22 >> 16;
                    final int var24 = (var22 & 65280) >> 8;
                    final int var25 = var22 & 255;
                    final int var15;
                    final int var16;
                    final int var17;
                    if (var11 == 0) {
                        var15 = var23 < 127 ? var12 * var23 >> 7 : 255 - ((255 - var12) * (255 - var23) >> 7);
                        var16 = var24 < 127 ? var13 * var24 >> 7 : 255 - ((255 - var13) * (255 - var24) >> 7);
                        var17 = var25 < 127 ? var14 * var25 >> 7 : 255 - ((255 - var14) * (255 - var25) >> 7);
                    } else {
                        var15 = var23 < 127 ? var23 * var11 + (var12 * var23 * var10 >> 7) >> 8 : var10 * (255 - ((255 - var12) * (255 - var23) >> 7)) + var23 * var11 >> 8;
                        var16 = var24 < 127 ? var24 * var11 + (var13 * var24 * var10 >> 7) >> 8 : var10 * (255 - ((255 - var13) * (255 - var24) >> 7)) + var24 * var11 >> 8;
                        var17 = var25 < 127 ? var25 * var11 + (var14 * var25 * var10 >> 7) >> 8 : var10 * (255 - ((255 - var14) * (255 - var25) >> 7)) + var25 * var11 >> 8;
                    }

                    graphicsPixels[var19++] = var17 + (var16 << 8) + (var15 << 16);
                }

                if (var9 > 0) {
                    var8 += var9;
                    var21 = 65536 - var8 >> 8;
                    var22 = var8 >> 8;
                    if (var7 != var6) {
                        var10 = (65536 - var8) * var6 + var8 * var7 >> 16;
                        var11 = 256 - var10;
                    }

                    if (var5 != var4) {
                        var23 = (var22 * (var5 & 16711935) + var21 * (var4 & 16711935) & -16711936) + (var22 * (var5 & 65280) + var21 * (var4 & 65280) & 16711680) >>> 8;
                        var12 = var23 >> 16;
                        var13 = (var23 & 65280) >> 8;
                        var14 = var23 & 255;
                    }
                }

                var19 += var18;
            }

        }
    }

    public static void method5725(int var0, int var1, int var2, int var3, final int var4, final int var5, final int var6, final int var7) {
        if (var2 > 0 && var3 > 0) {
            int var8 = 0;
            final int var9 = 65536 / var3;
            int var10 = var6;
            int var11 = 256 - var6;
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var1 < drawingAreaTop) {
                var8 += (drawingAreaTop - var1) * var9;
                var3 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            if (var3 + var1 > drawingAreaRight) {
                var3 = drawingAreaRight - var1;
            }

            int var12 = var4 & 16711680;
            int var13 = var4 & 65280;
            int var14 = var4 & 255;
            int var15 = var12 * var6 >> 8;
            int var16 = var13 * var6 >> 8;
            int var17 = var14 * var6 >> 8;
            final int var18 = graphicsPixelsWidth - var2;
            int var19 = var0 + graphicsPixelsWidth * var1;

            for (int var20 = 0; var20 < var3; ++var20) {
                int var21;
                int var22;
                int var23;
                for (var21 = -var2; var21 < 0; ++var21) {
                    var22 = graphicsPixels[var19];
                    var23 = var22 & 16711680;
                    final int var24 = var23 <= var12 ? var23 : (var11 == 0 ? var12 : var15 + (var23 * var11 >> 8) & 16711680);
                    final int var25 = var22 & 65280;
                    final int var26 = var25 <= var13 ? var25 : (var11 == 0 ? var13 : var16 + (var25 * var11 >> 8) & 65280);
                    final int var27 = var22 & 255;
                    final int var28 = var27 <= var14 ? var27 : (var11 == 0 ? var14 : var17 + (var27 * var11 >> 8));
                    graphicsPixels[var19++] = var24 + var26 + var28;
                }

                if (var9 > 0) {
                    var8 += var9;
                    var21 = 65536 - var8 >> 8;
                    var22 = var8 >> 8;
                    if (var7 != var6) {
                        var10 = (65536 - var8) * var6 + var8 * var7 >> 16;
                        var11 = 256 - var10;
                    }

                    if (var5 != var4) {
                        var23 = (var22 * (var5 & 16711935) + var21 * (var4 & 16711935) & -16711936) + (var22 * (var5 & 65280) + var21 * (var4 & 65280) & 16711680) >>> 8;
                        var12 = var23 & 16711680;
                        var13 = var23 & 65280;
                        var14 = var23 & 255;
                        var15 = var12 * var10 >> 8;
                        var16 = var13 * var10 >> 8;
                        var17 = var14 * var10 >> 8;
                    }
                }

                var19 += var18;
            }

        }
    }

    public static void method5726(int var0, int var1, int var2, int var3, final int var4, final int var5, final int var6, final int var7) {
        if (var3 > 0 && var2 > 0) {
            int var8 = 0;
            final int var9 = 65536 / var3;
            int var10 = var6;
            int var11 = 256 - var6;
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var1 < drawingAreaTop) {
                var8 += (drawingAreaTop - var1) * var9;
                var3 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            if (var3 + var1 > drawingAreaRight) {
                var3 = drawingAreaRight - var1;
            }

            int var12 = var4 & 16711680;
            int var13 = var4 & 65280;
            int var14 = var4 & 255;
            int var15 = var12 * var6 >> 8;
            int var16 = var13 * var6 >> 8;
            int var17 = var14 * var6 >> 8;
            final int var18 = graphicsPixelsWidth - var2;
            int var19 = var0 + graphicsPixelsWidth * var1;

            for (int var20 = 0; var20 < var3; ++var20) {
                int var21;
                int var22;
                int var23;
                for (var21 = -var2; var21 < 0; ++var21) {
                    var22 = graphicsPixels[var19];
                    var23 = var22 & 16711680;
                    final int var24 = var23 >= var12 ? var23 : (var11 == 0 ? var12 : var15 + (var23 * var11 >> 8) & 16711680);
                    final int var25 = var22 & 65280;
                    final int var26 = var25 >= var13 ? var25 : (var11 == 0 ? var13 : var16 + (var25 * var11 >> 8) & 65280);
                    final int var27 = var22 & 255;
                    final int var28 = var27 >= var14 ? var27 : (var11 == 0 ? var14 : var17 + (var27 * var11 >> 8));
                    graphicsPixels[var19++] = var24 + var26 + var28;
                }

                if (var9 > 0) {
                    var8 += var9;
                    var21 = 65536 - var8 >> 8;
                    var22 = var8 >> 8;
                    if (var7 != var6) {
                        var10 = (65536 - var8) * var6 + var8 * var7 >> 16;
                        var11 = 256 - var10;
                    }

                    if (var5 != var4) {
                        var23 = (var22 * (var5 & 16711935) + var21 * (var4 & 16711935) & -16711936) + (var22 * (var5 & 65280) + var21 * (var4 & 65280) & 16711680) >>> 8;
                        var12 = var23 & 16711680;
                        var13 = var23 & 65280;
                        var14 = var23 & 255;
                        var15 = var12 * var10 >> 8;
                        var16 = var13 * var10 >> 8;
                        var17 = var14 * var10 >> 8;
                    }
                }

                var19 += var18;
            }

        }
    }

    public static void method5727(int var0, int var1, int var2, int var3, final int var4, final int var5) {
        if (var2 > 0 && var3 > 0) {
            int var6 = 0;
            final int var7 = 65536 / var3;
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var1 < drawingAreaTop) {
                var6 += (drawingAreaTop - var1) * var7;
                var3 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            if (var3 + var1 > drawingAreaRight) {
                var3 = drawingAreaRight - var1;
            }

            final int var8 = graphicsPixelsWidth - var2;
            int var9 = var0 + graphicsPixelsWidth * var1;

            for (int var10 = -var3; var10 < 0; ++var10) {
                final int var11 = 65536 - var6 >> 8;
                final int var12 = var6 >> 8;
                final int var13 = (var12 * (var5 & 16711935) + var11 * (var4 & 16711935) & -16711936) + (var12 * (var5 & 65280) + var11 * (var4 & 65280) & 16711680) >>> 8;

                for (int var14 = -var2; var14 < 0; ++var14) {
                    graphicsPixels[var9++] = var13;
                }

                var9 += var8;
                var6 += var7;
            }

        }
    }

    public static void method5728(final int var0, final int var1, int var2, int var3, final int var4, final int var5, final byte[] var6, final int var7) {
        if (var0 + var2 >= 0 && var3 + var1 >= 0) {
            if (var0 < graphicsPixelsWidth && var1 < graphicsPixelsHeight) {
                int var8 = 0;
                int var9 = 0;
                if (var0 < 0) {
                    var8 -= var0;
                    var2 += var0;
                }

                if (var1 < 0) {
                    var9 -= var1;
                    var3 += var1;
                }

                if (var0 + var2 > graphicsPixelsWidth) {
                    var2 = graphicsPixelsWidth - var0;
                }

                if (var3 + var1 > graphicsPixelsHeight) {
                    var3 = graphicsPixelsHeight - var1;
                }

                final int var10 = var6.length / var7;
                final int var11 = graphicsPixelsWidth - var2;
                final int var12 = var4 >>> 24;
                final int var13 = var5 >>> 24;
                int var14;
                int var15;
                int var16;
                int var17;
                int var18;
                if (var12 == 255 && var13 == 255) {
                    var14 = var0 + var8 + (var9 + var1) * graphicsPixelsWidth;

                    for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15) {
                        for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16) {
                            var17 = (var15 - var1) % var10;
                            var18 = (var16 - var0) % var7;
                            if (var6[var18 + var17 * var7] != 0) {
                                graphicsPixels[var14++] = var5;
                            } else {
                                graphicsPixels[var14++] = var4;
                            }
                        }

                        var14 += var11;
                    }
                } else {
                    var14 = var0 + var8 + (var9 + var1) * graphicsPixelsWidth;

                    for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15) {
                        for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16) {
                            var17 = (var15 - var1) % var10;
                            var18 = (var16 - var0) % var7;
                            int var19 = var4;
                            if (var6[var18 + var17 * var7] != 0) {
                                var19 = var5;
                            }

                            final int var20 = var19 >>> 24;
                            final int var21 = 255 - var20;
                            final int var22 = graphicsPixels[var14];
                            final int var23 = ((var19 & 16711935) * var20 + (var22 & 16711935) * var21 & -16711936) + (var20 * (var19 & 65280) + var21 * (var22 & 65280) & 16711680) >> 8;
                            graphicsPixels[var14++] = var23;
                        }

                        var14 += var11;
                    }
                }

            }
        }
    }

    public static void drawRectangle(final int var0, final int var1, final int var2, final int var3, final int var4) {
        method5731(var0, var1, var2, var4);
        method5731(var0, var3 + var1 - 1, var2, var4);
        method5797(var0, var1, var3, var4);
        method5797(var0 + var2 - 1, var1, var3, var4);
    }

    public static void Rasterizer2D_drawRectangleAlpha(final int var0, final int var1, final int var2, final int var3, final int var4, final int var5) {
        Rasterizer2D_drawHorizontalLineAlpha(var0, var1, var2, var4, var5);
        Rasterizer2D_drawHorizontalLineAlpha(var0, var3 + var1 - 1, var2, var4, var5);
        if (var3 >= 3) {
            Rasterizer2D_drawVerticalLineAlpha(var0, var1 + 1, var3 - 2, var4, var5);
            Rasterizer2D_drawVerticalLineAlpha(var0 + var2 - 1, var1 + 1, var3 - 2, var4, var5);
        }

    }

    public static void method5731(int var0, final int var1, int var2, final int var3) {
        if (var1 >= drawingAreaTop && var1 < drawingAreaRight) {
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            final int var4 = var0 + graphicsPixelsWidth * var1;

            for (int var5 = 0; var5 < var2; ++var5) {
                graphicsPixels[var4 + var5] = var3;
            }

        }
    }

    private static void Rasterizer2D_drawHorizontalLineAlpha(int var0, final int var1, int var2, final int var3, final int var4) {
        if (var1 >= drawingAreaTop && var1 < drawingAreaRight) {
            if (var0 < draw_region_x) {
                var2 -= draw_region_x - var0;
                var0 = draw_region_x;
            }

            if (var0 + var2 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var0;
            }

            final int var5 = 256 - var4;
            final int var6 = (var3 >> 16 & 255) * var4;
            final int var7 = (var3 >> 8 & 255) * var4;
            final int var8 = var4 * (var3 & 255);
            int var12 = var0 + graphicsPixelsWidth * var1;

            for (int var13 = 0; var13 < var2; ++var13) {
                final int var9 = var5 * (graphicsPixels[var12] >> 16 & 255);
                final int var10 = (graphicsPixels[var12] >> 8 & 255) * var5;
                final int var11 = var5 * (graphicsPixels[var12] & 255);
                final int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                graphicsPixels[var12++] = var14;
            }

        }
    }

    public static void method5797(final int var0, int var1, int var2, final int var3) {
        if (var0 >= draw_region_x && var0 < drawingAreaBottom) {
            if (var1 < drawingAreaTop) {
                var2 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var2 + var1 > drawingAreaRight) {
                var2 = drawingAreaRight - var1;
            }

            final int var4 = var0 + graphicsPixelsWidth * var1;

            for (int var5 = 0; var5 < var2; ++var5) {
                graphicsPixels[var4 + var5 * graphicsPixelsWidth] = var3;
            }

        }
    }

    private static void Rasterizer2D_drawVerticalLineAlpha(final int var0, int var1, int var2, final int var3, final int var4) {
        if (var0 >= draw_region_x && var0 < drawingAreaBottom) {
            if (var1 < drawingAreaTop) {
                var2 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var2 + var1 > drawingAreaRight) {
                var2 = drawingAreaRight - var1;
            }

            final int var5 = 256 - var4;
            final int var6 = (var3 >> 16 & 255) * var4;
            final int var7 = (var3 >> 8 & 255) * var4;
            final int var8 = var4 * (var3 & 255);
            int var12 = var0 + graphicsPixelsWidth * var1;

            for (int var13 = 0; var13 < var2; ++var13) {
                final int var9 = var5 * (graphicsPixels[var12] >> 16 & 255);
                final int var10 = (graphicsPixels[var12] >> 8 & 255) * var5;
                final int var11 = var5 * (graphicsPixels[var12] & 255);
                final int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                graphicsPixels[var12] = var14;
                var12 += graphicsPixelsWidth;
            }

        }
    }

    public static void drawLine(int var0, int var1, int var2, int var3, final int var4) {
        var2 -= var0;
        var3 -= var1;
        if (var3 == 0) {
            if (var2 >= 0) {
                method5731(var0, var1, var2 + 1, var4);
            } else {
                method5731(var0 + var2, var1, -var2 + 1, var4);
            }

        } else if (var2 == 0) {
            if (var3 >= 0) {
                method5797(var0, var1, var3 + 1, var4);
            } else {
                method5797(var0, var3 + var1, -var3 + 1, var4);
            }

        } else {
            if (var3 + var2 < 0) {
                var0 += var2;
                var2 = -var2;
                var1 += var3;
                var3 = -var3;
            }

            final int var5;
            int var6;
            if (var2 > var3) {
                var1 <<= 16;
                var1 += 32768;
                var3 <<= 16;
                var5 = (int) Math.floor((double) var3 / var2 + 0.5D);
                var2 += var0;
                if (var0 < draw_region_x) {
                    var1 += var5 * (draw_region_x - var0);
                    var0 = draw_region_x;
                }

                if (var2 >= drawingAreaBottom) {
                    var2 = drawingAreaBottom - 1;
                }

                while (var0 <= var2) {
                    var6 = var1 >> 16;
                    if (var6 >= drawingAreaTop && var6 < drawingAreaRight) {
                        graphicsPixels[var0 + var6 * graphicsPixelsWidth] = var4;
                    }

                    var1 += var5;
                    ++var0;
                }
            } else {
                var0 <<= 16;
                var0 += 32768;
                var2 <<= 16;
                var5 = (int) Math.floor((double) var2 / var3 + 0.5D);
                var3 += var1;
                if (var1 < drawingAreaTop) {
                    var0 += (drawingAreaTop - var1) * var5;
                    var1 = drawingAreaTop;
                }

                if (var3 >= drawingAreaRight) {
                    var3 = drawingAreaRight - 1;
                }

                while (var1 <= var3) {
                    var6 = var0 >> 16;
                    if (var6 >= draw_region_x && var6 < drawingAreaBottom) {
                        graphicsPixels[var6 + graphicsPixelsWidth * var1] = var4;
                    }

                    var0 += var5;
                    ++var1;
                }
            }

        }
    }

    private static void Rasterizer2D_setPixel(final int var0, final int var1, final int var2) {
        if (var0 >= draw_region_x && var1 >= drawingAreaTop && var0 < drawingAreaBottom && var1 < drawingAreaRight) {
            graphicsPixels[var0 + graphicsPixelsWidth * var1] = var2;
        }
    }

    public static void method5737(int var0, int var1, final int var2, final int[] var3, final int[] var4) {
        int var5 = var0 + graphicsPixelsWidth * var1;

        for (var1 = 0; var1 < var3.length; ++var1) {
            int var6 = var5 + var3[var1];

            for (var0 = -var4[var1]; var0 < 0; ++var0) {
                graphicsPixels[var6++] = var2;
            }

            var5 += graphicsPixelsWidth;
        }

    }
}
