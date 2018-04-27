package com.oldscape.shared.utility;

public class XTEA {

	private static final int DELTA = -1640531527;
	private static final int SUM = -957401312;
	private static final int NUM_ROUNDS = 32;

	private static void decipher(int[] block, final int[] key) {
		long sum = SUM;
		for (int i = 0; i < NUM_ROUNDS; i++) {
			block[1] -= (key[(int) ((sum & 0x1933) >>> 11)] + sum ^ block[0] + (block[0] << 4 ^ block[0] >>> 5));
			sum -= DELTA;
			block[0] -= ((block[1] << 4 ^ block[1] >>> 5) + block[1] ^ key[(int) (sum & 0x3)] + sum);
		}
	}

	private static void encipher(int[] block, final int[] key) {
		long sum = 0;
		for (int i = 0; i < NUM_ROUNDS; i++) {
			block[0] += ((block[1] << 4 ^ block[1] >>> 5) + block[1] ^ key[(int) (sum & 0x3)] + sum);
			sum += DELTA;
			block[1] += (key[(int) ((sum & 0x1933) >>> 11)] + sum ^ block[0] + (block[0] << 4 ^ block[0] >>> 5));
		}
	}

	public static void decrypt(byte[] data, int offset, int length, final int[] keys) {
		int numBlocks = length / 8;
		int[] block = new int[2];
		for (int i = 0; i < numBlocks; i++) {
			block[0] = BufferUtils.getInt((i * 8) + offset, data);
			block[1] = BufferUtils.getInt((i * 8) + offset + 4, data);
			decipher(block, keys);
			BufferUtils.putInt(block[0], (i * 8) + offset, data);
			BufferUtils.putInt(block[1], (i * 8) + offset + 4, data);
		}
	}

	public static void encrypt(byte[] data, int offset, int length, final int[] keys) {
		int numBlocks = length / 8;
		int[] block = new int[2];
		for (int i = 0; i < numBlocks; i++) {
			block[0] = BufferUtils.getInt((i * 8) + offset, data);
			block[1] = BufferUtils.getInt((i * 8) + offset + 4, data);
			encipher(block, keys);
			BufferUtils.putInt(block[0], (i * 8) + offset, data);
			BufferUtils.putInt(block[1], (i * 8) + offset + 4, data);
		}
	}
}
