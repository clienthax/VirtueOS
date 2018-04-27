package com.oldscape.client;

public class class153 extends class297 {

	final boolean field2155;

	public class153(boolean var1) {
		this.field2155 = var1;
	}

	int method3141(ChatPlayer var1, ChatPlayer var2) {
		return var1.world != 0 && var2.world != 0
				? (this.field2155 ? var1.field3845 - var2.field3845 : var2.field3845 - var1.field3845)
				: this.method5282(var1, var2);
	}

	@Override
	public int compare(Object var1, Object var2) {
		return this.method3141((ChatPlayer) var1, (ChatPlayer) var2);
	}
}
