package com.oldscape.client.reference;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

class SourceDataSoundSystem extends AbstractSoundSystem {
    private AudioFormat audioFormat;
    private SourceDataLine source;
    private int size;
    private byte[] bytes;

    public static int method4507(int var0) {
        var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
        var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
        var0 = var0 + (var0 >>> 4) & 252645135;
        var0 += var0 >>> 8;
        var0 += var0 >>> 16;
        return var0 & 255;
    }

    protected void vmethod2247() {
        this.audioFormat = new AudioFormat(sampleRate, 16, audioHighMemory ? 2 : 1, true, false);
        this.bytes = new byte[256 << (audioHighMemory ? 2 : 1)];
    }

    void create(final int var1) throws LineUnavailableException {
        try {
            final Info var2 = new Info(SourceDataLine.class, this.audioFormat, var1 << (audioHighMemory ? 2 : 1));
            this.source = (SourceDataLine) AudioSystem.getLine(var2);
            this.source.open();
            this.source.start();
            this.size = var1;
        } catch (final LineUnavailableException var3) {
            if (method4507(var1) != 1) {
                this.create(GraphicsObject.nextPowerOfTwo(var1));
            } else {
                this.source = null;
                throw var3;
            }
        }
    }

    protected int size() {
        return this.size - (this.source.available() >> (audioHighMemory ? 2 : 1));
    }

    protected void write() {
        int var1 = 256;
        if (audioHighMemory) {
            var1 <<= 1;
        }

        for (int var2 = 0; var2 < var1; ++var2) {
            int var3 = super.samples[var2];
            if ((var3 + 8388608 & -16777216) != 0) {
                var3 = 8388607 ^ var3 >> 31;
            }

            this.bytes[var2 * 2] = (byte) (var3 >> 8);
            this.bytes[var2 * 2 + 1] = (byte) (var3 >> 16);
        }

        this.source.write(this.bytes, 0, var1 << 1);
    }

    protected void close() {
        if (this.source != null) {
            this.source.close();
            this.source = null;
        }

    }

    protected void flush() {
        this.source.flush();
    }
}
