package com.oldscape.client;

public class Spotanim extends CacheableNode {

	static IndexDataBase SpotAnimationDefinition_indexCache;

	static IndexDataBase SpotAnimationDefinition_modelIndexCache;

	static NodeCache spotanims;

	static NodeCache SpotAnimationDefinition_cachedModels;

	int id;

	int field3487;

	public int field3497;

	short[] field3488;

	short[] field3490;

	short[] field3491;

	short[] field3492;

	int widthScale;

	int heightScale;

	int orientation;

	int field3496;

	int field3489;

	static {
		spotanims = new NodeCache(64);
		SpotAnimationDefinition_cachedModels = new NodeCache(30);
	}

	Spotanim() {
		this.field3497 = -1;
		this.widthScale = 128;
		this.heightScale = 128;
		this.orientation = 0;
		this.field3496 = 0;
		this.field3489 = 0;
	}

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.readNext(var1, var2);
		}
	}

	void readNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.field3487 = var1.readUnsignedShort();
		} else if (var2 == 2) {
			this.field3497 = var1.readUnsignedShort();
		} else if (var2 == 4) {
			this.widthScale = var1.readUnsignedShort();
		} else if (var2 == 5) {
			this.heightScale = var1.readUnsignedShort();
		} else if (var2 == 6) {
			this.orientation = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.field3496 = var1.readUnsignedByte();
		} else if (var2 == 8) {
			this.field3489 = var1.readUnsignedByte();
		} else {
			int var3;
			int var4;
			if (var2 == 40) {
				var3 = var1.readUnsignedByte();
				this.field3488 = new short[var3];
				this.field3490 = new short[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.field3488[var4] = (short) var1.readUnsignedShort();
					this.field3490[var4] = (short) var1.readUnsignedShort();
				}
			} else if (var2 == 41) {
				var3 = var1.readUnsignedByte();
				this.field3491 = new short[var3];
				this.field3492 = new short[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.field3491[var4] = (short) var1.readUnsignedShort();
					this.field3492[var4] = (short) var1.readUnsignedShort();
				}
			}
		}

	}

	public final Model getModel(int var1) {
		Model var2 = (Model) SpotAnimationDefinition_cachedModels.get(this.id);
		if (var2 == null) {
			ModelData var3 = ModelData.method2645(SpotAnimationDefinition_modelIndexCache, this.field3487, 0);
			if (var3 == null) {
				return null;
			}

			int var4;
			if (this.field3488 != null) {
				for (var4 = 0; var4 < this.field3488.length; ++var4) {
					var3.recolor(this.field3488[var4], this.field3490[var4]);
				}
			}

			if (this.field3491 != null) {
				for (var4 = 0; var4 < this.field3491.length; ++var4) {
					var3.method2613(this.field3491[var4], this.field3492[var4]);
				}
			}

			var2 = var3.light(this.field3496 + 64, this.field3489 + 850, -30, -50, -30);
			SpotAnimationDefinition_cachedModels.put(var2, this.id);
		}

		Model var5;
		if (this.field3497 != -1 && var1 != -1) {
			var5 = CombatInfo1.getAnimation(this.field3497).transformSpotAnimModel(var2, var1);
		} else {
			var5 = var2.toSharedSpotAnimModel(true);
		}

		if (this.widthScale != 128 || this.heightScale != 128) {
			var5.scale(this.widthScale, this.heightScale, this.widthScale);
		}

		if (this.orientation != 0) {
			if (this.orientation == 90) {
				var5.rotateY90Ccw();
			}

			if (this.orientation == 180) {
				var5.rotateY90Ccw();
				var5.rotateY90Ccw();
			}

			if (this.orientation == 270) {
				var5.rotateY90Ccw();
				var5.rotateY90Ccw();
				var5.rotateY90Ccw();
			}
		}

		return var5;
	}
}
