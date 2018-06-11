package com.oldscape.client.reference;

final class DState {
    final int[] field2550;
    final int[] field2558;
    final boolean[] inUse;
    final boolean[] field2561;
    final byte[] seqToUnseq;
    final byte[] field2563;
    final int[] field2562;
    final byte[] field2565;
    final byte[] field2566;
    final byte[][] field2543;
    final int[][] field2568;
    final int[][] field2569;
    final int[][] field2552;
    final int[] field2571;
    private final int field2564;
    private final int field2544;
    private final int field2549;
    private final int field2538;
    private final int field2539;
    private final int field2540;
    byte[] strm;
    int next_in;
    int total_out_lo32;
    byte[] out;
    int next_out;
    int field2553;
    int total_out_hi32;
    byte out_ch;
    int out_len;
    int total_in_hi32;
    int total_in_lo32;
    int blockSize100k;
    int field2541;
    int tPos;
    int k0;
    int nblock_used;
    int nInUse;
    int field2572;

    DState() {
        this.field2564 = 4096;
        this.field2544 = 16;
        this.field2549 = 258;
        this.field2538 = 6;
        this.field2539 = 50;
        this.field2540 = 18002;
        this.next_in = 0;
        this.next_out = 0;
        this.field2550 = new int[256];
        this.field2558 = new int[257];
        this.inUse = new boolean[256];
        this.field2561 = new boolean[16];
        this.seqToUnseq = new byte[256];
        this.field2563 = new byte[4096];
        this.field2562 = new int[16];
        this.field2565 = new byte[18002];
        this.field2566 = new byte[18002];
        this.field2543 = new byte[6][258];
        this.field2568 = new int[6][258];
        this.field2569 = new int[6][258];
        this.field2552 = new int[6][258];
        this.field2571 = new int[6];
    }

}
