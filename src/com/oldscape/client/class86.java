package com.oldscape.client;

public class class86 {

	public static int field1330;

	public static Spotanim getSpotAnimType(int var0) {
		Spotanim var1 = (Spotanim) Spotanim.spotanims.get(var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
			var1 = new Spotanim();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			Spotanim.spotanims.put(var1, var0);
			return var1;
		}
	}

	static RenderOverview method1892() {
		return Preferences.renderOverview;
	}

	static void method1889(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		KeyFocusListener.method787(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			KeyFocusListener.method787(var1.children, var1.id, var3, var4, var2);
		}

		WidgetNode var5 = (WidgetNode) Client.componentTable.get(var1.id);
		if (var5 != null) {
			class44.method666(var5.id, var3, var4, var2);
		}

		if (var1.contentType == 1337) {
			;
		}

	}
}
