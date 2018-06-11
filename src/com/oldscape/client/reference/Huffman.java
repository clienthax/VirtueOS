package com.oldscape.client.reference;

public class Huffman {
    static int[] field2513;
    private final int[] masks;
    private final byte[] bits;
    private int[] keys;

    public Huffman(final byte[] var1) {
        final int var2 = var1.length;
        this.masks = new int[var2];
        this.bits = var1;
        final int[] var3 = new int[33];
        this.keys = new int[8];
        int var4 = 0;

        for (int var5 = 0; var5 < var2; ++var5) {
            final byte var6 = var1[var5];
            if (var6 != 0) {
                final int var7 = 1 << 32 - var6;
                final int var8 = var3[var6];
                this.masks[var5] = var8;
                final int var9;
                int var10;
                int var11;
                int var12;
                if ((var8 & var7) != 0) {
                    var9 = var3[var6 - 1];
                } else {
                    var9 = var8 | var7;

                    for (var10 = var6 - 1; var10 >= 1; --var10) {
                        var11 = var3[var10];
                        if (var8 != var11) {
                            break;
                        }

                        var12 = 1 << 32 - var10;
                        if ((var11 & var12) != 0) {
                            var3[var10] = var3[var10 - 1];
                            break;
                        }

                        var3[var10] = var11 | var12;
                    }
                }

                var3[var6] = var9;

                for (var10 = var6 + 1; var10 <= 32; ++var10) {
                    if (var8 == var3[var10]) {
                        var3[var10] = var9;
                    }
                }

                var10 = 0;

                for (var11 = 0; var11 < var6; ++var11) {
                    var12 = Integer.MIN_VALUE >>> var11;
                    if ((var8 & var12) != 0) {
                        if (this.keys[var10] == 0) {
                            this.keys[var10] = var4;
                        }

                        var10 = this.keys[var10];
                    } else {
                        ++var10;
                    }

                    if (var10 >= this.keys.length) {
                        final int[] var13 = new int[this.keys.length * 2];

                        System.arraycopy(this.keys, 0, var13, 0, this.keys.length);

                        this.keys = var13;
                    }

                }

                this.keys[var10] = ~var5;
                if (var10 >= var4) {
                    var4 = var10 + 1;
                }
            }
        }

    }

    public static class281 method3457(final int var0) {
        class281 var1 = (class281) class281.field3568.get(var0);
        if (var1 == null) {
            final byte[] var2 = class281.field3585.getConfigData(32, var0);
            var1 = new class281();
            if (var2 != null) {
                var1.method4965(new Buffer(var2));
            }

            class281.field3568.put(var1, var0);
        }
        return var1;
    }

    public int compress(final byte[] var1, int var2, int var3, final byte[] var4, final int var5) {
        int var6 = 0;
        int var7 = var5 << 3;

        for (var3 += var2; var2 < var3; ++var2) {
            final int var8 = var1[var2] & 255;
            final int var9 = this.masks[var8];
            final byte var10 = this.bits[var8];
            if (var10 == 0) {
                throw new RuntimeException("");
            }

            int var11 = var7 >> 3;
            int var12 = var7 & 7;
            var6 &= -var12 >> 31;
            final int var13 = (var12 + var10 - 1 >> 3) + var11;
            var12 += 24;
            var4[var11] = (byte) (var6 |= var9 >>> var12);
            if (var11 < var13) {
                ++var11;
                var12 -= 8;
                var4[var11] = (byte) (var6 = var9 >>> var12);
                if (var11 < var13) {
                    ++var11;
                    var12 -= 8;
                    var4[var11] = (byte) (var6 = var9 >>> var12);
                    if (var11 < var13) {
                        ++var11;
                        var12 -= 8;
                        var4[var11] = (byte) (var6 = var9 >>> var12);
                        if (var11 < var13) {
                            ++var11;
                            var12 -= 8;
                            var4[var11] = (byte) (var6 = var9 << -var12);
                        }
                    }
                }
            }

            var7 += var10;
        }

        return (var7 + 7 >> 3) - var5;
    }

    public int decompress(final byte[] var1, final int var2, final byte[] var3, int var4, int var5) {
        if (var5 == 0) {
            return 0;
        } else {
            int var6 = 0;
            var5 += var4;
            int var7 = var2;

            while (true) {
                final byte var8 = var1[var7];
                if (var8 < 0) {
                    var6 = this.keys[var6];
                } else {
                    ++var6;
                }

                int var9;
                if ((var9 = this.keys[var6]) < 0) {
                    var3[var4++] = (byte) (~var9);
                    if (var4 >= var5) {
                        break;
                    }

                    var6 = 0;
                }

                if ((var8 & 64) != 0) {
                    var6 = this.keys[var6];
                } else {
                    ++var6;
                }

                if ((var9 = this.keys[var6]) < 0) {
                    var3[var4++] = (byte) (~var9);
                    if (var4 >= var5) {
                        break;
                    }

                    var6 = 0;
                }

                if ((var8 & 32) != 0) {
                    var6 = this.keys[var6];
                } else {
                    ++var6;
                }

                if ((var9 = this.keys[var6]) < 0) {
                    var3[var4++] = (byte) (~var9);
                    if (var4 >= var5) {
                        break;
                    }

                    var6 = 0;
                }

                if ((var8 & 16) != 0) {
                    var6 = this.keys[var6];
                } else {
                    ++var6;
                }

                if ((var9 = this.keys[var6]) < 0) {
                    var3[var4++] = (byte) (~var9);
                    if (var4 >= var5) {
                        break;
                    }

                    var6 = 0;
                }

                if ((var8 & 8) != 0) {
                    var6 = this.keys[var6];
                } else {
                    ++var6;
                }

                if ((var9 = this.keys[var6]) < 0) {
                    var3[var4++] = (byte) (~var9);
                    if (var4 >= var5) {
                        break;
                    }

                    var6 = 0;
                }

                if ((var8 & 4) != 0) {
                    var6 = this.keys[var6];
                } else {
                    ++var6;
                }

                if ((var9 = this.keys[var6]) < 0) {
                    var3[var4++] = (byte) (~var9);
                    if (var4 >= var5) {
                        break;
                    }

                    var6 = 0;
                }

                if ((var8 & 2) != 0) {
                    var6 = this.keys[var6];
                } else {
                    ++var6;
                }

                if ((var9 = this.keys[var6]) < 0) {
                    var3[var4++] = (byte) (~var9);
                    if (var4 >= var5) {
                        break;
                    }

                    var6 = 0;
                }

                if ((var8 & 1) != 0) {
                    var6 = this.keys[var6];
                } else {
                    ++var6;
                }

                if ((var9 = this.keys[var6]) < 0) {
                    var3[var4++] = (byte) (~var9);
                    if (var4 >= var5) {
                        break;
                    }

                    var6 = 0;
                }

                ++var7;
            }

            return var7 + 1 - var2;
        }
    }
}
