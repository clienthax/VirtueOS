package com.oldscape.client.reference;

public class WorldMapType2 implements WorldMapSectionBase {
    static String field515;
    static MouseRecorder mouseRecorder;
    private int field519;
    private int field513;
    private int field516;
    private int field521;
    private int field514;
    private int field517;

    static class178 method578(final int var0, final int var1) {
        Client.field901.field2296 = var0;
        Client.field901.field2293 = var1;
        Client.field901.field2294 = 1;
        Client.field901.field2295 = 1;
        return Client.field901;
    }

    public void vmethod767(final WorldMapData worldMapData) {
        if (worldMapData.minX > this.field514) {
            worldMapData.minX = this.field514;
        }

        if (worldMapData.maxX < this.field514) {
            worldMapData.maxX = this.field514;
        }

        if (worldMapData.minY > this.field517) {
            worldMapData.minY = this.field517;
        }

        if (worldMapData.maxY < this.field517) {
            worldMapData.maxY = this.field517;
        }

    }

    public boolean containsCoord(final int plane, final int worldX, final int worldY) {
        return (plane >= this.field519 && plane < this.field513 + this.field519) && (worldX >> 6 == this.field516 && worldY >> 6 == this.field521);
    }

    public boolean vmethod768(final int worldX, final int worldY) {
        return worldX >> 6 == this.field514 && worldY >> 6 == this.field517;
    }

    public int[] vmethod753(final int plane, final int worldX, final int worldY) {
        if (!this.containsCoord(plane, worldX, worldY)) {
            return null;
        } else {
            return new int[]{this.field514 * 64 - this.field516 * 64 + worldX, worldY + (this.field517 * 64 - this.field521 * 64)};
        }
    }

    public Coordinates vmethod758(final int var1, final int var2) {
        if (!this.vmethod768(var1, var2)) {
            return null;
        } else {
            final int var3 = this.field516 * 64 - this.field514 * 64 + var1;
            final int var4 = this.field521 * 64 - this.field517 * 64 + var2;
            return new Coordinates(this.field519, var3, var4);
        }
    }

    public void decode(final Buffer var1) {
        this.field519 = var1.readUnsignedByte();
        this.field513 = var1.readUnsignedByte();
        this.field516 = var1.readUnsignedShort();
        this.field521 = var1.readUnsignedShort();
        this.field514 = var1.readUnsignedShort();
        this.field517 = var1.readUnsignedShort();
        this.method559();
    }

    private void method559() {
    }
}
