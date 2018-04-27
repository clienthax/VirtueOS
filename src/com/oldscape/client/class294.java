package com.oldscape.client;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class class294 {

	long field3818;

	long field3817;

	public boolean field3825;

	long field3819;

	long field3820;

	long field3821;

	int field3824;

	int field3823;

	int field3816;

	int field3822;

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

	public void method5210() {
		this.field3818 = class64.method1118();
	}

	public void method5211() {
		if (this.field3818 != -1L) {
			this.field3820 = class64.method1118() - this.field3818;
			this.field3818 = -1L;
		}

	}

	public void method5212(int var1) {
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

	public void method5225(Buffer var1) {
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

	public static final AbstractSoundSystem method5239(Signlink var0, int var1, int var2) {
		if (AbstractSoundSystem.sampleRate == 0) {
			throw new IllegalStateException();
		} else if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				AbstractSoundSystem var3 = AbstractSoundSystem.soundTaskDataProvider.vmethod2099();
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
					class316.field3925 = Executors.newScheduledThreadPool(1);
					class316.field3925.scheduleAtFixedRate(WidgetNode.task, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (WidgetNode.task != null) {
					if (WidgetNode.task.systems[var1] != null) {
						throw new IllegalArgumentException();
					}

					WidgetNode.task.systems[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new AbstractSoundSystem();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}
