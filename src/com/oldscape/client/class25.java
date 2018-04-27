package com.oldscape.client;

public class class25 {

	public static String osNameLC;

	int field375;

	Coordinates field374;

	class25(int var1, Coordinates var2) {
		this.field375 = var1;
		this.field374 = var2;
	}

	public static void method200(int var0) {
		MouseInput.mouseIdleTicks = var0;
	}

	public static void method201() {
		Widget.field2817.reset();
		Widget.Widget_cachedModels.reset();
		Widget.Widget_cachedFonts.reset();
		Widget.field2819.reset();
	}

	static final void method202(Widget var0, int var1, int var2, int var3) {
		class236 var4 = var0.method4425(false);
		if (var4 != null) {
			if (Client.field1099 < 3) {
				class7.compass.method5875(var1, var2, var4.field2773, var4.field2772, 25, 25, Client.mapAngle, 256,
						var4.field2774, var4.field2771);
			} else {
				Rasterizer2D.method5737(var1, var2, 0, var4.field2774, var4.field2771);
			}

		}
	}
}
