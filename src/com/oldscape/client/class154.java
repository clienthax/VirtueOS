package com.oldscape.client;

public class class154 extends class297 {

	public static boolean[] validInterfaces;

	final boolean field2158;

	public class154(boolean var1) {
		this.field2158 = var1;
	}

	int method3149(ChatPlayer var1, ChatPlayer var2) {
		if (var1.world != 0) {
			if (var2.world == 0) {
				return this.field2158 ? -1 : 1;
			}
		} else if (var2.world != 0) {
			return this.field2158 ? 1 : -1;
		}

		return this.method5282(var1, var2);
	}

	@Override
	public int compare(Object var1, Object var2) {
		return this.method3149((ChatPlayer) var1, (ChatPlayer) var2);
	}

	public static int method3157(int var0, int var1, int var2) {
		var2 &= 3;
		return var2 == 0 ? var1 : (var2 == 1 ? 7 - var0 : (var2 == 2 ? 7 - var1 : var0));
	}

	static void method3156() {
		if (Client.spellSelected) {
			Widget var0 = FontName.getWidgetChild(class234.field2768, Client.field1025);
			if (var0 != null && var0.onTargetLeaveListener != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.objs = var0.onTargetLeaveListener;
				AbstractSoundSystem.method2256(var1);
			}

			Client.spellSelected = false;
			FontName.method5490(var0);
		}
	}
}
