package com.oldscape.client.reference;

public class WorldMapType3 implements WorldMapSectionBase {
    static IndexData indexCache3;
    private int field380;
    private int field381;
    private int field382;
    private int field383;
    private int field392;
    private int field385;
    private int field386;
    private int field387;
    private int field384;
    private int field389;
    private int field390;
    private int field391;
    private int field394;
    private int field393;

    static Script method233(final int var0) {
        Script var2 = (Script) Script.field1459.get((var0 << 16));
        if (var2 != null) {
            return var2;
        } else {
            final String var3 = String.valueOf(var0);
            final int var4 = class190.indexScripts.getFile(var3);
            if (var4 != -1) {
                final byte[] var5 = class190.indexScripts.takeRecordFlat(var4);
                if (var5 != null) {
                    if (var5.length <= 1) {
                        return null;
                    }

                    var2 = Signlink.newScript(var5);
                    if (var2 != null) {
                        Script.field1459.put(var2, (var0 << 16));
                        return var2;
                    }
                }

            }
            return null;
        }
    }

    public static void method237() {
        VarPlayerType.varplayers.reset();
    }

    public static int method235() {
        return KeyFocusListener.keyboardIdleTicks;
    }

    static byte[] decodeContainer(final byte[] var0) {
        final Buffer var1 = new Buffer(var0);
        final int var2 = var1.readUnsignedByte();
        final int var3 = var1.readInt();
        if (var3 < 0 || IndexDataBase.field3393 != 0 && var3 > IndexDataBase.field3393) {
            throw new RuntimeException();
        } else if (var2 == 0) {
            final byte[] var4 = new byte[var3];
            var1.readBytes(var4, 0, var3);
            return var4;
        } else {
            final int var6 = var1.readInt();
            if (var6 < 0 || IndexDataBase.field3393 != 0 && var6 > IndexDataBase.field3393) {
                throw new RuntimeException();
            } else {
                final byte[] var5 = new byte[var6];
                if (var2 == 1) {
                    class188.Bzip2Decompressor_decompress(var5, var6, var0, 9);
                } else {
                    IndexDataBase.gzip.decompress(var1, var5);
                }

                return var5;
            }
        }
    }

    static void method232(final boolean var0) {
        if (var0) {
            Client.field907 = class90.field1385 ? class158.field2171 : class158.field2173;
        } else {
            Client.field907 = Client.preferences.preferences.containsKey(class228.method4120(class90.username)) ? class158.field2177 : class158.field2172;
        }

    }

    public void vmethod767(final WorldMapData worldMapData) {
        if (worldMapData.minX > this.field392) {
            worldMapData.minX = this.field392;
        }

        if (worldMapData.maxX < this.field392) {
            worldMapData.maxX = this.field392;
        }

        if (worldMapData.minY > this.field385) {
            worldMapData.minY = this.field385;
        }

        if (worldMapData.maxY < this.field385) {
            worldMapData.maxY = this.field385;
        }

    }

    public boolean containsCoord(final int plane, final int worldX, final int worldY) {
        return (plane >= this.field380 && plane < this.field380 + this.field381) && (worldX >= (this.field382 << 6) + (this.field386 << 3) && worldX <= (this.field382 << 6) + (this.field384 << 3) + 7 && worldY >= (this.field383 << 6) + (this.field387 << 3) && worldY <= (this.field383 << 6) + (this.field389 << 3) + 7);
    }

    public boolean vmethod768(final int worldX, final int worldY) {
        return worldX >= (this.field392 << 6) + (this.field390 << 3) && worldX <= (this.field392 << 6) + (this.field394 << 3) + 7 && worldY >= (this.field385 << 6) + (this.field391 << 3) && worldY <= (this.field385 << 6) + (this.field393 << 3) + 7;
    }

    public int[] vmethod753(final int plane, final int worldX, final int worldY) {
        if (!this.containsCoord(plane, worldX, worldY)) {
            return null;
        } else {
            return new int[]{this.field392 * 64 - this.field382 * 64 + worldX + (this.field390 * 8 - this.field386 * 8), worldY + (this.field385 * 64 - this.field383 * 64) + (this.field391 * 8 - this.field387 * 8)};
        }
    }

    public Coordinates vmethod758(final int var1, final int var2) {
        if (!this.vmethod768(var1, var2)) {
            return null;
        } else {
            final int var3 = this.field382 * 64 - this.field392 * 64 + (this.field386 * 8 - this.field390 * 8) + var1;
            final int var4 = this.field383 * 64 - this.field385 * 64 + var2 + (this.field387 * 8 - this.field391 * 8);
            return new Coordinates(this.field380, var3, var4);
        }
    }

    public void decode(final Buffer buffer) {
        this.field380 = buffer.readUnsignedByte();
        this.field381 = buffer.readUnsignedByte();
        this.field382 = buffer.readUnsignedShort();
        this.field386 = buffer.readUnsignedByte();
        this.field384 = buffer.readUnsignedByte();
        this.field383 = buffer.readUnsignedShort();
        this.field387 = buffer.readUnsignedByte();
        this.field389 = buffer.readUnsignedByte();
        this.field392 = buffer.readUnsignedShort();
        this.field390 = buffer.readUnsignedByte();
        this.field394 = buffer.readUnsignedByte();
        this.field385 = buffer.readUnsignedShort();
        this.field391 = buffer.readUnsignedByte();
        this.field393 = buffer.readUnsignedByte();
        this.decodeNext();
    }

    private void decodeNext() {
    }

}
