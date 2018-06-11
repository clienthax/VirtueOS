package com.oldscape.client.reference;

import java.util.Comparator;

class class149 implements Comparator {
    private final boolean field2141;

    class149(final boolean var1) {
        this.field2141 = var1;
    }

    static void method3104(final int xMin, final int yMin, final int xMax, final int yMax, final int color) {
        class7.boundingBoxes.addFirst(new BoundingBox2D(xMin, yMin, xMax, yMax, color));
    }

    private int doCompare(final ChatPlayer var1, final ChatPlayer var2) {
        return this.field2141 ? var1.field3845 - var2.field3845 : var2.field3845 - var1.field3845;
    }

    public int compare(final Object var1, final Object var2) {
        return this.doCompare((ChatPlayer) var1, (ChatPlayer) var2);
    }

    public boolean equals(final Object var1) {
        return super.equals(var1);
    }
}
