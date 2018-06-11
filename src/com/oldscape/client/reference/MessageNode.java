package com.oldscape.client.reference;

import java.io.File;
import java.io.RandomAccessFile;

class MessageNode extends CacheableNode {
    static Font fontBold12;
    int id;
    int tick;
    int type;
    String name;
    String sender;
    String value;
    private Name field824;
    private class303 field820;
    private class303 field821;

    MessageNode(final int var1, final String var2, final String var3, final String var4) {
        this.field820 = class303.field3851;
        this.field821 = class303.field3851;
        this.id = ++class95.field1452 - 1;
        this.tick = Client.gameCycle;
        this.type = var1;
        this.name = var2;
        this.method1153();
        this.sender = var3;
        this.value = var4;
    }

    static File method1176(final String var0) {
        if (!class170.field2234) {
            throw new RuntimeException("");
        } else {
            final File var1 = class170.field2232.get(var0);
            if (var1 != null) {
                return var1;
            } else {
                final File var2 = new File(class170.field2233, var0);
                RandomAccessFile var3 = null;

                try {
                    final File var4 = new File(var2.getParent());
                    if (!var4.exists()) {
                        throw new RuntimeException("");
                    } else {
                        var3 = new RandomAccessFile(var2, "rw");
                        final int var5 = var3.read();
                        var3.seek(0L);
                        var3.write(var5);
                        var3.seek(0L);
                        var3.close();
                        class170.field2232.put(var0, var2);
                        return var2;
                    }
                } catch (final Exception var8) {
                    try {
                        if (var3 != null) {
                            var3.close();
                        }
                    } catch (final Exception ignored) {
                    }

                    throw new RuntimeException();
                }
            }
        }
    }

    static boolean method1179(final int var0, int var1) {
        final ObjectComposition var2 = GameCanvas.getObjectDefinition(var0);
        if (var1 == 11) {
            var1 = 10;
        }

        if (var1 >= 5 && var1 <= 8) {
            var1 = 4;
        }

        return var2.method4996(var1);
    }

