package com.oldscape.client.reference;

public class WorldMapType1 implements WorldMapSectionBase {
    private int plane;
    private int field438;
    private int field429;
    private int field431;
    private int field440;
    private int field432;
    private int field427;
    private int field434;
    private int field428;
    private int field436;

    static String method309(final IterableHashTable params, final int id, final String defaultValue) {
        if (params == null) {
            return defaultValue;
        } else {
            final ObjectNode var3 = (ObjectNode) params.get(id);
            return var3 == null ? defaultValue : (String) var3.value;
        }
    }

    static void method308(final World[] var0, final int var1, final int var2, final int[] var3, final int[] var4) {
        if (var1 < var2) {
            int var5 = var1 - 1;
            int var6 = var2 + 1;
            final int var7 = (var2 + var1) / 2;
            final World var8 = var0[var7];
            var0[var7] = var0[var1];
            var0[var1] = var8;

            while (var5 < var6) {
                boolean var9 = true;

                int var10;
                int var11;
                int var12;
                do {
                    --var6;

                    for (var10 = 0; var10 < 4; ++var10) {
                        if (var3[var10] == 2) {
                            var11 = var0[var6].index;
                            var12 = var8.index;
                        } else if (var3[var10] == 1) {
                            var11 = var0[var6].playerCount;
                            var12 = var8.playerCount;
                            if (var11 == -1 && var4[var10] == 1) {
                                var11 = 2001;
                            }

                            if (var12 == -1 && var4[var10] == 1) {
                                var12 = 2001;
                            }
                        } else if (var3[var10] == 3) {
                            var11 = var0[var6].method1683() ? 1 : 0;
                            var12 = var8.method1683() ? 1 : 0;
                        } else {
                            var11 = var0[var6].id;
                            var12 = var8.id;
                        }

                        if (var11 != var12) {
                            if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                                var9 = false;
                            }
                            break;
                        }

                        if (var10 == 3) {
                            var9 = false;
                        }
                    }
                } while (var9);

                var9 = true;

                do {
                    ++var5;

                    for (var10 = 0; var10 < 4; ++var10) {
                        if (var3[var10] == 2) {
                            var11 = var0[var5].index;
                            var12 = var8.index;
                        } else if (var3[var10] == 1) {
                            var11 = var0[var5].playerCount;
                            var12 = var8.playerCount;
                            if (var11 == -1 && var4[var10] == 1) {
                                var11 = 2001;
                            }

                            if (var12 == -1 && var4[var10] == 1) {
                                var12 = 2001;
                            }
                        } else if (var3[var10] == 3) {
                            var11 = var0[var5].method1683() ? 1 : 0;
                            var12 = var8.method1683() ? 1 : 0;
                        } else {
                            var11 = var0[var5].id;
                            var12 = var8.id;
                        }

                        if (var11 != var12) {
                            if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                                var9 = false;
                            }
                            break;
                        }

                        if (var10 == 3) {
                            var9 = false;
                        }
                    }
                } while (var9);

                if (var5 < var6) {
                    final World var13 = var0[var5];
                    var0[var5] = var0[var6];
                    var0[var6] = var13;
                }
            }

            method308(var0, var1, var6, var3, var4);
            method308(var0, var6 + 1, var2, var3, var4);
        }

    }

    public void vmethod767(final WorldMapData worldMapData) {
        if (worldMapData.minX > this.field427) {
            worldMapData.minX = this.field427;
        }

        if (worldMapData.maxX < this.field428) {
            worldMapData.maxX = this.field428;
        }

        if (worldMapData.minY > this.field434) {
            worldMapData.minY = this.field434;
        }

        if (worldMapData.maxY < this.field436) {
            worldMapData.maxY = this.field436;
        }

    }

    public boolean containsCoord(final int plane, final int worldX, final int worldY) {
        return (plane >= this.plane && plane < this.field438 + this.plane) && (worldX >> 6 >= this.field429 && worldX >> 6 <= this.field440 && worldY >> 6 >= this.field431 && worldY >> 6 <= this.field432);
    }

    public boolean vmethod768(final int worldX, final int worldY) {
        return worldX >> 6 >= this.field427 && worldX >> 6 <= this.field428 && worldY >> 6 >= this.field434 && worldY >> 6 <= this.field436;
    }

    public int[] vmethod753(final int plane, final int worldX, final int worldY) {
        if (!this.containsCoord(plane, worldX, worldY)) {
            return null;
        } else {
            return new int[]{this.field427 * 64 - this.field429 * 64 + worldX, worldY + (this.field434 * 64 - this.field431 * 64)};
        }
    }

    public Coordinates vmethod758(final int var1, final int var2) {
        if (!this.vmethod768(var1, var2)) {
            return null;
        } else {
            final int x = this.field429 * 64 - this.field427 * 64 + var1;
            final int y = this.field431 * 64 - this.field434 * 64 + var2;
            return new Coordinates(this.plane, x, y);
        }
    }

    public void decode(final Buffer var1) {
        this.plane = var1.readUnsignedByte();
        this.field438 = var1.readUnsignedByte();
        this.field429 = var1.readUnsignedShort();
        this.field431 = var1.readUnsignedShort();
        this.field440 = var1.readUnsignedShort();
        this.field432 = var1.readUnsignedShort();
        this.field427 = var1.readUnsignedShort();
        this.field434 = var1.readUnsignedShort();
        this.field428 = var1.readUnsignedShort();
        this.field436 = var1.readUnsignedShort();
        this.method288();
    }

    private void method288() {
    }
}
