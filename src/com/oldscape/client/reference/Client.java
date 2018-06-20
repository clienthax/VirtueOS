package com.oldscape.client.reference;

import netscape.javascript.JSObject;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.Socket;
import java.util.*;

public final class Client extends GameEngine implements class302 {
    public static final NetWriter field957;
    static final boolean[] field1072;
    static final boolean[] field1074;
    static final boolean[] field1073;
    static final int gameDrawingMode;
    static final int[] widgetBoundsWidth;
    static final int[] widgetPositionX;
    static final int[] widgetPositionY;
    static final int[] widgetBoundsHeight;
    static final class71 field901;
    static final com.oldscape.client.reference.Deque field1066;
    static final GrandExchangeOffer[] grandExchangeOffers;
    static final int[] field1034;
    static final int[] field1131;
    static final int[] field984;
    static final ArrayList<class64> field871;
    static final PlayerComposition field1132;
    static final int[] audioDelays;
    static final SoundEffect[] audioEffects;
    static final int[] queuedSoundEffectIDs;
    static final int[] soundLocations;
    static final boolean[] field955;
    static final int[] unknownSoundValues1;
    static final SpritePixels[] mapIcons;
    static final int[] field1094;
    static final int[] field1095;
    static final int[] field968;
    static final int[] interfaceItemTriggers;
    static final com.oldscape.client.reference.Deque field1067;
    static final int[] field1089;
    static final com.oldscape.client.reference.Deque field1125;
    static final int[] field1006;
    static final int[] field942;
    static final int[] field939;
    static final int[] field1116;
    static final OwnWorldComparator field1134;
    static final int[] field1057;
    static final int[] field1082;
    static final CollisionData[] collisionMaps;
    static final boolean field878;
    static final NPC[] cachedNPCs;
    static final int[] npcIndices;
    static final int[] pendingNpcFlagsIndices;
    static final class294 field918;
    static final int[][][] instanceTemplateChunks;
    static final int[] field929;
    static final int field932;
    static final int field933;
    static final int field869;
    static final int field875;
    static final int field944;
    static final int[] overheadTextsX;
    static final int[] overheadTextsY;
    static final int[] overheadTextsOffsetY;
    static final int[] overheadTextsOffsetX;
    static final int[] field962;
    static final int[] field963;
    static final int[] overheadTextsCyclesRemaining;
    static final String[] overheadTexts;
    static final int[][] field966;
    static final Player[] cachedPlayers;
    static final int[] field1027;
    static final int[] playerMenuTypes;
    static final String[] playerOptions;
    static final boolean[] playerOptionsPriorities;
    static final int[] field995;
    static final com.oldscape.client.reference.Deque[][][] groundItemDeque;
    static final com.oldscape.client.reference.Deque projectiles;
    static final com.oldscape.client.reference.Deque graphicsObjectDeque;
    static final int[] boostedSkillLevels;
    static final int[] realSkillLevels;
    static final int[] skillExperiences;
    static final int[] menuActionParams0;
    static final int[] menuActionParams1;
    static final int[] menuTypes;
    static final int[] menuIdentifiers;
    static final String[] menuOptions;
    static final String[] menuTargets;
    static final boolean[] menuBooleanArray;
    static final int field1021;
    private static final long[] field1077;
    private static final boolean field1045;
    public static IndexDataBase field2511;
    public static int world;
    public static boolean isMembers;
    public static int rights;
    static int widgetCount;
    static int field1071;
    static long field1080;
    static Preferences preferences;
    static int cycleCntr;
    static boolean isResized;
    static int field1135;
    static int field1060;
    static boolean field1102;
    static HashTable widgetFlags;
    static int field1084;
    static int publicChatMode;
    static int field951;
    static int mouseWheelRotation;
    static int field1062;
    static int field1054;
    static int field1099;
    static int field881;
    static int field1044;
    static int destinationX;
    static int destinationY;
    static int field935;
    static int queuedSoundEffectCount;
    static int field1138;
    static int field996;
    static int field1064;
    static int field1026;
    static int field1075;
    static boolean field1111;
    static int field1093;
    static int field967;
    static long field1091;
    static int field952;
    static int field1056;
    static short field1118;
    static short field1120;
    static short field1123;
    static short field911;
    static short field1122;
    static short field1018;
    static short field1104;
    static short field1121;
    static int scale;
    static int viewportWidth;
    static int viewportHeight;
    static int Viewport_xOffset;
    static int Viewport_yOffset;
    static int field1063;
    static String field1085;
    static int chatCycle;
    static UrlRequest listFetcher;
    static class169 field2069;
    static int field416;
    static int cameraYaw;
    static int field3697;
    static int[][] field1354;
    static int[] field1356;
    static AbstractSoundSystem soundSystem0;
    static Player localPlayer;
    static BuildType field1920;
    static int[] field3314;
    static int field1052;
    static int flags;
    static int socketType;
    static boolean lowMemory;
    static int languageId;
    static String field876;
    static int gameState;
    static boolean field880;
    static int gameCycle;
    static long mouseLastLastPressedTimeMillis;
    static int field885;
    static boolean field886;
    static boolean displayFps;
    static int field888;
    static int hintArrowTargetType;
    static int hintArrowNpcTargetIdx;
    static int hintArrowPlayerTargetIdx;
    static int hintArrowX;
    static int hintArrowY;
    static int hintArrowOffsetZ;
    static int hintArrowOffsetX;
    static int hintArrowOffsetY;
    static AttackOption playerAttackOption;
    static AttackOption npcAttackOption;
    static int loadingStage;
    static int loginState;
    static int field983;
    static int field905;
    static class158 field907;
    static byte[] field908;
    static int npcIndexesCount;
    static int pendingNpcFlagsCount;
    static int field915;
    static boolean socketError;
    static boolean field917;
    static HashMap<FontName, Font> fontsMap;
    static int field920;
    static int field921;
    static int field922;
    static int field923;
    static int field924;
    static byte[][] field1139;
    static boolean isDynamicRegion;
    static int field930;
    static SpritePixels mapedge;
    static boolean field936;
    static int field919;
    static int cameraPitchTarget;
    static int mapAngle;
    static int field940;
    static int field941;
    static int field897;
    static int field943;
    static int field960;
    static int field945;
    static int field946;
    static int field947;
    static int field948;
    static int field1059;
    static int field950;
    static int field970;
    static boolean field1061;
    static int field884;
    static int overheadTextCount;
    static int field1137;
    static int screenX;
    static int screenY;
    static int lastLeftClickX;
    static int lastLeftClickY;
    static int field972;
    static int cursorState;
    static boolean field974;
    static int mouseCrosshair;
    static int pressedItemIndex;
    static String lastSelectedItemName;
    static int field977;
    static int field978;
    static int field912;
    static int field980;
    static int itemPressedDuration;
    static int myPlayerIndex;
    static boolean field1097;
    static int localInteractingIndex;
    static int field987;
    static boolean displaySelf;
    static int playerNameMask;
    static int field990;
    static int field1112;
    static com.oldscape.client.reference.Deque pendingSpawns;
    static int field1004;
    static boolean isMenuOpen;
    static int menuOptionCount;
    static boolean field1014;
    static boolean field981;
    static boolean field1016;
    static boolean displayMouseOverText;
    static int field991;
    static int field1019;
    static int field1115;
    static int itemSelectionState;
    static boolean spellSelected;
    static int field1025;
    static int field893;
    static String field1092;
    static String field1028;
    static int widgetRoot;
    static HashTable componentTable;
    static int field1031;
    static int field1096;
    static Widget field1033;
    static int energy;
    static int weight;
    static int field1048;
    static boolean field1020;
    static Widget field1039;
    static Widget draggedWidget;
    static Widget field937;
    static int field1042;
    static int field1114;
    static Widget draggedOnWidget;
    static boolean field1053;
    static int field1008;
    static int field1047;
    static boolean field958;
    static int field1049;
    static int field882;
    static boolean draggingWidget;
    private static int field1087;
    private static int field877;
    private static int field883;
    private static int field1113;
    private static int js5State;
    private static int field1046;
    private static int errorCount;
    private static int field906;
    private static int field953;
    private static boolean field954;
    private static boolean field1051;

    static {
        field1045 = true;
        world = 1;
        flags = 0;
        socketType = 0;
        isMembers = false;
        lowMemory = false;
        languageId = 0;
        field877 = -1;
        field878 = false;
        gameState = 0;
        field880 = true;
        gameCycle = 0;
        mouseLastLastPressedTimeMillis = 1L;
        field883 = -1;
        field1113 = -1;
        field885 = -1;
        field886 = true;
        displayFps = false;
        field888 = 0;
        hintArrowTargetType = 0;
        hintArrowNpcTargetIdx = 0;
        hintArrowPlayerTargetIdx = 0;
        hintArrowX = 0;
        hintArrowY = 0;
        hintArrowOffsetZ = 0;
        hintArrowOffsetX = 0;
        hintArrowOffsetY = 0;
        playerAttackOption = AttackOption.AttackOption_hidden;
        npcAttackOption = AttackOption.AttackOption_hidden;
        loadingStage = 0;
        js5State = 0;
        field1046 = 0;
        errorCount = 0;
        loginState = 0;
        field983 = 0;
        field905 = 0;
        field906 = 0;
        field907 = class158.field2172;
        field908 = null;
        cachedNPCs = new NPC['耀'];
        npcIndexesCount = 0;
        npcIndices = new int['耀'];
        pendingNpcFlagsCount = 0;
        pendingNpcFlagsIndices = new int[250];
        field957 = new NetWriter();
        field915 = 0;
        socketError = false;
        field917 = true;
        field918 = new class294();
        fontsMap = new HashMap<>();
        field920 = 0;
        field921 = 1;
        field922 = 0;
        field923 = 1;
        field924 = 0;
        collisionMaps = new CollisionData[4];
        isDynamicRegion = false;
        instanceTemplateChunks = new int[4][13][13];
        field929 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        field930 = 0;
        field932 = 2301979;
        field933 = 5063219;
        field869 = 3353893;
        field875 = 7759444;
        field936 = false;
        field919 = 0;
        cameraPitchTarget = 128;
        mapAngle = 0;
        field940 = 0;
        field941 = 0;
        field897 = 0;
        field943 = 0;
        field960 = 0;
        field945 = 50;
        field946 = 0;
        field947 = 0;
        field948 = 0;
        field1059 = 12;
        field950 = 6;
        field970 = 0;
        field1061 = false;
        field953 = 0;
        field954 = false;
        field884 = 0;
        overheadTextCount = 0;
        field944 = 50;
        overheadTextsX = new int[field944];
        overheadTextsY = new int[field944];
        overheadTextsOffsetY = new int[field944];
        overheadTextsOffsetX = new int[field944];
        field962 = new int[field944];
        field963 = new int[field944];
        overheadTextsCyclesRemaining = new int[field944];
        overheadTexts = new String[field944];
        field966 = new int[104][104];
        field1137 = 0;
        screenX = -1;
        screenY = -1;
        lastLeftClickX = 0;
        lastLeftClickY = 0;
        field972 = 0;
        cursorState = 0;
        field974 = true;
        mouseCrosshair = 0;
        pressedItemIndex = 0;
        field977 = 0;
        field978 = 0;
        field912 = 0;
        field980 = 0;
        field1051 = false;
        itemPressedDuration = 0;
        myPlayerIndex = 0;
        field1097 = true;
        cachedPlayers = new Player[2048];
        localInteractingIndex = -1;
        field987 = 0;
        displaySelf = true;
        playerNameMask = 0;
        field990 = 0;
        field1027 = new int[1000];
        playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
        playerOptions = new String[8];
        playerOptionsPriorities = new boolean[8];
        field995 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        field1112 = -1;
        groundItemDeque = new com.oldscape.client.reference.Deque[4][104][104];
        pendingSpawns = new com.oldscape.client.reference.Deque();
        projectiles = new com.oldscape.client.reference.Deque();
        graphicsObjectDeque = new com.oldscape.client.reference.Deque();
        boostedSkillLevels = new int[25];
        realSkillLevels = new int[25];
        skillExperiences = new int[25];
        field1004 = 0;
        isMenuOpen = false;
        menuOptionCount = 0;
        menuActionParams0 = new int[500];
        menuActionParams1 = new int[500];
        menuTypes = new int[500];
        menuIdentifiers = new int[500];
        menuOptions = new String[500];
        menuTargets = new String[500];
        menuBooleanArray = new boolean[500];
        field1014 = false;
        field981 = false;
        field1016 = false;
        displayMouseOverText = true;
        field991 = -1;
        field1019 = -1;
        field1115 = 0;
        field1021 = 50;
        itemSelectionState = 0;
        lastSelectedItemName = null;
        spellSelected = false;
        field1025 = -1;
        field893 = -1;
        field1092 = null;
        field1028 = null;
        widgetRoot = -1;
        componentTable = new HashTable(8);
        field1031 = 0;
        field1096 = 0;
        field1033 = null;
        energy = 0;
        weight = 0;
        rights = 0;
        field1048 = -1;
        field1020 = false;
        field1039 = null;
        draggedWidget = null;
        field937 = null;
        field1042 = 0;
        field1114 = 0;
        draggedOnWidget = null;
        field1053 = false;
        field1008 = -1;
        field1047 = -1;
        field958 = false;
        field1049 = -1;
        field882 = -1;
        draggingWidget = false;
        cycleCntr = 1;
        field984 = new int[32];
        field1054 = 0;
        interfaceItemTriggers = new int[32];
        field1056 = 0;
        field1057 = new int[32];
        field1052 = 0;
        chatCycle = 0;
        field1060 = 0;
        field967 = 0;
        field1062 = 0;
        field1063 = 0;
        field1064 = 0;
        mouseWheelRotation = 0;
        field1066 = new com.oldscape.client.reference.Deque();
        field1067 = new com.oldscape.client.reference.Deque();
        field1125 = new com.oldscape.client.reference.Deque();
        widgetFlags = new HashTable(512);
        widgetCount = 0;
        field1071 = -2;
        field1072 = new boolean[100];
        field1073 = new boolean[100];
        field1074 = new boolean[100];
        widgetPositionX = new int[100];
        widgetPositionY = new int[100];
        widgetBoundsWidth = new int[100];
        widgetBoundsHeight = new int[100];
        gameDrawingMode = 0;
        field1080 = 0L;
        isResized = true;
        field1082 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
        publicChatMode = 0;
        field1084 = 0;
        field1085 = "";
        field1077 = new long[100];
        field1087 = 0;
        field952 = 0;
        field1089 = new int[128];
        field968 = new int[128];
        field1091 = -1L;
        field881 = -1;
        field1093 = 0;
        field1094 = new int[1000];
        field1095 = new int[1000];
        mapIcons = new SpritePixels[1000];
        destinationX = 0;
        destinationY = 0;
        field1099 = 0;
        field996 = 255;
        field1026 = -1;
        field1102 = false;
        field1075 = 127;
        field951 = 127;
        queuedSoundEffectCount = 0;
        queuedSoundEffectIDs = new int[50];
        unknownSoundValues1 = new int[50];
        audioDelays = new int[50];
        soundLocations = new int[50];
        audioEffects = new SoundEffect[50];
        field1111 = false;
        field955 = new boolean[5];
        field942 = new int[5];
        field1006 = new int[5];
        field939 = new int[5];
        field1116 = new int[5];
        field1120 = 256;
        field1118 = 205;
        field1018 = 256;
        field1104 = 320;
        field1121 = 1;
        field1122 = 32767;
        field1123 = 1;
        field911 = 32767;
        Viewport_xOffset = 0;
        Viewport_yOffset = 0;
        viewportWidth = 0;
        viewportHeight = 0;
        scale = 0;
        field1132 = new PlayerComposition();
        field1044 = -1;
        field1138 = -1;
        grandExchangeOffers = new GrandExchangeOffer[8];
        field1134 = new OwnWorldComparator();
        field1135 = -1;
        field871 = new ArrayList<>(10);
        field935 = 0;
        field901 = new class71();
        field1034 = new int[50];
        field1131 = new int[50];
    }

    static void method1903(final int var0, final int var1) {
        if (menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
            if (displayMouseOverText) {
                final int var2 = menuOptionCount - 1;
                String var4;
                if (itemSelectionState == 1 && menuOptionCount < 2) {
                    var4 = "Use" + " " + lastSelectedItemName + " " + "->";
                } else if (spellSelected && menuOptionCount < 2) {
                    var4 = field1092 + " " + field1028 + " " + "->";
                } else {
                    final String var5;
                    if (var2 < 0) {
                        var5 = "";
                    } else if (!menuTargets[var2].isEmpty()) {
                        var5 = menuOptions[var2] + " " + menuTargets[var2];
                    } else {
                        var5 = menuOptions[var2];
                    }

                    var4 = var5;
                }

                if (menuOptionCount > 2) {
                    var4 = var4 + class45.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
                }

                MessageNode.fontBold12.drawRandomizedMouseoverText(var4, var0 + 4, var1 + 15, 16777215, 0, gameCycle / 1000);
            }
        }
    }

    static void method3165() {
        class229.field2690.method4140();
        class229.field2687 = 1;
        field2511 = null;
    }

    static void method411(final int var0, final int var1, final int var2, final int var3) {
        for (int var4 = 0; var4 < widgetCount; ++var4) {
            if (widgetBoundsWidth[var4] + widgetPositionX[var4] > var0 && widgetPositionX[var4] < var0 + var2 && widgetPositionY[var4] + widgetBoundsHeight[var4] > var1 && widgetPositionY[var4] < var3 + var1) {
                field1072[var4] = true;
            }
        }

    }

    static void method1681(final String var0, final boolean var1) {
        if (field1097) {
            final byte var2 = 4;
            final int var3 = var2 + 6;
            final int var4 = var2 + 6;
            final int var5 = class20.font_p12full.method5507(var0, 250);
            final int var6 = class20.font_p12full.method5508(var0, 250) * 13;
            Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 0);
            Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
            class20.font_p12full.method5514(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
            method411(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2);
            if (var1) {
                MapCacheArchiveNames.rasterProvider.drawFull(0, 0);
            } else {

                for (int var11 = 0; var11 < widgetCount; ++var11) {
                    if (widgetBoundsWidth[var11] + widgetPositionX[var11] > var3 && widgetPositionX[var11] < var5 + var3 && widgetPositionY[var11] + widgetBoundsHeight[var11] > var4 && widgetPositionY[var11] < var6 + var4) {
                        field1073[var11] = true;
                    }
                }
            }

        }
    }

    static void method234(final Actor actor) {
        if (actor.field1166 > gameCycle) {
            final int var2 = actor.field1166 - gameCycle;
            final int var3 = actor.field1203 * 128 + actor.size * 64;
            final int var4 = actor.field1199 * 128 + actor.size * 64;
            actor.x += (var3 - actor.x) / var2;
            actor.y += (var4 - actor.y) / var2;
            actor.field1158 = 0;
            actor.orientation = actor.field1171;
        } else if (actor.field1204 >= gameCycle) {
            ObjectComposition.method5018(actor);
        } else {
            GrandExchangeOffer.method125(actor);
        }

        if (actor.x < 128 || actor.y < 128 || actor.x >= 13184 || actor.y >= 13184) {
            actor.animation = -1;
            actor.graphic = -1;
            actor.field1166 = 0;
            actor.field1204 = 0;
            actor.x = actor.pathX[0] * 128 + actor.size * 64;
            actor.y = actor.pathY[0] * 128 + actor.size * 64;
            actor.method1655();
        }

        if (localPlayer == actor && (actor.x < 1536 || actor.y < 1536 || actor.x >= 11776 || actor.y >= 11776)) {
            actor.animation = -1;
            actor.graphic = -1;
            actor.field1166 = 0;
            actor.field1204 = 0;
            actor.x = actor.pathX[0] * 128 + actor.size * 64;
            actor.y = actor.pathY[0] * 128 + actor.size * 64;
            actor.method1655();
        }

        class46.method685(actor);
        BoundingBox.method44(actor);
    }

    static void method400(final int widgetID, final int var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
        if (class189.loadWidget(widgetID)) {
            class319.method5651(MouseRecorder.widgets[widgetID], -1, var1, var2, var3, var4, var5, var6);
        }
    }

    static void decodeMovement(final PacketBuffer buffer, final int playerIdx) {
        final boolean var2 = buffer.getBits(1) == 1;
        if (var2) {
            class93.field1439[++class93.field1438 - 1] = playerIdx;
        }

        final int var3 = buffer.getBits(2);
        final Player cachedPlayer = cachedPlayers[playerIdx];
        if (var3 == 0) {
            if (var2) {
                cachedPlayer.field860 = false;
            } else if (localInteractingIndex == playerIdx) {
                throw new RuntimeException();
            } else {
                class93.Players_regions[playerIdx] = (cachedPlayer.plane << 28) + (class138.baseX + cachedPlayer.pathX[0] >> 13 << 14) + (class23.baseY + cachedPlayer.pathY[0] >> 13);
                if (cachedPlayer.field1185 != -1) {
                    class93.Players_orientations[playerIdx] = cachedPlayer.field1185;
                } else {
                    class93.Players_orientations[playerIdx] = cachedPlayer.orientation;
                }

                class93.Players_targetIndices[playerIdx] = cachedPlayer.interacting;
                cachedPlayers[playerIdx] = null;
                if (buffer.getBits(1) != 0) {
                    ScriptEvent.decodeRegionHash(buffer, playerIdx);
                }

            }
        } else {
            final int var5;
            int var6;
            int var7;
            if (var3 == 1) {
                var5 = buffer.getBits(3);
                var6 = cachedPlayer.pathX[0];
                var7 = cachedPlayer.pathY[0];
                if (var5 == 0) {
                    --var6;
                    --var7;
                } else if (var5 == 1) {
                    --var7;
                } else if (var5 == 2) {
                    ++var6;
                    --var7;
                } else if (var5 == 3) {
                    --var6;
                } else if (var5 == 4) {
                    ++var6;
                } else if (var5 == 5) {
                    --var6;
                    ++var7;
                } else if (var5 == 6) {
                    ++var7;
                } else if (var5 == 7) {
                    ++var6;
                    ++var7;
                }

                if (localInteractingIndex == playerIdx && (cachedPlayer.x < 1536 || cachedPlayer.y < 1536 || cachedPlayer.x >= 11776 || cachedPlayer.y >= 11776)) {
                    cachedPlayer.method1196(var6, var7);
                    cachedPlayer.field860 = false;
                } else if (var2) {
                    cachedPlayer.field860 = true;
                    cachedPlayer.field861 = var6;
                    cachedPlayer.field837 = var7;
                } else {
                    cachedPlayer.field860 = false;
                    cachedPlayer.method1195(var6, var7, class93.field1429[playerIdx]);
                }

            } else if (var3 == 2) {
                var5 = buffer.getBits(4);
                var6 = cachedPlayer.pathX[0];
                var7 = cachedPlayer.pathY[0];
                if (var5 == 0) {
                    var6 -= 2;
                    var7 -= 2;
                } else if (var5 == 1) {
                    --var6;
                    var7 -= 2;
                } else if (var5 == 2) {
                    var7 -= 2;
                } else if (var5 == 3) {
                    ++var6;
                    var7 -= 2;
                } else if (var5 == 4) {
                    var6 += 2;
                    var7 -= 2;
                } else if (var5 == 5) {
                    var6 -= 2;
                    --var7;
                } else if (var5 == 6) {
                    var6 += 2;
                    --var7;
                } else if (var5 == 7) {
                    var6 -= 2;
                } else if (var5 == 8) {
                    var6 += 2;
                } else if (var5 == 9) {
                    var6 -= 2;
                    ++var7;
                } else if (var5 == 10) {
                    var6 += 2;
                    ++var7;
                } else if (var5 == 11) {
                    var6 -= 2;
                    var7 += 2;
                } else if (var5 == 12) {
                    --var6;
                    var7 += 2;
                } else if (var5 == 13) {
                    var7 += 2;
                } else if (var5 == 14) {
                    ++var6;
                    var7 += 2;
                } else if (var5 == 15) {
                    var6 += 2;
                    var7 += 2;
                }

                if (localInteractingIndex == playerIdx && (cachedPlayer.x < 1536 || cachedPlayer.y < 1536 || cachedPlayer.x >= 11776 || cachedPlayer.y >= 11776)) {
                    cachedPlayer.method1196(var6, var7);
                    cachedPlayer.field860 = false;
                } else if (var2) {
                    cachedPlayer.field860 = true;
                    cachedPlayer.field861 = var6;
                    cachedPlayer.field837 = var7;
                } else {
                    cachedPlayer.field860 = false;
                    cachedPlayer.method1195(var6, var7, class93.field1429[playerIdx]);
                }

            } else {
                var5 = buffer.getBits(1);
                int var8;
                int var9;
                final int var10;
                final int var11;
                if (var5 == 0) {
                    var6 = buffer.getBits(12);
                    var7 = var6 >> 10;
                    var8 = var6 >> 5 & 31;
                    if (var8 > 15) {
                        var8 -= 32;
                    }

                    var9 = var6 & 31;
                    if (var9 > 15) {
                        var9 -= 32;
                    }

                    var10 = var8 + cachedPlayer.pathX[0];
                    var11 = var9 + cachedPlayer.pathY[0];

                } else {
                    var6 = buffer.getBits(30);
                    var7 = var6 >> 28;
                    var8 = var6 >> 14 & 16383;
                    var9 = var6 & 16383;
                    var10 = (var8 + class138.baseX + cachedPlayer.pathX[0] & 16383) - class138.baseX;
                    var11 = (var9 + class23.baseY + cachedPlayer.pathY[0] & 16383) - class23.baseY;

                }
                if (localInteractingIndex != playerIdx || cachedPlayer.x >= 1536 && cachedPlayer.y >= 1536 && cachedPlayer.x < 11776 && cachedPlayer.y < 11776) {
                    if (var2) {
                        cachedPlayer.field860 = true;
                        cachedPlayer.field861 = var10;
                        cachedPlayer.field837 = var11;
                    } else {
                        cachedPlayer.field860 = false;
                        cachedPlayer.method1195(var10, var11, class93.field1429[playerIdx]);
                    }
                } else {
                    cachedPlayer.method1196(var10, var11);
                    cachedPlayer.field860 = false;
                }
                cachedPlayer.plane = (byte) (var7 + cachedPlayer.plane & 3);
                if (localInteractingIndex == playerIdx) {
                    BoundingBox3DDrawMode.plane = cachedPlayer.plane;
                }
            }
        }
    }

