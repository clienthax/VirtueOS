package com.oldscape.client.reference;

class WorldMapDecoration {
    public static Font field445;
    static Resampler field446;
    final int objectDefinitionId;
    final int decoration;
    final int rotation;

    WorldMapDecoration(final int objectId, final int decoration, final int rotation) {
        this.objectDefinitionId = objectId;
        this.decoration = decoration;
        this.rotation = rotation;
    }

    static boolean method315(final char var0) {
        return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
    }

    static Script method313(final int var0) {
        Script var1 = (Script) Script.field1459.get(var0);
        if (var1 != null) {
            return var1;
        } else {
            final byte[] var2 = class190.indexScripts.getConfigData(var0, 0);
            if (var2 == null) {
                return null;
            } else {
                var1 = Signlink.newScript(var2);
                Script.field1459.put(var1, var0);
                return var1;
            }
        }
    }

    public static SpritePixels createSprite(final int var0, final int var1, final int var2, final int var3, int var4, final boolean var5) {
        if (var1 == -1) {
            var4 = 0;
        } else if (var4 == 2 && var1 != 1) {
            var4 = 1;
        }

        final long var6 = ((long) var1 << 16) + var0 + ((long) var2 << 38) + ((long) var4 << 40) + ((long) var3 << 42);
        SpritePixels var8;
        if (!var5) {
            var8 = (SpritePixels) ItemComposition.itemSpriteCache.get(var6);
            if (var8 != null) {
                return var8;
            }
        }

        ItemComposition var9 = ItemComposition.getItemDefinition(var0);
        if (var1 > 1 && var9.countObj != null) {
            int var10 = -1;

            for (int var11 = 0; var11 < 10; ++var11) {
                if (var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
                    var10 = var9.countObj[var11];
                }
            }

            if (var10 != -1) {
                var9 = ItemComposition.getItemDefinition(var10);
            }
        }

        final Model var19 = var9.getModel(1);
        if (var19 == null) {
            return null;
        } else {
            SpritePixels var20 = null;
            if (var9.notedTemplate != -1) {
                var20 = createSprite(var9.note, 10, 1, 0, 0, true);
                if (var20 == null) {
                    return null;
                }
            } else if (var9.notedId != -1) {
                var20 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
                if (var20 == null) {
                    return null;
                }
            } else if (var9.placeholderTemplateId != -1) {
                var20 = createSprite(var9.placeholderId, var1, 0, 0, 0, false);
                if (var20 == null) {
                    return null;
                }
            }

            final int[] var12 = Rasterizer2D.graphicsPixels;
            final int var13 = Rasterizer2D.graphicsPixelsWidth;
            final int var14 = Rasterizer2D.graphicsPixelsHeight;
            final int[] var15 = new int[4];
            Rasterizer2D.copyDrawRegion(var15);
            var8 = new SpritePixels(36, 32);
            Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
            Rasterizer2D.reset();
            Graphics3D.Rasterizer3D_method1();
            Graphics3D.method2780(16, 16);
            Graphics3D.rasterGouraudLowRes = false;
            if (var9.placeholderTemplateId != -1) {
                var20.drawAt(0, 0);
            }

            int var16 = var9.zoom2d;
            if (var5) {
                var16 = (int) (var16 * 1.5D);
            } else if (var2 == 2) {
                var16 = (int) (var16 * 1.04D);
            }

            final int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
            final int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
            var19.calculateBoundsCylinder();
            var19.method2734(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
            if (var9.notedId != -1) {
                var20.drawAt(0, 0);
            }

            if (var2 >= 1) {
                var8.method5854(1);
            }

            if (var2 >= 2) {
                var8.method5854(16777215);
            }

            if (var3 != 0) {
                var8.method5855(var3);
            }

            Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
            if (var9.notedTemplate != -1) {
                var20.drawAt(0, 0);
            }

            if (var4 == 1 || var4 == 2 && var9.isStackable == 1) {
                field445.method5510(PlayerComposition.method4408(var1), 0, 9, 16776960, 1);
            }

            if (!var5) {
                ItemComposition.itemSpriteCache.put(var8, var6);
            }

            Rasterizer2D.setRasterBuffer(var12, var13, var14);
            Rasterizer2D.setDrawRegion(var15);
            Graphics3D.Rasterizer3D_method1();
            Graphics3D.rasterGouraudLowRes = true;
            return var8;
        }
    }

    static void method310(final int var0, final Coordinates coordinates, final boolean var2) {
        final WorldMapData var3 = class86.method1892().getWorldMapDataByFileId(var0);
        final int plane = Client.localPlayer.plane;
        final int var5 = (Client.localPlayer.x >> 7) + class138.baseX;
        final int var6 = (Client.localPlayer.y >> 7) + class23.baseY;
        final Coordinates var7 = new Coordinates(plane, var5, var6);
        class86.method1892().method6024(var3, var7, coordinates, var2);
    }

    static void characterToScreen(final Actor var0, final int var1) {
        SoundTask.worldToScreen(var0.x, var0.y, var1);
    }
}
