package com.oldscape.client.reference;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class class294 {
    private final long field3821;
    private final int field3822;
    public boolean field3825;
    private long field3818;
    private long field3817;
    private long field3819;
    private long field3820;
    private int field3824;
    private int field3823;
    private int field3816;

    public class294() {
        this.field3818 = -1L;
        this.field3817 = -1L;
        this.field3825 = false;
        this.field3819 = 0L;
        this.field3820 = 0L;
        this.field3821 = 0L;
        this.field3824 = 0;
        this.field3823 = 0;
        this.field3816 = 0;
        this.field3822 = 0;
    }

    public static AbstractSoundSystem method5239(final int var1, int var2) {
        if (AbstractSoundSystem.sampleRate == 0) {
            throw new IllegalStateException();
        } else if (var1 >= 0 && var1 < 2) {
            if (var2 < 256) {
                var2 = 256;
            }

            try {
                final AbstractSoundSystem var3 = AbstractSoundSystem.soundTaskDataProvider.getNewSoundSystem();
                var3.samples = new int[(AbstractSoundSystem.audioHighMemory ? 2 : 1) * 256];
                var3.field1570 = var2;
                var3.vmethod2247();
                var3.offset = (var2 & -1024) + 1024;
                if (var3.offset > 16384) {
                    var3.offset = 16384;
                }

                var3.create(var3.offset);
                if (Varbit.field3538 > 0 && WidgetNode.task == null) {
                    WidgetNode.task = new SoundTask();
                    class316.scheduledExecutorService = Executors.newScheduledThreadPool(1);
                    class316.scheduledExecutorService.scheduleAtFixedRate(WidgetNode.task, 0L, 10L, TimeUnit.MILLISECONDS);
                }

                if (WidgetNode.task != null) {
                    if (WidgetNode.task.systems[var1] != null) {
                        throw new IllegalArgumentException();
                    }

                    WidgetNode.task.systems[var1] = var3;
                }

                return var3;
            } catch (final Throwable var4) {
                return new AbstractSoundSystem();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void method5210() {
        this.field3818 = class64.method1118();
    }

    public void method5211() {
        if (this.field3818 != -1L) {
            this.field3820 = class64.method1118() - this.field3818;
            this.field3818 = -1L;
        }

    }

    public void method5212(final int var1) {
        this.field3817 = class64.method1118();
        this.field3824 = var1;
    }

    public void method5213() {
        if (this.field3817 != -1L) {
            this.field3819 = class64.method1118() - this.field3817;
            this.field3817 = -1L;
        }

        ++this.field3816;
        this.field3825 = true;
    }

    public void method5214() {
        this.field3825 = false;
        this.field3823 = 0;
    }

    public void method5230() {
        this.method5213();
    }

    public void method5225(final Buffer var1) {
        long var2 = this.field3820;
        var2 /= 10L;
        if (var2 < 0L) {
            var2 = 0L;
        } else if (var2 > 65535L) {
            var2 = 65535L;
        }

        var1.putShort((int) var2);
        long var4 = this.field3819;
        var4 /= 10L;
        if (var4 < 0L) {
            var4 = 0L;
        } else if (var4 > 65535L) {
            var4 = 65535L;
        }

        var1.putShort((int) var4);
        long var6 = this.field3821;
        var6 /= 10L;
        if (var6 < 0L) {
            var6 = 0L;
        } else if (var6 > 65535L) {
            var6 = 65535L;
        }

        var1.putShort((int) var6);
        var1.putShort(this.field3824);
        var1.putShort(this.field3823);
        var1.putShort(this.field3816);
        var1.putShort(this.field3822);
    }
}
