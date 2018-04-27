package com.oldscape.client;

public class WorldMapType2 implements WorldMapSectionBase {

	protected static String field515;

	static MouseRecorder mouseRecorder;

	int field519;

	int field513;

	int field516;

	int field521;

	int field514;

	int field517;

	@Override
	public void vmethod767(WorldMapData var1) {
		if (var1.minX > this.field514) {
			var1.minX = this.field514;
		}

		if (var1.field455 < this.field514) {
			var1.field455 = this.field514;
		}

		if (var1.minY > this.field517) {
			var1.minY = this.field517;
		}

		if (var1.field457 < this.field517) {
			var1.field457 = this.field517;
		}

	}

	@Override
	public boolean containsCoord(int var1, int var2, int var3) {
		return var1 >= this.field519 && var1 < this.field513 + this.field519
				? var2 >> 6 == this.field516 && var3 >> 6 == this.field521
				: false;
	}

	@Override
	public boolean vmethod768(int var1, int var2) {
		return var1 >> 6 == this.field514 && var2 >> 6 == this.field517;
	}

	@Override
	public int[] vmethod753(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[] { this.field514 * 64 - this.field516 * 64 + var2,
					var3 + (this.field517 * 64 - this.field521 * 64) };
			return var4;
		}
	}

	@Override
	public Coordinates vmethod758(int var1, int var2) {
		if (!this.vmethod768(var1, var2)) {
			return null;
		} else {
			int var3 = this.field516 * 64 - this.field514 * 64 + var1;
			int var4 = this.field521 * 64 - this.field517 * 64 + var2;
			return new Coordinates(this.field519, var3, var4);
		}
	}

	@Override
	public void vmethod754(Buffer var1) {
		this.field519 = var1.readUnsignedByte();
		this.field513 = var1.readUnsignedByte();
		this.field516 = var1.readUnsignedShort();
		this.field521 = var1.readUnsignedShort();
		this.field514 = var1.readUnsignedShort();
		this.field517 = var1.readUnsignedShort();
		this.method559();
	}

	void method559() {
	}

	static class178 method578(int var0, int var1) {
		Client.field901.field2296 = var0;
		Client.field901.field2293 = var1;
		Client.field901.field2294 = 1;
		Client.field901.field2295 = 1;
		return Client.field901;
	}
}
