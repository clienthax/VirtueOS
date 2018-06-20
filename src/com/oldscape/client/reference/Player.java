package com.oldscape.client.reference;

final class Player extends Actor {
    static int cameraX;
    final String[] actions;
    Name name;
    PlayerComposition composition;
    int skullIcon;
    int overheadIcon;
    int combatLevel;
    int totalLevel;
    int field842;
    int animationCycleStart;
    int animationCycleEnd;
    int field845;
    int field858;
    int field843;
    Model model;
    int field849;
    int field850;
    int field851;
    int field852;
    boolean isLowDetail;
    int team;
    boolean hidden;
    int plane;
    int playerId;
    boolean field860;
    int field861;
    int field837;
    private class303 field859;
    private class303 field835;

    Player() {
        this.skullIcon = -1;
        this.overheadIcon = -1;
        this.actions = new String[3];

        for (int var1 = 0; var1 < 3; ++var1) {
            this.actions[var1] = "";
        }

        this.combatLevel = 0;
        this.totalLevel = 0;
        this.animationCycleStart = 0;
        this.animationCycleEnd = 0;
        this.isLowDetail = false;
        this.team = 0;
        this.hidden = false;
        this.field859 = class303.field3851;
        this.field835 = class303.field3851;
        this.field860 = false;
    }

