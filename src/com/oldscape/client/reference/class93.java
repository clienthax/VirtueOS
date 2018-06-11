package com.oldscape.client.reference;

class class93 {
    static final byte[] field1428;
    static final byte[] field1429;
    static final Buffer[] field1430;
    static final int[] playerIndices;
    static final int[] field1435;
    static final int[] Players_regions;
    static final int[] Players_orientations;
    static final int[] Players_targetIndices;
    static final int[] field1439;
    static final Buffer field1432;
    static int playerIndexesCount;
    static int field1433;
    static int field1438;
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
