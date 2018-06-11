package com.oldscape.client.reference;

public abstract class Renderable extends CacheableNode {
    static int field2051;
    public int modelHeight;

    Renderable() {
        this.modelHeight = 1000;
    }

    public static void method3051(final int[] var0, final int[] var1) {
        if (var0 != null && var1 != null) {
            class195.field2584 = var0;
            OwnWorldComparator.field866 = new int[var0.length];
            class319.field3930 = new byte[var0.length][][];

            for (int var2 = 0; var2 < class195.field2584.length; ++var2) {
                class319.field3930[var2] = new byte[var1[var2]][];
            }

        } else {
            class195.field2584 = null;
            OwnWorldComparator.field866 = null;
            class319.field3930 = null;
        }
    }

    static int method3058(final int var0, int var1) {
        if (var0 == -1) {
            return 12345678;
        } else {
            var1 = (var0 & 127) * var1 / 128;
            if (var1 < 2) {
                var1 = 2;
            } else if (var1 > 126) {
                var1 = 126;
            }

            return (var0 & 65408) + var1;
        }
    }

    Model getModel() {
        return null;
    }

    void draw(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7, final int var8, final int var9) {
        final Model var10 = this.getModel();
        if (var10 != null) {
            this.modelHeight = var10.modelHeight;
            var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
        }

    }
}
