package com.oldscape.client.reference;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

class Signlink implements Runnable {
    public static String osNameLC;
    public static String javaVendor;
    public static String javaVersion;
    static int field2217;
    static Widget field2218;
    static String osName;
    private final Thread sysEventQueue;
    private Task currentTask;
    private Task cachedTask;
    private boolean closed;

    public Signlink() {
        this.currentTask = null;
        this.cachedTask = null;
        this.closed = false;
        javaVendor = "Unknown";
        javaVersion = "1.6";

        try {
            javaVendor = System.getProperty("java.vendor");
            javaVersion = System.getProperty("java.version");
        } catch (final Exception ignored) {
        }

        this.closed = false;
        this.sysEventQueue = new Thread(this);
        this.sysEventQueue.setPriority(10);
        this.sysEventQueue.setDaemon(true);
        this.sysEventQueue.start();
    }

    public static void method2684(final String var0, final String var1, final int var2, final int var3) throws IOException {
        class37.idxCount = var3;
        BoundingBox.field253 = var2;

        try {
            osName = System.getProperty("os.name");
        } catch (final Exception var30) {
            osName = "Unknown";
        }

        osNameLC = osName.toLowerCase();

        try {
            NPC.userHome = System.getProperty("user.home");
            if (NPC.userHome != null) {
                NPC.userHome = NPC.userHome + "/";
            }
        } catch (final Exception ignored) {
        }

        try {
            if (osNameLC.startsWith("win")) {
                if (NPC.userHome == null) {
                    NPC.userHome = System.getenv("USERPROFILE");
                }
            } else if (NPC.userHome == null) {
                NPC.userHome = System.getenv("HOME");
            }

            if (NPC.userHome != null) {
                NPC.userHome = NPC.userHome + "/";
            }
        } catch (final Exception ignored) {
        }

        if (NPC.userHome == null) {
            NPC.userHome = "~/";
        }

        WorldMapData.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", NPC.userHome, "/tmp/", ""};
        Resampler.field1627 = new String[]{".jagex_cache_" + BoundingBox.field253, ".file_store_" + BoundingBox.field253};
        int var18 = 0;

        File var5;
        label279:
        while (var18 < 4) {
            final String var6 = var18 == 0 ? "" : "" + var18;
            class167.jagexClDat = new File(NPC.userHome, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
            String var7 = null;
            String var8 = null;
            boolean var9 = false;
            File var38;
            if (class167.jagexClDat.exists()) {
                try {
                    final FileOnDisk var10 = new FileOnDisk(class167.jagexClDat, "rw", 10000L);

                    final Buffer var11;
                    int var12;
                    for (var11 = new Buffer((int) var10.length()); var11.offset < var11.payload.length; var11.offset += var12) {
                        var12 = var10.read(var11.payload, var11.offset, var11.payload.length - var11.offset);
                        if (var12 == -1) {
                            throw new IOException();
                        }
                    }

                    var11.offset = 0;
                    var12 = var11.readUnsignedByte();
                    if (var12 < 1 || var12 > 3) {
                        throw new IOException("" + var12);
                    }

                    int var13 = 0;
                    if (var12 > 1) {
                        var13 = var11.readUnsignedByte();
                    }

                    if (var12 <= 2) {
                        var7 = var11.getJagString();
                        if (var13 == 1) {
                            var8 = var11.getJagString();
                        }
                    } else {
                        var7 = var11.getCESU8();
                        if (var13 == 1) {
                            var8 = var11.getCESU8();
                        }
                    }

                    var10.close();
                } catch (final IOException var33) {
                    var33.printStackTrace();
                }

                if (var7 != null) {
                    var38 = new File(var7);
                    if (!var38.exists()) {
                        var7 = null;
                    }
                }

                if (var7 != null) {
                    var38 = new File(var7, "test.dat");
                    if (!method70(var38, true)) {
                        var7 = null;
                    }
                }
            }

            if (var7 == null && var18 == 0) {
                label254:
                for (int var19 = 0; var19 < Resampler.field1627.length; ++var19) {
                    for (int var20 = 0; var20 < WorldMapData.cacheLocations.length; ++var20) {
                        final File var21 = new File(WorldMapData.cacheLocations[var20] + Resampler.field1627[var19] + File.separatorChar + var0 + File.separatorChar);
                        if (var21.exists() && method70(new File(var21, "test.dat"), true)) {
                            var7 = var21.toString();
                            var9 = true;
                            break label254;
                        }
                    }
                }
            }

            if (var7 == null) {
                var7 = NPC.userHome + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
                var9 = true;
            }

            if (var8 != null) {
                final File var37 = new File(var8);
                var38 = new File(var7);

                try {

                    for (final File var15 : var37.listFiles()) {
                        final File var16 = new File(var38, var15.getName());
                        final boolean var17 = var15.renameTo(var16);
                        if (!var17) {
                            throw new IOException();
                        }
                    }
                } catch (final Exception var32) {
                    var32.printStackTrace();
                }

                var9 = true;
            }

            if (var9) {
                class110.method2284(new File(var7), null);
            }

            var5 = new File(var7);
            class241.field2807 = var5;
            if (!class241.field2807.exists()) {
                class241.field2807.mkdirs();
            }

            final File[] var34 = class241.field2807.listFiles();
            if (var34 != null) {

                for (final File var24 : var34) {
                    if (!method70(var24, false)) {
                        ++var18;
                        continue label279;
                    }
                }
            }
            break;
        }

        class170.field2233 = class241.field2807;
        if (!class170.field2233.exists()) {
            throw new RuntimeException("");
        } else {
            class170.field2234 = true;

            try {
                var5 = new File(NPC.userHome, "random.dat");
                int var26;
                if (var5.exists()) {
                    class167.randomDat = new CacheFile(new FileOnDisk(var5, "rw", 25L), 24, 0);
                } else {
                    label205:
                    for (int var25 = 0; var25 < Resampler.field1627.length; ++var25) {
                        for (var26 = 0; var26 < WorldMapData.cacheLocations.length; ++var26) {
                            final File var36 = new File(WorldMapData.cacheLocations[var26] + Resampler.field1627[var25] + File.separatorChar + "random.dat");
                            if (var36.exists()) {
                                class167.randomDat = new CacheFile(new FileOnDisk(var36, "rw", 25L), 24, 0);
                                break label205;
                            }
                        }
                    }
                }

                if (class167.randomDat == null) {
                    final RandomAccessFile var35 = new RandomAccessFile(var5, "rw");
                    var26 = var35.read();
                    var35.seek(0L);
                    var35.write(var26);
                    var35.seek(0L);
                    var35.close();
                    class167.randomDat = new CacheFile(new FileOnDisk(var5, "rw", 25L), 24, 0);
                }
            } catch (final IOException ignored) {
            }

            class167.dat2File = new CacheFile(new FileOnDisk(MessageNode.method1176("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class167.idx255File = new CacheFile(new FileOnDisk(MessageNode.method1176("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            Size.idxFiles = new CacheFile[class37.idxCount];

            for (int var27 = 0; var27 < class37.idxCount; ++var27) {
                Size.idxFiles[var27] = new CacheFile(new FileOnDisk(MessageNode.method1176("main_file_cache.idx" + var27), "rw", 1048576L), 6000, 0);
            }

        }
    }

    static boolean method70(final File file, final boolean delete) {
        try {
            final RandomAccessFile var2 = new RandomAccessFile(file, "rw");
            final int var3 = var2.read();
            var2.seek(0L);
            var2.write(var3);
            var2.seek(0L);
            var2.close();
            if (delete) {
                file.delete();
            }

            return true;
        } catch (final Exception var4) {
            return false;
        }
    }

    public static void processClientError(final String var0, final Throwable var1) {
        if (var1 != null) {
            var1.printStackTrace();
        } else {
            try {
                String var2 = "";

                if (var0 != null) {
                    var2 = var2 + var0;
                }

                System.out.println("Error: " + var2);
                var2 = var2.replace(':', '.');
                var2 = var2.replace('@', '_');
                var2 = var2.replace('&', '_');
                var2 = var2.replace('#', '_');
                if (RunException.field2198 == null) {
                    return;
                }

                final URL var3 = new URL(RunException.field2198.getCodeBase(), "clienterror.ws?c=" + RunException.revision + "&u=" + RunException.field2194 + "&v1=" + javaVendor + "&v2=" + javaVersion + "&e=" + var2);
                final DataInputStream var4 = new DataInputStream(var3.openStream());
                var4.read();
                var4.close();
            } catch (final Exception ignored) {
            }

        }
    }

    static Script newScript(final byte[] var0) {
        final Script var1 = new Script();
        final Buffer var2 = new Buffer(var0);
        var2.offset = var2.payload.length - 2;
        final int var3 = var2.readUnsignedShort();
        final int var4 = var2.payload.length - 2 - var3 - 12;
        var2.offset = var4;
        final int var5 = var2.readInt();
        var1.localIntCount = var2.readUnsignedShort();
        var1.localStringCount = var2.readUnsignedShort();
        var1.intStackCount = var2.readUnsignedShort();
        var1.stringStackCount = var2.readUnsignedShort();
        final int var6 = var2.readUnsignedByte();
        int var7;
        int var8;
        if (var6 > 0) {
            var1.switches = var1.method2016(var6);

            for (var7 = 0; var7 < var6; ++var7) {
                var8 = var2.readUnsignedShort();
                final IterableHashTable var9 = new IterableHashTable(var8 > 0 ? GraphicsObject.nextPowerOfTwo(var8) : 1);
                var1.switches[var7] = var9;

                while (var8-- > 0) {
                    final int var10 = var2.readInt();
                    final int var11 = var2.readInt();
                    var9.put(new IntegerNode(var11), var10);
                }
            }
        }

        var2.offset = 0;
        var2.getNullString();
        var1.instructions = new int[var5];
        var1.intOperands = new int[var5];
        var1.stringOperands = new String[var5];

        for (var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
            var8 = var2.readUnsignedShort();
            if (var8 == 3) {
                var1.stringOperands[var7] = var2.readString();
            } else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
                var1.intOperands[var7] = var2.readInt();
            } else {
                var1.intOperands[var7] = var2.readUnsignedByte();
            }
        }

        return var1;
    }

    static void method3241(final Player player, final int var1, final int var2, final int var3) {
        if (Client.localPlayer != player) {
            if (Client.menuOptionCount < 400) {
                final String var4;
                if (player.totalLevel == 0) {
                    var4 = player.actions[0] + player.name + player.actions[1] + PendingSpawn.method1653(player.combatLevel, Client.localPlayer.combatLevel) + " " + " (" + "level-" + player.combatLevel + ")" + player.actions[2];
                } else {
                    var4 = player.actions[0] + player.name + player.actions[1] + " " + " (" + "skill-" + player.totalLevel + ")" + player.actions[2];
                }

                int var5;
                if (Client.itemSelectionState == 1) {
                    TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class45.getColTags(16777215) + var4, 14, var1, var2, var3);
                } else if (Client.spellSelected) {
                    if ((class110.field1607 & 8) == 8) {
                        TextureProvider.addMenuEntry(Client.field1092, Client.field1028 + " " + "->" + " " + class45.getColTags(16777215) + var4, 15, var1, var2, var3);
                    }
                } else {
                    for (var5 = 7; var5 >= 0; --var5) {
                        if (Client.playerOptions[var5] != null) {
                            short var6 = 0;
                            if (Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                                if (Client.playerAttackOption == AttackOption.AttackOption_hidden) {
                                    continue;
                                }

                                if (AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || AttackOption.AttackOption_dependsOnCombatLevels == Client.playerAttackOption && player.combatLevel > Client.localPlayer.combatLevel) {
                                    var6 = 2000;
                                }

                                if (Client.localPlayer.team != 0 && player.team != 0) {
                                    if (player.team == Client.localPlayer.team) {
                                        var6 = 2000;
                                    } else {
                                        var6 = 0;
                                    }
                                }
                            } else if (Client.playerOptionsPriorities[var5]) {
                                var6 = 2000;
                            }

                            final int var8 = Client.playerMenuTypes[var5] + var6;
                            TextureProvider.addMenuEntry(Client.playerOptions[var5], class45.getColTags(16777215) + var4, var8, var1, var2, var3);
                        }
                    }
                }

                for (var5 = 0; var5 < Client.menuOptionCount; ++var5) {
                    if (Client.menuTypes[var5] == 23) {
                        Client.menuTargets[var5] = class45.getColTags(16777215) + var4;
                        break;
                    }
                }

            }
        }
    }

    public final void join() {
        synchronized (this) {
            this.closed = true;
            this.notifyAll();
        }

        try {
            this.sysEventQueue.join();
        } catch (final InterruptedException ignored) {
        }

    }

    private Task newTask(final int type, final int intArg, final Object objectArg) {
        final Task task = new Task();
        task.type = type;
        task.intArgument = intArg;
        task.objectArgument = objectArg;
        synchronized (this) {
            if (this.cachedTask != null) {
                this.cachedTask.task = task;
                this.cachedTask = task;
            } else {
                this.cachedTask = this.currentTask = task;
            }

            this.notify();
            return task;
        }
    }

    public final Task createSocket(final String stringArg, final int var2) {
        return this.newTask(1, var2, stringArg);
    }

    public final Task createRunnable(final Runnable objectArg, final int var2) {
        return this.newTask(2, var2, objectArg);
    }

    public final void run() {
        while (true) {
            final Task task;
            synchronized (this) {
                while (true) {
                    if (this.closed) {
                        return;
                    }

                    if (this.currentTask != null) {
                        task = this.currentTask;
                        this.currentTask = this.currentTask.task;
                        if (this.currentTask == null) {
                            this.cachedTask = null;
                        }
                        break;
                    }

                    try {
                        this.wait();
                    } catch (final InterruptedException ignored) {
                    }
                }
            }

            try {
                final int type = task.type;
                if (type == 1) {
                    task.value = new Socket(InetAddress.getByName((String) task.objectArgument), task.intArgument);
                } else if (type == 2) {
                    final Thread thread = new Thread((Runnable) task.objectArgument);
                    thread.setDaemon(true);
                    thread.start();
                    thread.setPriority(task.intArgument);
                    task.value = thread;
                } else if (type == 4) {
                    task.value = new DataInputStream(((URL) task.objectArgument).openStream());
                }

                task.status = 1;
            } catch (final ThreadDeath var6) {
                throw var6;
            } catch (final Throwable var7) {
                task.status = 2;
            }
        }
    }
}
