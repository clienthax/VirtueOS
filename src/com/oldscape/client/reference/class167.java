package com.oldscape.client.reference;

import java.io.File;

class class167 {
    public static CacheFile dat2File;
    public static CacheFile idx255File;
    static File jagexClDat;
    static CacheFile randomDat;
    static IndexedSprite field2223;

    static {
        randomDat = null;
        dat2File = null;
        idx255File = null;
    }

    static void method3256(final int var0, final int var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
        if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
            if (Client.lowMemory && var0 != BoundingBox3DDrawMode.plane) {
                return;
            }

            int var7 = 0;
            if (var1 == 0) {
                var7 = class255.region.getWallObjectHash(var0, var2, var3);
            }

            if (var1 == 1) {
                var7 = class255.region.method2879(var0, var2, var3);
            }

            if (var1 == 2) {
                var7 = class255.region.method2888(var0, var2, var3);
            }

            if (var1 == 3) {
                var7 = class255.region.getGroundObjectHash(var0, var2, var3);
            }

            int var11;
            if (var7 != 0) {
                var11 = class255.region.getObjectFlags(var0, var2, var3, var7);
                final int var13 = var7 >> 14 & 32767;
                final int var14 = var11 & 31;
                final int var15 = var11 >> 6 & 3;
                ObjectComposition var12;
                if (var1 == 0) {
                    class255.region.removeBoundaryObject(var0, var2, var3);
                    var12 = GameCanvas.getObjectDefinition(var13);
                    if (var12.clipType != 0) {
                        Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.blocksProjectile);
                    }
                }

                if (var1 == 1) {
                    class255.region.removeWallDecoration(var0, var2, var3);
                }

                if (var1 == 2) {
                    class255.region.method3035(var0, var2, var3);
                    var12 = GameCanvas.getObjectDefinition(var13);
                    if (var2 + var12.width > 103 || var3 + var12.width > 103 || var2 + var12.length > 103 || var3 + var12.length > 103) {
                        return;
                    }

                    if (var12.clipType != 0) {
                        Client.collisionMaps[var0].removeObject(var2, var3, var12.width, var12.length, var15, var12.blocksProjectile);
                    }
                }

                if (var1 == 3) {
                    class255.region.removeFloorDecoration(var0, var2, var3);
                    var12 = GameCanvas.getObjectDefinition(var13);
                    if (var12.clipType == 1) {
                        Client.collisionMaps[var0].method3401(var2, var3);
                    }
                }
            }

            if (var4 >= 0) {
                var11 = var0;
                if (var0 < 3 && (class62.tileSettings[1][var2][var3] & 2) == 2) {
                    var11 = var0 + 1;
                }

                class254.method4508(var0, var11, var2, var3, var4, var5, var6, class255.region, Client.collisionMaps[var0]);
            }
        }

    }
}
