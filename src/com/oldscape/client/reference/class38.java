package com.oldscape.client.reference;

class class38 {
    public static char currentTypedKey;

    static void method549() {
        Client.field957.method2038();
        Client.field957.packetBuffer.offset = 0;
        Client.field957.serverPacket = null;
        Client.field957.field1495 = null;
        Client.field957.field1492 = null;
        Client.field957.field1493 = null;
        Client.field957.packetLength = 0;
        Client.field957.field1480 = 0;
        Client.field888 = 0;
        Client.menuOptionCount = 0;
        Client.isMenuOpen = false;
        Client.field1099 = 0;
        Client.destinationX = 0;

        int var0;
        for (var0 = 0; var0 < 2048; ++var0) {
            Client.cachedPlayers[var0] = null;
        }

        Client.localPlayer = null;

        for (var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
            final NPC var1 = Client.cachedNPCs[var0];
            if (var1 != null) {
                var1.interacting = -1;
                var1.field1156 = false;
            }
        }

        class37.method544();
        class64.setGameState(30);

        for (var0 = 0; var0 < 100; ++var0) {
            Client.field1072[var0] = true;
        }

        class61.method1070();
    }

    static void method546(final int var0, final int var1) {
        if (Client.hintArrowTargetType == 2) {
            SoundTask.worldToScreen((Client.hintArrowX - class138.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - class23.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowOffsetZ * 2);
            if (Client.screenX > -1 && Client.gameCycle % 20 < 10) {
                BoundingBox3DDrawMode.headIconsHint[0].drawAt(var0 + Client.screenX - 12, Client.screenY + var1 - 28);
            }

        }
    }

    static void drawDot(final int var0, final int var1, final int var2, final int var3, final SpritePixels var4, final class236 var5) {
        if (var4 != null) {
            final int var6 = Client.mapAngle & 2047;
            final int var7 = var3 * var3 + var2 * var2;
            if (var7 <= 6400) {
                final int var8 = Graphics3D.SINE[var6];
                final int var9 = Graphics3D.COSINE[var6];
                final int var10 = var9 * var2 + var3 * var8 >> 16;
                final int var11 = var3 * var9 - var8 * var2 >> 16;
                if (var7 > 2500) {
                    var4.method5874(var10 + var5.width / 2 - var4.maxWidth / 2, var5.height / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.height, var5.field2774, var5.field2771);
                } else {
                    var4.drawAt(var0 + var10 + var5.width / 2 - var4.maxWidth / 2, var5.height / 2 + var1 - var11 - var4.maxHeight / 2);
                }

            }
        }
    }
}
