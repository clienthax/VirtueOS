package com.oldscape.client.reference;

public final class ISAACCipher {
    private final int[] randResult;
    private final int[] mm;
    private int valuesRemaining;
    private int field2613;
    private int field2611;
    private int field2612;

    public ISAACCipher(final int[] var1) {
        this.mm = new int[256];
        this.randResult = new int[256];

        System.arraycopy(var1, 0, this.randResult, 0, var1.length);

        this.method3812();
    }

    static void method3809(final boolean var0) {
        for (int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
            final NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
            int var3 = (Client.npcIndices[var1] << 14) + 536870912;
            if (var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method5123()) {
                final int var4 = var2.x >> 7;
                final int var5 = var2.y >> 7;
                if (var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
                    if (var2.size == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                        if (Client.field966[var4][var5] == Client.field1137) {
                            continue;
                        }

                        Client.field966[var4][var5] = Client.field1137;
                    }

                    if (!var2.composition.field3724) {
                        var3 -= Integer.MIN_VALUE;
                    }

                    var2.field1161 = Client.gameCycle;
                    class255.region.method2863(BoundingBox3DDrawMode.plane, var2.x, var2.y, WorldMapManager.getTileHeight(var2.size * 64 - 64 + var2.x, var2.size * 64 - 64 + var2.y, BoundingBox3DDrawMode.plane), var2.size * 64 - 64 + 60, var2, var2.angle, var3, var2.field1159);
                }
            }
        }

    }

    static boolean method3821() {
        return (Client.playerNameMask & 1) != 0;
    }

    final int nextInt() {
        if (0 == --this.valuesRemaining + 1) {
            this.generateMoreResults();
            this.valuesRemaining = 255;
        }

        return this.randResult[this.valuesRemaining];
    }

    final int method3813() {
        if (this.valuesRemaining == 0) {
            this.generateMoreResults();
            this.valuesRemaining = 256;
        }

        return this.randResult[this.valuesRemaining - 1];
    }

    private void generateMoreResults() {
        this.field2611 += ++this.field2612;

        for (int var1 = 0; var1 < 256; ++var1) {
            final int var2 = this.mm[var1];
            if ((var1 & 2) == 0) {
                if ((var1 & 1) == 0) {
                    this.field2613 ^= this.field2613 << 13;
                } else {
                    this.field2613 ^= this.field2613 >>> 6;
                }
            } else if ((var1 & 1) == 0) {
                this.field2613 ^= this.field2613 << 2;
            } else {
                this.field2613 ^= this.field2613 >>> 16;
            }

            this.field2613 += this.mm[var1 + 128 & 255];
            final int var3;
            this.mm[var1] = var3 = this.mm[(var2 & 1020) >> 2] + this.field2613 + this.field2611;
            this.randResult[var1] = this.field2611 = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
        }

    }

    private void method3812() {
        int var9 = -1640531527;
        int var8 = -1640531527;
        int var7 = -1640531527;
        int var6 = -1640531527;
        int var5 = -1640531527;
        int var4 = -1640531527;
        int var3 = -1640531527;
        int var2 = -1640531527;

        int var1;
        for (var1 = 0; var1 < 4; ++var1) {
            var2 ^= var3 << 11;
            var5 += var2;
            var3 += var4;
            var3 ^= var4 >>> 2;
            var6 += var3;
            var4 += var5;
            var4 ^= var5 << 8;
            var7 += var4;
            var5 += var6;
            var5 ^= var6 >>> 16;
            var8 += var5;
            var6 += var7;
            var6 ^= var7 << 10;
            var9 += var6;
            var7 += var8;
            var7 ^= var8 >>> 4;
            var2 += var7;
            var8 += var9;
            var8 ^= var9 << 8;
            var3 += var8;
            var9 += var2;
            var9 ^= var2 >>> 9;
            var4 += var9;
            var2 += var3;
        }

        for (var1 = 0; var1 < 256; var1 += 8) {
            var2 += this.randResult[var1];
            var3 += this.randResult[var1 + 1];
            var4 += this.randResult[var1 + 2];
            var5 += this.randResult[var1 + 3];
            var6 += this.randResult[var1 + 4];
            var7 += this.randResult[var1 + 5];
            var8 += this.randResult[var1 + 6];
            var9 += this.randResult[var1 + 7];
            var2 ^= var3 << 11;
            var5 += var2;
            var3 += var4;
            var3 ^= var4 >>> 2;
            var6 += var3;
            var4 += var5;
            var4 ^= var5 << 8;
            var7 += var4;
            var5 += var6;
            var5 ^= var6 >>> 16;
            var8 += var5;
            var6 += var7;
            var6 ^= var7 << 10;
            var9 += var6;
            var7 += var8;
            var7 ^= var8 >>> 4;
            var2 += var7;
            var8 += var9;
            var8 ^= var9 << 8;
            var3 += var8;
            var9 += var2;
            var9 ^= var2 >>> 9;
            var4 += var9;
            var2 += var3;
            this.mm[var1] = var2;
            this.mm[var1 + 1] = var3;
            this.mm[var1 + 2] = var4;
            this.mm[var1 + 3] = var5;
            this.mm[var1 + 4] = var6;
            this.mm[var1 + 5] = var7;
            this.mm[var1 + 6] = var8;
            this.mm[var1 + 7] = var9;
        }

        for (var1 = 0; var1 < 256; var1 += 8) {
            var2 += this.mm[var1];
            var3 += this.mm[var1 + 1];
            var4 += this.mm[var1 + 2];
            var5 += this.mm[var1 + 3];
            var6 += this.mm[var1 + 4];
            var7 += this.mm[var1 + 5];
            var8 += this.mm[var1 + 6];
            var9 += this.mm[var1 + 7];
            var2 ^= var3 << 11;
            var5 += var2;
            var3 += var4;
            var3 ^= var4 >>> 2;
            var6 += var3;
            var4 += var5;
            var4 ^= var5 << 8;
            var7 += var4;
            var5 += var6;
            var5 ^= var6 >>> 16;
            var8 += var5;
            var6 += var7;
            var6 ^= var7 << 10;
            var9 += var6;
            var7 += var8;
            var7 ^= var8 >>> 4;
            var2 += var7;
            var8 += var9;
            var8 ^= var9 << 8;
            var3 += var8;
            var9 += var2;
            var9 ^= var2 >>> 9;
            var4 += var9;
            var2 += var3;
            this.mm[var1] = var2;
            this.mm[var1 + 1] = var3;
            this.mm[var1 + 2] = var4;
            this.mm[var1 + 3] = var5;
            this.mm[var1 + 4] = var6;
            this.mm[var1 + 5] = var7;
            this.mm[var1 + 6] = var8;
            this.mm[var1 + 7] = var9;
        }

        this.generateMoreResults();
        this.valuesRemaining = 256;
    }
}
