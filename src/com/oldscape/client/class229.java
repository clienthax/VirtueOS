package com.oldscape.client;

public class class229 {

	public static IndexDataBase field2688;

	public static IndexDataBase field2691;

	public static IndexDataBase field2689;

	public static class230 field2690;

	public static int field2687;

	static Thread IndexStoreActionHandler_thread;

	public static boolean field2692;

	static {
		field2687 = 0;
	}

	static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
			class62.tileSettings[var1][var2][var3] = 0;

			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					if (var1 == 0) {
						class62.tileHeights[0][var2][var3] = -ItemContainer.method1131(var2 + 932731 + var4,
								var5 + 556238 + var3) * 8;
					} else {
						class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - 240;
					}
					break;
				}

				if (var7 == 1) {
					int var8 = var0.readUnsignedByte();
					if (var8 == 1) {
						var8 = 0;
					}

					if (var1 == 0) {
						class62.tileHeights[0][var2][var3] = -var8 * 8;
					} else {
						class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - var8 * 8;
					}
					break;
				}

				if (var7 <= 49) {
					class62.tileOverlayIds[var1][var2][var3] = var0.readByte();
					class62.tileOverlayPath[var1][var2][var3] = (byte) ((var7 - 2) / 4);
					class62.overlayRotations[var1][var2][var3] = (byte) (var7 - 2 + var6 & 3);
				} else if (var7 <= 81) {
					class62.tileSettings[var1][var2][var3] = (byte) (var7 - 49);
				} else {
					class62.tileUnderlayIds[var1][var2][var3] = (byte) (var7 - 81);
				}
			}
		} else {
			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					break;
				}

				if (var7 == 1) {
					var0.readUnsignedByte();
					break;
				}

				if (var7 <= 49) {
					var0.readUnsignedByte();
				}
			}
		}

	}
}
