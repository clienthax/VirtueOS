package com.oldscape.client.reference;

class CodeBook {
    final int dimensions;
    private final int entries;
    private final int[] entryLengths;
    private int[] field1501;
    private float[][] valueVector;
    private int[] field1500;

    CodeBook() {
        Instrument.getInt(24);
        this.dimensions = Instrument.getInt(16);
        this.entries = Instrument.getInt(24);
        this.entryLengths = new int[this.entries];
        final boolean var1 = Instrument.getBit() != 0;
        int var2;
        int var3;
        int var5;
        if (var1) {
            var2 = 0;

            for (var3 = Instrument.getInt(5) + 1; var2 < this.entries; ++var3) {
                final int var4 = Instrument.getInt(MouseInput.ilog(this.entries - var2));

                for (var5 = 0; var5 < var4; ++var5) {
                    this.entryLengths[var2++] = var3;
                }
            }
        } else {
            final boolean var14 = Instrument.getBit() != 0;

            for (var3 = 0; var3 < this.entries; ++var3) {
                if (var14 && Instrument.getBit() == 0) {
                    this.entryLengths[var3] = 0;
                } else {
                    this.entryLengths[var3] = Instrument.getInt(5) + 1;
                }
            }
        }

        this.createHuffmanTree();
        var2 = Instrument.getInt(4);
        if (var2 > 0) {
            final float var15 = float32Unpack(Instrument.getInt(32));
            final float var16 = float32Unpack(Instrument.getInt(32));
            var5 = Instrument.getInt(4) + 1;
            final boolean var6 = Instrument.getBit() != 0;
            final int var7;
            if (var2 == 1) {
                var7 = method2110(this.entries, this.dimensions);
            } else {
                var7 = this.entries * this.dimensions;
            }

            this.field1501 = new int[var7];

            int var8;
            for (var8 = 0; var8 < var7; ++var8) {
                this.field1501[var8] = Instrument.getInt(var5);
            }

            this.valueVector = new float[this.entries][this.dimensions];
            float var9;
            int var10;
            int var11;
            if (var2 == 1) {
                for (var8 = 0; var8 < this.entries; ++var8) {
                    var9 = 0.0F;
                    var10 = 1;

                    for (var11 = 0; var11 < this.dimensions; ++var11) {
                        final int var12 = var8 / var10 % var7;
                        final float var13 = this.field1501[var12] * var16 + var15 + var9;
                        this.valueVector[var8][var11] = var13;
                        if (var6) {
                            var9 = var13;
                        }

                        var10 *= var7;
                    }
                }
            } else {
                for (var8 = 0; var8 < this.entries; ++var8) {
                    var9 = 0.0F;
                    var10 = var8 * this.dimensions;

                    for (var11 = 0; var11 < this.dimensions; ++var11) {
                        final float var17 = this.field1501[var10] * var16 + var15 + var9;
                        this.valueVector[var8][var11] = var17;
                        if (var6) {
                            var9 = var17;
                        }

                        ++var10;
                    }
                }
            }
        }

    }

    static float float32Unpack(final int var0) {
        int var1 = var0 & 2097151;
        final int var2 = var0 & Integer.MIN_VALUE;
        final int var3 = (var0 & 2145386496) >> 21;
        if (var2 != 0) {
            var1 = -var1;
        }

        return (float) (var1 * Math.pow(2.0D, (var3 - 788)));
    }

    private static int method2110(final int var0, final int var1) {
        int var2 = (int) Math.pow(var0, 1.0D / var1) + 1;

        while (true) {
            int var4 = var2;
            int var5 = var1;

            int var6;
            for (var6 = 1; var5 > 1; var5 >>= 1) {
                if ((var5 & 1) != 0) {
                    var6 *= var4;
                }

                var4 *= var4;
            }

            final int var3;
            if (var5 == 1) {
                var3 = var6 * var4;
            } else {
                var3 = var6;
            }

            if (var3 <= var0) {
                return var2;
            }

            --var2;
        }
    }

    private void createHuffmanTree() {
        final int[] var1 = new int[this.entries];
        final int[] var2 = new int[33];

        int var3;
        int var4;
        int var5;
        int var6;
        int var7;
        int var8;
        int var10;
        for (var3 = 0; var3 < this.entries; ++var3) {
            var4 = this.entryLengths[var3];
            if (var4 != 0) {
                var5 = 1 << 32 - var4;
                var6 = var2[var4];
                var1[var3] = var6;
                int var12;
                if ((var6 & var5) != 0) {
                    var7 = var2[var4 - 1];
                } else {
                    var7 = var6 | var5;

                    for (var8 = var4 - 1; var8 >= 1; --var8) {
                        var12 = var2[var8];
                        if (var12 != var6) {
                            break;
                        }

                        var10 = 1 << 32 - var8;
                        if ((var12 & var10) != 0) {
                            var2[var8] = var2[var8 - 1];
                            break;
                        }

                        var2[var8] = var12 | var10;
                    }
                }

                var2[var4] = var7;

                for (var8 = var4 + 1; var8 <= 32; ++var8) {
                    var12 = var2[var8];
                    if (var12 == var6) {
                        var2[var8] = var7;
                    }
                }
            }
        }

        this.field1500 = new int[8];
        int var11 = 0;

        for (var3 = 0; var3 < this.entries; ++var3) {
            var4 = this.entryLengths[var3];
            if (var4 != 0) {
                var5 = var1[var3];
                var6 = 0;

                for (var7 = 0; var7 < var4; ++var7) {
                    var8 = Integer.MIN_VALUE >>> var7;
                    if ((var5 & var8) != 0) {
                        if (this.field1500[var6] == 0) {
                            this.field1500[var6] = var11;
                        }

                        var6 = this.field1500[var6];
                    } else {
                        ++var6;
                    }

                    if (var6 >= this.field1500.length) {
                        final int[] var9 = new int[this.field1500.length * 2];

                        for (var10 = 0; var10 < this.field1500.length; ++var10) {
                            var9[var10] = this.field1500[var10];
                        }

                        this.field1500 = var9;
                    }

                }

                this.field1500[var6] = ~var3;
                if (var6 >= var11) {
                    var11 = var6 + 1;
                }
            }
        }

    }

    int getHuffmanRoot() {
        int var1;
        for (var1 = 0; this.field1500[var1] >= 0; var1 = Instrument.getBit() != 0 ? this.field1500[var1] : var1 + 1) {
        }

        return ~this.field1500[var1];
    }

    float[] method2112() {
        return this.valueVector[this.getHuffmanRoot()];
    }
}
