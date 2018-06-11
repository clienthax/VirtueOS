package com.oldscape.client.reference;

import java.util.Comparator;

final class UnitPriceComparator implements Comparator {
    private int method129(final GrandExchangeEvent var1, final GrandExchangeEvent var2) {
        return Integer.compare(var1.grandExchangeOffer.price, var2.grandExchangeOffer.price);
    }

    public int compare(final Object var1, final Object var2) {
        return this.method129((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    public boolean equals(final Object var1) {
        return super.equals(var1);
    }
}
