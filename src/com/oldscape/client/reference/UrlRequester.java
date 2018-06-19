package com.oldscape.client.reference;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

class UrlRequester implements Runnable {
    static Timer timer;
    static long field2126;
    static int selectedItemIndex;
    private final Thread thread;
    private final Queue<UrlRequest> requests;
    private volatile boolean isClosed;

    public UrlRequester() {
        this.requests = new LinkedList<>();
        this.thread = new Thread(this);
        this.thread.setPriority(1);
        this.thread.start();
    }

    static void processNpcUpdateFlags(final PacketBuffer buffer) {
        for (int npcIdx = 0; npcIdx < Client.pendingNpcFlagsCount; ++npcIdx) {
            final int var2 = Client.pendingNpcFlagsIndices[npcIdx];
            final NPC npc = Client.cachedNPCs[var2];
            final int flags = buffer.readUnsignedByte();
            int var5;
            int var6;
            int var7;
            int var8;

            //animations
            if ((flags & 4) != 0) {
                var5 = buffer.readUnsignedShort();
                if (var5 == 65535) {
                    var5 = -1;
                }

                var6 = buffer.readUnsignedShortOb1();
                if (var5 == npc.animation && var5 != -1) {
                    var7 = CombatInfo1.getAnimation(var5).replyMode;
                    if (var7 == 1) {
                        npc.actionFrame = 0;
                        npc.actionFrameCycle = 0;
                        npc.actionAnimationDisable = var6;
                        npc.field1193 = 0;
                    }

                    if (var7 == 2) {
                        npc.field1193 = 0;
                    }
                } else if (var5 == -1 || npc.animation == -1 || CombatInfo1.getAnimation(var5).forcedPriority >= CombatInfo1.getAnimation(npc.animation).forcedPriority) {
                    npc.animation = var5;
                    npc.actionFrame = 0;
                    npc.actionFrameCycle = 0;
                    npc.actionAnimationDisable = var6;
                    npc.field1193 = 0;
                    npc.field1216 = npc.queueSize;
                }
            }

            //transform
            if ((flags & 64) != 0) {
                npc.composition = NPCComposition.getNpcDefinition(buffer.readUnsignedShort());
                npc.size = npc.composition.size;
                npc.rotation = npc.composition.rotation;
                npc.walkingAnimation = npc.composition.walkingAnimation;
                npc.rotate180Animation = npc.composition.rotate180Animation;
                npc.rotate90RightAnimation = npc.composition.rotate90RightAnimation;
                npc.rotate90LeftAnimation = npc.composition.rotate90LeftAnimation;
                npc.idlePoseAnimation = npc.composition.standingAnimation;
                npc.field1163 = npc.composition.field3716;
                npc.field1164 = npc.composition.field3714;
            }

            //orientation
            if ((flags & 2) != 0) {
                var5 = buffer.readUnsignedShort();
                var6 = buffer.method3554();
                var7 = npc.x - (var5 - class138.baseX - class138.baseX) * 64;
                var8 = npc.y - (var6 - class23.baseY - class23.baseY) * 64;
                if (var7 != 0 || var8 != 0) {
                    npc.field1185 = (int) (Math.atan2(var7, var8) * 325.949D) & 2047;
                }
            }

            //face entity
            if ((flags & 32) != 0) {
                npc.interacting = buffer.method3555();
                if (npc.interacting == 65535) {
                    npc.interacting = -1;
                }
            }

            //hitmasks
            if ((flags & 16) != 0) {
                var5 = buffer.method3538();
                int var9;
                int var10;
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
                        npc.method1657(var7, var9, var8, var10, Client.gameCycle, var11);
                    }
                }

                var6 = buffer.method3538();
                if (var6 > 0) {
                    for (var7 = 0; var7 < var6; ++var7) {
                        var8 = buffer.getUSmart();
                        var9 = buffer.getUSmart();
                        if (var9 != 32767) {
                            var10 = buffer.getUSmart();
                            var11 = buffer.readUnsignedShortOb1();
                            final int var12 = var9 > 0 ? buffer.readUnsignedShortOb1() : var11;
                            npc.setCombatInfo(var8, Client.gameCycle, var9, var10, var11, var12);
                        } else {
                            npc.method1659(var8);
                        }
                    }
                }
            }

            //gfx
            if ((flags & 1) != 0) {
                npc.graphic = buffer.method3555();
                var5 = buffer.getUnsignedIntLE();
                npc.field1198 = var5 >> 16;
                npc.graphicsDelay = (var5 & 65535) + Client.gameCycle;
                npc.spotAnimFrame = 0;
                npc.spotAnimFrameCycle = 0;
                if (npc.graphicsDelay > Client.gameCycle) {
                    npc.spotAnimFrame = -1;
                }

                if (npc.graphic == 65535) {
                    npc.graphic = -1;
                }
            }

            //force chat
            if ((flags & 8) != 0) {
                npc.overhead = buffer.readString();
                npc.overheadTextCyclesRemaining = 100;
            }
        }

    }

    public UrlRequest request(final URL var1) {
        final UrlRequest var2 = new UrlRequest(var1);
        synchronized (this) {
            this.requests.add(var2);
            this.notify();
            return var2;
        }
    }

    public void close() {
        this.isClosed = true;

        try {
            synchronized (this) {
                this.notify();
            }

            this.thread.join();
        } catch (final InterruptedException ignored) {
        }

    }

    public void run() {
        while (!this.isClosed) {
            try {
                final UrlRequest var1;
                synchronized (this) {
                    var1 = this.requests.poll();
                    if (var1 == null) {
                        try {
                            this.wait();
                        } catch (final InterruptedException ignored) {
                        }
                        continue;
                    }
                }

                DataInputStream var2 = null;
                URLConnection var3 = null;

                try {
                    var3 = var1.url.openConnection();
                    var3.setConnectTimeout(5000);
                    var3.setReadTimeout(5000);
                    var3.setUseCaches(false);
                    var3.setRequestProperty("Connection", "close");
                    final int var7 = var3.getContentLength();
                    if (var7 >= 0) {
                        final byte[] var5 = new byte[var7];
                        var2 = new DataInputStream(var3.getInputStream());
                        var2.readFully(var5);
                        var1.response0 = var5;
                    }

                    var1.isDone0 = true;
                } catch (final IOException var14) {
                    var1.isDone0 = true;
                } finally {
                    if (var2 != null) {
                        var2.close();
                    }

                    if (var3 instanceof HttpURLConnection) {
                        ((HttpURLConnection) var3).disconnect();
                    }

                }
            } catch (final Exception var17) {
                Signlink.processClientError(null, var17);
            }
        }

    }
}
