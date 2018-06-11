package com.oldscape.client.reference;

public class Area extends CacheableNode {
    static final NodeCache areaSpriteCache;
    static IndexDataBase field3461;
    static Area[] mapAreaType;
    static int field2162;

    static {
        areaSpriteCache = new NodeCache(256);
    }

    public final int id;
    public String name;
    public String[] actions;
    int spriteId;
    int textColor;
    int fontSizeId;
    String field3470;
    HorizontalAlignment horizontalAlignment;
    VerticalAlignment verticalAlignment;
    int field3473;
    private int field3468;
    private int[] field3464;
    private int field3456;
    private int field3466;
    private int field3467;
    private int field3459;
    private int[] field3471;
    private byte[] field3472;

    Area(final int var1) {
        this.spriteId = -1;
        this.field3468 = -1;
        this.fontSizeId = 0;
        this.actions = new String[5];
        this.field3456 = Integer.MAX_VALUE;
        this.field3466 = Integer.MAX_VALUE;
        this.field3467 = Integer.MIN_VALUE;
        this.field3459 = Integer.MIN_VALUE;
        this.horizontalAlignment = HorizontalAlignment.field3702;
        this.verticalAlignment = VerticalAlignment.field3440;
        this.field3473 = -1;
        this.id = var1;
    }

    public static boolean method1232(final IndexDataBase var0, final IndexDataBase var1) {
        field3461 = var1;
        if (!var0.method4624()) {
            return false;
        } else {
            field2162 = var0.fileCount(35);
            mapAreaType = new Area[field2162];

            for (int var2 = 0; var2 < field2162; ++var2) {
                final byte[] var3 = var0.getConfigData(35, var2);
                if (var3 != null) {
                    mapAreaType[var2] = new Area(var2);
                    mapAreaType[var2].method4757(new Buffer(var3));
                    mapAreaType[var2].method4744();
                }
            }

            return true;
        }
    }

    void method4757(final Buffer var1) {
        while (true) {
            final int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.readNext(var1, var2);
        }
    }

    private void readNext(final Buffer buffer, final int opcode) {
        if (opcode == 1) {
            this.spriteId = buffer.method3576();
        } else if (opcode == 2) {
            this.field3468 = buffer.method3576();
        } else if (opcode == 3) {
            this.name = buffer.readString();
        } else if (opcode == 4) {
            this.textColor = buffer.read24BitInt();
        } else if (opcode == 5) {
            buffer.read24BitInt();
        } else if (opcode == 6) {
            this.fontSizeId = buffer.readUnsignedByte();
        } else {
            final int var3;
            if (opcode == 7) {
                var3 = buffer.readUnsignedByte();
                if ((var3 & 1) == 0) {
                }

                if ((var3 & 2) == 2) {
                }
            } else if (opcode == 8) {
                buffer.readUnsignedByte();
            } else if (opcode >= 10 && opcode <= 14) {
                this.actions[opcode - 10] = buffer.readString();
            } else if (opcode == 15) {
                var3 = buffer.readUnsignedByte();
                this.field3464 = new int[var3 * 2];

                int var4;
                for (var4 = 0; var4 < var3 * 2; ++var4) {
                    this.field3464[var4] = buffer.readShort();
                }

                buffer.readInt();
                var4 = buffer.readUnsignedByte();
                this.field3471 = new int[var4];

                int var5;
                for (var5 = 0; var5 < this.field3471.length; ++var5) {
                    this.field3471[var5] = buffer.readInt();
                }

                this.field3472 = new byte[var3];

                for (var5 = 0; var5 < var3; ++var5) {
                    this.field3472[var5] = buffer.readByte();
                }
            } else if (opcode != 16) {
                if (opcode == 17) {
                    this.field3470 = buffer.readString();
                } else if (opcode == 18) {
                    buffer.method3576();
                } else if (opcode == 19) {
                    this.field3473 = buffer.readUnsignedShort();
                } else if (opcode == 21) {
                    buffer.readInt();
                } else if (opcode == 22) {
                    buffer.readInt();
                } else if (opcode == 23) {
                    buffer.readUnsignedByte();
                    buffer.readUnsignedByte();
                    buffer.readUnsignedByte();
                } else if (opcode == 24) {
                    buffer.readShort();
                    buffer.readShort();
                } else if (opcode == 25) {
                    buffer.method3576();
                } else if (opcode == 28) {
                    buffer.readUnsignedByte();
                } else if (opcode == 29) {
                    final HorizontalAlignment[] var6 = {HorizontalAlignment.field3702, HorizontalAlignment.field3699, HorizontalAlignment.field3698};
                    this.horizontalAlignment = (HorizontalAlignment) Enumerated.forOrdinal(var6, buffer.readUnsignedByte());
                } else if (opcode == 30) {
                    this.verticalAlignment = (VerticalAlignment) Enumerated.forOrdinal(Ignore.method5387(), buffer.readUnsignedByte());
                }
            }
        }

    }

    void method4744() {
        if (this.field3464 != null) {
            for (int var1 = 0; var1 < this.field3464.length; var1 += 2) {
                if (this.field3464[var1] < this.field3456) {
                    this.field3456 = this.field3464[var1];
                } else if (this.field3464[var1] > this.field3467) {
                    this.field3467 = this.field3464[var1];
                }

                if (this.field3464[var1 + 1] < this.field3466) {
                    this.field3466 = this.field3464[var1 + 1];
                } else if (this.field3464[var1 + 1] > this.field3459) {
                    this.field3459 = this.field3464[var1 + 1];
                }
            }
        }

    }

    SpritePixels getMapIcon() {
        final int var2 = this.spriteId;
        return this.getSpritePixels(var2);
    }

    private SpritePixels getSpritePixels(final int spriteId) {
        if (spriteId < 0) {
            return null;
        } else {
            SpritePixels spritePixels = (SpritePixels) areaSpriteCache.get(spriteId);
            if (spritePixels == null) {
                spritePixels = class332.method817(field3461, spriteId, 0);
                if (spritePixels != null) {
                    areaSpriteCache.put(spritePixels, spriteId);
                }

            }
            return spritePixels;
        }
    }

    public int getId() {
        return this.id;
    }

}
