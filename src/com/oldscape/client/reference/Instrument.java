package com.oldscape.client.reference;

class Instrument extends Node {
    static CodeBook[] codeBooks;
    private static byte[] payload;
    private static int position;
    private static int bitPosition;
    private static int blockSize0;
    private static int blockSize1;
    private static Floor1[] floors;
    private static Residue[] residues;
    private static Mapping[] mappings;
    private static boolean[] modeBlockFlags;
    private static int[] modeMappings;
    private static boolean field1521;
    private static float[] field1532;
    private static float[] field1519;
    private static float[] field1534;
    private static float[] field1523;
    private static float[] field1536;
    private static float[] field1537;
    private static float[] field1538;
    private static int[] field1539;
    private static int[] field1540;

    static {
        field1521 = false;
    }

    private byte[][] field1518;
    private int field1511;
    private int field1512;
    private int field1513;
    private int field1514;
    private boolean field1515;
    private float[] field1530;
    private int field1529;
    private int field1527;
    private boolean field1531;
    private byte[] field1541;
    private int field1543;
    private int field1528;

    private Instrument(final byte[] var1) {
        this.method2161(var1);
    }

    private static void setBytes(final byte[] var0, final int var1) {
        payload = var0;
        position = var1;
        bitPosition = 0;
    }

    static int getBit() {
        final int var0 = payload[position] >> bitPosition & 1;
        ++bitPosition;
        position += bitPosition >> 3;
        bitPosition &= 7;
        return var0;
    }

    static int getInt(int var0) {
        int var1 = 0;

        int var2;
        int var3;
        for (var2 = 0; var0 >= 8 - bitPosition; var0 -= var3) {
            var3 = 8 - bitPosition;
            final int var4 = (1 << var3) - 1;
            var1 += (payload[position] >> bitPosition & var4) << var2;
            bitPosition = 0;
            ++position;
            var2 += var3;
        }

        if (var0 > 0) {
            var3 = (1 << var0) - 1;
            var1 += (payload[position] >> bitPosition & var3) << var2;
            bitPosition += var0;
        }

        return var1;
    }

    private static void init(final byte[] var0) {
        setBytes(var0, 0);
        blockSize0 = 1 << getInt(4);
        blockSize1 = 1 << getInt(4);
        field1532 = new float[blockSize1];

        int var1;
        int var2;
        int var3;
        int var4;
        int var5;
        for (var1 = 0; var1 < 2; ++var1) {
            var2 = var1 != 0 ? blockSize1 : blockSize0;
            var3 = var2 >> 1;
            var4 = var2 >> 2;
            var5 = var2 >> 3;
            final float[] var6 = new float[var3];

            for (int var7 = 0; var7 < var4; ++var7) {
                var6[var7 * 2] = (float) Math.cos((var7 * 4) * 3.141592653589793D / var2);
                var6[var7 * 2 + 1] = -((float) Math.sin((var7 * 4) * 3.141592653589793D / var2));
            }

            final float[] var18 = new float[var3];

            for (int var8 = 0; var8 < var4; ++var8) {
                var18[var8 * 2] = (float) Math.cos((var8 * 2 + 1) * 3.141592653589793D / (var2 * 2));
                var18[var8 * 2 + 1] = (float) Math.sin((var8 * 2 + 1) * 3.141592653589793D / (var2 * 2));
            }

            final float[] var19 = new float[var4];

            for (int var9 = 0; var9 < var5; ++var9) {
                var19[var9 * 2] = (float) Math.cos((var9 * 4 + 2) * 3.141592653589793D / var2);
                var19[var9 * 2 + 1] = -((float) Math.sin((var9 * 4 + 2) * 3.141592653589793D / var2));
            }

            final int[] var20 = new int[var5];
            final int var10 = MouseInput.ilog(var5 - 1);

            for (int var11 = 0; var11 < var5; ++var11) {
                int var15 = var11;
                int var16 = var10;

                int var17;
                for (var17 = 0; var16 > 0; --var16) {
                    var17 = var17 << 1 | var15 & 1;
                    var15 >>>= 1;
                }

                var20[var11] = var17;
            }

            if (var1 != 0) {
                field1536 = var6;
                field1537 = var18;
                field1538 = var19;
                field1540 = var20;
            } else {
                field1519 = var6;
                field1534 = var18;
                field1523 = var19;
                field1539 = var20;
            }
        }

        var1 = getInt(8) + 1;
        codeBooks = new CodeBook[var1];

        for (var2 = 0; var2 < var1; ++var2) {
            codeBooks[var2] = new CodeBook();
        }

        var2 = getInt(6) + 1;

        for (var3 = 0; var3 < var2; ++var3) {
            getInt(16);
        }

        var2 = getInt(6) + 1;
        floors = new Floor1[var2];

        for (var3 = 0; var3 < var2; ++var3) {
            floors[var3] = new Floor1();
        }

        var3 = getInt(6) + 1;
        residues = new Residue[var3];

        for (var4 = 0; var4 < var3; ++var4) {
            residues[var4] = new Residue();
        }

        var4 = getInt(6) + 1;
        mappings = new Mapping[var4];

        for (var5 = 0; var5 < var4; ++var5) {
            mappings[var5] = new Mapping();
        }

        var5 = getInt(6) + 1;
        modeBlockFlags = new boolean[var5];
        modeMappings = new int[var5];

        for (int var21 = 0; var21 < var5; ++var21) {
            modeBlockFlags[var21] = getBit() != 0;
            getInt(16);
            getInt(16);
            modeMappings[var21] = getInt(8);
        }

    }

