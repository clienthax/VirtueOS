package com.oldscape.client.reference;

import java.lang.ref.SoftReference;

class class219 extends class224 {
    private final SoftReference field2659;

    class219(final Object var1, final int var2) {
        super(var2);
        this.field2659 = new SoftReference<>(var1);
    }

    Object vmethod4084() {
        return this.field2659.get();
    }

    boolean vmethod4087() {
        return true;
    }
}
