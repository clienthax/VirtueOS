package com.oldscape.client.reference;

import java.io.EOFException;
import java.io.IOException;

public final class IndexFile {
    private static final byte[] IndexStore_buffer;

    static {
        IndexStore_buffer = new byte[520];
    }

    private CacheFile dataFile;
    private CacheFile indexFile;
    private int index;
    private int maxSize;

    public IndexFile(final int var1, final CacheFile var2, final CacheFile var3, final int var4) {
        this.dataFile = null;
        this.indexFile = null;
        this.maxSize = 65000;
        this.index = var1;
        this.dataFile = var2;
        this.indexFile = var3;
        this.maxSize = var4;
    }

    public static KitDefinition getKitDefinition(final int id) {
        KitDefinition kitDefinition = (KitDefinition) KitDefinition.identKits.get(id);
        if (kitDefinition == null) {
            final byte[] data = KitDefinition.identKit_ref.getConfigData(3, id);
            kitDefinition = new KitDefinition();
            if (data != null) {
                kitDefinition.decode(new Buffer(data));
            }

            KitDefinition.identKits.put(kitDefinition, id);
        }
        return kitDefinition;
    }

    public byte[] read(final int var1) {
        synchronized (this.dataFile) {
            try {
                final Object var10000;
                if (this.indexFile.length() < (var1 * 6 + 6)) {
                    var10000 = null;
                    return (byte[]) var10000;
                } else {
                    this.indexFile.seek((var1 * 6));
                    this.indexFile.read(IndexStore_buffer, 0, 6);
                    final int var3 = ((IndexStore_buffer[0] & 255) << 16) + (IndexStore_buffer[2] & 255) + ((IndexStore_buffer[1] & 255) << 8);
                    int var4 = (IndexStore_buffer[5] & 255) + ((IndexStore_buffer[3] & 255) << 16) + ((IndexStore_buffer[4] & 255) << 8);
                    if (var3 < 0 || var3 > this.maxSize) {
                        var10000 = null;
                        return (byte[]) var10000;
                    } else if (var4 <= 0 || var4 > this.dataFile.length() / 520L) {
                        var10000 = null;
                        return (byte[]) var10000;
                    } else {
                        final byte[] var5 = new byte[var3];
                        int var6 = 0;
                        int var7 = 0;

                        while (var6 < var3) {
                            if (var4 == 0) {
                                var10000 = null;
                                return (byte[]) var10000;
                            }

                            this.dataFile.seek((var4 * 520));
                            int var8 = var3 - var6;
                            if (var8 > 512) {
                                var8 = 512;
                            }

                            this.dataFile.read(IndexStore_buffer, 0, var8 + 8);
                            final int var9 = (IndexStore_buffer[1] & 255) + ((IndexStore_buffer[0] & 255) << 8);
                            final int var10 = (IndexStore_buffer[3] & 255) + ((IndexStore_buffer[2] & 255) << 8);
                            final int var11 = ((IndexStore_buffer[5] & 255) << 8) + ((IndexStore_buffer[4] & 255) << 16) + (IndexStore_buffer[6] & 255);
                            final int var12 = IndexStore_buffer[7] & 255;
                            if (var9 == var1 && var7 == var10 && var12 == this.index) {
                                if (var11 >= 0 && var11 <= this.dataFile.length() / 520L) {
                                    for (int var13 = 0; var13 < var8; ++var13) {
                                        var5[var6++] = IndexStore_buffer[var13 + 8];
                                    }

                                    var4 = var11;
                                    ++var7;
                                    continue;
                                }

                                var10000 = null;
                                return (byte[]) var10000;
                            }

                            var10000 = null;
                            return (byte[]) var10000;
                        }

                        return var5;
                    }
                }
            } catch (final IOException var16) {
                return null;
            }
        }
    }

