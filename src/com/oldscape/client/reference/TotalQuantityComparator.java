package com.oldscape.client.reference;

import java.awt.*;
import java.util.Comparator;

final class TotalQuantityComparator implements Comparator {
    public static IndexDataBase overlay_ref;
    static int field302;
    static Image field304;

    static void method98(final int var0, final int var1) {
        final PacketNode var2 = WorldMapRectangle.method280(ClientPacket.field2405, Client.field957.field1484);
        var2.packetBuffer.putShort(var1);
        var2.packetBuffer.method3559(var0);
        Client.field957.method2052(var2);
    }

    private int method94(final GrandExchangeEvent var1, final GrandExchangeEvent var2) {
        return Integer.compare(var1.grandExchangeOffer.totalQuantity, var2.grandExchangeOffer.totalQuantity);
    }

    public boolean equals(final Object var1) {
        return super.equals(var1);
    }

    public int compare(final Object var1, final Object var2) {
        return this.method94((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }
}