    private static boolean loadDataBase(final IndexDataBase dataBase) {
        if (!field1521) {
            final byte[] data = dataBase.getConfigData(0, 0);
            if (data == null) {
                return false;
            }

            init(data);
            field1521 = true;
        }

        return true;
    }

    static Instrument getInstrument(final IndexDataBase indexDataBase, final int var1, final int var2) {
        if (!loadDataBase(indexDataBase)) {
            indexDataBase.tryLoadRecord(var1, var2);
            return null;
        } else {
            final byte[] var3 = indexDataBase.getConfigData(var1, var2);
            return var3 == null ? null : new Instrument(var3);
        }
    }

    private void method2161(final byte[] var1) {
        final Buffer var2 = new Buffer(var1);
        this.field1511 = var2.readInt();
        this.field1512 = var2.readInt();
        this.field1513 = var2.readInt();
        this.field1514 = var2.readInt();
        if (this.field1514 < 0) {
            this.field1514 = ~this.field1514;
            this.field1515 = true;
        }

        final int var3 = var2.readInt();
        this.field1518 = new byte[var3][];

        for (int var4 = 0; var4 < var3; ++var4) {
            int var5 = 0;

            int var6;
            do {
                var6 = var2.readUnsignedByte();
                var5 += var6;
            } while (var6 >= 255);

            final byte[] var7 = new byte[var5];
            var2.readBytes(var7, 0, var5);
            this.field1518[var4] = var7;
        }

    }

