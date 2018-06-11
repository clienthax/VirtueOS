package com.oldscape.client.reference;

import java.awt.*;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;

public class Cs2Methods {
    static int intStackSize;

    static int processCs2Opcode(final int opcode, final boolean var2) {
        final byte var3;
        int var4;
        int var5;
        final int var6;
        final Widget var28;
        final Widget widget;
        if (opcode < 1000) {
            if (opcode == 100) {
                intStackSize -= 3;
                var4 = class81.intStack[intStackSize];
                var5 = class81.intStack[intStackSize + 1];
                var6 = class81.intStack[intStackSize + 2];
                if (var5 == 0) {
                    throw new RuntimeException();
                }

                var28 = class44.getWidget(var4);
                if (var28.children == null) {
                    var28.children = new Widget[var6 + 1];
                }

                if (var28.children.length <= var6) {
                    final Widget[] var29 = new Widget[var6 + 1];

                    System.arraycopy(var28.children, 0, var29, 0, var28.children.length);

                    var28.children = var29;
                }

                if (var6 > 0 && var28.children[var6 - 1] == null) {
                    throw new RuntimeException("" + (var6 - 1));
                }

                final Widget var30 = new Widget();
                var30.type = var5;
                var30.parentId = var30.id = var28.id;
                var30.index = var6;
                var30.hasScript = true;
                var28.children[var6] = var30;
                if (var2) {
                    class81.field1285 = var30;
                } else {
                    Signlink.field2218 = var30;
                }

                FontName.method5490(var28);
                var3 = 1;
            } else if (opcode == 101) {
                widget = var2 ? class81.field1285 : Signlink.field2218;
                final Widget var44 = class44.getWidget(widget.id);
                var44.children[widget.index] = null;
                FontName.method5490(var44);
                var3 = 1;
            } else if (opcode == 102) {
                widget = class44.getWidget(class81.intStack[--intStackSize]);
                widget.children = null;
                FontName.method5490(widget);
                var3 = 1;
            } else if (opcode == 200) {
                intStackSize -= 2;
                var4 = class81.intStack[intStackSize];
                var5 = class81.intStack[intStackSize + 1];
                final Widget var47 = FontName.getWidgetChild(var4, var5);
                if (var47 != null && var5 != -1) {
                    class81.intStack[++intStackSize - 1] = 1;
                    if (var2) {
                        class81.field1285 = var47;
                    } else {
                        Signlink.field2218 = var47;
                    }
                } else {
                    class81.intStack[++intStackSize - 1] = 0;
                }

                var3 = 1;
            } else if (opcode == 201) {
                widget = class44.getWidget(class81.intStack[--intStackSize]);
                if (widget != null) {
                    class81.intStack[++intStackSize - 1] = 1;
                    if (var2) {
                        class81.field1285 = widget;
                    } else {
                        Signlink.field2218 = widget;
                    }
                } else {
                    class81.intStack[++intStackSize - 1] = 0;
                }

                var3 = 1;
            } else {
                var3 = 2;
            }

            return var3;
        } else if (opcode < 1100) {
            return processOpcode1000To1099(opcode, var2);
        } else if (opcode < 1200) {
            return processOpcode1100To1199(opcode, var2);
        } else if (opcode < 1300) {
            return processOpcode1200To1299(opcode, var2);
        } else if (opcode < 1400) {
            return processOpcode1300To1399(opcode, var2);
        } else if (opcode < 1500) {
            return processOpcode1400To1499(opcode, var2);
        } else if (opcode < 1600) {
            var28 = var2 ? class81.field1285 : Signlink.field2218;
            if (opcode == 1500) {
                class81.intStack[++intStackSize - 1] = var28.relativeX;
                var3 = 1;
            } else if (opcode == 1501) {
                class81.intStack[++intStackSize - 1] = var28.relativeY;
                var3 = 1;
            } else if (opcode == 1502) {
                class81.intStack[++intStackSize - 1] = var28.width;
                var3 = 1;
            } else if (opcode == 1503) {
                class81.intStack[++intStackSize - 1] = var28.height;
                var3 = 1;
            } else if (opcode == 1504) {
                class81.intStack[++intStackSize - 1] = var28.isHidden ? 1 : 0;
                var3 = 1;
            } else if (opcode == 1505) {
                class81.intStack[++intStackSize - 1] = var28.parentId;
                var3 = 1;
            } else {
                var3 = 2;
            }

            return var3;
        } else if (opcode < 1700) {
            widget = var2 ? class81.field1285 : Signlink.field2218;
            if (opcode == 1600) {
                class81.intStack[++intStackSize - 1] = widget.scrollX;
                var3 = 1;
            } else if (opcode == 1601) {
                class81.intStack[++intStackSize - 1] = widget.scrollY;
                var3 = 1;
            } else if (opcode == 1602) {
                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = widget.text;
                var3 = 1;
            } else if (opcode == 1603) {
                class81.intStack[++intStackSize - 1] = widget.scrollWidth;
                var3 = 1;
            } else if (opcode == 1604) {
                class81.intStack[++intStackSize - 1] = widget.scrollHeight;
                var3 = 1;
            } else if (opcode == 1605) {
                class81.intStack[++intStackSize - 1] = widget.modelZoom;
                var3 = 1;
            } else if (opcode == 1606) {
                class81.intStack[++intStackSize - 1] = widget.rotationX;
                var3 = 1;
            } else if (opcode == 1607) {
                class81.intStack[++intStackSize - 1] = widget.rotationY;
                var3 = 1;
            } else if (opcode == 1608) {
                class81.intStack[++intStackSize - 1] = widget.rotationZ;
                var3 = 1;
            } else if (opcode == 1609) {
                class81.intStack[++intStackSize - 1] = widget.opacity;
                var3 = 1;
            } else if (opcode == 1610) {
                class81.intStack[++intStackSize - 1] = widget.field2854;
                var3 = 1;
            } else if (opcode == 1611) {
                class81.intStack[++intStackSize - 1] = widget.textColor;
                var3 = 1;
            } else if (opcode == 1612) {
                class81.intStack[++intStackSize - 1] = widget.field2841;
                var3 = 1;
            } else if (opcode == 1613) {
                class81.intStack[++intStackSize - 1] = widget.field2909.rsOrdinal();
                var3 = 1;
            } else {
                var3 = 2;
            }

            return var3;
        } else if (opcode < 1800) {
            var28 = var2 ? class81.field1285 : Signlink.field2218;
            if (opcode == 1700) {
                class81.intStack[++intStackSize - 1] = var28.itemId;
                var3 = 1;
            } else if (opcode == 1701) {
                if (var28.itemId != -1) {
                    class81.intStack[++intStackSize - 1] = var28.itemQuantity;
                } else {
                    class81.intStack[++intStackSize - 1] = 0;
                }

                var3 = 1;
            } else if (opcode == 1702) {
                class81.intStack[++intStackSize - 1] = var28.index;
                var3 = 1;
            } else {
                var3 = 2;
            }

            return var3;
        } else if (opcode < 1900) {
            return processOpcode1800To1899(opcode, var2);
        } else if (opcode < 2000) {
            return processOpcode1900To1999(opcode, var2);
        } else if (opcode < 2100) {
            return processOpcode1000To1099(opcode, var2);
        } else if (opcode < 2200) {
            return processOpcode1100To1199(opcode, var2);
        } else if (opcode < 2300) {
            return processOpcode1200To1299(opcode, var2);
        } else if (opcode < 2400) {
            return processOpcode1300To1399(opcode, var2);
        } else if (opcode < 2500) {
            return processOpcode1400To1499(opcode, var2);
        } else if (opcode < 2600) {
            return processOpcode2500To2599(opcode);
        } else if (opcode < 2700) {
            widget = class44.getWidget(class81.intStack[--intStackSize]);
            if (opcode == 2600) {
                class81.intStack[++intStackSize - 1] = widget.scrollX;
                var3 = 1;
            } else if (opcode == 2601) {
                class81.intStack[++intStackSize - 1] = widget.scrollY;
                var3 = 1;
            } else if (opcode == 2602) {
                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = widget.text;
                var3 = 1;
            } else if (opcode == 2603) {
                class81.intStack[++intStackSize - 1] = widget.scrollWidth;
                var3 = 1;
            } else if (opcode == 2604) {
                class81.intStack[++intStackSize - 1] = widget.scrollHeight;
                var3 = 1;
            } else if (opcode == 2605) {
                class81.intStack[++intStackSize - 1] = widget.modelZoom;
                var3 = 1;
            } else if (opcode == 2606) {
                class81.intStack[++intStackSize - 1] = widget.rotationX;
                var3 = 1;
            } else if (opcode == 2607) {
                class81.intStack[++intStackSize - 1] = widget.rotationY;
                var3 = 1;
            } else if (opcode == 2608) {
                class81.intStack[++intStackSize - 1] = widget.rotationZ;
                var3 = 1;
            } else if (opcode == 2609) {
                class81.intStack[++intStackSize - 1] = widget.opacity;
                var3 = 1;
            } else if (opcode == 2610) {
                class81.intStack[++intStackSize - 1] = widget.field2854;
                var3 = 1;
            } else if (opcode == 2611) {
                class81.intStack[++intStackSize - 1] = widget.textColor;
                var3 = 1;
            } else if (opcode == 2612) {
                class81.intStack[++intStackSize - 1] = widget.field2841;
                var3 = 1;
            } else if (opcode == 2613) {
                class81.intStack[++intStackSize - 1] = widget.field2909.rsOrdinal();
                var3 = 1;
            } else {
                var3 = 2;
            }

            return var3;
        } else if (opcode < 2800) {
            if (opcode == 2700) {
                widget = class44.getWidget(class81.intStack[--intStackSize]);
                class81.intStack[++intStackSize - 1] = widget.itemId;
                var3 = 1;
            } else if (opcode == 2701) {
                widget = class44.getWidget(class81.intStack[--intStackSize]);
                if (widget.itemId != -1) {
                    class81.intStack[++intStackSize - 1] = widget.itemQuantity;
                } else {
                    class81.intStack[++intStackSize - 1] = 0;
                }

                var3 = 1;
            } else if (opcode == 2702) {
                var4 = class81.intStack[--intStackSize];
                final WidgetNode var42 = (WidgetNode) Client.componentTable.get(var4);
                if (var42 != null) {
                    class81.intStack[++intStackSize - 1] = 1;
                } else {
                    class81.intStack[++intStackSize - 1] = 0;
                }

                var3 = 1;
            } else if (opcode == 2706) {
                class81.intStack[++intStackSize - 1] = Client.widgetRoot;
                var3 = 1;
            } else {
                var3 = 2;
            }

            return var3;
        } else if (opcode < 2900) {
            widget = class44.getWidget(class81.intStack[--intStackSize]);
            if (opcode == 2800) {
                class81.intStack[++intStackSize - 1] = class250.method4502(GroundObject.getWidgetClickMask(widget));
                var3 = 1;
            } else if (opcode == 2801) {
                var5 = class81.intStack[--intStackSize];
                --var5;
                if (widget.actions != null && var5 < widget.actions.length && widget.actions[var5] != null) {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = widget.actions[var5];
                } else {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                }

                var3 = 1;
            } else if (opcode == 2802) {
                if (widget.opBase == null) {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                } else {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = widget.opBase;
                }

                var3 = 1;
            } else {
                var3 = 2;
            }

            return var3;
        } else if (opcode < 3000) {
            return processOpcode1900To1999(opcode, var2);
        } else if (opcode < 3200) {
            return processOpcode3000To3199(opcode, var2);
        } else if (opcode < 3300) {
            return processOpcode3200To3299(opcode);
        } else {
            int var10;
            int var16;
            final int[] var33;
            int var49;
            if (opcode < 3400) {
                if (opcode == 3300) {
                    class81.intStack[++intStackSize - 1] = Client.gameCycle;
                    var3 = 1;
                } else if (opcode == 3301) {
                    intStackSize -= 2;
                    var4 = class81.intStack[intStackSize];
                    var5 = class81.intStack[intStackSize + 1];
                    class81.intStack[++intStackSize - 1] = class61.method1072(var4, var5);
                    var3 = 1;
                } else if (opcode == 3302) {
                    intStackSize -= 2;
                    var4 = class81.intStack[intStackSize];
                    var5 = class81.intStack[intStackSize + 1];
                    class81.intStack[++intStackSize - 1] = BoundingBox.method41(var4, var5);
                    var3 = 1;
                } else {
                    int var11;
                    final int[] var46;
                    final ItemContainer var48;
                    if (opcode == 3303) {
                        intStackSize -= 2;
                        var4 = class81.intStack[intStackSize];
                        var5 = class81.intStack[intStackSize + 1];
                        var46 = class81.intStack;
                        var16 = ++intStackSize - 1;
                        var48 = (ItemContainer) ItemContainer.itemContainers.get(var4);
                        if (var48 == null) {
                            var49 = 0;
                        } else if (var5 == -1) {
                            var49 = 0;
                        } else {
                            var10 = 0;

                            for (var11 = 0; var11 < var48.stackSizes.length; ++var11) {
                                if (var5 == var48.itemIds[var11]) {
                                    var10 += var48.stackSizes[var11];
                                }
                            }

                            var49 = var10;
                        }

                        var46[var16] = var49;
                        var3 = 1;
                    } else if (opcode == 3304) {
                        var4 = class81.intStack[--intStackSize];
                        var33 = class81.intStack;
                        var6 = ++intStackSize - 1;
                        InvType var27 = (InvType) InvType.inventoryCache.get(var4);
                        final InvType var26;
                        if (var27 == null) {
                            final byte[] var50 = InvType.field3449.getConfigData(5, var4);
                            var27 = new InvType();
                            if (var50 != null) {
                                var27.decode(new Buffer(var50));
                            }

                            InvType.inventoryCache.put(var27, var4);
                        }
                        var26 = var27;

                        var33[var6] = var26.size;
                        var3 = 1;
                    } else if (opcode == 3305) {
                        var4 = class81.intStack[--intStackSize];
                        class81.intStack[++intStackSize - 1] = Client.boostedSkillLevels[var4];
                        var3 = 1;
                    } else if (opcode == 3306) {
                        var4 = class81.intStack[--intStackSize];
                        class81.intStack[++intStackSize - 1] = Client.realSkillLevels[var4];
                        var3 = 1;
                    } else if (opcode == 3307) {
                        var4 = class81.intStack[--intStackSize];
                        class81.intStack[++intStackSize - 1] = Client.skillExperiences[var4];
                        var3 = 1;
                    } else if (opcode == 3308) {
                        var4 = BoundingBox3DDrawMode.plane;
                        var5 = (Client.localPlayer.x >> 7) + class138.baseX;
                        var6 = (Client.localPlayer.y >> 7) + class23.baseY;
                        class81.intStack[++intStackSize - 1] = (var5 << 14) + var6 + (var4 << 28);
                        var3 = 1;
                    } else if (opcode == 3309) {
                        var4 = class81.intStack[--intStackSize];
                        class81.intStack[++intStackSize - 1] = var4 >> 14 & 16383;
                        var3 = 1;
                    } else if (opcode == 3310) {
                        var4 = class81.intStack[--intStackSize];
                        class81.intStack[++intStackSize - 1] = var4 >> 28;
                        var3 = 1;
                    } else if (opcode == 3311) {
                        var4 = class81.intStack[--intStackSize];
                        class81.intStack[++intStackSize - 1] = var4 & 16383;
                        var3 = 1;
                    } else if (opcode == 3312) {
                        class81.intStack[++intStackSize - 1] = Client.isMembers ? 1 : 0;
                        var3 = 1;
                    } else if (opcode == 3313) {
                        intStackSize -= 2;
                        var4 = class81.intStack[intStackSize] + 32768;
                        var5 = class81.intStack[intStackSize + 1];
                        class81.intStack[++intStackSize - 1] = class61.method1072(var4, var5);
                        var3 = 1;
                    } else if (opcode == 3314) {
                        intStackSize -= 2;
                        var4 = class81.intStack[intStackSize] + 32768;
                        var5 = class81.intStack[intStackSize + 1];
                        class81.intStack[++intStackSize - 1] = BoundingBox.method41(var4, var5);
                        var3 = 1;
                    } else if (opcode == 3315) {
                        intStackSize -= 2;
                        var4 = class81.intStack[intStackSize] + 32768;
                        var5 = class81.intStack[intStackSize + 1];
                        var46 = class81.intStack;
                        var16 = ++intStackSize - 1;
                        var48 = (ItemContainer) ItemContainer.itemContainers.get(var4);
                        if (var48 == null) {
                            var49 = 0;
                        } else if (var5 == -1) {
                            var49 = 0;
                        } else {
                            var10 = 0;

                            for (var11 = 0; var11 < var48.stackSizes.length; ++var11) {
                                if (var5 == var48.itemIds[var11]) {
                                    var10 += var48.stackSizes[var11];
                                }
                            }

                            var49 = var10;
                        }

                        var46[var16] = var49;
                        var3 = 1;
                    } else if (opcode == 3316) {
                        if (Client.rights >= 2) {
                            class81.intStack[++intStackSize - 1] = Client.rights;
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3317) {
                        class81.intStack[++intStackSize - 1] = Client.field888;
                        var3 = 1;
                    } else if (opcode == 3318) {
                        class81.intStack[++intStackSize - 1] = Client.world;
                        var3 = 1;
                    } else if (opcode == 3321) {
                        class81.intStack[++intStackSize - 1] = Client.energy;
                        var3 = 1;
                    } else if (opcode == 3322) {
                        class81.intStack[++intStackSize - 1] = Client.weight;
                        var3 = 1;
                    } else if (opcode == 3323) {
                        if (Client.field1020) {
                            class81.intStack[++intStackSize - 1] = 1;
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3324) {
                        class81.intStack[++intStackSize - 1] = Client.flags;
                        var3 = 1;
                    } else if (opcode == 3325) {
                        intStackSize -= 4;
                        var4 = class81.intStack[intStackSize];
                        var5 = class81.intStack[intStackSize + 1];
                        var6 = class81.intStack[intStackSize + 2];
                        var16 = class81.intStack[intStackSize + 3];
                        var4 += var5 << 14;
                        var4 += var6 << 28;
                        var4 += var16;
                        class81.intStack[++intStackSize - 1] = var4;
                        var3 = 1;
                    } else {
                        var3 = 2;
                    }
                }

                return var3;
            } else if (opcode < 3500) {
                Enum var41;
                if (opcode == 3400) {
                    intStackSize -= 2;
                    var4 = class81.intStack[intStackSize];
                    var5 = class81.intStack[intStackSize + 1];
                    Enum var20 = (Enum) Enum.EnumDefinition_cached.get(var4);
                    if (var20 == null) {
                        final byte[] var22 = Enum.EnumDefinition_indexCache.getConfigData(8, var4);
                        var20 = new Enum();
                        if (var22 != null) {
                            var20.decode(new Buffer(var22));
                        }

                        Enum.EnumDefinition_cached.put(var20, var4);
                    }
                    var41 = var20;

                    var20 = var41;
                    if (var41.valType != 's') {
                    }

                    for (var49 = 0; var49 < var20.size; ++var49) {
                        if (var5 == var20.keys[var49]) {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var20.stringVals[var49];
                            var20 = null;
                            break;
                        }
                    }

                    if (var20 != null) {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var20.defaultString;
                    }

                    var3 = 1;
                } else if (opcode == 3408) {
                    intStackSize -= 4;
                    var4 = class81.intStack[intStackSize];
                    var5 = class81.intStack[intStackSize + 1];
                    var6 = class81.intStack[intStackSize + 2];
                    var16 = class81.intStack[intStackSize + 3];
                    Enum var45 = (Enum) Enum.EnumDefinition_cached.get(var6);
                    final Enum var24;
                    if (var45 == null) {
                        final byte[] var18 = Enum.EnumDefinition_indexCache.getConfigData(8, var6);
                        var45 = new Enum();
                        if (var18 != null) {
                            var45.decode(new Buffer(var18));
                        }

                        Enum.EnumDefinition_cached.put(var45, var6);
                    }
                    var24 = var45;

                    var45 = var24;
                    if (var4 == var24.keyType && var5 == var24.valType) {
                        for (var10 = 0; var10 < var45.size; ++var10) {
                            if (var16 == var45.keys[var10]) {
                                if (var5 == 115) {
                                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var45.stringVals[var10];
                                } else {
                                    class81.intStack[++intStackSize - 1] = var45.intVals[var10];
                                }

                                var45 = null;
                                break;
                            }
                        }

                        if (var45 != null) {
                            if (var5 == 115) {
                                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var45.defaultString;
                            } else {
                                class81.intStack[++intStackSize - 1] = var45.defaultInt;
                            }
                        }

                    } else {
                        if (var5 == 115) {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "null";
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                    }
                    var3 = 1;
                } else if (opcode == 3411) {
                    var4 = class81.intStack[--intStackSize];
                    var41 = (Enum) Enum.EnumDefinition_cached.get(var4);
                    final Enum var40;
                    if (var41 == null) {
                        final byte[] var25 = Enum.EnumDefinition_indexCache.getConfigData(8, var4);
                        var41 = new Enum();
                        if (var25 != null) {
                            var41.decode(new Buffer(var25));
                        }

                        Enum.EnumDefinition_cached.put(var41, var4);
                    }
                    var40 = var41;

                    class81.intStack[++intStackSize - 1] = var40.method4957();
                    var3 = 1;
                } else {
                    var3 = 2;
                }

                return var3;
            } else {
                String var31;
                final PacketNode var35;
                if (opcode < 3700) {
                    if (opcode == 3600) {
                        if (WorldMapRectangle.friendManager.field1253 == 0) {
                            class81.intStack[++intStackSize - 1] = -2;
                        } else if (WorldMapRectangle.friendManager.field1253 == 1) {
                            class81.intStack[++intStackSize - 1] = -1;
                        } else {
                            class81.intStack[++intStackSize - 1] = WorldMapRectangle.friendManager.field1256.getCount();
                        }

                        var3 = 1;
                    } else if (opcode == 3601) {
                        var4 = class81.intStack[--intStackSize];
                        if (WorldMapRectangle.friendManager.method1732() && var4 >= 0 && var4 < WorldMapRectangle.friendManager.field1256.getCount()) {
                            final Friend var34 = (Friend) WorldMapRectangle.friendManager.field1256.get(var4);
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var34.getCurrentNameString();
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var34.getPreviousNameString();
                        } else {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                    } else if (opcode == 3602) {
                        var4 = class81.intStack[--intStackSize];
                        if (WorldMapRectangle.friendManager.method1732() && var4 >= 0 && var4 < WorldMapRectangle.friendManager.field1256.getCount()) {
                            class81.intStack[++intStackSize - 1] = ((ChatPlayer) WorldMapRectangle.friendManager.field1256.get(var4)).world;
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3603) {
                        var4 = class81.intStack[--intStackSize];
                        if (WorldMapRectangle.friendManager.method1732() && var4 >= 0 && var4 < WorldMapRectangle.friendManager.field1256.getCount()) {
                            class81.intStack[++intStackSize - 1] = ((ChatPlayer) WorldMapRectangle.friendManager.field1256.get(var4)).rank;
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3604) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        var5 = class81.intStack[--intStackSize];
                        var35 = WorldMapRectangle.method280(ClientPacket.field2462, Client.field957.field1484);
                        var35.packetBuffer.putByte(WorldMapRegion.getLength(var31) + 1);
                        var35.packetBuffer.method3541(var5);
                        var35.packetBuffer.putString(var31);
                        Client.field957.method2052(var35);
                        var3 = 1;
                    } else if (opcode == 3605) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        WorldMapRectangle.friendManager.addToFriendsList(var31);
                        var3 = 1;
                    } else if (opcode == 3606) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        WorldMapRectangle.friendManager.method1742(var31);
                        var3 = 1;
                    } else if (opcode == 3607) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        WorldMapRectangle.friendManager.addToIgnoreList(var31);
                        var3 = 1;
                    } else if (opcode == 3608) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        WorldMapRectangle.friendManager.method1743(var31);
                        var3 = 1;
                    } else if (opcode == 3609) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        var31 = FontName.method5489(var31);
                        class81.intStack[++intStackSize - 1] = WorldMapRectangle.friendManager.isFriended(new Name(var31, GZipDecompressor.loginType), false) ? 1 : 0;
                        var3 = 1;
                    } else if (opcode == 3611) {
                        if (GameEngine.clanMemberManager != null) {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = GameEngine.clanMemberManager.field3870;
                        } else {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                    } else if (opcode == 3612) {
                        if (GameEngine.clanMemberManager != null) {
                            class81.intStack[++intStackSize - 1] = GameEngine.clanMemberManager.getCount();
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3613) {
                        var4 = class81.intStack[--intStackSize];
                        if (GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount()) {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = GameEngine.clanMemberManager.get(var4).getCurrentName().getName();
                        } else {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                    } else if (opcode == 3614) {
                        var4 = class81.intStack[--intStackSize];
                        if (GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount()) {
                            class81.intStack[++intStackSize - 1] = ((ChatPlayer) GameEngine.clanMemberManager.get(var4)).method5390();
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3615) {
                        var4 = class81.intStack[--intStackSize];
                        if (GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount()) {
                            class81.intStack[++intStackSize - 1] = ((ChatPlayer) GameEngine.clanMemberManager.get(var4)).rank;
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3616) {
                        class81.intStack[++intStackSize - 1] = GameEngine.clanMemberManager != null ? GameEngine.clanMemberManager.field3865 : 0;
                        var3 = 1;
                    } else if (opcode == 3617) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        GrandExchangeEvent.method80(var31);
                        var3 = 1;
                    } else if (opcode == 3618) {
                        class81.intStack[++intStackSize - 1] = GameEngine.clanMemberManager != null ? GameEngine.clanMemberManager.field3871 : 0;
                        var3 = 1;
                    } else if (opcode == 3619) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        if (!var31.isEmpty()) {
                            final PacketNode var37 = WorldMapRectangle.method280(ClientPacket.field2398, Client.field957.field1484);
                            var37.packetBuffer.putByte(WorldMapRegion.getLength(var31));
                            var37.packetBuffer.putString(var31);
                            Client.field957.method2052(var37);
                        }

                        var3 = 1;
                    } else if (opcode == 3620) {
                        GroundObject.method2671();
                        var3 = 1;
                    } else if (opcode == 3621) {
                        if (!WorldMapRectangle.friendManager.method1732()) {
                            class81.intStack[++intStackSize - 1] = -1;
                        } else {
                            class81.intStack[++intStackSize - 1] = WorldMapRectangle.friendManager.field1254.getCount();
                        }

                        var3 = 1;
                    } else if (opcode == 3622) {
                        var4 = class81.intStack[--intStackSize];
                        if (WorldMapRectangle.friendManager.method1732() && var4 >= 0 && var4 < WorldMapRectangle.friendManager.field1254.getCount()) {
                            final Ignore var39 = (Ignore) WorldMapRectangle.friendManager.field1254.get(var4);
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var39.getCurrentNameString();
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var39.getPreviousNameString();
                        } else {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                    } else if (opcode == 3623) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        var31 = FontName.method5489(var31);
                        class81.intStack[++intStackSize - 1] = WorldMapRectangle.friendManager.isIgnored(new Name(var31, GZipDecompressor.loginType)) ? 1 : 0;
                        var3 = 1;
                    } else if (opcode == 3624) {
                        var4 = class81.intStack[--intStackSize];
                        if (GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount() && GameEngine.clanMemberManager.get(var4).getCurrentName().equals(Client.localPlayer.name)) {
                            class81.intStack[++intStackSize - 1] = 1;
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3625) {
                        if (GameEngine.clanMemberManager != null && GameEngine.clanMemberManager.field3869 != null) {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = GameEngine.clanMemberManager.field3869;
                        } else {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                    } else if (opcode == 3626) {
                        var4 = class81.intStack[--intStackSize];
                        if (GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount() && ((ClanMember) GameEngine.clanMemberManager.get(var4)).method5242()) {
                            class81.intStack[++intStackSize - 1] = 1;
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3627) {
                        var4 = class81.intStack[--intStackSize];
                        if (GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount() && ((ClanMember) GameEngine.clanMemberManager.get(var4)).method5260()) {
                            class81.intStack[++intStackSize - 1] = 1;
                        } else {
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 3628) {
                        WorldMapRectangle.friendManager.field1256.method5323();
                        var3 = 1;
                    } else {
                        final boolean var23;
                        if (opcode == 3629) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class321(var23));
                            var3 = 1;
                        } else if (opcode == 3630) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class322(var23));
                            var3 = 1;
                        } else if (opcode == 3631) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class155(var23));
                            var3 = 1;
                        } else if (opcode == 3632) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class149(var23));
                            var3 = 1;
                        } else if (opcode == 3633) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class154(var23));
                            var3 = 1;
                        } else if (opcode == 3634) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class157(var23));
                            var3 = 1;
                        } else if (opcode == 3635) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class153(var23));
                            var3 = 1;
                        } else if (opcode == 3636) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class151(var23));
                            var3 = 1;
                        } else if (opcode == 3637) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class150(var23));
                            var3 = 1;
                        } else if (opcode == 3638) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class152(var23));
                            var3 = 1;
                        } else if (opcode == 3639) {
                            WorldMapRectangle.friendManager.field1256.method5331();
                            var3 = 1;
                        } else if (opcode == 3640) {
                            WorldMapRectangle.friendManager.field1254.method5323();
                            var3 = 1;
                        } else if (opcode == 3641) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1254.method5324(new class321(var23));
                            var3 = 1;
                        } else if (opcode == 3642) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1254.method5324(new class322(var23));
                            var3 = 1;
                        } else if (opcode == 3643) {
                            WorldMapRectangle.friendManager.field1254.method5331();
                            var3 = 1;
                        } else if (opcode == 3644) {
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5323();
                            }

                            var3 = 1;
                        } else if (opcode == 3645) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class321(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3646) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class322(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3647) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class155(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3648) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class149(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3649) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class154(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3650) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class157(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3651) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class153(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3652) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class151(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3653) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class150(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3654) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class152(var23));
                            }

                            var3 = 1;
                        } else if (opcode == 3655) {
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5331();
                            }

                            var3 = 1;
                        } else if (opcode == 3656) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            WorldMapRectangle.friendManager.field1256.method5324(new class156(var23));
                            var3 = 1;
                        } else if (opcode == 3657) {
                            var23 = class81.intStack[--intStackSize] == 1;
                            if (GameEngine.clanMemberManager != null) {
                                GameEngine.clanMemberManager.method5324(new class156(var23));
                            }

                            var3 = 1;
                        } else {
                            var3 = 2;
                        }
                    }

                    return var3;
                } else if (opcode < 4000) {
                    return processOpcode3700To3999(opcode);
                } else if (opcode < 4100) {
                    return processOpcode4000To4099(opcode);
                } else if (opcode < 4200) {
                    return processOpcode4100To4199(opcode);
                } else if (opcode < 4300) {
                    return processOpcode4200To4299(opcode);
                } else if (opcode >= 5100) {
                    if (opcode < 5400) {
                        return processOpcode5100To5399(opcode);
                    } else if (opcode < 5600) {
                        return processOpcode5400To5599(opcode);
                    } else if (opcode < 5700) {
                        return processOpcode5600To5699(opcode);
                    } else if (opcode < 6300) {
                        if (opcode == 6200) {
                            intStackSize -= 2;
                            Client.field1120 = (short) class81.intStack[intStackSize];
                            if (Client.field1120 <= 0) {
                                Client.field1120 = 256;
                            }

                            Client.field1118 = (short) class81.intStack[intStackSize + 1];
                            if (Client.field1118 <= 0) {
                                Client.field1118 = 205;
                            }

                            var3 = 1;
                        } else if (opcode == 6201) {
                            intStackSize -= 2;
                            Client.field1018 = (short) class81.intStack[intStackSize];
                            if (Client.field1018 <= 0) {
                                Client.field1018 = 256;
                            }

                            Client.field1104 = (short) class81.intStack[intStackSize + 1];
                            if (Client.field1104 <= 0) {
                                Client.field1104 = 320;
                            }

                            var3 = 1;
                        } else if (opcode == 6202) {
                            intStackSize -= 4;
                            Client.field1121 = (short) class81.intStack[intStackSize];
                            if (Client.field1121 <= 0) {
                                Client.field1121 = 1;
                            }

                            Client.field1122 = (short) class81.intStack[intStackSize + 1];
                            if (Client.field1122 <= 0) {
                                Client.field1122 = 32767;
                            } else if (Client.field1122 < Client.field1121) {
                                Client.field1122 = Client.field1121;
                            }

                            Client.field1123 = (short) class81.intStack[intStackSize + 2];
                            if (Client.field1123 <= 0) {
                                Client.field1123 = 1;
                            }

                            Client.field911 = (short) class81.intStack[intStackSize + 3];
                            if (Client.field911 <= 0) {
                                Client.field911 = 32767;
                            } else if (Client.field911 < Client.field1123) {
                                Client.field911 = Client.field1123;
                            }

                            var3 = 1;
                        } else if (opcode == 6203) {
                            if (Client.field1039 != null) {
                                WorldMapRegion.method535(0, 0, Client.field1039.width, Client.field1039.height, false);
                                class81.intStack[++intStackSize - 1] = Client.viewportWidth;
                                class81.intStack[++intStackSize - 1] = Client.viewportHeight;
                            } else {
                                class81.intStack[++intStackSize - 1] = -1;
                                class81.intStack[++intStackSize - 1] = -1;
                            }

                            var3 = 1;
                        } else if (opcode == 6204) {
                            class81.intStack[++intStackSize - 1] = Client.field1018;
                            class81.intStack[++intStackSize - 1] = Client.field1104;
                            var3 = 1;
                        } else if (opcode == 6205) {
                            class81.intStack[++intStackSize - 1] = Client.field1120;
                            class81.intStack[++intStackSize - 1] = Client.field1118;
                            var3 = 1;
                        } else {
                            var3 = 2;
                        }

                        return var3;
                    } else {//6300
                        if (opcode < 6600) {
                            return processOpcode6300To6599(opcode);
                        } else if (opcode < 6700) {
                            return processOpcode6600To6699(opcode);
                        } else {
                            return 2;
                        }
                    }
                } else {
                    if (opcode == 5000) {
                        class81.intStack[++intStackSize - 1] = Client.publicChatMode;
                        var3 = 1;
                    } else if (opcode == 5001) {
                        intStackSize -= 3;
                        Client.publicChatMode = class81.intStack[intStackSize];
                        var5 = class81.intStack[intStackSize + 1];
                        final class320[] var14 = class320.method5386();
                        var16 = 0;

                        final class320 var12;
                        while (true) {
                            if (var16 >= var14.length) {
                                var12 = null;
                                break;
                            }

                            final class320 var8 = var14[var16];
                            if (var5 == var8.id) {
                                var12 = var8;
                                break;
                            }

                            ++var16;
                        }

                        class46.field579 = var12;
                        if (class46.field579 == null) {
                            class46.field579 = class320.field3933;
                        }

                        Client.field1084 = class81.intStack[intStackSize + 2];
                        var35 = WorldMapRectangle.method280(ClientPacket.field2386, Client.field957.field1484);
                        var35.packetBuffer.putByte(Client.publicChatMode);
                        var35.packetBuffer.putByte(class46.field579.id);
                        var35.packetBuffer.putByte(Client.field1084);
                        Client.field957.method2052(var35);
                        var3 = 1;
                    } else if (opcode == 5002) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        intStackSize -= 2;
                        var5 = class81.intStack[intStackSize];
                        var6 = class81.intStack[intStackSize + 1];
                        final PacketNode var7 = WorldMapRectangle.method280(ClientPacket.field2459, Client.field957.field1484);
                        var7.packetBuffer.putByte(WorldMapRegion.getLength(var31) + 2);
                        var7.packetBuffer.putString(var31);
                        var7.packetBuffer.putByte(var5 - 1);
                        var7.packetBuffer.putByte(var6);
                        Client.field957.method2052(var7);
                        var3 = 1;
                    } else if (opcode == 5003) {
                        intStackSize -= 2;
                        var4 = class81.intStack[intStackSize];
                        var5 = class81.intStack[intStackSize + 1];
                        final ChatLineBuffer var19 = class95.chatLineMap.get(var4);
                        final MessageNode var36 = var19.getMessage(var5);
                        if (var36 != null) {
                            class81.intStack[++intStackSize - 1] = var36.id;
                            class81.intStack[++intStackSize - 1] = var36.tick;
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var36.name != null ? var36.name : "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var36.sender != null ? var36.sender : "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var36.value != null ? var36.value : "";
                            class81.intStack[++intStackSize - 1] = var36.method1149() ? 1 : (var36.method1152() ? 2 : 0);
                        } else {
                            class81.intStack[++intStackSize - 1] = -1;
                            class81.intStack[++intStackSize - 1] = 0;
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 5004) {
                        var4 = class81.intStack[--intStackSize];
                        final MessageNode var13 = (MessageNode) class95.messages.get(var4);
                        if (var13 != null) {
                            class81.intStack[++intStackSize - 1] = var13.type;
                            class81.intStack[++intStackSize - 1] = var13.tick;
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var13.name != null ? var13.name : "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var13.sender != null ? var13.sender : "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var13.value != null ? var13.value : "";
                            class81.intStack[++intStackSize - 1] = var13.method1149() ? 1 : (var13.method1152() ? 2 : 0);
                        } else {
                            class81.intStack[++intStackSize - 1] = -1;
                            class81.intStack[++intStackSize - 1] = 0;
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                            class81.intStack[++intStackSize - 1] = 0;
                        }

                        var3 = 1;
                    } else if (opcode == 5005) {
                        if (class46.field579 == null) {
                            class81.intStack[++intStackSize - 1] = -1;
                        } else {
                            class81.intStack[++intStackSize - 1] = class46.field579.id;
                        }

                        var3 = 1;
                    } else if (opcode == 5008) {
                        var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        var5 = class81.intStack[--intStackSize];
                        String var38 = var31.toLowerCase();
                        byte var43 = 0;
                        if (var38.startsWith("yellow:")) {
                            var43 = 0;
                            var31 = var31.substring("yellow:".length());
                        } else if (var38.startsWith("red:")) {
                            var43 = 1;
                            var31 = var31.substring("red:".length());
                        } else if (var38.startsWith("green:")) {
                            var43 = 2;
                            var31 = var31.substring("green:".length());
                        } else if (var38.startsWith("cyan:")) {
                            var43 = 3;
                            var31 = var31.substring("cyan:".length());
                        } else if (var38.startsWith("purple:")) {
                            var43 = 4;
                            var31 = var31.substring("purple:".length());
                        } else if (var38.startsWith("white:")) {
                            var43 = 5;
                            var31 = var31.substring("white:".length());
                        } else if (var38.startsWith("flash1:")) {
                            var43 = 6;
                            var31 = var31.substring("flash1:".length());
                        } else if (var38.startsWith("flash2:")) {
                            var43 = 7;
                            var31 = var31.substring("flash2:".length());
                        } else if (var38.startsWith("flash3:")) {
                            var43 = 8;
                            var31 = var31.substring("flash3:".length());
                        } else if (var38.startsWith("glow1:")) {
                            var43 = 9;
                            var31 = var31.substring("glow1:".length());
                        } else if (var38.startsWith("glow2:")) {
                            var43 = 10;
                            var31 = var31.substring("glow2:".length());
                        } else if (var38.startsWith("glow3:")) {
                            var43 = 11;
                            var31 = var31.substring("glow3:".length());
                        } else if (Client.languageId != 0) {
                            if (var38.startsWith("yellow:")) {
                                var43 = 0;
                                var31 = var31.substring("yellow:".length());
                            } else if (var38.startsWith("red:")) {
                                var43 = 1;
                                var31 = var31.substring("red:".length());
                            } else if (var38.startsWith("green:")) {
                                var43 = 2;
                                var31 = var31.substring("green:".length());
                            } else if (var38.startsWith("cyan:")) {
                                var43 = 3;
                                var31 = var31.substring("cyan:".length());
                            } else if (var38.startsWith("purple:")) {
                                var43 = 4;
                                var31 = var31.substring("purple:".length());
                            } else if (var38.startsWith("white:")) {
                                var43 = 5;
                                var31 = var31.substring("white:".length());
                            } else if (var38.startsWith("flash1:")) {
                                var43 = 6;
                                var31 = var31.substring("flash1:".length());
                            } else if (var38.startsWith("flash2:")) {
                                var43 = 7;
                                var31 = var31.substring("flash2:".length());
                            } else if (var38.startsWith("flash3:")) {
                                var43 = 8;
                                var31 = var31.substring("flash3:".length());
                            } else if (var38.startsWith("glow1:")) {
                                var43 = 9;
                                var31 = var31.substring("glow1:".length());
                            } else if (var38.startsWith("glow2:")) {
                                var43 = 10;
                                var31 = var31.substring("glow2:".length());
                            } else if (var38.startsWith("glow3:")) {
                                var43 = 11;
                                var31 = var31.substring("glow3:".length());
                            }
                        }

                        var38 = var31.toLowerCase();
                        byte var15 = 0;
                        if (var38.startsWith("wave:")) {
                            var15 = 1;
                            var31 = var31.substring("wave:".length());
                        } else if (var38.startsWith("wave2:")) {
                            var15 = 2;
                            var31 = var31.substring("wave2:".length());
                        } else if (var38.startsWith("shake:")) {
                            var15 = 3;
                            var31 = var31.substring("shake:".length());
                        } else if (var38.startsWith("scroll:")) {
                            var15 = 4;
                            var31 = var31.substring("scroll:".length());
                        } else if (var38.startsWith("slide:")) {
                            var15 = 5;
                            var31 = var31.substring("slide:".length());
                        } else if (Client.languageId != 0) {
                            if (var38.startsWith("wave:")) {
                                var15 = 1;
                                var31 = var31.substring("wave:".length());
                            } else if (var38.startsWith("wave2:")) {
                                var15 = 2;
                                var31 = var31.substring("wave2:".length());
                            } else if (var38.startsWith("shake:")) {
                                var15 = 3;
                                var31 = var31.substring("shake:".length());
                            } else if (var38.startsWith("scroll:")) {
                                var15 = 4;
                                var31 = var31.substring("scroll:".length());
                            } else if (var38.startsWith("slide:")) {
                                var15 = 5;
                                var31 = var31.substring("slide:".length());
                            }
                        }

                        final PacketNode var17 = WorldMapRectangle.method280(ClientPacket.PUBLIC_CHAT_MESSAGE, Client.field957.field1484);
                        var17.packetBuffer.putByte(0);
                        var10 = var17.packetBuffer.offset;
                        var17.packetBuffer.putByte(var5);
                        var17.packetBuffer.putByte(var43);
                        var17.packetBuffer.putByte(var15);
                        method5280(var17.packetBuffer, var31);
                        var17.packetBuffer.method3514(var17.packetBuffer.offset - var10);
                        Client.field957.method2052(var17);
                        var3 = 1;
                    } else if (opcode == 5009) {
                        KeyFocusListener.scriptStringStackSize -= 2;
                        var31 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                        final String var32 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                        var35 = WorldMapRectangle.method280(ClientPacket.field2390, Client.field957.field1484);
                        var35.packetBuffer.putShort(0);
                        var16 = var35.packetBuffer.offset;
                        var35.packetBuffer.putString(var31);
                        method5280(var35.packetBuffer, var32);
                        var35.packetBuffer.method3513(var35.packetBuffer.offset - var16);
                        Client.field957.method2052(var35);
                        var3 = 1;
                    } else if (opcode == 5015) {
                        if (Client.localPlayer != null && Client.localPlayer.name != null) {
                            var31 = Client.localPlayer.name.getName();
                        } else {
                            var31 = "";
                        }

                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var31;
                        var3 = 1;
                    } else if (opcode == 5016) {
                        class81.intStack[++intStackSize - 1] = Client.field1084;
                        var3 = 1;
                    } else if (opcode == 5017) {
                        var4 = class81.intStack[--intStackSize];
                        class81.intStack[++intStackSize - 1] = ScriptVarType.method10(var4);
                        var3 = 1;
                    } else {
                        final MessageNode var21;
                        if (opcode == 5018) {
                            var4 = class81.intStack[--intStackSize];
                            var33 = class81.intStack;
                            var6 = ++intStackSize - 1;
                            var21 = (MessageNode) class95.messages.get(var4);
                            if (var21 == null) {
                                var16 = -1;
                            } else if (var21.previous == class95.field1453.sentinel) {
                                var16 = -1;
                            } else {
                                var16 = ((MessageNode) var21.previous).id;
                            }

                            var33[var6] = var16;
                            var3 = 1;
                        } else if (opcode == 5019) {
                            var4 = class81.intStack[--intStackSize];
                            var33 = class81.intStack;
                            var6 = ++intStackSize - 1;
                            var21 = (MessageNode) class95.messages.get(var4);
                            if (var21 == null) {
                                var16 = -1;
                            } else if (var21.next == class95.field1453.sentinel) {
                                var16 = -1;
                            } else {
                                var16 = ((MessageNode) var21.next).id;
                            }

                            var33[var6] = var16;
                            var3 = 1;
                        } else if (opcode == 5020) {
                            var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                            Player.method1231(var31);
                            var3 = 1;
                        } else if (opcode == 5021) {
                            Client.field1085 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize].toLowerCase().trim();
                            var3 = 1;
                        } else if (opcode == 5022) {
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.field1085;
                            var3 = 1;
                        } else {
                            var3 = 2;
                        }
                    }

                    return var3;
                }
            }
        }
    }

    private static int method5280(final Buffer buffer, final String var1) {
        final int var2 = buffer.offset;
        final int var4 = var1.length();
        final byte[] var5 = new byte[var4];

        for (int var6 = 0; var6 < var4; ++var6) {
            final char var7 = var1.charAt(var6);
            if (var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
                var5[var6] = (byte) var7;
            } else if (var7 == 8364) {
                var5[var6] = -128;
            } else if (var7 == 8218) {
                var5[var6] = -126;
            } else if (var7 == 402) {
                var5[var6] = -125;
            } else if (var7 == 8222) {
                var5[var6] = -124;
            } else if (var7 == 8230) {
                var5[var6] = -123;
            } else if (var7 == 8224) {
                var5[var6] = -122;
            } else if (var7 == 8225) {
                var5[var6] = -121;
            } else if (var7 == 710) {
                var5[var6] = -120;
            } else if (var7 == 8240) {
                var5[var6] = -119;
            } else if (var7 == 352) {
                var5[var6] = -118;
            } else if (var7 == 8249) {
                var5[var6] = -117;
            } else if (var7 == 338) {
                var5[var6] = -116;
            } else if (var7 == 381) {
                var5[var6] = -114;
            } else if (var7 == 8216) {
                var5[var6] = -111;
            } else if (var7 == 8217) {
                var5[var6] = -110;
            } else if (var7 == 8220) {
                var5[var6] = -109;
            } else if (var7 == 8221) {
                var5[var6] = -108;
            } else if (var7 == 8226) {
                var5[var6] = -107;
            } else if (var7 == 8211) {
                var5[var6] = -106;
            } else if (var7 == 8212) {
                var5[var6] = -105;
            } else if (var7 == 732) {
                var5[var6] = -104;
            } else if (var7 == 8482) {
                var5[var6] = -103;
            } else if (var7 == 353) {
                var5[var6] = -102;
            } else if (var7 == 8250) {
                var5[var6] = -101;
            } else if (var7 == 339) {
                var5[var6] = -100;
            } else if (var7 == 382) {
                var5[var6] = -98;
            } else if (var7 == 376) {
                var5[var6] = -97;
            } else {
                var5[var6] = 63;
            }
        }

        buffer.putShortSmart(var5.length);
        buffer.offset += class313.huffman.compress(var5, 0, var5.length, buffer.payload, buffer.offset);
        return buffer.offset - var2;
    }

    private static int processOpcode4000To4099(final int opcode) {
        final int var3;
        final int var4;
        if (opcode == 4000) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var4 + var3;
            return 1;
        } else if (opcode == 4001) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var3 - var4;
            return 1;
        } else if (opcode == 4002) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var3 * var4;
            return 1;
        } else if (opcode == 4003) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var3 / var4;
            return 1;
        } else if (opcode == 4004) {
            var3 = class81.intStack[--intStackSize];
            class81.intStack[++intStackSize - 1] = (int) (Math.random() * var3);
            return 1;
        } else if (opcode == 4005) {
            var3 = class81.intStack[--intStackSize];
            class81.intStack[++intStackSize - 1] = (int) (Math.random() * (var3 + 1));
            return 1;
        } else if (opcode == 4006) {
            intStackSize -= 5;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            final int var5 = class81.intStack[intStackSize + 2];
            final int var6 = class81.intStack[intStackSize + 3];
            final int var7 = class81.intStack[intStackSize + 4];
            class81.intStack[++intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
            return 1;
        } else if (opcode == 4007) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var3 + var4 * var3 / 100;
            return 1;
        } else if (opcode == 4008) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var3 | 1 << var4;
            return 1;
        } else if (opcode == 4009) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var3 & -1 - (1 << var4);
            return 1;
        } else if (opcode == 4010) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
            return 1;
        } else if (opcode == 4011) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var3 % var4;
            return 1;
        } else if (opcode == 4012) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            if (var3 == 0) {
                class81.intStack[++intStackSize - 1] = 0;
            } else {
                class81.intStack[++intStackSize - 1] = (int) Math.pow(var3, var4);
            }

            return 1;
        } else if (opcode == 4013) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            if (var3 == 0) {
                class81.intStack[++intStackSize - 1] = 0;
            } else {
                switch (var4) {
                    case 0:
                        class81.intStack[++intStackSize - 1] = Integer.MAX_VALUE;
                        break;
                    case 1:
                        class81.intStack[++intStackSize - 1] = var3;
                        break;
                    case 2:
                        class81.intStack[++intStackSize - 1] = (int) Math.sqrt(var3);
                        break;
                    case 3:
                        class81.intStack[++intStackSize - 1] = (int) Math.cbrt(var3);
                        break;
                    case 4:
                        class81.intStack[++intStackSize - 1] = (int) Math.sqrt(Math.sqrt(var3));
                        break;
                    default:
                        class81.intStack[++intStackSize - 1] = (int) Math.pow(var3, 1.0D / var4);
                }

            }
            return 1;
        } else if (opcode == 4014) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var3 & var4;
            return 1;
        } else if (opcode == 4015) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            class81.intStack[++intStackSize - 1] = var3 | var4;
            return 1;
        } else if (opcode == 4018) {
            intStackSize -= 3;
            final long var9 = class81.intStack[intStackSize];
            final long var11 = class81.intStack[intStackSize + 1];
            final long var13 = class81.intStack[intStackSize + 2];
            class81.intStack[++intStackSize - 1] = (int) (var9 * var13 / var11);
            return 1;
        } else {
            return 2;
        }
    }

    private static int processOpcode4200To4299(final int opcode) {
        final int var3;
        if (opcode == 4200) {
            var3 = class81.intStack[--intStackSize];
            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = ItemComposition.getItemDefinition(var3).name;
            return 1;
        } else {
            final int var4;
            final ItemComposition var5;
            if (opcode == 4201) {
                intStackSize -= 2;
                var3 = class81.intStack[intStackSize];
                var4 = class81.intStack[intStackSize + 1];
                var5 = ItemComposition.getItemDefinition(var3);
                if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var5.groundActions[var4 - 1];
                } else {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                }

                return 1;
            } else if (opcode == 4202) {
                intStackSize -= 2;
                var3 = class81.intStack[intStackSize];
                var4 = class81.intStack[intStackSize + 1];
                var5 = ItemComposition.getItemDefinition(var3);
                if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var5.inventoryActions[var4 - 1];
                } else {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                }

                return 1;
            } else if (opcode == 4203) {
                var3 = class81.intStack[--intStackSize];
                class81.intStack[++intStackSize - 1] = ItemComposition.getItemDefinition(var3).price;
                return 1;
            } else if (opcode == 4204) {
                var3 = class81.intStack[--intStackSize];
                class81.intStack[++intStackSize - 1] = ItemComposition.getItemDefinition(var3).isStackable == 1 ? 1 : 0;
                return 1;
            } else {
                final ItemComposition var6;
                if (opcode == 4205) {
                    var3 = class81.intStack[--intStackSize];
                    var6 = ItemComposition.getItemDefinition(var3);
                    if (var6.notedTemplate == -1 && var6.note >= 0) {
                        class81.intStack[++intStackSize - 1] = var6.note;
                    } else {
                        class81.intStack[++intStackSize - 1] = var3;
                    }

                    return 1;
                } else if (opcode == 4206) {
                    var3 = class81.intStack[--intStackSize];
                    var6 = ItemComposition.getItemDefinition(var3);
                    if (var6.notedTemplate >= 0 && var6.note >= 0) {
                        class81.intStack[++intStackSize - 1] = var6.note;
                    } else {
                        class81.intStack[++intStackSize - 1] = var3;
                    }

                    return 1;
                } else if (opcode == 4207) {
                    var3 = class81.intStack[--intStackSize];
                    class81.intStack[++intStackSize - 1] = ItemComposition.getItemDefinition(var3).isMembers ? 1 : 0;
                    return 1;
                } else if (opcode == 4208) {
                    var3 = class81.intStack[--intStackSize];
                    var6 = ItemComposition.getItemDefinition(var3);
                    if (var6.placeholderTemplateId == -1 && var6.placeholderId >= 0) {
                        class81.intStack[++intStackSize - 1] = var6.placeholderId;
                    } else {
                        class81.intStack[++intStackSize - 1] = var3;
                    }

                    return 1;
                } else if (opcode == 4209) {
                    var3 = class81.intStack[--intStackSize];
                    var6 = ItemComposition.getItemDefinition(var3);
                    if (var6.placeholderTemplateId >= 0 && var6.placeholderId >= 0) {
                        class81.intStack[++intStackSize - 1] = var6.placeholderId;
                    } else {
                        class81.intStack[++intStackSize - 1] = var3;
                    }

                    return 1;
                } else if (opcode == 4210) {
                    final String var7 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                    var4 = class81.intStack[--intStackSize];
                    GrandExchangeEvents.method72(var7, var4 == 1);
                    class81.intStack[++intStackSize - 1] = class61.field737;
                    return 1;
                } else if (opcode != 4211) {
                    if (opcode == 4212) {
                        class81.field1287 = 0;
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    if (Preferences.field1248 != null && class81.field1287 < class61.field737) {
                        class81.intStack[++intStackSize - 1] = Preferences.field1248[++class81.field1287 - 1] & '\uffff';
                    } else {
                        class81.intStack[++intStackSize - 1] = -1;
                    }

                    return 1;
                }
            }
        }
    }

    static int processOpcode3200To3299(final int opcode) {
        final int var3;
        final int var4;
        if (opcode == 3200) {
            intStackSize -= 3;
            var3 = class81.intStack[intStackSize];
            var4 = class81.intStack[intStackSize + 1];
            final int var5 = class81.intStack[intStackSize + 2];
            if (Client.field1075 != 0 && var4 != 0 && Client.queuedSoundEffectCount < 50) {
                Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var3;
                Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var4;
                Client.audioDelays[Client.queuedSoundEffectCount] = var5;
                Client.audioEffects[Client.queuedSoundEffectCount] = null;
                Client.soundLocations[Client.queuedSoundEffectCount] = 0;
                ++Client.queuedSoundEffectCount;
            }

            return 1;
        } else if (opcode != 3201) {
            if (opcode == 3202) {
                intStackSize -= 2;
                var3 = class81.intStack[intStackSize];
                var4 = class81.intStack[intStackSize + 1];
                if (Client.field996 != 0 && var3 != -1) {
                    PacketNode.method3442(class189.indexTrack2, var3, 0, Client.field996, false);
                    Client.field1102 = true;
                }

                return 1;
            } else {
                return 2;
            }
        } else {
            var3 = class81.intStack[--intStackSize];
            if (var3 == -1 && !Client.field1102) {
                Client.method3165();
            } else if (var3 != -1 && var3 != Client.field1026 && Client.field996 != 0 && !Client.field1102) {
                class163.method3213(2, PacketBuffer.indexTrack1, var3, 0, Client.field996, false);
            }

            Client.field1026 = var3;
            return 1;
        }
    }

    static int processOpcode1200To1299(int opcode, final boolean var2) {
        final Widget widget;
        if (opcode >= 2000) {
            opcode -= 1000;
            widget = class44.getWidget(class81.intStack[--intStackSize]);
        } else {
            widget = var2 ? class81.field1285 : Signlink.field2218;
        }

        FontName.method5490(widget);
        if (opcode != 1200 && opcode != 1205 && opcode != 1212) {
            if (opcode == 1201) {
                widget.modelType = 2;
                widget.modelId = class81.intStack[--intStackSize];
                return 1;
            } else if (opcode == 1202) {
                widget.modelType = 3;
                widget.modelId = Client.localPlayer.composition.method4385();
                return 1;
            } else {
                return 2;
            }
        } else {
            intStackSize -= 2;
            final int var4 = class81.intStack[intStackSize];
            final int var5 = class81.intStack[intStackSize + 1];
            widget.itemId = var4;
            widget.itemQuantity = var5;
            final ItemComposition var6 = ItemComposition.getItemDefinition(var4);
            widget.rotationX = var6.xan2d;
            widget.rotationZ = var6.yan2d;
            widget.rotationY = var6.zan2d;
            widget.offsetX2d = var6.offsetX2d;
            widget.offsetY2d = var6.offsetY2d;
            widget.modelZoom = var6.zoom2d;
            if (opcode == 1205) {
                widget.field2853 = 0;
            } else if (opcode == 1212 | var6.isStackable == 1) {
                widget.field2853 = 1;
            } else {
                widget.field2853 = 2;
            }

            if (widget.field2880 > 0) {
                widget.modelZoom = widget.modelZoom * 32 / widget.field2880;
            } else if (widget.originalWidth > 0) {
                widget.modelZoom = widget.modelZoom * 32 / widget.originalWidth;
            }

            return 1;
        }
    }

    static int processOpcode4100To4199(final int opcode) {
        final String var3;
        final int var4;
        if (opcode == 4100) {
            var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            var4 = class81.intStack[--intStackSize];
            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + var4;
            return 1;
        } else {
            final String var37;
            if (opcode == 4101) {
                KeyFocusListener.scriptStringStackSize -= 2;
                var3 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                var37 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + var37;
                return 1;
            } else if (opcode == 4102) {
                var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                var4 = class81.intStack[--intStackSize];
                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + ScriptVarType.method19(var4, true);
                return 1;
            } else if (opcode == 4103) {
                var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.toLowerCase();
                return 1;
            } else {
                final int var8;
                final int var21;
                int var28;
                if (opcode == 4104) {
                    var21 = class81.intStack[--intStackSize];
                    final long var22 = 86400000L * (var21 + 11745L);
                    class81.calendar.setTime(new Date(var22));
                    var28 = class81.calendar.get(Calendar.DAY_OF_MONTH);
                    final int var29 = class81.calendar.get(Calendar.MONTH);
                    var8 = class81.calendar.get(Calendar.YEAR);
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var28 + "-" + class81.months[var29] + "-" + var8;
                    return 1;
                } else if (opcode == 4105) {
                    KeyFocusListener.scriptStringStackSize -= 2;
                    var3 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                    var37 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                    if (Client.localPlayer.composition != null && Client.localPlayer.composition.isFemale) {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var37;
                    } else {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3;
                    }

                    return 1;
                } else if (opcode == 4106) {
                    var21 = class81.intStack[--intStackSize];
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Integer.toString(var21);
                    return 1;
                } else {
                    final int var5;
                    if (opcode == 4107) {
                        KeyFocusListener.scriptStringStackSize -= 2;
                        final int[] var27 = class81.intStack;
                        var4 = ++intStackSize - 1;
                        final String var39 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                        final String var40 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                        final int var9 = var39.length();
                        final int var10 = var40.length();
                        int var11 = 0;
                        int var12 = 0;
                        byte var13 = 0;
                        byte var14 = 0;

                        label318:
                        while (true) {
                            if (var11 - var13 >= var9 && var12 - var14 >= var10) {
                                final int var32 = Math.min(var9, var10);

                                int var33;
                                char var36;
                                for (var33 = 0; var33 < var32; ++var33) {
                                    char var34 = var39.charAt(var33);
                                    var36 = var40.charAt(var33);
                                    if (var34 != var36 && Character.toUpperCase(var34) != Character.toUpperCase(var36)) {
                                        var34 = Character.toLowerCase(var34);
                                        var36 = Character.toLowerCase(var36);
                                        if (var36 != var34) {
                                            var5 = GrandExchangeEvent.method83(var34) - GrandExchangeEvent.method83(var36);
                                            break label318;
                                        }
                                    }
                                }

                                var33 = var9 - var10;
                                if (var33 != 0) {
                                    var5 = var33;
                                } else {
                                    for (int var35 = 0; var35 < var32; ++var35) {
                                        var36 = var39.charAt(var35);
                                        final char var19 = var40.charAt(var35);
                                        if (var19 != var36) {
                                            var5 = GrandExchangeEvent.method83(var36) - GrandExchangeEvent.method83(var19);
                                            break label318;
                                        }
                                    }

                                    var5 = 0;
                                }
                                break;
                            }

                            if (var11 - var13 >= var9) {
                                var5 = -1;
                                break;
                            }

                            if (var12 - var14 >= var10) {
                                var5 = 1;
                                break;
                            }

                            char var15;
                            if (var13 != 0) {
                                var15 = (char) var13;
                            } else {
                                var15 = var39.charAt(var11++);
                            }

                            char var16;
                            if (var14 != 0) {
                                var16 = (char) var14;
                            } else {
                                var16 = var40.charAt(var12++);
                            }

                            final byte var17;
                            if (var15 == 198) {
                                var17 = 69;
                            } else if (var15 == 230) {
                                var17 = 101;
                            } else if (var15 == 223) {
                                var17 = 115;
                            } else if (var15 == 338) {
                                var17 = 69;
                            } else if (var15 == 339) {
                                var17 = 101;
                            } else {
                                var17 = 0;
                            }

                            var13 = var17;
                            final byte var18;
                            if (var16 == 198) {
                                var18 = 69;
                            } else if (var16 == 230) {
                                var18 = 101;
                            } else if (var16 == 223) {
                                var18 = 115;
                            } else if (var16 == 338) {
                                var18 = 69;
                            } else if (var16 == 339) {
                                var18 = 101;
                            } else {
                                var18 = 0;
                            }

                            var14 = var18;
                            var15 = class185.method3443(var15);
                            var16 = class185.method3443(var16);
                            if (var15 != var16 && Character.toUpperCase(var15) != Character.toUpperCase(var16)) {
                                var15 = Character.toLowerCase(var15);
                                var16 = Character.toLowerCase(var16);
                                if (var15 != var16) {
                                    var5 = GrandExchangeEvent.method83(var15) - GrandExchangeEvent.method83(var16);
                                    break;
                                }
                            }
                        }

                        var27[var4] = class248.method4500(var5);
                        return 1;
                    } else {
                        final byte[] var24;
                        final Font var25;
                        if (opcode == 4108) {
                            var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                            intStackSize -= 2;
                            var4 = class81.intStack[intStackSize];
                            var5 = class81.intStack[intStackSize + 1];
                            var24 = KeyFocusListener.indexCache13.getConfigData(var5, 0);
                            var25 = new Font(var24);
                            class81.intStack[++intStackSize - 1] = var25.method5508(var3, var4);
                            return 1;
                        } else if (opcode == 4109) {
                            var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                            intStackSize -= 2;
                            var4 = class81.intStack[intStackSize];
                            var5 = class81.intStack[intStackSize + 1];
                            var24 = KeyFocusListener.indexCache13.getConfigData(var5, 0);
                            var25 = new Font(var24);
                            class81.intStack[++intStackSize - 1] = var25.method5507(var3, var4);
                            return 1;
                        } else if (opcode == 4110) {
                            KeyFocusListener.scriptStringStackSize -= 2;
                            var3 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                            var37 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                            if (class81.intStack[--intStackSize] == 1) {
                                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3;
                            } else {
                                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var37;
                            }

                            return 1;
                        } else if (opcode == 4111) {
                            var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                            return 1;
                        } else if (opcode == 4112) {
                            var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                            var4 = class81.intStack[--intStackSize];
                            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3 + (char) var4;
                            return 1;
                        } else {
                            final boolean var6;
                            char var7;
                            final int[] var20;
                            if (opcode == 4113) {
                                var21 = class81.intStack[--intStackSize];
                                var20 = class81.intStack;
                                var5 = ++intStackSize - 1;
                                var7 = (char) var21;
                                if (var7 >= ' ' && var7 <= '~') {
                                    var6 = true;
                                } else if (var7 >= 160 && var7 <= 255) {
                                    var6 = true;
                                } else var6 = var7 == 8364 || var7 == 338 || var7 == 8212 || var7 == 339 || var7 == 376;

                                var20[var5] = var6 ? 1 : 0;
                                return 1;
                            } else if (opcode == 4114) {
                                var21 = class81.intStack[--intStackSize];
                                var20 = class81.intStack;
                                var5 = ++intStackSize - 1;
                                var7 = (char) var21;
                                var6 = var7 >= '0' && var7 <= '9' || var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                                var20[var5] = var6 ? 1 : 0;
                                return 1;
                            } else if (opcode != 4115) {
                                if (opcode == 4116) {
                                    var21 = class81.intStack[--intStackSize];
                                    class81.intStack[++intStackSize - 1] = class64.method1111((char) var21) ? 1 : 0;
                                    return 1;
                                } else if (opcode == 4117) {
                                    var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                    if (var3 != null) {
                                        class81.intStack[++intStackSize - 1] = var3.length();
                                    } else {
                                        class81.intStack[++intStackSize - 1] = 0;
                                    }

                                    return 1;
                                } else if (opcode == 4118) {
                                    var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                    intStackSize -= 2;
                                    var4 = class81.intStack[intStackSize];
                                    var5 = class81.intStack[intStackSize + 1];
                                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.substring(var4, var5);
                                    return 1;
                                } else if (opcode == 4119) {
                                    var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                    final StringBuilder var38 = new StringBuilder(var3.length());
                                    boolean var26 = false;

                                    for (var28 = 0; var28 < var3.length(); ++var28) {
                                        var7 = var3.charAt(var28);
                                        if (var7 == '<') {
                                            var26 = true;
                                        } else if (var7 == '>') {
                                            var26 = false;
                                        } else if (!var26) {
                                            var38.append(var7);
                                        }
                                    }

                                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var38.toString();
                                    return 1;
                                } else if (opcode == 4120) {
                                    var3 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                    var4 = class81.intStack[--intStackSize];
                                    class81.intStack[++intStackSize - 1] = var3.indexOf(var4);
                                    return 1;
                                } else if (opcode == 4121) {
                                    KeyFocusListener.scriptStringStackSize -= 2;
                                    var3 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                                    var37 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                                    var5 = class81.intStack[--intStackSize];
                                    class81.intStack[++intStackSize - 1] = var3.indexOf(var37, var5);
                                    return 1;
                                } else {
                                    return 2;
                                }
                            } else {
                                var21 = class81.intStack[--intStackSize];
                                var20 = class81.intStack;
                                var5 = ++intStackSize - 1;
                                var7 = (char) var21;
                                var6 = var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                                var20[var5] = var6 ? 1 : 0;
                                return 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private static int processOpcode5100To5399(final int opcode) {
        if (opcode == 5306) {
            final int[] var3 = class81.intStack;
            final int var4 = ++intStackSize - 1;
            final int var5 = Client.isResized ? 2 : 1;
            var3[var4] = var5;
            return 1;
        } else {
            final int var6;
            if (opcode == 5307) {
                var6 = class81.intStack[--intStackSize];
                if (var6 == 1 || var6 == 2) {
                    GameCanvas.method832(var6);
                }

                return 1;
            } else if (opcode == 5308) {
                class81.intStack[++intStackSize - 1] = Client.preferences.screenType;
                return 1;
            } else if (opcode != 5309) {
                return 2;
            } else {
                var6 = class81.intStack[--intStackSize];
                if (var6 == 1 || var6 == 2) {
                    Client.preferences.screenType = var6;
                    MouseInput.method1062();
                }

                return 1;
            }
        }
    }

    private static int processOpcode6300To6599(final int opcode) {
        if (opcode == 6500) {
            class81.intStack[++intStackSize - 1] = WorldMapDecorationType.loadWorlds() ? 1 : 0;
            return 1;
        } else {
            World var4;
            if (opcode == 6501) {
                World.field1228 = 0;
                if (World.field1228 < World.worldCount) {
                    var4 = World.worldList[++World.field1228 - 1];
                } else {
                    var4 = null;
                }

                if (var4 != null) {
                    class81.intStack[++intStackSize - 1] = var4.id;
                    class81.intStack[++intStackSize - 1] = var4.mask;
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.activity;
                    class81.intStack[++intStackSize - 1] = var4.location;
                    class81.intStack[++intStackSize - 1] = var4.playerCount;
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.address;
                } else {
                    class81.intStack[++intStackSize - 1] = -1;
                    class81.intStack[++intStackSize - 1] = 0;
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                    class81.intStack[++intStackSize - 1] = 0;
                    class81.intStack[++intStackSize - 1] = 0;
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                }

                return 1;
            } else if (opcode == 6502) {
                final World var3;
                if (World.field1228 < World.worldCount) {
                    var3 = World.worldList[++World.field1228 - 1];
                } else {
                    var3 = null;
                }

                if (var3 != null) {
                    class81.intStack[++intStackSize - 1] = var3.id;
                    class81.intStack[++intStackSize - 1] = var3.mask;
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.activity;
                    class81.intStack[++intStackSize - 1] = var3.location;
                    class81.intStack[++intStackSize - 1] = var3.playerCount;
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.address;
                } else {
                    class81.intStack[++intStackSize - 1] = -1;
                    class81.intStack[++intStackSize - 1] = 0;
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                    class81.intStack[++intStackSize - 1] = 0;
                    class81.intStack[++intStackSize - 1] = 0;
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                }

                return 1;
            } else {
                int var5;
                final int var11;
                if (opcode == 6506) {
                    var11 = class81.intStack[--intStackSize];
                    var4 = null;

                    for (var5 = 0; var5 < World.worldCount; ++var5) {
                        if (var11 == World.worldList[var5].id) {
                            var4 = World.worldList[var5];
                            break;
                        }
                    }

                    if (var4 != null) {
                        class81.intStack[++intStackSize - 1] = var4.id;
                        class81.intStack[++intStackSize - 1] = var4.mask;
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.activity;
                        class81.intStack[++intStackSize - 1] = var4.location;
                        class81.intStack[++intStackSize - 1] = var4.playerCount;
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.address;
                    } else {
                        class81.intStack[++intStackSize - 1] = -1;
                        class81.intStack[++intStackSize - 1] = 0;
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                        class81.intStack[++intStackSize - 1] = 0;
                        class81.intStack[++intStackSize - 1] = 0;
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                    }

                    return 1;
                } else if (opcode == 6507) {
                    intStackSize -= 4;
                    var11 = class81.intStack[intStackSize];
                    final boolean var15 = class81.intStack[intStackSize + 1] == 1;
                    var5 = class81.intStack[intStackSize + 2];
                    final boolean var6 = class81.intStack[intStackSize + 3] == 1;
                    class23.method187(var11, var15, var5, var6);
                    return 1;
                } else if (opcode != 6511) {
                    if (opcode == 6512) {
                        Client.field1014 = class81.intStack[--intStackSize] == 1;
                        return 1;
                    } else {
                        final int var12;
                        final ParamNode var13;
                        if (opcode == 6513) {
                            intStackSize -= 2;
                            var11 = class81.intStack[intStackSize];
                            var12 = class81.intStack[intStackSize + 1];
                            var13 = ParamNode.method4877(var12);
                            if (var13.isStringParam()) {
                                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = NPCComposition.getNpcDefinition(var11).method5125(var12, var13.stringObj);
                            } else {
                                class81.intStack[++intStackSize - 1] = NPCComposition.getNpcDefinition(var11).method5124(var12, var13.intObj);
                            }

                            return 1;
                        } else if (opcode == 6514) {
                            intStackSize -= 2;
                            var11 = class81.intStack[intStackSize];
                            var12 = class81.intStack[intStackSize + 1];
                            var13 = ParamNode.method4877(var12);
                            if (var13.isStringParam()) {
                                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = GameCanvas.getObjectDefinition(var11).method5008(var12, var13.stringObj);
                            } else {
                                class81.intStack[++intStackSize - 1] = GameCanvas.getObjectDefinition(var11).method5003(var12, var13.intObj);
                            }

                            return 1;
                        } else if (opcode == 6515) {
                            intStackSize -= 2;
                            var11 = class81.intStack[intStackSize];
                            var12 = class81.intStack[intStackSize + 1];
                            var13 = ParamNode.method4877(var12);
                            if (var13.isStringParam()) {
                                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = ItemComposition.getItemDefinition(var11).method5069(var12, var13.stringObj);
                            } else {
                                class81.intStack[++intStackSize - 1] = ItemComposition.getItemDefinition(var11).method5068(var12, var13.intObj);
                            }

                            return 1;
                        } else if (opcode == 6516) {
                            intStackSize -= 2;
                            var11 = class81.intStack[intStackSize];
                            var12 = class81.intStack[intStackSize + 1];
                            var13 = ParamNode.method4877(var12);
                            if (var13.isStringParam()) {
                                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class228.method4119(var11).method4932(var12, var13.stringObj);
                            } else {
                                final int[] var14 = class81.intStack;
                                final int var7 = ++intStackSize - 1;
                                class279 var9 = (class279) class279.field3553.get(var11);
                                final class279 var8;
                                if (var9 == null) {
                                    final byte[] var10 = class279.field3552.getConfigData(34, var11);
                                    var9 = new class279();
                                    if (var10 != null) {
                                        var9.method4937(new Buffer(var10));
                                    }

                                    var9.method4925();
                                    class279.field3553.put(var9, var11);
                                }
                                var8 = var9;

                                var14[var7] = var8.method4924(var12, var13.intObj);
                            }

                            return 1;
                        } else if (opcode == 6518) {
                            class81.intStack[++intStackSize - 1] = Client.field878 ? 1 : 0;
                            return 1;
                        } else if (opcode == 6520) {
                            return 1;
                        } else if (opcode == 6521) {
                            return 1;
                        } else if (opcode == 6522) {
                            --KeyFocusListener.scriptStringStackSize;
                            --intStackSize;
                            return 1;
                        } else if (opcode == 6523) {
                            --KeyFocusListener.scriptStringStackSize;
                            --intStackSize;
                            return 1;
                        } else {
                            return 2;
                        }
                    }
                } else {
                    var11 = class81.intStack[--intStackSize];
                    if (var11 >= 0 && var11 < World.worldCount) {
                        var4 = World.worldList[var11];
                        class81.intStack[++intStackSize - 1] = var4.id;
                        class81.intStack[++intStackSize - 1] = var4.mask;
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.activity;
                        class81.intStack[++intStackSize - 1] = var4.location;
                        class81.intStack[++intStackSize - 1] = var4.playerCount;
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var4.address;
                    } else {
                        class81.intStack[++intStackSize - 1] = -1;
                        class81.intStack[++intStackSize - 1] = 0;
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                        class81.intStack[++intStackSize - 1] = 0;
                        class81.intStack[++intStackSize - 1] = 0;
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                    }

                    return 1;
                }
            }
        }
    }

    static int processOpcode5400To5599(final int opcode) {
        int var3;
        if (opcode == 5504) {
            intStackSize -= 2;
            var3 = class81.intStack[intStackSize];
            final int var4 = class81.intStack[intStackSize + 1];
            if (!Client.field1111) {
                Client.cameraPitchTarget = var3;
                Client.mapAngle = var4;
            }

            return 1;
        } else if (opcode == 5505) {
            class81.intStack[++intStackSize - 1] = Client.cameraPitchTarget;
            return 1;
        } else if (opcode == 5506) {
            class81.intStack[++intStackSize - 1] = Client.mapAngle;
            return 1;
        } else if (opcode == 5530) {
            var3 = class81.intStack[--intStackSize];
            if (var3 < 0) {
                var3 = 0;
            }

            Client.field945 = var3;
            return 1;
        } else if (opcode == 5531) {
            class81.intStack[++intStackSize - 1] = Client.field945;
            return 1;
        } else {
            return 2;
        }
    }

    static int processOpcode5600To5699(final int opcode) {
        if (opcode == 5630) {
            Client.field915 = 250;
            return 1;
        } else {
            return 2;
        }
    }

    static int processOpcode1000To1099(int opcode, final boolean var2) {
        int var3 = -1;
        final Widget var4;
        if (opcode >= 2000) {
            opcode -= 1000;
            var3 = class81.intStack[--intStackSize];
            var4 = class44.getWidget(var3);
        } else {
            var4 = var2 ? class81.field1285 : Signlink.field2218;
        }

        if (opcode == 1000) {
            intStackSize -= 4;
            var4.originalX = class81.intStack[intStackSize];
            var4.originalY = class81.intStack[intStackSize + 1];
            var4.dynamicX = class81.intStack[intStackSize + 2];
            var4.dynamicY = class81.intStack[intStackSize + 3];
            FontName.method5490(var4);
            class23.clientInstance.widgetMethod0(var4);
            if (var3 != -1 && var4.type == 0) {
                class86.method1889(MouseRecorder.widgets[var3 >> 16], var4, false);
            }

            return 1;
        } else if (opcode == 1001) {
            intStackSize -= 4;
            var4.originalWidth = class81.intStack[intStackSize];
            var4.originalHeight = class81.intStack[intStackSize + 1];
            var4.dynamicWidth = class81.intStack[intStackSize + 2];
            var4.buttonType = class81.intStack[intStackSize + 3];
            FontName.method5490(var4);
            class23.clientInstance.widgetMethod0(var4);
            if (var3 != -1 && var4.type == 0) {
                class86.method1889(MouseRecorder.widgets[var3 >> 16], var4, false);
            }

            return 1;
        } else if (opcode == 1003) {
            final boolean var5 = class81.intStack[--intStackSize] == 1;
            if (var5 != var4.isHidden) {
                var4.isHidden = var5;
                FontName.method5490(var4);
            }

            return 1;
        } else if (opcode == 1005) {
            var4.noClickThrough = class81.intStack[--intStackSize] == 1;
            return 1;
        } else if (opcode == 1006) {
            var4.noScrollThrough = class81.intStack[--intStackSize] == 1;
            return 1;
        } else {
            return 2;
        }
    }

    static int processOpcode1100To1199(int opcode, final boolean var2) {
        int var4 = -1;
        final Widget var3;
        if (opcode >= 2000) {
            opcode -= 1000;
            var4 = class81.intStack[--intStackSize];
            var3 = class44.getWidget(var4);
        } else {
            var3 = var2 ? class81.field1285 : Signlink.field2218;
        }

        if (opcode == 1100) {
            intStackSize -= 2;
            var3.scrollX = class81.intStack[intStackSize];
            if (var3.scrollX > var3.scrollWidth - var3.width) {
                var3.scrollX = var3.scrollWidth - var3.width;
            }

            if (var3.scrollX < 0) {
                var3.scrollX = 0;
            }

            var3.scrollY = class81.intStack[intStackSize + 1];
            if (var3.scrollY > var3.scrollHeight - var3.height) {
                var3.scrollY = var3.scrollHeight - var3.height;
            }

            if (var3.scrollY < 0) {
                var3.scrollY = 0;
            }

            FontName.method5490(var3);
            return 1;
        } else if (opcode == 1101) {
            var3.textColor = class81.intStack[--intStackSize];
            FontName.method5490(var3);
            return 1;
        } else if (opcode == 1102) {
            var3.filled = class81.intStack[--intStackSize] == 1;
            FontName.method5490(var3);
            return 1;
        } else if (opcode == 1103) {
            var3.opacity = class81.intStack[--intStackSize];
            FontName.method5490(var3);
            return 1;
        } else if (opcode == 1104) {
            var3.lineWidth = class81.intStack[--intStackSize];
            FontName.method5490(var3);
            return 1;
        } else if (opcode == 1105) {
            var3.spriteId = class81.intStack[--intStackSize];
            FontName.method5490(var3);
            return 1;
        } else if (opcode == 1106) {
            var3.textureId = class81.intStack[--intStackSize];
            FontName.method5490(var3);
            return 1;
        } else if (opcode == 1107) {
            var3.spriteTiling = class81.intStack[--intStackSize] == 1;
            FontName.method5490(var3);
            return 1;
        } else if (opcode == 1108) {
            var3.modelType = 1;
            var3.modelId = class81.intStack[--intStackSize];
            FontName.method5490(var3);
            return 1;
        } else if (opcode == 1109) {
            intStackSize -= 6;
            var3.offsetX2d = class81.intStack[intStackSize];
            var3.offsetY2d = class81.intStack[intStackSize + 1];
            var3.rotationX = class81.intStack[intStackSize + 2];
            var3.rotationZ = class81.intStack[intStackSize + 3];
            var3.rotationY = class81.intStack[intStackSize + 4];
            var3.modelZoom = class81.intStack[intStackSize + 5];
            FontName.method5490(var3);
            return 1;
        } else {
            final int var9;
            if (opcode == 1110) {
                var9 = class81.intStack[--intStackSize];
                if (var9 != var3.field2869) {
                    var3.field2869 = var9;
                    var3.sequenceFrameId = 0;
                    var3.field2945 = 0;
                    FontName.method5490(var3);
                }

                return 1;
            } else if (opcode == 1111) {
                var3.field2879 = class81.intStack[--intStackSize] == 1;
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1112) {
                final String var8 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                if (!var8.equals(var3.text)) {
                    var3.text = var8;
                    FontName.method5490(var3);
                }

                return 1;
            } else if (opcode == 1113) {
                var3.fontId = class81.intStack[--intStackSize];
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1114) {
                intStackSize -= 3;
                var3.field2885 = class81.intStack[intStackSize];
                var3.field2833 = class81.intStack[intStackSize + 1];
                var3.field2884 = class81.intStack[intStackSize + 2];
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1115) {
                var3.textShadowed = class81.intStack[--intStackSize] == 1;
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1116) {
                var3.borderThickness = class81.intStack[--intStackSize];
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1117) {
                var3.sprite2 = class81.intStack[--intStackSize];
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1118) {
                var3.flippedVertically = class81.intStack[--intStackSize] == 1;
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1119) {
                var3.flippedHorizontally = class81.intStack[--intStackSize] == 1;
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1120) {
                intStackSize -= 2;
                var3.scrollWidth = class81.intStack[intStackSize];
                var3.scrollHeight = class81.intStack[intStackSize + 1];
                FontName.method5490(var3);
                if (var4 != -1 && var3.type == 0) {
                    class86.method1889(MouseRecorder.widgets[var4 >> 16], var3, false);
                }

                return 1;
            } else if (opcode == 1121) {
                TotalQuantityComparator.method98(var3.id, var3.index);
                Client.field1033 = var3;
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1122) {
                var3.field2858 = class81.intStack[--intStackSize];
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1123) {
                var3.field2841 = class81.intStack[--intStackSize];
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1124) {
                var3.field2854 = class81.intStack[--intStackSize];
                FontName.method5490(var3);
                return 1;
            } else if (opcode == 1125) {
                var9 = class81.intStack[--intStackSize];
                final class329[] var6 = {class329.field3966, class329.field3965, class329.field3968, class329.field3969, class329.field3967};
                final class329 var7 = (class329) Enumerated.forOrdinal(var6, var9);
                if (var7 != null) {
                    var3.field2909 = var7;
                    FontName.method5490(var3);
                }

                return 1;
            } else if (opcode == 1126) {
                var3.field2903 = class81.intStack[--intStackSize] == 1;
                return 1;
            } else {
                return 2;
            }
        }
    }

    static int processOpcode1300To1399(int var0, final boolean var2) {
        final Widget widget;
        if (var0 >= 2000) {
            var0 -= 1000;
            widget = class44.getWidget(class81.intStack[--intStackSize]);
        } else {
            widget = var2 ? class81.field1285 : Signlink.field2218;
        }

        final int var4;
        if (var0 == 1300) {
            var4 = class81.intStack[--intStackSize] - 1;
            if (var4 >= 0 && var4 <= 9) {
                widget.setAction(var4, class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize]);
            } else {
                --KeyFocusListener.scriptStringStackSize;
            }
            return 1;
        } else if (var0 == 1301) {
            intStackSize -= 2;
            var4 = class81.intStack[intStackSize];
            final int var5 = class81.intStack[intStackSize + 1];
            widget.dragParent = FontName.getWidgetChild(var4, var5);
            return 1;
        } else if (var0 == 1302) {
            widget.dragRenderBehavior = class81.intStack[--intStackSize] == 1;
            return 1;
        } else if (var0 == 1303) {
            widget.dragDeadZone = class81.intStack[--intStackSize];
            return 1;
        } else if (var0 == 1304) {
            widget.dragDeadTime = class81.intStack[--intStackSize];
            return 1;
        } else if (var0 == 1305) {
            widget.opBase = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            return 1;
        } else if (var0 == 1306) {
            widget.targetVerb = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            return 1;
        } else if (var0 == 1307) {
            widget.actions = null;
            return 1;
        } else {
            return 2;
        }
    }

    static int processOpcode1400To1499(int var0, final boolean var2) {
        final Widget var3;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = class44.getWidget(class81.intStack[--intStackSize]);
        } else {
            var3 = var2 ? class81.field1285 : Signlink.field2218;
        }

        String var4 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
        int[] var5 = null;
        if (!var4.isEmpty() && var4.charAt(var4.length() - 1) == 'Y') {
            int var6 = class81.intStack[--intStackSize];
            if (var6 > 0) {
                for (var5 = new int[var6]; var6-- > 0; var5[var6] = class81.intStack[--intStackSize]) {
                }
            }

            var4 = var4.substring(0, var4.length() - 1);
        }

        Object[] listeners = new Object[var4.length() + 1];

        int var7;
        for (var7 = listeners.length - 1; var7 >= 1; --var7) {
            if (var4.charAt(var7 - 1) == 's') {
                listeners[var7] = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            } else {
                listeners[var7] = class81.intStack[--intStackSize];
            }
        }

        var7 = class81.intStack[--intStackSize];
        if (var7 != -1) {
            listeners[0] = var7;
        } else {
            listeners = null;
        }

        if (var0 == 1400) {
            var3.onClickListener = listeners;
        } else if (var0 == 1401) {
            var3.onHoldListener = listeners;
        } else if (var0 == 1402) {
            var3.onReleaseListener = listeners;
        } else if (var0 == 1403) {
            var3.onMouseOverListener = listeners;
        } else if (var0 == 1404) {
            var3.onMouseLeaveListener = listeners;
        } else if (var0 == 1405) {
            var3.onDragListener = listeners;
        } else if (var0 == 1406) {
            var3.onTargetLeaveListener = listeners;
        } else if (var0 == 1407) {
            var3.onVarTransmitListener = listeners;
            var3.varTransmitTriggers = var5;
        } else if (var0 == 1408) {
            var3.onTimerListener = listeners;
        } else if (var0 == 1409) {
            var3.onOpListener = listeners;
        } else if (var0 == 1410) {
            var3.onDragCompleteListener = listeners;
        } else if (var0 == 1411) {
            var3.onClickRepeatListener = listeners;
        } else if (var0 == 1412) {
            var3.onMouseRepeatListener = listeners;
        } else if (var0 == 1414) {
            var3.onInvTransmitListener = listeners;
            var3.invTransmitTriggers = var5;
        } else if (var0 == 1415) {
            var3.onStatTransmitListener = listeners;
            var3.statTransmitTriggers = var5;
        } else if (var0 == 1416) {
            var3.onTargetEnterListener = listeners;
        } else if (var0 == 1417) {
            var3.onScrollWheelListener = listeners;
        } else if (var0 == 1418) {
            var3.onChatTransmitListener = listeners;
        } else if (var0 == 1419) {
            var3.onKeyListener = listeners;
        } else if (var0 == 1420) {
            var3.onFriendTransmitListener = listeners;
        } else if (var0 == 1421) {
            var3.onClanTransmitListener = listeners;
        } else if (var0 == 1422) {
            var3.onMiscTransmitListener = listeners;
        } else if (var0 == 1423) {
            var3.onDialogAbortListener = listeners;
        } else if (var0 == 1424) {
            var3.onSubChangeListener = listeners;
        } else if (var0 == 1425) {
            var3.onStockTransmitListener = listeners;
        } else if (var0 == 1426) {
            var3.onCamFinishedListener = listeners;
        } else {
            if (var0 != 1427) {
                return 2;
            }

            var3.onResizeListener = listeners;
        }

        var3.hasListener = true;
        return 1;
    }

    static int processOpcode1800To1899(final int var0, final boolean var2) {
        final Widget var3 = var2 ? class81.field1285 : Signlink.field2218;
        if (var0 == 1800) {
            class81.intStack[++intStackSize - 1] = class250.method4502(GroundObject.getWidgetClickMask(var3));
            return 1;
        } else if (var0 != 1801) {
            if (var0 == 1802) {
                if (var3.opBase == null) {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                } else {
                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.opBase;
                }

                return 1;
            } else {
                return 2;
            }
        } else {
            int var4 = class81.intStack[--intStackSize];
            --var4;
            if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.actions[var4];
            } else {
                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
            }

            return 1;
        }
    }

    static int processOpcode1900To1999(int var0, final boolean var2) {
        final Widget var3;
        if (var0 >= 2000) {
            var0 -= 1000;
            var3 = class44.getWidget(class81.intStack[--intStackSize]);
        } else {
            var3 = var2 ? class81.field1285 : Signlink.field2218;
        }

        if (var0 == 1927) {
            if (class81.field1288 >= 10) {
                throw new RuntimeException();
            } else if (var3.onResizeListener == null) {
                return 0;
            } else {
                final ScriptEvent var4 = new ScriptEvent();
                var4.widget = var3;
                var4.objs = var3.onResizeListener;
                var4.field806 = class81.field1288 + 1;
                Client.field1066.addFront(var4);
                return 1;
            }
        } else {
            return 2;
        }
    }

    static int processOpcode2500To2599(final int opcode) {
        final Widget widget = class44.getWidget(class81.intStack[--intStackSize]);
        if (opcode == 2500) {
            class81.intStack[++intStackSize - 1] = widget.relativeX;
            return 1;
        } else if (opcode == 2501) {
            class81.intStack[++intStackSize - 1] = widget.relativeY;
            return 1;
        } else if (opcode == 2502) {
            class81.intStack[++intStackSize - 1] = widget.width;
            return 1;
        } else if (opcode == 2503) {
            class81.intStack[++intStackSize - 1] = widget.height;
            return 1;
        } else if (opcode == 2504) {
            class81.intStack[++intStackSize - 1] = widget.isHidden ? 1 : 0;
            return 1;
        } else if (opcode == 2505) {
            class81.intStack[++intStackSize - 1] = widget.parentId;
            return 1;
        } else {
            return 2;
        }
    }

    static int processOpcode3000To3199(final int opcode, final boolean var2) {
        final String var11;
        if (opcode == 3100) {
            var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            class57.sendGameMessage(0, "", var11);
            return 1;
        } else if (opcode == 3101) {
            intStackSize -= 2;
            GameObject.method3083(Client.localPlayer, class81.intStack[intStackSize], class81.intStack[intStackSize + 1]);
            return 1;
        } else if (opcode == 3103) {
            final PacketNode var13 = WorldMapRectangle.method280(ClientPacket.field2428, Client.field957.field1484);
            Client.field957.method2052(var13);

            for (WidgetNode widgetNode = (WidgetNode) Client.componentTable.first(); widgetNode != null; widgetNode = (WidgetNode) Client.componentTable.next()) {
                if (widgetNode.owner == 0 || widgetNode.owner == 3) {
                    class57.closeWidget(widgetNode, true);
                }
            }

            if (Client.field1033 != null) {
                FontName.method5490(Client.field1033);
                Client.field1033 = null;
            }

            return 1;
        } else {
            int var7;
            final int var14;
            if (opcode == 3104) {
                var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                var7 = 0;
                if (class7.method27(var11)) {
                    var14 = class150.parseInt(var11, 10);
                    var7 = var14;
                }

                final PacketNode var19 = WorldMapRectangle.method280(ClientPacket.field2410, Client.field957.field1484);
                var19.packetBuffer.putInt(var7);
                Client.field957.method2052(var19);
                return 1;
            } else {
                final PacketNode var12;
                if (opcode == 3105) {
                    var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                    var12 = WorldMapRectangle.method280(ClientPacket.field2480, Client.field957.field1484);
                    var12.packetBuffer.putByte(var11.length() + 1);
                    var12.packetBuffer.putString(var11);
                    Client.field957.method2052(var12);
                    return 1;
                } else if (opcode == 3106) {
                    var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                    var12 = WorldMapRectangle.method280(ClientPacket.field2397, Client.field957.field1484);
                    var12.packetBuffer.putByte(var11.length() + 1);
                    var12.packetBuffer.putString(var11);
                    Client.field957.method2052(var12);
                    return 1;
                } else {
                    final String var4;
                    final int var9;
                    if (opcode == 3107) {
                        var9 = class81.intStack[--intStackSize];
                        var4 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        WorldMapRectangle.method279(var9, var4);
                        return 1;
                    } else if (opcode == 3108) {
                        intStackSize -= 3;
                        var9 = class81.intStack[intStackSize];
                        var7 = class81.intStack[intStackSize + 1];
                        var14 = class81.intStack[intStackSize + 2];
                        final Widget var16 = class44.getWidget(var14);
                        class27.method239(var16, var9, var7);
                        return 1;
                    } else if (opcode == 3109) {
                        intStackSize -= 2;
                        var9 = class81.intStack[intStackSize];
                        var7 = class81.intStack[intStackSize + 1];
                        final Widget var18 = var2 ? class81.field1285 : Signlink.field2218;
                        class27.method239(var18, var9, var7);
                        return 1;
                    } else if (opcode == 3110) {
                        MapIconReference.middleMouseMovesCamera = class81.intStack[--intStackSize] == 1;
                        return 1;
                    } else if (opcode == 3111) {
                        class81.intStack[++intStackSize - 1] = Client.preferences.hideRoofs ? 1 : 0;
                        return 1;
                    } else if (opcode == 3112) {
                        Client.preferences.hideRoofs = class81.intStack[--intStackSize] == 1;
                        MouseInput.method1062();
                        return 1;
                    } else if (opcode == 3113) {
                        var11 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                        final boolean var17 = class81.intStack[--intStackSize] == 1;
                        if (var17) {
                            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                                try {
                                    Desktop.getDesktop().browse(new URI(var11));
                                    return 1;
                                } catch (final Exception ignored) {
                                }
                            }

                            if (class57.field667.startsWith("win")) {
                                Buffer.method3727(var11, 0);
                            } else if (class57.field667.startsWith("mac")) {
                                CombatInfoListHolder.method1865(var11, 1, "openjs");
                            } else {
                                Buffer.method3727(var11, 2);
                            }
                        } else {
                            Buffer.method3727(var11, 3);
                        }

                        return 1;
                    } else if (opcode == 3115) {
                        var9 = class81.intStack[--intStackSize];
                        var12 = WorldMapRectangle.method280(ClientPacket.field2389, Client.field957.field1484);
                        var12.packetBuffer.putShort(var9);
                        Client.field957.method2052(var12);
                        return 1;
                    } else if (opcode == 3116) {
                        var9 = class81.intStack[--intStackSize];
                        KeyFocusListener.scriptStringStackSize -= 2;
                        var4 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                        final String var8 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                        if (var4.length() > 500) {
                            return 1;
                        } else if (var8.length() > 500) {
                            return 1;
                        } else {
                            final PacketNode var6 = WorldMapRectangle.method280(ClientPacket.field2385, Client.field957.field1484);
                            var6.packetBuffer.putShort(1 + WorldMapRegion.getLength(var4) + WorldMapRegion.getLength(var8));
                            var6.packetBuffer.putString(var8);
                            var6.packetBuffer.method3542(var9);
                            var6.packetBuffer.putString(var4);
                            Client.field957.method2052(var6);
                            return 1;
                        }
                    } else if (opcode == 3117) {
                        Client.field981 = class81.intStack[--intStackSize] == 1;
                        return 1;
                    } else if (opcode == 3118) {
                        Client.displayMouseOverText = class81.intStack[--intStackSize] == 1;
                        return 1;
                    } else if (opcode == 3119) {
                        Client.displaySelf = class81.intStack[--intStackSize] == 1;
                        return 1;
                    } else if (opcode == 3120) {
                        if (class81.intStack[--intStackSize] == 1) {
                            Client.playerNameMask |= 1;
                        } else {
                            Client.playerNameMask &= -2;
                        }

                        return 1;
                    } else if (opcode == 3121) {
                        if (class81.intStack[--intStackSize] == 1) {
                            Client.playerNameMask |= 2;
                        } else {
                            Client.playerNameMask &= -3;
                        }

                        return 1;
                    } else if (opcode == 3122) {
                        if (class81.intStack[--intStackSize] == 1) {
                            Client.playerNameMask |= 4;
                        } else {
                            Client.playerNameMask &= -5;
                        }

                        return 1;
                    } else if (opcode == 3123) {
                        if (class81.intStack[--intStackSize] == 1) {
                            Client.playerNameMask |= 8;
                        } else {
                            Client.playerNameMask &= -9;
                        }

                        return 1;
                    } else if (opcode == 3124) {
                        Client.playerNameMask = 0;
                        return 1;
                    } else if (opcode == 3125) {
                        Client.field974 = class81.intStack[--intStackSize] == 1;
                        return 1;
                    } else if (opcode == 3126) {
                        Client.field1097 = class81.intStack[--intStackSize] == 1;
                        return 1;
                    } else if (opcode == 3127) {
                        class23.method190(class81.intStack[--intStackSize] == 1);
                        return 1;
                    } else if (opcode == 3128) {
                        final int[] var3 = class81.intStack;
                        var7 = ++intStackSize - 1;
                        final boolean var5 = Client.field1016;
                        var3[var7] = var5 ? 1 : 0;
                        return 1;
                    } else if (opcode == 3129) {
                        intStackSize -= 2;
                        Client.field1059 = class81.intStack[intStackSize];
                        Client.field950 = class81.intStack[intStackSize + 1];
                        return 1;
                    } else {
                        return 2;
                    }
                }
            }
        }
    }

    static int processOpcode3700To3999(final int var0) {
        final int var3;
        if (var0 == 3903) {
            var3 = class81.intStack[--intStackSize];
            class81.intStack[++intStackSize - 1] = Client.grandExchangeOffers[var3].type();
            return 1;
        } else if (var0 == 3904) {
            var3 = class81.intStack[--intStackSize];
            class81.intStack[++intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
            return 1;
        } else if (var0 == 3905) {
            var3 = class81.intStack[--intStackSize];
            class81.intStack[++intStackSize - 1] = Client.grandExchangeOffers[var3].price;
            return 1;
        } else if (var0 == 3906) {
            var3 = class81.intStack[--intStackSize];
            class81.intStack[++intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
            return 1;
        } else if (var0 == 3907) {
            var3 = class81.intStack[--intStackSize];
            class81.intStack[++intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
            return 1;
        } else if (var0 == 3908) {
            var3 = class81.intStack[--intStackSize];
            class81.intStack[++intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
            return 1;
        } else {
            final int var12;
            if (var0 == 3910) {
                var3 = class81.intStack[--intStackSize];
                var12 = Client.grandExchangeOffers[var3].status();
                class81.intStack[++intStackSize - 1] = var12 == 0 ? 1 : 0;
                return 1;
            } else if (var0 == 3911) {
                var3 = class81.intStack[--intStackSize];
                var12 = Client.grandExchangeOffers[var3].status();
                class81.intStack[++intStackSize - 1] = var12 == 2 ? 1 : 0;
                return 1;
            } else if (var0 == 3912) {
                var3 = class81.intStack[--intStackSize];
                var12 = Client.grandExchangeOffers[var3].status();
                class81.intStack[++intStackSize - 1] = var12 == 5 ? 1 : 0;
                return 1;
            } else if (var0 == 3913) {
                var3 = class81.intStack[--intStackSize];
                var12 = Client.grandExchangeOffers[var3].status();
                class81.intStack[++intStackSize - 1] = var12 == 1 ? 1 : 0;
                return 1;
            } else {
                final boolean var13;
                if (var0 == 3914) {
                    var13 = class81.intStack[--intStackSize] == 1;
                    if (class55.grandExchangeEvents != null) {
                        class55.grandExchangeEvents.sort(GrandExchangeEvents.field285, var13);
                    }

                    return 1;
                } else if (var0 == 3915) {
                    var13 = class81.intStack[--intStackSize] == 1;
                    if (class55.grandExchangeEvents != null) {
                        class55.grandExchangeEvents.sort(GrandExchangeEvents.field290, var13);
                    }

                    return 1;
                } else if (var0 == 3916) {
                    intStackSize -= 2;
                    var13 = class81.intStack[intStackSize] == 1;
                    final boolean var4 = class81.intStack[intStackSize + 1] == 1;
                    if (class55.grandExchangeEvents != null) {
                        Client.field1134.field865 = var4;
                        class55.grandExchangeEvents.sort(Client.field1134, var13);
                    }

                    return 1;
                } else if (var0 == 3917) {
                    var13 = class81.intStack[--intStackSize] == 1;
                    if (class55.grandExchangeEvents != null) {
                        class55.grandExchangeEvents.sort(GrandExchangeEvents.field283, var13);
                    }

                    return 1;
                } else if (var0 == 3918) {
                    var13 = class81.intStack[--intStackSize] == 1;
                    if (class55.grandExchangeEvents != null) {
                        class55.grandExchangeEvents.sort(GrandExchangeEvents.field288, var13);
                    }

                    return 1;
                } else if (var0 == 3919) {
                    class81.intStack[++intStackSize - 1] = class55.grandExchangeEvents == null ? 0 : class55.grandExchangeEvents.events.size();
                    return 1;
                } else {
                    final GrandExchangeEvent var11;
                    if (var0 == 3920) {
                        var3 = class81.intStack[--intStackSize];
                        var11 = class55.grandExchangeEvents.events.get(var3);
                        class81.intStack[++intStackSize - 1] = var11.world;
                        return 1;
                    } else if (var0 == 3921) {
                        var3 = class81.intStack[--intStackSize];
                        var11 = class55.grandExchangeEvents.events.get(var3);
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var11.method81();
                        return 1;
                    } else if (var0 == 3922) {
                        var3 = class81.intStack[--intStackSize];
                        var11 = class55.grandExchangeEvents.events.get(var3);
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var11.method79();
                        return 1;
                    } else if (var0 == 3923) {
                        var3 = class81.intStack[--intStackSize];
                        var11 = class55.grandExchangeEvents.events.get(var3);
                        final long var5 = class64.method1118() - class71.field834 - var11.field292;
                        final int var7 = (int) (var5 / 3600000L);
                        final int var8 = (int) ((var5 - (var7 * 3600000)) / 60000L);
                        final int var9 = (int) ((var5 - (var7 * 3600000) - (var8 * 60000)) / 1000L);
                        final String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var10;
                        return 1;
                    } else if (var0 == 3924) {
                        var3 = class81.intStack[--intStackSize];
                        var11 = class55.grandExchangeEvents.events.get(var3);
                        class81.intStack[++intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                        return 1;
                    } else if (var0 == 3925) {
                        var3 = class81.intStack[--intStackSize];
                        var11 = class55.grandExchangeEvents.events.get(var3);
                        class81.intStack[++intStackSize - 1] = var11.grandExchangeOffer.price;
                        return 1;
                    } else if (var0 == 3926) {
                        var3 = class81.intStack[--intStackSize];
                        var11 = class55.grandExchangeEvents.events.get(var3);
                        class81.intStack[++intStackSize - 1] = var11.grandExchangeOffer.itemId;
                        return 1;
                    } else {
                        return 2;
                    }
                }
            }
        }
    }

    static int processOpcode6600To6699(final int var0) {
        final int var3;
        if (var0 == 6600) {
            var3 = BoundingBox3DDrawMode.plane;
            final int var9 = (Client.localPlayer.x >> 7) + class138.baseX;
            final int var5 = (Client.localPlayer.y >> 7) + class23.baseY;
            class86.method1892().method6018(var3, var9, var5, true);
            return 1;
        } else {
            final WorldMapData var11;
            if (var0 == 6601) {
                var3 = class81.intStack[--intStackSize];
                String var16 = "";
                var11 = class86.method1892().getWorldMapDataByFileId(var3);
                if (var11 != null) {
                    var16 = var11.getName();
                }

                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var16;
                return 1;
            } else if (var0 == 6602) {
                var3 = class81.intStack[--intStackSize];
                class86.method1892().method6019(var3);
                return 1;
            } else if (var0 == 6603) {
                class81.intStack[++intStackSize - 1] = class86.method1892().method6033();
                return 1;
            } else if (var0 == 6604) {
                var3 = class81.intStack[--intStackSize];
                class86.method1892().method6030(var3);
                return 1;
            } else if (var0 == 6605) {
                class81.intStack[++intStackSize - 1] = class86.method1892().method6035() ? 1 : 0;
                return 1;
            } else {
                final Coordinates var15;
                if (var0 == 6606) {
                    var15 = new Coordinates(class81.intStack[--intStackSize]);
                    class86.method1892().method6037(var15.x, var15.y);
                    return 1;
                } else if (var0 == 6607) {
                    var15 = new Coordinates(class81.intStack[--intStackSize]);
                    class86.method1892().method6038(var15.x, var15.y);
                    return 1;
                } else if (var0 == 6608) {
                    var15 = new Coordinates(class81.intStack[--intStackSize]);
                    class86.method1892().method6029(var15.plane, var15.x, var15.y);
                    return 1;
                } else if (var0 == 6609) {
                    var15 = new Coordinates(class81.intStack[--intStackSize]);
                    class86.method1892().method6040(var15.plane, var15.x, var15.y);
                    return 1;
                } else if (var0 == 6610) {
                    class81.intStack[++intStackSize - 1] = class86.method1892().method6047();
                    class81.intStack[++intStackSize - 1] = class86.method1892().method6042();
                    return 1;
                } else {
                    final WorldMapData var13;
                    if (var0 == 6611) {
                        var3 = class81.intStack[--intStackSize];
                        var13 = class86.method1892().getWorldMapDataByFileId(var3);
                        if (var13 == null) {
                            class81.intStack[++intStackSize - 1] = 0;
                        } else {
                            class81.intStack[++intStackSize - 1] = var13.getCoords().bitpack();
                        }

                        return 1;
                    } else if (var0 == 6612) {
                        var3 = class81.intStack[--intStackSize];
                        var13 = class86.method1892().getWorldMapDataByFileId(var3);
                        if (var13 == null) {
                            class81.intStack[++intStackSize - 1] = 0;
                            class81.intStack[++intStackSize - 1] = 0;
                        } else {
                            class81.intStack[++intStackSize - 1] = (var13.getMaxX() - var13.getMinX() + 1) * 64;
                            class81.intStack[++intStackSize - 1] = (var13.getMaxY() - var13.getMinY() + 1) * 64;
                        }

                        return 1;
                    } else if (var0 == 6613) {
                        var3 = class81.intStack[--intStackSize];
                        var13 = class86.method1892().getWorldMapDataByFileId(var3);
                        if (var13 == null) {
                            class81.intStack[++intStackSize - 1] = 0;
                            class81.intStack[++intStackSize - 1] = 0;
                            class81.intStack[++intStackSize - 1] = 0;
                            class81.intStack[++intStackSize - 1] = 0;
                        } else {
                            class81.intStack[++intStackSize - 1] = var13.getMinX() * 64;
                            class81.intStack[++intStackSize - 1] = var13.getMinY() * 64;
                            class81.intStack[++intStackSize - 1] = var13.getMaxX() * 64 + 64 - 1;
                            class81.intStack[++intStackSize - 1] = var13.getMaxY() * 64 + 64 - 1;
                        }

                        return 1;
                    } else if (var0 == 6614) {
                        var3 = class81.intStack[--intStackSize];
                        var13 = class86.method1892().getWorldMapDataByFileId(var3);
                        if (var13 == null) {
                            class81.intStack[++intStackSize - 1] = -1;
                        } else {
                            class81.intStack[++intStackSize - 1] = var13.method338();
                        }

                        return 1;
                    } else if (var0 == 6615) {
                        var15 = class86.method1892().method6043();
                        if (var15 == null) {
                            class81.intStack[++intStackSize - 1] = -1;
                            class81.intStack[++intStackSize - 1] = -1;
                        } else {
                            class81.intStack[++intStackSize - 1] = var15.x;
                            class81.intStack[++intStackSize - 1] = var15.y;
                        }

                        return 1;
                    } else if (var0 == 6616) {
                        class81.intStack[++intStackSize - 1] = class86.method1892().method6020();
                        return 1;
                    } else if (var0 == 6617) {
                        var15 = new Coordinates(class81.intStack[--intStackSize]);
                        var13 = class86.method1892().method6021();
                        if (var13 == null) {
                            class81.intStack[++intStackSize - 1] = -1;
                            class81.intStack[++intStackSize - 1] = -1;
                        } else {
                            final int[] var14 = var13.method321(var15.plane, var15.x, var15.y);
                            if (var14 == null) {
                                class81.intStack[++intStackSize - 1] = -1;
                                class81.intStack[++intStackSize - 1] = -1;
                            } else {
                                class81.intStack[++intStackSize - 1] = var14[0];
                                class81.intStack[++intStackSize - 1] = var14[1];
                            }

                        }
                        return 1;
                    } else {
                        final Coordinates var7;
                        if (var0 == 6618) {
                            var15 = new Coordinates(class81.intStack[--intStackSize]);
                            var13 = class86.method1892().method6021();
                            if (var13 == null) {
                                class81.intStack[++intStackSize - 1] = -1;
                                class81.intStack[++intStackSize - 1] = -1;
                            } else {
                                var7 = var13.method322(var15.x, var15.y);
                                if (var7 == null) {
                                    class81.intStack[++intStackSize - 1] = -1;
                                } else {
                                    class81.intStack[++intStackSize - 1] = var7.bitpack();
                                }

                            }
                            return 1;
                        } else {
                            final Coordinates var12;
                            if (var0 == 6619) {
                                intStackSize -= 2;
                                var3 = class81.intStack[intStackSize];
                                var12 = new Coordinates(class81.intStack[intStackSize + 1]);
                                WorldMapDecoration.method310(var3, var12, false);
                                return 1;
                            } else if (var0 == 6620) {
                                intStackSize -= 2;
                                var3 = class81.intStack[intStackSize];
                                var12 = new Coordinates(class81.intStack[intStackSize + 1]);
                                WorldMapDecoration.method310(var3, var12, true);
                                return 1;
                            } else if (var0 == 6621) {
                                intStackSize -= 2;
                                var3 = class81.intStack[intStackSize];
                                var12 = new Coordinates(class81.intStack[intStackSize + 1]);
                                var11 = class86.method1892().getWorldMapDataByFileId(var3);
                                if (var11 == null) {
                                    class81.intStack[++intStackSize - 1] = 0;
                                } else {
                                    class81.intStack[++intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y) ? 1 : 0;
                                }
                                return 1;
                            } else if (var0 == 6622) {
                                class81.intStack[++intStackSize - 1] = class86.method1892().method6044();
                                class81.intStack[++intStackSize - 1] = class86.method1892().method6045();
                                return 1;
                            } else if (var0 == 6623) {
                                var15 = new Coordinates(class81.intStack[--intStackSize]);
                                var13 = class86.method1892().getWorldMapDataContainingCoord(var15.plane, var15.x, var15.y);
                                if (var13 == null) {
                                    class81.intStack[++intStackSize - 1] = -1;
                                } else {
                                    class81.intStack[++intStackSize - 1] = var13.getFileId();
                                }

                                return 1;
                            } else if (var0 == 6624) {
                                class86.method1892().method6118(class81.intStack[--intStackSize]);
                                return 1;
                            } else if (var0 == 6625) {
                                class86.method1892().method6157();
                                return 1;
                            } else if (var0 == 6626) {
                                class86.method1892().method6048(class81.intStack[--intStackSize]);
                                return 1;
                            } else if (var0 == 6627) {
                                class86.method1892().method6141();
                                return 1;
                            } else {
                                final boolean var10;
                                if (var0 == 6628) {
                                    var10 = class81.intStack[--intStackSize] == 1;
                                    class86.method1892().method6106(var10);
                                    return 1;
                                } else if (var0 == 6629) {
                                    var3 = class81.intStack[--intStackSize];
                                    class86.method1892().method6051(var3);
                                    return 1;
                                } else if (var0 == 6630) {
                                    var3 = class81.intStack[--intStackSize];
                                    class86.method1892().method6134(var3);
                                    return 1;
                                } else if (var0 == 6631) {
                                    class86.method1892().method6160();
                                    return 1;
                                } else if (var0 == 6632) {
                                    var10 = class81.intStack[--intStackSize] == 1;
                                    class86.method1892().method6054(var10);
                                    return 1;
                                } else {
                                    final boolean var4;
                                    if (var0 == 6633) {
                                        intStackSize -= 2;
                                        var3 = class81.intStack[intStackSize];
                                        var4 = class81.intStack[intStackSize + 1] == 1;
                                        class86.method1892().method6055(var3, var4);
                                        return 1;
                                    } else if (var0 == 6634) {
                                        intStackSize -= 2;
                                        var3 = class81.intStack[intStackSize];
                                        var4 = class81.intStack[intStackSize + 1] == 1;
                                        class86.method1892().method6056(var3, var4);
                                        return 1;
                                    } else if (var0 == 6635) {
                                        class81.intStack[++intStackSize - 1] = class86.method1892().method6074() ? 1 : 0;
                                        return 1;
                                    } else if (var0 == 6636) {
                                        var3 = class81.intStack[--intStackSize];
                                        class81.intStack[++intStackSize - 1] = class86.method1892().method6058(var3) ? 1 : 0;
                                        return 1;
                                    } else if (var0 == 6637) {
                                        var3 = class81.intStack[--intStackSize];
                                        class81.intStack[++intStackSize - 1] = class86.method1892().method6059(var3) ? 1 : 0;
                                        return 1;
                                    } else if (var0 == 6638) {
                                        intStackSize -= 2;
                                        var3 = class81.intStack[intStackSize];
                                        var12 = new Coordinates(class81.intStack[intStackSize + 1]);
                                        var7 = class86.method1892().method6062(var3, var12);
                                        if (var7 == null) {
                                            class81.intStack[++intStackSize - 1] = -1;
                                        } else {
                                            class81.intStack[++intStackSize - 1] = var7.bitpack();
                                        }

                                        return 1;
                                    } else {
                                        final MapIcon var8;
                                        if (var0 == 6639) {
                                            var8 = class86.method1892().method6064();
                                            if (var8 == null) {
                                                class81.intStack[++intStackSize - 1] = -1;
                                                class81.intStack[++intStackSize - 1] = -1;
                                            } else {
                                                class81.intStack[++intStackSize - 1] = var8.areaId;
                                                class81.intStack[++intStackSize - 1] = var8.field532.bitpack();
                                            }

                                            return 1;
                                        } else if (var0 == 6640) {
                                            var8 = class86.method1892().method6065();
                                            if (var8 == null) {
                                                class81.intStack[++intStackSize - 1] = -1;
                                                class81.intStack[++intStackSize - 1] = -1;
                                            } else {
                                                class81.intStack[++intStackSize - 1] = var8.areaId;
                                                class81.intStack[++intStackSize - 1] = var8.field532.bitpack();
                                            }

                                            return 1;
                                        } else {
                                            final Area var6;
                                            if (var0 == 6693) {
                                                var3 = class81.intStack[--intStackSize];
                                                var6 = Area.mapAreaType[var3];
                                                if (var6.name == null) {
                                                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                                                } else {
                                                    class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var6.name;
                                                }

                                                return 1;
                                            } else if (var0 == 6694) {
                                                var3 = class81.intStack[--intStackSize];
                                                var6 = Area.mapAreaType[var3];
                                                class81.intStack[++intStackSize - 1] = var6.fontSizeId;
                                                return 1;
                                            } else if (var0 == 6695) {
                                                var3 = class81.intStack[--intStackSize];
                                                var6 = Area.mapAreaType[var3];
                                                if (var6 == null) {
                                                    class81.intStack[++intStackSize - 1] = -1;
                                                } else {
                                                    class81.intStack[++intStackSize - 1] = var6.field3473;
                                                }

                                                return 1;
                                            } else if (var0 == 6696) {
                                                var3 = class81.intStack[--intStackSize];
                                                var6 = Area.mapAreaType[var3];
                                                if (var6 == null) {
                                                    class81.intStack[++intStackSize - 1] = -1;
                                                } else {
                                                    class81.intStack[++intStackSize - 1] = var6.spriteId;
                                                }

                                                return 1;
                                            } else if (var0 == 6697) {
                                                class81.intStack[++intStackSize - 1] = class20.scriptMapIconReference.areaId;
                                                return 1;
                                            } else if (var0 == 6698) {
                                                class81.intStack[++intStackSize - 1] = class20.scriptMapIconReference.field590.bitpack();
                                                return 1;
                                            } else if (var0 == 6699) {
                                                class81.intStack[++intStackSize - 1] = class20.scriptMapIconReference.field591.bitpack();
                                                return 1;
                                            } else {
                                                return 2;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
