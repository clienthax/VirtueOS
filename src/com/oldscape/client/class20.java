package com.oldscape.client;

public class class20 {

	static int field336;

	static MapIconReference scriptMapIconReference;

	static Font font_p12full;

	static int cameraY;

	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatLineBuffer var4 = (ChatLineBuffer) class95.chatLineMap.get(Integer.valueOf(var0));
		if (var4 == null) {
			var4 = new ChatLineBuffer();
			class95.chatLineMap.put(Integer.valueOf(var0), var4);
		}

		MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
		class95.messages.put(var5, var5.id);
		class95.field1453.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}

	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (class189.loadWidget(var0)) {
				Widget[] var1 = MouseRecorder.widgets[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoadListener != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.objs = var3.onLoadListener;
						FloorUnderlayDefinition.runScript(var4, 5000000);
					}
				}

			}
		}
	}
}
