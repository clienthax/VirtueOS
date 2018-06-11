package com.oldscape.client.reference;

class VertexNormal {
    public static int field1931;
    int x;
    int y;
    int z;
    int magnitude;

    VertexNormal() {
    }

    VertexNormal(final VertexNormal var1) {
        this.x = var1.x;
        this.y = var1.y;
        this.z = var1.z;
        this.magnitude = var1.magnitude;
    }

    static IndexedSprite method2778(final boolean var0, final boolean var1) {
        return var0 ? (var1 ? class246.field2979 : class90.field1393) : (var1 ? Frames.field2074 : class90.field1363);
    }
}
