package com.oldscape.client;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Preferences {

	static RenderOverview renderOverview;

	static short[] field1248;

	static int field1249;

	boolean hideRoofs;

	boolean muted;

	int screenType;

	String rememberedUsername;

	boolean hideUsername;

	LinkedHashMap preferences;

	static {
		field1249 = 6;
	}

	Preferences() {
		this.screenType = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.preferences = new LinkedHashMap();
		this.method1727(true);
	}

	Preferences(Buffer var1) {
		this.screenType = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.preferences = new LinkedHashMap();
		if (var1 != null && var1.payload != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= field1249) {
				if (var1.readUnsignedByte() == 1) {
					this.hideRoofs = true;
				}

				if (var2 > 1) {
					this.muted = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.screenType = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.getNullString();
				}

				if (var2 > 5) {
					this.hideUsername = var1.method3524();
				}
			} else {
				this.method1727(true);
			}
		} else {
			this.method1727(true);
		}

	}

	void method1727(boolean var1) {
	}

	Buffer serialize() {
		Buffer var1 = new Buffer(100);
		var1.putByte(field1249);
		var1.putByte(this.hideRoofs ? 1 : 0);
		var1.putByte(this.muted ? 1 : 0);
		var1.putByte(this.screenType);
		var1.putByte(this.preferences.size());
		Iterator var2 = this.preferences.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			var1.putInt(((Integer) var3.getKey()).intValue());
			var1.putInt(((Integer) var3.getValue()).intValue());
		}

		var1.putString(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBooleanAsByte(this.hideUsername);
		return var1;
	}
}
