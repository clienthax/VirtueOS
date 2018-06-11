package com.oldscape.client.reference;

class class155 extends class297 {

    private final boolean field2163;

    class155(final boolean var1) {
        this.field2163 = var1;
    }

    private int doCompare(final ChatPlayer var1, final ChatPlayer var2) {
        return var2.world != var1.world ? (this.field2163 ? var1.world - var2.world : var2.world - var1.world) : this.doCompare(var1, var2);
    }

    public int compare(final Object var1, final Object var2) {
        return this.doCompare((ChatPlayer) var1, (ChatPlayer) var2);
    }

}
