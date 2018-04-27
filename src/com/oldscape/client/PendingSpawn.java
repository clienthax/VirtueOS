package com.oldscape.client;

public final class PendingSpawn extends Node {

	int level;

	int type;

	int x;

	int y;

	int field1146;

	int field1144;

	int field1147;

	int id;

	int orientation;

	int field1151;

	int delay;

	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}

	static final String method1653(int var0, int var1) {
		int var2 = var1 - var0;
		return var2 < -9 ? class45.getColTags(16711680)
				: (var2 < -6 ? class45.getColTags(16723968)
						: (var2 < -3 ? class45.getColTags(16740352)
								: (var2 < 0 ? class45.getColTags(16756736)
										: (var2 > 9 ? class45.getColTags(65280)
												: (var2 > 6 ? class45.getColTags(4259584)
														: (var2 > 3 ? class45.getColTags(8453888)
																: (var2 > 0 ? class45.getColTags(12648192)
																		: class45.getColTags(16776960))))))));
	}
}
