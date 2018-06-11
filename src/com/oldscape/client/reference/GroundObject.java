package com.oldscape.client.reference;

public final class GroundObject {
    static IndexedSprite[] mapscene;
    public Renderable renderable;
    public int hash;
    int floor;
    int x;
    int y;
    int renderInfoBitPacked;

    public static boolean method2669(final int var0) {
        return (var0 >> 21 & 1) != 0;
    }

    static void method2670() {
        if (Client.localPlayer.x >> 7 == Client.destinationX && Client.localPlayer.y >> 7 == Client.destinationY) {
            Client.destinationX = 0;
        }

    }

    static void method2671() {
        final PacketNode var0 = WorldMapRectangle.method280(ClientPacket.field2398, Client.field957.field1484);
        var0.packetBuffer.putByte(0);
        Client.field957.method2052(var0);
    }

    static int getWidgetClickMask(final Widget var0) {
        final IntegerNode var1 = (IntegerNode) Client.widgetFlags.get(((long) var0.id << 32) + var0.index);
        return var1 != null ? var1.value : var0.clickMask;
    }
}
