package com.oldscape.client.reference;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class class45 extends WorldMapData {
    HashSet<class22> field572;
    HashSet<class46> field570;
    List<class25> field571;

    static String getColTags(final int var0) {
        return "<col=" + Integer.toHexString(var0) + ">";
    }

    static AttackOption[] method667() {
        return new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_hidden};
    }

    static void method672(final String var0) {
        final PacketNode var1 = WorldMapRectangle.method280(ClientPacket.field2434, Client.field957.field1484);
        var1.packetBuffer.putByte(WorldMapRegion.getLength(var0));
        var1.packetBuffer.putString(var0);
        Client.field957.method2052(var1);
    }

    static void changeWorld(final World var0) {
        if (var0.method1683() != Client.isMembers) {
            Client.isMembers = var0.method1683();
            World.method1724(var0.method1683());
        }

        Projectile.host = var0.address;
        Client.world = var0.id;
        Client.flags = var0.mask;
        class228.port1 = Client.socketType == 0 ? 43594 : var0.id + 40000;
        class243.port2 = Client.socketType == 0 ? 443 : var0.id + 50000;
        class138.myWorldPort = class228.port1;
    }

    void method669(final Buffer var1, final Buffer var2, final Buffer var3, final int var4, final boolean var5) {
        this.loadMapData(var1, var4);
        int size = var3.readUnsignedShort();
        this.field572 = new HashSet<>(size);

        for (int var7 = 0; var7 < size; ++var7) {
            final class22 var8 = new class22();

            try {
                var8.method185(var2, var3);
            } catch (final IllegalStateException var13) {
                continue;
            }

            this.field572.add(var8);
        }

        size = var3.readUnsignedShort();
        this.field570 = new HashSet<>(size);

        for (int var11 = 0; var11 < size; ++var11) {
            final class46 var9 = new class46();

            try {
                var9.method677(var2, var3);
            } catch (final IllegalStateException var12) {
                continue;
            }

            this.field570.add(var9);
        }

        this.method674(var2, var5);
    }

    private void method674(final Buffer var1, final boolean var2) {
        this.field571 = new LinkedList<>();
        final int var3 = var1.readUnsignedShort();

        for (int var4 = 0; var4 < var3; ++var4) {
            final int var5 = var1.method3576();
            final Coordinates var6 = new Coordinates(var1.readInt());
            final boolean var7 = var1.readUnsignedByte() == 1;
            if (var2 || !var7) {
                this.field571.add(new class25(var5, var6));
            }
        }

    }
}