    static void processPlayerUpdateFlags(final PacketBuffer buffer, final int playerIdx, final Player player, final int flags) {
        byte movementType = -1;
        int var5;
        int var6;
        int var9;
        int var10;

        /**
         * Correct order
         * 4
         * 64
         * 16
         * 128
         * 2048
         * 1
         * 256
         * 8
         * 512
         * 1024
         * 4096
         * 2
         *
         */

        System.out.println("flags " + flags);

        //Force chat
        if ((flags & 4) != 0) {
            player.overhead = buffer.readString();
            if (player.overhead.charAt(0) == '~') {
                player.overhead = player.overhead.substring(1);
                class57.sendGameMessage(2, player.name.getName(), player.overhead);
            } else if (player == Client.localPlayer) {
                class57.sendGameMessage(2, player.name.getName(), player.overhead);
            }

            player.field1168 = false;
            player.field1174 = 0;
            player.field1175 = 0;
            player.overheadTextCyclesRemaining = 150;
        }

        //face entity
        if ((flags & 64) != 0) {
            player.interacting = buffer.readUnsignedShort();
            if (player.interacting == 65535) {
                player.interacting = -1;
            }
        }

        //Face position / change direction
        if ((flags & 16) != 0) {
            player.field1185 = buffer.method3555();
            if (player.queueSize == 0) {
                player.orientation = player.field1185;
                player.field1185 = -1;
            }
        }


        //Hit masks
        if ((flags & 128) != 0) {
            var5 = buffer.method3636();
            int var7;
            int var8;
            int var11;
            if (var5 > 0) {
                for (var6 = 0; var6 < var5; ++var6) {
                    var8 = -1;
                    var9 = -1;
                    var10 = -1;
                    var7 = buffer.getUSmart();
                    if (var7 == 32767) {
                        var7 = buffer.getUSmart();
                        var9 = buffer.getUSmart();
                        var8 = buffer.getUSmart();
                        var10 = buffer.getUSmart();
                    } else if (var7 != 32766) {
                        var9 = buffer.getUSmart();
                    } else {
                        var7 = -1;
                    }

                    var11 = buffer.getUSmart();
                    player.method1657(var7, var9, var8, var10, Client.gameCycle, var11);
                }
            }

            var6 = buffer.method3538();
            if (var6 > 0) {
                for (var7 = 0; var7 < var6; ++var7) {
                    var8 = buffer.getUSmart();
                    var9 = buffer.getUSmart();
                    if (var9 != 32767) {
                        var10 = buffer.getUSmart();
                        var11 = buffer.method3538();
                        final int var12 = var9 > 0 ? buffer.readUnsignedShortOb1() : var11;
                        player.setCombatInfo(var8, Client.gameCycle, var9, var10, var11, var12);
                    } else {
                        player.method1659(var8);
                    }
                }
            }
        }

        //Context menu
        if ((flags & 2048) != 0) {
            for (var5 = 0; var5 < 3; ++var5) {
                player.actions[var5] = buffer.readString();
            }
        }

        //Animation
        if ((flags & 1) != 0) {
            var5 = buffer.readUnsignedShort();
            if (var5 == 65535) {
                var5 = -1;
            }

            var6 = buffer.method3538();
            GameObject.method3083(player, var5, var6);
        }

        //GFX
        if ((flags & 256) != 0) {
            player.graphic = buffer.getUnsignedShortLE();
            var5 = buffer.method3563();
            player.field1198 = var5 >> 16;
            player.graphicsDelay = (var5 & 65535) + Client.gameCycle;
            player.spotAnimFrame = 0;
            player.spotAnimFrameCycle = 0;
            if (player.graphicsDelay > Client.gameCycle) {
                player.spotAnimFrame = -1;
            }

            if (player.graphic == 65535) {
                player.graphic = -1;
            }
        }

        //Chat masks
        if ((flags & 8) != 0) {
            var5 = buffer.getUnsignedShortLE();
            final ChatCrownType[] var17 = {ChatCrownType.STAFF_MODERATOR, ChatCrownType.PLAYER_MODERATOR, ChatCrownType.IRONMAN, ChatCrownType.HARDCORE_IRONMAN, ChatCrownType.PLAYER, ChatCrownType.ULTIMATE_IRONMAN};
            final ChatCrownType var18 = (ChatCrownType) Enumerated.forOrdinal(var17, buffer.readUnsignedShortOb1());
            final boolean var21 = buffer.readUnsignedByte() == 1;
            var9 = buffer.method3538();
            var10 = buffer.offset;
            if (player.name != null && player.composition != null) {
                boolean var22 = false;
                if (var18.ignorable && WorldMapRectangle.friendManager.isIgnored(player.name)) {
                    var22 = true;
                }

                if (!var22 && Client.myPlayerIndex == 0 && !player.hidden) {
                    class93.field1432.offset = 0;
                    buffer.method3565(class93.field1432.payload, 0, var9);
                    class93.field1432.offset = 0;
                    final String var19 = FontTypeFace.appendTags(class303.method5406(WallObject.method3061(class93.field1432)));
                    player.overhead = var19.trim();
                    player.field1174 = var5 >> 8;
                    player.field1175 = var5 & 255;
                    player.overheadTextCyclesRemaining = 150;
                    player.field1168 = var21;
                    player.field1157 = player != Client.localPlayer && var18.ignorable && "" != Client.field1085 && !var19.toLowerCase().contains(Client.field1085);
                    final int var13;
                    if (var18.moderator) {
                        var13 = var21 ? 91 : 1;
                    } else {
                        var13 = var21 ? 90 : 2;
                    }

                    if (var18.icon != -1) {
                        final int var16 = var18.icon;
                        final String var15 = "<img=" + var16 + ">";
                        class57.sendGameMessage(var13, var15 + player.name.getName(), var19);
                    } else {
                        class57.sendGameMessage(var13, player.name.getName(), var19);
                    }
                }
            }

            buffer.offset = var10 + var9;
        }


        //Movement mask
        if ((flags & 512) != 0) {
            movementType = buffer.method3548();
        }

        //Forced movement
        if ((flags & 1024) != 0) {
            player.field1203 = buffer.readByte();
            player.field1199 = buffer.method3725();
            player.field1200 = buffer.method3548();
            player.field1202 = buffer.method3634();
            player.field1166 = buffer.getUnsignedShortLE() + Client.gameCycle;
            player.field1204 = buffer.method3554() + Client.gameCycle;
            player.field1171 = buffer.method3555();
            if (player.field860) {
                player.field1203 += player.field861;
                player.field1199 += player.field837;
                player.field1200 += player.field861;
                player.field1202 += player.field837;
                player.queueSize = 0;
            } else {
                player.field1203 += player.pathX[0];
                player.field1199 += player.pathY[0];
                player.field1200 += player.pathX[0];
                player.field1202 += player.pathY[0];
                player.queueSize = 1;
            }

            player.field1216 = 0;
        }

        //Temp movement??
        if ((flags & 4096) != 0) {
            class93.field1429[playerIdx] = buffer.method3634();
        }

        //Appearance
        if ((flags & 2) != 0) {
            var5 = buffer.readUnsignedShortOb1();
            final byte[] var23 = new byte[var5];
            final Buffer var24 = new Buffer(var23);
            buffer.method3661(var23, 0, var5);
            class93.field1430[playerIdx] = var24;
            player.decodeApperance(var24);
        }

        if (player.field860) {
            if (movementType == 127) {
                player.method1196(player.field861, player.field837);
            } else {
                final byte type;
                if (movementType != -1) {
                    type = movementType;
                } else {
                    type = class93.field1429[playerIdx];
                }

                player.method1195(player.field861, player.field837, type);
            }
        }

    }

