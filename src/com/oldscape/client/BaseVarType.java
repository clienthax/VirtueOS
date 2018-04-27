package com.oldscape.client;

public enum BaseVarType implements Enumerated {

	INTEGER(1, 0, Integer.class, new class2()),

	LONG(2, 1, Long.class, new class3()),

	STRING(0, 2, String.class, new class5());

	public static class265 field25;

	final int id2;

	final int id;

	BaseVarType(int var3, int var4, Class var5, class0 var6) {
		this.id2 = var3;
		this.id = var4;
	}

	@Override
	public int rsOrdinal() {
		return this.id;
	}

	static final void method9(Player var0, int var1, int var2, byte var3) {
		int var4 = var0.pathX[0];
		int var5 = var0.pathY[0];
		int var6 = var0.getSize();
		if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
			if (var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
				int var7 = class171.method3325(var4, var5, var0.getSize(), WorldMapType2.method578(var1, var2),
						Client.collisionMaps[var0.field856], true, Client.field1034, Client.field1131);
				if (var7 >= 1) {
					for (int var8 = 0; var8 < var7 - 1; ++var8) {
						var0.method1186(Client.field1034[var8], Client.field1131[var8], var3);
					}

				}
			}
		}
	}
}
