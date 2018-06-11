package com.oldscape.client.reference;

import java.util.Random;

abstract class FontTypeFace extends Rasterizer2D {
    private static final Random field3914;
    private static final String[] field3915;
    public static IndexedSprite[] modIcons;
    private static int strikeRGB;
    private static int underlineRGB;
    private static int prevShadeRGB;
    private static int shadow;
    private static int prevColorRGB;
    private static int color;
    private static int field3894;
    private static int field3905;
    private static int field3913;

    static {
        strikeRGB = -1;
        underlineRGB = -1;
        prevShadeRGB = -1;
        shadow = -1;
        prevColorRGB = 0;
        color = 0;
        field3894 = 256;
        field3905 = 0;
        field3913 = 0;
        field3914 = new Random();
        field3915 = new String[100];
    }

    public int verticalSpace;
    public int minSpacing;
    public int maxSpacing;
    private byte[][] gylphs;
    private int[] field3910;
    private int[] gylphHeights;
    private int[] glyphWidths;
    private int[] horizontalOffsets;
    private int[] verticalOffsets;
    private byte[] field3904;

    FontTypeFace(final byte[] var1, final int[] var2, final int[] var3, final int[] var4, final int[] var5, final byte[][] var7) {
        this.gylphs = new byte[256][];
        this.verticalSpace = 0;
        this.horizontalOffsets = var2;
        this.verticalOffsets = var3;
        this.gylphHeights = var4;
        this.glyphWidths = var5;
        this.method5502(var1);
        this.gylphs = var7;
        int var8 = Integer.MAX_VALUE;
        int var9 = Integer.MIN_VALUE;

        for (int var10 = 0; var10 < 256; ++var10) {
            if (this.verticalOffsets[var10] < var8 && this.glyphWidths[var10] != 0) {
                var8 = this.verticalOffsets[var10];
            }

            if (this.verticalOffsets[var10] + this.glyphWidths[var10] > var9) {
                var9 = this.verticalOffsets[var10] + this.glyphWidths[var10];
            }
        }

        this.minSpacing = this.verticalSpace - var8;
        this.maxSpacing = var9 - this.verticalSpace;
    }

    FontTypeFace(final byte[] var1) {
        this.gylphs = new byte[256][];
        this.verticalSpace = 0;
        this.method5502(var1);
    }

    private static int method5503(final byte[][] var0, final byte[][] var1, final int[] var2, final int[] var3, final int[] var4, final int var5, final int var6) {
        final int var7 = var2[var5];
        final int var8 = var7 + var4[var5];
        final int var9 = var2[var6];
        final int var10 = var9 + var4[var6];
        int var11 = var7;
        if (var9 > var7) {
            var11 = var9;
        }

        int var12 = var8;
        if (var10 < var8) {
            var12 = var10;
        }

        int var13 = var3[var5];
        if (var3[var6] < var13) {
            var13 = var3[var6];
        }

        final byte[] var14 = var1[var5];
        final byte[] var15 = var0[var6];
        int var16 = var11 - var7;
        int var17 = var11 - var9;

        for (int var18 = var11; var18 < var12; ++var18) {
            final int var19 = var14[var16++] + var15[var17++];
            if (var19 < var13) {
                var13 = var19;
            }
        }

        return -var13;
    }

    public static String appendTags(final String var0) {
        final int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            final char var4 = var0.charAt(var3);
            if (var4 == '<' || var4 == '>') {
                var2 += 3;
            }
        }

        final StringBuilder var6 = new StringBuilder(var1 + var2);

        for (int var7 = 0; var7 < var1; ++var7) {
            final char var5 = var0.charAt(var7);
            if (var5 == '<') {
                var6.append("<lt>");
            } else if (var5 == '>') {
                var6.append("<gt>");
            } else {
                var6.append(var5);
            }
        }

