package com.oldscape.client;
import java.util.HashMap;

public class Fonts {

	static SpritePixels[] headIconsPrayer;

	IndexDataBase field3892;

	IndexDataBase field3890;

	HashMap map;

	public Fonts(IndexDataBase var1, IndexDataBase var2) {
		this.field3892 = var1;
		this.field3890 = var2;
		this.map = new HashMap();
	}

	public HashMap createMap(FontName[] var1) {
		HashMap var2 = new HashMap();
		FontName[] var3 = var1;

		for (int var4 = 0; var4 < var3.length; ++var4) {
			FontName var5 = var3[var4];
			if (this.map.containsKey(var5)) {
				var2.put(var5, this.map.get(var5));
			} else {
				IndexDataBase var7 = this.field3892;
				IndexDataBase var8 = this.field3890;
				String var9 = var5.field3885;
				int var10 = var7.getFile(var9);
				int var11 = var7.getChild(var10, "");
				Font var6 = FontName.method5488(var7, var8, var10, var11);
				if (var6 != null) {
					this.map.put(var5, var6);
					var2.put(var5, var6);
				}
			}
		}

		return var2;
	}
}
