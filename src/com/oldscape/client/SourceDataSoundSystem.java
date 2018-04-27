package com.oldscape.client;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class SourceDataSoundSystem extends AbstractSoundSystem {

	AudioFormat audioFormat;

	SourceDataLine source;

	int size;

	byte[] bytes;

	@Override
	protected void vmethod2247() {
		this.audioFormat = new AudioFormat(AbstractSoundSystem.sampleRate, 16,
				AbstractSoundSystem.audioHighMemory ? 2 : 1, true, false);
		this.bytes = new byte[256 << (AbstractSoundSystem.audioHighMemory ? 2 : 1)];
	}

	@Override
	protected void create(int var1) throws LineUnavailableException {
		try {
			Info var2 = new Info(SourceDataLine.class, this.audioFormat,
					var1 << (AbstractSoundSystem.audioHighMemory ? 2 : 1));
			this.source = (SourceDataLine) AudioSystem.getLine(var2);
			this.source.open();
			this.source.start();
			this.size = var1;
		} catch (LineUnavailableException var3) {
			if (class253.method4507(var1) != 1) {
				this.create(GraphicsObject.nextPowerOfTwo(var1));
			} else {
				this.source = null;
				throw var3;
			}
		}
	}

	@Override
	protected int size() {
		return this.size - (this.source.available() >> (AbstractSoundSystem.audioHighMemory ? 2 : 1));
	}

	@Override
	protected void write() {
		int var1 = 256;
		if (AbstractSoundSystem.audioHighMemory) {
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

	@Override
	protected void close() {
		if (this.source != null) {
			this.source.close();
			this.source = null;
		}

	}

	@Override
	protected void flush() {
		this.source.flush();
	}
}