        return var6.toString();
    }

    private static void renderShadeRGB(final byte[] var0, int var1, int var2, int var3, int var4, final int var5) {
        int var6 = var1 + var2 * graphicsPixelsWidth;
        int var7 = graphicsPixelsWidth - var3;
        int var8 = 0;
        int var9 = 0;
        int var10;
        if (var2 < drawingAreaTop) {
            var10 = drawingAreaTop - var2;
            var4 -= var10;
            var2 = drawingAreaTop;
            var9 += var3 * var10;
            var6 += var10 * graphicsPixelsWidth;
        }

        if (var2 + var4 > drawingAreaRight) {
            var4 -= var2 + var4 - drawingAreaRight;
        }

        if (var1 < draw_region_x) {
            var10 = draw_region_x - var1;
            var3 -= var10;
            var1 = draw_region_x;
            var9 += var10;
            var6 += var10;
            var8 += var10;
            var7 += var10;
        }

        if (var3 + var1 > drawingAreaBottom) {
            var10 = var3 + var1 - drawingAreaBottom;
            var3 -= var10;
            var8 += var10;
            var7 += var10;
        }

        if (var3 > 0 && var4 > 0) {
            render(graphicsPixels, var0, var5, var9, var6, var3, var4, var7, var8);
        }
    }

    static void render(final int[] var0, final byte[] var1, final int var2, int var3, int var4, int var5, final int var6, final int var7, final int var8) {
        final int var9 = -(var5 >> 2);
        var5 = -(var5 & 3);

        for (int var10 = -var6; var10 < 0; ++var10) {
            int var11;
            for (var11 = var9; var11 < 0; ++var11) {
                if (var1[var3++] != 0) {
                    var0[var4++] = var2;
                } else {
                    ++var4;
                }

                if (var1[var3++] != 0) {
                    var0[var4++] = var2;
                } else {
                    ++var4;
                }

                if (var1[var3++] != 0) {
                    var0[var4++] = var2;
                } else {
                    ++var4;
                }

                if (var1[var3++] != 0) {
                    var0[var4++] = var2;
                } else {
                    ++var4;
                }
            }

            for (var11 = var5; var11 < 0; ++var11) {
                if (var1[var3++] != 0) {
                    var0[var4++] = var2;
                } else {
                    ++var4;
                }
            }

            var4 += var7;
            var3 += var8;
        }

    }

    private static void renderShadeRGBA(final byte[] var0, int var1, int var2, int var3, int var4, final int var5, final int var6) {
        int var7 = var1 + var2 * graphicsPixelsWidth;
        int var8 = graphicsPixelsWidth - var3;
        int var9 = 0;
        int var10 = 0;
        int var11;
        if (var2 < drawingAreaTop) {
            var11 = drawingAreaTop - var2;
            var4 -= var11;
            var2 = drawingAreaTop;
            var10 += var3 * var11;
            var7 += var11 * graphicsPixelsWidth;
        }

        if (var2 + var4 > drawingAreaRight) {
            var4 -= var2 + var4 - drawingAreaRight;
        }

        if (var1 < draw_region_x) {
            var11 = draw_region_x - var1;
            var3 -= var11;
            var1 = draw_region_x;
            var10 += var11;
            var7 += var11;
            var9 += var11;
            var8 += var11;
        }

        if (var3 + var1 > drawingAreaBottom) {
            var11 = var3 + var1 - drawingAreaBottom;
            var3 -= var11;
            var9 += var11;
            var8 += var11;
        }

        if (var3 > 0 && var4 > 0) {
            renderRGBA(graphicsPixels, var0, var5, var10, var7, var3, var4, var8, var9, var6);
        }
    }

    static void renderRGBA(final int[] var0, final byte[] var1, int var2, int var3, int var4, final int var5, final int var6, final int var7, final int var8, int var9) {
        var2 = ((var2 & 65280) * var9 & 16711680) + (var9 * (var2 & 16711935) & -16711936) >> 8;
        var9 = 256 - var9;

        for (int var10 = -var6; var10 < 0; ++var10) {
            for (int var11 = -var5; var11 < 0; ++var11) {
                if (var1[var3++] != 0) {
                    final int var12 = var0[var4];
                    var0[var4++] = (((var12 & 65280) * var9 & 16711680) + ((var12 & 16711935) * var9 & -16711936) >> 8) + var2;
                } else {
                    ++var4;
                }
            }

            var4 += var7;
            var3 += var8;
        }

    }

    abstract void renderRGB(byte[] var1, int var2, int var3, int var4, int var5, int var6);

    abstract void renderRGBA(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

    private void method5502(final byte[] var1) {
        this.field3910 = new int[256];
        int var2;
        if (var1.length == 257) {
            for (var2 = 0; var2 < this.field3910.length; ++var2) {
                this.field3910[var2] = var1[var2] & 255;
            }

            this.verticalSpace = var1[256] & 255;
        } else {
            var2 = 0;

            for (int var3 = 0; var3 < 256; ++var3) {
                this.field3910[var3] = var1[var2++] & 255;
            }

            final int[] var10 = new int[256];
            final int[] var4 = new int[256];

            int var5;
            for (var5 = 0; var5 < 256; ++var5) {
                var10[var5] = var1[var2++] & 255;
            }

            for (var5 = 0; var5 < 256; ++var5) {
                var4[var5] = var1[var2++] & 255;
            }

            final byte[][] var11 = new byte[256][];

            int var8;
            for (int var6 = 0; var6 < 256; ++var6) {
                var11[var6] = new byte[var10[var6]];
                byte var7 = 0;

                for (var8 = 0; var8 < var11[var6].length; ++var8) {
                    var7 += var1[var2++];
                    var11[var6][var8] = var7;
                }
            }

            final byte[][] var12 = new byte[256][];

            int var13;
            for (var13 = 0; var13 < 256; ++var13) {
                var12[var13] = new byte[var10[var13]];
                byte var14 = 0;

                for (int var9 = 0; var9 < var12[var13].length; ++var9) {
                    var14 += var1[var2++];
                    var12[var13][var9] = var14;
                }
            }

            this.field3904 = new byte[65536];

            for (var13 = 0; var13 < 256; ++var13) {
                if (var13 != 32 && var13 != 160) {
                    for (var8 = 0; var8 < 256; ++var8) {
                        if (var8 != 32 && var8 != 160) {
                            this.field3904[var8 + (var13 << 8)] = (byte) method5503(var11, var12, var4, this.field3910, var10, var13, var8);
                        }
                    }
                }
            }

            this.verticalSpace = var4[32] + var10[32];
        }

    }

    private int method5577(char var1) {
        if (var1 == 160) {
            var1 = ' ';
        }

        return this.field3910[Client.charToByteCp1252(var1) & 255];
    }

    public int getTextWidth(final String var1) {
        if (var1 == null) {
            return 0;
        } else {
            int var2 = -1;
            int var3 = -1;
            int var4 = 0;

            for (int var5 = 0; var5 < var1.length(); ++var5) {
                char var6 = var1.charAt(var5);
                if (var6 == '<') {
                    var2 = var5;
                } else {
                    if (var6 == '>' && var2 != -1) {
                        final String var7 = var1.substring(var2 + 1, var5);
                        var2 = -1;
                        if (var7.equals("lt")) {
                            var6 = '<';
                        } else {
                            if (!var7.equals("gt")) {
                                if (var7.startsWith("img=")) {
                                    try {
                                        final String var9 = var7.substring(4);
                                        final int var8 = class150.parseInt(var9, 10);
                                        var4 += modIcons[var8].originalWidth;
                                        var3 = -1;
                                    } catch (final Exception ignored) {
                                    }
                                }
                                continue;
                            }

                            var6 = '>';
                        }
                    }

                    if (var6 == 160) {
                        var6 = ' ';
                    }

                    if (var2 == -1) {
                        var4 += this.field3910[(char) (Client.charToByteCp1252(var6) & 255)];
                        if (this.field3904 != null && var3 != -1) {
                            var4 += this.field3904[var6 + (var3 << 8)];
                        }

                        var3 = var6;
                    }
                }
            }

            return var4;
        }
    }

    public int method5580(final String var1, final int[] var2, final String[] var3) {
        if (var1 == null) {
            return 0;
        } else {
            int var4 = 0;
            int var5 = 0;
            final StringBuilder var6 = new StringBuilder(100);
            int var7 = -1;
            int var8 = 0;
            byte var9 = 0;
            int var10 = -1;
            char var11 = 0;
            int var12 = 0;
            final int var13 = var1.length();

            for (int var14 = 0; var14 < var13; ++var14) {
                char var15 = var1.charAt(var14);
                if (var15 == '<') {
                    var10 = var14;
                } else {
                    if (var15 == '>' && var10 != -1) {
                        final String var16 = var1.substring(var10 + 1, var14);
                        var10 = -1;
                        var6.append('<');
                        var6.append(var16);
                        var6.append('>');
                        if (var16.equals("br")) {
                            var3[var12] = var6.toString().substring(var5, var6.length());
                            ++var12;
                            var5 = var6.length();
                            var4 = 0;
                            var7 = -1;
                            var11 = 0;
                        } else if (var16.equals("lt")) {
                            var4 += this.method5577('<');
                            if (this.field3904 != null && var11 != -1) {
                                var4 += this.field3904[(var11 << '\b') + 60];
                            }

                            var11 = '<';
                        } else if (var16.equals("gt")) {
                            var4 += this.method5577('>');
                            if (this.field3904 != null && var11 != -1) {
                                var4 += this.field3904[(var11 << '\b') + 62];
                            }

                            var11 = '>';
                        } else if (var16.startsWith("img=")) {
                            try {
                                final String var18 = var16.substring(4);
                                final int var17 = class150.parseInt(var18, 10);
                                var4 += modIcons[var17].originalWidth;
                                var11 = 0;
                            } catch (final Exception ignored) {
                            }
                        }

                        var15 = 0;
                    }

                    if (var10 == -1) {
                        if (var15 != 0) {
                            var6.append(var15);
                            var4 += this.method5577(var15);
                            if (this.field3904 != null && var11 != -1) {
                                var4 += this.field3904[var15 + (var11 << '\b')];
                            }

                            var11 = var15;
                        }

                        if (var15 == ' ') {
                            var7 = var6.length();
                            var8 = var4;
                            var9 = 1;
                        }

                        if (var2 != null && var4 > var2[var12 < var2.length ? var12 : var2.length - 1] && var7 >= 0) {
                            var3[var12] = var6.toString().substring(var5, var7 - var9);
                            ++var12;
                            var5 = var7;
                            var7 = -1;
                            var4 -= var8;
                            var11 = 0;
                        }

                        if (var15 == '-') {
                            var7 = var6.length();
                            var8 = var4;
                            var9 = 0;
                        }
                    }
                }
            }

            final String var21 = var6.toString();
            if (var21.length() > var5) {
                var3[var12++] = var21.substring(var5, var21.length());
            }

            return var12;
        }
    }

    public int method5507(final String var1, final int var2) {
        final int var3 = this.method5580(var1, new int[]{var2}, field3915);
        int var4 = 0;

        for (int var5 = 0; var5 < var3; ++var5) {
            final int var6 = this.getTextWidth(field3915[var5]);
            if (var6 > var4) {
                var4 = var6;
            }
        }

        return var4;
    }

    public int method5508(final String var1, final int var2) {
        return this.method5580(var1, new int[]{var2}, field3915);
    }

    public void method5510(final String var1, final int var2, final int var3, final int var4, final int var5) {
        if (var1 != null) {
            this.setColor(var4, var5);
            this.drawText(var1, var2, var3);
        }
    }

    public void method5511(final String var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
        if (var1 != null) {
            this.setColor(var4, var5);
            field3894 = var6;
            this.drawText(var1, var2, var3);
        }
    }

    public void method5512(final String var1, final int var2, final int var3, final int var4, final int var5) {
        if (var1 != null) {
            this.setColor(var4, var5);
            this.drawText(var1, var2 - this.getTextWidth(var1), var3);
        }
    }

    public void drawTextCentered(final String var1, final int var2, final int var3, final int var4, final int var5) {
        if (var1 != null) {
            this.setColor(var4, var5);
            this.drawText(var1, var2 - this.getTextWidth(var1) / 2, var3);
        }
    }

    public int method5514(final String var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7, final int var8, int var9, int var10) {
        if (var1 == null) {
            return 0;
        } else {
            this.setColor(var6, var7);
            if (var10 == 0) {
                var10 = this.verticalSpace;
            }

            int[] var11 = {var4};
            if (var5 < var10 + this.minSpacing + this.maxSpacing && var5 < var10 + var10) {
                var11 = null;
            }

            final int var12 = this.method5580(var1, var11, field3915);
            if (var9 == 3 && var12 == 1) {
                var9 = 1;
            }

            int var13;
            int var14;
            if (var9 == 0) {
                var13 = var3 + this.minSpacing;
            } else if (var9 == 1) {
                var13 = var3 + (var5 - this.minSpacing - this.maxSpacing - var10 * (var12 - 1)) / 2 + this.minSpacing;
            } else if (var9 == 2) {
                var13 = var3 + var5 - this.maxSpacing - var10 * (var12 - 1);
            } else {
                var14 = (var5 - this.minSpacing - this.maxSpacing - var10 * (var12 - 1)) / (var12 + 1);
                if (var14 < 0) {
                    var14 = 0;
                }

                var13 = var3 + var14 + this.minSpacing;
                var10 += var14;
            }

            for (var14 = 0; var14 < var12; ++var14) {
                if (var8 == 0) {
                    this.drawText(field3915[var14], var2, var13);
                } else if (var8 == 1) {
                    this.drawText(field3915[var14], var2 + (var4 - this.getTextWidth(field3915[var14])) / 2, var13);
                } else if (var8 == 2) {
                    this.drawText(field3915[var14], var2 + var4 - this.getTextWidth(field3915[var14]), var13);
                } else if (var14 == var12 - 1) {
                    this.drawText(field3915[var14], var2, var13);
                } else {
                    this.method5546(field3915[var14], var4);
                    this.drawText(field3915[var14], var2, var13);
                    field3905 = 0;
                }

                var13 += var10;
            }

            return var12;
        }
    }

    public void method5515(final String var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
        if (var1 != null) {
            this.setColor(var4, var5);
            final int[] var7 = new int[var1.length()];

            for (int var8 = 0; var8 < var1.length(); ++var8) {
                var7[var8] = (int) (Math.sin(var8 / 2.0D + var6 / 5.0D) * 5.0D);
            }

            this.drawMouseoverText(var1, var2 - this.getTextWidth(var1) / 2, var3, null, var7);
        }
    }

    public void method5516(final String var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
        if (var1 != null) {
            this.setColor(var4, var5);
            final int[] var7 = new int[var1.length()];
            final int[] var8 = new int[var1.length()];

            for (int var9 = 0; var9 < var1.length(); ++var9) {
                var7[var9] = (int) (Math.sin(var9 / 5.0D + var6 / 5.0D) * 5.0D);
                var8[var9] = (int) (Math.sin(var9 / 3.0D + var6 / 5.0D) * 5.0D);
            }

            this.drawMouseoverText(var1, var2 - this.getTextWidth(var1) / 2, var3, var7, var8);
        }
    }

    public void method5517(final String var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7) {
        if (var1 != null) {
            this.setColor(var4, var5);
            double var8 = 7.0D - var7 / 8.0D;
            if (var8 < 0.0D) {
                var8 = 0.0D;
            }

            final int[] var10 = new int[var1.length()];

            for (int var11 = 0; var11 < var1.length(); ++var11) {
                var10[var11] = (int) (Math.sin(var11 / 1.5D + var6 / 1.0D) * var8);
            }

            this.drawMouseoverText(var1, var2 - this.getTextWidth(var1) / 2, var3, null, var10);
        }
    }

    public void drawRandomizedMouseoverText(final String var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
        if (var1 != null) {
            this.setColor(var4, var5);
            field3914.setSeed(var6);
            field3894 = 192 + (field3914.nextInt() & 31);
            final int[] var7 = new int[var1.length()];
            int var8 = 0;

            for (int var9 = 0; var9 < var1.length(); ++var9) {
                var7[var9] = var8;
                if ((field3914.nextInt() & 3) == 0) {
                    ++var8;
                }
            }

            this.drawMouseoverText(var1, var2, var3, var7, null);
        }
    }

    private void setColor(final int var1, final int var2) {
        strikeRGB = -1;
        underlineRGB = -1;
        prevShadeRGB = var2;
        shadow = var2;
        prevColorRGB = var1;
        color = var1;
        field3894 = 256;
        field3905 = 0;
        field3913 = 0;
    }

    private void setRGB(final String var1) {
        try {
            if (var1.startsWith("col=")) {
                color = class304.method5422(var1.substring(4), 16);
            } else if (var1.equals("/col")) {
                color = prevColorRGB;
            } else if (var1.startsWith("str=")) {
                strikeRGB = class304.method5422(var1.substring(4), 16);
            } else if (var1.equals("str")) {
                strikeRGB = 8388608;
            } else if (var1.equals("/str")) {
                strikeRGB = -1;
            } else if (var1.startsWith("u=")) {
                underlineRGB = class304.method5422(var1.substring(2), 16);
            } else if (var1.equals("u")) {
                underlineRGB = 0;
            } else if (var1.equals("/u")) {
                underlineRGB = -1;
            } else if (var1.startsWith("shad=")) {
                shadow = class304.method5422(var1.substring(5), 16);
            } else if (var1.equals("shad")) {
                shadow = 0;
            } else if (var1.equals("/shad")) {
                shadow = prevShadeRGB;
            } else if (var1.equals("br")) {
                this.setColor(prevColorRGB, prevShadeRGB);
            }
        } catch (final Exception ignored) {
        }

    }

    private void method5546(final String var1, final int var2) {
        int var3 = 0;
        boolean var4 = false;

        for (int var5 = 0; var5 < var1.length(); ++var5) {
            final char var6 = var1.charAt(var5);
            if (var6 == '<') {
                var4 = true;
            } else if (var6 == '>') {
                var4 = false;
            } else if (!var4 && var6 == ' ') {
                ++var3;
            }
        }

        if (var3 > 0) {
            field3905 = (var2 - this.getTextWidth(var1) << 8) / var3;
        }

    }

    private void drawText(final String var1, int var2, int var3) {
        var3 -= this.verticalSpace;
        int var4 = -1;
        int var5 = -1;

        for (int var6 = 0; var6 < var1.length(); ++var6) {
            if (var1.charAt(var6) != 0) {
                char var7 = (char) (Client.charToByteCp1252(var1.charAt(var6)) & 255);
                if (var7 == '<') {
                    var4 = var6;
                } else {
                    final int var9;
                    if (var7 == '>' && var4 != -1) {
                        final String var8 = var1.substring(var4 + 1, var6);
                        var4 = -1;
                        if (var8.equals("lt")) {
                            var7 = '<';
                        } else {
                            if (!var8.equals("gt")) {
                                if (var8.startsWith("img=")) {
                                    try {
                                        final String var10 = var8.substring(4);
                                        var9 = class150.parseInt(var10, 10);
                                        final IndexedSprite var12 = modIcons[var9];
                                        var12.method5825(var2, var3 + this.verticalSpace - var12.originalHeight);
                                        var2 += var12.originalWidth;
                                        var5 = -1;
                                    } catch (final Exception ignored) {
                                    }
                                } else {
                                    this.setRGB(var8);
                                }
                                continue;
                            }

                            var7 = '>';
                        }
                    }

                    if (var7 == 160) {
                        var7 = ' ';
                    }

                    if (var4 == -1) {
                        if (this.field3904 != null && var5 != -1) {
                            var2 += this.field3904[var7 + (var5 << 8)];
                        }

                        final int var14 = this.gylphHeights[var7];
                        var9 = this.glyphWidths[var7];
                        if (var7 != ' ') {
                            if (field3894 == 256) {
                                if (shadow != -1) {
                                    renderShadeRGB(this.gylphs[var7], var2 + this.horizontalOffsets[var7] + 1, var3 + this.verticalOffsets[var7] + 1, var14, var9, shadow);
                                }

                                this.renderRGB(this.gylphs[var7], var2 + this.horizontalOffsets[var7], var3 + this.verticalOffsets[var7], var14, var9, color);
                            } else {
                                if (shadow != -1) {
                                    renderShadeRGBA(this.gylphs[var7], var2 + this.horizontalOffsets[var7] + 1, var3 + this.verticalOffsets[var7] + 1, var14, var9, shadow, field3894);
                                }

                                this.renderRGBA(this.gylphs[var7], var2 + this.horizontalOffsets[var7], var3 + this.verticalOffsets[var7], var14, var9, color, field3894);
                            }
                        } else if (field3905 > 0) {
                            field3913 += field3905;
                            var2 += field3913 >> 8;
                            field3913 &= 255;
                        }

                        final int var15 = this.field3910[var7];
                        if (strikeRGB != -1) {
                            method5731(var2, var3 + (int) (this.verticalSpace * 0.7D), var15, strikeRGB);
                        }

                        if (underlineRGB != -1) {
                            method5731(var2, var3 + this.verticalSpace + 1, var15, underlineRGB);
                        }

                        var2 += var15;
                        var5 = var7;
                    }
                }
            }
        }

    }

    private void drawMouseoverText(final String var1, int var2, int var3, final int[] var4, final int[] var5) {
        var3 -= this.verticalSpace;
        int var6 = -1;
        int var7 = -1;
        int var8 = 0;

        for (int var9 = 0; var9 < var1.length(); ++var9) {
            if (var1.charAt(var9) != 0) {
                char var10 = (char) (Client.charToByteCp1252(var1.charAt(var9)) & 255);
                if (var10 == '<') {
                    var6 = var9;
                } else {
                    final int var12;
                    final int var13;
                    final int var14;
                    if (var10 == '>' && var6 != -1) {
                        final String var11 = var1.substring(var6 + 1, var9);
                        var6 = -1;
                        if (var11.equals("lt")) {
                            var10 = '<';
                        } else {
                            if (!var11.equals("gt")) {
                                if (var11.startsWith("img=")) {
                                    try {
                                        if (var4 != null) {
                                            var12 = var4[var8];
                                        } else {
                                            var12 = 0;
                                        }

                                        if (var5 != null) {
                                            var13 = var5[var8];
                                        } else {
                                            var13 = 0;
                                        }

                                        ++var8;
                                        final String var15 = var11.substring(4);
                                        var14 = class150.parseInt(var15, 10);
                                        final IndexedSprite var17 = modIcons[var14];
                                        var17.method5825(var12 + var2, var13 + (var3 + this.verticalSpace - var17.originalHeight));
                                        var2 += var17.originalWidth;
                                        var7 = -1;
                                    } catch (final Exception ignored) {
                                    }
                                } else {
                                    this.setRGB(var11);
                                }
                                continue;
                            }

                            var10 = '>';
                        }
                    }

                    if (var10 == 160) {
                        var10 = ' ';
                    }

                    if (var6 == -1) {
                        if (this.field3904 != null && var7 != -1) {
                            var2 += this.field3904[var10 + (var7 << 8)];
                        }

                        final int var19 = this.gylphHeights[var10];
                        var12 = this.glyphWidths[var10];
                        if (var4 != null) {
                            var13 = var4[var8];
                        } else {
                            var13 = 0;
                        }

                        if (var5 != null) {
                            var14 = var5[var8];
                        } else {
                            var14 = 0;
                        }

                        ++var8;
                        if (var10 != ' ') {
                            if (field3894 == 256) {
                                if (shadow != -1) {
                                    renderShadeRGB(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10] + 1, var3 + var14 + this.verticalOffsets[var10] + 1, var19, var12, shadow);
                                }

                                this.renderRGB(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10], var3 + var14 + this.verticalOffsets[var10], var19, var12, color);
                            } else {
                                if (shadow != -1) {
                                    renderShadeRGBA(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10] + 1, var3 + var14 + this.verticalOffsets[var10] + 1, var19, var12, shadow, field3894);
                                }

                                this.renderRGBA(this.gylphs[var10], var13 + var2 + this.horizontalOffsets[var10], var3 + var14 + this.verticalOffsets[var10], var19, var12, color, field3894);
                            }
                        } else if (field3905 > 0) {
                            field3913 += field3905;
                            var2 += field3913 >> 8;
                            field3913 &= 255;
                        }

                        final int var20 = this.field3910[var10];
                        if (strikeRGB != -1) {
                            method5731(var2, var3 + (int) (this.verticalSpace * 0.7D), var20, strikeRGB);
                        }

                        if (underlineRGB != -1) {
                            method5731(var2, var3 + this.verticalSpace, var20, underlineRGB);
                        }

                        var2 += var20;
                        var7 = var10;
                    }
                }
            }
        }

    }
}
