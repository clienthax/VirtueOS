package com.oldscape.client.reference;

class class37 {
    static final class37 field499;
    static final class37 field498;
    static int field497;
    static int idxCount;
    static int field502;
    static String field501;

    static {
        field499 = new class37(0);
        field498 = new class37(1);
    }

    final int field500;

    private class37(final int var1) {
        this.field500 = var1;
    }

    static void method544() {
        ItemContainer.itemContainers = new HashTable(32);
    }

    static int method543(final int var0, final int var1, final int var2) {
        final int var3 = 256 - var2;
        return ((var0 & 65280) * var3 + (var1 & 65280) * var2 & 16711680) + ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) >> 8;
    }

    static void drawWorldSelect(final Font var0, final Font var1) {
        if (class5.field40 == null) {
            class5.field40 = IndexDataBase.getSprites(class151.indexSprites, "sl_back", "");
        }

        if (BoundingBox3DDrawMode.slFlagSprites == null) {
            BoundingBox3DDrawMode.slFlagSprites = WorldMapManager.getIndexedSprites(class151.indexSprites, "sl_flags", "");
        }

        if (VarpStorage.slArrowSprites == null) {
            VarpStorage.slArrowSprites = WorldMapManager.getIndexedSprites(class151.indexSprites, "sl_arrows", "");
        }

        if (World.slStarSprites == null) {
            World.slStarSprites = WorldMapManager.getIndexedSprites(class151.indexSprites, "sl_stars", "");
        }

        Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1359, 23, 765, 480, 0);
        Rasterizer2D.method5727(class90.field1359, 0, 125, 23, 12425273, 9135624);
        Rasterizer2D.method5727(class90.field1359 + 125, 0, 640, 23, 5197647, 2697513);
        var0.drawTextCentered("Select a world", class90.field1359 + 62, 15, 0, -1);
        if (World.slStarSprites != null) {
            World.slStarSprites[1].method5825(class90.field1359 + 140, 1);
            var1.method5510("Members only world", class90.field1359 + 152, 10, 16777215, -1);
            World.slStarSprites[0].method5825(class90.field1359 + 140, 12);
            var1.method5510("Free world", class90.field1359 + 152, 21, 16777215, -1);
        }

        int var4;
        int var5;
        if (VarpStorage.slArrowSprites != null) {
            final int var2 = class90.field1359 + 280;
            if (World.field1230[0] == 0 && World.field1229[0] == 0) {
                VarpStorage.slArrowSprites[2].method5825(var2, 4);
            } else {
                VarpStorage.slArrowSprites[0].method5825(var2, 4);
            }

            if (World.field1230[0] == 0 && World.field1229[0] == 1) {
                VarpStorage.slArrowSprites[3].method5825(var2 + 15, 4);
            } else {
                VarpStorage.slArrowSprites[1].method5825(var2 + 15, 4);
            }

            var0.method5510("World", var2 + 32, 17, 16777215, -1);
            final int var3 = class90.field1359 + 390;
            if (World.field1230[0] == 1 && World.field1229[0] == 0) {
                VarpStorage.slArrowSprites[2].method5825(var3, 4);
            } else {
                VarpStorage.slArrowSprites[0].method5825(var3, 4);
            }

            if (World.field1230[0] == 1 && World.field1229[0] == 1) {
                VarpStorage.slArrowSprites[3].method5825(var3 + 15, 4);
            } else {
                VarpStorage.slArrowSprites[1].method5825(var3 + 15, 4);
            }

            var0.method5510("Players", var3 + 32, 17, 16777215, -1);
            var4 = class90.field1359 + 500;
            if (World.field1230[0] == 2 && World.field1229[0] == 0) {
                VarpStorage.slArrowSprites[2].method5825(var4, 4);
            } else {
                VarpStorage.slArrowSprites[0].method5825(var4, 4);
            }

            if (World.field1230[0] == 2 && World.field1229[0] == 1) {
                VarpStorage.slArrowSprites[3].method5825(var4 + 15, 4);
            } else {
                VarpStorage.slArrowSprites[1].method5825(var4 + 15, 4);
            }

            var0.method5510("Location", var4 + 32, 17, 16777215, -1);
            var5 = class90.field1359 + 610;
            if (World.field1230[0] == 3 && World.field1229[0] == 0) {
                VarpStorage.slArrowSprites[2].method5825(var5, 4);
            } else {
                VarpStorage.slArrowSprites[0].method5825(var5, 4);
            }

            if (World.field1230[0] == 3 && World.field1229[0] == 1) {
                VarpStorage.slArrowSprites[3].method5825(var5 + 15, 4);
            } else {
                VarpStorage.slArrowSprites[1].method5825(var5 + 15, 4);
            }

            var0.method5510("Type", var5 + 32, 17, 16777215, -1);
        }

        Rasterizer2D.Rasterizer2D_fillRectangle(class90.field1359 + 708, 4, 50, 16, 0);
        var1.drawTextCentered("Cancel", class90.field1359 + 708 + 25, 16, 16777215, -1);
        class90.field1390 = -1;
        if (class5.field40 != null) {
            final byte var21 = 88;
            final byte var22 = 19;
            var4 = 765 / (var21 + 1);
            var5 = 480 / (var22 + 1);

            int var6;
            int var7;
            do {
                var6 = var5;
                var7 = var4;
                if (var5 * (var4 - 1) >= World.worldCount) {
                    --var4;
                }

                if (var4 * (var5 - 1) >= World.worldCount) {
                    --var5;
                }

                if (var4 * (var5 - 1) >= World.worldCount) {
                    --var5;
                }
            } while (var5 != var6 || var7 != var4);

            var6 = (765 - var21 * var4) / (var4 + 1);
            if (var6 > 5) {
                var6 = 5;
            }

            var7 = (480 - var22 * var5) / (var5 + 1);
            if (var7 > 5) {
                var7 = 5;
            }

            final int var8 = (765 - var4 * var21 - var6 * (var4 - 1)) / 2;
            final int var9 = (480 - var5 * var22 - var7 * (var5 - 1)) / 2;
            int var10 = var9 + 23;
            int var11 = var8 + class90.field1359;
            int var12 = 0;
            boolean var13 = false;

            int var14;
            for (var14 = 0; var14 < World.worldCount; ++var14) {
                final World var15 = World.worldList[var14];
                boolean var16 = true;
                String var17 = Integer.toString(var15.playerCount);
                if (var15.playerCount == -1) {
                    var17 = "OFF";
                    var16 = false;
                } else if (var15.playerCount > 1980) {
                    var17 = "FULL";
                    var16 = false;
                }

                int var19 = 0;
                final byte var18;
                if (var15.method1688()) {
                    if (var15.method1683()) {
                        var18 = 7;
                    } else {
                        var18 = 6;
                    }
                } else if (var15.method1687()) {
                    var19 = 16711680;
                    if (var15.method1683()) {
                        var18 = 5;
                    } else {
                        var18 = 4;
                    }
                } else if (var15.method1685()) {
                    if (var15.method1683()) {
                        var18 = 3;
                    } else {
                        var18 = 2;
                    }
                } else if (var15.method1683()) {
                    var18 = 1;
                } else {
                    var18 = 0;
                }

                if (MouseInput.mouseLastX >= var11 && MouseInput.mouseLastY >= var10 && MouseInput.mouseLastX < var21 + var11 && MouseInput.mouseLastY < var10 + var22 && var16) {
                    class90.field1390 = var14;
                    class5.field40[var18].method5862(var11, var10, 128, 16777215);
                    var13 = true;
                } else {
                    class5.field40[var18].method5856(var11, var10);
                }

                if (BoundingBox3DDrawMode.slFlagSprites != null) {
                    BoundingBox3DDrawMode.slFlagSprites[(var15.method1683() ? 8 : 0) + var15.location].method5825(var11 + 29, var10);
                }

                var0.drawTextCentered(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
                var1.drawTextCentered(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
                var10 = var10 + var22 + var7;
                ++var12;
                if (var12 >= var5) {
                    var10 = var9 + 23;
                    var11 = var11 + var21 + var6;
                    var12 = 0;
                }
            }

            if (var13) {
                var14 = var1.getTextWidth(World.worldList[class90.field1390].activity) + 6;
                final int var20 = var1.verticalSpace + 8;
                Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - var14 / 2, MouseInput.mouseLastY + 20 + 5, var14, var20, 16777120);
                Rasterizer2D.drawRectangle(MouseInput.mouseLastX - var14 / 2, MouseInput.mouseLastY + 20 + 5, var14, var20, 0);
                var1.drawTextCentered(World.worldList[class90.field1390].activity, MouseInput.mouseLastX, MouseInput.mouseLastY + var1.verticalSpace + 20 + 5 + 4, 0, -1);
            }
        }

        MapCacheArchiveNames.rasterProvider.drawFull(0, 0);
    }
}
