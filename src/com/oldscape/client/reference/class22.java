package com.oldscape.client.reference;

class class22 extends WorldMapDecorationInfo {

    static void method184(final int var0) {
        Projectile.topContextMenuRow = new ContextMenuRow();
        Projectile.topContextMenuRow.param0 = Client.menuActionParams0[var0];
        Projectile.topContextMenuRow.param1 = Client.menuActionParams1[var0];
        Projectile.topContextMenuRow.type = Client.menuTypes[var0];
        Projectile.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
        Projectile.topContextMenuRow.option = Client.menuOptions[var0];
    }

    void method185(final Buffer buffer, final Buffer var2) {
        int var3 = var2.readUnsignedByte();
        if (var3 != class37.field499.field500) {
            throw new IllegalStateException("");
        } else {
            super.field410 = var2.readUnsignedByte();
            super.planes = var2.readUnsignedByte();
            super.field406 = var2.readUnsignedShort();
            super.field407 = var2.readUnsignedShort();
            super.field420 = var2.readUnsignedShort();
            super.field409 = var2.readUnsignedShort();
            super.planes = Math.min(super.planes, 4);
            super.worldMapUnderlayColors = new short[1][64][64];
            super.worldMapOverlayColors = new short[super.planes][64][64];
            super.worldMapOverlayShapes = new byte[super.planes][64][64];
            super.worldMapOverlayRotations = new byte[super.planes][64][64];
            super.decorations = new WorldMapDecoration[super.planes][64][64][];
            var3 = buffer.readUnsignedByte();
            if (var3 != class36.field494.field496) {
                throw new IllegalStateException("");
            } else {
                final int var4 = buffer.readUnsignedByte();
                final int var5 = buffer.readUnsignedByte();
                if (var4 == super.field420 && var5 == super.field409) {
                    for (int x = 0; x < 64; ++x) {
                        for (int y = 0; y < 64; ++y) {
                            this.method251(x, y, buffer);
                        }
                    }

                } else {
                    throw new IllegalStateException("");
                }
            }
        }
    }

    public boolean equals(final Object var1) {
        if (!(var1 instanceof class22)) {
            return false;
        } else {
            final class22 var2 = (class22) var1;
            return var2.field420 == super.field420 && var2.field409 == super.field409;
        }
    }

    public int hashCode() {
        return super.field420 | super.field409 << 8;
    }
}