    static void method1230(final IndexDataBase var0, final IndexDataBase var1, final boolean var2, final int var3) {
        if (class90.field1387) {
            if (var3 == 4) {
                class90.loginIndex = 4;
            }

        } else {
            class90.loginIndex = var3;
            Rasterizer2D.reset();
            final byte[] var4 = var0.takeRecordByNames("title.jpg", "");
            class321.field3938 = class185.method3448(var4);
            class90.field1381 = class321.field3938.method5847();
            if ((Client.flags & 536870912) != 0) {
                class171.logoSprite = FriendManager.getSprite(var1, "logo_deadman_mode", "");
            } else {
                class171.logoSprite = FriendManager.getSprite(var1, "logo", "");
            }

            IndexStoreActionHandler.field3398 = FriendManager.getSprite(var1, "titlebox", "");
            class90.field1388 = FriendManager.getSprite(var1, "titlebutton", "");
            class90.runeSprites = WorldMapManager.getIndexedSprites(var1, "runes", "");
            class57.titlemuteSprite = WorldMapManager.getIndexedSprites(var1, "title_mute", "");
            class90.field1363 = FriendManager.getSprite(var1, "options_radio_buttons,0", "");
            Frames.field2074 = FriendManager.getSprite(var1, "options_radio_buttons,4", "");
            class90.field1393 = FriendManager.getSprite(var1, "options_radio_buttons,2", "");
            class246.field2979 = FriendManager.getSprite(var1, "options_radio_buttons,6", "");
            NPC.field1318 = class90.field1363.width;
            class203.field2616 = class90.field1363.height;
            class21.field347 = new int[256];

            int var5;
            for (var5 = 0; var5 < 64; ++var5) {
                class21.field347[var5] = var5 * 262144;
            }

            for (var5 = 0; var5 < 64; ++var5) {
                class21.field347[var5 + 64] = var5 * 1024 + 16711680;
            }

            for (var5 = 0; var5 < 64; ++var5) {
                class21.field347[var5 + 128] = var5 * 4 + 16776960;
            }

            for (var5 = 0; var5 < 64; ++var5) {
                class21.field347[var5 + 192] = 16777215;
            }

            ScriptState.field762 = new int[256];

            for (var5 = 0; var5 < 64; ++var5) {
                ScriptState.field762[var5] = var5 * 1024;
            }

            for (var5 = 0; var5 < 64; ++var5) {
                ScriptState.field762[var5 + 64] = var5 * 4 + 65280;
            }

            for (var5 = 0; var5 < 64; ++var5) {
                ScriptState.field762[var5 + 128] = var5 * 262144 + 65535;
            }

            for (var5 = 0; var5 < 64; ++var5) {
                ScriptState.field762[var5 + 192] = 16777215;
            }

            GrandExchangeEvent.field298 = new int[256];

            for (var5 = 0; var5 < 64; ++var5) {
                GrandExchangeEvent.field298[var5] = var5 * 4;
            }

            for (var5 = 0; var5 < 64; ++var5) {
                GrandExchangeEvent.field298[var5 + 64] = var5 * 262144 + 255;
            }

            for (var5 = 0; var5 < 64; ++var5) {
                GrandExchangeEvent.field298[var5 + 128] = var5 * 1024 + 16711935;
            }

            for (var5 = 0; var5 < 64; ++var5) {
                GrandExchangeEvent.field298[var5 + 192] = 16777215;
            }

            class21.field344 = new int[256];
            MouseRecorder.field819 = new int['耀'];
            GrandExchangeEvents.field287 = new int['耀'];
            class44.method663(null);
            Huffman.field2513 = new int['耀'];
            AbstractSoundSystem.field1585 = new int['耀'];
            if (var2) {
                class90.username = "";
                class90.password = "";
            }

            Size.field369 = 0;
            class37.field501 = "";
            class90.field1385 = true;
            class90.worldSelectShown = false;
            if (!Client.preferences.muted) {
                final IndexData var8 = PacketBuffer.indexTrack1;
                final int var6 = var8.getFile("scape main");
                final int var7 = var8.getChild(var6, "");
                class163.method3213(2, var8, var6, var7, 255, false);
            } else {
                class229.field2687 = 1;
                Client.field2511 = null;
                VertexNormal.field1931 = -1;
                GrandExchangeEvents.field284 = -1;
                class86.field1330 = 0;
                class229.field2692 = false;
                class2.field11 = 2;
            }

            GraphicsObject.sendConInfo(false);
            class90.field1387 = true;
            class90.field1359 = (GameEngine.canvasWidth - 765) / 2;
            class90.loginWindowX = class90.field1359 + 202;
            class171.field279 = class90.loginWindowX + 180;
            class321.field3938.method5856(class90.field1359, 0);
            class90.field1381.method5856(class90.field1359 + 382, 0);
            class171.logoSprite.method5825(class90.field1359 + 382 - class171.logoSprite.width / 2, 18);
        }
    }

