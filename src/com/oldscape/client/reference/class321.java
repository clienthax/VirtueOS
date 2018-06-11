package com.oldscape.client.reference;

import java.util.Comparator;

class class321 implements Comparator {
    static SpritePixels field3938;
    private final boolean field3937;

    public class321(final boolean var1) {
        this.field3937 = var1;
    }

    private int method5655(final Nameable var1, final Nameable var2) {
        return this.field3937 ? var1.doCompare(var2) : var2.doCompare(var1);
    }

    public int compare(final Object var1, final Object var2) {
        return this.method5655((Nameable) var1, (Nameable) var2);
    }

    public boolean equals(final Object var1) {
        return super.equals(var1);
    }
}
