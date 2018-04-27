package com.oldscape.client;

public abstract class class178 {

	public int field2296;

	public int field2293;

	public int field2294;

	public int field2295;

	protected abstract boolean vmethod3428(int var1, int var2, int var3, CollisionData var4);

	static Script method3431(class245 var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0.field2973;
		Script var5 = WorldMapType3.method233(var3, var0);
		if (var5 != null) {
			return var5;
		} else {
			int var6 = var0.field2973 + (var2 + 40000 << 8);
			var5 = WorldMapType3.method233(var6, var0);
			return var5 != null ? var5 : null;
		}
	}

	static final void method3432(int var0) {
		if (var0 >= 0) {
			int var1 = Client.menuActionParams0[var0];
			int var2 = Client.menuActionParams1[var0];
			int var3 = Client.menuTypes[var0];
			int var4 = Client.menuIdentifiers[var0];
			String var5 = Client.menuOptions[var0];
			String var6 = Client.menuTargets[var0];
			PacketBuffer.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.mouseLastPressedX,
					MouseInput.mouseLastPressedY);
		}
	}
}
