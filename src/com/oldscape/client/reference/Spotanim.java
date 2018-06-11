package com.oldscape.client.reference;

public class Spotanim extends CacheableNode {
    static final NodeCache spotanims;
    static final NodeCache SpotAnimationDefinition_cachedModels;
    static IndexDataBase SpotAnimationDefinition_indexCache;
    static IndexDataBase SpotAnimationDefinition_modelIndexCache;

    static {
        spotanims = new NodeCache(64);
        SpotAnimationDefinition_cachedModels = new NodeCache(30);
    }

    public int field3497;
    int id;
    private int field3487;
    private short[] field3488;
    private short[] field3490;
    private short[] field3491;
    private short[] field3492;
    private int widthScale;
    private int heightScale;
    private int orientation;
    private int field3496;
    private int field3489;

    Spotanim() {
        this.field3497 = -1;
        this.widthScale = 128;
        this.heightScale = 128;
        this.orientation = 0;
        this.field3496 = 0;
        this.field3489 = 0;
    }

    static void method210(final IndexDataBase var0, final IndexDataBase var1) {
        SpotAnimationDefinition_indexCache = var0;
        SpotAnimationDefinition_modelIndexCache = var1;
    }

    public static Spotanim getSpotAnimType(final int var0) {
        Spotanim var1 = (Spotanim) spotanims.get(var0);
        if (var1 == null) {
            final byte[] var2 = SpotAnimationDefinition_indexCache.getConfigData(13, var0);
            var1 = new Spotanim();
            var1.id = var0;
            if (var2 != null) {
                var1.decode(new Buffer(var2));
            }

            spotanims.put(var1, var0);
        }
        return var1;
    }

    void decode(final Buffer var1) {
        while (true) {
            final int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.readNext(var1, var2);
        }
    }

    private void readNext(final Buffer var1, final int var2) {
        if (var2 == 1) {
            this.field3487 = var1.readUnsignedShort();
        } else if (var2 == 2) {
            this.field3497 = var1.readUnsignedShort();
        } else if (var2 == 4) {
            this.widthScale = var1.readUnsignedShort();
        } else if (var2 == 5) {
            this.heightScale = var1.readUnsignedShort();
        } else if (var2 == 6) {
            this.orientation = var1.readUnsignedShort();
        } else if (var2 == 7) {
            this.field3496 = var1.readUnsignedByte();
        } else if (var2 == 8) {
            this.field3489 = var1.readUnsignedByte();
        } else {
            final int var3;
            int var4;
            if (var2 == 40) {
                var3 = var1.readUnsignedByte();
                this.field3488 = new short[var3];
                this.field3490 = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.field3488[var4] = (short) var1.readUnsignedShort();
                    this.field3490[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 == 41) {
                var3 = var1.readUnsignedByte();
                this.field3491 = new short[var3];
                this.field3492 = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.field3491[var4] = (short) var1.readUnsignedShort();
                    this.field3492[var4] = (short) var1.readUnsignedShort();
                }
            }
        }

    }

    public final Model getModel(final int var1) {
        Model var2 = (Model) SpotAnimationDefinition_cachedModels.get(this.id);
        if (var2 == null) {
            final ModelData var3 = ModelData.method2645(SpotAnimationDefinition_modelIndexCache, this.field3487, 0);
            if (var3 == null) {
                return null;
            }

            int var4;
            if (this.field3488 != null) {
                for (var4 = 0; var4 < this.field3488.length; ++var4) {
                    var3.recolor(this.field3488[var4], this.field3490[var4]);
                }
            }

            if (this.field3491 != null) {
                for (var4 = 0; var4 < this.field3491.length; ++var4) {
                    var3.method2613(this.field3491[var4], this.field3492[var4]);
                }
            }

            var2 = var3.light(this.field3496 + 64, this.field3489 + 850, -30, -50, -30);
            SpotAnimationDefinition_cachedModels.put(var2, this.id);
        }

        final Model var5;
        if (this.field3497 != -1 && var1 != -1) {
            var5 = CombatInfo1.getAnimation(this.field3497).transformSpotAnimModel(var2, var1);
        } else {
            var5 = var2.toSharedSpotAnimModel(true);
        }

        if (this.widthScale != 128 || this.heightScale != 128) {
            var5.scale(this.widthScale, this.heightScale, this.widthScale);
        }

        if (this.orientation != 0) {
            if (this.orientation == 90) {
                var5.rotateY90Ccw();
            }

            if (this.orientation == 180) {
                var5.rotateY90Ccw();
                var5.rotateY90Ccw();
            }

            if (this.orientation == 270) {
                var5.rotateY90Ccw();
                var5.rotateY90Ccw();
                var5.rotateY90Ccw();
            }
        }

        return var5;
    }
}