    //Command processor
    static void method1231(final String command) {
        if (command.equalsIgnoreCase("toggleroof")) {
            Client.preferences.hideRoofs = !Client.preferences.hideRoofs;
            MouseInput.method1062();
            if (Client.preferences.hideRoofs) {
                class57.sendGameMessage(99, "", "Roofs are now all hidden");
            } else {
                class57.sendGameMessage(99, "", "Roofs will only be removed selectively");
            }
        }

        if (command.equalsIgnoreCase("displayfps")) {
            Client.displayFps = !Client.displayFps;
        }

        if (command.equalsIgnoreCase("renderself")) {
            Client.displaySelf = !Client.displaySelf;
        }

        if (command.equalsIgnoreCase("mouseovertext")) {
            Client.displayMouseOverText = !Client.displayMouseOverText;
        }

        if (Client.rights >= 2) {
            if (command.equalsIgnoreCase("aabb")) {
                if (!class7.drawBoundingBoxes3D) {
                    class7.drawBoundingBoxes3D = true;
                    class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ALWAYS;
                } else if (BoundingBox3DDrawMode.ALWAYS == class7.boundingBox3DDrawMode) {
                    class7.drawBoundingBoxes3D = true;
                    class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
                } else {
                    class7.drawBoundingBoxes3D = false;
                }
            }

            if (command.equalsIgnoreCase("showcoord")) {
                Preferences.renderOverview.field4016 = !Preferences.renderOverview.field4016;
            }

            if (command.equalsIgnoreCase("fpson")) {
                Client.displayFps = true;
            }

            if (command.equalsIgnoreCase("fpsoff")) {
                Client.displayFps = false;
            }

            if (command.equalsIgnoreCase("gc")) {
                System.gc();
            }

            if (command.equalsIgnoreCase("clientdrop")) {
                if (Client.field915 > 0) {
                    VarPlayerType.method4736();
                } else {
                    Client.field918.method5211();
                    class64.setGameState(40);
                    Client.field2069 = Client.field957.getSocket();
                    Client.field957.method2043();
                }
            }

            if (command.equalsIgnoreCase("cs")) {
                class57.sendGameMessage(99, "", "" + Client.field917);
            }

            if (command.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                throw new RuntimeException();
            }
        }

        final PacketNode var1 = WorldMapRectangle.method280(ClientPacket.field2415, Client.field957.field1484);
        var1.packetBuffer.putByte(command.length() + 1);
        var1.packetBuffer.putString(command);
        Client.field957.method2052(var1);
    }

