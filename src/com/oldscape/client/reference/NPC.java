package com.oldscape.client.reference;

import java.io.File;
import java.io.IOException;

final class NPC extends Actor {
    static String userHome;
    static int field1318;
    NPCComposition composition;

    static boolean method1878(final int var0, final int var1, final class178 var2, final CollisionData collisionData) {
        int var4 = var0;
        int var5 = var1;
        final byte var6 = 64;
        final byte var7 = 64;
        final int var8 = var0 - var6;
        final int var9 = var1 - var7;
        class177.field2285[var6][var7] = 99;
        class177.field2286[var6][var7] = 0;
        final byte var10 = 0;
        int var11 = 0;
        class177.field2290[var10] = var0;
        int var18 = var10 + 1;
        class177.field2287[var10] = var1;
        final int[][] var12 = collisionData.flags;

        while (var18 != var11) {
            var4 = class177.field2290[var11];
            var5 = class177.field2287[var11];
            var11 = var11 + 1 & 4095;
            final int var16 = var4 - var8;
            final int var17 = var5 - var9;
            final int var13 = var4 - collisionData.x;
            final int var14 = var5 - collisionData.y;
            if (var2.vmethod3428(1, var4, var5, collisionData)) {
                class177.field2283 = var4;
                class177.field2289 = var5;
                return true;
            }

            final int var15 = class177.field2286[var16][var17] + 1;
            if (var16 > 0 && class177.field2285[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
                class177.field2290[var18] = var4 - 1;
                class177.field2287[var18] = var5;
                var18 = var18 + 1 & 4095;
                class177.field2285[var16 - 1][var17] = 2;
                class177.field2286[var16 - 1][var17] = var15;
            }

            if (var16 < 127 && class177.field2285[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
                class177.field2290[var18] = var4 + 1;
                class177.field2287[var18] = var5;
                var18 = var18 + 1 & 4095;
                class177.field2285[var16 + 1][var17] = 8;
                class177.field2286[var16 + 1][var17] = var15;
            }

            if (var17 > 0 && class177.field2285[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
                class177.field2290[var18] = var4;
                class177.field2287[var18] = var5 - 1;
                var18 = var18 + 1 & 4095;
                class177.field2285[var16][var17 - 1] = 1;
                class177.field2286[var16][var17 - 1] = var15;
            }

            if (var17 < 127 && class177.field2285[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
                class177.field2290[var18] = var4;
                class177.field2287[var18] = var5 + 1;
                var18 = var18 + 1 & 4095;
                class177.field2285[var16][var17 + 1] = 4;
                class177.field2286[var16][var17 + 1] = var15;
            }

            if (var16 > 0 && var17 > 0 && class177.field2285[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
                class177.field2290[var18] = var4 - 1;
                class177.field2287[var18] = var5 - 1;
                var18 = var18 + 1 & 4095;
                class177.field2285[var16 - 1][var17 - 1] = 3;
                class177.field2286[var16 - 1][var17 - 1] = var15;
            }

            if (var16 < 127 && var17 > 0 && class177.field2285[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
                class177.field2290[var18] = var4 + 1;
                class177.field2287[var18] = var5 - 1;
                var18 = var18 + 1 & 4095;
                class177.field2285[var16 + 1][var17 - 1] = 9;
                class177.field2286[var16 + 1][var17 - 1] = var15;
            }

            if (var16 > 0 && var17 < 127 && class177.field2285[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
                class177.field2290[var18] = var4 - 1;
                class177.field2287[var18] = var5 + 1;
                var18 = var18 + 1 & 4095;
                class177.field2285[var16 - 1][var17 + 1] = 6;
                class177.field2286[var16 - 1][var17 + 1] = var15;
            }

            if (var16 < 127 && var17 < 127 && class177.field2285[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
                class177.field2290[var18] = var4 + 1;
                class177.field2287[var18] = var5 + 1;
                var18 = var18 + 1 & 4095;
                class177.field2285[var16 + 1][var17 + 1] = 12;
                class177.field2286[var16 + 1][var17 + 1] = var15;
            }
        }

        class177.field2283 = var4;
        class177.field2289 = var5;
        return false;
    }

    public static FileOnDisk getPreferencesFile(final String var0, final String var1, final boolean var2) {
        final File var3 = new File(class241.field2807, "preferences" + var0 + ".dat");
        if (var3.exists()) {
            try {
                return new FileOnDisk(var3, "rw", 10000L);
            } catch (final IOException ignored) {
            }
        }

        String var4 = "";
        if (BoundingBox.field253 == 33) {
            var4 = "_rc";
        } else if (BoundingBox.field253 == 34) {
            var4 = "_wip";
        }

        final File var5 = new File(userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
        FileOnDisk var6;
        if (!var2 && var5.exists()) {
            try {
                var6 = new FileOnDisk(var5, "rw", 10000L);
                return var6;
            } catch (final IOException ignored) {
            }
        }

        try {
            var6 = new FileOnDisk(var3, "rw", 10000L);
            return var6;
        } catch (final IOException var7) {
            throw new RuntimeException();
        }
    }

    final void method1873(final int var1, final byte var2) {
        int var3 = super.pathX[0];
        int var4 = super.pathY[0];
        if (var1 == 0) {
            --var3;
            ++var4;
        }

        if (var1 == 1) {
            ++var4;
        }

        if (var1 == 2) {
            ++var3;
            ++var4;
        }

        if (var1 == 3) {
            --var3;
        }

        if (var1 == 4) {
            ++var3;
        }

        if (var1 == 5) {
            --var3;
            --var4;
        }

        if (var1 == 6) {
            --var4;
        }

        if (var1 == 7) {
            ++var3;
            --var4;
        }

        if (super.animation != -1 && CombatInfo1.getAnimation(super.animation).priority == 1) {
            super.animation = -1;
        }

        if (super.queueSize < 9) {
            ++super.queueSize;
        }

        for (int var5 = super.queueSize; var5 > 0; --var5) {
            super.pathX[var5] = super.pathX[var5 - 1];
            super.pathY[var5] = super.pathY[var5 - 1];
            super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
        }

        super.pathX[0] = var3;
        super.pathY[0] = var4;
        super.pathTraversed[0] = var2;
    }

    final void method1874(final int var1, final int var2, final boolean var3) {
        if (super.animation != -1 && CombatInfo1.getAnimation(super.animation).priority == 1) {
            super.animation = -1;
        }

        if (!var3) {
            final int var4 = var1 - super.pathX[0];
            final int var5 = var2 - super.pathY[0];
            if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
                if (super.queueSize < 9) {
                    ++super.queueSize;
                }

                for (int var6 = super.queueSize; var6 > 0; --var6) {
                    super.pathX[var6] = super.pathX[var6 - 1];
                    super.pathY[var6] = super.pathY[var6 - 1];
                    super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
                }

                super.pathX[0] = var1;
                super.pathY[0] = var2;
                super.pathTraversed[0] = 1;
                return;
            }
        }

        super.queueSize = 0;
        super.field1216 = 0;
        super.field1158 = 0;
        super.pathX[0] = var1;
        super.pathY[0] = var2;
        super.x = super.size * 64 + super.pathX[0] * 128;
        super.y = super.size * 64 + super.pathY[0] * 128;
    }

    protected final Model getModel() {
        if (this.composition == null) {
            return null;
        } else {
            final Sequence action = super.animation != -1 && super.actionAnimationDisable == 0 ? CombatInfo1.getAnimation(super.animation) : null;
            final Sequence pose = super.poseAnimation == -1 || super.idlePoseAnimation == super.poseAnimation && action != null ? null : CombatInfo1.getAnimation(super.poseAnimation);
            Model model = this.composition.getModel(action, super.actionFrame, pose, super.poseFrame);
            if (model == null) {
                return null;
            } else {
                model.calculateBoundsCylinder();
                super.logicalHeight = model.modelHeight;
                if (super.graphic != -1 && super.spotAnimFrame != -1) {
                    final Model spotAnimModel = Spotanim.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
                    if (spotAnimModel != null) {
                        spotAnimModel.offsetBy(0, -super.field1198, 0);
                        final Model[] modelParts = {model, spotAnimModel};
                        model = new Model(modelParts, 2);
                    }
                }

                if (this.composition.size == 1) {
                    model.field1874 = true;
                }

                return model;
            }
        }
    }

    final boolean hasConfig() {
        return this.composition != null;
    }
}
