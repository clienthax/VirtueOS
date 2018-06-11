package com.oldscape.client.reference;

final class class62 {
    static final int[][][] tileHeights;
    static final byte[][][] tileSettings;
    static final int[] field749;
    static final int[] field746;
    static final int[] field738;
    static final int[] field740;
    static final int[] field752;
    static final int[] field750;
    static int field747;
    static byte[][][] tileUnderlayIds;
    static byte[][][] tileOverlayIds;
    static byte[][][] tileOverlayPath;
    static byte[][][] overlayRotations;
    static int field751;
    static int field745;

    static {
        tileHeights = new int[4][105][105];
        tileSettings = new byte[4][104][104];
        field747 = 99;
        field749 = new int[]{1, 2, 4, 8};
        field746 = new int[]{16, 32, 64, 128};
        field738 = new int[]{1, 0, -1, 0};
        field740 = new int[]{0, -1, 0, 1};
        field752 = new int[]{1, -1, -1, 1};
        field750 = new int[]{-1, -1, 1, 1};
        field751 = (int) (Math.random() * 17.0D) - 8;
        field745 = (int) (Math.random() * 33.0D) - 16;
    }
}
