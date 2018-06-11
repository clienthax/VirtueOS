package com.oldscape.client.reference;

final class Item extends Renderable {
    public static int currentPressedKey;
    int id;
    int quantity;

    public static void method1951(final IndexDataBase var0, final IndexDataBase var1, final IndexDataBase var2) {
        Sequence.seq_ref = var0;
        Sequence.skel_ref = var1;
        Sequence.skin_ref = var2;
    }

    static Frames getFrames(final int var0) {
        final Frames var1 = (Frames) Sequence.skeletons.get(var0);
        if (var1 != null) {
            return var1;
        } else {
            final IndexDataBase var3 = Sequence.skel_ref;
            final IndexDataBase var4 = Sequence.skin_ref;
            boolean var5 = true;
            final int[] var6 = var3.getChilds(var0);

            for (final int aVar6 : var6) {
                final byte[] var8 = var3.getChild(var0, aVar6);
                if (var8 == null) {
                    var5 = false;
                } else {
                    final int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
                    final byte[] var10 = var4.getChild(var9, 0);
                    if (var10 == null) {
                        var5 = false;
                    }
                }
            }

            Frames var2;
            if (!var5) {
                var2 = null;
            } else {
                try {
                    var2 = new Frames(var3, var4, var0);
                } catch (final Exception var12) {
                    var2 = null;
                }
            }

            if (var2 != null) {
                Sequence.skeletons.put(var2, var0);
            }

            return var2;
        }
    }

    protected final Model getModel() {
        return ItemComposition.getItemDefinition(this.id).getModel(this.quantity);
    }
}
