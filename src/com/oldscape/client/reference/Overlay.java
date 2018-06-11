package com.oldscape.client.reference;

public class Overlay extends CacheableNode {
    public static final NodeCache overlays;

    static {
        overlays = new NodeCache(64);
    }

    public int color;
    public int texture;
    public boolean isHidden;
    public int otherRgbColor;
    public int hue;
    public int saturation;
    public int lightness;
    public int otherHue;
    public int otherSaturation;
    public int otherLightness;

    Overlay() {
        this.color = 0;
        this.texture = -1;
        this.isHidden = true;
        this.otherRgbColor = -1;
    }

    void post() {
        if (this.otherRgbColor != -1) {
            this.setHSL(this.otherRgbColor);
            this.otherHue = this.hue;
            this.otherSaturation = this.saturation;
            this.otherLightness = this.lightness;
        }

        this.setHSL(this.color);
    }

    void decode(final Buffer var1, final int var2) {
        while (true) {
            final int var3 = var1.readUnsignedByte();
            if (var3 == 0) {
                return;
            }

            this.readNext(var1, var3, var2);
        }
    }

    private void readNext(final Buffer var1, final int var2, final int var3) {
        if (var2 == 1) {
            this.color = var1.read24BitInt();
        } else if (var2 == 2) {
            this.texture = var1.readUnsignedByte();
        } else if (var2 == 5) {
            this.isHidden = false;
        } else if (var2 == 7) {
            this.otherRgbColor = var1.read24BitInt();
        } else if (var2 == 8) {
        }

    }

    private void setHSL(final int var1) {
        final double var2 = (var1 >> 16 & 255) / 256.0D;
        final double var4 = (var1 >> 8 & 255) / 256.0D;
        final double var6 = (var1 & 255) / 256.0D;
        double var8 = var2;
        if (var4 < var2) {
            var8 = var4;
        }

        if (var6 < var8) {
            var8 = var6;
        }

        double var10 = var2;
        if (var4 > var2) {
            var10 = var4;
        }

        if (var6 > var10) {
            var10 = var6;
        }

        double var12 = 0.0D;
        double var14 = 0.0D;
        final double var16 = (var10 + var8) / 2.0D;
        if (var10 != var8) {
            if (var16 < 0.5D) {
                var14 = (var10 - var8) / (var8 + var10);
            }

            if (var16 >= 0.5D) {
                var14 = (var10 - var8) / (2.0D - var10 - var8);
            }

            if (var2 == var10) {
                var12 = (var4 - var6) / (var10 - var8);
            } else if (var4 == var10) {
                var12 = (var6 - var2) / (var10 - var8) + 2.0D;
            } else if (var6 == var10) {
                var12 = (var2 - var4) / (var10 - var8) + 4.0D;
            }
        }

        var12 /= 6.0D;
        this.hue = (int) (256.0D * var12);
        this.saturation = (int) (256.0D * var14);
        this.lightness = (int) (var16 * 256.0D);
        if (this.saturation < 0) {
            this.saturation = 0;
        } else if (this.saturation > 255) {
            this.saturation = 255;
        }

        if (this.lightness < 0) {
            this.lightness = 0;
        } else if (this.lightness > 255) {
            this.lightness = 255;
        }

    }
}