    final void decodeApperance(final Buffer var1) {
        var1.offset = 0;
        final int var2 = var1.readUnsignedByte();
        this.skullIcon = var1.readByte();
        this.overheadIcon = var1.readByte();
        int var3 = -1;
        this.team = 0;
        final int[] var4 = new int[12];

        int var6;
        int var7;
        for (int var5 = 0; var5 < 12; ++var5) {
            var6 = var1.readUnsignedByte();
            if (var6 == 0) {
                var4[var5] = 0;
            } else {
                var7 = var1.readUnsignedByte();
                var4[var5] = var7 + (var6 << 8);
                if (var5 == 0 && var4[0] == 65535) {
                    var3 = var1.readUnsignedShort();
                    break;
                }

                if (var4[var5] >= 512) {
                    final int var8 = ItemComposition.getItemDefinition(var4[var5] - 512).team;
                    if (var8 != 0) {
                        this.team = var8;
                    }
                }
            }
        }

        final int[] var9 = new int[5];

        for (var6 = 0; var6 < 5; ++var6) {
            var7 = var1.readUnsignedByte();
            if (var7 < 0 || var7 >= PlayerComposition.colorsToReplace[var6].length) {
                var7 = 0;
            }

            var9[var6] = var7;
        }

        super.idlePoseAnimation = var1.readUnsignedShort();
        if (super.idlePoseAnimation == 65535) {
            super.idlePoseAnimation = -1;
        }

        super.field1163 = var1.readUnsignedShort();
        if (super.field1163 == 65535) {
            super.field1163 = -1;
        }

        super.field1164 = super.field1163;
        super.walkingAnimation = var1.readUnsignedShort();
        if (super.walkingAnimation == 65535) {
            super.walkingAnimation = -1;
        }

        super.rotate180Animation = var1.readUnsignedShort();
        if (super.rotate180Animation == 65535) {
            super.rotate180Animation = -1;
        }

        super.rotate90RightAnimation = var1.readUnsignedShort();
        if (super.rotate90RightAnimation == 65535) {
            super.rotate90RightAnimation = -1;
        }

        super.rotate90LeftAnimation = var1.readUnsignedShort();
        if (super.rotate90LeftAnimation == 65535) {
            super.rotate90LeftAnimation = -1;
        }

        super.field1169 = var1.readUnsignedShort();
        if (super.field1169 == 65535) {
            super.field1169 = -1;
        }

        this.name = new Name(var1.readString(), GZipDecompressor.loginType);
        this.method1188();
        this.method1191();
        if (this == Client.localPlayer) {
            RunException.field2194 = this.name.getName();
        }

        this.combatLevel = var1.readUnsignedByte();
        this.totalLevel = var1.readUnsignedShort();
        this.hidden = var1.readUnsignedByte() == 1;
        if (Client.socketType == 0 && Client.rights >= 2) {
            this.hidden = false;
        }

        if (this.composition == null) {
            this.composition = new PlayerComposition();
        }

        this.composition.method4396(var4, var9, var2 == 1, var3);
    }

    boolean isFriend() {
        if (this.field859 == class303.field3851) {
            this.method1189();
        }

        return this.field859 == class303.field3850;
    }

    void method1188() {
        this.field859 = class303.field3851;
    }

    private void method1189() {
        this.field859 = WorldMapRectangle.friendManager.method1776(this.name) ? class303.field3850 : class303.field3849;
    }

    boolean isClanMember() {
        if (this.field835 == class303.field3851) {
            this.method1206();
        }

        return this.field835 == class303.field3850;
    }

    void method1191() {
        this.field835 = class303.field3851;
    }

    private void method1206() {
        this.field835 = GameEngine.clanMemberManager != null && GameEngine.clanMemberManager.isMember(this.name) ? class303.field3850 : class303.field3849;
    }

