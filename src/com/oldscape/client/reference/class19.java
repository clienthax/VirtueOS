package com.oldscape.client.reference;

import java.util.Comparator;

final class class19 implements Comparator {
    static IndexFile indexStore255;
    static SpritePixels[] mapMarkers;

    public static int method167(final String var0) {
        return var0.length() + 2;
    }

    public static void method166(final int x, final int y, final int plane, final boolean var3) {
        final PacketNode packetNode = WorldMapRectangle.method280(ClientPacket.field2457, Client.field957.field1484);
        packetNode.packetBuffer.method3559(var3 ? Client.field970 : 0);
        packetNode.packetBuffer.method3528(x);
        packetNode.packetBuffer.method3543(plane);
        packetNode.packetBuffer.putShort(y);
        Client.field957.method2052(packetNode);
    }

    private int doCompare(final GrandExchangeEvent var1, final GrandExchangeEvent var2) {
        return Long.compare(var1.field292, var2.field292);
    }

    public int compare(final Object var1, final Object var2) {
        return this.doCompare((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    public boolean equals(final Object var1) {
        return super.equals(var1);
    }
}
