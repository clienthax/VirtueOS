package com.oldscape.client.reference;

final class class61 {
    static int field737;

    static void method1071() {
        for (class80 var0 = (class80) class80.field1263.getFront(); var0 != null; var0 = (class80) class80.field1263.getNext()) {
            if (var0.field1266 != null) {
                MouseInput.field727.method2060(var0.field1266);
                var0.field1266 = null;
            }

            if (var0.field1271 != null) {
                MouseInput.field727.method2060(var0.field1271);
                var0.field1271 = null;
            }
        }

        class80.field1263.clear();
    }

    static int method1072(final int var0, final int var1) {
        final ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.get(var0);
        return var2 == null ? -1 : (var1 >= 0 && var1 < var2.itemIds.length ? var2.itemIds[var1] : -1);
    }

    static void method1070() {
        final PacketNode var0 = WorldMapRectangle.method280(ClientPacket.field2404, Client.field957.field1484);
        final PacketBuffer var1 = var0.packetBuffer;
        final int var2 = Client.isResized ? 2 : 1;
        var1.putByte(var2);
        var0.packetBuffer.putShort(GameEngine.canvasWidth);
        var0.packetBuffer.putShort(GameEngine.canvasHeight);
        Client.field957.method2052(var0);
    }
}