    private float[] method2134(final int var1) {
        setBytes(this.field1518[var1], 0);
        getBit();
        final int var2 = getInt(MouseInput.ilog(modeMappings.length - 1));
        final boolean var3 = modeBlockFlags[var2];
        final int var4 = var3 ? blockSize1 : blockSize0;
        boolean var5 = false;
        boolean var6 = false;
        if (var3) {
            var5 = getBit() != 0;
            var6 = getBit() != 0;
        }

        final int var7 = var4 >> 1;
        final int var8;
        final int var9;
        final int var10;
        if (var3 && !var5) {
            var8 = (var4 >> 2) - (blockSize0 >> 2);
            var9 = (blockSize0 >> 2) + (var4 >> 2);
            var10 = blockSize0 >> 1;
        } else {
            var8 = 0;
            var9 = var7;
            var10 = var4 >> 1;
        }

        final int var11;
        final int var12;
        final int var13;
        if (var3 && !var6) {
            var11 = var4 - (var4 >> 2) - (blockSize0 >> 2);
            var12 = (blockSize0 >> 2) + (var4 - (var4 >> 2));
            var13 = blockSize0 >> 1;
        } else {
            var11 = var7;
            var12 = var4;
            var13 = var4 >> 1;
        }

        final Mapping var14 = mappings[modeMappings[var2]];
        final int var16 = var14.mux;
        int var17 = var14.submapFloors[var16];
        final boolean var15 = !floors[var17].decodedFloor();

        for (var17 = 0; var17 < var14.field1664; ++var17) {
            final Residue var18 = residues[var14.field1662[var17]];
            final float[] var19 = field1532;
            var18.decodeResidue(var19, var4 >> 1, var15);
        }

        int var40;
        if (!var15) {
            var17 = var14.mux;
            var40 = var14.submapFloors[var17];
            floors[var40].computeFloor(field1532, var4 >> 1);
        }

        int var42;
        if (var15) {
            for (var17 = var4 >> 1; var17 < var4; ++var17) {
                field1532[var17] = 0.0F;
            }
        } else {
            var17 = var4 >> 1;
            var40 = var4 >> 2;
            var42 = var4 >> 3;
            final float[] var43 = field1532;

            int var21;
            for (var21 = 0; var21 < var17; ++var21) {
                var43[var21] *= 0.5F;
            }

            for (var21 = var17; var21 < var4; ++var21) {
                var43[var21] = -var43[var4 - var21 - 1];
            }

            final float[] var44 = var3 ? field1536 : field1519;
            final float[] var22 = var3 ? field1537 : field1534;
            final float[] var23 = var3 ? field1538 : field1523;
            final int[] var24 = var3 ? field1540 : field1539;

            int var25;
            float var26;
            float var27;
            float var28;
            float var29;
            for (var25 = 0; var25 < var40; ++var25) {
                var26 = var43[var25 * 4] - var43[var4 - var25 * 4 - 1];
                var27 = var43[var25 * 4 + 2] - var43[var4 - var25 * 4 - 3];
                var28 = var44[var25 * 2];
                var29 = var44[var25 * 2 + 1];
                var43[var4 - var25 * 4 - 1] = var26 * var28 - var27 * var29;
                var43[var4 - var25 * 4 - 3] = var26 * var29 + var27 * var28;
            }

            float var30;
            float var31;
            for (var25 = 0; var25 < var42; ++var25) {
                var26 = var43[var17 + var25 * 4 + 3];
                var27 = var43[var17 + var25 * 4 + 1];
                var28 = var43[var25 * 4 + 3];
                var29 = var43[var25 * 4 + 1];
                var43[var17 + var25 * 4 + 3] = var26 + var28;
                var43[var17 + var25 * 4 + 1] = var27 + var29;
                var30 = var44[var17 - 4 - var25 * 4];
                var31 = var44[var17 - 3 - var25 * 4];
                var43[var25 * 4 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
                var43[var25 * 4 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
            }

            var25 = MouseInput.ilog(var4 - 1);

            int var47;
            int var48;
            int var49;
            int var50;
            for (var47 = 0; var47 < var25 - 3; ++var47) {
                var48 = var4 >> var47 + 2;
                var49 = 8 << var47;

                for (var50 = 0; var50 < 2 << var47; ++var50) {
                    final int var51 = var4 - var48 * var50 * 2;
                    final int var52 = var4 - var48 * (var50 * 2 + 1);

                    for (int var32 = 0; var32 < var4 >> var47 + 4; ++var32) {
                        final int var33 = var32 * 4;
                        final float var34 = var43[var51 - 1 - var33];
                        final float var35 = var43[var51 - 3 - var33];
                        final float var36 = var43[var52 - 1 - var33];
                        final float var37 = var43[var52 - 3 - var33];
                        var43[var51 - 1 - var33] = var34 + var36;
                        var43[var51 - 3 - var33] = var35 + var37;
                        final float var38 = var44[var32 * var49];
                        final float var39 = var44[var32 * var49 + 1];
                        var43[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                        var43[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
                    }
                }
            }

            for (var47 = 1; var47 < var42 - 1; ++var47) {
                var48 = var24[var47];
                if (var47 < var48) {
                    var49 = var47 * 8;
                    var50 = var48 * 8;
                    var30 = var43[var49 + 1];
                    var43[var49 + 1] = var43[var50 + 1];
                    var43[var50 + 1] = var30;
                    var30 = var43[var49 + 3];
                    var43[var49 + 3] = var43[var50 + 3];
                    var43[var50 + 3] = var30;
                    var30 = var43[var49 + 5];
                    var43[var49 + 5] = var43[var50 + 5];
                    var43[var50 + 5] = var30;
                    var30 = var43[var49 + 7];
                    var43[var49 + 7] = var43[var50 + 7];
                    var43[var50 + 7] = var30;
                }
            }

            for (var47 = 0; var47 < var17; ++var47) {
                var43[var47] = var43[var47 * 2 + 1];
            }

            for (var47 = 0; var47 < var42; ++var47) {
                var43[var4 - 1 - var47 * 2] = var43[var47 * 4];
                var43[var4 - 2 - var47 * 2] = var43[var47 * 4 + 1];
                var43[var4 - var40 - 1 - var47 * 2] = var43[var47 * 4 + 2];
                var43[var4 - var40 - 2 - var47 * 2] = var43[var47 * 4 + 3];
            }

            for (var47 = 0; var47 < var42; ++var47) {
                var27 = var23[var47 * 2];
                var28 = var23[var47 * 2 + 1];
                var29 = var43[var17 + var47 * 2];
                var30 = var43[var17 + var47 * 2 + 1];
                var31 = var43[var4 - 2 - var47 * 2];
                final float var53 = var43[var4 - 1 - var47 * 2];
                float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
                var43[var17 + var47 * 2] = (var29 + var31 + var54) * 0.5F;
                var43[var4 - 2 - var47 * 2] = (var29 + var31 - var54) * 0.5F;
                var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
                var43[var17 + var47 * 2 + 1] = (var30 - var53 + var54) * 0.5F;
                var43[var4 - 1 - var47 * 2] = (-var30 + var53 + var54) * 0.5F;
            }

            for (var47 = 0; var47 < var40; ++var47) {
                var43[var47] = var43[var17 + var47 * 2] * var22[var47 * 2] + var43[var17 + var47 * 2 + 1] * var22[var47 * 2 + 1];
                var43[var17 - 1 - var47] = var43[var17 + var47 * 2] * var22[var47 * 2 + 1] - var43[var17 + var47 * 2 + 1] * var22[var47 * 2];
            }

            for (var47 = 0; var47 < var40; ++var47) {
                var43[var47 + (var4 - var40)] = -var43[var47];
            }

            for (var47 = 0; var47 < var40; ++var47) {
                var43[var47] = var43[var40 + var47];
            }

            for (var47 = 0; var47 < var40; ++var47) {
                var43[var40 + var47] = -var43[var40 - var47 - 1];
            }

            for (var47 = 0; var47 < var40; ++var47) {
                var43[var17 + var47] = var43[var4 - var47 - 1];
            }

            for (var47 = var8; var47 < var9; ++var47) {
                var27 = (float) Math.sin(((var47 - var8) + 0.5D) / var10 * 0.5D * 3.141592653589793D);
                field1532[var47] *= (float) Math.sin(1.5707963267948966D * var27 * var27);
            }

            for (var47 = var11; var47 < var12; ++var47) {
                var27 = (float) Math.sin(((var47 - var11) + 0.5D) / var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
                field1532[var47] *= (float) Math.sin(1.5707963267948966D * var27 * var27);
            }
        }

        float[] var41 = null;
        if (this.field1529 > 0) {
            var40 = var4 + this.field1529 >> 2;
            var41 = new float[var40];
            int var20;
            if (!this.field1531) {
                for (var42 = 0; var42 < this.field1527; ++var42) {
                    var20 = var42 + (this.field1529 >> 1);
                    var41[var42] += this.field1530[var20];
                }
            }

            if (!var15) {
                for (var42 = var8; var42 < var4 >> 1; ++var42) {
                    var20 = var41.length - (var4 >> 1) + var42;
                    var41[var20] += field1532[var42];
                }
            }
        }

        final float[] var46 = this.field1530;
        this.field1530 = field1532;
        field1532 = var46;
        this.field1529 = var4;
        this.field1527 = var12 - (var4 >> 1);
        this.field1531 = var15;
        return var41;
    }

    RawAudioNode method2138(final int[] var1) {
        if (var1 != null && var1[0] <= 0) {
            return null;
        } else {
            if (this.field1541 == null) {
                this.field1529 = 0;
                this.field1530 = new float[blockSize1];
                this.field1541 = new byte[this.field1512];
                this.field1543 = 0;
                this.field1528 = 0;
            }

            for (; this.field1528 < this.field1518.length; ++this.field1528) {
                if (var1 != null && var1[0] <= 0) {
                    return null;
                }

                final float[] var2 = this.method2134(this.field1528);
                if (var2 != null) {
                    int var3 = this.field1543;
                    int var4 = var2.length;
                    if (var4 > this.field1512 - var3) {
                        var4 = this.field1512 - var3;
                    }

                    for (int var5 = 0; var5 < var4; ++var5) {
                        int var6 = (int) (128.0F + var2[var5] * 128.0F);
                        if ((var6 & -256) != 0) {
                            var6 = ~var6 >> 31;
                        }

                        this.field1541[var3++] = (byte) (var6 - 128);
                    }

                    if (var1 != null) {
                        var1[0] -= var3 - this.field1543;
                    }

                    this.field1543 = var3;
                }
            }

            this.field1530 = null;
            final byte[] var7 = this.field1541;
            this.field1541 = null;
            return new RawAudioNode(this.field1511, var7, this.field1513, this.field1514, this.field1515);
        }
    }
}
