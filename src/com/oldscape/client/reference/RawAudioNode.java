package com.oldscape.client.reference;

public class RawAudioNode extends AbstractIntegerNode0 {
    public int sampleRate;
    public byte[] audioBuffer;
    public int startPosition;
    public boolean field1548;
    int endPosition;

    RawAudioNode(final int var1, final byte[] var2, final int var3, final int var4) {
        this.sampleRate = var1;
        this.audioBuffer = var2;
        this.startPosition = var3;
        this.endPosition = var4;
    }

    RawAudioNode(final int var1, final byte[] var2, final int var3, final int var4, final boolean var5) {
        this.sampleRate = var1;
        this.audioBuffer = var2;
        this.startPosition = var3;
        this.endPosition = var4;
        this.field1548 = var5;
    }

    public RawAudioNode applyResampler(final Resampler var1) {
        this.audioBuffer = var1.resampleIfNecessary(this.audioBuffer);
        this.sampleRate = var1.method2302(this.sampleRate);
        if (this.startPosition == this.endPosition) {
            this.startPosition = this.endPosition = var1.method2303(this.startPosition);
        } else {
            this.startPosition = var1.method2303(this.startPosition);
            this.endPosition = var1.method2303(this.endPosition);
            if (this.startPosition == this.endPosition) {
                --this.startPosition;
            }
        }

        return this;
    }
}
