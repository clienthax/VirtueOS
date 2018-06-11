package com.oldscape.client.reference;

class InvType extends CacheableNode {
    public static final NodeCache inventoryCache;
    public static IndexDataBase field3449;

    static {
        inventoryCache = new NodeCache(64);
    }

    public int size;

    public InvType() {
        this.size = 0;
    }

    public void decode(final Buffer var1) {
        while (true) {
            final int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method4716(var1, var2);
        }
    }

    private void method4716(final Buffer var1, final int var2) {
        if (var2 == 2) {
            this.size = var1.readUnsignedShort();
        }

    }
}
