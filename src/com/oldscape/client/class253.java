package com.oldscape.client;

public class class253 {

	static int[] field3314;

	public static int method4507(int var0) {
		var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
		var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
		var0 = var0 + (var0 >>> 4) & 252645135;
		var0 += var0 >>> 8;
		var0 += var0 >>> 16;
		return var0 & 255;
	}

	public static JagexGame[] method4506() {
		return new JagexGame[] { JagexGame.field3364, JagexGame.field3360, JagexGame.field3361, JagexGame.field3363,
				JagexGame.field3362, JagexGame.field3366 };
	}
}
