package com.oldscape.client.reference;

public class ObjectComposition extends CacheableNode {
    public static final NodeCache field3593;
    static final NodeCache objects;
    static final NodeCache cachedModels;
    static final NodeCache field3595;
    private static final ModelData[] field3596;
    static boolean objectCompositionLowDetail;
    static IndexDataBase objects_ref;
    static IndexDataBase models_ref;
    static int field3640;

    static {
        objectCompositionLowDetail = false;
        objects = new NodeCache(4096);
        field3593 = new NodeCache(500);
        cachedModels = new NodeCache(30);
        field3595 = new NodeCache(30);
        field3596 = new ModelData[4];
    }

    public int id;
    public String name;
    public int width;
    public int length;
    public int clipType;
    public boolean blocksProjectile;
    public int int1;
    public boolean modelClipped;
    public int animationId;
    public int decorDisplacement;
    public String[] actions;
    public int mapIconId;
    public int mapSceneId;
    public boolean clipped;
    public boolean obstructsGround;
    public int supportItems;
    public int[] impostorIds;
    public int ambientSoundId;
    public int int4;
    public int int5;
    public int int6;
    public int[] field3614;
    boolean isHollow;
    private int[] objectModels;
    private int[] objectTypes;
    private short[] recolorToFind;
    private short[] recolorToReplace;
    private short[] textureToFind;
    private short[] textureToReplace;
    private int contouredGround;
    private boolean nonFlatShading;
    private int ambient;
    private int contrast;
    private boolean isRotated;
    private int modelSizeX;
    private int modelSizeHeight;
    private int modelSizeY;
    private int offsetX;
    private int offsetHeight;
    private int offsetY;
    private int varpId;
    private int configId;
    private IterableHashTable params;

    ObjectComposition() {
        this.name = "null";
        this.width = 1;
        this.length = 1;
        this.clipType = 2;
        this.blocksProjectile = true;
        this.int1 = -1;
        this.contouredGround = -1;
        this.nonFlatShading = false;
        this.modelClipped = false;
        this.animationId = -1;
        this.decorDisplacement = 16;
        this.ambient = 0;
        this.contrast = 0;
        this.actions = new String[5];
        this.mapIconId = -1;
        this.mapSceneId = -1;
        this.isRotated = false;
        this.clipped = true;
        this.modelSizeX = 128;
        this.modelSizeHeight = 128;
        this.modelSizeY = 128;
        this.offsetX = 0;
        this.offsetHeight = 0;
        this.offsetY = 0;
        this.obstructsGround = false;
        this.isHollow = false;
        this.supportItems = -1;
        this.varpId = -1;
        this.configId = -1;
        this.ambientSoundId = -1;
        this.int4 = 0;
        this.int5 = 0;
        this.int6 = 0;
    }

    public static void method5053(final IndexDataBase var0, final IndexDataBase var1) {
        CombatInfo2.field3532 = var0;
        CombatInfo2.field3528 = var1;
    }

    static void method5018(final Actor var0) {
        if (var0.field1204 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.actionFrameCycle + 1 > CombatInfo1.getAnimation(var0.animation).frameLengths[var0.actionFrame]) {
            final int var1 = var0.field1204 - var0.field1166;
            final int var2 = Client.gameCycle - var0.field1166;
            final int var3 = var0.field1203 * 128 + var0.size * 64;
            final int var4 = var0.field1199 * 128 + var0.size * 64;
            final int var5 = var0.field1200 * 128 + var0.size * 64;
            final int var6 = var0.field1202 * 128 + var0.size * 64;
            var0.x = (var5 * var2 + var3 * (var1 - var2)) / var1;
            var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
        }

        var0.field1158 = 0;
        var0.orientation = var0.field1171;
        var0.angle = var0.orientation;
    }

    void post() {
        if (this.int1 == -1) {
            this.int1 = 0;
            if (this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
                this.int1 = 1;
            }

            for (int var1 = 0; var1 < 5; ++var1) {
                if (this.actions[var1] != null) {
                    this.int1 = 1;
                }
            }
        }

        if (this.supportItems == -1) {
            this.supportItems = this.clipType != 0 ? 1 : 0;
        }

    }

    void decode(final Buffer var1) {
        while (true) {
            final int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.loadData(var1, var2);
        }
    }

