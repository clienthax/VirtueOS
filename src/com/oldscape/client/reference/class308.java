package com.oldscape.client.reference;

class class308 extends class221 {
    public final int field3876;
    public final Name name;
    public final short field3875;

    class308(final Name name, final int var2) {
        this.field3876 = (int) (class64.method1118() / 1000L);
        this.name = name;
        this.field3875 = (short) var2;
    }

    static int method5486(final Widget var0, final int var1) {
        if (var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
            try {
                final int[] var2 = var0.dynamicValues[var1];
                int var3 = 0;
                int var4 = 0;
                byte var5 = 0;

                while (true) {
                    final int var6 = var2[var4++];
                    int var7 = 0;
                    byte var8 = 0;
                    if (var6 == 0) {
                        return var3;
                    }

                    if (var6 == 1) {
                        var7 = Client.boostedSkillLevels[var2[var4++]];
                    }

                    if (var6 == 2) {
                        var7 = Client.realSkillLevels[var2[var4++]];
                    }

                    if (var6 == 3) {
                        var7 = Client.skillExperiences[var2[var4++]];
                    }

                    int var9;
                    Widget var10;
                    int var11;
                    int var12;
                    if (var6 == 4) {
                        var9 = var2[var4++] << 16;
                        var9 += var2[var4++];
                        var10 = class44.getWidget(var9);
                        var11 = var2[var4++];
                        if (var11 != -1 && (!ItemComposition.getItemDefinition(var11).isMembers || Client.isMembers)) {
                            for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
                                if (var11 + 1 == var10.itemIds[var12]) {
                                    var7 += var10.itemQuantities[var12];
                                }
                            }
                        }
                    }

                    if (var6 == 5) {
                        var7 = VarpStorage.clientVarps[var2[var4++]];
                    }

                    if (var6 == 6) {
                        var7 = class248.field3012[Client.realSkillLevels[var2[var4++]] - 1];
                    }

                    if (var6 == 7) {
                        var7 = VarpStorage.clientVarps[var2[var4++]] * 100 / 46875;
                    }

                    if (var6 == 8) {
                        var7 = Client.localPlayer.combatLevel;
                    }

                    if (var6 == 9) {
                        for (var9 = 0; var9 < 25; ++var9) {
                            if (class248.field3011[var9]) {
                                var7 += Client.realSkillLevels[var9];
                            }
                        }
                    }

                    if (var6 == 10) {
                        var9 = var2[var4++] << 16;
                        var9 += var2[var4++];
                        var10 = class44.getWidget(var9);
                        var11 = var2[var4++];
                        if (var11 != -1 && (!ItemComposition.getItemDefinition(var11).isMembers || Client.isMembers)) {
                            for (var12 = 0; var12 < var10.itemIds.length; ++var12) {
                                if (var11 + 1 == var10.itemIds[var12]) {
                                    var7 = 999999999;
                                    break;
                                }
                            }
                        }
                    }

                    if (var6 == 11) {
                        var7 = Client.energy;
                    }

                    if (var6 == 12) {
                        var7 = Client.weight;
                    }

                    if (var6 == 13) {
                        var9 = VarpStorage.clientVarps[var2[var4++]];
                        final int var13 = var2[var4++];
                        var7 = (var9 & 1 << var13) != 0 ? 1 : 0;
                    }

                    if (var6 == 14) {
                        var9 = var2[var4++];
                        var7 = Varbit.getVarbit(var9);
                    }

                    if (var6 == 15) {
                        var8 = 1;
                    }

                    if (var6 == 16) {
                        var8 = 2;
                    }

                    if (var6 == 17) {
                        var8 = 3;
                    }

                    if (var6 == 18) {
                        var7 = (Client.localPlayer.x >> 7) + class138.baseX;
                    }

                    if (var6 == 19) {
                        var7 = (Client.localPlayer.y >> 7) + class23.baseY;
                    }

                    if (var6 == 20) {
                        var7 = var2[var4++];
                    }

                    if (var8 == 0) {
                        if (var5 == 0) {
                            var3 += var7;
                        }

                        if (var5 == 1) {
                            var3 -= var7;
                        }

                        if (var5 == 2 && var7 != 0) {
                            var3 /= var7;
                        }

                        if (var5 == 3) {
                            var3 *= var7;
                        }

                        var5 = 0;
                    } else {
                        var5 = var8;
                    }
                }
            } catch (final Exception var14) {
                return -1;
            }
        } else {
            return -2;
        }
    }
}
