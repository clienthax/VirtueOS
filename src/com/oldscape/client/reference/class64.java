package com.oldscape.client.reference;

import java.io.IOException;
import java.net.Socket;

class class64 {
    private final IndexData field764;
    private final int field766;
    private final String info;
    private int field763;

    class64(final IndexData var1, final String var2) {
        this.field763 = 0;
        this.field764 = var1;
        this.field766 = var1.size();
        this.info = var2;
    }

    public static synchronized long method1118() {
        final long var0 = System.currentTimeMillis();
        if (var0 < class138.field2048) {
            class196.field2587 += class138.field2048 - var0;
        }

        class138.field2048 = var0;
        return var0 + class196.field2587;
    }

    public static class169 method1119(final Socket var0, final int var1, final int var2) throws IOException {
        return new class171(var0, var1, var2);
    }

    public static boolean method1112(final int var0) {
        return var0 >= WorldMapDecorationType.field2988.rsOrdinal && var0 <= WorldMapDecorationType.field2993.rsOrdinal;
    }

    public static boolean method1111(final char var0) {
        return var0 >= '0' && var0 <= '9';
    }

    static void setGameState(final int var0) {
        if (var0 != Client.gameState) {
            if (Client.gameState == 0) {
                class23.clientInstance.method922();
            }

            if (var0 == 20 || var0 == 40 || var0 == 45) {
                Client.loginState = 0;
                Client.field983 = 0;
                Client.field905 = 0;
                Client.field918.method5212(var0);
                if (var0 != 20) {
                    WorldMapType3.method232(false);
                }
            }

            if (var0 != 20 && var0 != 40 && Client.field2069 != null) {
                Client.field2069.vmethod3331();
                Client.field2069 = null;
            }

            if (Client.gameState == 25) {
                Client.field924 = 0;
                Client.field920 = 0;
                Client.field921 = 1;
                Client.field922 = 0;
                Client.field923 = 1;
            }

            if (var0 != 5 && var0 != 10) {
                if (var0 == 20) {
                    Player.method1230(ClanMember.indexCache10, class151.indexSprites, true, Client.gameState == 11 ? 4 : 0);
                } else if (var0 == 11) {
                    Player.method1230(ClanMember.indexCache10, class151.indexSprites, false, 4);
                } else if (class90.field1387) {
                    IndexStoreActionHandler.field3398 = null;
                    class90.field1388 = null;
                    class90.runeSprites = null;
                    class321.field3938 = null;
                    class90.field1381 = null;
                    class171.logoSprite = null;
                    class57.titlemuteSprite = null;
                    class90.field1363 = null;
                    class90.field1393 = null;
                    class5.field40 = null;
                    BoundingBox3DDrawMode.slFlagSprites = null;
                    VarpStorage.slArrowSprites = null;
                    World.slStarSprites = null;
                    class167.field2223 = null;
                    class21.field347 = null;
                    ScriptState.field762 = null;
                    GrandExchangeEvent.field298 = null;
                    class21.field344 = null;
                    MouseRecorder.field819 = null;
                    GrandExchangeEvents.field287 = null;
                    Huffman.field2513 = null;
                    AbstractSoundSystem.field1585 = null;
                    class229.field2687 = 1;
                    Client.field2511 = null;
                    VertexNormal.field1931 = -1;
                    GrandExchangeEvents.field284 = -1;
                    class86.field1330 = 0;
                    class229.field2692 = false;
                    class2.field11 = 2;
                    GraphicsObject.sendConInfo(true);
                    class90.field1387 = false;
                }
            } else {
                Player.method1230(ClanMember.indexCache10, class151.indexSprites, true, 0);
            }

            Client.gameState = var0;
        }
    }

    boolean method1117() {
        this.field763 = 0;

        for (int var1 = 0; var1 < this.field766; ++var1) {
            if (!this.field764.method4642(var1) || this.field764.method4636(var1)) {
                ++this.field763;
            }
        }

        return this.field763 >= this.field766;
    }
}
