package com.oldscape.client;
import java.applet.Applet;

public class RunException extends RuntimeException {

	public static Applet field2198;

	public static String field2194;

	public static int revision;

	String field2197;

	Throwable parent;

	RunException(Throwable var1, String var2) {
		this.field2197 = var2;
		this.parent = var1;
	}

	static boolean method3215(IndexDataBase var0, int var1, int var2) {
		byte[] var3 = var0.getConfigData(var1, var2);
		if (var3 == null) {
			return false;
		} else {
			Area.decodeSprite(var3);
			return true;
		}
	}
}