    static void drawObject(final int var0, final int var1, final int var2, final int var3, final int var4) {
        int var5 = class255.region.getWallObjectHash(var0, var1, var2);
        int var6;
        int var7;
        int var8;
        int var9;
        int var11;
        int var12;
        if (var5 != 0) {
            var6 = class255.region.getObjectFlags(var0, var1, var2, var5);
            var7 = var6 >> 6 & 3;
            var8 = var6 & 31;
            var9 = var3;
            if (var5 > 0) {
                var9 = var4;
            }

            final int[] var10 = BoundingBox2D.minimapSprite.pixels;
            var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
            var12 = var5 >> 14 & 32767;
            final ObjectComposition objectDefinition = GameCanvas.getObjectDefinition(var12);
            if (objectDefinition.mapSceneId != -1) {
                final IndexedSprite sprite = GroundObject.mapscene[objectDefinition.mapSceneId];
                if (sprite != null) {
                    final int var15 = (objectDefinition.width * 4 - sprite.width) / 2;
                    final int var16 = (objectDefinition.length * 4 - sprite.height) / 2;
                    sprite.method5825(var1 * 4 + var15 + 48, var16 + (104 - var2 - objectDefinition.length) * 4 + 48);
                }
            } else {
                if (var8 == 0 || var8 == 2) {
                    if (var7 == 0) {
                        var10[var11] = var9;
                        var10[var11 + 512] = var9;
                        var10[var11 + 1024] = var9;
                        var10[var11 + 1536] = var9;
                    } else if (var7 == 1) {
                        var10[var11] = var9;
                        var10[var11 + 1] = var9;
                        var10[var11 + 2] = var9;
                        var10[var11 + 3] = var9;
                    } else if (var7 == 2) {
                        var10[var11 + 3] = var9;
                        var10[var11 + 512 + 3] = var9;
                        var10[var11 + 1024 + 3] = var9;
                        var10[var11 + 1536 + 3] = var9;
                    } else if (var7 == 3) {
                        var10[var11 + 1536] = var9;
                        var10[var11 + 1536 + 1] = var9;
                        var10[var11 + 1536 + 2] = var9;
                        var10[var11 + 1536 + 3] = var9;
                    }
                }

                if (var8 == 3) {
                    if (var7 == 0) {
                        var10[var11] = var9;
                    } else if (var7 == 1) {
                        var10[var11 + 3] = var9;
                    } else if (var7 == 2) {
                        var10[var11 + 1536 + 3] = var9;
                    } else if (var7 == 3) {
                        var10[var11 + 1536] = var9;
                    }
                }

                if (var8 == 2) {
                    if (var7 == 3) {
                        var10[var11] = var9;
                        var10[var11 + 512] = var9;
                        var10[var11 + 1024] = var9;
                        var10[var11 + 1536] = var9;
                    } else if (var7 == 0) {
                        var10[var11] = var9;
                        var10[var11 + 1] = var9;
                        var10[var11 + 2] = var9;
                        var10[var11 + 3] = var9;
                    } else if (var7 == 1) {
                        var10[var11 + 3] = var9;
                        var10[var11 + 512 + 3] = var9;
                        var10[var11 + 1024 + 3] = var9;
                        var10[var11 + 1536 + 3] = var9;
                    } else if (var7 == 2) {
                        var10[var11 + 1536] = var9;
                        var10[var11 + 1536 + 1] = var9;
                        var10[var11 + 1536 + 2] = var9;
                        var10[var11 + 1536 + 3] = var9;
                    }
                }
            }
        }

        var5 = class255.region.method2888(var0, var1, var2);
        if (var5 != 0) {
            var6 = class255.region.getObjectFlags(var0, var1, var2, var5);
            var7 = var6 >> 6 & 3;
            var8 = var6 & 31;
            var9 = var5 >> 14 & 32767;
            final ObjectComposition var23 = GameCanvas.getObjectDefinition(var9);
            final int var18;
            if (var23.mapSceneId != -1) {
                final IndexedSprite var17 = GroundObject.mapscene[var23.mapSceneId];
                if (var17 != null) {
                    var12 = (var23.width * 4 - var17.width) / 2;
                    var18 = (var23.length * 4 - var17.height) / 2;
                    var17.method5825(var12 + var1 * 4 + 48, (104 - var2 - var23.length) * 4 + var18 + 48);
                }
            } else if (var8 == 9) {
                var11 = 15658734;
                if (var5 > 0) {
                    var11 = 15597568;
                }

                final int[] var22 = BoundingBox2D.minimapSprite.pixels;
                var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
                if (var7 != 0 && var7 != 2) {
                    var22[var18] = var11;
                    var22[var18 + 1 + 512] = var11;
                    var22[var18 + 1024 + 2] = var11;
                    var22[var18 + 1536 + 3] = var11;
                } else {
                    var22[var18 + 1536] = var11;
                    var22[var18 + 1 + 1024] = var11;
                    var22[var18 + 512 + 2] = var11;
                    var22[var18 + 3] = var11;
                }
            }
        }

        var5 = class255.region.getGroundObjectHash(var0, var1, var2);
        if (var5 != 0) {
            var6 = var5 >> 14 & 32767;
            final ObjectComposition var19 = GameCanvas.getObjectDefinition(var6);
            if (var19.mapSceneId != -1) {
                final IndexedSprite sprite = GroundObject.mapscene[var19.mapSceneId];
                if (sprite != null) {
                    var9 = (var19.width * 4 - sprite.width) / 2;
                    final int var21 = (var19.length * 4 - sprite.height) / 2;
                    sprite.method5825(var9 + var1 * 4 + 48, var21 + (104 - var2 - var19.length) * 4 + 48);
                }
            }
        }

    }

    void setMessage(final int var1, final String var2, final String var3, final String var4) {
        this.id = ++class95.field1452 - 1;
        this.tick = Client.gameCycle;
        this.type = var1;
        this.name = var2;
        this.method1153();
        this.sender = var3;
        this.value = var4;
    }

    void method1148() {
        this.field820 = class303.field3851;
    }

    final boolean method1149() {
        if (this.field820 == class303.field3851) {
            this.method1150();
        }

        return this.field820 == class303.field3850;
    }

    private void method1150() {
        this.field820 = WorldMapRectangle.friendManager.field1256.isMember(this.field824) ? class303.field3850 : class303.field3849;
    }

    void method1162() {
        this.field821 = class303.field3851;
    }

    final boolean method1152() {
        if (this.field821 == class303.field3851) {
            this.method1161();
        }

        return this.field821 == class303.field3850;
    }

    private void method1161() {
        this.field821 = WorldMapRectangle.friendManager.field1254.isMember(this.field824) ? class303.field3850 : class303.field3849;
    }

    private void method1153() {
        if (this.name != null) {
            this.field824 = new Name(FontName.method5489(this.name), GZipDecompressor.loginType);
        } else {
            this.field824 = null;
        }

    }
}
