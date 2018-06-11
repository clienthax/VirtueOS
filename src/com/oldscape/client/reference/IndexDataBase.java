package com.oldscape.client.reference;

public abstract class IndexDataBase {
    static final GZipDecompressor gzip;
    static final int field3393;

    static {
        gzip = new GZipDecompressor();
        field3393 = 0;
    }

    public int crc;
    int[] archiveCrcs;
    int[] archiveRevisions;
    int[] archiveNumberOfFiles;
    Object[] archives;
    private int validArchivesCount;
    private int[] archiveIds;
    private int[] archiveNames;
    private Identifiers identifiers;
    private int[][] archiveFileIds;
    private int[][] archiveFileNames;
    private Identifiers[] childIdentifiers;
    private Object[][] childs;
    private boolean releaseArchives;
    private boolean shallowRecords;

    IndexDataBase(final boolean var1, final boolean var2) {
        this.releaseArchives = var1;
        this.shallowRecords = var2;
    }

    public static int djb2Hash(final CharSequence sequence) {
        final int var1 = sequence.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = (var2 << 5) - var2 + Client.charToByteCp1252(sequence.charAt(var3));
        }

        return var2;
    }

    public static SpritePixels[] getSprites(final IndexDataBase var0, final String var1, final String var2) {
        final int var3 = var0.getFile(var1);
        final int var4 = var0.getChild(var3, var2);
        final SpritePixels[] var5;
        if (!RunException.method3215(var0, var3, var4)) {
            var5 = null;
        } else {
            var5 = class85.method1886();
        }

        return var5;
    }

    void setIndexReference(final byte[] var1) {
        this.crc = class150.method3118(var1, var1.length);
        final Buffer var2 = new Buffer(WorldMapType3.decodeContainer(var1));
        final int var3 = var2.readUnsignedByte();
        if (var3 >= 5 && var3 <= 7) {
            if (var3 >= 6) {
                var2.readInt();
            }

            final int var4 = var2.readUnsignedByte();
            if (var3 >= 7) {
                this.validArchivesCount = var2.getLargeSmart();
            } else {
                this.validArchivesCount = var2.readUnsignedShort();
            }

            int var5 = 0;
            int var6 = -1;
            this.archiveIds = new int[this.validArchivesCount];
            int var7;
            if (var3 >= 7) {
                for (var7 = 0; var7 < this.validArchivesCount; ++var7) {
                    this.archiveIds[var7] = var5 += var2.getLargeSmart();
                    if (this.archiveIds[var7] > var6) {
                        var6 = this.archiveIds[var7];
                    }
                }
            } else {
                for (var7 = 0; var7 < this.validArchivesCount; ++var7) {
                    this.archiveIds[var7] = var5 += var2.readUnsignedShort();
                    if (this.archiveIds[var7] > var6) {
                        var6 = this.archiveIds[var7];
                    }
                }
            }

            this.archiveCrcs = new int[var6 + 1];
            this.archiveRevisions = new int[var6 + 1];
            this.archiveNumberOfFiles = new int[var6 + 1];
            this.archiveFileIds = new int[var6 + 1][];
            this.archives = new Object[var6 + 1];
            this.childs = new Object[var6 + 1][];
            if (var4 != 0) {
                this.archiveNames = new int[var6 + 1];

                for (var7 = 0; var7 < this.validArchivesCount; ++var7) {
                    this.archiveNames[this.archiveIds[var7]] = var2.readInt();
                }

                this.identifiers = new Identifiers(this.archiveNames);
            }

            for (var7 = 0; var7 < this.validArchivesCount; ++var7) {
                this.archiveCrcs[this.archiveIds[var7]] = var2.readInt();
            }

            for (var7 = 0; var7 < this.validArchivesCount; ++var7) {
                this.archiveRevisions[this.archiveIds[var7]] = var2.readInt();
            }

            for (var7 = 0; var7 < this.validArchivesCount; ++var7) {
                this.archiveNumberOfFiles[this.archiveIds[var7]] = var2.readUnsignedShort();
            }

            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if (var3 >= 7) {
                for (var7 = 0; var7 < this.validArchivesCount; ++var7) {
                    var8 = this.archiveIds[var7];
                    var9 = this.archiveNumberOfFiles[var8];
                    var5 = 0;
                    var10 = -1;
                    this.archiveFileIds[var8] = new int[var9];

                    for (var11 = 0; var11 < var9; ++var11) {
                        var12 = this.archiveFileIds[var8][var11] = var5 += var2.getLargeSmart();
                        if (var12 > var10) {
                            var10 = var12;
                        }
                    }

                    this.childs[var8] = new Object[var10 + 1];
                }
            } else {
                for (var7 = 0; var7 < this.validArchivesCount; ++var7) {
                    var8 = this.archiveIds[var7];
                    var9 = this.archiveNumberOfFiles[var8];
                    var5 = 0;
                    var10 = -1;
                    this.archiveFileIds[var8] = new int[var9];

                    for (var11 = 0; var11 < var9; ++var11) {
                        var12 = this.archiveFileIds[var8][var11] = var5 += var2.readUnsignedShort();
                        if (var12 > var10) {
                            var10 = var12;
                        }
                    }

                    this.childs[var8] = new Object[var10 + 1];
                }
            }

            if (var4 != 0) {
                this.archiveFileNames = new int[var6 + 1][];
                this.childIdentifiers = new Identifiers[var6 + 1];

                for (var7 = 0; var7 < this.validArchivesCount; ++var7) {
                    var8 = this.archiveIds[var7];
                    var9 = this.archiveNumberOfFiles[var8];
                    this.archiveFileNames[var8] = new int[this.childs[var8].length];

                    for (var10 = 0; var10 < var9; ++var10) {
                        this.archiveFileNames[var8][this.archiveFileIds[var8][var10]] = var2.readInt();
                    }

                    this.childIdentifiers[var8] = new Identifiers(this.archiveFileNames[var8]);
                }
            }

        } else {
            throw new RuntimeException("");
        }
    }

    void vmethod4634(final int var1) {
    }

    public byte[] getConfigData(final int var1, final int var2) {
        return this.getConfigDataKeys(var1, var2, null);
    }

    public byte[] getConfigDataKeys(final int var1, final int var2, final int[] var3) {
        if (var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
            if (this.childs[var1][var2] == null) {
                boolean var4 = this.buildRecords(var1, var3);
                if (!var4) {
                    this.loadArchive(var1);
                    var4 = this.buildRecords(var1, var3);
                    if (!var4) {
                        return null;
                    }
                }
            }

            final byte[] var5 = WorldMapRectangle.toByteArray(this.childs[var1][var2], false);
            if (this.shallowRecords) {
                this.childs[var1][var2] = null;
            }

            return var5;
        } else {
            return null;
        }
    }

    public boolean tryLoadRecord(final int var1, final int var2) {
        if (var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
            if (this.childs[var1][var2] != null) {
                return true;
            } else if (this.archives[var1] != null) {
                return true;
            } else {
                this.loadArchive(var1);
                return this.archives[var1] != null;
            }
        } else {
            return false;
        }
    }

    public boolean method4615(final int var1) {
        if (this.childs.length == 1) {
            return this.tryLoadRecord(0, var1);
        } else if (this.childs[var1].length == 1) {
            return this.tryLoadRecord(var1, 0);
        } else {
            throw new RuntimeException();
        }
    }

    public boolean containsFile(final int var1) {
        if (this.archives[var1] != null) {
            return true;
        } else {
            this.loadArchive(var1);
            return this.archives[var1] != null;
        }
    }

    public boolean method4624() {
        boolean var1 = true;

        for (final int var3 : this.archiveIds) {
            if (this.archives[var3] == null) {
                this.loadArchive(var3);
                if (this.archives[var3] == null) {
                    var1 = false;
                }
            }
        }

        return var1;
    }

    int archiveLoadPercent(final int var1) {
        return this.archives[var1] != null ? 100 : 0;
    }

    public byte[] takeRecordFlat(final int var1) {
        if (this.childs.length == 1) {
            return this.getConfigData(0, var1);
        } else if (this.childs[var1].length == 1) {
            return this.getConfigData(var1, 0);
        } else {
            throw new RuntimeException();
        }
    }

    public byte[] getChild(final int var1, final int var2) {
        if (var1 >= 0 && var1 < this.childs.length && this.childs[var1] != null && var2 >= 0 && var2 < this.childs[var1].length) {
            if (this.childs[var1][var2] == null) {
                boolean var3 = this.buildRecords(var1, null);
                if (!var3) {
                    this.loadArchive(var1);
                    var3 = this.buildRecords(var1, null);
                    if (!var3) {
                        return null;
                    }
                }
            }

            return WorldMapRectangle.toByteArray(this.childs[var1][var2], false);
        } else {
            return null;
        }
    }

    public byte[] getRecordFlat(final int var1) {
        if (this.childs.length == 1) {
            return this.getChild(0, var1);
        } else if (this.childs[var1].length == 1) {
            return this.getChild(var1, 0);
        } else {
            throw new RuntimeException();
        }
    }

    void loadArchive(final int var1) {
    }

    public int[] getChilds(final int var1) {
        return this.archiveFileIds[var1];
    }

    public int fileCount(final int var1) {
        return this.childs[var1].length;
    }

    public int size() {
        return this.childs.length;
    }

    public void method4566() {
        for (int var1 = 0; var1 < this.archives.length; ++var1) {
            this.archives[var1] = null;
        }

    }

    public void method4543(final int var1) {
        for (int var2 = 0; var2 < this.childs[var1].length; ++var2) {
            this.childs[var1][var2] = null;
        }

    }

    public void reset() {
        for (int var1 = 0; var1 < this.childs.length; ++var1) {
            if (this.childs[var1] != null) {
                for (int var2 = 0; var2 < this.childs[var1].length; ++var2) {
                    this.childs[var1][var2] = null;
                }
            }
        }

    }

    private boolean buildRecords(final int var1, final int[] var2) {
        if (this.archives[var1] == null) {
            return false;
        } else {
            final int var3 = this.archiveNumberOfFiles[var1];
            final int[] var4 = this.archiveFileIds[var1];
            final Object[] var5 = this.childs[var1];
            boolean var6 = true;

            for (int var7 = 0; var7 < var3; ++var7) {
                if (var5[var4[var7]] == null) {
                    var6 = false;
                    break;
                }
            }

            if (!var6) {
                final byte[] var18;
                if (var2 != null && (var2[0] != 0 || var2[1] != 0 || var2[2] != 0 || var2[3] != 0)) {
                    var18 = WorldMapRectangle.toByteArray(this.archives[var1], true);
                    final Buffer var8 = new Buffer(var18);
                    var8.decryptXtea(var2, 5, var8.payload.length);
                } else {
                    var18 = WorldMapRectangle.toByteArray(this.archives[var1], false);
                }

                final byte[] var20 = WorldMapType3.decodeContainer(var18);
                if (this.releaseArchives) {
                    this.archives[var1] = null;
                }

                if (var3 > 1) {
                    int var9 = var20.length;
                    --var9;
                    final int var10 = var20[var9] & 255;
                    var9 -= var10 * var3 * 4;
                    final Buffer var11 = new Buffer(var20);
                    final int[] var12 = new int[var3];
                    var11.offset = var9;

                    int var14;
                    int var15;
                    for (int var13 = 0; var13 < var10; ++var13) {
                        var14 = 0;

                        for (var15 = 0; var15 < var3; ++var15) {
                            var14 += var11.readInt();
                            var12[var15] += var14;
                        }
                    }

                    final byte[][] var19 = new byte[var3][];

                    for (var14 = 0; var14 < var3; ++var14) {
                        var19[var14] = new byte[var12[var14]];
                        var12[var14] = 0;
                    }

                    var11.offset = var9;
                    var14 = 0;

                    for (var15 = 0; var15 < var10; ++var15) {
                        int var16 = 0;

                        for (int var17 = 0; var17 < var3; ++var17) {
                            var16 += var11.readInt();
                            System.arraycopy(var20, var14, var19[var17], var12[var17], var16);
                            var12[var17] += var16;
                            var14 += var16;
                        }
                    }

                    for (var15 = 0; var15 < var3; ++var15) {
                        if (!this.shallowRecords) {
                            var5[var4[var15]] = GameEngine.byteArrayToObject(var19[var15]);
                        } else {
                            var5[var4[var15]] = var19[var15];
                        }
                    }
                } else if (!this.shallowRecords) {
                    var5[var4[0]] = GameEngine.byteArrayToObject(var20);
                } else {
                    var5[var4[0]] = var20;
                }

            }
            return true;
        }
    }

    public int getFile(String var1) {
        var1 = var1.toLowerCase();
        return this.identifiers.getFile(djb2Hash(var1));
    }

    public int getChild(final int var1, String var2) {
        var2 = var2.toLowerCase();
        return this.childIdentifiers[var1].getFile(djb2Hash(var2));
    }

    public boolean method4599(String var1, String var2) {
        var1 = var1.toLowerCase();
        var2 = var2.toLowerCase();
        final int var3 = this.identifiers.getFile(djb2Hash(var1));
        if (var3 < 0) {
            return false;
        } else {
            final int var4 = this.childIdentifiers[var3].getFile(djb2Hash(var2));
            return var4 >= 0;
        }
    }

    public byte[] takeRecordByNames(String var1, String var2) {
        var1 = var1.toLowerCase();
        var2 = var2.toLowerCase();
        final int var3 = this.identifiers.getFile(djb2Hash(var1));
        final int var4 = this.childIdentifiers[var3].getFile(djb2Hash(var2));
        return this.getConfigData(var3, var4);
    }

    public boolean tryLoadRecordByNames(String var1, String var2) {
        var1 = var1.toLowerCase();
        var2 = var2.toLowerCase();
        final int var3 = this.identifiers.getFile(djb2Hash(var1));
        final int var4 = this.childIdentifiers[var3].getFile(djb2Hash(var2));
        return this.tryLoadRecord(var3, var4);
    }

    public boolean tryLoadArchiveByName(String var1) {
        var1 = var1.toLowerCase();
        final int var2 = this.identifiers.getFile(djb2Hash(var1));
        return this.containsFile(var2);
    }

    public void method4552(String var1) {
        var1 = var1.toLowerCase();
        final int var2 = this.identifiers.getFile(djb2Hash(var1));
        if (var2 >= 0) {
            this.vmethod4634(var2);
        }
    }

    public int archiveLoadPercentByName(String var1) {
        var1 = var1.toLowerCase();
        final int var2 = this.identifiers.getFile(djb2Hash(var1));
        return this.archiveLoadPercent(var2);
    }
}
