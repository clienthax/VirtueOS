package com.oldscape.client;
import java.io.IOException;
import javax.imageio.ImageIO;

public class class55 {

	static GrandExchangeEvents grandExchangeEvents;

	static int[] floorHues;

	static String sessionToken;

	static IndexData indexCache4;

	static Font fontPlain11;

	static int menuX;

	static int field660;

	static {
		ImageIO.setUseCache(false);
	}

	static final void method837(TaskDataNode var0) {
		var0.field1660 = false;
		if (var0.data != null) {
			var0.data.int1 = 0;
		}

		for (TaskDataNode var1 = var0.vmethod4330(); var1 != null; var1 = var0.vmethod4321()) {
			method837(var1);
		}

	}

	static final void flush(boolean var0) {
		BoundingBox2D.method36();
		++Client.field957.field1485;
		if (Client.field957.field1485 >= 50 || var0) {
			Client.field957.field1485 = 0;
			if (!Client.socketError && Client.field957.getSocket() != null) {
				PacketNode var1 = WorldMapRectangle.method280(ClientPacket.field2452, Client.field957.field1484);
				Client.field957.method2052(var1);

				try {
					Client.field957.method2039();
				} catch (IOException var3) {
					Client.socketError = true;
				}
			}

		}
	}

	static void method834(int var0, int var1, int var2, int var3) {
		Widget var4 = FontName.getWidgetChild(var0, var1);
		if (var4 != null && var4.onTargetEnterListener != null) {
			ScriptEvent var5 = new ScriptEvent();
			var5.widget = var4;
			var5.objs = var4.onTargetEnterListener;
			AbstractSoundSystem.method2256(var5);
		}

		Client.field893 = var3;
		Client.spellSelected = true;
		class234.field2768 = var0;
		Client.field1025 = var1;
		class110.field1607 = var2;
		FontName.method5490(var4);
	}
}