    public boolean write(final int var1, final byte[] var2, final int var3) {
        synchronized (this.dataFile) {
            if (var3 >= 0 && var3 <= this.maxSize) {
                boolean var5 = this.write0(var1, var2, var3, true);
                if (!var5) {
                    var5 = this.write0(var1, var2, var3, false);
                }

                return var5;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean write0(final int var1, final byte[] var2, final int var3, boolean var4) {
        synchronized (this.dataFile) {
            try {
                int var6;
                if (var4) {
                    if (this.indexFile.length() < (var1 * 6 + 6)) {
                        return false;
                    }

                    this.indexFile.seek((var1 * 6));
                    this.indexFile.read(IndexStore_buffer, 0, 6);
                    var6 = (IndexStore_buffer[5] & 255) + ((IndexStore_buffer[3] & 255) << 16) + ((IndexStore_buffer[4] & 255) << 8);
                    if (var6 <= 0 || var6 > this.dataFile.length() / 520L) {
                        return false;
                    }
                } else {
                    var6 = (int) ((this.dataFile.length() + 519L) / 520L);
                    if (var6 == 0) {
                        var6 = 1;
                    }
                }

                IndexStore_buffer[0] = (byte) (var3 >> 16);
                IndexStore_buffer[1] = (byte) (var3 >> 8);
                IndexStore_buffer[2] = (byte) var3;
                IndexStore_buffer[3] = (byte) (var6 >> 16);
                IndexStore_buffer[4] = (byte) (var6 >> 8);
                IndexStore_buffer[5] = (byte) var6;
                this.indexFile.seek((var1 * 6));
                this.indexFile.write(IndexStore_buffer, 0, 6);
                int var7 = 0;
                int var8 = 0;

                while (true) {
                    if (var7 < var3) {
                        label145:
                        {
                            int var9 = 0;
                            int var14;
                            if (var4) {
                                this.dataFile.seek((var6 * 520));

                                try {
                                    this.dataFile.read(IndexStore_buffer, 0, 8);
                                } catch (final EOFException var16) {
                                    break label145;
                                }

                                var14 = (IndexStore_buffer[1] & 255) + ((IndexStore_buffer[0] & 255) << 8);
                                final int var11 = (IndexStore_buffer[3] & 255) + ((IndexStore_buffer[2] & 255) << 8);
                                var9 = ((IndexStore_buffer[5] & 255) << 8) + ((IndexStore_buffer[4] & 255) << 16) + (IndexStore_buffer[6] & 255);
                                final int var12 = IndexStore_buffer[7] & 255;
                                if (var14 != var1 || var11 != var8 || var12 != this.index) {
                                    return false;
                                }

                                if (var9 < 0 || var9 > this.dataFile.length() / 520L) {
                                    return false;
                                }
                            }

                            if (var9 == 0) {
                                var4 = false;
                                var9 = (int) ((this.dataFile.length() + 519L) / 520L);
                                if (var9 == 0) {
                                    ++var9;
                                }

                                if (var9 == var6) {
                                    ++var9;
                                }
                            }

                            if (var3 - var7 <= 512) {
                                var9 = 0;
                            }

                            IndexStore_buffer[0] = (byte) (var1 >> 8);
                            IndexStore_buffer[1] = (byte) var1;
                            IndexStore_buffer[2] = (byte) (var8 >> 8);
                            IndexStore_buffer[3] = (byte) var8;
                            IndexStore_buffer[4] = (byte) (var9 >> 16);
                            IndexStore_buffer[5] = (byte) (var9 >> 8);
                            IndexStore_buffer[6] = (byte) var9;
                            IndexStore_buffer[7] = (byte) this.index;
                            this.dataFile.seek((var6 * 520));
                            this.dataFile.write(IndexStore_buffer, 0, 8);
                            var14 = var3 - var7;
                            if (var14 > 512) {
                                var14 = 512;
                            }

                            this.dataFile.write(var2, var7, var14);
                            var7 += var14;
                            var6 = var9;
                            ++var8;
                            continue;
                        }
                    }

                    return true;
                }
            } catch (final IOException var17) {
                return false;
            }
        }
    }
}
