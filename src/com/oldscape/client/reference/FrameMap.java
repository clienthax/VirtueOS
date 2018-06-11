package com.oldscape.client.reference;

class FrameMap extends Node {
    static Buffer NetCache_reference;
    final int id;
    final int[] types;
    final int[][] list;
    private final int count;

    FrameMap(final int var1, final byte[] var2) {
        this.id = var1;
        final Buffer var3 = new Buffer(var2);
        this.count = var3.readUnsignedByte();
        this.types = new int[this.count];
        this.list = new int[this.count][];

        int var4;
        for (var4 = 0; var4 < this.count; ++var4) {
            this.types[var4] = var3.readUnsignedByte();
        }

        for (var4 = 0; var4 < this.count; ++var4) {
            this.list[var4] = new int[var3.readUnsignedByte()];
        }

        for (var4 = 0; var4 < this.count; ++var4) {
            for (int var5 = 0; var5 < this.list[var4].length; ++var5) {
                this.list[var4][var5] = var3.readUnsignedByte();
            }
        }

    }

    static void worldToMinimap(final int var0, final int var1, final int var2, final int var3, final SpritePixels spritePixels, final class236 var5) {
        final int var6 = var3 * var3 + var2 * var2;
        if (var6 > 4225 && var6 < 90000) {
            final int var7 = Client.mapAngle & 2047;
            final int var8 = Graphics3D.SINE[var7];
            final int var9 = Graphics3D.COSINE[var7];
            final int var10 = var9 * var2 + var3 * var8 >> 16;
            final int var11 = var3 * var9 - var8 * var2 >> 16;
            final double var12 = Math.atan2(var10, var11);
            final int var14 = var5.width / 2 - 25;
            final int var15 = (int) (Math.sin(var12) * var14);
            final int var16 = (int) (Math.cos(var12) * var14);
            final byte var17 = 20;
            Client.mapedge.method5876(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
        } else {
            class38.drawDot(var0, var1, var2, var3, spritePixels, var5);
        }

    }
}
