package com.oldscape.shared.utility.crypto;

import java.nio.ByteBuffer;

/**
 * @author JaGeX Games Studio
 */
public class Huffman {

    int[] keys;
    int[] masks;
    byte[] bits;

    public Huffman(ByteBuffer buffer) {

        int length = buffer.capacity();

        byte[] bytes = new byte[length];
        buffer.get(bytes);

        int var2 = bytes.length;
        this.masks = new int[var2];
        this.bits = bytes;
        int[] var3 = new int[33];
        this.keys = new int[8];
        int var4 = 0;

        for (int var5 = 0; var5 < var2; ++var5) {
            byte var6 = bytes[var5];
            if (var6 != 0) {
                int var7 = 1 << 32 - var6;
                int var8 = var3[var6];
                this.masks[var5] = var8;
                int var9;
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
                        int[] var13 = new int[this.keys.length * 2];

                        for (int var14 = 0; var14 < this.keys.length; ++var14) {
                            var13[var14] = this.keys[var14];
                        }

                        this.keys = var13;
                    }

                    var12 >>>= 1;
                }

                this.keys[var10] = ~var5;
                if (var10 >= var4) {
                    var4 = var10 + 1;
                }
            }
        }

    }

    public int compress(byte[] decompressed, int dOffset, int length, byte[] compressed, int cOffset) {
        int var6 = 0;
        int offset = cOffset << 3;

        for (length += dOffset; dOffset < length; ++dOffset) {
            int var8 = decompressed[dOffset] & 255;
            int code = this.masks[var8];
            byte size = this.bits[var8];
            if (size == 0) {
                throw new RuntimeException("");
            }

            int position = offset >> 3;
            int var12 = offset & 7;
            var6 &= -var12 >> 31;
            int var13 = (var12 + size - 1 >> 3) + position;
            var12 += 24;
            compressed[position] = (byte) (var6 |= code >>> var12);
            if (position < var13) {
                ++position;
                var12 -= 8;
                compressed[position] = (byte) (var6 = code >>> var12);
                if (position < var13) {
                    ++position;
                    var12 -= 8;
                    compressed[position] = (byte) (var6 = code >>> var12);
                    if (position < var13) {
                        ++position;
                        var12 -= 8;
                        compressed[position] = (byte) (var6 = code >>> var12);
                        if (position < var13) {
                            ++position;
                            var12 -= 8;
                            compressed[position] = (byte) (var6 = code << -var12);
                        }
                    }
                }
            }

            offset += size;
        }

        return (offset + 7 >> 3) - cOffset;
    }

    public int decompress(byte[] compressed, int cOffset, byte[] decompressed, int dOffset, int length) {
        if (length == 0) {
            return 0;
        } else {
            int position = 0;
            length += dOffset;
            int offset = cOffset;

            while (true) {
                byte code = compressed[offset];
                if (code < 0) {
                    position = this.keys[position];
                } else {
                    ++position;
                }

                int value;
                if ((value = this.keys[position]) < 0) {
                    decompressed[dOffset++] = (byte) (~value);
                    if (dOffset >= length) {
                        break;
                    }

                    position = 0;
                }

                if ((code & 64) != 0) {
                    position = this.keys[position];
                } else {
                    ++position;
                }

                if ((value = this.keys[position]) < 0) {
                    decompressed[dOffset++] = (byte) (~value);
                    if (dOffset >= length) {
                        break;
                    }

                    position = 0;
                }

                if ((code & 32) != 0) {
                    position = this.keys[position];
                } else {
                    ++position;
                }

                if ((value = this.keys[position]) < 0) {
                    decompressed[dOffset++] = (byte) (~value);
                    if (dOffset >= length) {
                        break;
                    }

                    position = 0;
                }

                if ((code & 16) != 0) {
                    position = this.keys[position];
                } else {
                    ++position;
                }

                if ((value = this.keys[position]) < 0) {
                    decompressed[dOffset++] = (byte) (~value);
                    if (dOffset >= length) {
                        break;
                    }

                    position = 0;
                }

                if ((code & 8) != 0) {
                    position = this.keys[position];
                } else {
                    ++position;
                }

                if ((value = this.keys[position]) < 0) {
                    decompressed[dOffset++] = (byte) (~value);
                    if (dOffset >= length) {
                        break;
                    }

                    position = 0;
                }

                if ((code & 4) != 0) {
                    position = this.keys[position];
                } else {
                    ++position;
                }

                if ((value = this.keys[position]) < 0) {
                    decompressed[dOffset++] = (byte) (~value);
                    if (dOffset >= length) {
                        break;
                    }

                    position = 0;
                }

                if ((code & 2) != 0) {
                    position = this.keys[position];
                } else {
                    ++position;
                }

                if ((value = this.keys[position]) < 0) {
                    decompressed[dOffset++] = (byte) (~value);
                    if (dOffset >= length) {
                        break;
                    }

                    position = 0;
                }

                if ((code & 1) != 0) {
                    position = this.keys[position];
                } else {
                    ++position;
                }

                if ((value = this.keys[position]) < 0) {
                    decompressed[dOffset++] = (byte) (~value);
                    if (dOffset >= length) {
                        break;
                    }

                    position = 0;
                }

                ++offset;
            }

            return offset + 1 - cOffset;
        }
    }

}
