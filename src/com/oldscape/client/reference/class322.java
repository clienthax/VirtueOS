package com.oldscape.client.reference;

import java.util.Comparator;

class class322 implements Comparator {
    private final boolean field3939;

    public class322(final boolean var1) {
        this.field3939 = var1;
    }

    private int method5665(final Nameable var1, final Nameable var2) {
        return this.field3939 ? var1.getCurrentName().compareCleanName(var2.getCurrentName()) : var2.getCurrentName().compareCleanName(var1.getCurrentName());
    }

    public int compare(final Object var1, final Object var2) {
        return this.method5665((Nameable) var1, (Nameable) var2);
    }

    public boolean equals(final Object var1) {
        return super.equals(var1);
    }
}
