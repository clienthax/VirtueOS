package com.oldscape.client;

public class Area extends CacheableNode {

	static IndexDataBase field3461;

	public static Area[] mapAreaType;

	static NodeCache areaSpriteCache;

	public final int id;

	public int spriteId;

	int field3468;

	public String name;

	public int field3460;

	public int field3458;

	public String[] field3462;

	public String field3470;

	int[] field3464;

	int field3456;

	int field3466;

	int field3467;

	int field3459;

	public HorizontalAlignment horizontalAlignment;

	public VerticalAlignment verticalAlignment;

	int[] field3471;

	byte[] field3472;

	public int field3473;

	static {
		areaSpriteCache = new NodeCache(256);
	}

	Area(int var1) {
		this.spriteId = -1;
		this.field3468 = -1;
		this.field3458 = 0;
		this.field3462 = new String[5];
		this.field3456 = Integer.MAX_VALUE;
		this.field3466 = Integer.MAX_VALUE;
		this.field3467 = Integer.MIN_VALUE;
		this.field3459 = Integer.MIN_VALUE;
		this.horizontalAlignment = HorizontalAlignment.field3702;
		this.verticalAlignment = VerticalAlignment.field3440;
		this.field3473 = -1;
		this.id = var1;
	}

	void method4757(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4742(var1, var2);
		}
	}

	void method4742(Buffer var1, int var2) {
		if (var2 == 1) {
			this.spriteId = var1.method3576();
		} else if (var2 == 2) {
			this.field3468 = var1.method3576();
		} else if (var2 == 3) {
			this.name = var1.readString();
		} else if (var2 == 4) {
			this.field3460 = var1.read24BitInt();
		} else if (var2 == 5) {
			var1.read24BitInt();
		} else if (var2 == 6) {
			this.field3458 = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) {
				var3 = var1.readUnsignedByte();
				if ((var3 & 1) == 0) {
					;
				}

				if ((var3 & 2) == 2) {
					;
				}
			} else if (var2 == 8) {
				var1.readUnsignedByte();
			} else if (var2 >= 10 && var2 <= 14) {
				this.field3462[var2 - 10] = var1.readString();
			} else if (var2 == 15) {
				var3 = var1.readUnsignedByte();
				this.field3464 = new int[var3 * 2];

				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) {
					this.field3464[var4] = var1.readShort();
				}

				var1.readInt();
				var4 = var1.readUnsignedByte();
				this.field3471 = new int[var4];

				int var5;
				for (var5 = 0; var5 < this.field3471.length; ++var5) {
					this.field3471[var5] = var1.readInt();
				}

				this.field3472 = new byte[var3];

				for (var5 = 0; var5 < var3; ++var5) {
					this.field3472[var5] = var1.readByte();
				}
			} else if (var2 != 16) {
				if (var2 == 17) {
					this.field3470 = var1.readString();
				} else if (var2 == 18) {
					var1.method3576();
				} else if (var2 == 19) {
					this.field3473 = var1.readUnsignedShort();
				} else if (var2 == 21) {
					var1.readInt();
				} else if (var2 == 22) {
					var1.readInt();
				} else if (var2 == 23) {
					var1.readUnsignedByte();
					var1.readUnsignedByte();
					var1.readUnsignedByte();
				} else if (var2 == 24) {
					var1.readShort();
					var1.readShort();
				} else if (var2 == 25) {
					var1.method3576();
				} else if (var2 == 28) {
					var1.readUnsignedByte();
				} else if (var2 == 29) {
					HorizontalAlignment[] var6 = new HorizontalAlignment[] { HorizontalAlignment.field3702,
							HorizontalAlignment.field3699, HorizontalAlignment.field3698 };
					this.horizontalAlignment = (HorizontalAlignment) Permission.forOrdinal(var6,
							var1.readUnsignedByte());
				} else if (var2 == 30) {
					this.verticalAlignment = (VerticalAlignment) Permission.forOrdinal(Ignore.method5387(),
							var1.readUnsignedByte());
				}
			}
		}

	}

	void method4744() {
		if (this.field3464 != null) {
			for (int var1 = 0; var1 < this.field3464.length; var1 += 2) {
				if (this.field3464[var1] < this.field3456) {
					this.field3456 = this.field3464[var1];
				} else if (this.field3464[var1] > this.field3467) {
					this.field3467 = this.field3464[var1];
				}

				if (this.field3464[var1 + 1] < this.field3466) {
					this.field3466 = this.field3464[var1 + 1];
				} else if (this.field3464[var1 + 1] > this.field3459) {
					this.field3459 = this.field3464[var1 + 1];
				}
			}
		}

	}

	public SpritePixels getMapIcon(boolean var1) {
		int var2 = this.spriteId;
		return this.method4745(var2);
	}

	SpritePixels method4745(int var1) {
		if (var1 < 0) {
			return null;
		} else {
			SpritePixels var2 = (SpritePixels) areaSpriteCache.get(var1);
			if (var2 != null) {
				return var2;
			} else {
				var2 = SoundTaskDataProvider.method817(field3461, var1, 0);
				if (var2 != null) {
					areaSpriteCache.put(var2, var1);
				}

				return var2;
			}
		}
	}

	public int method4746() {
		return this.id;
	}

	static void decodeSprite(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class332.indexedSpriteCount = var1.readUnsignedShort();
		class332.indexedSpriteOffsetXs = new int[class332.indexedSpriteCount];
		FileSystem.indexedSpriteOffsetYs = new int[class332.indexedSpriteCount];
		WorldMapDecoration.indexSpriteWidths = new int[class332.indexedSpriteCount];
		class332.indexedSpriteHeights = new int[class332.indexedSpriteCount];
		class332.spritePixels = new byte[class332.indexedSpriteCount][];
		var1.offset = var0.length - 7 - class332.indexedSpriteCount * 8;
		class332.indexedSpriteWidth = var1.readUnsignedShort();
		class332.indexedSpriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
			class332.indexedSpriteOffsetXs[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
			FileSystem.indexedSpriteOffsetYs[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
			WorldMapDecoration.indexSpriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
			class332.indexedSpriteHeights[var3] = var1.readUnsignedShort();
		}

		var1.offset = var0.length - 7 - class332.indexedSpriteCount * 8 - (var2 - 1) * 3;
		class332.indexedSpritePalette = new int[var2];

		for (var3 = 1; var3 < var2; ++var3) {
			class332.indexedSpritePalette[var3] = var1.read24BitInt();
			if (class332.indexedSpritePalette[var3] == 0) {
				class332.indexedSpritePalette[var3] = 1;
			}
		}

		var1.offset = 0;

		for (var3 = 0; var3 < class332.indexedSpriteCount; ++var3) {
			int var4 = WorldMapDecoration.indexSpriteWidths[var3];
			int var5 = class332.indexedSpriteHeights[var3];
			int var6 = var4 * var5;
			byte[] var7 = new byte[var6];
			class332.spritePixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var10 * var4] = var1.readByte();
					}
				}
			}
		}

	}
}
