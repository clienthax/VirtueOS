package com.oldscape.client.reference;

import java.util.Comparator;

class OwnWorldComparator implements Comparator {
    static int[] field866;
    boolean field865;

    static void method1247(final PendingSpawn pendingSpawn) {
        int var1 = 0;
        int var2 = -1;
        int var3 = 0;
        int var4 = 0;
        if (pendingSpawn.type == 0) {
            var1 = class255.region.getWallObjectHash(pendingSpawn.level, pendingSpawn.x, pendingSpawn.y);
        }

        if (pendingSpawn.type == 1) {
            var1 = class255.region.method2879(pendingSpawn.level, pendingSpawn.x, pendingSpawn.y);
        }

        if (pendingSpawn.type == 2) {
            var1 = class255.region.method2888(pendingSpawn.level, pendingSpawn.x, pendingSpawn.y);
        }

        if (pendingSpawn.type == 3) {
            var1 = class255.region.getGroundObjectHash(pendingSpawn.level, pendingSpawn.x, pendingSpawn.y);
        }

        if (var1 != 0) {
            final int var5 = class255.region.getObjectFlags(pendingSpawn.level, pendingSpawn.x, pendingSpawn.y, var1);
            var2 = var1 >> 14 & 32767;
            var3 = var5 & 31;
            var4 = var5 >> 6 & 3;
        }

        pendingSpawn.field1146 = var2;
        pendingSpawn.field1147 = var3;
        pendingSpawn.field1144 = var4;
    }

    static void method1248() {
        Client.field1060 = Client.cycleCntr;
    }

    private int method1234(final GrandExchangeEvent var1, final GrandExchangeEvent var2) {
        if (var2.world == var1.world) {
            return 0;
        } else {
            if (this.field865) {
                if (Client.world == var1.world) {
                    return -1;
                }

                if (var2.world == Client.world) {
                    return 1;
                }
            }

            return var1.world < var2.world ? -1 : 1;
        }
    }

    public int compare(final Object var1, final Object var2) {
        return this.method1234((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
    }

    public boolean equals(final Object var1) {
        return super.equals(var1);
    }
}
