package com.oldscape.client;

public class class49 implements WorldMapSectionBase {

	static FileRequest currentRequest;

	static SpritePixels[] mapDots;

	int field599;

	int field597;

	int field598;

	int field608;

	int field600;

	int field596;

	int field602;

	int field603;

	int field604;

	int field605;

	@Override
	public void vmethod767(WorldMapData var1) {
		if (var1.minX > this.field600) {
			var1.minX = this.field600;
		}

		if (var1.field455 < this.field600) {
			var1.field455 = this.field600;
		}

		if (var1.minY > this.field596) {
			var1.minY = this.field596;
		}

		if (var1.field457 < this.field596) {
			var1.field457 = this.field596;
		}

	}

	@Override
	public boolean containsCoord(int var1, int var2, int var3) {
		return var1 >= this.field599 && var1 < this.field599 + this.field597
				? var2 >= (this.field598 << 6) + (this.field602 << 3)
						&& var2 <= (this.field598 << 6) + (this.field602 << 3) + 7
						&& var3 >= (this.field608 << 6) + (this.field603 << 3)
						&& var3 <= (this.field608 << 6) + (this.field603 << 3) + 7
				: false;
	}

	@Override
	public boolean vmethod768(int var1, int var2) {
		return var1 >= (this.field600 << 6) + (this.field604 << 3)
				&& var1 <= (this.field600 << 6) + (this.field604 << 3) + 7
				&& var2 >= (this.field596 << 6) + (this.field605 << 3)
				&& var2 <= (this.field596 << 6) + (this.field605 << 3) + 7;
	}

	@Override
	public int[] vmethod753(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[] {
					this.field600 * 64 - this.field598 * 64 + var2 + (this.field604 * 8 - this.field602 * 8),
					var3 + (this.field596 * 64 - this.field608 * 64) + (this.field605 * 8 - this.field603 * 8) };
			return var4;
		}
	}

	@Override
	public Coordinates vmethod758(int var1, int var2) {
		if (!this.vmethod768(var1, var2)) {
			return null;
		} else {
			int var3 = this.field598 * 64 - this.field600 * 64 + (this.field602 * 8 - this.field604 * 8) + var1;
			int var4 = this.field608 * 64 - this.field596 * 64 + var2 + (this.field603 * 8 - this.field605 * 8);
			return new Coordinates(this.field599, var3, var4);
		}
	}

	@Override
	public void vmethod754(Buffer var1) {
		this.field599 = var1.readUnsignedByte();
		this.field597 = var1.readUnsignedByte();
		this.field598 = var1.readUnsignedShort();
		this.field602 = var1.readUnsignedByte();
		this.field608 = var1.readUnsignedShort();
		this.field603 = var1.readUnsignedByte();
		this.field600 = var1.readUnsignedShort();
		this.field604 = var1.readUnsignedByte();
		this.field596 = var1.readUnsignedShort();
		this.field605 = var1.readUnsignedByte();
		this.method756();
	}

	void method756() {
	}

	static void method755() {
		int var0 = class93.playerIndexesCount;
		int[] var1 = class93.playerIndices;

		for (int var2 = 0; var2 < var0; ++var2) {
			if (var1[var2] != Client.field1112 && var1[var2] != Client.localInteractingIndex) {
				WorldMapManager.method627(Client.cachedPlayers[var1[var2]], true);
			}
		}

	}
}
