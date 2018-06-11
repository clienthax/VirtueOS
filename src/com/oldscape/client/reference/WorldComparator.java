package com.oldscape.client.reference;

import java.util.Comparator;

final class WorldComparator implements Comparator {

    private int doCompare(final GrandExchangeEvent var1, final GrandExchangeEvent var2) {
        return Integer.compare(var1.world, var2.world);
    }

    public boolean equals(final Object var1) {
        return super.equals(var1);
    }

    public int compare(final Object var1, final Object var2) {
        return this.doCompare((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

}