    static void method3432(final int var0) {
        if (var0 >= 0) {
            final int var1 = menuActionParams0[var0];
            final int var2 = menuActionParams1[var0];
            final int var3 = menuTypes[var0];
            final int var4 = menuIdentifiers[var0];
            final String var6 = menuTargets[var0];
            PacketBuffer.menuAction(var1, var2, var3, var4, var6, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
        }
    }

    public static byte charToByteCp1252(final char var0) {
        final byte var1;
        if (var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
            var1 = (byte) var0;
        } else if (var0 == 8364) {
            var1 = -128;
        } else if (var0 == 8218) {
            var1 = -126;
        } else if (var0 == 402) {
            var1 = -125;
        } else if (var0 == 8222) {
            var1 = -124;
        } else if (var0 == 8230) {
            var1 = -123;
        } else if (var0 == 8224) {
            var1 = -122;
        } else if (var0 == 8225) {
            var1 = -121;
        } else if (var0 == 710) {
            var1 = -120;
        } else if (var0 == 8240) {
            var1 = -119;
        } else if (var0 == 352) {
            var1 = -118;
        } else if (var0 == 8249) {
            var1 = -117;
        } else if (var0 == 338) {
            var1 = -116;
        } else if (var0 == 381) {
            var1 = -114;
        } else if (var0 == 8216) {
            var1 = -111;
        } else if (var0 == 8217) {
            var1 = -110;
        } else if (var0 == 8220) {
            var1 = -109;
        } else if (var0 == 8221) {
            var1 = -108;
        } else if (var0 == 8226) {
            var1 = -107;
        } else if (var0 == 8211) {
            var1 = -106;
        } else if (var0 == 8212) {
            var1 = -105;
        } else if (var0 == 732) {
            var1 = -104;
        } else if (var0 == 8482) {
            var1 = -103;
        } else if (var0 == 353) {
            var1 = -102;
        } else if (var0 == 8250) {
            var1 = -101;
        } else if (var0 == 339) {
            var1 = -100;
        } else if (var0 == 382) {
            var1 = -98;
        } else if (var0 == 376) {
            var1 = -97;
        } else {
            var1 = 63;
        }

        return var1;
    }

    static int method1503(final World var0, final World var1, final int var2, final boolean var3, final int var4, final boolean var5) {
        final int var6 = ScriptState.method1110(var0, var1, var2, var3);
        if (var6 != 0) {
            return var3 ? -var6 : var6;
        } else if (var4 == -1) {
            return 0;
        } else {
            final int var7 = ScriptState.method1110(var0, var1, var4, var5);
            return var5 ? -var7 : var7;
        }
    }

    private void setItemTableSlot(final int var0, final int var1, final int var2, final int var3) {
        ItemContainer var4 = (ItemContainer) ItemContainer.itemContainers.get(var0);
        if (var4 == null) {
            var4 = new ItemContainer();
            ItemContainer.itemContainers.put(var4, var0);
        }

        if (var4.itemIds.length <= var1) {
            final int[] var5 = new int[var1 + 1];
            final int[] var6 = new int[var1 + 1];

            int var7;
            for (var7 = 0; var7 < var4.itemIds.length; ++var7) {
                var5[var7] = var4.itemIds[var7];
                var6[var7] = var4.stackSizes[var7];
            }

            for (var7 = var4.itemIds.length; var7 < var1; ++var7) {
                var5[var7] = -1;
                var6[var7] = 0;
            }

            var4.itemIds = var5;
            var4.stackSizes = var6;
        }

        var4.itemIds[var1] = var2;
        var4.stackSizes[var1] = var3;
    }

    protected final void vmethod1262() {
        field1080 = class64.method1118() + 500L;
        this.method1263();
        if (widgetRoot != -1) {
            this.method1345(true);
        }

    }

    protected final void setUp() {
        Renderable.method3051(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
        class228.port1 = socketType == 0 ? 43594 : world + 40000;
        class243.port2 = socketType == 0 ? 443 : world + 50000;
        class138.myWorldPort = class228.port1;
        PlayerComposition.colorsToFind = class240.colorsToFind;
        PlayerComposition.colorsToReplace = class240.colorsToReplace;
        PlayerComposition.colorsToFind2 = class240.colorsToFind2;
        PlayerComposition.colorsToReplace2 = class240.colorsToReplace2;
        MapIconReference.urlRequester = new UrlRequester();
        this.setUpKeyboard();
        this.setUpMouse();
        class90.mouseWheel = this.mouseWheel();
        class19.indexStore255 = new IndexFile(255, class167.dat2File, class167.idx255File, 500000);
        FileOnDisk var2 = null;
        Preferences var3 = new Preferences();

        try {
            var2 = NPC.getPreferencesFile("", class265.field3435.name, false);
            final byte[] var4 = new byte[(int) var2.length()];

            int var6;
            for (int var5 = 0; var5 < var4.length; var5 += var6) {
                var6 = var2.read(var4, var5, var4.length - var5);
                if (var6 == -1) {
                    throw new IOException();
                }
            }

            var3 = new Preferences(new Buffer(var4));
        } catch (final Exception ignored) {
        }

        try {
            if (var2 != null) {
                var2.close();
            }
        } catch (final Exception ignored) {
        }

        preferences = var3;
        this.setUpClipboard();
        GrandExchangeEvents.method76(this, WorldMapType2.field515);
        if (socketType != 0) {
            displayFps = true;
        }

        GameCanvas.method832(preferences.screenType);
        WorldMapRectangle.friendManager = new FriendManager(GZipDecompressor.loginType);
    }

    protected final void packetHandler() {
        ++gameCycle;
        this.processJS5Connection();

        while (true) {
            final FileSystem fileSystem;
            synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
                fileSystem = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
            }

            if (fileSystem == null) {
                int var50;
                try {
                    if (class229.field2687 == 1) {
                        var50 = class229.field2690.method4250();
                        if (var50 > 0 && class229.field2690.method4151()) {
                            var50 -= class2.field11;
                            if (var50 < 0) {
                                var50 = 0;
                            }

                            class229.field2690.method4134(var50);
                        } else {
                            class229.field2690.method4140();
                            class229.field2690.method4141();
                            if (field2511 != null) {
                                class229.field2687 = 2;
                            } else {
                                class229.field2687 = 0;
                            }

                            GraphicsObject.field1300 = null;
                            SceneTilePaint.field1965 = null;
                        }
                    }
                } catch (final Exception var68) {
                    var68.printStackTrace();
                    class229.field2690.method4140();
                    class229.field2687 = 0;
                    GraphicsObject.field1300 = null;
                    SceneTilePaint.field1965 = null;
                    field2511 = null;
                }

                BoundingBox2D.method36();
                DecorativeObject.method3081();
                synchronized (MouseInput.mouse) {
                    MouseInput.mouseCurrentButton = MouseInput.MouseHandler_currentButton;
                    MouseInput.mouseLastX = MouseInput.mouseX;
                    MouseInput.mouseLastY = MouseInput.mouseY;
                    MouseInput.mouseLastButton = MouseInput.MouseHandler_lastButton;
                    MouseInput.mouseLastPressedX = MouseInput.MouseHandler_lastPressedX;
                    MouseInput.mouseLastPressedY = MouseInput.MouseHandler_lastPressedY;
                    MouseInput.mouseLastPressedTimeMillis = MouseInput.MouseHandler_lastPressedTimeMillis;
                    MouseInput.MouseHandler_lastButton = 0;
                }

                if (class90.mouseWheel != null) {
                    var50 = class90.mouseWheel.useRotation();
                    mouseWheelRotation = var50;
                }

                if (gameState == 0) {
                    MilliTimer.load();
                    UrlRequester.timer.vmethod3326();

                    for (var50 = 0; var50 < 32; ++var50) {
                        field688[var50] = 0L;
                    }

                    for (var50 = 0; var50 < 32; ++var50) {
                        field709[var50] = 0L;
                    }

                    field684 = 0;
                } else if (gameState == 5) {
                    class171.method3299();
                    MilliTimer.load();
                    UrlRequester.timer.vmethod3326();

                    for (var50 = 0; var50 < 32; ++var50) {
                        field688[var50] = 0L;
                    }

                    for (var50 = 0; var50 < 32; ++var50) {
                        field709[var50] = 0L;
                    }

                    field684 = 0;
                } else if (gameState != 10 && gameState != 11) {
                    if (gameState == 20) {
                        class171.method3299();
                        this.method1260();
                    } else if (gameState == 25) {
                        class55.flush(false);
                        field920 = 0;
                        boolean var80 = true;

                        int var51;
                        for (var51 = 0; var51 < Varbit.field3544.length; ++var51) {
                            if (ItemContainer.landMapFileIds[var51] != -1 && Varbit.field3544[var51] == null) {
                                Varbit.field3544[var51] = MouseRecorder.indexMaps.getConfigData(ItemContainer.landMapFileIds[var51], 0);
                                if (Varbit.field3544[var51] == null) {
                                    var80 = false;
                                    ++field920;
                                }
                            }

                            if (FontName.landRegionFileIds[var51] != -1 && field1139[var51] == null) {
                                try {
                                    field1139[var51] = MouseRecorder.indexMaps.getConfigDataKeys(FontName.landRegionFileIds[var51], 0, class152.xteaKeys[var51]);
                                    if (field1139[var51] == null) {
                                        var80 = false;
                                        ++field920;
                                    }
                                    System.out.println("var51 " + var51);
                                    System.out.println("field1139[var51] " + field1139[var51]);
                                    System.out.println("xteaKeys[var51]" + class152.xteaKeys[var51]);
                                } catch (final Exception e) {
//                                    System.out.println("var51 " + var51);
//                                    System.out.println("field1139[var51] " + field1139[var51]);
//                                    System.out.println("xteaKeys[var51]" + class152.xteaKeys[var51]);
                                }
                            }
                        }

                        if (!var80) {
                            field924 = 1;
                        } else {
                            field922 = 0;
                            var80 = true;

                            int var5;
                            int var10;
                            int var11;
                            int var12;
                            int var14;
                            int var15;
                            int var16;
                            int var17;
                            int var18;
                            int var19;
                            int var52;
                            for (var51 = 0; var51 < Varbit.field3544.length; ++var51) {
                                final byte[] var3 = field1139[var51];
                                if (var3 != null) {
                                    var52 = (class298.mapRegions[var51] >> 8) * 64 - class138.baseX;
                                    var5 = (class298.mapRegions[var51] & 255) * 64 - class23.baseY;
                                    if (isDynamicRegion) {
                                        var52 = 10;
                                        var5 = 10;
                                    }

                                    boolean var8 = true;
                                    final Buffer var9 = new Buffer(var3);
                                    var10 = -1;

                                    label1485:
                                    while (true) {
                                        var11 = var9.getUSmart();
                                        if (var11 == 0) {
                                            var80 &= var8;
                                            break;
                                        }

                                        var10 += var11;
                                        var12 = 0;
                                        boolean var13 = false;

                                        while (true) {
                                            while (!var13) {
                                                var14 = var9.getUSmart();
                                                if (var14 == 0) {
                                                    continue label1485;
                                                }

                                                var12 += var14 - 1;
                                                var15 = var12 & 63;
                                                var16 = var12 >> 6 & 63;
                                                var17 = var9.readUnsignedByte() >> 2;
                                                var18 = var16 + var52;
                                                var19 = var15 + var5;
                                                if (var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                                    final ObjectComposition var20 = GameCanvas.getObjectDefinition(var10);
                                                    if (var17 != 22 || !lowMemory || var20.int1 != 0 || var20.clipType == 1 || var20.obstructsGround) {
                                                        if (!var20.method5027()) {
                                                            ++field922;
                                                            var8 = false;
                                                        }

                                                        var13 = true;
                                                    }
                                                }
                                            }

                                            var14 = var9.getUSmart();
                                            if (var14 == 0) {
                                                break;
                                            }

                                            var9.readUnsignedByte();
                                        }
                                    }
                                }
                            }

                            if (!var80) {
                                field924 = 2;
                            } else {
                                if (field924 != 0) {
                                    method1681("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                                }

                                BoundingBox2D.method36();
                                class255.region.reset();

                                for (var51 = 0; var51 < 4; ++var51) {
                                    collisionMaps[var51].reset();
                                }

                                int var53;
                                for (var51 = 0; var51 < 4; ++var51) {
                                    for (var53 = 0; var53 < 104; ++var53) {
                                        for (var52 = 0; var52 < 104; ++var52) {
                                            class62.tileSettings[var51][var53][var52] = 0;
                                        }
                                    }
                                }

                                BoundingBox2D.method36();
                                class62.field747 = 99;
                                class62.tileUnderlayIds = new byte[4][104][104];
                                class62.tileOverlayIds = new byte[4][104][104];
                                class62.tileOverlayPath = new byte[4][104][104];
                                class62.overlayRotations = new byte[4][104][104];
                                GZipDecompressor.field2520 = new int[4][105][105];
                                class297.field3831 = new byte[4][105][105];
                                field1354 = new int[105][105];
                                class55.floorHues = new int[104];
                                class183.floorSaturations = new int[104];
                                field3314 = new int[104];
                                class36.floorMultiplier = new int[104];
                                field1356 = new int[104];
                                var51 = Varbit.field3544.length;
                                class61.method1071();
                                class55.flush(true);
                                int var6;
                                int var7;
                                int var73;
                                int var75;
                                if (!isDynamicRegion) {
                                    var53 = 0;

                                    label1423:
                                    while (true) {
                                        byte[] var54;
                                        if (var53 >= var51) {
                                            for (var53 = 0; var53 < var51; ++var53) {
                                                var52 = (class298.mapRegions[var53] >> 8) * 64 - class138.baseX;
                                                var5 = (class298.mapRegions[var53] & 255) * 64 - class23.baseY;
                                                var54 = Varbit.field3544[var53];
                                                if (var54 == null && GrandExchangeEvent.field301 < 800) {
                                                    BoundingBox2D.method36();
                                                    BoundingBox3DDrawMode.method54(var52, var5, 64, 64);
                                                }
                                            }

                                            class55.flush(true);
                                            var53 = 0;

                                            while (true) {
                                                if (var53 >= var51) {
                                                    break label1423;
                                                }

                                                final byte[] var4 = field1139[var53];
                                                if (var4 != null) {
                                                    var5 = (class298.mapRegions[var53] >> 8) * 64 - class138.baseX;
                                                    var6 = (class298.mapRegions[var53] & 255) * 64 - class23.baseY;
                                                    BoundingBox2D.method36();
                                                    GrandExchangeEvent.method85(var4, var5, var6, class255.region, collisionMaps);
                                                }

                                                ++var53;
                                            }
                                        }

                                        var52 = (class298.mapRegions[var53] >> 8) * 64 - class138.baseX;
                                        var5 = (class298.mapRegions[var53] & 255) * 64 - class23.baseY;
                                        var54 = Varbit.field3544[var53];
                                        if (var54 != null) {
                                            BoundingBox2D.method36();
                                            var7 = ScriptState.field761 * 8 - 48;
                                            var73 = GrandExchangeEvent.field301 * 8 - 48;
                                            final CollisionData[] var74 = collisionMaps;
                                            var10 = 0;

                                            label1420:
                                            while (true) {
                                                if (var10 >= 4) {
                                                    final Buffer var55 = new Buffer(var54);
                                                    var11 = 0;

                                                    while (true) {
                                                        if (var11 >= 4) {
                                                            break label1420;
                                                        }

                                                        for (var12 = 0; var12 < 64; ++var12) {
                                                            for (var75 = 0; var75 < 64; ++var75) {
                                                                class229.loadTerrain(var55, var11, var12 + var52, var75 + var5, var7, var73, 0);
                                                            }
                                                        }

                                                        ++var11;
                                                    }
                                                }

                                                for (var11 = 0; var11 < 64; ++var11) {
                                                    for (var12 = 0; var12 < 64; ++var12) {
                                                        if (var11 + var52 > 0 && var52 + var11 < 103 && var5 + var12 > 0 && var5 + var12 < 103) {
                                                            var74[var10].flags[var52 + var11][var12 + var5] &= -16777217;
                                                        }
                                                    }
                                                }

                                                ++var10;
                                            }
                                        }

                                        ++var53;
                                    }
                                }

                                int var21;
                                int var22;
                                int var23;
                                int var25;
                                int var26;
                                int var27;
                                int var28;
                                int var29;
                                int var30;
                                int var33;
                                int var34;
                                int var35;
                                int var36;
                                int var37;
                                int var39;
                                int var41;
                                int var42;
                                int var43;
                                int var44;
                                int var56;
                                int var59;
                                int var62;
                                if (isDynamicRegion) {
                                    var53 = 0;

                                    label1369:
                                    while (true) {
                                        CollisionData[] var58;
                                        Buffer var76;
                                        if (var53 >= 4) {
                                            for (var53 = 0; var53 < 13; ++var53) {
                                                for (var52 = 0; var52 < 13; ++var52) {
                                                    var5 = instanceTemplateChunks[0][var53][var52];
                                                    if (var5 == -1) {
                                                        BoundingBox3DDrawMode.method54(var53 * 8, var52 * 8, 8, 8);
                                                    }
                                                }
                                            }

                                            class55.flush(true);
                                            var53 = 0;

                                            while (true) {
                                                if (var53 >= 4) {
                                                    break label1369;
                                                }

                                                BoundingBox2D.method36();

                                                for (var52 = 0; var52 < 13; ++var52) {
                                                    label1292:
                                                    for (var5 = 0; var5 < 13; ++var5) {
                                                        var6 = instanceTemplateChunks[var53][var52][var5];
                                                        if (var6 != -1) {
                                                            var7 = var6 >> 24 & 3;
                                                            var73 = var6 >> 1 & 3;
                                                            var56 = var6 >> 14 & 1023;
                                                            var10 = var6 >> 3 & 2047;
                                                            var11 = (var56 / 8 << 8) + var10 / 8;

                                                            for (var12 = 0; var12 < class298.mapRegions.length; ++var12) {
                                                                if (class298.mapRegions[var12] == var11 && field1139[var12] != null) {
                                                                    final byte[] var60 = field1139[var12];
                                                                    var14 = var52 * 8;
                                                                    var15 = var5 * 8;
                                                                    var16 = (var56 & 7) * 8;
                                                                    var17 = (var10 & 7) * 8;
                                                                    final Region var61 = class255.region;
                                                                    var58 = collisionMaps;
                                                                    var76 = new Buffer(var60);
                                                                    var21 = -1;

                                                                    while (true) {
                                                                        var22 = var76.getUSmart();
                                                                        if (var22 == 0) {
                                                                            continue label1292;
                                                                        }

                                                                        var21 += var22;
                                                                        var23 = 0;

                                                                        while (true) {
                                                                            var62 = var76.getUSmart();
                                                                            if (var62 == 0) {
                                                                                break;
                                                                            }

                                                                            var23 += var62 - 1;
                                                                            var25 = var23 & 63;
                                                                            var26 = var23 >> 6 & 63;
                                                                            var27 = var23 >> 12;
                                                                            var28 = var76.readUnsignedByte();
                                                                            var29 = var28 >> 2;
                                                                            var30 = var28 & 3;
                                                                            if (var7 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                                                final ObjectComposition var31 = GameCanvas.getObjectDefinition(var21);
                                                                                var34 = var26 & 7;
                                                                                var35 = var25 & 7;
                                                                                var37 = var31.width;
                                                                                int var38 = var31.length;
                                                                                if ((var30 & 1) == 1) {
                                                                                    var39 = var37;
                                                                                    var37 = var38;
                                                                                    var38 = var39;
                                                                                }

                                                                                var36 = var73 & 3;
                                                                                if (var36 == 0) {
                                                                                    var33 = var34;
                                                                                } else if (var36 == 1) {
                                                                                    var33 = var35;
                                                                                } else if (var36 == 2) {
                                                                                    var33 = 7 - var34 - (var37 - 1);
                                                                                } else {
                                                                                    var33 = 7 - var35 - (var38 - 1);
                                                                                }

                                                                                var39 = var14 + var33;
                                                                                var42 = var26 & 7;
                                                                                var43 = var25 & 7;
                                                                                int var45 = var31.width;
                                                                                int var46 = var31.length;
                                                                                int var47;
                                                                                if ((var30 & 1) == 1) {
                                                                                    var47 = var45;
                                                                                    var45 = var46;
                                                                                    var46 = var47;
                                                                                }

                                                                                var44 = var73 & 3;
                                                                                if (var44 == 0) {
                                                                                    var41 = var43;
                                                                                } else if (var44 == 1) {
                                                                                    var41 = 7 - var42 - (var45 - 1);
                                                                                } else if (var44 == 2) {
                                                                                    var41 = 7 - var43 - (var46 - 1);
                                                                                } else {
                                                                                    var41 = var42;
                                                                                }

                                                                                var47 = var15 + var41;
                                                                                if (var39 > 0 && var47 > 0 && var39 < 103 && var47 < 103) {
                                                                                    int var48 = var53;
                                                                                    if ((class62.tileSettings[1][var39][var47] & 2) == 2) {
                                                                                        var48 = var53 - 1;
                                                                                    }

                                                                                    CollisionData var49 = null;
                                                                                    if (var48 >= 0) {
                                                                                        var49 = var58[var48];
                                                                                    }

                                                                                    class44.addObject(var53, var39, var47, var21, var30 + var73 & 3, var29, var61, var49);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                                ++var53;
                                            }
                                        }

                                        BoundingBox2D.method36();

                                        for (var52 = 0; var52 < 13; ++var52) {
                                            for (var5 = 0; var5 < 13; ++var5) {
                                                boolean var72 = false;
                                                var7 = instanceTemplateChunks[var53][var52][var5];
                                                if (var7 != -1) {
                                                    var73 = var7 >> 24 & 3;
                                                    var56 = var7 >> 1 & 3;
                                                    var10 = var7 >> 14 & 1023;
                                                    var11 = var7 >> 3 & 2047;
                                                    var12 = (var10 / 8 << 8) + var11 / 8;

                                                    for (var75 = 0; var75 < class298.mapRegions.length; ++var75) {
                                                        if (class298.mapRegions[var75] == var12 && Varbit.field3544[var75] != null) {
                                                            final byte[] var57 = Varbit.field3544[var75];
                                                            var15 = var52 * 8;
                                                            var16 = var5 * 8;
                                                            var17 = (var10 & 7) * 8;
                                                            var18 = (var11 & 7) * 8;
                                                            var58 = collisionMaps;

                                                            for (var59 = 0; var59 < 8; ++var59) {
                                                                for (var21 = 0; var21 < 8; ++var21) {
                                                                    if (var59 + var15 > 0 && var15 + var59 < 103 && var21 + var16 > 0 && var16 + var21 < 103) {
                                                                        var58[var53].flags[var15 + var59][var21 + var16] &= -16777217;
                                                                    }
                                                                }
                                                            }

                                                            var76 = new Buffer(var57);

                                                            for (var21 = 0; var21 < 4; ++var21) {
                                                                for (var22 = 0; var22 < 64; ++var22) {
                                                                    for (var23 = 0; var23 < 64; ++var23) {
                                                                        if (var73 == var21 && var22 >= var17 && var22 < var17 + 8 && var23 >= var18 && var23 < var18 + 8) {
                                                                            var28 = var22 & 7;
                                                                            var29 = var23 & 7;
                                                                            var30 = var56 & 3;
                                                                            if (var30 == 0) {
                                                                                var27 = var28;
                                                                            } else if (var30 == 1) {
                                                                                var27 = var29;
                                                                            } else if (var30 == 2) {
                                                                                var27 = 7 - var28;
                                                                            } else {
                                                                                var27 = 7 - var29;
                                                                            }

                                                                            class229.loadTerrain(var76, var53, var15 + var27, var16 + class154.method3157(var22 & 7, var23 & 7, var56), 0, 0, var56);
                                                                        } else {
                                                                            class229.loadTerrain(var76, 0, -1, -1, 0, 0, 0);
                                                                        }
                                                                    }
                                                                }
                                                            }

                                                            var72 = true;
                                                            break;
                                                        }
                                                    }
                                                }

                                                if (!var72) {
                                                    class138.method3049(var53, var52 * 8, var5 * 8);
                                                }
                                            }
                                        }

                                        ++var53;
                                    }
                                }

                                class55.flush(true);
                                BoundingBox2D.method36();
                                final Region var70 = class255.region;
                                final CollisionData[] var71 = collisionMaps;

                                for (var5 = 0; var5 < 4; ++var5) {
                                    for (var6 = 0; var6 < 104; ++var6) {
                                        for (var7 = 0; var7 < 104; ++var7) {
                                            if ((class62.tileSettings[var5][var6][var7] & 1) == 1) {
                                                var73 = var5;
                                                if ((class62.tileSettings[1][var6][var7] & 2) == 2) {
                                                    var73 = var5 - 1;
                                                }

                                                if (var73 >= 0) {
                                                    var71[var73].method3384(var6, var7);
                                                }
                                            }
                                        }
                                    }
                                }

                                class62.field751 += (int) (Math.random() * 5.0D) - 2;
                                if (class62.field751 < -8) {
                                    class62.field751 = -8;
                                }

                                if (class62.field751 > 8) {
                                    class62.field751 = 8;
                                }

                                class62.field745 += (int) (Math.random() * 5.0D) - 2;
                                if (class62.field745 < -16) {
                                    class62.field745 = -16;
                                }

                                if (class62.field745 > 16) {
                                    class62.field745 = 16;
                                }

                                for (var5 = 0; var5 < 4; ++var5) {
                                    final byte[][] var81 = class297.field3831[var5];
                                    var12 = (int) Math.sqrt(5100.0D);
                                    var75 = var12 * 768 >> 8;

                                    for (var14 = 1; var14 < 103; ++var14) {
                                        for (var15 = 1; var15 < 103; ++var15) {
                                            var16 = class62.tileHeights[var5][var15 + 1][var14] - class62.tileHeights[var5][var15 - 1][var14];
                                            var17 = class62.tileHeights[var5][var15][var14 + 1] - class62.tileHeights[var5][var15][var14 - 1];
                                            var18 = (int) Math.sqrt((var16 * var16 + var17 * var17 + 65536));
                                            var19 = (var16 << 8) / var18;
                                            var59 = 65536 / var18;
                                            var21 = (var17 << 8) / var18;
                                            var22 = (var21 * -50 + var19 * -50 + var59 * -10) / var75 + 96;
                                            var23 = (var81[var15 - 1][var14] >> 2) + (var81[var15][var14 - 1] >> 2) + (var81[var15 + 1][var14] >> 3) + (var81[var15][var14 + 1] >> 3) + (var81[var15][var14] >> 1);
                                            field1354[var15][var14] = var22 - var23;
                                        }
                                    }

                                    for (var14 = 0; var14 < 104; ++var14) {
                                        class55.floorHues[var14] = 0;
                                        class183.floorSaturations[var14] = 0;
                                        field3314[var14] = 0;
                                        class36.floorMultiplier[var14] = 0;
                                        field1356[var14] = 0;
                                    }

                                    for (var14 = -5; var14 < 109; ++var14) {
                                        for (var15 = 0; var15 < 104; ++var15) {
                                            var16 = var14 + 5;
                                            if (var16 >= 0 && var16 < 104) {
                                                var17 = class62.tileUnderlayIds[var5][var16][var15] & 255;
                                                if (var17 > 0) {
                                                    final FloorUnderlayDefinition var85 = FloorUnderlayDefinition.getUnderlayDefinition(var17 - 1);
                                                    class55.floorHues[var15] += var85.hue;
                                                    class183.floorSaturations[var15] += var85.saturation;
                                                    field3314[var15] += var85.lightness;
                                                    class36.floorMultiplier[var15] += var85.hueMultiplier;
                                                    ++field1356[var15];
                                                }
                                            }

                                            var17 = var14 - 5;
                                            if (var17 >= 0 && var17 < 104) {
                                                var18 = class62.tileUnderlayIds[var5][var17][var15] & 255;
                                                if (var18 > 0) {
                                                    final FloorUnderlayDefinition var84 = FloorUnderlayDefinition.getUnderlayDefinition(var18 - 1);
                                                    class55.floorHues[var15] -= var84.hue;
                                                    class183.floorSaturations[var15] -= var84.saturation;
                                                    field3314[var15] -= var84.lightness;
                                                    class36.floorMultiplier[var15] -= var84.hueMultiplier;
                                                    --field1356[var15];
                                                }
                                            }
                                        }

                                        if (var14 >= 1 && var14 < 103) {
                                            var15 = 0;
                                            var16 = 0;
                                            var17 = 0;
                                            var18 = 0;
                                            var19 = 0;

                                            for (var59 = -5; var59 < 109; ++var59) {
                                                var21 = var59 + 5;
                                                if (var21 >= 0 && var21 < 104) {
                                                    var15 += class55.floorHues[var21];
                                                    var16 += class183.floorSaturations[var21];
                                                    var17 += field3314[var21];
                                                    var18 += class36.floorMultiplier[var21];
                                                    var19 += field1356[var21];
                                                }

                                                var22 = var59 - 5;
                                                if (var22 >= 0 && var22 < 104) {
                                                    var15 -= class55.floorHues[var22];
                                                    var16 -= class183.floorSaturations[var22];
                                                    var17 -= field3314[var22];
                                                    var18 -= class36.floorMultiplier[var22];
                                                    var19 -= field1356[var22];
                                                }

                                                if (var59 >= 1 && var59 < 103 && (!lowMemory || (class62.tileSettings[0][var14][var59] & 2) != 0 || (class62.tileSettings[var5][var14][var59] & 16) == 0)) {
                                                    if (var5 < class62.field747) {
                                                        class62.field747 = var5;
                                                    }

                                                    var23 = class62.tileUnderlayIds[var5][var14][var59] & 255;
                                                    var62 = class62.tileOverlayIds[var5][var14][var59] & 255;
                                                    if (var23 > 0 || var62 > 0) {
                                                        var25 = class62.tileHeights[var5][var14][var59];
                                                        var26 = class62.tileHeights[var5][var14 + 1][var59];
                                                        var27 = class62.tileHeights[var5][var14 + 1][var59 + 1];
                                                        var28 = class62.tileHeights[var5][var14][var59 + 1];
                                                        var29 = field1354[var14][var59];
                                                        var30 = field1354[var14 + 1][var59];
                                                        final int var63 = field1354[var14 + 1][var59 + 1];
                                                        final int var32 = field1354[var14][var59 + 1];
                                                        var33 = -1;
                                                        var34 = -1;
                                                        if (var23 > 0) {
                                                            var35 = var15 * 256 / var18;
                                                            var36 = var16 / var19;
                                                            var37 = var17 / var19;
                                                            var33 = class246.method4490(var35, var36, var37);
                                                            var35 = var35 + class62.field751 & 255;
                                                            var37 += class62.field745;
                                                            if (var37 < 0) {
                                                                var37 = 0;
                                                            } else if (var37 > 255) {
                                                                var37 = 255;
                                                            }

                                                            var34 = class246.method4490(var35, var36, var37);
                                                        }

                                                        if (var5 > 0) {
                                                            boolean var78 = true;
                                                            if (var23 == 0 && class62.tileOverlayPath[var5][var14][var59] != 0) {
                                                                var78 = false;
                                                            }

                                                            if (var62 > 0 && !class95.getOverlayDefinition(var62 - 1).isHidden) {
                                                                var78 = false;
                                                            }

                                                            if (var78 && var26 == var25 && var27 == var25 && var28 == var25) {
                                                                GZipDecompressor.field2520[var5][var14][var59] |= 2340;
                                                            }
                                                        }

                                                        var35 = 0;
                                                        if (var34 != -1) {
                                                            var35 = Graphics3D.colorPalette[Renderable.method3058(var34, 96)];
                                                        }

                                                        if (var62 == 0) {
                                                            var70.addTile(var5, var14, var59, 0, 0, -1, var25, var26, var27, var28, Renderable.method3058(var33, var29), Renderable.method3058(var33, var30), Renderable.method3058(var33, var63), Renderable.method3058(var33, var32), 0, 0, 0, 0, var35, 0);
                                                        } else {
                                                            var36 = class62.tileOverlayPath[var5][var14][var59] + 1;
                                                            final byte var79 = class62.overlayRotations[var5][var14][var59];
                                                            final Overlay var64 = class95.getOverlayDefinition(var62 - 1);
                                                            var39 = var64.texture;
                                                            final int var40;
                                                            if (var39 >= 0) {
                                                                var41 = Graphics3D.textureLoader.getAverageTextureRGB(var39);
                                                                var40 = -1;
                                                            } else if (var64.color == 16711935) {
                                                                var40 = -2;
                                                                var39 = -1;
                                                                var41 = -2;
                                                            } else {
                                                                var40 = class246.method4490(var64.hue, var64.saturation, var64.lightness);
                                                                var42 = var64.hue + class62.field751 & 255;
                                                                var43 = var64.lightness + class62.field745;
                                                                if (var43 < 0) {
                                                                    var43 = 0;
                                                                } else if (var43 > 255) {
                                                                    var43 = 255;
                                                                }

                                                                var41 = class246.method4490(var42, var64.saturation, var43);
                                                            }

                                                            var42 = 0;
                                                            if (var41 != -2) {
                                                                var42 = Graphics3D.colorPalette[adjustHSLListness0(var41, 96)];
                                                            }

                                                            if (var64.otherRgbColor != -1) {
                                                                var43 = var64.otherHue + class62.field751 & 255;
                                                                var44 = var64.otherLightness + class62.field745;
                                                                if (var44 < 0) {
                                                                    var44 = 0;
                                                                } else if (var44 > 255) {
                                                                    var44 = 255;
                                                                }

                                                                var41 = class246.method4490(var43, var64.otherSaturation, var44);
                                                                var42 = Graphics3D.colorPalette[adjustHSLListness0(var41, 96)];
                                                            }

                                                            var70.addTile(var5, var14, var59, var36, var79, var39, var25, var26, var27, var28, Renderable.method3058(var33, var29), Renderable.method3058(var33, var30), Renderable.method3058(var33, var63), Renderable.method3058(var33, var32), adjustHSLListness0(var40, var29), adjustHSLListness0(var40, var30), adjustHSLListness0(var40, var63), adjustHSLListness0(var40, var32), var35, var42);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    for (var14 = 1; var14 < 103; ++var14) {
                                        for (var15 = 1; var15 < 103; ++var15) {
                                            if ((class62.tileSettings[var5][var15][var14] & 8) != 0) {
                                                var59 = 0;
                                            } else if (var5 > 0 && (class62.tileSettings[1][var15][var14] & 2) != 0) {
                                                var59 = var5 - 1;
                                            } else {
                                                var59 = var5;
                                            }

                                            var70.setPhysicalLevel(var5, var15, var14, var59);
                                        }
                                    }

                                    class62.tileUnderlayIds[var5] = null;
                                    class62.tileOverlayIds[var5] = null;
                                    class62.tileOverlayPath[var5] = null;
                                    class62.overlayRotations[var5] = null;
                                    class297.field3831[var5] = null;
                                }

                                var70.applyLighting(-50, -10, -50);

                                for (var5 = 0; var5 < 104; ++var5) {
                                    for (var6 = 0; var6 < 104; ++var6) {
                                        if ((class62.tileSettings[1][var5][var6] & 2) == 2) {
                                            var70.setBridge(var5, var6);
                                        }
                                    }
                                }

                                var5 = 1;
                                var6 = 2;
                                var7 = 4;

                                for (var73 = 0; var73 < 4; ++var73) {
                                    if (var73 > 0) {
                                        var5 <<= 3;
                                        var6 <<= 3;
                                        var7 <<= 3;
                                    }

                                    for (var56 = 0; var56 <= var73; ++var56) {
                                        for (var10 = 0; var10 <= 104; ++var10) {
                                            for (var11 = 0; var11 <= 104; ++var11) {
                                                short var77;
                                                if ((GZipDecompressor.field2520[var56][var11][var10] & var5) != 0) {
                                                    var12 = var10;
                                                    var75 = var10;
                                                    var14 = var56;

                                                    for (var15 = var56; var12 > 0 && (GZipDecompressor.field2520[var56][var11][var12 - 1] & var5) != 0; --var12) {
                                                    }

                                                    while (var75 < 104 && (GZipDecompressor.field2520[var56][var11][var75 + 1] & var5) != 0) {
                                                        ++var75;
                                                    }

                                                    label1011:
                                                    while (var14 > 0) {
                                                        for (var16 = var12; var16 <= var75; ++var16) {
                                                            if ((GZipDecompressor.field2520[var14 - 1][var11][var16] & var5) == 0) {
                                                                break label1011;
                                                            }
                                                        }

                                                        --var14;
                                                    }

                                                    label1000:
                                                    while (var15 < var73) {
                                                        for (var16 = var12; var16 <= var75; ++var16) {
                                                            if ((GZipDecompressor.field2520[var15 + 1][var11][var16] & var5) == 0) {
                                                                break label1000;
                                                            }
                                                        }

                                                        ++var15;
                                                    }

                                                    var16 = (var15 + 1 - var14) * (var75 - var12 + 1);
                                                    if (var16 >= 8) {
                                                        var77 = 240;
                                                        var18 = class62.tileHeights[var15][var11][var12] - var77;
                                                        var19 = class62.tileHeights[var14][var11][var12];
                                                        Region.addOcclude(var73, 1, var11 * 128, var11 * 128, var12 * 128, var75 * 128 + 128, var18, var19);

                                                        for (var59 = var14; var59 <= var15; ++var59) {
                                                            for (var21 = var12; var21 <= var75; ++var21) {
                                                                GZipDecompressor.field2520[var59][var11][var21] &= ~var5;
                                                            }
                                                        }
                                                    }
                                                }

                                                if ((GZipDecompressor.field2520[var56][var11][var10] & var6) != 0) {
                                                    var12 = var11;
                                                    var75 = var11;
                                                    var14 = var56;

                                                    for (var15 = var56; var12 > 0 && (GZipDecompressor.field2520[var56][var12 - 1][var10] & var6) != 0; --var12) {
                                                    }

                                                    while (var75 < 104 && (GZipDecompressor.field2520[var56][var75 + 1][var10] & var6) != 0) {
                                                        ++var75;
                                                    }

                                                    label1064:
                                                    while (var14 > 0) {
                                                        for (var16 = var12; var16 <= var75; ++var16) {
                                                            if ((GZipDecompressor.field2520[var14 - 1][var16][var10] & var6) == 0) {
                                                                break label1064;
                                                            }
                                                        }

                                                        --var14;
                                                    }

                                                    label1053:
                                                    while (var15 < var73) {
                                                        for (var16 = var12; var16 <= var75; ++var16) {
                                                            if ((GZipDecompressor.field2520[var15 + 1][var16][var10] & var6) == 0) {
                                                                break label1053;
                                                            }
                                                        }

                                                        ++var15;
                                                    }

                                                    var16 = (var75 - var12 + 1) * (var15 + 1 - var14);
                                                    if (var16 >= 8) {
                                                        var77 = 240;
                                                        var18 = class62.tileHeights[var15][var12][var10] - var77;
                                                        var19 = class62.tileHeights[var14][var12][var10];
                                                        Region.addOcclude(var73, 2, var12 * 128, var75 * 128 + 128, var10 * 128, var10 * 128, var18, var19);

                                                        for (var59 = var14; var59 <= var15; ++var59) {
                                                            for (var21 = var12; var21 <= var75; ++var21) {
                                                                GZipDecompressor.field2520[var59][var21][var10] &= ~var6;
                                                            }
                                                        }
                                                    }
                                                }

                                                if ((GZipDecompressor.field2520[var56][var11][var10] & var7) != 0) {
                                                    var12 = var11;
                                                    var75 = var11;
                                                    var14 = var10;

                                                    for (var15 = var10; var14 > 0 && (GZipDecompressor.field2520[var56][var11][var14 - 1] & var7) != 0; --var14) {
                                                    }

                                                    while (var15 < 104 && (GZipDecompressor.field2520[var56][var11][var15 + 1] & var7) != 0) {
                                                        ++var15;
                                                    }

                                                    label1117:
                                                    while (var12 > 0) {
                                                        for (var16 = var14; var16 <= var15; ++var16) {
                                                            if ((GZipDecompressor.field2520[var56][var12 - 1][var16] & var7) == 0) {
                                                                break label1117;
                                                            }
                                                        }

                                                        --var12;
                                                    }

                                                    label1106:
                                                    while (var75 < 104) {
                                                        for (var16 = var14; var16 <= var15; ++var16) {
                                                            if ((GZipDecompressor.field2520[var56][var75 + 1][var16] & var7) == 0) {
                                                                break label1106;
                                                            }
                                                        }

                                                        ++var75;
                                                    }

                                                    if ((var75 - var12 + 1) * (var15 - var14 + 1) >= 4) {
                                                        var16 = class62.tileHeights[var56][var12][var14];
                                                        Region.addOcclude(var73, 4, var12 * 128, var75 * 128 + 128, var14 * 128, var15 * 128 + 128, var16, var16);

                                                        for (var17 = var12; var17 <= var75; ++var17) {
                                                            for (var18 = var14; var18 <= var15; ++var18) {
                                                                GZipDecompressor.field2520[var56][var17][var18] &= ~var7;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                class55.flush(true);


                                if (lowMemory) {
                                    class255.region.setup(class62.field747);
                                } else {
                                    class255.region.setup(0);
                                }

                                for (var6 = 0; var6 < 104; ++var6) {
                                    for (var7 = 0; var7 < 104; ++var7) {
                                        class18.groundItemSpawned(var6, var7);
                                    }
                                }

                                BoundingBox2D.method36();

                                for (PendingSpawn var82 = (PendingSpawn) pendingSpawns.getFront(); var82 != null; var82 = (PendingSpawn) pendingSpawns.getNext()) {
                                    if (var82.hitpoints == -1) {
                                        var82.delay = 0;
                                        OwnWorldComparator.method1247(var82);
                                    } else {
                                        var82.unlink();
                                    }
                                }

                                ObjectComposition.field3593.reset();
                                PacketNode var83;
                                if (class23.clientInstance.method926()) {
                                    var83 = WorldMapRectangle.method280(ClientPacket.field2433, field957.field1484);
                                    var83.packetBuffer.putInt(1057001181);
                                    field957.method2052(var83);
                                }

                                if (!isDynamicRegion) {
                                    var6 = (ScriptState.field761 - 6) / 8;
                                    var7 = (ScriptState.field761 + 6) / 8;
                                    var73 = (GrandExchangeEvent.field301 - 6) / 8;
                                    var56 = (GrandExchangeEvent.field301 + 6) / 8;

                                    for (var10 = var6 - 1; var10 <= var7 + 1; ++var10) {
                                        for (var11 = var73 - 1; var11 <= var56 + 1; ++var11) {
                                            if (var10 < var6 || var10 > var7 || var11 < var73 || var11 > var56) {
                                                MouseRecorder.indexMaps.method4552("m" + var10 + "_" + var11);
                                                MouseRecorder.indexMaps.method4552("l" + var10 + "_" + var11);
                                            }
                                        }
                                    }
                                }

                                class64.setGameState(30);
                                BoundingBox2D.method36();
                                CombatInfoListHolder.method1870();
                                var83 = WorldMapRectangle.method280(ClientPacket.field2464, field957.field1484);
                                field957.method2052(var83);
                                UrlRequester.timer.vmethod3326();

                                for (var7 = 0; var7 < 32; ++var7) {
                                    field688[var7] = 0L;
                                }

                                for (var7 = 0; var7 < 32; ++var7) {
                                    field709[var7] = 0L;
                                }

                                field684 = 0;
                            }
                        }
                    }
                } else {
                    class171.method3299();
                }

                if (gameState == 30) {
                    this.method1261();
                } else if (gameState == 40 || gameState == 45) {
                    this.method1260();
                }

                return;
            }

            fileSystem.data.load(fileSystem.index, (int) fileSystem.hash, fileSystem.field3367, false);
        }
    }

    protected final void methodDraw(final boolean var1) {
        boolean var2;
        label174:
        {
            try {
                if (class229.field2687 == 2) {
                    if (GraphicsObject.field1300 == null) {
                        GraphicsObject.field1300 = Track1.getMusicFile(field2511, VertexNormal.field1931, GrandExchangeEvents.field284);
                        if (GraphicsObject.field1300 == null) {
                            var2 = false;
                            break label174;
                        }
                    }

                    if (SceneTilePaint.field1965 == null) {
                        SceneTilePaint.field1965 = new class110(class229.field2689, class229.vorbisIdxRef);
                    }

                    if (class229.field2690.method4136(GraphicsObject.field1300, class229.field2688, SceneTilePaint.field1965, 22050)) {
                        class229.field2690.method4137();
                        class229.field2690.method4134(class86.field1330);
                        class229.field2690.method4139(GraphicsObject.field1300, class229.field2692);
                        class229.field2687 = 0;
                        GraphicsObject.field1300 = null;
                        SceneTilePaint.field1965 = null;
                        field2511 = null;
                        var2 = true;
                        break label174;
                    }
                }
            } catch (final Exception var6) {
                var6.printStackTrace();
                class229.field2690.method4140();
                class229.field2687 = 0;
                GraphicsObject.field1300 = null;
                SceneTilePaint.field1965 = null;
                field2511 = null;
            }

            var2 = false;
        }

        if (var2 && field1102 && soundSystem0 != null) {
            soundSystem0.tryFlush();
        }

        int var4;
        if ((gameState == 10 || gameState == 20 || gameState == 30) && field1080 != 0L && class64.method1118() > field1080) {
            var4 = isResized ? 2 : 1;
            GameCanvas.method832(var4);
        }

        if (var1) {
            for (var4 = 0; var4 < 100; ++var4) {
                field1072[var4] = true;
            }
        }

        if (gameState == 0) {
            this.drawLoadingScreen(class90.loadingBarPercentage, class90.loadingText, var1);
        } else if (gameState == 5) {
            class234.drawLoginScreen(MessageNode.fontBold12, class55.fontPlain11, class20.font_p12full, var1);
        } else if (gameState != 10 && gameState != 11) {
            if (gameState == 20) {
                class234.drawLoginScreen(MessageNode.fontBold12, class55.fontPlain11, class20.font_p12full, var1);
            } else if (gameState == 25) {
                if (field924 == 1) {
                    if (field920 > field921) {
                        field921 = field920;
                    }

                    var4 = (field921 * 50 - field920 * 50) / field921;
                    method1681("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
                } else if (field924 == 2) {
                    if (field922 > field923) {
                        field923 = field922;
                    }

                    var4 = (field923 * 50 - field922 * 50) / field923 + 50;
                    method1681("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
                } else {
                    method1681("Loading - please wait.", false);
                }
            } else if (gameState == 30) {
                this.method1264();
            } else if (gameState == 40) {
                method1681("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
            } else if (gameState == 45) {
                method1681("Please wait...", false);
            }
        } else {
            class234.drawLoginScreen(MessageNode.fontBold12, class55.fontPlain11, class20.font_p12full, var1);
        }

        if (gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
            for (var4 = 0; var4 < widgetCount; ++var4) {
                if (field1073[var4]) {
                    MapCacheArchiveNames.rasterProvider.draw(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
                    field1073[var4] = false;
                }
            }
        } else if (gameState > 0) {
            MapCacheArchiveNames.rasterProvider.drawFull(0, 0);

            for (var4 = 0; var4 < widgetCount; ++var4) {
                field1073[var4] = false;
            }
        }

    }

    protected final void vmethod1256() {
        if (SceneTilePaint.varcs.changed()) {
            SceneTilePaint.varcs.serialize();
        }

        if (WorldMapType2.mouseRecorder != null) {
            WorldMapType2.mouseRecorder.isRunning = false;
        }

        WorldMapType2.mouseRecorder = null;
        field957.close();
        if (KeyFocusListener.keyboard != null) {
            synchronized (KeyFocusListener.keyboard) {
                KeyFocusListener.keyboard = null;
            }
        }

        if (MouseInput.mouse != null) {
            synchronized (MouseInput.mouse) {
                MouseInput.mouse = null;
            }
        }

        class90.mouseWheel = null;
        if (soundSystem0 != null) {
            soundSystem0.shutdown();
        }

        if (class71.soundSystem1 != null) {
            class71.soundSystem1.shutdown();
        }

        if (class264.NetCache_socket != null) {
            class264.NetCache_socket.vmethod3331();
        }

        synchronized (IndexStoreActionHandler.IndexStoreActionHandler_lock) {
            if (IndexStoreActionHandler.field3401 != 0) {
                IndexStoreActionHandler.field3401 = 1;

                try {
                    IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
                } catch (final InterruptedException ignored) {
                }
            }
        }

        if (MapIconReference.urlRequester != null) {
            MapIconReference.urlRequester.close();
            MapIconReference.urlRequester = null;
        }

        MapIcon.method587();
    }

    protected final void vmethod1251() {
    }

    public final void init() {
        try {
            if (this.isValidHost()) {

                for (final Parameters var4 : new Parameters[]{Parameters.field3812, Parameters.field3811, Parameters.field3810, Parameters.field3801, Parameters.field3809, Parameters.field3799, Parameters.field3807, Parameters.field3814, Parameters.field3805, Parameters.field3808, Parameters.field3813, Parameters.field3804, Parameters.field3803, Parameters.field3806, Parameters.field3800, Parameters.field3802}) {
                    final String var5 = this.getParameter(var4.key);
                    if (var5 != null) {
                        switch (Integer.parseInt(var4.key)) {
                            case 1:
                                flags = Integer.parseInt(var5);
                                break;
                            case 2:
                                if (field877 == -1) {
                                    field877 = Integer.parseInt(var5);
                                }
                            case 3:
                            case 6:
                            default:
                                break;
                            case 4:
                                world = Integer.parseInt(var5);
                                break;
                            case 5:
                                isMembers = var5.equalsIgnoreCase("true");
                                break;
                            case 7:
                                if (var5.equalsIgnoreCase("true")) {
                                }
                                break;
                            case 8:
                                WidgetNode.field795 = Integer.parseInt(var5);
                                break;
                            case 9:
                                field876 = var5;
                                break;
                            case 10:
                                field1920 = BuildType.getFromOrdinal(Integer.parseInt(var5));
                                break;
                            case 11:
                                languageId = Integer.parseInt(var5);
                                break;
                            case 12:
                                class55.sessionToken = var5;
                                break;
                            case 13:
                                class265.field3435 = (JagexGame) Enumerated.forOrdinal(JagexGame.method4506(), Integer.parseInt(var5));
                                if (class265.field3435 == JagexGame.OLDSCAPE) {
                                    GZipDecompressor.loginType = JagexLoginType.field4069;
                                } else {
                                    GZipDecompressor.loginType = JagexLoginType.field4070;
                                }
                                break;
                            case 14:
                                socketType = Integer.parseInt(var5);
                                break;
                            case 15:
                                field917 = Integer.parseInt(var5) != 0;
                        }
                    }
                }

                Region.regionLowMemory = false;
                lowMemory = false;
                Projectile.host = this.getCodeBase().getHost();
                final String var10 = field1920.identifier;
                final byte var6 = 0;

                try {
                    Signlink.method2684("oldschool", var10, var6, 17);
                } catch (final Exception var8) {
                    Signlink.processClientError(null, var8);
                }

                class23.clientInstance = this;
                this.initialize(765, 503, 168);
            }
        } catch (final RuntimeException var9) {
            var9.printStackTrace();
            throw class44.method664(var9, "client.init(" + ')');
        }
    }

    private void processJS5Connection() {
        if (gameState != 1000) {
            final boolean var1 = method984();
            if (!var1) {
                this.method1258();
            }

        }
    }

    private void method1258() {
        if (class264.field3430 >= 4) {
            this.error("js5crc");
            gameState = 1000;
        } else {
            if (class264.field3431 >= 4) {
                if (gameState <= 5) {
                    this.error("js5io");
                    gameState = 1000;
                    return;
                }

                field1046 = 3000;
                class264.field3431 = 3;
            }

            if (--field1046 + 1 <= 0) {
                try {
                    if (js5State == 0) {
                        GrandExchangeEvent.socket = taskManager.createSocket(Projectile.host, class138.myWorldPort);
                        ++js5State;
                    }

                    if (js5State == 1) {
                        if (GrandExchangeEvent.socket.status == 2) {
                            this.error(-1);
                            return;
                        }

                        if (GrandExchangeEvent.socket.status == 1) {
                            ++js5State;
                        }
                    }

                    if (js5State == 2) {
                        if (field917) {
                            class3.rssocket = class64.method1119((Socket) GrandExchangeEvent.socket.value, 40000, 5000);
                        } else {
                            class3.rssocket = new class173((Socket) GrandExchangeEvent.socket.value, taskManager, 5000);
                        }

                        final Buffer var1 = new Buffer(5);
                        var1.putByte(15);
                        var1.putInt(168);
                        class3.rssocket.vmethod3337(var1.payload, 0, 5);
                        ++js5State;
                        WorldMapData.field463 = class64.method1118();
                    }

                    if (js5State == 3) {
                        if (class3.rssocket.getAvailable() > 0 || !field917 && gameState <= 5) {
                            final int var2 = class3.rssocket.vmethod3349();
                            if (var2 != 0) {
                                this.error(var2);
                                return;
                            }

                            ++js5State;
                        } else if (class64.method1118() - WorldMapData.field463 > 30000L) {
                            this.error(-2);
                            return;
                        }
                    }

                    if (js5State == 4) {
                        ScriptEvent.method1143(class3.rssocket, gameState > 20);
                        GrandExchangeEvent.socket = null;
                        class3.rssocket = null;
                        js5State = 0;
                        errorCount = 0;
                    }
                } catch (final IOException var3) {
                    this.error(-3);
                }

            }
        }
    }

    private void error(final int serverResponse) {
        GrandExchangeEvent.socket = null;
        class3.rssocket = null;
        js5State = 0;
        if (class228.port1 == class138.myWorldPort) {
            class138.myWorldPort = class243.port2;
        } else {
            class138.myWorldPort = class228.port1;
        }

        ++errorCount;
        if (errorCount >= 2 && (serverResponse == 7 || serverResponse == 9)) {
            if (gameState <= 5) {
                this.error("js5connect_full");
                gameState = 1000;
            } else {
                field1046 = 3000;
            }
        } else if (errorCount >= 2 && serverResponse == 6) {
            this.error("js5connect_outofdate");
            gameState = 1000;
        } else if (errorCount >= 4) {
            if (gameState <= 5) {
                this.error("js5connect");
                gameState = 1000;
            } else {
                field1046 = 3000;
            }
        }

    }

    private void method1260() {
        Object var1 = field957.getSocket();
        final PacketBuffer var2 = field957.packetBuffer;

        try {
            if (loginState == 0) {
                if (var1 != null) {
                    ((class169) var1).vmethod3331();
                    var1 = null;
                }

                Size.field364 = null;
                socketError = false;
                field983 = 0;
                loginState = 1;
            }

            if (loginState == 1) {
                if (Size.field364 == null) {
                    Size.field364 = taskManager.createSocket(Projectile.host, class138.myWorldPort);
                }

                if (Size.field364.status == 2) {
                    throw new IOException();
                }

                if (Size.field364.status == 1) {
                    if (field917) {
                        var1 = class64.method1119((Socket) Size.field364.value, 40000, 5000);
                    } else {
                        var1 = new class173((Socket) Size.field364.value, taskManager, 5000);
                    }

                    field957.setSocket((class169) var1);
                    Size.field364 = null;
                    loginState = 2;
                }
            }

            if (loginState == 2) {
                field957.method2038();
                final PacketNode var4 = ServerPacket.method3433();
                var4.clientPacket = null;
                var4.field2503 = 0;
                var4.packetBuffer = new PacketBuffer(5000);
                var4.packetBuffer.putByte(LoginPacket.field2488.id);
                field957.method2052(var4);
                field957.method2039();
                var2.offset = 0;
                loginState = 3;
            }

            boolean var12;
            int var13;
            if (loginState == 3) {
                if (soundSystem0 != null) {
                    soundSystem0.method2214();
                }

                if (class71.soundSystem1 != null) {
                    class71.soundSystem1.method2214();
                }

                var12 = !field917 || ((class169) var1).vmethod3335(1);

                if (var12) {
                    var13 = ((class169) var1).vmethod3349();
                    if (soundSystem0 != null) {
                        soundSystem0.method2214();
                    }

                    if (class71.soundSystem1 != null) {
                        class71.soundSystem1.method2214();
                    }

                    if (var13 != 0) {
                        MouseInput.method1051(var13);
                        return;
                    }

                    var2.offset = 0;
                    loginState = 4;
                }
            }

            int var24;
            if (loginState == 4) {
                if (var2.offset < 8) {
                    var24 = ((class169) var1).getAvailable();
                    if (var24 > 8 - var2.offset) {
                        var24 = 8 - var2.offset;
                    }

                    if (var24 > 0) {
                        ((class169) var1).vmethod3348(var2.payload, var2.offset, var24);
                        var2.offset += var24;
                    }
                }

                if (var2.offset == 8) {
                    var2.offset = 0;
                    UrlRequester.field2126 = var2.readLong();
                    loginState = 5;
                }
            }

            int var7;
            if (loginState == 5) {
                field957.packetBuffer.offset = 0;
                field957.method2038();
                final PacketBuffer var3 = new PacketBuffer(500);
                final int[] var19 = {(int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (UrlRequester.field2126 >> 32), (int) (UrlRequester.field2126 & -1L)};
                var3.offset = 0;
                var3.putByte(1);
                var3.putByte(field907.rsOrdinal());
                var3.putInt(var19[0]);
                var3.putInt(var19[1]);
                var3.putInt(var19[2]);
                var3.putInt(var19[3]);
                switch (field907.field2174) {
                    case 0:
                        var3.putInt(preferences.preferences.get(class228.method4120(class90.username)));
                        var3.offset += 4;
                        break;
                    case 1:
                    case 3:
                        var3.put24bitInt(Size.field369);
                        var3.offset += 5;
                        break;
                    case 2:
                        var3.offset += 8;
                }

                var3.putString(class90.password);
                var3.encryptRsa(class88.RSA_EXPONENT, class88.RSA_MODULUS);
                final PacketNode var6 = ServerPacket.method3433();
                var6.clientPacket = null;
                var6.field2503 = 0;
                var6.packetBuffer = new PacketBuffer(5000);
                var6.packetBuffer.offset = 0;
                if (gameState == 40) {
                    var6.packetBuffer.putByte(LoginPacket.field2486.id);
                } else {
                    var6.packetBuffer.putByte(LoginPacket.field2485.id);
                }

                var6.packetBuffer.putShort(0);
                var7 = var6.packetBuffer.offset;
                var6.packetBuffer.putInt(168);
                var6.packetBuffer.putBytes(var3.payload, 0, var3.offset);
                final int var8 = var6.packetBuffer.offset;
                var6.packetBuffer.putString(class90.username);
                var6.packetBuffer.putByte((isResized ? 1 : 0) << 1 | (lowMemory ? 1 : 0));
                var6.packetBuffer.putShort(canvasWidth);
                var6.packetBuffer.putShort(canvasHeight);
                final PacketBuffer var9 = var6.packetBuffer;
                if (field908 != null) {
                    var9.putBytes(field908, 0, field908.length);
                } else {
                    final byte[] var10 = MilliTimer.method3192();
                    var9.putBytes(var10, 0, var10.length);
                }

                var6.packetBuffer.putString(class55.sessionToken);
                var6.packetBuffer.putInt(WidgetNode.field795);
                final Buffer var23 = new Buffer(CombatInfo1.platformInfo.method6184());
                CombatInfo1.platformInfo.method6183(var23);
                var6.packetBuffer.putBytes(var23.payload, 0, var23.payload.length);
                var6.packetBuffer.putByte(field877);
                var6.packetBuffer.putInt(0);
                var6.packetBuffer.putInt(class71.indexInterfaces.crc);
                var6.packetBuffer.putInt(class93.indexSoundEffects.crc);
                var6.packetBuffer.putInt(Size.configsIndex.crc);
                var6.packetBuffer.putInt(WorldMapType3.indexCache3.crc);
                var6.packetBuffer.putInt(class55.indexCache4.crc);
                var6.packetBuffer.putInt(MouseRecorder.indexMaps.crc);
                var6.packetBuffer.putInt(PacketBuffer.indexTrack1.crc);
                var6.packetBuffer.putInt(class18.indexModels.crc);
                var6.packetBuffer.putInt(class151.indexSprites.crc);
                var6.packetBuffer.putInt(GameCanvas.indexTextures.crc);
                var6.packetBuffer.putInt(ClanMember.indexCache10.crc);
                var6.packetBuffer.putInt(class189.indexTrack2.crc);
                var6.packetBuffer.putInt(class190.indexScripts.crc);
                var6.packetBuffer.putInt(KeyFocusListener.indexCache13.crc);
                var6.packetBuffer.putInt(MapCacheArchiveNames.vorbisIndex.crc);
                var6.packetBuffer.putInt(MouseRecorder.indexCache15.crc);
                var6.packetBuffer.putInt(class95.indexWorldMap.crc);
                var6.packetBuffer.encryptXtea(var19, var8, var6.packetBuffer.offset);
                var6.packetBuffer.method3513(var6.packetBuffer.offset - var7);
                field957.method2052(var6);
                field957.method2039();
                field957.field1484 = new ISAACCipher(var19);

                for (int var11 = 0; var11 < 4; ++var11) {
                    var19[var11] += 50;
                }

                var2.seed(var19);
                loginState = 6;
            }

            if (loginState == 6 && ((class169) var1).getAvailable() > 0) {
                var24 = ((class169) var1).vmethod3349();
                if (var24 == 21 && gameState == 20) {
                    loginState = 7;
                } else if (var24 == 2) {
                    loginState = 9;
                } else if (var24 == 15 && gameState == 40) {
                    field957.packetLength = -1;
                    loginState = 13;
                } else if (var24 == 23 && field905 < 1) {
                    ++field905;
                    loginState = 0;
                } else {
                    if (var24 != 29) {
                        MouseInput.method1051(var24);
                        return;
                    }

                    loginState = 11;
                }
            }

            if (loginState == 7 && ((class169) var1).getAvailable() > 0) {
                field906 = (((class169) var1).vmethod3349() + 3) * 60;
                loginState = 8;
            }

            if (loginState == 8) {
                field983 = 0;
                BoundingBox3DDrawMode.method53("You have only just left another world.", "Your profile will be transferred in:", field906 / 60 + " seconds.");
                if (--field906 <= 0) {
                    loginState = 0;
                }

            } else {
                if (loginState == 9 && ((class169) var1).getAvailable() >= 13) {
                    var12 = ((class169) var1).vmethod3349() == 1;
                    ((class169) var1).vmethod3348(var2.payload, 0, 4);
                    var2.offset = 0;
                    if (var12) {
                        var13 = var2.readOpcode() << 24;
                        var13 |= var2.readOpcode() << 16;
                        var13 |= var2.readOpcode() << 8;
                        var13 |= var2.readOpcode();
                        final int var14 = class228.method4120(class90.username);
                        if (preferences.preferences.size() >= 10 && !preferences.preferences.containsKey(var14)) {
                            final Iterator var22 = preferences.preferences.entrySet().iterator();
                            var22.next();
                            var22.remove();
                        }

                        preferences.preferences.put(var14, var13);
                    }

                    if (class90.Login_isUsernameRemembered) {
                        preferences.rememberedUsername = class90.username;
                    } else {
                        preferences.rememberedUsername = null;
                    }

                    MouseInput.method1062();
                    rights = ((class169) var1).vmethod3349();
                    field1020 = ((class169) var1).vmethod3349() == 1;
                    localInteractingIndex = ((class169) var1).vmethod3349();
                    localInteractingIndex <<= 8;
                    localInteractingIndex += ((class169) var1).vmethod3349();
                    field987 = ((class169) var1).vmethod3349();
                    ((class169) var1).vmethod3348(var2.payload, 0, 1);
                    var2.offset = 0;
                    final ServerPacket[] var5 = {ServerPacket.LOGOUT, ServerPacket.LOC_ANIM, ServerPacket.IF_SET_SCROLL_POS, ServerPacket.TRIGGER_ON_DIALOG_ABORT, ServerPacket.FRIEND_LIST_LOADED, ServerPacket.MESSAGE_PRIVATE_ECHO, ServerPacket.REFLECTION_CHECKER, ServerPacket.HINT_ARROW, ServerPacket.IF_MOVE_SUB, ServerPacket.IF_SET_COLOUR, ServerPacket.DYNAMIC_REGION_PACKET, ServerPacket.UPDATE_INV_PARTIAL, ServerPacket.CAM_SHAKE, ServerPacket.UPDATE_INV_FULL, ServerPacket.SET_VARP_SMALL, ServerPacket.CLEAR_ANIMATIONS, ServerPacket.GRAND_EXCHANGE_OFFERS, ServerPacket.field2314, ServerPacket.GET_PARAMS, ServerPacket.GRAND_EXCHANGE_EVENTS, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER, ServerPacket.field2318, ServerPacket.MESSAGE_FRIENDCHANNEL, ServerPacket.OBJ_DEL, ServerPacket.UPDATE_IGNORE_LIST, ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED, ServerPacket.LOC_CUSTOMISE, ServerPacket.IF_SET_ANIM, ServerPacket.IF_SET_ANGLE, ServerPacket.IF_OPEN_SUB, ServerPacket.IF_CLOSE_SUB, ServerPacket.UPDATE_FRIEND_LIST, ServerPacket.GROUND_ITEM_SPAWN, ServerPacket.NPC_INFO_SMALL, ServerPacket.field2331, ServerPacket.IF_SET_TEXT, ServerPacket.IF_SET_NPC_HEAD, ServerPacket.UPDATE_STAT, ServerPacket.IF_SET_CLICK_MASK, ServerPacket.IF_SET_PLAYER_HEAD, ServerPacket.PLAYER_UPDATE, ServerPacket.STATIC_REGION, ServerPacket.MESSAGE_PRIVATE, ServerPacket.UPDATE_RUN_ENERGY, ServerPacket.OBJ_COUNT, ServerPacket.SET_VARP_LARGE, ServerPacket.CHAT_FILTER_SETTINGS, ServerPacket.CAM_LOOKAT, ServerPacket.CAMERA_REPOSITION, ServerPacket.NPC_INFO_LARGE, ServerPacket.UPDATE_INV_STOP_TRANSMIT, ServerPacket.LOGOUT_TRANSFER, ServerPacket.SET_MAP_FLAG, ServerPacket.MAP_PROJANIM, ServerPacket.field2361, ServerPacket.UPDATE_RUN_WEIGHT, ServerPacket.SYNTH_SOUND, ServerPacket.IF_SET_OBJECT, ServerPacket.field2338, ServerPacket.PERFORMANCE_MONITORING, ServerPacket.LOC_ADD_CHANGE, ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerPacket.IF_SET_MODEL, ServerPacket.UPDATE_UID192, ServerPacket.CAMERA_RESET, ServerPacket.PLAYER_OPTIONS, ServerPacket.IF_OPEN_TOP, ServerPacket.IF_SET_POSITION, ServerPacket.IF_SET_HIDDEN, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL, ServerPacket.field2367, ServerPacket.SOUND_AREA, ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT, ServerPacket.UPDATE_REBOOT_TIMER, ServerPacket.RUN_CLIENT_SCRIPT, ServerPacket.OBJ_ADD, ServerPacket.field2373, ServerPacket.field2374, ServerPacket.RESET_CLIENT_VARCACHE, ServerPacket.MESSAGE_GAME, ServerPacket.MINIMAP_TOGGLE, ServerPacket.field2378, ServerPacket.PLAY_SONG, ServerPacket.IF_PREBUILD_TOP_LEVEL};
                    var7 = var2.method3783();
                    if (var7 < 0 || var7 >= var5.length) {
                        throw new IOException(var7 + " " + var2.offset);
                    }

                    field957.serverPacket = var5[var7];
                    field957.packetLength = field957.serverPacket.packetLength;
                    ((class169) var1).vmethod3348(var2.payload, 0, 2);
                    var2.offset = 0;
                    field957.packetLength = var2.readUnsignedShort();

                    try {
                        class53.method824(class23.clientInstance, "zap");
                    } catch (final Throwable ignored) {
                    }

                    loginState = 10;
                }

                if (loginState == 10) {
                    if (((class169) var1).getAvailable() >= field957.packetLength) {
                        var2.offset = 0;
                        ((class169) var1).vmethod3348(var2.payload, 0, field957.packetLength);
                        field918.method5213();
                        WidgetNode.method1136();
                        class3.initializeGPI(var2);
                        ScriptState.field761 = -1;
                        class3.xteaChanged(false, var2);
                        field957.serverPacket = null;
                    }

                } else {
                    if (loginState == 11 && ((class169) var1).getAvailable() >= 2) {
                        var2.offset = 0;
                        ((class169) var1).vmethod3348(var2.payload, 0, 2);
                        var2.offset = 0;
                        Bounds.field3945 = var2.readUnsignedShort();
                        loginState = 12;
                    }

                    if (loginState == 12 && ((class169) var1).getAvailable() >= Bounds.field3945) {
                        var2.offset = 0;
                        ((class169) var1).vmethod3348(var2.payload, 0, Bounds.field3945);
                        var2.offset = 0;
                        final String var18 = var2.readString();
                        final String var20 = var2.readString();
                        final String var21 = var2.readString();
                        BoundingBox3DDrawMode.method53(var18, var20, var21);
                        class64.setGameState(10);
                    }

                    if (loginState == 13) {
                        if (field957.packetLength == -1) {
                            if (((class169) var1).getAvailable() < 2) {
                                return;
                            }

                            ((class169) var1).vmethod3348(var2.payload, 0, 2);
                            var2.offset = 0;
                            field957.packetLength = var2.readUnsignedShort();
                        }

                        if (((class169) var1).getAvailable() >= field957.packetLength) {
                            ((class169) var1).vmethod3348(var2.payload, 0, field957.packetLength);
                            var2.offset = 0;
                            var24 = field957.packetLength;
                            field918.method5230();
                            class38.method549();
                            class3.initializeGPI(var2);
                            if (var24 != var2.offset) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        ++field983;
                        if (field983 > 2000) {
                            if (field905 < 1) {
                                if (class228.port1 == class138.myWorldPort) {
                                    class138.myWorldPort = class243.port2;
                                } else {
                                    class138.myWorldPort = class228.port1;
                                }

                                ++field905;
                                loginState = 0;
                            } else {
                                MouseInput.method1051(-3);
                            }
                        }
                    }
                }
            }
        } catch (final IOException var17) {
            if (field905 < 1) {
                if (class138.myWorldPort == class228.port1) {
                    class138.myWorldPort = class243.port2;
                } else {
                    class138.myWorldPort = class228.port1;
                }

                ++field905;
                loginState = 0;
            } else {
                MouseInput.method1051(-2);
            }
        }
    }

    private void method1261() {
        if (field888 > 1) {
            --field888;
        }

        if (field915 > 0) {
            --field915;
        }

        if (socketError) {
            socketError = false;
            if (field915 > 0) {
                VarPlayerType.method4736();
            } else {
                field918.method5211();
                class64.setGameState(40);
                field2069 = field957.getSocket();
                field957.method2043();
            }

        } else {
            if (!isMenuOpen) {
                Size.method198();
            }

            int var1;
            for (var1 = 0; var1 < 100 && this.method1265(field957); ++var1) {
            }

            if (gameState == 30) {
                int var2;
                PacketNode var12;
            /* TODO
            while(WorldMapDecorationInfo.method268()) {

               var12 = WorldMapRectangle.method280(ClientPacket.field2450, field957.field1484);
               var12.packetBuffer.putByte(0);
               var2 = var12.packetBuffer.offset;
               GrandExchangeEvents.encodeClassVerifier(var12.packetBuffer);
               var12.packetBuffer.method3514(var12.packetBuffer.offset - var2);
               field957.method2052(var12);
             }
            */

                if (field918.field3825) {
                    var12 = WorldMapRectangle.method280(ClientPacket.field2414, field957.field1484);
                    var12.packetBuffer.putByte(0);
                    var2 = var12.packetBuffer.offset;
                    field918.method5225(var12.packetBuffer);
                    var12.packetBuffer.method3514(var12.packetBuffer.offset - var2);
                    field957.method2052(var12);
                    field918.method5214();
                }

                int var3;
                int var4;
                int var5;
                int var7;
                int var8;
                int var9;
                synchronized (WorldMapType2.mouseRecorder.lock) {
                    if (!field1045) {
                        WorldMapType2.mouseRecorder.index = 0;
                    } else if (MouseInput.mouseLastButton != 0 || WorldMapType2.mouseRecorder.index >= 40) {
                        final PacketNode var13 = WorldMapRectangle.method280(ClientPacket.field2476, field957.field1484);
                        var13.packetBuffer.putByte(0);
                        var3 = var13.packetBuffer.offset;
                        var4 = 0;

                        for (var5 = 0; var5 < WorldMapType2.mouseRecorder.index && var13.packetBuffer.offset - var3 < 240; ++var5) {
                            ++var4;
                            int var6 = WorldMapType2.mouseRecorder.ys[var5];
                            if (var6 < 0) {
                                var6 = 0;
                            } else if (var6 > 502) {
                                var6 = 502;
                            }

                            var7 = WorldMapType2.mouseRecorder.xs[var5];
                            if (var7 < 0) {
                                var7 = 0;
                            } else if (var7 > 764) {
                                var7 = 764;
                            }

                            var8 = var7 + var6 * 765;
                            if (WorldMapType2.mouseRecorder.ys[var5] == -1 && WorldMapType2.mouseRecorder.xs[var5] == -1) {
                                var7 = -1;
                                var6 = -1;
                                var8 = 524287;
                            }

                            if (var7 == field883 && var6 == field1113) {
                                if (field885 < 2047) {
                                    ++field885;
                                }
                            } else {
                                var9 = var7 - field883;
                                field883 = var7;
                                int var10 = var6 - field1113;
                                field1113 = var6;
                                if (field885 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                                    var9 += 32;
                                    var10 += 32;
                                    var13.packetBuffer.putShort(var10 + (field885 << 12) + (var9 << 6));
                                    field885 = 0;
                                } else if (field885 < 8) {
                                    var13.packetBuffer.put24bitInt((field885 << 19) + var8 + 8388608);
                                    field885 = 0;
                                } else {
                                    var13.packetBuffer.putInt((field885 << 19) + var8 + -1073741824);
                                    field885 = 0;
                                }
                            }
                        }

                        var13.packetBuffer.method3514(var13.packetBuffer.offset - var3);
                        field957.method2052(var13);
                        if (var4 >= WorldMapType2.mouseRecorder.index) {
                            WorldMapType2.mouseRecorder.index = 0;
                        } else {
                            WorldMapType2.mouseRecorder.index -= var4;

                            for (var5 = 0; var5 < WorldMapType2.mouseRecorder.index; ++var5) {
                                WorldMapType2.mouseRecorder.xs[var5] = WorldMapType2.mouseRecorder.xs[var5 + var4];
                                WorldMapType2.mouseRecorder.ys[var5] = WorldMapType2.mouseRecorder.ys[var5 + var4];
                            }
                        }
                    }
                }

                PacketNode var16;
                if (MouseInput.mouseLastButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
                    long var14 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
                    if (var14 > 4095L) {
                        var14 = 4095L;
                    }

                    mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis * -1L;
                    var3 = MouseInput.mouseLastPressedY;
                    if (var3 < 0) {
                        var3 = 0;
                    } else if (var3 > canvasHeight) {
                        var3 = canvasHeight;
                    }

                    var4 = MouseInput.mouseLastPressedX;
                    if (var4 < 0) {
                        var4 = 0;
                    } else if (var4 > canvasWidth) {
                        var4 = canvasWidth;
                    }

                    var5 = (int) var14;
                    var16 = WorldMapRectangle.method280(ClientPacket.field2447, field957.field1484);
                    var16.packetBuffer.putShort((MouseInput.mouseLastButton == 2 ? 1 : 0) + (var5 << 1));
                    var16.packetBuffer.putShort(var4);
                    var16.packetBuffer.putShort(var3);
                    field957.method2052(var16);
                }

                if (KeyFocusListener.field638 > 0) {
                    var12 = WorldMapRectangle.method280(ClientPacket.field2384, field957.field1484);
                    var12.packetBuffer.putShort(0);
                    var2 = var12.packetBuffer.offset;
                    final long var17 = class64.method1118();

                    for (var5 = 0; var5 < KeyFocusListener.field638; ++var5) {
                        long var19 = var17 - field1091;
                        if (var19 > 16777215L) {
                            var19 = 16777215L;
                        }

                        field1091 = var17;
                        var12.packetBuffer.method3543(KeyFocusListener.field630[var5]);
                        var12.packetBuffer.method3722((int) var19);
                    }

                    var12.packetBuffer.method3513(var12.packetBuffer.offset - var2);
                    field957.method2052(var12);
                }

                if (field953 > 0) {
                    --field953;
                }

                if (KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
                    field954 = true;
                }

                if (field954 && field953 <= 0) {
                    field953 = 20;
                    field954 = false;
                    var12 = WorldMapRectangle.method280(ClientPacket.CAMERA_POSITION, field957.field1484);
                    var12.packetBuffer.putShort(cameraPitchTarget);
                    var12.packetBuffer.method3528(mapAngle);
                    field957.method2052(var12);
                }

                if (PlayerComposition.gameFocused && !field886) {
                    field886 = true;
                    var12 = WorldMapRectangle.method280(ClientPacket.FOCUS_CHANGED, field957.field1484);
                    var12.packetBuffer.putByte(1);
                    field957.method2052(var12);
                }

                if (!PlayerComposition.gameFocused && field886) {
                    field886 = false;
                    var12 = WorldMapRectangle.method280(ClientPacket.FOCUS_CHANGED, field957.field1484);
                    var12.packetBuffer.putByte(0);
                    field957.method2052(var12);
                }

                if (Preferences.renderOverview != null) {
                    Preferences.renderOverview.method6008();
                }

                if (BoundingBox.field249) {
                    if (clanMemberManager != null) {
                        clanMemberManager.method5331();
                    }

                    MapCacheArchiveNames.method588();
                    BoundingBox.field249 = false;
                }

                if (BoundingBox3DDrawMode.plane != field881) {
                    field881 = BoundingBox3DDrawMode.plane;
                    ScriptEvent.method1141(BoundingBox3DDrawMode.plane);
                }

                if (gameState == 30) {
                    for (PendingSpawn var33 = (PendingSpawn) pendingSpawns.getFront(); var33 != null; var33 = (PendingSpawn) pendingSpawns.getNext()) {
                        if (var33.hitpoints > 0) {
                            --var33.hitpoints;
                        }

                        if (var33.hitpoints == 0) {
                            if (var33.field1146 < 0 || MessageNode.method1179(var33.field1146, var33.field1147)) {
                                class167.method3256(var33.level, var33.type, var33.x, var33.y, var33.field1146, var33.field1144, var33.field1147);
                                var33.unlink();
                            }
                        } else {
                            if (var33.delay > 0) {
                                --var33.delay;
                            }

                            if (var33.delay == 0 && var33.x >= 1 && var33.y >= 1 && var33.x <= 102 && var33.y <= 102 && (var33.id < 0 || MessageNode.method1179(var33.id, var33.field1151))) {
                                class167.method3256(var33.level, var33.type, var33.x, var33.y, var33.id, var33.orientation, var33.field1151);
                                var33.delay = -1;
                                if (var33.field1146 == var33.id && var33.field1146 == -1) {
                                    var33.unlink();
                                } else if (var33.id == var33.field1146 && var33.field1144 == var33.orientation && var33.field1147 == var33.field1151) {
                                    var33.unlink();
                                }
                            }
                        }
                    }

                    WorldMapDecorationInfo.method275();
                    ++field957.field1480;
                    if (field957.field1480 > 750) {
                        if (field915 > 0) {
                            VarPlayerType.method4736();
                        } else {
                            field918.method5211();
                            class64.setGameState(40);
                            field2069 = field957.getSocket();
                            field957.method2043();
                        }

                    } else {
                        var1 = class93.playerIndexesCount;
                        final int[] var31 = class93.playerIndices;

                        for (var3 = 0; var3 < var1; ++var3) {
                            final Player var21 = cachedPlayers[var31[var3]];
                            if (var21 != null) {
                                method234(var21);
                            }
                        }

                        for (var1 = 0; var1 < npcIndexesCount; ++var1) {
                            var2 = npcIndices[var1];
                            final NPC var22 = cachedNPCs[var2];
                            if (var22 != null) {
                                method234(var22);
                            }
                        }

                        final int[] var34 = class93.playerIndices;

                        for (var2 = 0; var2 < class93.playerIndexesCount; ++var2) {
                            final Player var41 = cachedPlayers[var34[var2]];
                            if (var41 != null && var41.overheadTextCyclesRemaining > 0) {
                                --var41.overheadTextCyclesRemaining;
                                if (var41.overheadTextCyclesRemaining == 0) {
                                    var41.overhead = null;
                                }
                            }
                        }

                        for (var2 = 0; var2 < npcIndexesCount; ++var2) {
                            var3 = npcIndices[var2];
                            final NPC var39 = cachedNPCs[var3];
                            if (var39 != null && var39.overheadTextCyclesRemaining > 0) {
                                --var39.overheadTextCyclesRemaining;
                                if (var39.overheadTextCyclesRemaining == 0) {
                                    var39.overhead = null;
                                }
                            }
                        }

                        ++field930;
                        if (cursorState != 0) {
                            field972 += 20;
                            if (field972 >= 400) {
                                cursorState = 0;
                            }
                        }

                        if (class2.field17 != null) {
                            ++mouseCrosshair;
                            if (mouseCrosshair >= 15) {
                                FontName.method5490(class2.field17);
                                class2.field17 = null;
                            }
                        }

                        final Widget var35 = BoundingBox3D.field259;
                        final Widget var32 = class7.field234;
                        BoundingBox3D.field259 = null;
                        class7.field234 = null;
                        draggedOnWidget = null;
                        field958 = false;
                        field1053 = false;
                        field952 = 0;

                        while (class160.method3183() && field952 < 128) {
                            if (rights >= 2 && KeyFocusListener.keyPressed[82] && Item.currentPressedKey == 66) {
                                String var40 = "";

                                MessageNode var36;
                                for (final Iterator var23 = class95.messages.iterator(); var23.hasNext(); var40 = var40 + var36.name + ':' + var36.value + '\n') {
                                    var36 = (MessageNode) var23.next();
                                }

                                class23.clientInstance.method898(var40);
                            } else if (field960 != 1 || class38.currentTypedKey <= 0) {
                                field968[field952] = Item.currentPressedKey;
                                field1089[field952] = class38.currentTypedKey;
                                ++field952;
                            }
                        }

                        final boolean var27 = rights >= 2;
                        if (var27 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                            var4 = localPlayer.plane - mouseWheelRotation;
                            if (var4 < 0) {
                                var4 = 0;
                            } else if (var4 > 3) {
                                var4 = 3;
                            }

                            if (var4 != localPlayer.plane) {
                                class19.method166(localPlayer.pathX[0] + class138.baseX, localPlayer.pathY[0] + class23.baseY, var4, false);
                            }

                            mouseWheelRotation = 0;
                        }

                        if (widgetRoot != -1) {
                            method400(widgetRoot, 0, 0, canvasWidth, canvasHeight, 0, 0);
                        }

                        ++cycleCntr;

                        while (true) {
                            Widget var37;
                            ScriptEvent var42;
                            Widget var43;
                            do {
                                var42 = (ScriptEvent) field1067.popFront();
                                if (var42 == null) {
                                    while (true) {
                                        do {
                                            var42 = (ScriptEvent) field1125.popFront();
                                            if (var42 == null) {
                                                while (true) {
                                                    do {
                                                        var42 = (ScriptEvent) field1066.popFront();
                                                        if (var42 == null) {
                                                            this.method1446();
                                                            if (Preferences.renderOverview != null) {
                                                                Preferences.renderOverview.method6018(BoundingBox3DDrawMode.plane, (localPlayer.x >> 7) + class138.baseX, (localPlayer.y >> 7) + class23.baseY, false);
                                                                Preferences.renderOverview.method6034();
                                                            }

                                                            if (draggedWidget != null) {
                                                                this.method1271();
                                                            }

                                                            if (UrlRequest.field2137 != null) {
                                                                FontName.method5490(UrlRequest.field2137);
                                                                ++itemPressedDuration;
                                                                if (MouseInput.mouseCurrentButton == 0) {
                                                                    if (field1051) {
                                                                        if (class36.widget == UrlRequest.field2137 && field977 != field980) {
                                                                            final Widget var44 = UrlRequest.field2137;
                                                                            byte var28 = 0;
                                                                            if (field1096 == 1 && var44.contentType == 206) {
                                                                                var28 = 1;
                                                                            }

                                                                            if (var44.itemIds[field980] <= 0) {
                                                                                var28 = 0;
                                                                            }

                                                                            var7 = GroundObject.getWidgetClickMask(var44);
                                                                            final boolean var29 = (var7 >> 29 & 1) != 0;
                                                                            if (var29) {
                                                                                var8 = field977;
                                                                                var9 = field980;
                                                                                var44.itemIds[var9] = var44.itemIds[var8];
                                                                                var44.itemQuantities[var9] = var44.itemQuantities[var8];
                                                                                var44.itemIds[var8] = -1;
                                                                                var44.itemQuantities[var8] = 0;
                                                                            } else if (var28 == 1) {
                                                                                var8 = field977;
                                                                                var9 = field980;

                                                                                while (var8 != var9) {
                                                                                    if (var8 > var9) {
                                                                                        var44.method4461(var8 - 1, var8);
                                                                                        --var8;
                                                                                    } else if (var8 < var9) {
                                                                                        var44.method4461(var8 + 1, var8);
                                                                                        ++var8;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                var44.method4461(field980, field977);
                                                                            }

                                                                            final PacketNode var24 = WorldMapRectangle.method280(ClientPacket.field2423, field957.field1484);
                                                                            var24.packetBuffer.putByte(var28);
                                                                            var24.packetBuffer.putShort(field977);
                                                                            var24.packetBuffer.method3551(field980);
                                                                            var24.packetBuffer.method3552(UrlRequest.field2137.id);
                                                                            field957.method2052(var24);
                                                                        }
                                                                    } else if (this.method1267()) {
                                                                        this.openMenu(field978, field912);
                                                                    } else if (menuOptionCount > 0) {
                                                                        var4 = field978;
                                                                        var5 = field912;
                                                                        final ContextMenuRow var38 = Projectile.topContextMenuRow;
                                                                        PacketBuffer.menuAction(var38.param0, var38.param1, var38.type, var38.identifier, var38.option, var4, var5);
                                                                        Projectile.topContextMenuRow = null;
                                                                    }

                                                                    mouseCrosshair = 10;
                                                                    MouseInput.mouseLastButton = 0;
                                                                    UrlRequest.field2137 = null;
                                                                } else if (itemPressedDuration >= 5 && (MouseInput.mouseLastX > field978 + 5 || MouseInput.mouseLastX < field978 - 5 || MouseInput.mouseLastY > field912 + 5 || MouseInput.mouseLastY < field912 - 5)) {
                                                                    field1051 = true;
                                                                }
                                                            }

                                                            if (Region.method2906()) {
                                                                var4 = Region.selectedRegionTileX;
                                                                var5 = Region.selectedRegionTileY;
                                                                var16 = WorldMapRectangle.method280(ClientPacket.field2395, field957.field1484);
                                                                var16.packetBuffer.putByte(5);
                                                                var16.packetBuffer.method3542(KeyFocusListener.keyPressed[82] ? (KeyFocusListener.keyPressed[81] ? 2 : 1) : 0);
                                                                var16.packetBuffer.method3550(var5 + class23.baseY);
                                                                var16.packetBuffer.method3551(var4 + class138.baseX);
                                                                field957.method2052(var16);
                                                                Region.method2892();
                                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                                cursorState = 1;
                                                                field972 = 0;
                                                                destinationX = var4;
                                                                destinationY = var5;
                                                            }

                                                            if (var35 != BoundingBox3D.field259) {
                                                                if (var35 != null) {
                                                                    FontName.method5490(var35);
                                                                }

                                                                if (BoundingBox3D.field259 != null) {
                                                                    FontName.method5490(BoundingBox3D.field259);
                                                                }
                                                            }

                                                            if (var32 != class7.field234 && field1115 == field1021) {
                                                                if (var32 != null) {
                                                                    FontName.method5490(var32);
                                                                }

                                                                if (class7.field234 != null) {
                                                                    FontName.method5490(class7.field234);
                                                                }
                                                            }

                                                            if (class7.field234 != null) {
                                                                if (field1115 < field1021) {
                                                                    ++field1115;
                                                                    if (field1115 == field1021) {
                                                                        FontName.method5490(class7.field234);
                                                                    }
                                                                }
                                                            } else if (field1115 > 0) {
                                                                --field1115;
                                                            }

                                                            Ignore.method5385();
                                                            if (field1111) {
                                                                Widget.method4465();
                                                            }

                                                            for (var4 = 0; var4 < 5; ++var4) {
                                                                ++field1116[var4];
                                                            }

                                                            SceneTilePaint.varcs.process();
                                                            var4 = Frames.method3065();
                                                            var5 = WorldMapType3.method235();
                                                            if (var4 > 15000 && var5 > 15000) {
                                                                field915 = 250;
                                                                class25.setMouseIdleTicks(14500);
                                                                var16 = WorldMapRectangle.method280(ClientPacket.field2482, field957.field1484);
                                                                field957.method2052(var16);
                                                            }

                                                            WorldMapRectangle.friendManager.checkForFriendStateChange();
                                                            ++field957.field1485;
                                                            if (field957.field1485 > 50) {
                                                                var16 = WorldMapRectangle.method280(ClientPacket.field2452, field957.field1484);
                                                                field957.method2052(var16);
                                                            }

                                                            try {
                                                                field957.method2039();
                                                            } catch (final IOException var25) {
                                                                if (field915 > 0) {
                                                                    VarPlayerType.method4736();
                                                                } else {
                                                                    field918.method5211();
                                                                    class64.setGameState(40);
                                                                    field2069 = field957.getSocket();
                                                                    field957.method2043();
                                                                }
                                                            }

                                                            return;
                                                        }

                                                        var43 = var42.widget;
                                                        if (var43.index < 0) {
                                                            break;
                                                        }

                                                        var37 = class44.getWidget(var43.parentId);
                                                    }
                                                    while (var37 == null || var37.children == null || var43.index >= var37.children.length || var43 != var37.children[var43.index]);

                                                    AbstractSoundSystem.method2256(var42);
                                                }
                                            }

                                            var43 = var42.widget;
                                            if (var43.index < 0) {
                                                break;
                                            }

                                            var37 = class44.getWidget(var43.parentId);
                                        }
                                        while (var37 == null || var37.children == null || var43.index >= var37.children.length || var43 != var37.children[var43.index]);

                                        AbstractSoundSystem.method2256(var42);
                                    }
                                }

                                var43 = var42.widget;
                                if (var43.index < 0) {
                                    break;
                                }

                                var37 = class44.getWidget(var43.parentId);
                            }
                            while (var37 == null || var37.children == null || var43.index >= var37.children.length || var43 != var37.children[var43.index]);

                            AbstractSoundSystem.method2256(var42);
                        }
                    }
                }
            }
        }
    }

    private void method1263() {
        if (preferences != null) {
            try {
                final Client client = class23.clientInstance;
                final int var4 = isResized ? 2 : 1;
                class53.method820(client, "resize", new Object[]{var4});
            } catch (final Throwable ignored) {
            }
        }

    }

    private void method1264() {
        int var1;
        if (widgetRoot != -1) {
            var1 = widgetRoot;
            if (class189.loadWidget(var1)) {
                class47.method739(MouseRecorder.widgets[var1], -1);
            }
        }

        for (var1 = 0; var1 < widgetCount; ++var1) {
            if (field1072[var1]) {
                field1073[var1] = true;
            }

            field1074[var1] = field1072[var1];
            field1072[var1] = false;
        }

        field1071 = gameCycle;
        field991 = -1;
        field1019 = -1;
        class36.widget = null;
        if (widgetRoot != -1) {
            widgetCount = 0;
            class88.method1893(widgetRoot, 0, 0, canvasWidth, canvasHeight, 0, 0, -1);
        }

        Rasterizer2D.noClip();
        if (!isMenuOpen) {
            if (field991 != -1) {
                method1903(field991, field1019);
            }
        } else {
            class195.method3741();
        }

        if (gameDrawingMode == 3) {
            for (var1 = 0; var1 < widgetCount; ++var1) {
                if (field1074[var1]) {
                    Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
                } else if (field1073[var1]) {
                    Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
                }
            }
        }

        var1 = BoundingBox3DDrawMode.plane;
        final int var2 = localPlayer.x;
        final int var3 = localPlayer.y;
        final int var4 = field930;

        for (class80 var5 = (class80) class80.field1263.getFront(); var5 != null; var5 = (class80) class80.field1263.getNext()) {
            if (var5.ambientSoundId != -1 || var5.field1274 != null) {
                int var6 = 0;
                if (var2 > var5.field1269) {
                    var6 += var2 - var5.field1269;
                } else if (var2 < var5.field1265) {
                    var6 += var5.field1265 - var2;
                }

                if (var3 > var5.field1262) {
                    var6 += var3 - var5.field1262;
                } else if (var3 < var5.field1261) {
                    var6 += var5.field1261 - var3;
                }

                if (var6 - 64 <= var5.field1273 && field951 != 0 && var1 == var5.field1259) {
                    var6 -= 64;
                    if (var6 < 0) {
                        var6 = 0;
                    }

                    final int var7 = (var5.field1273 - var6) * field951 / var5.field1273;
                    if (var5.field1266 == null) {
                        if (var5.ambientSoundId >= 0) {
                            final SoundEffect var8 = SoundEffect.getTrack(class55.indexCache4, var5.ambientSoundId, 0);
                            if (var8 != null) {
                                final RawAudioNode var9 = var8.method2124().applyResampler(WorldMapDecoration.field446);
                                final class115 var10 = class115.method2317(var9, 100, var7);
                                var10.method2320(-1);
                                MouseInput.field727.method2059(var10);
                                var5.field1266 = var10;
                            }
                        }
                    } else {
                        var5.field1266.method2321(var7);
                    }

                    if (var5.field1271 == null) {
                        if (var5.field1274 != null && (var5.field1270 -= var4) <= 0) {
                            final int var12 = (int) (Math.random() * var5.field1274.length);
                            final SoundEffect var13 = SoundEffect.getTrack(class55.indexCache4, var5.field1274[var12], 0);
                            if (var13 != null) {
                                final RawAudioNode var14 = var13.method2124().applyResampler(WorldMapDecoration.field446);
                                final class115 var11 = class115.method2317(var14, 100, var7);
                                var11.method2320(0);
                                MouseInput.field727.method2059(var11);
                                var5.field1271 = var11;
                                var5.field1270 = var5.field1267 + (int) (Math.random() * (var5.field1268 - var5.field1267));
                            }
                        }
                    } else {
                        var5.field1271.method2321(var7);
                        if (!var5.field1271.linked()) {
                            var5.field1271 = null;
                        }
                    }
                } else {
                    if (var5.field1266 != null) {
                        MouseInput.field727.method2060(var5.field1266);
                        var5.field1266 = null;
                    }

                    if (var5.field1271 != null) {
                        MouseInput.field727.method2060(var5.field1271);
                        var5.field1271 = null;
                    }
                }
            }
        }

        field930 = 0;
    }

    private boolean method1265(final NetWriter var1) {
        class169 var2 = var1.getSocket();
        final PacketBuffer var3 = var1.packetBuffer;
        if (var2 == null) {
            return false;
        } else {
            String var5;
            int var6;
            try {
                if (var1.serverPacket == null) {
                    if (var1.field1489) {
                        if (!var2.vmethod3335(1)) {
                            return false;
                        }

                        var2.vmethod3348(var1.packetBuffer.payload, 0, 1);
                        var1.field1480 = 0;
                        var1.field1489 = false;
                    }

                    var3.offset = 0;
                    if (var3.method3780()) {
                        if (!var2.vmethod3335(1)) {
                            return false;
                        }

                        var2.vmethod3348(var1.packetBuffer.payload, 1, 1);
                        var1.field1480 = 0;
                    }

                    var1.field1489 = true;
                    final ServerPacket[] var4 = {ServerPacket.LOGOUT, ServerPacket.LOC_ANIM, ServerPacket.IF_SET_SCROLL_POS, ServerPacket.TRIGGER_ON_DIALOG_ABORT, ServerPacket.FRIEND_LIST_LOADED, ServerPacket.MESSAGE_PRIVATE_ECHO, ServerPacket.REFLECTION_CHECKER, ServerPacket.HINT_ARROW, ServerPacket.IF_MOVE_SUB, ServerPacket.IF_SET_COLOUR, ServerPacket.DYNAMIC_REGION_PACKET, ServerPacket.UPDATE_INV_PARTIAL, ServerPacket.CAM_SHAKE, ServerPacket.UPDATE_INV_FULL, ServerPacket.SET_VARP_SMALL, ServerPacket.CLEAR_ANIMATIONS, ServerPacket.GRAND_EXCHANGE_OFFERS, ServerPacket.field2314, ServerPacket.GET_PARAMS, ServerPacket.GRAND_EXCHANGE_EVENTS, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER, ServerPacket.field2318, ServerPacket.MESSAGE_FRIENDCHANNEL, ServerPacket.OBJ_DEL, ServerPacket.UPDATE_IGNORE_LIST, ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED, ServerPacket.LOC_CUSTOMISE, ServerPacket.IF_SET_ANIM, ServerPacket.IF_SET_ANGLE, ServerPacket.IF_OPEN_SUB, ServerPacket.IF_CLOSE_SUB, ServerPacket.UPDATE_FRIEND_LIST, ServerPacket.GROUND_ITEM_SPAWN, ServerPacket.NPC_INFO_SMALL, ServerPacket.field2331, ServerPacket.IF_SET_TEXT, ServerPacket.IF_SET_NPC_HEAD, ServerPacket.UPDATE_STAT, ServerPacket.IF_SET_CLICK_MASK, ServerPacket.IF_SET_PLAYER_HEAD, ServerPacket.PLAYER_UPDATE, ServerPacket.STATIC_REGION, ServerPacket.MESSAGE_PRIVATE, ServerPacket.UPDATE_RUN_ENERGY, ServerPacket.OBJ_COUNT, ServerPacket.SET_VARP_LARGE, ServerPacket.CHAT_FILTER_SETTINGS, ServerPacket.CAM_LOOKAT, ServerPacket.CAMERA_REPOSITION, ServerPacket.NPC_INFO_LARGE, ServerPacket.UPDATE_INV_STOP_TRANSMIT, ServerPacket.LOGOUT_TRANSFER, ServerPacket.SET_MAP_FLAG, ServerPacket.MAP_PROJANIM, ServerPacket.field2361, ServerPacket.UPDATE_RUN_WEIGHT, ServerPacket.SYNTH_SOUND, ServerPacket.IF_SET_OBJECT, ServerPacket.field2338, ServerPacket.PERFORMANCE_MONITORING, ServerPacket.LOC_ADD_CHANGE, ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerPacket.IF_SET_MODEL, ServerPacket.UPDATE_UID192, ServerPacket.CAMERA_RESET, ServerPacket.PLAYER_OPTIONS, ServerPacket.IF_OPEN_TOP, ServerPacket.IF_SET_POSITION, ServerPacket.IF_SET_HIDDEN, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL, ServerPacket.field2367, ServerPacket.SOUND_AREA, ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT, ServerPacket.UPDATE_REBOOT_TIMER, ServerPacket.RUN_CLIENT_SCRIPT, ServerPacket.OBJ_ADD, ServerPacket.field2373, ServerPacket.field2374, ServerPacket.RESET_CLIENT_VARCACHE, ServerPacket.MESSAGE_GAME, ServerPacket.MINIMAP_TOGGLE, ServerPacket.field2378, ServerPacket.PLAY_SONG, ServerPacket.IF_PREBUILD_TOP_LEVEL};
                    var6 = var3.method3783();
                    if (var6 < 0 || var6 >= var4.length) {
                        throw new IOException(var6 + " " + var3.offset);
                    }

                    if (var6 != 14 && var6 != 29 && var6 != 40 && var6 != 45 && var6 != 18 && var6 != 46 && var6 != 79 && var6 != 6 && var6 != 63
                            && var6 != 78 && var6 != 33 && var6 != 32 && var6 != 13 && var6 != 59 && var6 != 74
                            && var6 != 37 && var6 != 82 && var6 != 35 && var6 != 66 && var6 != 38 && var6 != 64
                            && var6 != 65 && var6 != 43 && var6 != 15 && var6 != 19 && var6 != 16 && var6 != 24
                            && var6 != 31 && var6 != 8 && var6 != 52 && var6 != 30 && var6 != 80 && var6 != 25 && var6 != 75
                            && var6 != 56 && var6 != 39 && var6 != 27 && var6 != 60 && var6 != 41 && var6 != 11 && var6 != 55
                            && var6 != 50 && var6 != 3 && var6 != 61 && var6 != 68 && var6 != 47 && var6 != 48 && var6 != 57
                            && var6 != 23 && var6 != 36 && var6 != 0
                            )
                        System.out.println("packet " + var6);

                    var1.serverPacket = var4[var6];
                    var1.packetLength = var1.serverPacket.packetLength;
                }

                if (var1.packetLength == -1) {
                    if (!var2.vmethod3335(1)) {
                        return false;
                    }

                    var1.getSocket().vmethod3348(var3.payload, 0, 1);
                    var1.packetLength = var3.payload[0] & 255;
                }

                if (var1.packetLength == -2) {
                    if (!var2.vmethod3335(2)) {
                        return false;
                    }

                    var1.getSocket().vmethod3348(var3.payload, 0, 2);
                    var3.offset = 0;
                    var1.packetLength = var3.readUnsignedShort();
                }

                if (!var2.vmethod3335(var1.packetLength)) {
                    return false;
                }

                var3.offset = 0;
                var2.vmethod3348(var3.payload, 0, var1.packetLength);
                var1.field1480 = 0;
                field918.method5210();
                var1.field1493 = var1.field1492;
                var1.field1492 = var1.field1495;
                var1.field1495 = var1.serverPacket;
                int var23;
                final Widget var68;
                if (ServerPacket.IF_SET_PLAYER_HEAD == var1.serverPacket) {
                    var23 = var3.readInt();

                    System.out.println(String.format("sendSetInterfacePlayerHead(%d, %d)", var23 >> 16, var23 & 0xFF));

                    var68 = class44.getWidget(var23);
                    var68.modelType = 3;
                    var68.modelId = localPlayer.composition.method4385();
                    FontName.method5490(var68);
                    var1.serverPacket = null;
                    return true;
                }

                int var24;
                final Widget var70;
                if (ServerPacket.IF_SET_POSITION == var1.serverPacket) {
                    var23 = var3.method3556();
                    var24 = var3.getIntLE();
                    var6 = var3.method3595();
                    var70 = class44.getWidget(var24);

                    System.out.println(String.format("sendSetInterfacePosition(%d, %d, %d, %d)", var24 >> 16, var24 & 0xFF, var23, var6));

                    if (var23 != var70.originalX || var6 != var70.originalY || var70.dynamicX != 0 || var70.dynamicY != 0) {
                        var70.originalX = var23;
                        var70.originalY = var6;
                        var70.dynamicX = 0;
                        var70.dynamicY = 0;
                        FontName.method5490(var70);
                        this.widgetMethod0(var70);
                        if (var70.type == 0) {
                            class86.method1889(MouseRecorder.widgets[var24 >> 16], var70, false);
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_CLOSE_SUB == var1.serverPacket) {
                    var23 = var3.readInt();

                    System.out.println(String.format("sendCloseWidgetSub(%d, %d)", var23 >> 16, var23 & 0xFF));

                    final WidgetNode var72 = (WidgetNode) componentTable.get(var23);
                    if (var72 != null) {
                        class57.closeWidget(var72, true);
                    }

                    if (field1033 != null) {
                        FontName.method5490(field1033);
                        field1033 = null;
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.CHAT_FILTER_SETTINGS == var1.serverPacket) {
                    field1084 = var3.method3538();
                    publicChatMode = var3.readUnsignedShortOb1();

                    System.out.println(String.format("setPublicChatMode %d %d", field1084, publicChatMode));

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SET_VARP_LARGE == var1.serverPacket) {
                    var23 = var3.readInt();
                    var24 = var3.readUnsignedShort();
                    System.out.println(String.format("setVarpLarge(%d, %d)", var24, var23));

                    VarpStorage.serverVarps[var24] = var23;
                    if (VarpStorage.clientVarps[var24] != var23) {
                        VarpStorage.clientVarps[var24] = var23;
                    }

                    class18.method142(var24);
                    field984[++field1054 - 1 & 31] = var24;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.GRAND_EXCHANGE_OFFERS == var1.serverPacket) {
                    var23 = var3.readUnsignedByte();
                    System.out.println("grandExchangeOffers(...)");
                    if (var3.readUnsignedByte() == 0) {
                        grandExchangeOffers[var23] = new GrandExchangeOffer();
                        var3.offset += 18;
                    } else {
                        --var3.offset;
                        grandExchangeOffers[var23] = new GrandExchangeOffer(var3);
                    }

                    field1062 = cycleCntr;
                    var1.serverPacket = null;
                    return true;
                }

                String var62;
                if (ServerPacket.RUN_CLIENT_SCRIPT == var1.serverPacket) {
                    var62 = var3.readString();
                    final Object[] var71 = new Object[var62.length() + 1];

                    for (var6 = var62.length() - 1; var6 >= 0; --var6) {
                        if (var62.charAt(var6) == 's') {
                            var71[var6 + 1] = var3.readString();
                        } else {
                            var71[var6 + 1] = var3.readInt();
                        }
                    }

                    var71[0] = var3.readInt();

                    {
                        final Object[] args = new Object[var71.length - 1];
                        System.arraycopy(var71, 1, args, 0, args.length);
                        //         System.out.println("cs2Script(" + var71[0] + ", " + Arrays.toString(args) + ", " + var62 + ");");
                        System.out.println("cs2Script(" + var71[0] + ", new Object[]{" + Arrays.toString(args) + "});//" + var62);
                    }

                    final ScriptEvent var92 = new ScriptEvent();
                    var92.objs = var71;
                    AbstractSoundSystem.method2256(var92);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.CLEAR_ANIMATIONS == var1.serverPacket) {//clearAnimations
                    System.out.println("clearAnimations()");
                    for (var23 = 0; var23 < cachedPlayers.length; ++var23) {
                        if (cachedPlayers[var23] != null) {
                            cachedPlayers[var23].animation = -1;
                        }
                    }

                    for (var23 = 0; var23 < cachedNPCs.length; ++var23) {
                        if (cachedNPCs[var23] != null) {
                            cachedNPCs[var23].animation = -1;
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS == var1.serverPacket) {
                    ParamNode.field3551 = var3.method3636();
                    WidgetNode.field794 = var3.method3538();
                    var1.serverPacket = null;
                    return true;
                }

                int var8;
                long var9;
                int var26;
                if (ServerPacket.IF_SET_CLICK_MASK == var1.serverPacket) {
                    var23 = var3.getIntLE();
                    var24 = var3.getUnsignedShortLE();
                    if (var24 == 65535) {
                        var24 = -1;
                    }

                    var6 = var3.getIntV2();
                    var26 = var3.getUnsignedShortLE();
                    if (var26 == 65535) {
                        var26 = -1;
                    }

                    final int root = var23 >> 16;
                    final int component = var23 & 0xFF;
                    System.out.println(String.format("sendSetWidgetClickMask(%d, %d, %d, %d, %d)", root, component, var24, var26, var6));

                    for (var8 = var24; var8 <= var26; ++var8) {
                        var9 = var8 + ((long) var23 << 32);
                        final Node var76 = widgetFlags.get(var9);
                        if (var76 != null) {
                            var76.unlink();
                        }

                        widgetFlags.put(new IntegerNode(var6), var9);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2331 == var1.serverPacket) {
                    var23 = var3.readUnsignedByte();
                    field960 = var23;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.PLAYER_OPTIONS == var1.serverPacket) {
                    var62 = var3.readString();
                    var24 = var3.readUnsignedByte();
                    var6 = var3.readUnsignedByte();
                    System.out.println("playerOptions(" + var24 + ", " + var6 + ", \"" + var62 + "\")");

                    if (var24 >= 1 && var24 <= 8) {
                        if (var62.equalsIgnoreCase("null")) {
                            var62 = null;
                        }

                        playerOptions[var24 - 1] = var62;
                        playerOptionsPriorities[var24 - 1] = var6 == 0;
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.STATIC_REGION == var1.serverPacket) {
                    class3.xteaChanged(false, var1.packetBuffer);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.MINIMAP_TOGGLE == var1.serverPacket) {//something todo with compass?
                    field1099 = var3.readUnsignedByte();
                    var1.serverPacket = null;
                    return true;
                }

                final Widget var25;
                final boolean var81;
                if (ServerPacket.IF_SET_HIDDEN == var1.serverPacket) {
                    var81 = var3.method3538() == 1;
                    var24 = var3.getIntV2();
                    var25 = class44.getWidget(var24);
                    System.out.println(String.format("sendSetInterfaceHidden(%d, %d, %b)", var24 >> 16, var24 & 0xFF, var81));


                    if (var81 != var25.isHidden) {
                        var25.isHidden = var81;
                        FontName.method5490(var25);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.DYNAMIC_REGION_PACKET == var1.serverPacket) {
                    class3.xteaChanged(true, var1.packetBuffer);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.MAP_PROJANIM == var1.serverPacket) {
                    class57.method869(class183.field2491);
                    var1.serverPacket = null;
                    return true;
                }

                WidgetNode var7;
                if (ServerPacket.IF_OPEN_SUB == var1.serverPacket) {
                    var23 = var3.getIntV1();
                    var24 = var3.readUnsignedShortOb1();
                    var6 = var3.getUnsignedShortLE();

                    System.out.println(String.format("sendOpenWidgetSub(%d, %d, %d, %b)", var23 >> 16, var23 & 0xFF, var6, var24 == 1));

                    var7 = (WidgetNode) componentTable.get(var23);
                    if (var7 != null) {
                        class57.closeWidget(var7, var6 != var7.id);
                    }

                    FileSystem.method4523(var23, var6, var24);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_REBOOT_TIMER == var1.serverPacket) {
                    field888 = var3.method3555() * 30;
                    field1064 = cycleCntr;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED == var1.serverPacket) {
                    WidgetNode.field794 = var3.method3636();
                    ParamNode.field3551 = var3.method3538();

                    while (var3.offset < var1.packetLength) {
                        var23 = var3.readUnsignedByte();
                        final class183[] var69 = {class183.field2491, class183.field2490, class183.field2501, class183.field2492, class183.field2489, class183.field2494, class183.field2493, class183.field2495, class183.field2497, class183.field2498};
                        final class183 var91 = var69[var23];
                        class57.method869(var91);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.OBJ_DEL == var1.serverPacket) {
                    class57.method869(class183.field2493);
                    var1.serverPacket = null;
                    return true;
                }

                int var27;
                if (ServerPacket.PLAYER_UPDATE == var1.serverPacket) {
                    var23 = var1.packetLength;
                    var24 = var3.offset;
                    class93.field1438 = 0;
                    var6 = 0;
                    var3.bitAccess();

                    for (var26 = 0; var26 < class93.playerIndexesCount; ++var26) {
                        var8 = class93.playerIndices[var26];
                        if ((class93.field1428[var8] & 1) == 0) {
                            if (var6 > 0) {
                                --var6;
                                class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                            } else {
                                var27 = var3.getBits(1);
                                if (var27 == 0) {
                                    var6 = FriendManager.method1789(var3);
                                    class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                                } else {
                                    decodeMovement(var3, var8);
                                }
                            }
                        }
                    }

                    var3.byteAccess();
                    if (var6 != 0) {
                        throw new RuntimeException();
                    }

                    var3.bitAccess();

                    for (var26 = 0; var26 < class93.playerIndexesCount; ++var26) {
                        var8 = class93.playerIndices[var26];
                        if ((class93.field1428[var8] & 1) != 0) {
                            if (var6 > 0) {
                                --var6;
                                class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                            } else {
                                var27 = var3.getBits(1);
                                if (var27 == 0) {
                                    var6 = FriendManager.method1789(var3);
                                    class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                                } else {
                                    decodeMovement(var3, var8);
                                }
                            }
                        }
                    }

                    var3.byteAccess();
                    if (var6 != 0) {
                        throw new RuntimeException();
                    }

                    var3.bitAccess();

                    for (var26 = 0; var26 < class93.field1433; ++var26) {
                        var8 = class93.field1435[var26];
                        if ((class93.field1428[var8] & 1) != 0) {
                            if (var6 > 0) {
                                --var6;
                                class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                            } else {
                                var27 = var3.getBits(1);
                                if (var27 == 0) {
                                    var6 = FriendManager.method1789(var3);
                                    class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                                } else if (ScriptEvent.decodeRegionHash(var3, var8)) {
                                    class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                                }
                            }
                        }
                    }

                    var3.byteAccess();
                    if (var6 != 0) {
                        throw new RuntimeException();
                    }

                    var3.bitAccess();

                    for (var26 = 0; var26 < class93.field1433; ++var26) {
                        var8 = class93.field1435[var26];
                        if ((class93.field1428[var8] & 1) == 0) {
                            if (var6 > 0) {
                                --var6;
                                class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                            } else {
                                var27 = var3.getBits(1);
                                if (var27 == 0) {
                                    var6 = FriendManager.method1789(var3);
                                    class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                                } else if (ScriptEvent.decodeRegionHash(var3, var8)) {
                                    class93.field1428[var8] = (byte) (class93.field1428[var8] | 2);
                                }
                            }
                        }
                    }

                    var3.byteAccess();
                    if (var6 != 0) {
                        throw new RuntimeException();
                    }

                    class93.playerIndexesCount = 0;
                    class93.field1433 = 0;

                    Player var95;
                    for (var26 = 1; var26 < 2048; ++var26) {
                        class93.field1428[var26] = (byte) (class93.field1428[var26] >> 1);
                        var95 = cachedPlayers[var26];
                        if (var95 != null) {
                            class93.playerIndices[++class93.playerIndexesCount - 1] = var26;
                        } else {
                            class93.field1435[++class93.field1433 - 1] = var26;
                        }
                    }

                    for (var6 = 0; var6 < class93.field1438; ++var6) {
                        var26 = class93.field1439[var6];
                        var95 = cachedPlayers[var26];
                        var27 = var3.readUnsignedByte();
                        if ((var27 & 32) != 0) {
                            var27 += var3.readUnsignedByte() << 8;
                        }

                        Player.processPlayerUpdateFlags(var3, var26, var95, var27);
                    }

                    if (var23 != var3.offset - var24) {
                        throw new RuntimeException(var3.offset - var24 + " " + var23);
                    }

                    if (BaseVarType.field25 != null) {
                        field1135 = gameCycle;
                        BaseVarType.field25.method4688();

                        for (var24 = 0; var24 < cachedPlayers.length; ++var24) {
                            if (cachedPlayers[var24] != null) {
                                BaseVarType.field25.method4703((cachedPlayers[var24].x >> 7) + class138.baseX, (cachedPlayers[var24].y >> 7) + class23.baseY);
                            }
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2318 == var1.serverPacket) {
                    var23 = var3.readInt();
                    if (var23 != field970) {
                        field970 = var23;
                        BoundingBox2D.method32();
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.CAMERA_RESET == var1.serverPacket) {
                    System.out.println("resetCamera()");
                    field1111 = false;

                    for (var23 = 0; var23 < 5; ++var23) {
                        field955[var23] = false;
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.OBJ_COUNT == var1.serverPacket) {
                    class57.method869(class183.field2490);
                    var1.serverPacket = null;
                    return true;
                }

                final long var10;
                final int var12;
                int var14;
                int var16;
                final int var18;
                final int var79;
                String var80;
                final String var84;
                String var88;
                if (ServerPacket.GET_PARAMS == var1.serverPacket) {
                    var62 = var3.readString();
                    System.out.println("getParams " + var62);
                    class55.sessionToken = var62;

                    try {
                        var5 = class23.clientInstance.getParameter(Parameters.field3811.key);
                        var80 = class23.clientInstance.getParameter(Parameters.field3808.key);
                        String var74 = var5 + "settings=" + var62 + "; version=1; path=/; domain=" + var80;
                        if (var62.isEmpty()) {
                            var74 = var74 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                        } else {
                            var84 = var74 + "; Expires=";
                            var10 = class64.method1118() + 94608000000L;
                            class204.gmtCalendar.setTime(new Date(var10));
                            var12 = class204.gmtCalendar.get(Calendar.DAY_OF_WEEK);
                            final int var77 = class204.gmtCalendar.get(Calendar.DAY_OF_MONTH);
                            var14 = class204.gmtCalendar.get(Calendar.MONTH);
                            var79 = class204.gmtCalendar.get(Calendar.YEAR);
                            var16 = class204.gmtCalendar.get(Calendar.HOUR_OF_DAY);
                            final int var17 = class204.gmtCalendar.get(Calendar.MINUTE);
                            var18 = class204.gmtCalendar.get(Calendar.SECOND);
                            var88 = class204.days[var12 - 1] + ", " + var77 / 10 + var77 % 10 + "-" + class204.monthLanguages[0][var14] + "-" + var79 + " " + var16 / 10 + var16 % 10 + ":" + var17 / 10 + var17 % 10 + ":" + var18 / 10 + var18 % 10 + " GMT";
                            var74 = var84 + var88 + "; Max-Age=" + 94608000L;
                        }

                        final Client var94 = class23.clientInstance;
                        var88 = "document.cookie=\"" + var74 + "\"";
                        JSObject.getWindow(var94).eval(var88);
                    } catch (final Throwable ignored) {
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER == var1.serverPacket) {
                    if (clanMemberManager != null) {
                        clanMemberManager.method5459(var3);
                    }

                    field967 = cycleCntr;
                    BoundingBox.field249 = true;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.LOGOUT_TRANSFER == var1.serverPacket) {
                    final World var65 = new World();
                    var65.address = var3.readString();
                    var65.id = var3.readUnsignedShort();
                    var24 = var3.readInt();
                    var65.mask = var24;
                    class64.setGameState(45);
                    var2.vmethod3331();
                    var2 = null;
                    class45.changeWorld(var65);
                    var1.serverPacket = null;
                    return false;
                }

                if (ServerPacket.OBJ_ADD == var1.serverPacket) {
                    class57.method869(class183.field2494);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_SET_ANIM == var1.serverPacket) {
                    var23 = var3.method3556();
                    var24 = var3.getIntV2();
                    var25 = class44.getWidget(var24);

                    System.out.println(String.format("setInterfaceAnim(%d, %d, %d)", var24 >> 16, var24 & 0xFF, var23));

                    if (var23 != var25.field2869 || var23 == -1) {
                        var25.field2869 = var23;
                        var25.sequenceFrameId = 0;
                        var25.field2945 = 0;
                        FontName.method5490(var25);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_SET_SCROLL_POS == var1.serverPacket) {
                    var23 = var3.readUnsignedShort();
                    var24 = var3.getIntLE();
                    var25 = class44.getWidget(var24);

                    System.out.println(String.format("setInterfaceScrollPos(%d, %d, %d)", var24 >> 16, var24 & 0xFF, var23));


                    if (var25 != null && var25.type == 0) {
                        if (var23 > var25.scrollHeight - var25.height) {
                            var23 = var25.scrollHeight - var25.height;
                        }

                        if (var23 < 0) {
                            var23 = 0;
                        }

                        if (var23 != var25.scrollY) {
                            var25.scrollY = var23;
                            FontName.method5490(var25);
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_SET_NPC_HEAD == var1.serverPacket) {
                    var23 = var3.getIntV1();
                    var24 = var3.readUnsignedShort();
                    var25 = class44.getWidget(var23);
                    System.out.println(String.format("setInterfaceNpcHead(%d, %d, %d)", var23 >> 16, var23 & 0xFF, var24));

                    if (var25.modelType != 2 || var24 != var25.modelId) {
                        var25.modelType = 2;
                        var25.modelId = var24;
                        FontName.method5490(var25);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2314 == var1.serverPacket) {
                    var23 = var3.readInt();
                    var68 = class44.getWidget(var23);

                    for (var6 = 0; var6 < var68.itemIds.length; ++var6) {
                        var68.itemIds[var6] = -1;
                        var68.itemIds[var6] = 0;
                    }

                    FontName.method5490(var68);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SET_VARP_SMALL == var1.serverPacket) {
                    var23 = var3.method3554();
                    final byte var96 = var3.readByte();

                    System.out.println(String.format("setVarpSmall(event %d, state %d)", var23, var96));

                    VarpStorage.serverVarps[var23] = var96;
                    if (VarpStorage.clientVarps[var23] != var96) {
                        VarpStorage.clientVarps[var23] = var96;
                    }

                    class18.method142(var23);
                    field984[++field1054 - 1 & 31] = var23;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_RUN_ENERGY == var1.serverPacket) {
                    class250.method4503();
                    energy = var3.readUnsignedByte();
                    field1064 = cycleCntr;
                    var1.serverPacket = null;
                    return true;
                }

                Widget var86;
                if (ServerPacket.IF_MOVE_SUB == var1.serverPacket) {
                    var23 = var3.getIntV1();
                    var24 = var3.getIntV2();

//               System.out.println(String.format("setInterfaceSets(%d, %d, %d, %d)", var24 >> 16, var24 & 0xFF, var23 >> 16, var23 & 0xFF));
                    System.out.println(String.format("sendInterfaceMoveSub(%d, %d, %d, %d)", var24 >> 16, var24 & 0xFF, var23 >> 16, var23 & 0xFF));

                    final WidgetNode var85 = (WidgetNode) componentTable.get(var24);
                    var7 = (WidgetNode) componentTable.get(var23);
                    if (var7 != null) {
                        class57.closeWidget(var7, var85 == null || var7.id != var85.id);
                    }

                    if (var85 != null) {
                        var85.unlink();
                        componentTable.put(var85, var23);
                    }

                    var86 = class44.getWidget(var24);
                    if (var86 != null) {
                        FontName.method5490(var86);
                    }

                    var86 = class44.getWidget(var23);
                    if (var86 != null) {
                        FontName.method5490(var86);
                        class86.method1889(MouseRecorder.widgets[var86.id >>> 16], var86, true);
                    }

                    if (widgetRoot != -1) {
                        DynamicObject.method2026(widgetRoot, 1);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                int var30;
                if (ServerPacket.UPDATE_INV_FULL == var1.serverPacket) {//13, items on interface?
                    var23 = var3.readInt();
                    var24 = var3.readUnsignedShort();

                    if (var23 < -70000) {
                        var24 += 32768;
                    }
                    System.out.println("packet 13 (items on interface?) " + var23 + " " + var24);

                    if (var23 >= 0) {
                        var25 = class44.getWidget(var23);
                    } else {
                        var25 = null;
                    }

                    if (var25 != null) {
                        for (var26 = 0; var26 < var25.itemIds.length; ++var26) {
                            var25.itemIds[var26] = 0;
                            var25.itemQuantities[var26] = 0;
                        }
                    }

                    final ItemContainer var73 = (ItemContainer) ItemContainer.itemContainers.get(var24);
                    if (var73 != null) {
                        for (var8 = 0; var8 < var73.itemIds.length; ++var8) {
                            var73.itemIds[var8] = -1;
                            var73.stackSizes[var8] = 0;
                        }
                    }

                    var26 = var3.readUnsignedShort();
                    System.out.println("packet13 " + var26);

                    for (var8 = 0; var8 < var26; ++var8) {
                        var27 = var3.method3538();
                        if (var27 == 255) {
                            var27 = var3.getIntLE();
                        }

                        var30 = var3.method3555();
                        System.out.println("packet13 " + var27 + " " + var30);
                        if (var25 != null && var8 < var25.itemIds.length) {
                            var25.itemIds[var8] = var30;
                            var25.itemQuantities[var8] = var27;
                        }

                        setItemTableSlot(var24, var8, var30 - 1, var27);
                    }

                    if (var25 != null) {
                        FontName.method5490(var25);
                    }

                    class250.method4503();
                    interfaceItemTriggers[++field1056 - 1 & 31] = var24 & 32767;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2338 == var1.serverPacket) {
                    var23 = var3.getIntV2();
                    var24 = var3.method3555();
                    var6 = var3.method3554();
                    var70 = class44.getWidget(var23);
                    var70.field2904 = var6 + (var24 << 16);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.PLAY_SONG == var1.serverPacket) {
                    var23 = var3.readUnsignedShort();
                    if (var23 == 65535) {
                        var23 = -1;
                    }

                    System.out.println(String.format("playSong(%d)", var23));


                    if (var23 == -1 && !field1102) {
                        method3165();
                    } else if (var23 != -1 && var23 != field1026 && field996 != 0 && !field1102) {
                        class163.method3213(2, PacketBuffer.indexTrack1, var23, 0, field996, false);
                    }

                    field1026 = var23;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2378 == var1.serverPacket) {//Something todo with POH triggers when entering building mode, secondary songs?
                    var23 = var3.readUnsignedShort();
                    if (var23 == 65535) {
                        var23 = -1;
                    }

                    var24 = var3.method3558();

                    if (field996 != 0 && var23 != -1) {
                        PacketNode.method3442(class189.indexTrack2, var23, 0, field996, false);
                        field1102 = true;
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL == var1.serverPacket) {//69 - clans again
                    if (var1.packetLength == 0) {
                        clanMemberManager = null;
                    } else {
                        if (clanMemberManager == null) {
                            clanMemberManager = new ClanMemberManager(GZipDecompressor.loginType, class23.clientInstance);
                        }

                        clanMemberManager.method5469(var3);
                    }

                    field967 = cycleCntr;
                    BoundingBox.field249 = true;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_SET_OBJECT == var1.serverPacket) {
                    var23 = var3.getUnsignedShortLE();
                    if (var23 == 65535) {
                        var23 = -1;
                    }

                    var24 = var3.getIntV1();
                    var6 = var3.getIntV1();
                    var70 = class44.getWidget(var6);

                    System.out.println(String.format("setInterfaceObject(%d, %d, %d, %d)", var6 >> 16, var6 & 0xFF, var23, var24));

                    final ItemComposition var89;
                    if (!var70.hasScript) {
                        if (var23 == -1) {
                            var70.modelType = 0;
                            var1.serverPacket = null;
                            return true;
                        }

                        var89 = ItemComposition.getItemDefinition(var23);
                        var70.modelType = 4;
                        var70.modelId = var23;
                        var70.rotationX = var89.xan2d;
                        var70.rotationZ = var89.yan2d;
                        var70.modelZoom = var89.zoom2d * 100 / var24;
                    } else {
                        var70.itemId = var23;
                        var70.itemQuantity = var24;
                        var89 = ItemComposition.getItemDefinition(var23);
                        var70.rotationX = var89.xan2d;
                        var70.rotationZ = var89.yan2d;
                        var70.rotationY = var89.zan2d;
                        var70.offsetX2d = var89.offsetX2d;
                        var70.offsetY2d = var89.offsetY2d;
                        var70.modelZoom = var89.zoom2d;
                        if (var89.isStackable == 1) {
                            var70.field2853 = 1;
                        } else {
                            var70.field2853 = 2;
                        }

                        if (var70.field2880 > 0) {
                            var70.modelZoom = var70.modelZoom * 32 / var70.field2880;
                        } else if (var70.originalWidth > 0) {
                            var70.modelZoom = var70.modelZoom * 32 / var70.originalWidth;
                        }

                    }
                    FontName.method5490(var70);

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.NPC_INFO_SMALL == var1.serverPacket) {
                    WorldMapRegion.updateNpcs(false, var3);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.REFLECTION_CHECKER == var1.serverPacket) {//TODO
               /*
               var23 = var1.packetLength;
               ClassInfo var67 = new ClassInfo();
               var67.count = var3.readUnsignedByte();
               var67.field3947 = var3.readInt();
               var67.type = new int[var67.count];
               var67.errorIdentifiers = new int[var67.count];
               var67.fields = new Field[var67.count];
               var67.field3951 = new int[var67.count];
               var67.methods = new Method[var67.count];
               var67.args = new byte[var67.count][][];

               for(var6 = 0; var6 < var67.count; ++var6) {
                  try {
                     var26 = var3.readUnsignedByte();
                     if(var26 != 0 && var26 != 1 && var26 != 2) {
                        if(var26 == 3 || var26 == 4) {
                           var84 = var3.readString();
                           var88 = var3.readString();
                           var30 = var3.readUnsignedByte();
                           String[] var75 = new String[var30];

                           for(var12 = 0; var12 < var30; ++var12) {
                              var75[var12] = var3.readString();
                           }

                           String var93 = var3.readString();
                           byte[][] var32 = new byte[var30][];
                           if(var26 == 3) {
                              for(var14 = 0; var14 < var30; ++var14) {
                                 var79 = var3.readInt();
                                 var32[var14] = new byte[var79];
                                 var3.readBytes(var32[var14], 0, var79);
                              }
                           }

                           var67.type[var6] = var26;
                           Class[] var97 = new Class[var30];

                           for(var79 = 0; var79 < var30; ++var79) {
                              var97[var79] = Name.loadClassFromDescriptor(var75[var79]);
                           }

                           Class var34 = Name.loadClassFromDescriptor(var93);
                           if(Name.loadClassFromDescriptor(var84).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var98 = Name.loadClassFromDescriptor(var84).getDeclaredMethods();
                           Method[] var99 = var98;

                           for(var18 = 0; var18 < var99.length; ++var18) {
                              Method var19 = var99[var18];
                              if(Reflection.getMethodName(var19).equals(var88)) {
                                 Class[] var20 = Reflection.getParameterTypes(var19);
                                 if(var97.length == var20.length) {
                                    boolean var21 = true;

                                    for(int var22 = 0; var22 < var97.length; ++var22) {
                                       if(var20[var22] != var97[var22]) {
                                          var21 = false;
                                          break;
                                       }
                                    }

                                    if(var21 && var34 == var19.getReturnType()) {
                                       var67.methods[var6] = var19;
                                    }
                                 }
                              }
                           }

                           var67.args[var6] = var32;
                        }
                     } else {
                        var84 = var3.readString();
                        var88 = var3.readString();
                        var30 = 0;
                        if(var26 == 1) {
                           var30 = var3.readInt();
                        }

                        var67.type[var6] = var26;
                        var67.field3951[var6] = var30;
                        if(Name.loadClassFromDescriptor(var84).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var67.fields[var6] = Reflection.findField(Name.loadClassFromDescriptor(var84), var88);
                     }
                  } catch (ClassNotFoundException var55) {
                     var67.errorIdentifiers[var6] = -1;
                  } catch (SecurityException var56) {
                     var67.errorIdentifiers[var6] = -2;
                  } catch (NullPointerException var57) {
                     var67.errorIdentifiers[var6] = -3;
                  } catch (Exception var58) {
                     var67.errorIdentifiers[var6] = -4;
                  } catch (Throwable var59) {
                     var67.errorIdentifiers[var6] = -5;
                  }
               }

               class326.classInfos.addFirst(var67);
               */
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_SET_TEXT == var1.serverPacket) {
                    var62 = var3.readString();
                    var24 = var3.readInt();
                    var25 = class44.getWidget(var24);
                    System.out.println(String.format("setInterfaceText(%d, %d, \"%s\")", var24 >> 16, var24 & 0xFF, var62));

                    if (!var62.equals(var25.text)) {
                        var25.text = var62;
                        FontName.method5490(var25);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2374 == var1.serverPacket) {
                    for (var23 = 0; var23 < VarpStorage.clientVarps.length; ++var23) {
                        if (VarpStorage.clientVarps[var23] != VarpStorage.serverVarps[var23]) {
                            VarpStorage.clientVarps[var23] = VarpStorage.serverVarps[var23];
                            class18.method142(var23);
                            field984[++field1054 - 1 & 31] = var23;
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_UID192 == var1.serverPacket) {
                    var3.offset += 28;
                    if (var3.checkCrc()) {
                        class255.method4512(var3, var3.offset - 28);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.LOC_ADD_CHANGE == var1.serverPacket) {
                    class57.method869(class183.field2498);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SOUND_AREA == var1.serverPacket) {
                    class57.method869(class183.field2495);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_OPEN_TOP == var1.serverPacket) {
                    var23 = var3.method3554();

                    System.out.println(String.format("setTopInterface(%d)", var23));

                    widgetRoot = var23;
                    this.method1345(false);
                    BoundingBox.method45(var23);
                    class20.runWidgetOnLoadListener(widgetRoot);

                    for (var24 = 0; var24 < 100; ++var24) {
                        field1072[var24] = true;
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.GROUND_ITEM_SPAWN == var1.serverPacket) {
                    ParamNode.field3551 = var3.readUnsignedShortOb1();
                    WidgetNode.field794 = var3.readUnsignedByte();

//               System.out.println("ground item spawn "+ParamNode.field3551+" "+WidgetNode.field794);

                    for (var23 = WidgetNode.field794; var23 < WidgetNode.field794 + 8; ++var23) {
                        for (var24 = ParamNode.field3551; var24 < ParamNode.field3551 + 8; ++var24) {
                            if (groundItemDeque[BoundingBox3DDrawMode.plane][var23][var24] != null) {
                                groundItemDeque[BoundingBox3DDrawMode.plane][var23][var24] = null;
                                class18.groundItemSpawned(var23, var24);
                            }
                        }
                    }

                    for (PendingSpawn var63 = (PendingSpawn) pendingSpawns.getFront(); var63 != null; var63 = (PendingSpawn) pendingSpawns.getNext()) {
                        if (var63.x >= WidgetNode.field794 && var63.x < WidgetNode.field794 + 8 && var63.y >= ParamNode.field3551 && var63.y < ParamNode.field3551 + 8 && var63.level == BoundingBox3DDrawMode.plane) {
                            var63.hitpoints = 0;
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2367 == var1.serverPacket) {//Something to do with world map zoom?
                    var81 = var3.readUnsignedByteAsBool();
                    if (var81) {
                        if (BaseVarType.field25 == null) {
                            BaseVarType.field25 = new class265();
                        }
                    } else {
                        BaseVarType.field25 = null;
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2361 == var1.serverPacket) {
                    class57.method869(class183.field2501);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT == var1.serverPacket) {
                    class46.field579 = class320.method1(var3.readUnsignedByte());
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_SET_ANGLE == var1.serverPacket) {
                    var23 = var3.method3554();
                    var24 = var3.method3554();
                    var6 = var3.getIntV1();
                    var26 = var3.method3554();
                    var86 = class44.getWidget(var6);

                    System.out.println(String.format("sendInterfaceAngle(%d, %d, X %d, Z %d, Zoom %d)", var6 >> 16, var6 & 0xFF, var23, var26, var24));


                    if (var23 != var86.rotationX || var26 != var86.rotationZ || var24 != var86.modelZoom) {
                        var86.rotationX = var23;
                        var86.rotationZ = var26;
                        var86.modelZoom = var24;
                        FontName.method5490(var86);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_FRIEND_LIST == var1.serverPacket) {
                    System.out.println("setFrieldsList(...)");
                    WorldMapRectangle.friendManager.method1734(var3, var1.packetLength);
                    field1060 = cycleCntr;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.NPC_INFO_LARGE == var1.serverPacket) {
                    WorldMapRegion.updateNpcs(true, var3);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2373 == var1.serverPacket) {
                    class57.method869(class183.field2489);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_SET_COLOUR == var1.serverPacket) {
                    var23 = var3.readUnsignedShort();
                    var24 = var3.getIntV1();
                    var6 = var23 >> 10 & 31;
                    var26 = var23 >> 5 & 31;
                    var8 = var23 & 31;
                    var27 = (var26 << 11) + (var6 << 19) + (var8 << 3);
                    final Widget var101 = class44.getWidget(var24);

                    System.out.println(String.format("setInterfaceColour(%d, %d, %d)", var24 >> 16, var24 & 0xFF, var23));


                    if (var27 != var101.textColor) {
                        var101.textColor = var27;
                        FontName.method5490(var101);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.GRAND_EXCHANGE_EVENTS == var1.serverPacket) {
                    var81 = var3.readUnsignedByte() == 1;

                    if (var81) {
                        System.out.println("grandExchangeEvents(" + var81 + "......)");

                        class71.field834 = class64.method1118() - var3.readLong();
                        class55.grandExchangeEvents = new GrandExchangeEvents(var3);
                    } else {
                        System.out.println("grandExchangeEvents(" + var81 + ")");
                        class55.grandExchangeEvents = null;
                    }

                    field1063 = cycleCntr;
                    var1.serverPacket = null;
                    return true;
                }

                final String var36;
                final long var38;
                final long var40;
                if (ServerPacket.MESSAGE_PRIVATE == var1.serverPacket) {
                    var62 = var3.readString();
                    var38 = var3.readUnsignedShort();
                    var40 = var3.read24BitInt();
                    final ChatCrownType[] var87 = {ChatCrownType.STAFF_MODERATOR, ChatCrownType.PLAYER_MODERATOR, ChatCrownType.IRONMAN, ChatCrownType.HARDCORE_IRONMAN, ChatCrownType.PLAYER, ChatCrownType.ULTIMATE_IRONMAN};
                    final ChatCrownType var100 = (ChatCrownType) Enumerated.forOrdinal(var87, var3.readUnsignedByte());
                    final long var42 = var40 + (var38 << 32);
                    boolean var13 = false;

                    for (var14 = 0; var14 < 100; ++var14) {
                        if (field1077[var14] == var42) {
                            var13 = true;
                            break;
                        }
                    }

                    if (WorldMapRectangle.friendManager.isIgnored(new Name(var62, GZipDecompressor.loginType))) {
                        var13 = true;
                    }

                    if (!var13 && myPlayerIndex == 0) {
                        field1077[field1087] = var42;
                        field1087 = (field1087 + 1) % 100;
                        final String var33 = FontTypeFace.appendTags(class303.method5406(WallObject.method3061(var3)));
                        final byte var78;
                        if (var100.moderator) {
                            var78 = 7;
                        } else {
                            var78 = 3;
                        }

                        if (var100.icon != -1) {
                            var18 = var100.icon;
                            var36 = "<img=" + var18 + ">";
                            class57.sendGameMessage(var78, var36 + var62, var33);
                        } else {
                            class57.sendGameMessage(var78, var62, var33);
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.IF_SET_MODEL == var1.serverPacket) {
                    var23 = var3.method3554();
                    var24 = var3.getIntV1();
                    var25 = class44.getWidget(var24);

                    System.out.println(String.format("setInterfaceModel(%d, %d, id %d)", var24 >> 16, var24 & 0xFF, var23));

                    if (var25.modelType != 1 || var23 != var25.modelId) {
                        var25.modelType = 1;
                        var25.modelId = var23;
                        FontName.method5490(var25);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.HINT_ARROW == var1.serverPacket) {
                    hintArrowTargetType = var3.readUnsignedByte();
                    if (hintArrowTargetType == 1) {
                        hintArrowNpcTargetIdx = var3.readUnsignedShort();
                    }

                    if (hintArrowTargetType >= 2 && hintArrowTargetType <= 6) {
                        if (hintArrowTargetType == 2) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 3) {
                            hintArrowOffsetX = 0;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 4) {
                            hintArrowOffsetX = 128;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 5) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 0;
                        }

                        if (hintArrowTargetType == 6) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 128;
                        }

                        hintArrowTargetType = 2;
                        hintArrowX = var3.readUnsignedShort();
                        hintArrowY = var3.readUnsignedShort();
                        hintArrowOffsetZ = var3.readUnsignedByte();
                    }

                    if (hintArrowTargetType == 10) {
                        hintArrowPlayerTargetIdx = var3.readUnsignedShort();
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.TRIGGER_ON_DIALOG_ABORT == var1.serverPacket) {
                    if (widgetRoot != -1) {
                        DynamicObject.method2026(widgetRoot, 0);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_INV_STOP_TRANSMIT == var1.serverPacket) {
                    var23 = var3.method3555();
                    final ItemContainer var66 = (ItemContainer) ItemContainer.itemContainers.get(var23);
                    if (var66 != null) {
                        var66.unlink();
                    }

                    interfaceItemTriggers[++field1056 - 1 & 31] = var23 & 32767;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.MESSAGE_PRIVATE_ECHO == var1.serverPacket) {
                    var62 = var3.readString();
                    var5 = FontTypeFace.appendTags(class303.method5406(WallObject.method3061(var3)));
                    class57.sendGameMessage(6, var62, var5);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.MESSAGE_GAME == var1.serverPacket) {
                    var23 = var3.getUSmart();
                    final boolean var82 = var3.readUnsignedByte() == 1;
                    var80 = "";
                    boolean var90 = false;
                    if (var82) {
                        var80 = var3.readString();
                        if (WorldMapRectangle.friendManager.isIgnored(new Name(var80, GZipDecompressor.loginType))) {
                            var90 = true;
                        }
                    }

                    var84 = var3.readString();
                    if (!var90) {
                        class57.sendGameMessage(var23, var80, var84);
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_IGNORE_LIST == var1.serverPacket) {
                    System.out.println("setIgnoreList(...)");
                    WorldMapRectangle.friendManager.field1254.method5294(var3, var1.packetLength);
                    class197.method3746();
                    field1060 = cycleCntr;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.CAMERA_REPOSITION == var1.serverPacket) {
                    field1111 = true;
                    field3697 = var3.readUnsignedByte();
                    BoundingBox2D.field248 = var3.readUnsignedByte();
                    Signlink.field2217 = var3.readUnsignedShort();
                    TotalQuantityComparator.field302 = var3.readUnsignedByte();
                    ScriptVarType.field230 = var3.readUnsignedByte();
                    if (ScriptVarType.field230 >= 100) {
                        var23 = field3697 * 128 + 64;
                        var24 = BoundingBox2D.field248 * 128 + 64;
                        var6 = WorldMapManager.getTileHeight(var23, var24, BoundingBox3DDrawMode.plane) - Signlink.field2217;
                        var26 = var23 - Player.cameraX;
                        var8 = var6 - GameObject.cameraZ;
                        var27 = var24 - class20.cameraY;
                        var30 = (int) Math.sqrt((var26 * var26 + var27 * var27));
                        GrandExchangeOffer.cameraPitch = (int) (Math.atan2(var8, var30) * 325.949D) & 2047;
                        cameraYaw = (int) (Math.atan2(var26, var27) * -325.949D) & 2047;
                        if (GrandExchangeOffer.cameraPitch < 128) {
                            GrandExchangeOffer.cameraPitch = 128;
                        }

                        if (GrandExchangeOffer.cameraPitch > 383) {
                            GrandExchangeOffer.cameraPitch = 383;
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.RESET_CLIENT_VARCACHE == var1.serverPacket) {
                    System.out.println("resetVarps()");
                    for (var23 = 0; var23 < class289.field3777; ++var23) {
                        final VarPlayerType var64 = class150.method3119(var23);
                        if (var64 != null) {
                            VarpStorage.serverVarps[var23] = 0;
                            VarpStorage.clientVarps[var23] = 0;
                        }
                    }

                    class250.method4503();
                    field1054 += 32;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.MESSAGE_FRIENDCHANNEL == var1.serverPacket) {
                    var62 = var3.readString();
                    var38 = var3.readLong();
                    var40 = var3.readUnsignedShort();
                    var9 = var3.read24BitInt();
                    final ChatCrownType[] var11 = {ChatCrownType.STAFF_MODERATOR, ChatCrownType.PLAYER_MODERATOR, ChatCrownType.IRONMAN, ChatCrownType.HARDCORE_IRONMAN, ChatCrownType.PLAYER, ChatCrownType.ULTIMATE_IRONMAN};
                    final ChatCrownType var31 = (ChatCrownType) Enumerated.forOrdinal(var11, var3.readUnsignedByte());
                    final long var44 = var9 + (var40 << 32);
                    boolean var15 = false;

                    for (var16 = 0; var16 < 100; ++var16) {
                        if (var44 == field1077[var16]) {
                            var15 = true;
                            break;
                        }
                    }

                    if (var31.ignorable && WorldMapRectangle.friendManager.isIgnored(new Name(var62, GZipDecompressor.loginType))) {
                        var15 = true;
                    }

                    if (!var15 && myPlayerIndex == 0) {
                        field1077[field1087] = var44;
                        field1087 = (field1087 + 1) % 100;
                        final String var35 = FontTypeFace.appendTags(class303.method5406(WallObject.method3061(var3)));
                        if (var31.icon != -1) {
                            var18 = var31.icon;
                            var36 = "<img=" + var18 + ">";
                            class20.addChatMessage(9, var36 + var62, var35, class252.method4505(var38));
                        } else {
                            class20.addChatMessage(9, var62, var35, class252.method4505(var38));
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.CAM_SHAKE == var1.serverPacket) {
                    var23 = var3.readUnsignedByte();
                    var24 = var3.readUnsignedByte();
                    var6 = var3.readUnsignedByte();
                    var26 = var3.readUnsignedByte();
                    field955[var23] = true;
                    field942[var23] = var24;
                    field1006[var23] = var6;
                    field939[var23] = var26;
                    field1116[var23] = 0;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_INV_PARTIAL == var1.serverPacket) {
                    var23 = var3.readInt();
                    var24 = var3.readUnsignedShort();
                    if (var23 < -70000) {
                        var24 += 32768;
                    }

                    if (var23 >= 0) {
                        var25 = class44.getWidget(var23);
                    } else {
                        var25 = null;
                    }

                    for (; var3.offset < var1.packetLength; setItemTableSlot(var24, var26, var8 - 1, var27)) {
                        var26 = var3.getUSmart();
                        var8 = var3.readUnsignedShort();
                        var27 = 0;
                        if (var8 != 0) {
                            var27 = var3.readUnsignedByte();
                            if (var27 == 255) {
                                var27 = var3.readInt();
                            }
                        }

                        if (var25 != null && var26 >= 0 && var26 < var25.itemIds.length) {
                            var25.itemIds[var26] = var8;
                            var25.itemQuantities[var26] = var27;
                        }
                    }

                    if (var25 != null) {
                        FontName.method5490(var25);
                    }

                    class250.method4503();
                    interfaceItemTriggers[++field1056 - 1 & 31] = var24 & 32767;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.LOC_ANIM == var1.serverPacket) {
                    class57.method869(class183.field2497);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.CAM_LOOKAT == var1.serverPacket) {
                    field1111 = true;
                    ScriptState.field755 = var3.readUnsignedByte();
                    class37.field497 = var3.readUnsignedByte();
                    Renderable.field2051 = var3.readUnsignedShort();
                    field416 = var3.readUnsignedByte();
                    class255.field3331 = var3.readUnsignedByte();

                    System.out.println(String.format("cameraLookat(%d, %d, %d, %d, %d);", ScriptState.field755, class37.field497, Renderable.field2051, field416, class255.field3331));

                    if (class255.field3331 >= 100) {
                        Player.cameraX = ScriptState.field755 * 128 + 64;
                        class20.cameraY = class37.field497 * 128 + 64;
                        GameObject.cameraZ = WorldMapManager.getTileHeight(Player.cameraX, class20.cameraY, BoundingBox3DDrawMode.plane) - Renderable.field2051;
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SYNTH_SOUND == var1.serverPacket) {
                    var23 = var3.readUnsignedShort();
                    var24 = var3.readUnsignedByte();
                    var6 = var3.readUnsignedShort();
                    if (field1075 != 0 && var24 != 0 && queuedSoundEffectCount < 50) {
                        queuedSoundEffectIDs[queuedSoundEffectCount] = var23;
                        unknownSoundValues1[queuedSoundEffectCount] = var24;
                        audioDelays[queuedSoundEffectCount] = var6;
                        audioEffects[queuedSoundEffectCount] = null;
                        soundLocations[queuedSoundEffectCount] = 0;
                        ++queuedSoundEffectCount;
                    }

                    var1.serverPacket = null;
                    return true;
                }

                long var47;
                if (ServerPacket.IF_PREBUILD_TOP_LEVEL == var1.serverPacket) {//widget flags? -- BATCHSET
                    //it sets toplevel widget, adds sub widget and sets click masks - polar
                    var23 = var3.offset + var1.packetLength;
                    var24 = var3.readUnsignedShort();
                    var6 = var3.readUnsignedShort();

                    System.out.println("IF_BATCHSET " + var24 + " " + var6);

                    if (var24 != widgetRoot) {
                        widgetRoot = var24;
                        this.method1345(false);
                        BoundingBox.method45(widgetRoot);
                        class20.runWidgetOnLoadListener(widgetRoot);

                        for (var26 = 0; var26 < 100; ++var26) {
                            field1072[var26] = true;
                        }
                    }

                    WidgetNode var37;
                    for (; var6-- > 0; var37.field793 = true) {
                        var26 = var3.readInt();
                        var8 = var3.readUnsignedShort();
                        var27 = var3.readUnsignedByte();
                        System.out.println(String.format("IF_BATCHSET(%d, %d, %d, %d)", var26 >> 16, var26 & 0xFF, var8, var27));


                        var37 = (WidgetNode) componentTable.get(var26);
                        if (var37 != null && var8 != var37.id) {
                            class57.closeWidget(var37, true);
                            var37 = null;
                        }

                        if (var37 == null) {
                            var37 = FileSystem.method4523(var26, var8, var27);
                        }
                    }

                    for (var7 = (WidgetNode) componentTable.first(); var7 != null; var7 = (WidgetNode) componentTable.next()) {
                        if (var7.field793) {
                            var7.field793 = false;
                        } else {
                            class57.closeWidget(var7, true);
                        }
                    }

                    widgetFlags = new HashTable(512);

                    while (var3.offset < var23) {
                        var26 = var3.readInt();
                        var8 = var3.readUnsignedShort();
                        var27 = var3.readUnsignedShort();
                        var30 = var3.readInt();
                        System.out.println(String.format("IF_BATCHSET(%d, %d, %d, %d, %d)", var26 >> 16, var26 & 0xFF, var8, var27, var30));

                        for (int var46 = var8; var46 <= var27; ++var46) {
                            var47 = ((long) var26 << 32) + var46;
                            widgetFlags.put(new IntegerNode(var30), var47);
                        }
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.LOC_CUSTOMISE == var1.serverPacket) {
                    class57.method869(class183.field2492);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.PERFORMANCE_MONITORING == var1.serverPacket) {
                    var23 = var3.readInt();
                    var24 = var3.readInt();
                    var26 = 0;
                    if (IndexStoreActionHandler.field3402 == null || !IndexStoreActionHandler.field3402.isValid()) {
                        try {

                            for (final GarbageCollectorMXBean var29 : ManagementFactory.getGarbageCollectorMXBeans()) {
                                if (var29.isValid()) {
                                    IndexStoreActionHandler.field3402 = var29;
                                    garbageCollectorLastCheckTimeMs = -1L;
                                    garbageCollectorLastCollectionTime = -1L;
                                }
                            }
                        } catch (final Throwable ignored) {
                        }
                    }

                    if (IndexStoreActionHandler.field3402 != null) {
                        final long var49 = class64.method1118();
                        var10 = IndexStoreActionHandler.field3402.getCollectionTime();
                        if (-1L != garbageCollectorLastCollectionTime) {
                            var47 = var10 - garbageCollectorLastCollectionTime;
                            final long var51 = var49 - garbageCollectorLastCheckTimeMs;
                            if (var51 != 0L) {
                                var26 = (int) (100L * var47 / var51);
                            }
                        }

                        garbageCollectorLastCollectionTime = var10;
                        garbageCollectorLastCheckTimeMs = var49;
                    }

                    final PacketNode var83 = WorldMapRectangle.method280(ClientPacket.field2411, field957.field1484);
                    var83.packetBuffer.putByte(FPS);
                    var83.packetBuffer.method3559(var23);
                    var83.packetBuffer.putInt(var24);
                    var83.packetBuffer.method3543(var26);
                    field957.method2052(var83);
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SET_MAP_FLAG == var1.serverPacket) {
                    destinationX = var3.readUnsignedByte();
                    if (destinationX == 255) {
                        destinationX = 0;
                    }

                    destinationY = var3.readUnsignedByte();
                    if (destinationY == 255) {
                        destinationY = 0;
                    }

                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.FRIEND_LIST_LOADED == var1.serverPacket) {
                    WorldMapRectangle.friendManager.method1733();
                    field1060 = cycleCntr;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.LOGOUT == var1.serverPacket) {
                    System.out.println("logout();");
                    VarPlayerType.method4736();
                    var1.serverPacket = null;
                    return false;
                }

                if (ServerPacket.UPDATE_RUN_WEIGHT == var1.serverPacket) {
                    class250.method4503();
                    weight = var3.readShort();
                    field1064 = cycleCntr;
                    var1.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_STAT == var1.serverPacket) {//skill llevels?
                    class250.method4503();
                    var23 = var3.getIntLE();
                    var24 = var3.method3538();
                    var6 = var3.method3636();
                    skillExperiences[var24] = var23;
                    boostedSkillLevels[var24] = var6;
                    realSkillLevels[var24] = 1;
                    System.out.println("setSkillLevel(" + var24 + ", " + var6 + ", " + var23 + ")");

                    for (var26 = 0; var26 < 98; ++var26) {
                        if (var23 >= class248.field3012[var26]) {
                            realSkillLevels[var24] = var26 + 2;
                        }
                    }

                    field1057[++field1052 - 1 & 31] = var24;
                    var1.serverPacket = null;
                    return true;
                }

                Signlink.processClientError("" + (var1.serverPacket != null ? var1.serverPacket.packetId : -1) + "," + (var1.field1492 != null ? var1.field1492.packetId : -1) + "," + (var1.field1493 != null ? var1.field1493.packetId : -1) + "," + var1.packetLength, null);
                VarPlayerType.method4736();
            } catch (final IOException var60) {
                if (field915 > 0) {
                    VarPlayerType.method4736();
                } else {
                    field918.method5211();
                    class64.setGameState(40);
                    field2069 = field957.getSocket();
                    field957.method2043();
                }
            } catch (final Exception var61) {
                var5 = "" + (var1.serverPacket != null ? var1.serverPacket.packetId : -1) + "," + (var1.field1492 != null ? var1.field1492.packetId : -1) + "," + (var1.field1493 != null ? var1.field1493.packetId : -1) + "," + var1.packetLength + "," + (localPlayer.pathX[0] + class138.baseX) + "," + (localPlayer.pathY[0] + class23.baseY) + ",";

                for (var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
                    var5 = var5 + var3.payload[var6] + ",";
                }

                Signlink.processClientError(var5, var61);
                VarPlayerType.method4736();
                var61.printStackTrace();
            }

            return true;
        }
    }

    private void method1446() {
        WidgetNode.method1133();
        if (UrlRequest.field2137 == null) {
            if (draggedWidget == null) {
                int var1 = MouseInput.mouseLastButton;
                int var2;
                final int var4;
                final int var5;
                final int var6;
                int var9;
                if (isMenuOpen) {
                    int var3;
                    if (var1 != 1 && (MapIconReference.middleMouseMovesCamera || var1 != 4)) {
                        var2 = MouseInput.mouseLastX;
                        var3 = MouseInput.mouseLastY;
                        if (var2 < class55.menuX - 10 || var2 > class55.menuX + class245.field2975 + 10 || var3 < ScriptState.menuY - 10 || var3 > ScriptState.menuY + Script.field1455 + 10) {
                            isMenuOpen = false;
                            method411(class55.menuX, ScriptState.menuY, class245.field2975, Script.field1455);
                        }
                    }

                    if (var1 == 1 || !MapIconReference.middleMouseMovesCamera && var1 == 4) {
                        var2 = class55.menuX;
                        var3 = ScriptState.menuY;
                        var4 = class245.field2975;
                        var5 = MouseInput.mouseLastPressedX;
                        var6 = MouseInput.mouseLastPressedY;
                        int var7 = -1;

                        for (int var14 = 0; var14 < menuOptionCount; ++var14) {
                            var9 = (menuOptionCount - 1 - var14) * 15 + var3 + 31;
                            if (var5 > var2 && var5 < var4 + var2 && var6 > var9 - 13 && var6 < var9 + 3) {
                                var7 = var14;
                            }
                        }

                        if (var7 != -1) {
                            method3432(var7);
                        }

                        isMenuOpen = false;
                        method411(class55.menuX, ScriptState.menuY, class245.field2975, Script.field1455);
                    }
                } else {
                    var2 = menuOptionCount - 1;
                    if ((var1 == 1 || !MapIconReference.middleMouseMovesCamera && var1 == 4) && var2 >= 0) {
                        var4 = menuTypes[var2];
                        if (var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                            label255:
                            {
                                var5 = menuActionParams0[var2];
                                var6 = menuActionParams1[var2];
                                final Widget var13 = class44.getWidget(var6);
                                var9 = GroundObject.getWidgetClickMask(var13);
                                final boolean var8 = (var9 >> 28 & 1) != 0;
                                int var11;
                                if (!var8) {
                                    var11 = GroundObject.getWidgetClickMask(var13);
                                    final boolean var10 = (var11 >> 29 & 1) != 0;
                                    if (!var10) {
                                        break label255;
                                    }
                                }

                                if (UrlRequest.field2137 != null && !field1051 && menuOptionCount > 0 && !this.method1267()) {
                                    final int var15 = field978;
                                    var11 = field912;
                                    final ContextMenuRow var12 = Projectile.topContextMenuRow;
                                    PacketBuffer.menuAction(var12.param0, var12.param1, var12.type, var12.identifier, var12.option, var15, var11);
                                    Projectile.topContextMenuRow = null;
                                }

                                field1051 = false;
                                itemPressedDuration = 0;
                                if (UrlRequest.field2137 != null) {
                                    FontName.method5490(UrlRequest.field2137);
                                }

                                UrlRequest.field2137 = class44.getWidget(var6);
                                field977 = var5;
                                field978 = MouseInput.mouseLastPressedX;
                                field912 = MouseInput.mouseLastPressedY;
                                if (var2 >= 0) {
                                    class22.method184(var2);
                                }

                                FontName.method5490(UrlRequest.field2137);
                                return;
                            }
                        }
                    }

                    if ((var1 == 1 || !MapIconReference.middleMouseMovesCamera && var1 == 4) && this.method1267()) {
                        var1 = 2;
                    }

                    if ((var1 == 1 || !MapIconReference.middleMouseMovesCamera && var1 == 4) && menuOptionCount > 0) {
                        method3432(var2);
                    }

                    if (var1 == 2 && menuOptionCount > 0) {
                        this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                    }
                }

            }
        }
    }

    private boolean method1267() {
        final int var1 = menuOptionCount - 1;
        boolean var3 = field1004 == 1 && menuOptionCount > 2;
        if (!var3) {
            final boolean var4;
            if (var1 < 0) {
                var4 = false;
            } else {
                int var5 = menuTypes[var1];
                if (var5 >= 2000) {
                    var5 -= 2000;
                }

                var4 = var5 == 1007;
            }

            var3 = var4;
        }

        return var3 && !menuBooleanArray[var1];
    }

    private void openMenu(final int var1, final int var2) {
        int var3 = MessageNode.fontBold12.getTextWidth("Choose Option");

        int var4;
        for (var4 = 0; var4 < menuOptionCount; ++var4) {
            final Font var5 = MessageNode.fontBold12;
            final String var6;
            if (var4 < 0) {
                var6 = "";
            } else if (!menuTargets[var4].isEmpty()) {
                var6 = menuOptions[var4] + " " + menuTargets[var4];
            } else {
                var6 = menuOptions[var4];
            }

            final int var7 = var5.getTextWidth(var6);
            if (var7 > var3) {
                var3 = var7;
            }
        }

        var3 += 8;
        var4 = menuOptionCount * 15 + 22;
        int var8 = var1 - var3 / 2;
        if (var8 + var3 > canvasWidth) {
            var8 = canvasWidth - var3;
        }

        if (var8 < 0) {
            var8 = 0;
        }

        int var9 = var2;
        if (var2 + var4 > canvasHeight) {
            var9 = canvasHeight - var4;
        }

        if (var9 < 0) {
            var9 = 0;
        }

        class255.region.method2889(BoundingBox3DDrawMode.plane, var1, var2, false);
        isMenuOpen = true;
        class55.menuX = var8;
        ScriptState.menuY = var9;
        class245.field2975 = var3;
        Script.field1455 = menuOptionCount * 15 + 22;
    }

    private void method1345(final boolean var1) {
        class44.method666(widgetRoot, canvasWidth, canvasHeight, var1);
    }

    void widgetMethod0(final Widget var1) {
        final Widget widget = var1.parentId == -1 ? null : class44.getWidget(var1.parentId);
        final int width;
        final int height;
        if (widget == null) {
            width = canvasWidth;
            height = canvasHeight;
        } else {
            width = widget.width;
            height = widget.height;
        }

        BoundingBox3D.method48(var1, width, height, false);
        BoundingBox3D.method52(var1, width, height);
    }

    private void method1271() {
        FontName.method5490(draggedWidget);
        ++class55.field660;
        if (field958 && field1053) {
            int var1 = MouseInput.mouseLastX;
            int var2 = MouseInput.mouseLastY;
            var1 -= field1042;
            var2 -= field1114;
            if (var1 < field1008) {
                var1 = field1008;
            }

            if (var1 + draggedWidget.width > field1008 + field937.width) {
                var1 = field1008 + field937.width - draggedWidget.width;
            }

            if (var2 < field1047) {
                var2 = field1047;
            }

            if (var2 + draggedWidget.height > field1047 + field937.height) {
                var2 = field1047 + field937.height - draggedWidget.height;
            }

            final int var3 = var1 - field1049;
            final int var4 = var2 - field882;
            final int var5 = draggedWidget.dragDeadZone;
            if (class55.field660 > draggedWidget.dragDeadTime && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
                draggingWidget = true;
            }

            final int var6 = var1 - field1008 + field937.scrollX;
            final int var7 = var2 - field1047 + field937.scrollY;
            ScriptEvent var8;
            if (draggedWidget.onDragListener != null && draggingWidget) {
                var8 = new ScriptEvent();
                var8.widget = draggedWidget;
                var8.field799 = var6;
                var8.field798 = var7;
                var8.objs = draggedWidget.onDragListener;
                AbstractSoundSystem.method2256(var8);
            }

            if (MouseInput.mouseCurrentButton == 0) {
                if (draggingWidget) {
                    if (draggedWidget.onDragCompleteListener != null) {
                        var8 = new ScriptEvent();
                        var8.widget = draggedWidget;
                        var8.field799 = var6;
                        var8.field798 = var7;
                        var8.field802 = draggedOnWidget;
                        var8.objs = draggedWidget.onDragCompleteListener;
                        AbstractSoundSystem.method2256(var8);
                    }

                    if (draggedOnWidget != null && Widget.method4692(draggedWidget) != null) {
                        final PacketNode var12 = WorldMapRectangle.method280(ClientPacket.field2465, field957.field1484);
                        var12.packetBuffer.putShort(draggedOnWidget.itemId);
                        var12.packetBuffer.method3528(draggedOnWidget.index);
                        var12.packetBuffer.method3550(draggedWidget.index);
                        var12.packetBuffer.putInt(draggedWidget.id);
                        var12.packetBuffer.putShort(draggedWidget.itemId);
                        var12.packetBuffer.method3552(draggedOnWidget.id);
                        field957.method2052(var12);
                    }
                } else if (this.method1267()) {
                    this.openMenu(field1042 + field1049, field1114 + field882);
                } else if (menuOptionCount > 0) {
                    final int var11 = field1049 + field1042;
                    final int var9 = field882 + field1114;
                    final ContextMenuRow var10 = Projectile.topContextMenuRow;
                    PacketBuffer.menuAction(var10.param0, var10.param1, var10.type, var10.identifier, var10.option, var11, var9);
                    Projectile.topContextMenuRow = null;
                }

                draggedWidget = null;
            }

        } else {
            if (class55.field660 > 1) {
                draggedWidget = null;
            }

        }
    }

    public Name vmethod5404() {
        return localPlayer != null ? localPlayer.name : null;
    }
}
