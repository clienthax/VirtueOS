package com.oldscape.client.reference;

public final class BoundingBox3D extends BoundingBox {
    static Widget field259;
    private final int int1;
    private final int int2;
    private final int int3;
    private final int int4;
    private final int int5;
    private final int int6;
    private final int color;

    BoundingBox3D(final Model var1, final int var2, final int var3, final int var4, final int var5) {
        this.int1 = var2 + var1.centerX - var1.extremeX;
        this.int2 = var3 + var1.centerY - var1.extremeY;
        this.int3 = var4 + var1.centerZ - var1.extremeZ;
        this.int4 = var2 + var1.centerX + var1.extremeX;
        this.int5 = var3 + var1.centerY + var1.extremeY;
        this.int6 = var4 + var1.extremeZ + var1.centerZ;
        this.color = var5;
    }

    static void method48(final Widget widget, final int width, final int height, final boolean var3) {
        final int var4 = widget.width;
        final int var5 = widget.height;
        if (widget.dynamicWidth == 0) {
            widget.width = widget.originalWidth;
        } else if (widget.dynamicWidth == 1) {
            widget.width = width - widget.originalWidth;
        } else if (widget.dynamicWidth == 2) {
            widget.width = widget.originalWidth * width >> 14;
        }

        if (widget.buttonType == 0) {
            widget.height = widget.originalHeight;
        } else if (widget.buttonType == 1) {
            widget.height = height - widget.originalHeight;
        } else if (widget.buttonType == 2) {
            widget.height = height * widget.originalHeight >> 14;
        }

        if (widget.dynamicWidth == 4) {
            widget.width = widget.field2839 * widget.height / widget.field2840;
        }

        if (widget.buttonType == 4) {
            widget.height = widget.field2840 * widget.width / widget.field2839;
        }

        if (widget.contentType == 1337) {
            Client.field1039 = widget;
        }

        if (var3 && widget.onResizeListener != null && (var4 != widget.width || var5 != widget.height)) {
            final ScriptEvent var6 = new ScriptEvent();
            var6.widget = widget;
            var6.objs = widget.onResizeListener;
            Client.field1066.addFront(var6);
        }

    }

    static void method52(final Widget var0, final int var1, final int var2) {
        if (var0.dynamicX == 0) {
            var0.relativeX = var0.originalX;
        } else if (var0.dynamicX == 1) {
            var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
        } else if (var0.dynamicX == 2) {
            var0.relativeX = var1 - var0.width - var0.originalX;
        } else if (var0.dynamicX == 3) {
            var0.relativeX = var0.originalX * var1 >> 14;
        } else if (var0.dynamicX == 4) {
            var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
        } else {
            var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
        }

        if (var0.dynamicY == 0) {
            var0.relativeY = var0.originalY;
        } else if (var0.dynamicY == 1) {
            var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
        } else if (var0.dynamicY == 2) {
            var0.relativeY = var2 - var0.height - var0.originalY;
        } else if (var0.dynamicY == 3) {
            var0.relativeY = var2 * var0.originalY >> 14;
        } else if (var0.dynamicY == 4) {
            var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
        } else {
            var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
        }

    }

    public final void vmethod46() {
        for (int var4 = 0; var4 < 8; ++var4) {
            final int var1 = (var4 & 1) == 0 ? this.int1 : this.int4;
            final int var2 = (var4 & 2) == 0 ? this.int2 : this.int5;
            final int var3 = (var4 & 4) == 0 ? this.int3 : this.int6;
            if ((var4 & 1) == 0) {
                class27.method245(var1, var2, var3, this.int4, var2, var3, this.color);
            }

            if ((var4 & 2) == 0) {
                class27.method245(var1, var2, var3, var1, this.int5, var3, this.color);
            }

            if ((var4 & 4) == 0) {
                class27.method245(var1, var2, var3, var1, var2, this.int6, this.color);
            }
        }

    }
}
