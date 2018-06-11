package com.oldscape.client.reference;

class Frames extends CacheableNode {
    static IndexedSprite field2074;
    final Frame[] skeletons;

    public Frames(final IndexDataBase var1, final IndexDataBase var2, final int var3) {
        final Deque var5 = new Deque();
        final int var6 = var1.fileCount(var3);
        this.skeletons = new Frame[var6];
        final int[] var7 = var1.getChilds(var3);

        for (final int aVar7 : var7) {
            final byte[] var9 = var1.getConfigData(var3, aVar7);
            FrameMap var10 = null;
            final int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

            for (FrameMap var12 = (FrameMap) var5.getFront(); var12 != null; var12 = (FrameMap) var5.getNext()) {
                if (var11 == var12.id) {
                    var10 = var12;
                    break;
                }
            }

            if (var10 == null) {
                final byte[] var13 = var2.getChild(var11, 0);
                var10 = new FrameMap(var11, var13);
                var5.addFront(var10);
            }

            this.skeletons[aVar7] = new Frame(var9, var10);
        }

    }

    public static int method3065() {
        return ++MouseInput.mouseIdleTicks - 1;
    }

    static int method3062(final IterableHashTable var0, final int var1, final int var2) {
        if (var0 == null) {
            return var2;
        } else {
            final IntegerNode var3 = (IntegerNode) var0.get(var1);
            return var3 == null ? var2 : var3.value;
        }
    }

    public boolean method3063(final int var1) {
        return this.skeletons[var1].showing;
    }
}
