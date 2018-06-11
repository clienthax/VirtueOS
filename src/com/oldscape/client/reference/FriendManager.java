package com.oldscape.client.reference;

public class FriendManager {
    public final class304 field1256;
    public final class298 field1254;
    private final JagexLoginType field1252;
    int field1253;

    FriendManager(final JagexLoginType var1) {
        this.field1253 = 0;
        this.field1252 = var1;
        this.field1256 = new class304(var1);
        this.field1254 = new class298(var1);
    }

    static void sendAlreadyOnIgnoreListMessage(final String name) {
        final StringBuilder var10000 = (new StringBuilder()).append(name);
        final String var1 = var10000.append(" is already on your ignore list").toString();
        class57.sendGameMessage(30, "", var1);
    }

    static int method1789(final PacketBuffer var0) {
        final int var1 = var0.getBits(2);
        final int var2;
        if (var1 == 0) {
            var2 = 0;
        } else if (var1 == 1) {
            var2 = var0.getBits(5);
        } else if (var1 == 2) {
            var2 = var0.getBits(8);
        } else {
            var2 = var0.getBits(11);
        }

        return var2;
    }

    public static int method1792(final int var0) {
        return var0 >> 17 & 7;
    }

    public static IndexedSprite getSprite(final IndexDataBase var0, final String var1, final String var2) {
        final int var3 = var0.getFile(var1);
        final int var4 = var0.getChild(var3, var2);
        final IndexedSprite var5;
        if (!RunException.method3215(var0, var3, var4)) {
            var5 = null;
        } else {
            var5 = IndexedSprite.method3159();
        }

        return var5;
    }

    boolean method1732() {
        return this.field1253 == 2;
    }

    final void method1733() {
        this.field1253 = 1;
    }

    final void method1734(final Buffer var1, final int var2) {
        this.field1256.method5411(var1, var2);
        this.field1253 = 2;

        for (int var3 = 0; var3 < class93.playerIndexesCount; ++var3) {
            final Player var4 = Client.cachedPlayers[class93.playerIndices[var3]];
            var4.method1188();
        }

        for (final Object message : class95.messages) {
            final MessageNode var6 = (MessageNode) message;
            var6.method1148();
        }

        if (GameEngine.clanMemberManager != null) {
            GameEngine.clanMemberManager.method5460();
        }

    }

    final void checkForFriendStateChange() {
        for (class308 var1 = (class308) this.field1256.field3856.method4061(); var1 != null; var1 = (class308) this.field1256.field3856.method4060()) {
            if (var1.field3876 < class64.method1118() / 1000L - 5L) {
                if (var1.field3875 > 0) {
                    class57.sendGameMessage(5, "", var1.name + " has logged in.");
                }

                if (var1.field3875 == 0) {
                    class57.sendGameMessage(5, "", var1.name + " has logged out.");
                }

                var1.method4067();
            }
        }

    }

    final void method1756() {
        this.field1253 = 0;
        this.field1256.method5302();
        this.field1254.method5302();
    }

    final boolean isFriended(final Name var1, final boolean var2) {
        return var1 != null && (var1.equals(Client.localPlayer.name) || this.field1256.method5414(var1, var2));
    }

    final boolean isIgnored(final Name var1) {
        return var1 != null && this.field1254.isMember(var1);
    }

    final void addToFriendsList(final String var1) {
        if (var1 != null) {
            final Name var2 = new Name(var1, this.field1252);
            if (var2.isCleanNameValid()) {
                StringBuilder var10000;
                final String var3;
                if (this.isFriendsListFull()) {
                    var3 = "Your friend list is full. Max of 200 for free users, and 400 for members";
                    class57.sendGameMessage(30, "", var3);
                } else if (Client.localPlayer.name.equals(var2)) {
                    var3 = "You can\'t add yourself to your own friend list";
                    class57.sendGameMessage(30, "", var3);
                } else {
                    if (this.isFriended(var2, false)) {
                        var10000 = (new StringBuilder()).append(var1);
                        var3 = var10000.append(" is already on your friend list").toString();
                        class57.sendGameMessage(30, "", var3);
                    } else if (this.isIgnored(var2)) {
                        var10000 = new StringBuilder();
                        var10000 = var10000.append("Please remove ").append(var1);
                        var3 = var10000.append(" from your ignore list first").toString();
                        class57.sendGameMessage(30, "", var3);
                    } else {
                        class45.method672(var1);
                    }
                }
            }
        }
    }

    private boolean isFriendsListFull() {
        return this.field1256.method5305() || this.field1256.getCount() >= 200 && Client.field987 != 1;
    }

    final void addToIgnoreList(final String var1) {
        if (var1 != null) {
            final Name var2 = new Name(var1, this.field1252);
            if (var2.isCleanNameValid()) {
                if (this.method1741()) {
                    Size.method199();
                } else {
                    StringBuilder var10000;
                    final String var3;
                    if (Client.localPlayer.name.equals(var2)) {
                        var3 = "You can\'t add yourself to your own ignore list";
                        class57.sendGameMessage(30, "", var3);
                    } else if (this.isIgnored(var2)) {
                        sendAlreadyOnIgnoreListMessage(var1);
                    } else if (this.isFriended(var2, false)) {
                        var10000 = new StringBuilder();
                        var10000 = var10000.append("Please remove ").append(var1);
                        var3 = var10000.append(" from your friend list first").toString();
                        class57.sendGameMessage(30, "", var3);
                    } else {
                        class249.method4501(var1);
                    }
                }
            }
        }
    }

    private boolean method1741() {
        return this.field1254.method5305() || this.field1254.getCount() >= 100 && Client.field987 != 1;
    }

    final void method1742(final String var1) {
        if (var1 != null) {
            final Name var2 = new Name(var1, this.field1252);
            if (var2.isCleanNameValid()) {
                if (this.field1256.method5344(var2)) {
                    OwnWorldComparator.method1248();
                    final PacketNode var3 = WorldMapRectangle.method280(ClientPacket.field2475, Client.field957.field1484);
                    var3.packetBuffer.putByte(WorldMapRegion.getLength(var1));
                    var3.packetBuffer.putString(var1);
                    Client.field957.method2052(var3);
                }

                for (int var5 = 0; var5 < class93.playerIndexesCount; ++var5) {
                    final Player var4 = Client.cachedPlayers[class93.playerIndices[var5]];
                    var4.method1188();
                }

                for (final Object message : class95.messages) {
                    final MessageNode var7 = (MessageNode) message;
                    var7.method1148();
                }

                if (GameEngine.clanMemberManager != null) {
                    GameEngine.clanMemberManager.method5460();
                }

            }
        }
    }

    final void method1743(final String var1) {
        if (var1 != null) {
            final Name var2 = new Name(var1, this.field1252);
            if (var2.isCleanNameValid()) {
                if (this.field1254.method5344(var2)) {
                    OwnWorldComparator.method1248();
                    final PacketNode var3 = WorldMapRectangle.method280(ClientPacket.field2470, Client.field957.field1484);
                    var3.packetBuffer.putByte(WorldMapRegion.getLength(var1));
                    var3.packetBuffer.putString(var1);
                    Client.field957.method2052(var3);
                }

                class197.method3746();
            }
        }
    }

    final boolean method1776(final Name var1) {
        final Friend var2 = (Friend) this.field1256.method5307(var1);
        return var2 != null && var2.method5391();
    }
}
