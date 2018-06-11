package com.oldscape.client.reference;

import java.io.IOException;

public class MilliTimer extends Timer {
    private final long[] field2181;
    private int field2180;
    private int sleepTime;
    private long field2183;
    private int field2184;
    private int field2185;

    public MilliTimer() {
        this.field2181 = new long[10];
        this.field2180 = 256;
        this.sleepTime = 1;
        this.field2184 = 0;
        this.field2183 = class64.method1118();

        for (int var1 = 0; var1 < 10; ++var1) {
            this.field2181[var1] = this.field2183;
        }

    }

    public static byte[] method3192() {
        final byte[] var0 = new byte[24];

        try {
            class167.randomDat.seek(0L);
            class167.randomDat.read(var0);

            int var1;
            for (var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            }

            if (var1 >= 24) {
                throw new IOException();
            }
        } catch (final Exception var4) {
            for (int var2 = 0; var2 < 24; ++var2) {
                var0[var2] = -1;
            }
        }

        return var0;
    }

    static void load() {
        int var0;
        if (Client.loadingStage == 0) {
            class255.region = new Region(4, 104, 104, class62.tileHeights);

            for (var0 = 0; var0 < 4; ++var0) {
                Client.collisionMaps[var0] = new CollisionData(104, 104);
            }

            BoundingBox2D.minimapSprite = new SpritePixels(512, 512);
            class90.loadingText = "Starting game engine...";
            class90.loadingBarPercentage = 5;
            Client.loadingStage = 20;
        } else {
            int var1;
            int var2;
            int var3;
            int var4;
            if (Client.loadingStage != 20) {
                if (Client.loadingStage == 30) {
                    class71.indexInterfaces = class196.openCacheIndex(0, false, true, true);
                    class93.indexSoundEffects = class196.openCacheIndex(1, false, true, true);
                    Size.configsIndex = class196.openCacheIndex(2, true, false, true);
                    WorldMapType3.indexCache3 = class196.openCacheIndex(3, false, true, true);
                    class55.indexCache4 = class196.openCacheIndex(4, false, true, true);
                    MouseRecorder.indexMaps = class196.openCacheIndex(5, true, true, true);
                    PacketBuffer.indexTrack1 = class196.openCacheIndex(6, true, true, true);
                    class18.indexModels = class196.openCacheIndex(7, false, true, true);
                    class151.indexSprites = class196.openCacheIndex(8, false, true, true);
                    GameCanvas.indexTextures = class196.openCacheIndex(9, false, true, true);
                    ClanMember.indexCache10 = class196.openCacheIndex(10, false, true, true);
                    class189.indexTrack2 = class196.openCacheIndex(11, false, true, true);
                    class190.indexScripts = class196.openCacheIndex(12, false, true, true);
                    KeyFocusListener.indexCache13 = class196.openCacheIndex(13, true, false, true);
                    MapCacheArchiveNames.vorbisIndex = class196.openCacheIndex(14, false, true, true);
                    MouseRecorder.indexCache15 = class196.openCacheIndex(15, false, true, true);
                    class95.indexWorldMap = class196.openCacheIndex(16, true, true, true);
                    class90.loadingText = "Connecting to update server";
                    class90.loadingBarPercentage = 20;
                    Client.loadingStage = 40;
                } else if (Client.loadingStage == 40) {
                    final byte var16 = 0;
                    var0 = var16 + class71.indexInterfaces.percentage() * 4 / 100;
                    var0 += class93.indexSoundEffects.percentage() * 4 / 100;
                    var0 += Size.configsIndex.percentage() * 2 / 100;
                    var0 += WorldMapType3.indexCache3.percentage() * 2 / 100;
                    var0 += class55.indexCache4.percentage() * 6 / 100;
                    var0 += MouseRecorder.indexMaps.percentage() * 4 / 100;
                    var0 += PacketBuffer.indexTrack1.percentage() * 2 / 100;
                    var0 += class18.indexModels.percentage() * 58 / 100;
                    var0 += class151.indexSprites.percentage() * 2 / 100;
                    var0 += GameCanvas.indexTextures.percentage() * 2 / 100;
                    var0 += ClanMember.indexCache10.percentage() * 2 / 100;
                    var0 += class189.indexTrack2.percentage() * 2 / 100;
                    var0 += class190.indexScripts.percentage() * 2 / 100;
                    var0 += KeyFocusListener.indexCache13.percentage() * 2 / 100;
                    var0 += MapCacheArchiveNames.vorbisIndex.percentage() * 2 / 100;
                    var0 += MouseRecorder.indexCache15.percentage() * 2 / 100;
                    var0 += class95.indexWorldMap.percentage() * 2 / 100;
                    if (var0 != 100) {
                        if (var0 != 0) {
                            class90.loadingText = "Checking for updates - " + var0 + "%";
                        }

                        class90.loadingBarPercentage = 30;
                    } else {
                        ScriptState.method1108(class71.indexInterfaces, "Animations");
                        ScriptState.method1108(class93.indexSoundEffects, "Skeletons");
                        ScriptState.method1108(class55.indexCache4, "Sound FX");
                        ScriptState.method1108(MouseRecorder.indexMaps, "Maps");
                        ScriptState.method1108(PacketBuffer.indexTrack1, "Music Tracks");
                        ScriptState.method1108(class18.indexModels, "Models");
                        ScriptState.method1108(class151.indexSprites, "Sprites");
                        ScriptState.method1108(class189.indexTrack2, "Music Jingles");
                        ScriptState.method1108(MapCacheArchiveNames.vorbisIndex, "Music Samples");
                        ScriptState.method1108(MouseRecorder.indexCache15, "Music Patches");
                        ScriptState.method1108(class95.indexWorldMap, "World Map");
                        class90.loadingText = "Loaded update list";
                        class90.loadingBarPercentage = 30;
                        Client.loadingStage = 45;
                    }
                } else if (Client.loadingStage == 45) {
                    CombatInfo1.method1677(22050, !Client.lowMemory, 2);
                    final class230 var20 = new class230();
                    var20.method4191(9, 128);
                    Client.soundSystem0 = class294.method5239(0, 22050);
                    Client.soundSystem0.method2206(var20);
                    class2.method3(MouseRecorder.indexCache15, MapCacheArchiveNames.vorbisIndex, class55.indexCache4, var20);
                    class71.soundSystem1 = class294.method5239(1, 2048);
                    MouseInput.field727 = new class100();
                    class71.soundSystem1.method2206(MouseInput.field727);
                    WorldMapDecoration.field446 = new Resampler(22050, AbstractSoundSystem.sampleRate);
                    class90.loadingText = "Prepared sound engine";
                    class90.loadingBarPercentage = 35;
                    Client.loadingStage = 50;
                    SceneTilePaint.fonts = new Fonts(class151.indexSprites, KeyFocusListener.indexCache13);
                } else if (Client.loadingStage == 50) {
                    final FontName[] var19 = {FontName.FontName_plain11, FontName.FontName_plain12, FontName.FontName_bold12, FontName.FontName_verdana_plain11, FontName.FontName_verdana_plain13, FontName.FontName_verdana_plain15};
                    var1 = var19.length;
                    final Fonts var21 = SceneTilePaint.fonts;
                    final FontName[] var22 = {FontName.FontName_plain11, FontName.FontName_plain12, FontName.FontName_bold12, FontName.FontName_verdana_plain11, FontName.FontName_verdana_plain13, FontName.FontName_verdana_plain15};
                    Client.fontsMap = var21.createMap(var22);
                    if (Client.fontsMap.size() < var1) {
                        class90.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
                        class90.loadingBarPercentage = 40;
                    } else {
                        class55.fontPlain11 = Client.fontsMap.get(FontName.FontName_plain11);
                        class20.font_p12full = Client.fontsMap.get(FontName.FontName_plain12);
                        MessageNode.fontBold12 = Client.fontsMap.get(FontName.FontName_bold12);
                        CombatInfo1.platformInfo = new MachineInfo(true);
                        class90.loadingText = "Loaded fonts";
                        class90.loadingBarPercentage = 40;
                        Client.loadingStage = 60;
                    }
                } else {
                    IndexData var12;
                    final IndexData var23;
                    if (Client.loadingStage == 60) {
                        var23 = ClanMember.indexCache10;
                        var12 = class151.indexSprites;
                        var3 = 0;
                        if (var23.tryLoadRecordByNames("title.jpg", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("logo", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("logo_deadman_mode", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("titlebox", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("titlebutton", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("runes", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("title_mute", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("options_radio_buttons,0", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("options_radio_buttons,2", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("options_radio_buttons,4", "")) {
                            ++var3;
                        }

                        if (var12.tryLoadRecordByNames("options_radio_buttons,6", "")) {
                            ++var3;
                        }

                        var12.tryLoadRecordByNames("sl_back", "");
                        var12.tryLoadRecordByNames("sl_flags", "");
                        var12.tryLoadRecordByNames("sl_arrows", "");
                        var12.tryLoadRecordByNames("sl_stars", "");
                        var12.tryLoadRecordByNames("sl_button", "");
                        var4 = MouseInput.method1066();
                        if (var3 < var4) {
                            class90.loadingText = "Loading title screen - " + var3 * 100 / var4 + "%";
                            class90.loadingBarPercentage = 50;
                        } else {
                            class90.loadingText = "Loaded title screen";
                            class90.loadingBarPercentage = 50;
                            class64.setGameState(5);
                            Client.loadingStage = 70;
                        }
                    } else if (Client.loadingStage == 70) {
                        if (!Size.configsIndex.method4624()) {
                            class90.loadingText = "Loading config - " + Size.configsIndex.loadPercent() + "%";
                            class90.loadingBarPercentage = 60;
                        } else {
                            TotalQuantityComparator.overlay_ref = Size.configsIndex;
                            class240.method4410(Size.configsIndex);
                            var23 = Size.configsIndex;
                            var12 = class18.indexModels;
                            KitDefinition.identKit_ref = var23;
                            KitDefinition.field3516 = var12;
                            KitDefinition.field3519 = KitDefinition.identKit_ref.fileCount(3);
                            class199.method3765(Size.configsIndex, class18.indexModels, Client.lowMemory);
                            final IndexData var13 = Size.configsIndex;
                            final IndexData var15 = class18.indexModels;
                            NPCComposition.NpcDefinition_indexCache = var13;
                            NPCComposition.NpcDefinition_modelIndexCache = var15;
                            class7.method29(Size.configsIndex);
                            final IndexData var5 = Size.configsIndex;
                            final IndexData var6 = class18.indexModels;
                            final boolean var7 = Client.isMembers;
                            final Font var8 = class55.fontPlain11;
                            ItemComposition.item_ref = var5;
                            ItemComposition.ItemDefinition_modelIndexCache = var6;
                            class158.isMembersWorld = var7;
                            AbstractSoundSystem.field1583 = ItemComposition.item_ref.fileCount(10);
                            WorldMapDecoration.field445 = var8;
                            Item.method1951(Size.configsIndex, class71.indexInterfaces, class93.indexSoundEffects);
                            Spotanim.method210(Size.configsIndex, class18.indexModels);
                            Varbit.varbit_ref = Size.configsIndex;
                            class151.method3130(Size.configsIndex);
                            Projectile.method1938(WorldMapType3.indexCache3, class18.indexModels, class151.indexSprites, KeyFocusListener.indexCache13);
                            class23.method189(Size.configsIndex);
                            Enum.method409(Size.configsIndex);
                            TextureProvider.method2592(Size.configsIndex);
                            class21.method172(Size.configsIndex);
                            ParamNode.param_ref = Size.configsIndex;
                            SceneTilePaint.varcs = new Varcs();
                            JagexGame.method4522(Size.configsIndex, class151.indexSprites, KeyFocusListener.indexCache13);
                            ObjectComposition.method5053(Size.configsIndex, class151.indexSprites);
                            Area.method1232(Size.configsIndex, class151.indexSprites);
                            class90.loadingText = "Loaded config";
                            class90.loadingBarPercentage = 60;
                            Client.loadingStage = 80;
                        }
                    } else if (Client.loadingStage == 80) {
                        var0 = 0;
                        SpritePixels var14;
                        if (class7.compass == null) {
                            var12 = class151.indexSprites;
                            var3 = var12.getFile("compass");
                            var4 = var12.getChild(var3, "");
                            var14 = class332.method817(var12, var3, var4);
                            class7.compass = var14;
                        } else {
                            ++var0;
                        }

                        if (Client.mapedge == null) {
                            var12 = class151.indexSprites;
                            var3 = var12.getFile("mapedge");
                            var4 = var12.getChild(var3, "");
                            var14 = class332.method817(var12, var3, var4);
                            Client.mapedge = var14;
                        } else {
                            ++var0;
                        }

                        if (GroundObject.mapscene == null) {
                            GroundObject.mapscene = WorldMapManager.getIndexedSprites(class151.indexSprites, "mapscene", "");
                        } else {
                            ++var0;
                        }

                        if (GameEngine.headIconsPk == null) {
                            GameEngine.headIconsPk = IndexDataBase.getSprites(class151.indexSprites, "headicons_pk", "");
                        } else {
                            ++var0;
                        }

                        if (Fonts.headIconsPrayer == null) {
                            Fonts.headIconsPrayer = IndexDataBase.getSprites(class151.indexSprites, "headicons_prayer", "");
                        } else {
                            ++var0;
                        }

                        if (BoundingBox3DDrawMode.headIconsHint == null) {
                            BoundingBox3DDrawMode.headIconsHint = IndexDataBase.getSprites(class151.indexSprites, "headicons_hint", "");
                        } else {
                            ++var0;
                        }

                        if (class19.mapMarkers == null) {
                            class19.mapMarkers = IndexDataBase.getSprites(class151.indexSprites, "mapmarker", "");
                        } else {
                            ++var0;
                        }

                        if (class248.crossSprites == null) {
                            class248.crossSprites = IndexDataBase.getSprites(class151.indexSprites, "cross", "");
                        } else {
                            ++var0;
                        }

                        if (WorldMapType4.mapDots == null) {
                            WorldMapType4.mapDots = IndexDataBase.getSprites(class151.indexSprites, "mapdots", "");
                        } else {
                            ++var0;
                        }

                        if (class18.scrollbarSprites == null) {
                            class18.scrollbarSprites = WorldMapManager.getIndexedSprites(class151.indexSprites, "scrollbar", "");
                        } else {
                            ++var0;
                        }

                        if (class3.modIconSprites == null) {
                            class3.modIconSprites = WorldMapManager.getIndexedSprites(class151.indexSprites, "mod_icons", "");
                        } else {
                            ++var0;
                        }

                        if (var0 < 11) {
                            class90.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                            class90.loadingBarPercentage = 70;
                        } else {
                            FontTypeFace.modIcons = class3.modIconSprites;
                            Client.mapedge.method5850();
                            var1 = (int) (Math.random() * 21.0D) - 10;
                            var2 = (int) (Math.random() * 21.0D) - 10;
                            var3 = (int) (Math.random() * 21.0D) - 10;
                            var4 = (int) (Math.random() * 41.0D) - 20;
                            GroundObject.mapscene[0].method5824(var4 + var1, var2 + var4, var3 + var4);
                            class90.loadingText = "Loaded sprites";
                            class90.loadingBarPercentage = 70;
                            Client.loadingStage = 90;
                        }
                    } else if (Client.loadingStage == 90) {
                        if (!GameCanvas.indexTextures.method4624()) {
                            class90.loadingText = "Loading textures - " + "0%";
                            class90.loadingBarPercentage = 90;
                        } else {
                            class243.field2961 = new TextureProvider(GameCanvas.indexTextures, class151.indexSprites, 20, 0.8D, Client.lowMemory ? 64 : 128);
                            Graphics3D.method2784(class243.field2961);
                            Graphics3D.setBrightness(0.8D);
                            Client.loadingStage = 100;
                        }
                    } else if (Client.loadingStage == 100) {
                        var0 = class243.field2961.method2572();
                        if (var0 < 100) {
                            class90.loadingText = "Loading textures - " + var0 + "%";
                            class90.loadingBarPercentage = 90;
                        } else {
                            class90.loadingText = "Loaded textures";
                            class90.loadingBarPercentage = 90;
                            Client.loadingStage = 110;
                        }
                    } else if (Client.loadingStage == 110) {
                        WorldMapType2.mouseRecorder = new MouseRecorder();
                        GameEngine.taskManager.createRunnable(WorldMapType2.mouseRecorder, 10);
                        class90.loadingText = "Loaded input handler";
                        class90.loadingBarPercentage = 92;
                        Client.loadingStage = 120;
                    } else if (Client.loadingStage == 120) {
                        if (!ClanMember.indexCache10.tryLoadRecordByNames("huffman", "")) {
                            class90.loadingText = "Loading wordpack - " + 0 + "%";
                            class90.loadingBarPercentage = 94;
                        } else {
                            class313.huffman = new Huffman(ClanMember.indexCache10.takeRecordByNames("huffman", ""));
                            class90.loadingText = "Loaded wordpack";
                            class90.loadingBarPercentage = 94;
                            Client.loadingStage = 130;
                        }
                    } else if (Client.loadingStage == 130) {
                        if (!WorldMapType3.indexCache3.method4624()) {
                            class90.loadingText = "Loading interfaces - " + WorldMapType3.indexCache3.loadPercent() * 4 / 5 + "%";
                            class90.loadingBarPercentage = 96;
                        } else if (!class190.indexScripts.method4624()) {
                            class90.loadingText = "Loading interfaces - " + (80 + class190.indexScripts.loadPercent() / 6) + "%";
                            class90.loadingBarPercentage = 96;
                        } else if (!KeyFocusListener.indexCache13.method4624()) {
                            class90.loadingText = "Loading interfaces - " + (96 + KeyFocusListener.indexCache13.loadPercent() / 50) + "%";
                            class90.loadingBarPercentage = 96;
                        } else {
                            class90.loadingText = "Loaded interfaces";
                            class90.loadingBarPercentage = 98;
                            Client.loadingStage = 140;
                        }
                    } else if (Client.loadingStage == 140) {
                        class90.loadingBarPercentage = 100;
                        if (!class95.indexWorldMap.tryLoadArchiveByName(MapCacheArchiveNames.DETAILS.name)) {
                            class90.loadingText = "Loading world map - " + class95.indexWorldMap.archiveLoadPercentByName(MapCacheArchiveNames.DETAILS.name) / 10 + "%";
                        } else {
                            if (Preferences.renderOverview == null) {
                                Preferences.renderOverview = new RenderOverview();
                                Preferences.renderOverview.method6006(class95.indexWorldMap, MessageNode.fontBold12, Client.fontsMap, GroundObject.mapscene);
                            }

                            var0 = Preferences.renderOverview.method6057();
                            if (var0 < 100) {
                                class90.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                            } else {
                                class90.loadingText = "Loaded world map";
                                Client.loadingStage = 150;
                            }
                        }
                    } else if (Client.loadingStage == 150) {
                        class64.setGameState(10);
                    }
                }
            } else {
                final int[] var11 = new int[9];

                for (var1 = 0; var1 < 9; ++var1) {
                    var2 = var1 * 32 + 15 + 128;
                    var3 = var2 * 3 + 600;
                    var4 = Graphics3D.SINE[var2];
                    var11[var1] = var3 * var4 >> 16;
                }

                Region.buildVisibilityMaps(var11, 500, 800, 512, 334);
                class90.loadingText = "Prepared visibility map";
                class90.loadingBarPercentage = 10;
                Client.loadingStage = 30;
            }
        }
    }

    public void vmethod3326() {
        for (int var1 = 0; var1 < 10; ++var1) {
            this.field2181[var1] = 0L;
        }

    }

    public int vmethod3328(final int var1, final int var2) {
        final int var3 = this.field2180;
        final int var4 = this.sleepTime;
        this.field2180 = 300;
        this.sleepTime = 1;
        this.field2183 = class64.method1118();
        if (this.field2181[this.field2185] == 0L) {
            this.field2180 = var3;
            this.sleepTime = var4;
        } else if (this.field2183 > this.field2181[this.field2185]) {
            this.field2180 = (int) ((var1 * 2560) / (this.field2183 - this.field2181[this.field2185]));
        }

        if (this.field2180 < 25) {
            this.field2180 = 25;
        }

        if (this.field2180 > 256) {
            this.field2180 = 256;
            this.sleepTime = (int) (var1 - (this.field2183 - this.field2181[this.field2185]) / 10L);
        }

        if (this.sleepTime > var1) {
            this.sleepTime = var1;
        }

        this.field2181[this.field2185] = this.field2183;
        this.field2185 = (this.field2185 + 1) % 10;
        int var5;
        if (this.sleepTime > 1) {
            for (var5 = 0; var5 < 10; ++var5) {
                if (this.field2181[var5] != 0L) {
                    this.field2181[var5] += this.sleepTime;
                }
            }
        }

        if (this.sleepTime < var2) {
            this.sleepTime = var2;
        }

        ScriptVarType.method11(this.sleepTime);

        for (var5 = 0; this.field2184 < 256; this.field2184 += this.field2180) {
            ++var5;
        }

        this.field2184 &= 255;
        return var5;
    }
}
