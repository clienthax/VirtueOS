package com.oldscape.client;

public class WorldMapType3 implements WorldMapSectionBase {

	static IndexData indexCache3;

	int field380;

	int field381;

	int field382;

	int field383;

	int field392;

	int field385;

	int field386;

	int field387;

	int field384;

	int field389;

	int field390;

	int field391;

	int field394;

	int field393;

	@Override
	public void vmethod767(WorldMapData var1) {
		if (var1.minX > this.field392) {
			var1.minX = this.field392;
		}

		if (var1.field455 < this.field392) {
			var1.field455 = this.field392;
		}

		if (var1.minY > this.field385) {
			var1.minY = this.field385;
		}

		if (var1.field457 < this.field385) {
			var1.field457 = this.field385;
		}

	}

	@Override
	public boolean containsCoord(int var1, int var2, int var3) {
		return var1 >= this.field380 && var1 < this.field380 + this.field381
				? var2 >= (this.field382 << 6) + (this.field386 << 3)
						&& var2 <= (this.field382 << 6) + (this.field384 << 3) + 7
						&& var3 >= (this.field383 << 6) + (this.field387 << 3)
						&& var3 <= (this.field383 << 6) + (this.field389 << 3) + 7
				: false;
	}

	@Override
	public boolean vmethod768(int var1, int var2) {
		return var1 >= (this.field392 << 6) + (this.field390 << 3)
				&& var1 <= (this.field392 << 6) + (this.field394 << 3) + 7
				&& var2 >= (this.field385 << 6) + (this.field391 << 3)
				&& var2 <= (this.field385 << 6) + (this.field393 << 3) + 7;
	}

	@Override
	public int[] vmethod753(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[] {
					this.field392 * 64 - this.field382 * 64 + var2 + (this.field390 * 8 - this.field386 * 8),
					var3 + (this.field385 * 64 - this.field383 * 64) + (this.field391 * 8 - this.field387 * 8) };
			return var4;
		}
	}

	@Override
	public Coordinates vmethod758(int var1, int var2) {
		if (!this.vmethod768(var1, var2)) {
			return null;
		} else {
			int var3 = this.field382 * 64 - this.field392 * 64 + (this.field386 * 8 - this.field390 * 8) + var1;
			int var4 = this.field383 * 64 - this.field385 * 64 + var2 + (this.field387 * 8 - this.field391 * 8);
			return new Coordinates(this.field380, var3, var4);
		}
	}

	@Override
	public void vmethod754(Buffer var1) {
		this.field380 = var1.readUnsignedByte();
		this.field381 = var1.readUnsignedByte();
		this.field382 = var1.readUnsignedShort();
		this.field386 = var1.readUnsignedByte();
		this.field384 = var1.readUnsignedByte();
		this.field383 = var1.readUnsignedShort();
		this.field387 = var1.readUnsignedByte();
		this.field389 = var1.readUnsignedByte();
		this.field392 = var1.readUnsignedShort();
		this.field390 = var1.readUnsignedByte();
		this.field394 = var1.readUnsignedByte();
		this.field385 = var1.readUnsignedShort();
		this.field391 = var1.readUnsignedByte();
		this.field393 = var1.readUnsignedByte();
		this.method215();
	}

	void method215() {
	}

	public static void method210(IndexDataBase var0, IndexDataBase var1) {
		Spotanim.SpotAnimationDefinition_indexCache = var0;
		Spotanim.SpotAnimationDefinition_modelIndexCache = var1;
	}

	static Script method233(int var0, class245 var1) {
		Script var2 = (Script) Script.field1459.get(var0 << 16);
		if (var2 != null) {
			return var2;
		} else {
			String var3 = String.valueOf(var0);
			int var4 = class190.indexScripts.getFile(var3);
			if (var4 == -1) {
				return null;
			} else {
				byte[] var5 = class190.indexScripts.takeRecordFlat(var4);
				if (var5 != null) {
					if (var5.length <= 1) {
						return null;
					}

					var2 = Signlink.newScript(var5);
					if (var2 != null) {
						Script.field1459.put(var2, var0 << 16);
						return var2;
					}
				}

				return null;
			}
		}
	}

	public static void method237() {
		VarPlayerType.varplayers.reset();
	}

	public static int method235() {
		return KeyFocusListener.keyboardIdleTicks;
	}

	static final byte[] decodeContainer(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 < 0 || IndexDataBase.field3393 != 0 && var3 > IndexDataBase.field3393) {
			throw new RuntimeException();
		} else if (var2 == 0) {
			byte[] var4 = new byte[var3];
			var1.readBytes(var4, 0, var3);
			return var4;
		} else {
			int var6 = var1.readInt();
			if (var6 < 0 || IndexDataBase.field3393 != 0 && var6 > IndexDataBase.field3393) {
				throw new RuntimeException();
			} else {
				byte[] var5 = new byte[var6];
				if (var2 == 1) {
					class188.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
				} else {
					IndexDataBase.gzip.decompress(var1, var5);
				}

				return var5;
			}
		}
	}

	static final void method232(boolean var0) {
		if (var0) {
			Client.field907 = class90.field1385 ? class158.field2171 : class158.field2173;
		} else {
			Client.field907 = Client.preferences.preferences.containsKey(
					Integer.valueOf(class228.method4120(class90.username))) ? class158.field2177 : class158.field2172;
		}

	}

	static final void method234(Actor var0, int var1) {
		if (var0.field1166 > Client.gameCycle) {
			int var2 = var0.field1166 - Client.gameCycle;
			int var3 = var0.field1203 * 128 + var0.field1172 * 64;
			int var4 = var0.field1199 * 128 + var0.field1172 * 64;
			var0.x += (var3 - var0.x) / var2;
			var0.y += (var4 - var0.y) / var2;
			var0.field1158 = 0;
			var0.orientation = var0.field1171;
		} else if (var0.field1204 >= Client.gameCycle) {
			ObjectComposition.method5018(var0);
		} else {
			GrandExchangeOffer.method125(var0);
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.animation = -1;
			var0.graphic = -1;
			var0.field1166 = 0;
			var0.field1204 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field1172 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field1172 * 64;
			var0.method1655();
		}

		if (SoundTaskDataProvider.localPlayer == var0
				&& (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.animation = -1;
			var0.graphic = -1;
			var0.field1166 = 0;
			var0.field1204 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field1172 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field1172 * 64;
			var0.method1655();
		}

		class46.method685(var0);
		BoundingBox.method44(var0);
	}
}