    private void loadData(final Buffer var1, final int var2) {
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUnsignedByte();
            if (var3 > 0) {
                if (this.objectModels != null && !objectCompositionLowDetail) {
                    var1.offset += 3 * var3;
                } else {
                    this.objectTypes = new int[var3];
                    this.objectModels = new int[var3];

                    for (var4 = 0; var4 < var3; ++var4) {
                        this.objectModels[var4] = var1.readUnsignedShort();
                        this.objectTypes[var4] = var1.readUnsignedByte();
                    }
                }
            }
        } else if (var2 == 2) {
            this.name = var1.readString();
        } else if (var2 == 5) {
            var3 = var1.readUnsignedByte();
            if (var3 > 0) {
                if (this.objectModels != null && !objectCompositionLowDetail) {
                    var1.offset += var3 * 2;
                } else {
                    this.objectTypes = null;
                    this.objectModels = new int[var3];

                    for (var4 = 0; var4 < var3; ++var4) {
                        this.objectModels[var4] = var1.readUnsignedShort();
                    }
                }
            }
        } else if (var2 == 14) {
            this.width = var1.readUnsignedByte();
        } else if (var2 == 15) {
            this.length = var1.readUnsignedByte();
        } else if (var2 == 17) {
            this.clipType = 0;
            this.blocksProjectile = false;
        } else if (var2 == 18) {
            this.blocksProjectile = false;
        } else if (var2 == 19) {
            this.int1 = var1.readUnsignedByte();
        } else if (var2 == 21) {
            this.contouredGround = 0;
        } else if (var2 == 22) {
            this.nonFlatShading = true;
        } else if (var2 == 23) {
            this.modelClipped = true;
        } else if (var2 == 24) {
            this.animationId = var1.readUnsignedShort();
            if (this.animationId == 65535) {
                this.animationId = -1;
            }
        } else if (var2 == 27) {
            this.clipType = 1;
        } else if (var2 == 28) {
            this.decorDisplacement = var1.readUnsignedByte();
        } else if (var2 == 29) {
            this.ambient = var1.readByte();
        } else if (var2 == 39) {
            this.contrast = var1.readByte() * 25;
        } else if (var2 >= 30 && var2 < 35) {
            this.actions[var2 - 30] = var1.readString();
            if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
                this.actions[var2 - 30] = null;
            }
        } else if (var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorToFind = new short[var3];
            this.recolorToReplace = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.recolorToFind[var4] = (short) var1.readUnsignedShort();
                this.recolorToReplace[var4] = (short) var1.readUnsignedShort();
            }
        } else if (var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.textureToFind = new short[var3];
            this.textureToReplace = new short[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.textureToFind[var4] = (short) var1.readUnsignedShort();
                this.textureToReplace[var4] = (short) var1.readUnsignedShort();
            }
        } else if (var2 == 62) {
            this.isRotated = true;
        } else if (var2 == 64) {
            this.clipped = false;
        } else if (var2 == 65) {
            this.modelSizeX = var1.readUnsignedShort();
        } else if (var2 == 66) {
            this.modelSizeHeight = var1.readUnsignedShort();
        } else if (var2 == 67) {
            this.modelSizeY = var1.readUnsignedShort();
        } else if (var2 == 68) {
            this.mapSceneId = var1.readUnsignedShort();
        } else if (var2 == 69) {
            var1.readUnsignedByte();
        } else if (var2 == 70) {
            this.offsetX = var1.readShort();
        } else if (var2 == 71) {
            this.offsetHeight = var1.readShort();
        } else if (var2 == 72) {
            this.offsetY = var1.readShort();
        } else if (var2 == 73) {
            this.obstructsGround = true;
        } else if (var2 == 74) {
            this.isHollow = true;
        } else if (var2 == 75) {
            this.supportItems = var1.readUnsignedByte();
        } else if (var2 != 77 && var2 != 92) {
            if (var2 == 78) {
                this.ambientSoundId = var1.readUnsignedShort();
                this.int4 = var1.readUnsignedByte();
            } else if (var2 == 79) {
                this.int5 = var1.readUnsignedShort();
                this.int6 = var1.readUnsignedShort();
                this.int4 = var1.readUnsignedByte();
                var3 = var1.readUnsignedByte();
                this.field3614 = new int[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.field3614[var4] = var1.readUnsignedShort();
                }
            } else if (var2 == 81) {
                this.contouredGround = var1.readUnsignedByte() * 256;
            } else if (var2 == 82) {
                this.mapIconId = var1.readUnsignedShort();
            } else if (var2 == 249) {
                this.params = WorldMapDecorationInfo.readStringIntParameters(var1, this.params);
            }
        } else {
            this.varpId = var1.readUnsignedShort();
            if (this.varpId == 65535) {
                this.varpId = -1;
            }

            this.configId = var1.readUnsignedShort();
            if (this.configId == 65535) {
                this.configId = -1;
            }

            var3 = -1;
            if (var2 == 92) {
                var3 = var1.readUnsignedShort();
                if (var3 == 65535) {
                    var3 = -1;
                }
            }

            var4 = var1.readUnsignedByte();
            this.impostorIds = new int[var4 + 2];

            for (int var5 = 0; var5 <= var4; ++var5) {
                this.impostorIds[var5] = var1.readUnsignedShort();
                if (this.impostorIds[var5] == 65535) {
                    this.impostorIds[var5] = -1;
                }
            }

            this.impostorIds[var4 + 1] = var3;
        }

    }

    public final boolean method4996(final int var1) {
        if (this.objectTypes != null) {
            for (int var4 = 0; var4 < this.objectTypes.length; ++var4) {
                if (this.objectTypes[var4] == var1) {
                    return models_ref.tryLoadRecord(this.objectModels[var4] & 65535, 0);
                }
            }

            return true;
        } else if (this.objectModels == null) {
            return true;
        } else if (var1 != 10) {
            return true;
        } else {
            boolean var2 = true;

            for (final int objectModel : this.objectModels) {
                var2 &= models_ref.tryLoadRecord(objectModel & 65535, 0);
            }

            return var2;
        }
    }

    public final boolean method5027() {
        if (this.objectModels == null) {
            return true;
        } else {
            boolean var1 = true;

            for (final int objectModel : this.objectModels) {
                var1 &= models_ref.tryLoadRecord(objectModel & 65535, 0);
            }

            return var1;
        }
    }

    public final Renderable getModel(final int var1, final int var2, final int[][] var3, final int var4, final int var5, final int var6) {
        final long var7;
        if (this.objectTypes == null) {
            var7 = (var2 + (this.id << 10));
        } else {
            var7 = (var2 + (var1 << 3) + (this.id << 10));
        }

        Object var9 = cachedModels.get(var7);
        if (var9 == null) {
            final ModelData var10 = this.getModel(var1, var2);
            if (var10 == null) {
                return null;
            }

            if (!this.nonFlatShading) {
                var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            } else {
                var10.field1731 = (short) (this.ambient + 64);
                var10.contrast = (short) (this.contrast + 768);
                var10.computeNormals();
                var9 = var10;
            }

            cachedModels.put((CacheableNode) var9, var7);
        }

        if (this.nonFlatShading) {
            var9 = ((ModelData) var9).method2604();
        }

        if (this.contouredGround >= 0) {
            if (var9 instanceof Model) {
                var9 = ((Model) var9).method2686(var3, var4, var5, var6, true, this.contouredGround);
            } else if (var9 instanceof ModelData) {
                var9 = ((ModelData) var9).method2601(var3, var4, var5, var6, this.contouredGround);
            }
        }

        return (Renderable) var9;
    }

    public final Model method4999(final int var1, final int var2, final int[][] var3, final int var4, final int var5, final int var6) {
        final long var7;
        if (this.objectTypes == null) {
            var7 = (var2 + (this.id << 10));
        } else {
            var7 = (var2 + (var1 << 3) + (this.id << 10));
        }

        Model var9 = (Model) field3595.get(var7);
        if (var9 == null) {
            final ModelData var10 = this.getModel(var1, var2);
            if (var10 == null) {
                return null;
            }

            var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            field3595.put(var9, var7);
        }

        if (this.contouredGround >= 0) {
            var9 = var9.method2686(var3, var4, var5, var6, true, this.contouredGround);
        }

        return var9;
    }

    final Model method5000(final int objectType, final int orientation, final int[][] tileHeight, final int var4, final int var5, final int var6, final Sequence sequence, final int animationFrame) {
        final long var9;
        if (this.objectTypes == null) {
            var9 = (orientation + (this.id << 10));
        } else {
            var9 = (orientation + (objectType << 3) + (this.id << 10));
        }

        Model model = (Model) field3595.get(var9);
        if (model == null) {
            final ModelData modelData = this.getModel(objectType, orientation);
            if (modelData == null) {
                return null;
            }

            model = modelData.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            field3595.put(model, var9);
        }

        if (sequence != null || this.contouredGround != -1) {
            if (sequence != null) {
                model = sequence.transformObjectModel(model, animationFrame, orientation);
            } else {
                model = model.toSharedModel(true);
            }

            if (this.contouredGround >= 0) {
                model = model.method2686(tileHeight, var4, var5, var6, false, this.contouredGround);
            }

        }
        return model;
    }

    private ModelData getModel(final int objectType, int orientation) {
        ModelData var3 = null;
        boolean var4;
        int var5;
        int var7;
        if (this.objectTypes == null) {
            if (objectType != 10) {
                return null;
            }

            if (this.objectModels == null) {
                return null;
            }

            var4 = this.isRotated;
            if (objectType == 2 && orientation > 3) {
                var4 = !var4;
            }

            var5 = this.objectModels.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                var7 = this.objectModels[var6];
                if (var4) {
                    var7 += 65536;
                }

                var3 = (ModelData) field3593.get(var7);
                if (var3 == null) {
                    var3 = ModelData.method2645(models_ref, var7 & 65535, 0);
                    if (var3 == null) {
                        return null;
                    }

                    if (var4) {
                        var3.method2614();
                    }

                    field3593.put(var3, var7);
                }

                if (var5 > 1) {
                    field3596[var6] = var3;
                }
            }

            if (var5 > 1) {
                var3 = new ModelData(field3596, var5);
            }
        } else {
            int var9 = -1;

            for (var5 = 0; var5 < this.objectTypes.length; ++var5) {
                if (this.objectTypes[var5] == objectType) {
                    var9 = var5;
                    break;
                }
            }

            if (var9 == -1) {
                return null;
            }

            var5 = this.objectModels[var9];
            final boolean var10 = this.isRotated ^ orientation > 3;
            if (var10) {
                var5 += 65536;
            }

            var3 = (ModelData) field3593.get(var5);
            if (var3 == null) {
                var3 = ModelData.method2645(models_ref, var5 & 65535, 0);
                if (var3 == null) {
                    return null;
                }

                if (var10) {
                    var3.method2614();
                }

                field3593.put(var3, var5);
            }
        }

        var4 = this.modelSizeX != 128 || this.modelSizeHeight != 128 || this.modelSizeY != 128;

        final boolean var11;
        var11 = this.offsetX != 0 || this.offsetHeight != 0 || this.offsetY != 0;

        final ModelData var8 = new ModelData(var3, orientation == 0 && !var4 && !var11, this.recolorToFind == null, null == this.textureToFind);
        if (objectType == 4 && orientation > 3) {
            var8.method2606(256);
            var8.method2611(45, 0, -45);
        }

        orientation &= 3;
        if (orientation == 1) {
            var8.method2607();
        } else if (orientation == 2) {
            var8.method2625();
        } else if (orientation == 3) {
            var8.method2610();
        }

        if (this.recolorToFind != null) {
            for (var7 = 0; var7 < this.recolorToFind.length; ++var7) {
                var8.recolor(this.recolorToFind[var7], this.recolorToReplace[var7]);
            }
        }

        if (this.textureToFind != null) {
            for (var7 = 0; var7 < this.textureToFind.length; ++var7) {
                var8.method2613(this.textureToFind[var7], this.textureToReplace[var7]);
            }
        }

        if (var4) {
            var8.method2615(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
        }

        if (var11) {
            var8.method2611(this.offsetX, this.offsetHeight, this.offsetY);
        }

        return var8;
    }

    public final ObjectComposition getImpostor() {
        int var1 = -1;
        if (this.varpId != -1) {
            var1 = Varbit.getVarbit(this.varpId);
        } else if (this.configId != -1) {
            var1 = VarpStorage.clientVarps[this.configId];
        }

        final int var2;
        if (var1 >= 0 && var1 < this.impostorIds.length - 1) {
            var2 = this.impostorIds[var1];
        } else {
            var2 = this.impostorIds[this.impostorIds.length - 1];
        }

        return var2 != -1 ? GameCanvas.getObjectDefinition(var2) : null;
    }

    public int method5003(final int var1, final int var2) {
        return Frames.method3062(this.params, var1, var2);
    }

    public String method5008(final int var1, final String var2) {
        return WorldMapType1.method309(this.params, var1, var2);
    }

    public boolean method5005() {
        if (this.impostorIds == null) {
            return this.ambientSoundId != -1 || this.field3614 != null;
        } else {
            for (final int impostorId : this.impostorIds) {
                if (impostorId != -1) {
                    final ObjectComposition var2 = GameCanvas.getObjectDefinition(impostorId);
                    if (var2.ambientSoundId != -1 || var2.field3614 != null) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
