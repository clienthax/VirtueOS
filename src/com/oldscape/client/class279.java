package com.oldscape.client;

public class class279 extends CacheableNode {

	public static IndexDataBase field3552;

	public static NodeCache field3553;

	IterableHashTable field3554;

	static {
		field3553 = new NodeCache(64);
	}

	public void method4925() {
	}

	public void method4937(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method4923(var1, var2);
		}
	}

	void method4923(Buffer var1, int var2) {
		if (var2 == 249) {
			this.field3554 = class28.readStringIntParameters(var1, this.field3554);
		}

	}

	public int method4924(int var1, int var2) {
		IterableHashTable var4 = this.field3554;
		int var3;
		if (var4 == null) {
			var3 = var2;
		} else {
			IntegerNode var5 = (IntegerNode) var4.get(var1);
			if (var5 == null) {
				var3 = var2;
			} else {
				var3 = var5.value;
			}
		}

		return var3;
	}

	public String method4932(int var1, String var2) {
		return WorldMapType1.method309(this.field3554, var1, var2);
	}

	public static boolean method4922(class245 var0) {
		return class245.field2976 == var0 || class245.field2969 == var0 || class245.field2965 == var0
				|| class245.field2970 == var0 || class245.field2967 == var0 || class245.field2968 == var0
				|| class245.field2971 == var0 || class245.field2966 == var0;
	}
}
