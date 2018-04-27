package com.oldscape.client;

public class class243 {

	static int port2;

	static TextureProvider field2961;

	public static IndexedSprite method4486(IndexDataBase var0, int var1) {
		byte[] var3 = var0.takeRecordFlat(var1);
		boolean var2;
		if (var3 == null) {
			var2 = false;
		} else {
			Area.decodeSprite(var3);
			var2 = true;
		}

		return !var2 ? null : class155.method3159();
	}
}
