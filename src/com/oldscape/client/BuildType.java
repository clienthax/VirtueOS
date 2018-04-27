package com.oldscape.client;

public class BuildType {

	static final BuildType RC;

	static final BuildType WIP;

	static final BuildType LIVE;

	static final BuildType BUILD_LIVE;

	public final String identifier;

	final int field3358;

	static {
		RC = new BuildType("LIVE", 0);
		WIP = new BuildType("BUILDLIVE", 3);
		LIVE = new BuildType("RC", 1);
		BUILD_LIVE = new BuildType("WIP", 2);
	}

	BuildType(String var1, int var2) {
		this.identifier = var1;
		this.field3358 = var2;
	}
}