    int getSize() {
        return this.composition != null && this.composition.transformedNpcId != -1 ? NPCComposition.getNpcDefinition(this.composition.transformedNpcId).size : 1;
    }

    final Model getModel() {
        if (this.composition == null) {
            return null;
        } else {
            final Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0 ? CombatInfo1.getAnimation(super.animation) : null;
            final Sequence var2 = super.poseAnimation == -1 || this.isLowDetail || super.idlePoseAnimation == super.poseAnimation && var1 != null ? null : CombatInfo1.getAnimation(super.poseAnimation);
            Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
            if (var3 == null) {
                return null;
            } else {
                var3.calculateBoundsCylinder();
                super.logicalHeight = var3.modelHeight;
                Model var4;
                Model[] var5;
                if (!this.isLowDetail && super.graphic != -1 && super.spotAnimFrame != -1) {
                    var4 = Spotanim.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
                    if (var4 != null) {
                        var4.offsetBy(0, -super.field1198, 0);
                        var5 = new Model[]{var3, var4};
                        var3 = new Model(var5, 2);
                    }
                }

                if (!this.isLowDetail && this.model != null) {
                    if (Client.gameCycle >= this.animationCycleEnd) {
                        this.model = null;
                    }

                    if (Client.gameCycle >= this.animationCycleStart && Client.gameCycle < this.animationCycleEnd) {
                        var4 = this.model;
                        var4.offsetBy(this.field845 - super.x, this.field858 - this.field842, this.field843 - super.y);
                        if (super.orientation == 512) {
                            var4.rotateY90Ccw();
                            var4.rotateY90Ccw();
                            var4.rotateY90Ccw();
                        } else if (super.orientation == 1024) {
                            var4.rotateY90Ccw();
                            var4.rotateY90Ccw();
                        } else if (super.orientation == 1536) {
                            var4.rotateY90Ccw();
                        }

                        var5 = new Model[]{var3, var4};
                        var3 = new Model(var5, 2);
                        if (super.orientation == 512) {
                            var4.rotateY90Ccw();
                        } else if (super.orientation == 1024) {
                            var4.rotateY90Ccw();
                            var4.rotateY90Ccw();
                        } else if (super.orientation == 1536) {
                            var4.rotateY90Ccw();
                            var4.rotateY90Ccw();
                            var4.rotateY90Ccw();
                        }

                        var4.offsetBy(super.x - this.field845, this.field842 - this.field858, super.y - this.field843);
                    }
                }

                var3.field1874 = true;
                return var3;
            }
        }
    }

    final void method1195(final int var1, final int var2, final byte var3) {
        if (super.animation != -1 && CombatInfo1.getAnimation(super.animation).priority == 1) {
            super.animation = -1;
        }

        super.field1185 = -1;
        if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
            if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
                if (var3 == 2) {
                    BaseVarType.method9(this, var1, var2, (byte) 2);
                }

                this.method1186(var1, var2, var3);
            } else {
                this.method1196(var1, var2);
            }
        } else {
            this.method1196(var1, var2);
        }

    }

    void method1196(final int var1, final int var2) {
        super.queueSize = 0;
        super.field1216 = 0;
        super.field1158 = 0;
        super.pathX[0] = var1;
        super.pathY[0] = var2;
        final int var3 = this.getSize();
        super.x = super.pathX[0] * 128 + var3 * 64;
        super.y = super.pathY[0] * 128 + var3 * 64;
    }

    final void method1186(final int pathX, final int PathY, final byte var3) {
        if (super.queueSize < 9) {
            ++super.queueSize;
        }

        for (int var4 = super.queueSize; var4 > 0; --var4) {
            super.pathX[var4] = super.pathX[var4 - 1];
            super.pathY[var4] = super.pathY[var4 - 1];
            super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
        }

        super.pathX[0] = pathX;
        super.pathY[0] = PathY;
        super.pathTraversed[0] = var3;
    }

    final boolean hasConfig() {
        return this.composition != null;
    }
}
