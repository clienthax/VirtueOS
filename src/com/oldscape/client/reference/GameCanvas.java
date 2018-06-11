package com.oldscape.client.reference;

import java.awt.*;

final class GameCanvas extends Canvas {
    static IndexData indexTextures;
    static int field2228;
    private final Component component;

    GameCanvas(final Component var1) {
        this.component = var1;
    }

    static void method314(int var0, int var1, int var2, int var3) {
        ++Client.field1137;
        GroundObject.method2670();
        if (Client.displaySelf) {
            WorldMapManager.method627(Client.localPlayer, false);
        }

        if (Client.field1112 >= 0 && Client.cachedPlayers[Client.field1112] != null) {
            WorldMapManager.method627(Client.cachedPlayers[Client.field1112], false);
        }

        ISAACCipher.method3809(true);
        WorldMapType4.method755();
        ISAACCipher.method3809(false);
        class177.method3427();

        for (GraphicsObject var4 = (GraphicsObject) Client.graphicsObjectDeque.getFront(); var4 != null; var4 = (GraphicsObject) Client.graphicsObjectDeque.getNext()) {
            if (var4.level == BoundingBox3DDrawMode.plane && !var4.finished) {
                if (Client.gameCycle >= var4.startCycle) {
                    var4.method1851(Client.field930);
                    if (var4.finished) {
                        var4.unlink();
                    } else {
                        class255.region.method2863(var4.level, var4.x, var4.y, var4.height, 60, var4, 0, -1, false);
                    }
                }
            } else {
                var4.unlink();
            }
        }

        WorldMapRegion.method535(var0, var1, var2, var3, true);
        var0 = Client.Viewport_xOffset;
        var1 = Client.Viewport_yOffset;
        var2 = Client.viewportWidth;
        var3 = Client.viewportHeight;
        Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
        Graphics3D.Rasterizer3D_method1();
        int var5;
        int var6;
        int var7;
        int var8;
        int var9;
        int var10;
        int var11;
        int var12;
        int var13;
        int var14;
        int var15;
        int var16;
        int var28;
        if (!Client.field1111) {
            var28 = Client.cameraPitchTarget;
            if (Client.field884 / 256 > var28) {
                var28 = Client.field884 / 256;
            }

            if (Client.field955[4] && Client.field1006[4] + 128 > var28) {
                var28 = Client.field1006[4] + 128;
            }

            var5 = Client.mapAngle & 2047;
            var6 = field2228;
            var7 = ObjectComposition.field3640;
            var8 = class46.field578;
            var9 = var28 * 3 + 600;
            var10 = 2048 - var28 & 2047;
            var11 = 2048 - var5 & 2047;
            var12 = 0;
            var13 = 0;
            var14 = var9;
            int var17;
            if (var10 != 0) {
                var15 = Graphics3D.SINE[var10];
                var16 = Graphics3D.COSINE[var10];
                var17 = var13 * var16 - var15 * var9 >> 16;
                var14 = var16 * var9 + var13 * var15 >> 16;
                var13 = var17;
            }

            if (var11 != 0) {
                var15 = Graphics3D.SINE[var11];
                var16 = Graphics3D.COSINE[var11];
                var17 = var16 * var12 + var15 * var14 >> 16;
                var14 = var14 * var16 - var15 * var12 >> 16;
                var12 = var17;
            }

            Player.cameraX = var6 - var12;
            GameObject.cameraZ = var7 - var13;
            class20.cameraY = var8 - var14;
            GrandExchangeOffer.cameraPitch = var28;
            Client.cameraYaw = var5;
            if (Client.field960 == 1 && Client.rights >= 2 && Client.gameCycle % 50 == 0 && (field2228 >> 7 != Client.localPlayer.x >> 7 || class46.field578 >> 7 != Client.localPlayer.y >> 7)) {
                var15 = Client.localPlayer.plane;
                var16 = (field2228 >> 7) + class138.baseX;
                var17 = (class46.field578 >> 7) + class23.baseY;
                class19.method166(var16, var17, var15, true);
            }
        }

        if (!Client.field1111) {
            if (Client.preferences.hideRoofs) {
                var5 = BoundingBox3DDrawMode.plane;
            } else {
                label680:
                {
                    var6 = 3;
                    if (GrandExchangeOffer.cameraPitch < 310) {
                        if (Client.field960 == 1) {
                            var7 = field2228 >> 7;
                            var8 = class46.field578 >> 7;
                        } else {
                            var7 = Client.localPlayer.x >> 7;
                            var8 = Client.localPlayer.y >> 7;
                        }

                        var9 = Player.cameraX >> 7;
                        var10 = class20.cameraY >> 7;
                        if (var9 < 0 || var10 < 0 || var9 >= 104 || var10 >= 104) {
                            var5 = BoundingBox3DDrawMode.plane;
                            break label680;
                        }

                        if (var7 < 0 || var8 < 0 || var7 >= 104 || var8 >= 104) {
                            var5 = BoundingBox3DDrawMode.plane;
                            break label680;
                        }

                        if ((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                            var6 = BoundingBox3DDrawMode.plane;
                        }

                        if (var7 > var9) {
                            var11 = var7 - var9;
                        } else {
                            var11 = var9 - var7;
                        }

                        if (var8 > var10) {
                            var12 = var8 - var10;
                        } else {
                            var12 = var10 - var8;
                        }

                        if (var11 > var12) {
                            var13 = var12 * 65536 / var11;
                            var14 = 32768;

                            while (var7 != var9) {
                                if (var9 < var7) {
                                    ++var9;
                                } else if (var9 > var7) {
                                    --var9;
                                }

                                if ((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                                    var6 = BoundingBox3DDrawMode.plane;
                                }

                                var14 += var13;
                                if (var14 >= 65536) {
                                    var14 -= 65536;
                                    if (var10 < var8) {
                                        ++var10;
                                    } else if (var10 > var8) {
                                        --var10;
                                    }

                                    if ((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                                        var6 = BoundingBox3DDrawMode.plane;
                                    }
                                }
                            }
                        } else if (var12 > 0) {
                            var13 = var11 * 65536 / var12;
                            var14 = 32768;

                            while (var10 != var8) {
                                if (var10 < var8) {
                                    ++var10;
                                } else if (var10 > var8) {
                                    --var10;
                                }

                                if ((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                                    var6 = BoundingBox3DDrawMode.plane;
                                }

                                var14 += var13;
                                if (var14 >= 65536) {
                                    var14 -= 65536;
                                    if (var9 < var7) {
                                        ++var9;
                                    } else if (var9 > var7) {
                                        --var9;
                                    }

                                    if ((class62.tileSettings[BoundingBox3DDrawMode.plane][var9][var10] & 4) != 0) {
                                        var6 = BoundingBox3DDrawMode.plane;
                                    }
                                }
                            }
                        }
                    }

                    if (Client.localPlayer.x >= 0 && Client.localPlayer.y >= 0 && Client.localPlayer.x < 13312 && Client.localPlayer.y < 13312) {
                        if ((class62.tileSettings[BoundingBox3DDrawMode.plane][Client.localPlayer.x >> 7][Client.localPlayer.y >> 7] & 4) != 0) {
                            var6 = BoundingBox3DDrawMode.plane;
                        }

                        var5 = var6;
                    } else {
                        var5 = BoundingBox3DDrawMode.plane;
                    }
                }
            }

            var28 = var5;
        } else {
            var28 = method831();
        }

        var5 = Player.cameraX;
        var6 = GameObject.cameraZ;
        var7 = class20.cameraY;
        var8 = GrandExchangeOffer.cameraPitch;
        var9 = Client.cameraYaw;

        for (var10 = 0; var10 < 5; ++var10) {
            if (Client.field955[var10]) {
                var11 = (int) (Math.random() * (Client.field942[var10] * 2 + 1) - Client.field942[var10] + Math.sin(Client.field1116[var10] * (Client.field939[var10] / 100.0D)) * Client.field1006[var10]);
                if (var10 == 0) {
                    Player.cameraX += var11;
                }

                if (var10 == 1) {
                    GameObject.cameraZ += var11;
                }

                if (var10 == 2) {
                    class20.cameraY += var11;
                }

                if (var10 == 3) {
                    Client.cameraYaw = var11 + Client.cameraYaw & 2047;
                }

                if (var10 == 4) {
                    GrandExchangeOffer.cameraPitch += var11;
                    if (GrandExchangeOffer.cameraPitch < 128) {
                        GrandExchangeOffer.cameraPitch = 128;
                    }

                    if (GrandExchangeOffer.cameraPitch > 383) {
                        GrandExchangeOffer.cameraPitch = 383;
                    }
                }
            }
        }

        var10 = MouseInput.mouseLastX;
        var11 = MouseInput.mouseLastY;
        if (MouseInput.mouseLastButton != 0) {
            var10 = MouseInput.mouseLastPressedX;
            var11 = MouseInput.mouseLastPressedY;
        }

        if (var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
            var12 = var10 - var0;
            var13 = var11 - var1;
            class132.Viewport_mouseX = var12;
            class132.Viewport_mouseY = var13;
            class132.Viewport_containsMouse = true;
            class132.Viewport_entityCountAtMouse = 0;
            class132.Viewport_false0 = false;
        } else {
            class132.Viewport_containsMouse = false;
            class132.Viewport_entityCountAtMouse = 0;
        }

        BoundingBox2D.method36();
        Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
        BoundingBox2D.method36();
        var12 = Graphics3D.Rasterizer3D_zoom;
        Graphics3D.Rasterizer3D_zoom = Client.scale;
        class255.region.drawRegion(Player.cameraX, GameObject.cameraZ, class20.cameraY, GrandExchangeOffer.cameraPitch, Client.cameraYaw, var28);

        while (true) {
            final BoundingBox var29 = (BoundingBox) class7.boundingBoxes.removeLast();
            if (var29 == null) {
                Graphics3D.Rasterizer3D_zoom = var12;
                BoundingBox2D.method36();
                class255.region.clearEntities();
                Client.overheadTextCount = 0;
                boolean var33 = false;
                var14 = -1;
                var15 = -1;
                var16 = class93.playerIndexesCount;
                final int[] var30 = class93.playerIndices;

                int var18;
                for (var18 = 0; var18 < var16 + Client.npcIndexesCount; ++var18) {
                    final Object var19;
                    if (var18 < var16) {
                        var19 = Client.cachedPlayers[var30[var18]];
                        if (var30[var18] == Client.field1112) {
                            var33 = true;
                            var14 = var18;
                            continue;
                        }

                        if (var19 == Client.localPlayer) {
                            var15 = var18;
                            continue;
                        }
                    } else {
                        var19 = Client.cachedNPCs[Client.npcIndices[var18 - var16]];
                    }

                    draw2DExtras((Actor) var19, var18, var0, var1, var2, var3);
                }

                if (Client.displaySelf && var15 != -1) {
                    draw2DExtras(Client.localPlayer, var15, var0, var1, var2, var3);
                }

                if (var33) {
                    draw2DExtras(Client.cachedPlayers[Client.field1112], var14, var0, var1, var2, var3);
                }

                for (var18 = 0; var18 < Client.overheadTextCount; ++var18) {
                    final int var31 = Client.overheadTextsX[var18];
                    int var20 = Client.overheadTextsY[var18];
                    final int var21 = Client.overheadTextsOffsetX[var18];
                    final int var22 = Client.overheadTextsOffsetY[var18];
                    boolean var23 = true;

                    while (var23) {
                        var23 = false;

                        for (int var24 = 0; var24 < var18; ++var24) {
                            if (var20 + 2 > Client.overheadTextsY[var24] - Client.overheadTextsOffsetY[var24] && var20 - var22 < Client.overheadTextsY[var24] + 2 && var31 - var21 < Client.overheadTextsOffsetX[var24] + Client.overheadTextsX[var24] && var21 + var31 > Client.overheadTextsX[var24] - Client.overheadTextsOffsetX[var24] && Client.overheadTextsY[var24] - Client.overheadTextsOffsetY[var24] < var20) {
                                var20 = Client.overheadTextsY[var24] - Client.overheadTextsOffsetY[var24];
                                var23 = true;
                            }
                        }
                    }

                    Client.screenX = Client.overheadTextsX[var18];
                    Client.screenY = Client.overheadTextsY[var18] = var20;
                    final String var32 = Client.overheadTexts[var18];
                    if (Client.field1031 == 0) {
                        int var25 = 16776960;
                        if (Client.field962[var18] < 6) {
                            var25 = Client.field1082[Client.field962[var18]];
                        }

                        if (Client.field962[var18] == 6) {
                            var25 = Client.field1137 % 20 < 10 ? 16711680 : 16776960;
                        }

                        if (Client.field962[var18] == 7) {
                            var25 = Client.field1137 % 20 < 10 ? 255 : '\uffff';
                        }

                        if (Client.field962[var18] == 8) {
                            var25 = Client.field1137 % 20 < 10 ? '뀀' : 8454016;
                        }

                        int var26;
                        if (Client.field962[var18] == 9) {
                            var26 = 150 - Client.overheadTextsCyclesRemaining[var18];
                            if (var26 < 50) {
                                var25 = var26 * 1280 + 16711680;
                            } else if (var26 < 100) {
                                var25 = 16776960 - (var26 - 50) * 327680;
                            } else if (var26 < 150) {
                                var25 = (var26 - 100) * 5 + 65280;
                            }
                        }

                        if (Client.field962[var18] == 10) {
                            var26 = 150 - Client.overheadTextsCyclesRemaining[var18];
                            if (var26 < 50) {
                                var25 = var26 * 5 + 16711680;
                            } else if (var26 < 100) {
                                var25 = 16711935 - (var26 - 50) * 327680;
                            } else if (var26 < 150) {
                                var25 = (var26 - 100) * 327680 + 255 - (var26 - 100) * 5;
                            }
                        }

                        if (Client.field962[var18] == 11) {
                            var26 = 150 - Client.overheadTextsCyclesRemaining[var18];
                            if (var26 < 50) {
                                var25 = 16777215 - var26 * 327685;
                            } else if (var26 < 100) {
                                var25 = (var26 - 50) * 327685 + 65280;
                            } else if (var26 < 150) {
                                var25 = 16777215 - (var26 - 100) * 327680;
                            }
                        }

                        if (Client.field963[var18] == 0) {
                            MessageNode.fontBold12.drawTextCentered(var32, var0 + Client.screenX, Client.screenY + var1, var25, 0);
                        }

                        if (Client.field963[var18] == 1) {
                            MessageNode.fontBold12.method5515(var32, var0 + Client.screenX, Client.screenY + var1, var25, 0, Client.field1137);
                        }

                        if (Client.field963[var18] == 2) {
                            MessageNode.fontBold12.method5516(var32, var0 + Client.screenX, Client.screenY + var1, var25, 0, Client.field1137);
                        }

                        if (Client.field963[var18] == 3) {
                            MessageNode.fontBold12.method5517(var32, var0 + Client.screenX, Client.screenY + var1, var25, 0, Client.field1137, 150 - Client.overheadTextsCyclesRemaining[var18]);
                        }

                        if (Client.field963[var18] == 4) {
                            var26 = (150 - Client.overheadTextsCyclesRemaining[var18]) * (MessageNode.fontBold12.getTextWidth(var32) + 100) / 150;
                            Rasterizer2D.setInnerDrawRegion(var0 + Client.screenX - 50, var1, var0 + Client.screenX + 50, var3 + var1);
                            MessageNode.fontBold12.method5510(var32, var0 + Client.screenX + 50 - var26, Client.screenY + var1, var25, 0);
                            Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
                        }

                        if (Client.field963[var18] == 5) {
                            var26 = 150 - Client.overheadTextsCyclesRemaining[var18];
                            int var27 = 0;
                            if (var26 < 25) {
                                var27 = var26 - 25;
                            } else if (var26 > 125) {
                                var27 = var26 - 125;
                            }

                            Rasterizer2D.setInnerDrawRegion(var0, Client.screenY + var1 - MessageNode.fontBold12.verticalSpace - 1, var0 + var2, Client.screenY + var1 + 5);
                            MessageNode.fontBold12.drawTextCentered(var32, var0 + Client.screenX, var27 + Client.screenY + var1, var25, 0);
                            Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
                        }
                    } else {
                        MessageNode.fontBold12.drawTextCentered(var32, var0 + Client.screenX, Client.screenY + var1, 16776960, 0);
                    }
                }

                class38.method546(var0, var1);
                ((TextureProvider) Graphics3D.textureLoader).checkTextures(Client.field930);
                if (Client.field974) {
                    if (Client.cursorState == 1) {
                        class248.crossSprites[Client.field972 / 100].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
                    }

                    if (Client.cursorState == 2) {
                        class248.crossSprites[Client.field972 / 100 + 4].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
                    }
                }

                class246.method4491();
                Player.cameraX = var5;
                GameObject.cameraZ = var6;
                class20.cameraY = var7;
                GrandExchangeOffer.cameraPitch = var8;
                Client.cameraYaw = var9;
                if (Client.field880) {
                    final byte var34 = 0;
                    var14 = var34 + class264.NetCache_pendingPriorityWritesCount + class264.NetCache_pendingPriorityResponsesCount;
                    if (var14 == 0) {
                        Client.field880 = false;
                    }
                }

                if (Client.field880) {
                    Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
                    Client.method1681("Loading - please wait.", false);
                }

                return;
            }

            var29.vmethod46();
        }
    }

    static String method3290(final int var0) {
        String var1 = Integer.toString(var0);

        for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
            var1 = var1.substring(0, var2) + "," + var1.substring(var2);
        }

        return var1.length() > 9 ? " " + class45.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>" : (var1.length() > 6 ? " " + class45.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + class45.getColTags(16776960) + var1 + "</col>");
    }

    static void draw2DExtras(final Actor var0, final int var1, final int var2, final int var3, final int var4, final int var5) {
        if (var0 != null && var0.hasConfig()) {
            if (var0 instanceof NPC) {
                NPCComposition var6 = ((NPC) var0).composition;
                if (var6.configs != null) {
                    var6 = var6.transform();
                }

                if (var6 == null) {
                    return;
                }
            }

            final int var75 = class93.playerIndexesCount;
            final int[] var7 = class93.playerIndices;
            byte var8 = 0;
            Player var10;
            if (var1 < var75 && var0.field1161 == Client.gameCycle) {
                var10 = (Player) var0;
                final boolean var9;
                if (Client.playerNameMask == 0) {
                    var9 = false;
                } else if (var10 == Client.localPlayer) {
                    var9 = method540();
                } else {
                    var9 = WidgetNode.method1134() || ISAACCipher.method3821() && var10.isFriend() || World.method1722() && var10.isClanMember();
                }

                if (var9) {
                    final Player var11 = (Player) var0;
                    if (var1 < var75) {
                        WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
                        final FontTypeFace var12 = Client.fontsMap.get(FontName.FontName_plain12);
                        final byte var13 = 9;
                        var12.drawTextCentered(var11.name.getName(), var2 + Client.screenX, var3 + Client.screenY - var13, 16777215, 0);
                        var8 = 18;
                    }
                }
            }

            int var87 = -2;
            int var15;
            int var22;
            int var23;
            if (!var0.combatInfoList.isEmpty()) {
                WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);

                for (CombatInfoListHolder var88 = (CombatInfoListHolder) var0.combatInfoList.last(); var88 != null; var88 = (CombatInfoListHolder) var0.combatInfoList.previous()) {
                    final CombatInfo1 var89 = var88.method1860(Client.gameCycle);
                    if (var89 == null) {
                        if (var88.method1858()) {
                            var88.unlink();
                        }
                    } else {
                        final CombatInfo2 var91 = var88.combatInfo2;
                        final SpritePixels var76 = var91.method4863();
                        final SpritePixels var14 = var91.method4862();
                        int var16 = 0;
                        if (var76 != null && var14 != null) {
                            if (var91.field3525 * 2 < var14.width) {
                                var16 = var91.field3525;
                            }

                            var15 = var14.width - var16 * 2;
                        } else {
                            var15 = var91.healthScale;
                        }

                        int var17 = 255;
                        final int var19 = Client.gameCycle - var89.cycle;
                        final int var20 = var15 * var89.health / var91.healthScale;
                        int var21;
                        int var92;
                        if (var89.int2 > var19) {
                            var21 = var91.field3530 == 0 ? 0 : var91.field3530 * (var19 / var91.field3530);
                            var22 = var15 * var89.healthRatio / var91.healthScale;
                            var92 = var21 * (var20 - var22) / var89.int2 + var22;
                        } else {
                            var92 = var20;
                            var21 = var91.field3522 + var89.int2 - var19;
                            if (var91.field3523 >= 0) {
                                var17 = (var21 << 8) / (var91.field3522 - var91.field3523);
                            }
                        }

                        if (var89.health > 0 && var92 < 1) {
                            var92 = 1;
                        }

                        if (var76 != null && var14 != null) {
                            if (var92 == var15) {
                                var92 += var16 * 2;
                            } else {
                                var92 += var16;
                            }

                            var21 = var76.height;
                            var87 += var21;
                            var22 = var2 + Client.screenX - (var15 >> 1);
                            var23 = var3 + Client.screenY - var87;
                            var22 -= var16;
                            if (var17 >= 0 && var17 < 255) {
                                var76.drawAtOpacity(var22, var23, var17);
                                Rasterizer2D.setInnerDrawRegion(var22, var23, var22 + var92, var21 + var23);
                                var14.drawAtOpacity(var22, var23, var17);
                            } else {
                                var76.drawAt(var22, var23);
                                Rasterizer2D.setInnerDrawRegion(var22, var23, var22 + var92, var21 + var23);
                                var14.drawAt(var22, var23);
                            }

                            Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                        } else {
                            var87 += 5;
                            if (Client.screenX > -1) {
                                var21 = var2 + Client.screenX - (var15 >> 1);
                                var22 = var3 + Client.screenY - var87;
                                Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var92, 5, 65280);
                                Rasterizer2D.Rasterizer2D_fillRectangle(var92 + var21, var22, var15 - var92, 5, 16711680);
                            }

                        }
                        var87 += 2;
                    }
                }
            }

            if (var87 == -2) {
                var87 += 7;
            }

            var87 += var8;
            if (var1 < var75) {
                var10 = (Player) var0;
                if (var10.hidden) {
                    return;
                }

                if (var10.skullIcon != -1 || var10.overheadIcon != -1) {
                    WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
                    if (Client.screenX > -1) {
                        if (var10.skullIcon != -1) {
                            var87 += 25;
                            GameEngine.headIconsPk[var10.skullIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var87);
                        }

                        if (var10.overheadIcon != -1) {
                            var87 += 25;
                            Fonts.headIconsPrayer[var10.overheadIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var87);
                        }
                    }
                }

                if (var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
                    WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
                    if (Client.screenX > -1) {
                        var87 += BoundingBox3DDrawMode.headIconsHint[1].height;
                        BoundingBox3DDrawMode.headIconsHint[1].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var87);
                    }
                }
            } else {
                NPCComposition var90 = ((NPC) var0).composition;
                if (var90.configs != null) {
                    var90 = var90.transform();
                }

                if (var90.headIcon >= 0 && var90.headIcon < Fonts.headIconsPrayer.length) {
                    WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
                    if (Client.screenX > -1) {
                        Fonts.headIconsPrayer[var90.headIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 30);
                    }
                }

                if (Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
                    WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
                    if (Client.screenX > -1) {
                        BoundingBox3DDrawMode.headIconsHint[0].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 28);
                    }
                }
            }

            if (var0.overhead != null && (var1 >= var75 || !var0.field1157 && (Client.publicChatMode == 4 || !var0.field1168 && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player) var0).isFriend())))) {
                WorldMapDecoration.characterToScreen(var0, var0.logicalHeight);
                if (Client.screenX > -1 && Client.overheadTextCount < Client.field944) {
                    Client.overheadTextsOffsetX[Client.overheadTextCount] = MessageNode.fontBold12.getTextWidth(var0.overhead) / 2;
                    Client.overheadTextsOffsetY[Client.overheadTextCount] = MessageNode.fontBold12.verticalSpace;
                    Client.overheadTextsX[Client.overheadTextCount] = Client.screenX;
                    Client.overheadTextsY[Client.overheadTextCount] = Client.screenY;
                    Client.field962[Client.overheadTextCount] = var0.field1174;
                    Client.field963[Client.overheadTextCount] = var0.field1175;
                    Client.overheadTextsCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
                    Client.overheadTexts[Client.overheadTextCount] = var0.overhead;
                    ++Client.overheadTextCount;
                }
            }

            for (int var77 = 0; var77 < 4; ++var77) {
                final int var78 = var0.hitsplatCycles[var77];
                final int var79 = var0.field1180[var77];
                class281 var94 = null;
                int var80 = 0;
                if (var79 >= 0) {
                    if (var78 <= Client.gameCycle) {
                        continue;
                    }

                    var94 = Huffman.method3457(var0.field1180[var77]);
                    var80 = var94.field3575;
                    if (var94 != null && var94.field3586 != null) {
                        var94 = var94.method4962();
                        if (var94 == null) {
                            var0.hitsplatCycles[var77] = -1;
                            continue;
                        }
                    }
                } else if (var78 < 0) {
                    continue;
                }

                var15 = var0.field1183[var77];
                class281 var81 = null;
                if (var15 >= 0) {
                    var81 = Huffman.method3457(var15);
                    if (var81 != null && var81.field3586 != null) {
                        var81 = var81.method4962();
                    }
                }

                if (var78 - var80 <= Client.gameCycle) {
                    if (var94 == null) {
                        var0.hitsplatCycles[var77] = -1;
                    } else {
                        WorldMapDecoration.characterToScreen(var0, var0.logicalHeight / 2);
                        if (Client.screenX > -1) {
                            if (var77 == 1) {
                                Client.screenY -= 20;
                            }

                            if (var77 == 2) {
                                Client.screenX -= 15;
                                Client.screenY -= 10;
                            }

                            if (var77 == 3) {
                                Client.screenX += 15;
                                Client.screenY -= 10;
                            }

                            final SpritePixels var82;
                            final SpritePixels var83;
                            final SpritePixels var84;
                            final SpritePixels var85;
                            var22 = 0;
                            var23 = 0;
                            int var24 = 0;
                            int var25 = 0;
                            int var26 = 0;
                            int var27 = 0;
                            int var28 = 0;
                            int var29 = 0;
                            SpritePixels var30 = null;
                            SpritePixels var31 = null;
                            SpritePixels var32 = null;
                            SpritePixels var33 = null;
                            int var34 = 0;
                            int var35 = 0;
                            int var36 = 0;
                            int var37 = 0;
                            int var38 = 0;
                            int var39 = 0;
                            int var40 = 0;
                            int var41 = 0;
                            int var42 = 0;
                            var82 = var94.method4968();
                            int var43;
                            if (var82 != null) {
                                var22 = var82.width;
                                var43 = var82.height;
                                if (var43 > var42) {
                                    var42 = var43;
                                }

                                var26 = var82.offsetX;
                            }

                            var83 = var94.method4991();
                            if (var83 != null) {
                                var23 = var83.width;
                                var43 = var83.height;
                                if (var43 > var42) {
                                    var42 = var43;
                                }

                                var27 = var83.offsetX;
                            }

                            var84 = var94.method4966();
                            if (var84 != null) {
                                var24 = var84.width;
                                var43 = var84.height;
                                if (var43 > var42) {
                                    var42 = var43;
                                }

                                var28 = var84.offsetX;
                            }

                            var85 = var94.method4981();
                            if (var85 != null) {
                                var25 = var85.width;
                                var43 = var85.height;
                                if (var43 > var42) {
                                    var42 = var43;
                                }

                                var29 = var85.offsetX;
                            }

                            if (var81 != null) {
                                var30 = var81.method4968();
                                if (var30 != null) {
                                    var34 = var30.width;
                                    var43 = var30.height;
                                    if (var43 > var42) {
                                        var42 = var43;
                                    }

                                    var38 = var30.offsetX;
                                }

                                var31 = var81.method4991();
                                if (var31 != null) {
                                    var35 = var31.width;
                                    var43 = var31.height;
                                    if (var43 > var42) {
                                        var42 = var43;
                                    }

                                    var39 = var31.offsetX;
                                }

                                var32 = var81.method4966();
                                if (var32 != null) {
                                    var36 = var32.width;
                                    var43 = var32.height;
                                    if (var43 > var42) {
                                        var42 = var43;
                                    }

                                    var40 = var32.offsetX;
                                }

                                var33 = var81.method4981();
                                if (var33 != null) {
                                    var37 = var33.width;
                                    var43 = var33.height;
                                    if (var43 > var42) {
                                        var42 = var43;
                                    }

                                    var41 = var33.offsetX;
                                }
                            }

                            com.oldscape.client.reference.Font var86 = var94.method4970();
                            if (var86 == null) {
                                var86 = class55.fontPlain11;
                            }

                            com.oldscape.client.reference.Font var44;
                            if (var81 != null) {
                                var44 = var81.method4970();
                                if (var44 == null) {
                                    var44 = class55.fontPlain11;
                                }
                            } else {
                                var44 = class55.fontPlain11;
                            }

                            final String var45;
                            String var46 = null;
                            int var48 = 0;
                            var45 = var94.method4963(var0.hitsplatTypes[var77]);
                            final int var93 = var86.getTextWidth(var45);
                            if (var81 != null) {
                                var46 = var81.method4963(var0.field1181[var77]);
                                var48 = var44.getTextWidth(var46);
                            }

                            int var49 = 0;
                            int var50 = 0;
                            if (var23 > 0) {
                                if (var84 == null && var85 == null) {
                                    var49 = 1;
                                } else {
                                    var49 = var93 / var23 + 1;
                                }
                            }

                            if (var81 != null && var35 > 0) {
                                if (var32 == null && var33 == null) {
                                    var50 = 1;
                                } else {
                                    var50 = var48 / var35 + 1;
                                }
                            }

                            int var51 = 0;
                            final int var52 = var51;
                            if (var22 > 0) {
                                var51 += var22;
                            }

                            var51 += 2;
                            final int var53 = var51;
                            if (var24 > 0) {
                                var51 += var24;
                            }

                            final int var54 = var51;
                            int var55 = var51;
                            int var56;
                            if (var23 > 0) {
                                var56 = var49 * var23;
                                var51 += var56;
                                var55 += (var56 - var93) / 2;
                            } else {
                                var51 += var93;
                            }

                            var56 = var51;
                            if (var25 > 0) {
                                var51 += var25;
                            }

                            int var57 = 0;
                            int var58 = 0;
                            int var59 = 0;
                            int var60 = 0;
                            int var61 = 0;
                            int var62;
                            if (var81 != null) {
                                var51 += 2;
                                var57 = var51;
                                if (var34 > 0) {
                                    var51 += var34;
                                }

                                var51 += 2;
                                var58 = var51;
                                if (var36 > 0) {
                                    var51 += var36;
                                }

                                var59 = var51;
                                var61 = var51;
                                if (var35 > 0) {
                                    var62 = var35 * var50;
                                    var51 += var62;
                                    var61 += (var62 - var48) / 2;
                                } else {
                                    var51 += var48;
                                }

                                var60 = var51;
                                if (var37 > 0) {
                                    var51 += var37;
                                }
                            }

                            var62 = var0.hitsplatCycles[var77] - Client.gameCycle;
                            final int var63 = var94.field3571 - var62 * var94.field3571 / var94.field3575;
                            final int var64 = var62 * var94.field3581 / var94.field3575 - var94.field3581;
                            final int var65 = var63 + (var2 + Client.screenX - (var51 >> 1));
                            final int var66 = var3 + Client.screenY - 12 + var64;
                            int var67 = var66;
                            int var68 = var42 + var66;
                            final int var69 = var66 + var94.field3584 + 15;
                            final int var70 = var69 - var86.minSpacing;
                            final int var71 = var69 + var86.maxSpacing;
                            if (var70 < var66) {
                                var67 = var70;
                            }

                            if (var71 > var68) {
                                var68 = var71;
                            }

                            int var72 = 0;
                            int var73;
                            int var74;
                            if (var81 != null) {
                                var72 = var66 + var81.field3584 + 15;
                                var73 = var72 - var44.minSpacing;
                                var74 = var72 + var44.maxSpacing;
                                if (var73 < var67) {
                                }

                                if (var74 > var68) {
                                }
                            }

                            var73 = 255;
                            if (var94.field3582 >= 0) {
                                var73 = (var62 << 8) / (var94.field3575 - var94.field3582);
                            }

                            if (var73 >= 0 && var73 < 255) {
                                if (var82 != null) {
                                    var82.drawAtOpacity(var65 + var52 - var26, var66, var73);
                                }

                                if (var84 != null) {
                                    var84.drawAtOpacity(var53 + var65 - var28, var66, var73);
                                }

                                if (var83 != null) {
                                    for (var74 = 0; var74 < var49; ++var74) {
                                        var83.drawAtOpacity(var23 * var74 + (var54 + var65 - var27), var66, var73);
                                    }
                                }

                                if (var85 != null) {
                                    var85.drawAtOpacity(var56 + var65 - var29, var66, var73);
                                }

                                var86.method5511(var45, var55 + var65, var69, var94.field3574, 0, var73);
                                if (var81 != null) {
                                    if (var30 != null) {
                                        var30.drawAtOpacity(var65 + var57 - var38, var66, var73);
                                    }

                                    if (var32 != null) {
                                        var32.drawAtOpacity(var58 + var65 - var40, var66, var73);
                                    }

                                    if (var31 != null) {
                                        for (var74 = 0; var74 < var50; ++var74) {
                                            var31.drawAtOpacity(var35 * var74 + (var65 + var59 - var39), var66, var73);
                                        }
                                    }

                                    if (var33 != null) {
                                        var33.drawAtOpacity(var60 + var65 - var41, var66, var73);
                                    }

                                    var44.method5511(var46, var61 + var65, var72, var81.field3574, 0, var73);
                                }
                            } else {
                                if (var82 != null) {
                                    var82.drawAt(var52 + var65 - var26, var66);
                                }

                                if (var84 != null) {
                                    var84.drawAt(var65 + var53 - var28, var66);
                                }

                                if (var83 != null) {
                                    for (var74 = 0; var74 < var49; ++var74) {
                                        var83.drawAt(var23 * var74 + (var54 + var65 - var27), var66);
                                    }
                                }

                                if (var85 != null) {
                                    var85.drawAt(var65 + var56 - var29, var66);
                                }

                                var86.method5510(var45, var55 + var65, var69, var94.field3574 | -16777216, 0);
                                if (var81 != null) {
                                    if (var30 != null) {
                                        var30.drawAt(var57 + var65 - var38, var66);
                                    }

                                    if (var32 != null) {
                                        var32.drawAt(var58 + var65 - var40, var66);
                                    }

                                    if (var31 != null) {
                                        for (var74 = 0; var74 < var50; ++var74) {
                                            var31.drawAt(var35 * var74 + (var65 + var59 - var39), var66);
                                        }
                                    }

                                    if (var33 != null) {
                                        var33.drawAt(var60 + var65 - var41, var66);
                                    }

                                    var44.method5510(var46, var61 + var65, var72, var81.field3574 | -16777216, 0);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    static boolean method540() {
        return (Client.playerNameMask & 8) != 0;
    }

    public static ObjectComposition getObjectDefinition(final int var0) {
        ObjectComposition var1 = (ObjectComposition) ObjectComposition.objects.get(var0);
        if (var1 == null) {
            final byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
            var1 = new ObjectComposition();
            var1.id = var0;
            if (var2 != null) {
                var1.decode(new Buffer(var2));
            }

            var1.post();
            if (var1.isHollow) {
                var1.clipType = 0;
                var1.blocksProjectile = false;
            }

            ObjectComposition.objects.put(var1, var0);
        }
        return var1;
    }

    static void method832(final int var0) {
        Client.field1080 = 0L;
        Client.isResized = var0 >= 2;

        final int var1 = Client.isResized ? 2 : 1;
        if (var1 == 1) {
            class23.clientInstance.method894(765, 503);
        } else {
            class23.clientInstance.method894(7680, 2160);
        }

        if (Client.gameState >= 25) {
            class61.method1070();
        }

    }

    static int method831() {
        if (Client.preferences.hideRoofs) {
            return BoundingBox3DDrawMode.plane;
        } else {
            final int var0 = WorldMapManager.getTileHeight(Player.cameraX, class20.cameraY, BoundingBox3DDrawMode.plane);
            return var0 - GameObject.cameraZ < 800 && (class62.tileSettings[BoundingBox3DDrawMode.plane][Player.cameraX >> 7][class20.cameraY >> 7] & 4) != 0 ? BoundingBox3DDrawMode.plane : 3;
        }
    }

    static void method833(final int var0, final int var1, final int var2, final int var3) {
        if (Client.itemSelectionState == 0 && !Client.spellSelected) {
            TextureProvider.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
        }

        int var4 = -1;
        int var5 = -1;

        int var6;
        int var7;
        for (var6 = 0; var6 < class132.Viewport_entityCountAtMouse; ++var6) {
            var7 = class132.Viewport_entityIdsAtMouse[var6];
            final int var8 = var7 & 127;
            final int var9 = var7 >> 7 & 127;
            final int var10 = var7 >> 29 & 3;
            final int var11 = var7 >> 14 & 32767;
            if (var7 != var5) {
                var5 = var7;
                if (var10 == 2 && class255.region.getObjectFlags(BoundingBox3DDrawMode.plane, var8, var9, var7) >= 0) {
                    ObjectComposition var12 = getObjectDefinition(var11);
                    if (var12.impostorIds != null) {
                        var12 = var12.getImpostor();
                    }

                    if (var12 == null) {
                        continue;
                    }

                    if (Client.itemSelectionState == 1) {
                        TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class45.getColTags(65535) + var12.name, 1, var7, var8, var9);
                    } else if (Client.spellSelected) {
                        if ((class110.field1607 & 4) == 4) {
                            TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + class45.getColTags(65535) + var12.name, 2, var7, var8, var9);
                        }
                    } else {
                        final String[] var19 = var12.actions;
                        if (var19 != null) {
                            for (int var20 = 4; var20 >= 0; --var20) {
                                if (var19[var20] != null) {
                                    short var15 = 0;
                                    if (var20 == 0) {
                                        var15 = 3;
                                    }

                                    if (var20 == 1) {
                                        var15 = 4;
                                    }

                                    if (var20 == 2) {
                                        var15 = 5;
                                    }

                                    if (var20 == 3) {
                                        var15 = 6;
                                    }

                                    if (var20 == 4) {
                                        var15 = 1001;
                                    }

                                    TextureProvider.addMenuEntry(var19[var20], class45.getColTags(65535) + var12.name, var15, var7, var8, var9);
                                }
                            }
                        }

                        TextureProvider.addMenuEntry("Examine", class45.getColTags(65535) + var12.name, 1002, var12.id << 14, var8, var9);
                    }
                }

                int var13;
                NPC var14;
                Player var16;
                int[] var26;
                int var28;
                if (var10 == 1) {
                    final NPC var23 = Client.cachedNPCs[var11];
                    if (var23 == null) {
                        continue;
                    }

                    if (var23.composition.size == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                        for (var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                            var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                            if (var14 != null && var23 != var14 && var14.composition.size == 1 && var23.x == var14.x && var14.y == var23.y) {
                                KeyFocusListener.method811(var14.composition, Client.npcIndices[var13], var8, var9);
                            }
                        }

                        var13 = class93.playerIndexesCount;
                        var26 = class93.playerIndices;

                        for (var28 = 0; var28 < var13; ++var28) {
                            var16 = Client.cachedPlayers[var26[var28]];
                            if (var16 != null && var16.x == var23.x && var16.y == var23.y) {
                                Signlink.method3241(var16, var26[var28], var8, var9);
                            }
                        }
                    }

                    KeyFocusListener.method811(var23.composition, var11, var8, var9);
                }

                if (var10 == 0) {
                    final Player var24 = Client.cachedPlayers[var11];
                    if (var24 == null) {
                        continue;
                    }

                    if ((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                        for (var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                            var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                            if (var14 != null && var14.composition.size == 1 && var14.x == var24.x && var14.y == var24.y) {
                                KeyFocusListener.method811(var14.composition, Client.npcIndices[var13], var8, var9);
                            }
                        }

                        var13 = class93.playerIndexesCount;
                        var26 = class93.playerIndices;

                        for (var28 = 0; var28 < var13; ++var28) {
                            var16 = Client.cachedPlayers[var26[var28]];
                            if (var16 != null && var24 != var16 && var24.x == var16.x && var24.y == var16.y) {
                                Signlink.method3241(var16, var26[var28], var8, var9);
                            }
                        }
                    }

                    if (var11 != Client.field1112) {
                        Signlink.method3241(var24, var11, var8, var9);
                    } else {
                        var4 = var7;
                    }
                }

                if (var10 == 3) {
                    final Deque var25 = Client.groundItemDeque[BoundingBox3DDrawMode.plane][var8][var9];
                    if (var25 != null) {
                        for (Item var29 = (Item) var25.getTail(); var29 != null; var29 = (Item) var25.getPrevious()) {
                            final ItemComposition var27 = ItemComposition.getItemDefinition(var29.id);
                            if (Client.itemSelectionState == 1) {
                                TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class45.getColTags(16748608) + var27.name, 16, var29.id, var8, var9);
                            } else if (Client.spellSelected) {
                                if ((class110.field1607 & 1) == 1) {
                                    TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + class45.getColTags(16748608) + var27.name, 17, var29.id, var8, var9);
                                }
                            } else {
                                final String[] var21 = var27.groundActions;

                                for (int var22 = 4; var22 >= 0; --var22) {
                                    if (var21 != null && var21[var22] != null) {
                                        byte var17 = 0;
                                        if (var22 == 0) {
                                            var17 = 18;
                                        }

                                        if (var22 == 1) {
                                            var17 = 19;
                                        }

                                        if (var22 == 2) {
                                            var17 = 20;
                                        }

                                        if (var22 == 3) {
                                            var17 = 21;
                                        }

                                        if (var22 == 4) {
                                            var17 = 22;
                                        }

                                        TextureProvider.addMenuEntry(var21[var22], class45.getColTags(16748608) + var27.name, var17, var29.id, var8, var9);
                                    } else if (var22 == 2) {
                                        TextureProvider.addMenuEntry("Take", class45.getColTags(16748608) + var27.name, 20, var29.id, var8, var9);
                                    }
                                }

                                TextureProvider.addMenuEntry("Examine", class45.getColTags(16748608) + var27.name, 1004, var29.id, var8, var9);
                            }
                        }
                    }
                }
            }
        }

        if (var4 != -1) {
            var6 = var4 & 127;
            var7 = var4 >> 7 & 127;
            final Player var18 = Client.cachedPlayers[Client.field1112];
            Signlink.method3241(var18, Client.field1112, var6, var7);
        }

    }

    static void gameDraw(final Widget[] var0, final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7, final int var8) {
        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
        Graphics3D.Rasterizer3D_method1();

        for (final Widget var10 : var0) {
            if (var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.draggedWidget)) {
                final int var11;
                if (var8 == -1) {
                    Client.widgetPositionX[Client.widgetCount] = var10.relativeX + var6;
                    Client.widgetPositionY[Client.widgetCount] = var7 + var10.relativeY;
                    Client.widgetBoundsWidth[Client.widgetCount] = var10.width;
                    Client.widgetBoundsHeight[Client.widgetCount] = var10.height;
                    var11 = ++Client.widgetCount - 1;
                } else {
                    var11 = var8;
                }

                var10.boundsIndex = var11;
                var10.loopCycle = Client.gameCycle;
                if (var10.hasScript) {
                    final boolean var12 = var10.isHidden;
                    if (var12) {
                        continue;
                    }
                }

                if (var10.contentType > 0) {
                    class88.method1894(var10);
                }

                int var39 = var10.relativeX + var6;
                int var13 = var7 + var10.relativeY;
                int var14 = var10.opacity;
                int var15;
                int var16;
                if (var10 == Client.draggedWidget) {
                    if (var1 != -1412584499 && !var10.dragRenderBehavior) {
                        class66.field785 = var0;
                        CombatInfoListHolder.field1310 = var6;
                        GrandExchangeEvent.field300 = var7;
                        continue;
                    }

                    if (Client.draggingWidget && Client.field1053) {
                        var15 = MouseInput.mouseLastX;
                        var16 = MouseInput.mouseLastY;
                        var15 -= Client.field1042;
                        var16 -= Client.field1114;
                        if (var15 < Client.field1008) {
                            var15 = Client.field1008;
                        }

                        if (var15 + var10.width > Client.field1008 + Client.field937.width) {
                            var15 = Client.field1008 + Client.field937.width - var10.width;
                        }

                        if (var16 < Client.field1047) {
                            var16 = Client.field1047;
                        }

                        if (var16 + var10.height > Client.field1047 + Client.field937.height) {
                            var16 = Client.field1047 + Client.field937.height - var10.height;
                        }

                        var39 = var15;
                        var13 = var16;
                    }

                    if (!var10.dragRenderBehavior) {
                        var14 = 128;
                    }
                }

                final int var17;
                final int var18;
                int var20;
                int var21;
                int var22;
                int var30;
                if (var10.type == 2) {
                    var15 = var2;
                    var16 = var3;
                    var17 = var4;
                    var18 = var5;
                } else if (var10.type == 9) {
                    var30 = var39;
                    var20 = var13;
                    var21 = var39 + var10.width;
                    var22 = var13 + var10.height;
                    if (var21 < var39) {
                        var30 = var21;
                        var21 = var39;
                    }

                    if (var22 < var13) {
                        var20 = var22;
                        var22 = var13;
                    }

                    ++var21;
                    ++var22;
                    var15 = var30 > var2 ? var30 : var2;
                    var16 = var20 > var3 ? var20 : var3;
                    var17 = var21 < var4 ? var21 : var4;
                    var18 = var22 < var5 ? var22 : var5;
                } else {
                    var30 = var39 + var10.width;
                    var20 = var13 + var10.height;
                    var15 = var39 > var2 ? var39 : var2;
                    var16 = var13 > var3 ? var13 : var3;
                    var17 = var30 < var4 ? var30 : var4;
                    var18 = var20 < var5 ? var20 : var5;
                }

                if (!var10.hasScript || var15 < var17 && var16 < var18) {
                    int var23;
                    int var24;
                    int var25;
                    int var26;
                    int var27;
                    if (var10.contentType != 0) {
                        if (var10.contentType == 1336) {
                            if (Client.displayFps) {
                                var13 += 15;
                                class20.font_p12full.method5512("Fps:" + GameEngine.FPS, var39 + var10.width, var13, 16776960, -1);
                                var13 += 15;
                                final Runtime var43 = Runtime.getRuntime();
                                var20 = (int) ((var43.totalMemory() - var43.freeMemory()) / 1024L);
                                var21 = 16776960;
                                if (var20 > 327680 && !Client.lowMemory) {
                                    var21 = 16711680;
                                }

                                class20.font_p12full.method5512("Mem:" + var20 + "k", var39 + var10.width, var13, var21, -1);
                            }
                            continue;
                        }

                        if (var10.contentType == 1337) {
                            Client.field991 = var39;
                            Client.field1019 = var13;
                            method314(var39, var13, var10.width, var10.height);
                            Client.field1072[var10.boundsIndex] = true;
                            Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                            continue;
                        }

                        if (var10.contentType == 1338) {
                            BoundingBox2D.method36();
                            final class236 var42 = var10.method4425(false);
                            if (var42 != null) {
                                Rasterizer2D.setDrawRegion(var39, var13, var39 + var42.width, var13 + var42.height);
                                if (Client.field1099 != 2 && Client.field1099 != 5) {
                                    var20 = Client.mapAngle & 2047;
                                    var21 = Client.localPlayer.x / 32 + 48;
                                    var22 = 464 - Client.localPlayer.y / 32;
                                    BoundingBox2D.minimapSprite.method5875(var39, var13, var42.width, var42.height, var21, var22, var20, 256, var42.field2774, var42.field2771);

                                    for (var23 = 0; var23 < Client.field1093; ++var23) {
                                        var24 = Client.field1094[var23] * 4 + 2 - Client.localPlayer.x / 32;
                                        var25 = Client.field1095[var23] * 4 + 2 - Client.localPlayer.y / 32;
                                        class38.drawDot(var39, var13, var24, var25, Client.mapIcons[var23], var42);
                                    }

                                    var23 = 0;

                                    while (true) {
                                        if (var23 >= 104) {
                                            for (var23 = 0; var23 < Client.npcIndexesCount; ++var23) {
                                                final NPC var50 = Client.cachedNPCs[Client.npcIndices[var23]];
                                                if (var50 != null && var50.hasConfig()) {
                                                    NPCComposition var55 = var50.composition;
                                                    if (var55 != null && var55.configs != null) {
                                                        var55 = var55.transform();
                                                    }

                                                    if (var55 != null && var55.isMinimapVisible && var55.field3724) {
                                                        var26 = var50.x / 32 - Client.localPlayer.x / 32;
                                                        var27 = var50.y / 32 - Client.localPlayer.y / 32;
                                                        class38.drawDot(var39, var13, var26, var27, WorldMapType4.mapDots[1], var42);
                                                    }
                                                }
                                            }

                                            var23 = class93.playerIndexesCount;
                                            final int[] var51 = class93.playerIndices;

                                            for (var25 = 0; var25 < var23; ++var25) {
                                                final Player var37 = Client.cachedPlayers[var51[var25]];
                                                if (var37 != null && var37.hasConfig() && !var37.hidden && var37 != Client.localPlayer) {
                                                    var27 = var37.x / 32 - Client.localPlayer.x / 32;
                                                    final int var38 = var37.y / 32 - Client.localPlayer.y / 32;
                                                    boolean var48 = false;
                                                    if (Client.localPlayer.team != 0 && var37.team != 0 && var37.team == Client.localPlayer.team) {
                                                        var48 = true;
                                                    }

                                                    if (var37.isFriend()) {
                                                        class38.drawDot(var39, var13, var27, var38, WorldMapType4.mapDots[3], var42);
                                                    } else if (var48) {
                                                        class38.drawDot(var39, var13, var27, var38, WorldMapType4.mapDots[4], var42);
                                                    } else if (var37.isClanMember()) {
                                                        class38.drawDot(var39, var13, var27, var38, WorldMapType4.mapDots[5], var42);
                                                    } else {
                                                        class38.drawDot(var39, var13, var27, var38, WorldMapType4.mapDots[2], var42);
                                                    }
                                                }
                                            }

                                            if (Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
                                                if (Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                                                    final NPC var57 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                                                    if (var57 != null) {
                                                        var26 = var57.x / 32 - Client.localPlayer.x / 32;
                                                        var27 = var57.y / 32 - Client.localPlayer.y / 32;
                                                        FrameMap.worldToMinimap(var39, var13, var26, var27, class19.mapMarkers[1], var42);
                                                    }
                                                }

                                                if (Client.hintArrowTargetType == 2) {
                                                    var25 = Client.hintArrowX * 4 - class138.baseX * 4 + 2 - Client.localPlayer.x / 32;
                                                    var26 = Client.hintArrowY * 4 - class23.baseY * 4 + 2 - Client.localPlayer.y / 32;
                                                    FrameMap.worldToMinimap(var39, var13, var25, var26, class19.mapMarkers[1], var42);
                                                }

                                                if (Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                                                    final Player var58 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                                                    if (var58 != null) {
                                                        var26 = var58.x / 32 - Client.localPlayer.x / 32;
                                                        var27 = var58.y / 32 - Client.localPlayer.y / 32;
                                                        FrameMap.worldToMinimap(var39, var13, var26, var27, class19.mapMarkers[1], var42);
                                                    }
                                                }
                                            }

                                            if (Client.destinationX != 0) {
                                                var25 = Client.destinationX * 4 + 2 - Client.localPlayer.x / 32;
                                                var26 = Client.destinationY * 4 + 2 - Client.localPlayer.y / 32;
                                                class38.drawDot(var39, var13, var25, var26, class19.mapMarkers[0], var42);
                                            }

                                            if (!Client.localPlayer.hidden) {
                                                Rasterizer2D.Rasterizer2D_fillRectangle(var42.width / 2 + var39 - 1, var42.height / 2 + var13 - 1, 3, 3, 16777215);
                                            }
                                            break;
                                        }

                                        for (var24 = 0; var24 < 104; ++var24) {
                                            final Deque var36 = Client.groundItemDeque[BoundingBox3DDrawMode.plane][var23][var24];
                                            if (var36 != null) {
                                                var26 = var23 * 4 + 2 - Client.localPlayer.x / 32;
                                                var27 = var24 * 4 + 2 - Client.localPlayer.y / 32;
                                                class38.drawDot(var39, var13, var26, var27, WorldMapType4.mapDots[0], var42);
                                            }
                                        }

                                        ++var23;
                                    }
                                } else {
                                    Rasterizer2D.method5737(var39, var13, 0, var42.field2774, var42.field2771);
                                }

                                Client.field1073[var11] = true;
                            }

                            Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                            continue;
                        }

                        if (var10.contentType == 1339) {
                            class25.method202(var10, var39, var13);
                            Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                            continue;
                        }

                        if (var10.contentType == 1400) {
                            Preferences.renderOverview.extractWorldmap(var39, var13, var10.width, var10.height, Client.gameCycle);
                        }

                        if (var10.contentType == 1401) {
                            Preferences.renderOverview.extractData(var39, var13, var10.width, var10.height);
                        }
                    }

                    boolean var46;
                    if (var10.type == 0) {
                        if (!var10.hasScript) {
                            var46 = var10.isHidden;
                            if (var46 && var10 != BoundingBox3D.field259) {
                                continue;
                            }
                        }

                        if (!var10.hasScript) {
                            if (var10.scrollY > var10.scrollHeight - var10.height) {
                                var10.scrollY = var10.scrollHeight - var10.height;
                            }

                            if (var10.scrollY < 0) {
                                var10.scrollY = 0;
                            }
                        }

                        gameDraw(var0, var10.id, var15, var16, var17, var18, var39 - var10.scrollX, var13 - var10.scrollY, var11);
                        if (var10.children != null) {
                            gameDraw(var10.children, var10.id, var15, var16, var17, var18, var39 - var10.scrollX, var13 - var10.scrollY, var11);
                        }

                        final WidgetNode var19 = (WidgetNode) Client.componentTable.get(var10.id);
                        if (var19 != null) {
                            class88.method1893(var19.id, var15, var16, var17, var18, var39, var13, var11);
                        }

                        Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                        Graphics3D.Rasterizer3D_method1();
                    }

                    if (Client.isResized || Client.field1074[var11] || Client.gameDrawingMode > 1) {
                        if (var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                            class152.method3139(var39 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                        }

                        if (var10.type != 1) {
                            if (var10.type == 2) {
                                var30 = 0;

                                for (var20 = 0; var20 < var10.originalHeight; ++var20) {
                                    for (var21 = 0; var21 < var10.originalWidth; ++var21) {
                                        var22 = var21 * (var10.paddingX + 32) + var39;
                                        var23 = var13 + var20 * (var10.paddingY + 32);
                                        if (var30 < 20) {
                                            var22 += var10.xSprites[var30];
                                            var23 += var10.field2915[var30];
                                        }

                                        if (var10.itemIds[var30] <= 0) {
                                            if (var10.field2892 != null && var30 < 20) {
                                                final SpritePixels var49 = var10.method4423(var30);
                                                if (var49 != null) {
                                                    var49.drawAt(var22, var23);
                                                } else if (Widget.field2820) {
                                                    FontName.method5490(var10);
                                                }
                                            }
                                        } else {
                                            var26 = var10.itemIds[var30] - 1;
                                            if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == UrlRequest.field2137 && var30 == Client.field977) {
                                                final SpritePixels var35;
                                                if (Client.itemSelectionState == 1 && var30 == UrlRequester.selectedItemIndex && var10.id == BoundingBox.field251) {
                                                    var35 = WorldMapDecoration.createSprite(var26, var10.itemQuantities[var30], 2, 0, 2, false);
                                                } else {
                                                    var35 = WorldMapDecoration.createSprite(var26, var10.itemQuantities[var30], 1, 3153952, 2, false);
                                                }

                                                if (var35 != null) {
                                                    if (var10 == UrlRequest.field2137 && var30 == Client.field977) {
                                                        var24 = MouseInput.mouseLastX - Client.field978;
                                                        var25 = MouseInput.mouseLastY - Client.field912;
                                                        if (var24 < 5 && var24 > -5) {
                                                            var24 = 0;
                                                        }

                                                        if (var25 < 5 && var25 > -5) {
                                                            var25 = 0;
                                                        }

                                                        if (Client.itemPressedDuration < 5) {
                                                            var24 = 0;
                                                            var25 = 0;
                                                        }

                                                        var35.drawAtOpacity(var22 + var24, var23 + var25, 128);
                                                        if (var1 != -1) {
                                                            final Widget var28 = var0[var1 & 65535];
                                                            int var29;
                                                            if (var23 + var25 < Rasterizer2D.drawingAreaTop && var28.scrollY > 0) {
                                                                var29 = (Rasterizer2D.drawingAreaTop - var23 - var25) * Client.field930 / 3;
                                                                if (var29 > Client.field930 * 10) {
                                                                    var29 = Client.field930 * 10;
                                                                }

                                                                if (var29 > var28.scrollY) {
                                                                    var29 = var28.scrollY;
                                                                }

                                                                var28.scrollY -= var29;
                                                                Client.field912 += var29;
                                                                FontName.method5490(var28);
                                                            }

                                                            if (var25 + var23 + 32 > Rasterizer2D.drawingAreaRight && var28.scrollY < var28.scrollHeight - var28.height) {
                                                                var29 = (var25 + var23 + 32 - Rasterizer2D.drawingAreaRight) * Client.field930 / 3;
                                                                if (var29 > Client.field930 * 10) {
                                                                    var29 = Client.field930 * 10;
                                                                }

                                                                if (var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                                    var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                                }

                                                                var28.scrollY += var29;
                                                                Client.field912 -= var29;
                                                                FontName.method5490(var28);
                                                            }
                                                        }
                                                    } else if (var10 == class2.field17 && var30 == Client.pressedItemIndex) {
                                                        var35.drawAtOpacity(var22, var23, 128);
                                                    } else {
                                                        var35.drawAt(var22, var23);
                                                    }
                                                } else {
                                                    FontName.method5490(var10);
                                                }
                                            }
                                        }

                                        ++var30;
                                    }
                                }
                            } else if (var10.type == 3) {
                                if (class27.method246(var10)) {
                                    var30 = var10.field2841;
                                    if (var10 == BoundingBox3D.field259 && var10.field2908 != 0) {
                                        var30 = var10.field2908;
                                    }
                                } else {
                                    var30 = var10.textColor;
                                    if (var10 == BoundingBox3D.field259 && var10.field2849 != 0) {
                                        var30 = var10.field2849;
                                    }
                                }

                                if (var10.filled) {
                                    switch (var10.field2909.value) {
                                        case 1:
                                            Rasterizer2D.method5723(var39, var13, var10.width, var10.height, var10.textColor, var10.field2841, 256 - (var10.opacity & 255), 256 - (var10.field2854 & 255));
                                            break;
                                        case 2:
                                            Rasterizer2D.method5742(var39, var13, var10.width, var10.height, var10.textColor, var10.field2841, 256 - (var10.opacity & 255), 256 - (var10.field2854 & 255));
                                            break;
                                        case 3:
                                            Rasterizer2D.method5725(var39, var13, var10.width, var10.height, var10.textColor, var10.field2841, 256 - (var10.opacity & 255), 256 - (var10.field2854 & 255));
                                            break;
                                        case 4:
                                            Rasterizer2D.method5726(var39, var13, var10.width, var10.height, var10.textColor, var10.field2841, 256 - (var10.opacity & 255), 256 - (var10.field2854 & 255));
                                            break;
                                        default:
                                            if (var14 == 0) {
                                                Rasterizer2D.Rasterizer2D_fillRectangle(var39, var13, var10.width, var10.height, var30);
                                            } else {
                                                Rasterizer2D.fillRectangle(var39, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                                            }
                                    }
                                } else if (var14 == 0) {
                                    Rasterizer2D.drawRectangle(var39, var13, var10.width, var10.height, var30);
                                } else {
                                    Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var39, var13, var10.width, var10.height, var30, 256 - (var14 & 255));
                                }
                            } else {
                                final com.oldscape.client.reference.Font var40;
                                if (var10.type == 4) {
                                    var40 = var10.getFont();
                                    if (var40 == null) {
                                        if (Widget.field2820) {
                                            FontName.method5490(var10);
                                        }
                                    } else {
                                        String var53 = var10.text;
                                        if (class27.method246(var10)) {
                                            var20 = var10.field2841;
                                            if (var10 == BoundingBox3D.field259 && var10.field2908 != 0) {
                                                var20 = var10.field2908;
                                            }

                                            if (!var10.string1.isEmpty()) {
                                                var53 = var10.string1;
                                            }
                                        } else {
                                            var20 = var10.textColor;
                                            if (var10 == BoundingBox3D.field259 && var10.field2849 != 0) {
                                                var20 = var10.field2849;
                                            }
                                        }

                                        if (var10.hasScript && var10.itemId != -1) {
                                            final ItemComposition var54 = ItemComposition.getItemDefinition(var10.itemId);
                                            var53 = var54.name;
                                            if (var53 == null) {
                                                var53 = "null";
                                            }

                                            if ((var54.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                                var53 = class45.getColTags(16748608) + var53 + "</col>" + " " + 'x' + method3290(var10.itemQuantity);
                                            }
                                        }

                                        if (var10 == Client.field1033) {
                                            var53 = "Please wait...";
                                            var20 = var10.textColor;
                                        }

                                        if (!var10.hasScript) {
                                            var53 = WidgetNode.method1135(var53, var10);
                                        }

                                        var40.method5514(var53, var39, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, var10.field2885, var10.field2833, var10.field2884);
                                    }
                                } else if (var10.type == 5) {
                                    final SpritePixels var41;
                                    if (!var10.hasScript) {
                                        var41 = var10.method4431(class27.method246(var10));
                                        if (var41 != null) {
                                            var41.drawAt(var39, var13);
                                        } else if (Widget.field2820) {
                                            FontName.method5490(var10);
                                        }
                                    } else {
                                        if (var10.itemId != -1) {
                                            var41 = WorldMapDecoration.createSprite(var10.itemId, var10.itemQuantity, var10.borderThickness, var10.sprite2, var10.field2853, false);
                                        } else {
                                            var41 = var10.method4431(false);
                                        }

                                        if (var41 == null) {
                                            if (Widget.field2820) {
                                                FontName.method5490(var10);
                                            }
                                        } else {
                                            var20 = var41.maxWidth;
                                            var21 = var41.maxHeight;
                                            if (!var10.spriteTiling) {
                                                var22 = var10.width * 4096 / var20;
                                                if (var10.textureId != 0) {
                                                    var41.method5877(var10.width / 2 + var39, var10.height / 2 + var13, var10.textureId, var22);
                                                } else if (var14 != 0) {
                                                    var41.method5866(var39, var13, var10.width, var10.height, 256 - (var14 & 255));
                                                } else if (var20 == var10.width && var21 == var10.height) {
                                                    var41.drawAt(var39, var13);
                                                } else {
                                                    var41.method5860(var39, var13, var10.width, var10.height);
                                                }
                                            } else {
                                                Rasterizer2D.setInnerDrawRegion(var39, var13, var39 + var10.width, var13 + var10.height);
                                                var22 = (var20 - 1 + var10.width) / var20;
                                                var23 = (var21 - 1 + var10.height) / var21;

                                                for (var24 = 0; var24 < var22; ++var24) {
                                                    for (var25 = 0; var25 < var23; ++var25) {
                                                        if (var10.textureId != 0) {
                                                            var41.method5877(var20 / 2 + var39 + var20 * var24, var21 / 2 + var13 + var25 * var21, var10.textureId, 4096);
                                                        } else if (var14 != 0) {
                                                            var41.drawAtOpacity(var39 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
                                                        } else {
                                                            var41.drawAt(var39 + var20 * var24, var13 + var25 * var21);
                                                        }
                                                    }
                                                }

                                                Rasterizer2D.setDrawRegion(var2, var3, var4, var5);
                                            }
                                        }
                                    }
                                } else {
                                    ItemComposition var34;
                                    if (var10.type == 6) {
                                        var46 = class27.method246(var10);
                                        if (var46) {
                                            var20 = var10.field2855;
                                        } else {
                                            var20 = var10.field2869;
                                        }

                                        Model var47 = null;
                                        var22 = 0;
                                        if (var10.itemId != -1) {
                                            var34 = ItemComposition.getItemDefinition(var10.itemId);
                                            if (var34 != null) {
                                                var34 = var34.method5063(var10.itemQuantity);
                                                var47 = var34.getModel(1);
                                                if (var47 != null) {
                                                    var47.calculateBoundsCylinder();
                                                    var22 = var47.modelHeight / 2;
                                                } else {
                                                    FontName.method5490(var10);
                                                }
                                            }
                                        } else if (var10.modelType == 5) {
                                            if (var10.modelId == 0) {
                                                var47 = Client.field1132.getModel(null, -1, null, -1);
                                            } else {
                                                var47 = Client.localPlayer.getModel();
                                            }
                                        } else if (var20 == -1) {
                                            var47 = var10.getModel(null, -1, var46, Client.localPlayer.composition);
                                            if (var47 == null && Widget.field2820) {
                                                FontName.method5490(var10);
                                            }
                                        } else {
                                            final Sequence sequence = CombatInfo1.getAnimation(var20);
                                            var47 = var10.getModel(sequence, var10.sequenceFrameId, var46, Client.localPlayer.composition);
                                            if (var47 == null && Widget.field2820) {
                                                FontName.method5490(var10);
                                            }
                                        }

                                        Graphics3D.method2780(var10.width / 2 + var39, var10.height / 2 + var13);
                                        var23 = Graphics3D.SINE[var10.rotationX] * var10.modelZoom >> 16;
                                        var24 = Graphics3D.COSINE[var10.rotationX] * var10.modelZoom >> 16;
                                        if (var47 != null) {
                                            if (!var10.hasScript) {
                                                var47.method2734(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                            } else {
                                                var47.calculateBoundsCylinder();
                                                if (var10.field2879) {
                                                    var47.method2748(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var23 + var22 + var10.offsetY2d, var24 + var10.offsetY2d, var10.modelZoom);
                                                } else {
                                                    var47.method2734(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.offsetX2d, var23 + var22 + var10.offsetY2d, var24 + var10.offsetY2d);
                                                }
                                            }
                                        }

                                        Graphics3D.Rasterizer3D_method3();
                                    } else {
                                        if (var10.type == 7) {
                                            var40 = var10.getFont();
                                            if (var40 == null) {
                                                if (Widget.field2820) {
                                                    FontName.method5490(var10);
                                                }
                                                continue;
                                            }

                                            var20 = 0;

                                            for (var21 = 0; var21 < var10.originalHeight; ++var21) {
                                                for (var22 = 0; var22 < var10.originalWidth; ++var22) {
                                                    if (var10.itemIds[var20] > 0) {
                                                        var34 = ItemComposition.getItemDefinition(var10.itemIds[var20] - 1);
                                                        final String var31;
                                                        if (var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                            var31 = class45.getColTags(16748608) + var34.name + "</col>";
                                                        } else {
                                                            var31 = class45.getColTags(16748608) + var34.name + "</col>" + " " + 'x' + method3290(var10.itemQuantities[var20]);
                                                        }

                                                        var25 = var39 + var22 * (var10.paddingX + 115);
                                                        var26 = var13 + (var10.paddingY + 12) * var21;
                                                        if (var10.field2885 == 0) {
                                                            var40.method5510(var31, var25, var26, var10.textColor, var10.textShadowed ? 0 : -1);
                                                        } else if (var10.field2885 == 1) {
                                                            var40.drawTextCentered(var31, var10.width / 2 + var25, var26, var10.textColor, var10.textShadowed ? 0 : -1);
                                                        } else {
                                                            var40.method5512(var31, var25 + var10.width - 1, var26, var10.textColor, var10.textShadowed ? 0 : -1);
                                                        }
                                                    }

                                                    ++var20;
                                                }
                                            }
                                        }

                                        if (var10.type == 8 && var10 == class7.field234 && Client.field1115 == Client.field1021) {
                                            var30 = 0;
                                            var20 = 0;
                                            final com.oldscape.client.reference.Font var32 = class20.font_p12full;
                                            String var33 = var10.text;

                                            String var52;
                                            for (var33 = WidgetNode.method1135(var33, var10); !var33.isEmpty(); var20 = var20 + var32.verticalSpace + 1) {
                                                var24 = var33.indexOf("<br>");
                                                if (var24 != -1) {
                                                    var52 = var33.substring(0, var24);
                                                    var33 = var33.substring(var24 + 4);
                                                } else {
                                                    var52 = var33;
                                                    var33 = "";
                                                }

                                                var25 = var32.getTextWidth(var52);
                                                if (var25 > var30) {
                                                    var30 = var25;
                                                }
                                            }

                                            var30 += 6;
                                            var20 += 7;
                                            var24 = var39 + var10.width - 5 - var30;
                                            var25 = var13 + var10.height + 5;
                                            if (var24 < var39 + 5) {
                                                var24 = var39 + 5;
                                            }

                                            if (var30 + var24 > var4) {
                                                var24 = var4 - var30;
                                            }

                                            if (var20 + var25 > var5) {
                                                var25 = var5 - var20;
                                            }

                                            Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var30, var20, 16777120);
                                            Rasterizer2D.drawRectangle(var24, var25, var30, var20, 0);
                                            var33 = var10.text;
                                            var26 = var25 + var32.verticalSpace + 2;

                                            for (var33 = WidgetNode.method1135(var33, var10); !var33.isEmpty(); var26 = var26 + var32.verticalSpace + 1) {
                                                var27 = var33.indexOf("<br>");
                                                if (var27 != -1) {
                                                    var52 = var33.substring(0, var27);
                                                    var33 = var33.substring(var27 + 4);
                                                } else {
                                                    var52 = var33;
                                                    var33 = "";
                                                }

                                                var32.method5510(var52, var24 + 3, var26, 0, -1);
                                            }
                                        }

                                        if (var10.type == 9) {
                                            if (var10.field2903) {
                                                var30 = var39;
                                                var20 = var13 + var10.height;
                                                var21 = var39 + var10.width;
                                                var22 = var13;
                                            } else {
                                                var30 = var39;
                                                var20 = var13;
                                                var21 = var39 + var10.width;
                                                var22 = var13 + var10.height;
                                            }

                                            if (var10.lineWidth == 1) {
                                                Rasterizer2D.drawLine(var30, var20, var21, var22, var10.textColor);
                                            } else {
                                                class2.method2(var30, var20, var21, var22, var10.textColor, var10.lineWidth);
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

    public final void paint(final Graphics var1) {
        this.component.paint(var1);
    }

    public final void update(final Graphics var1) {
        this.component.update(var1);
    }
}
