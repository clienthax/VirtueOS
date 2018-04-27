package com.oldscape.client;

public class class93 {

	static byte[] field1428;

	static byte[] field1429;

	static Buffer[] field1430;

	static int playerIndexesCount;

	static int[] playerIndices;

	static int field1433;

	static int[] field1435;

	static int[] Players_regions;

	static int[] Players_orientations;

	static int[] Players_targetIndices;

	static int field1438;

	static int[] field1439;

	static Buffer field1432;

	static IndexData indexSoundEffects;

	static {
		field1428 = new byte[2048];
		field1429 = new byte[2048];
		field1430 = new Buffer[2048];
		playerIndexesCount = 0;
		playerIndices = new int[2048];
		field1433 = 0;
		field1435 = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		field1438 = 0;
		field1439 = new int[2048];
		field1432 = new Buffer(new byte[5000]);
	}
}
