package com.oldscape.client;

public class Bounds {

	static int field3945;

	public int field3943;

	public int field3941;

	public int field3942;

	public int field3944;

	public Bounds(int var1, int var2, int var3, int var4) {
		this.method5675(var1, var2);
		this.method5676(var3, var4);
	}

	public Bounds(int var1, int var2) {
		this(0, 0, var1, var2);
	}

	public void method5675(int var1, int var2) {
		this.field3943 = var1;
		this.field3941 = var2;
	}

	public void method5676(int var1, int var2) {
		this.field3942 = var1;
		this.field3944 = var2;
	}

	public void method5680(Bounds var1, Bounds var2) {
		this.method5678(var1, var2);
		this.method5694(var1, var2);
	}

	void method5678(Bounds var1, Bounds var2) {
		var2.field3943 = this.field3943;
		var2.field3942 = this.field3942;
		if (this.field3943 < var1.field3943) {
			var2.field3942 -= var1.field3943 - this.field3943;
			var2.field3943 = var1.field3943;
		}

		if (var2.method5683() > var1.method5683()) {
			var2.field3942 -= var2.method5683() - var1.method5683();
		}

		if (var2.field3942 < 0) {
			var2.field3942 = 0;
		}

	}

	void method5694(Bounds var1, Bounds var2) {
		var2.field3941 = this.field3941;
		var2.field3944 = this.field3944;
		if (this.field3941 < var1.field3941) {
			var2.field3944 -= var1.field3941 - this.field3941;
			var2.field3941 = var1.field3941;
		}

		if (var2.method5681() > var1.method5681()) {
			var2.field3944 -= var2.method5681() - var1.method5681();
		}

		if (var2.field3944 < 0) {
			var2.field3944 = 0;
		}

	}

	int method5683() {
		return this.field3942 + this.field3943;
	}

	int method5681() {
		return this.field3941 + this.field3944;
	}

	@Override
	public String toString() {
		return null;
	}
}
