package com.oldscape.client.reference;

class Residue {
    private final int type;
    private final int begin;
    private final int end;
    private final int partitionSize;
    private final int classification;
    private final int classBook;
    private final int[] field1617;

    Residue() {
        this.type = Instrument.getInt(16);
        this.begin = Instrument.getInt(24);
        this.end = Instrument.getInt(24);
        this.partitionSize = Instrument.getInt(24) + 1;
        this.classification = Instrument.getInt(6) + 1;
        this.classBook = Instrument.getInt(8);
        final int[] var1 = new int[this.classification];

        int var2;
        for (var2 = 0; var2 < this.classification; ++var2) {
            int var3 = 0;
            final int var4 = Instrument.getInt(3);
            final boolean var5 = Instrument.getBit() != 0;
            if (var5) {
                var3 = Instrument.getInt(5);
            }

            var1[var2] = var3 << 3 | var4;
        }

        this.field1617 = new int[this.classification * 8];

        for (var2 = 0; var2 < this.classification * 8; ++var2) {
            this.field1617[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0 ? Instrument.getInt(8) : -1;
        }

    }

    void decodeResidue(final float[] var1, final int var2, final boolean var3) {
        int var4;
        for (var4 = 0; var4 < var2; ++var4) {
            var1[var4] = 0.0F;
        }

        if (!var3) {
            var4 = Instrument.codeBooks[this.classBook].dimensions;
            final int var5 = this.end - this.begin;
            final int var6 = var5 / this.partitionSize;
            final int[] var7 = new int[var6];

            for (int var8 = 0; var8 < 8; ++var8) {
                int var9 = 0;

                while (var9 < var6) {
                    int var10;
                    int var11;
                    if (var8 == 0) {
                        var10 = Instrument.codeBooks[this.classBook].getHuffmanRoot();

                        for (var11 = var4 - 1; var11 >= 0; --var11) {
                            if (var9 + var11 < var6) {
                                var7[var9 + var11] = var10 % this.classification;
                            }

                            var10 /= this.classification;
                        }
                    }

                    for (var10 = 0; var10 < var4; ++var10) {
                        var11 = var7[var9];
                        final int var12 = this.field1617[var8 + var11 * 8];
                        if (var12 >= 0) {
                            final int var13 = var9 * this.partitionSize + this.begin;
                            final CodeBook var14 = Instrument.codeBooks[var12];
                            int var15;
                            if (this.type == 0) {
                                var15 = this.partitionSize / var14.dimensions;

                                for (int var16 = 0; var16 < var15; ++var16) {
                                    final float[] var17 = var14.method2112();

                                    for (int var18 = 0; var18 < var14.dimensions; ++var18) {
                                        var1[var13 + var16 + var18 * var15] += var17[var18];
                                    }
                                }
                            } else {
                                var15 = 0;

                                while (var15 < this.partitionSize) {
                                    final float[] var19 = var14.method2112();

                                    for (int var20 = 0; var20 < var14.dimensions; ++var20) {
                                        var1[var13 + var15] += var19[var20];
                                        ++var15;
                                    }
                                }
                            }
                        }

                        ++var9;
                        if (var9 >= var6) {
                            break;
                        }
                    }
                }
            }

        }
    }
}
