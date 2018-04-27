package com.sean.shared.network.game;

import io.netty.buffer.ByteBuf;

public final class GameFrameReader {

	private static final int[] BITMASKS = { 0x0, 0x1, 0x3, 0x7, 0xf, 0x1f, 0x3f, 0x7f, 0xff, 0x1ff, 0x3ff, 0x7ff, 0xfff,
			0x1fff, 0x3fff, 0x7fff, 0xffff, 0x1ffff, 0x3ffff, 0x7ffff, 0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff,
			0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff, -1 };

	private final int opcode;
	private final ByteBuf buffer;
	private AccessMode mode = AccessMode.BYTE_ACCESS;
	private int bitIndex;

	public GameFrameReader(GameFrame frame) {
		opcode = frame.getOpcode();
		buffer = frame.getPayload();
	}

	public int getOpcode() {
		return opcode;
	}

	public int getLength() {
		checkByteAccess();
		return buffer.readableBytes();
	}

	public void switchToByteAccess() {
		if (mode == AccessMode.BYTE_ACCESS) {
			throw new IllegalStateException("Already in byte access mode");
		}
		mode = AccessMode.BYTE_ACCESS;
		buffer.readerIndex((bitIndex + 7) / 8);
	}

	public void switchToBitAccess() {
		if (mode == AccessMode.BIT_ACCESS) {
			throw new IllegalStateException("Already in bit access mode");
		}
		mode = AccessMode.BIT_ACCESS;
		bitIndex = buffer.readerIndex() * 8;
	}

	public int getSignedSmart() {
		checkByteAccess();
		int peek = buffer.getByte(buffer.readerIndex());
		if (peek < 128) {
			return buffer.readByte() - 64;
		} else {
			return buffer.readShort() - 49152;
		}
	}

	public int getUnsignedSmart() {
		checkByteAccess();
		int peek = buffer.getByte(buffer.readerIndex());
		if (peek < 128) {
			return buffer.readByte();
		} else {
			return buffer.readShort() - 32768;
		}
	}

	/**
	 * Reads a RuneScape string from a buffer.
	 * 
	 * @param buf
	 *            The buffer.
	 * @return The string.
	 */
	public String getString() {
		StringBuilder bldr = new StringBuilder();
		byte b;
		while (buffer.isReadable() && (b = buffer.readByte()) != 0) {
			bldr.append((char) b);
		}
		return bldr.toString();
	}

	public long getSigned(DataType type) {
		return getSigned(type, DataOrder.BIG, DataTransformation.NONE);
	}

	public long getSigned(DataType type, DataOrder order) {
		return getSigned(type, order, DataTransformation.NONE);
	}

	public long getSigned(DataType type, DataTransformation transformation) {
		return getSigned(type, DataOrder.BIG, transformation);
	}

	public long getSigned(DataType type, DataOrder order, DataTransformation transformation) {
		long longValue = get(type, order, transformation);
		if (type != DataType.LONG) {
			int max = (int) (Math.pow(2, type.getBytes() * 8 - 1) - 1);
			if (longValue > max) {
				longValue -= (max + 1) * 2;
			}
		}
		return longValue;
	}

	public long getUnsigned(DataType type) {
		return getUnsigned(type, DataOrder.BIG, DataTransformation.NONE);
	}

	public long getUnsigned(DataType type, DataOrder order) {
		return getUnsigned(type, order, DataTransformation.NONE);
	}

	public long getUnsigned(DataType type, DataTransformation transformation) {
		return getUnsigned(type, DataOrder.BIG, transformation);
	}

	public long getUnsigned(DataType type, DataOrder order, DataTransformation transformation) {
		long longValue = get(type, order, transformation);
		if (type == DataType.LONG) {
			throw new IllegalArgumentException("due to java restrictions, longs must be read as signed types");
		}
		return longValue & 0xFFFFFFFFFFFFFFFFL;
	}

	private long get(DataType type, DataOrder order, DataTransformation transformation) {
		checkByteAccess();
		long longValue = 0;
		int length = type.getBytes();
		if (order == DataOrder.BIG) {
			for (int i = length - 1; i >= 0; i--) {
				if (i == 0 && transformation != DataTransformation.NONE) {
					if (transformation == DataTransformation.ADD) {
						longValue |= (buffer.readByte() - 128) & 0xFF;
					} else if (transformation == DataTransformation.NEGATE) {
						longValue |= (-buffer.readByte()) & 0xFF;
					} else if (transformation == DataTransformation.SUBTRACT) {
						longValue |= (128 - buffer.readByte()) & 0xFF;
					} else {
						throw new IllegalArgumentException("unknown transformation");
					}
				} else {
					longValue |= ((buffer.readByte() & 0xFF) << (i * 8));
				}
			}
		} else if (order == DataOrder.LITTLE) {
			for (int i = 0; i < length; i++) {
				if (i == 0 && transformation != DataTransformation.NONE) {
					if (transformation == DataTransformation.ADD) {
						longValue |= (buffer.readByte() - 128) & 0xFF;
					} else if (transformation == DataTransformation.NEGATE) {
						longValue |= (-buffer.readByte()) & 0xFF;
					} else if (transformation == DataTransformation.SUBTRACT) {
						longValue |= (128 - buffer.readByte()) & 0xFF;
					} else {
						throw new IllegalArgumentException("unknown transformation");
					}
				} else {
					longValue |= ((buffer.readByte() & 0xFF) << (i * 8));
				}
			}
		} else if (order == DataOrder.MIDDLE) {
			if (transformation != DataTransformation.NONE) {
				throw new IllegalArgumentException("middle endian cannot be transformed");
			}
			if (type == DataType.INT) {
				longValue |= (buffer.readByte() & 0xFF) << 8;
				longValue |= buffer.readByte() & 0xFF;
				longValue |= (buffer.readByte() & 0xFF) << 24;
				longValue |= (buffer.readByte() & 0xFF) << 16;
			} else if (type == DataType.MEDIUM) {
				longValue |= (buffer.readByte() & 0xFF) << 8;
				longValue |= (buffer.readByte() & 0xFF) << 16;
				longValue |= buffer.readByte() & 0xFF;
			} else {
				throw new IllegalArgumentException("middle endian can only be used with an integer/tri-byte");
			}
		} else if (order == DataOrder.INVERSED_MIDDLE) {
			if (transformation != DataTransformation.NONE) {
				throw new IllegalArgumentException("inversed middle endian cannot be transformed");
			}
			if (type == DataType.INT) {
				longValue |= (buffer.readByte() & 0xFF) << 16;
				longValue |= (buffer.readByte() & 0xFF) << 24;
				longValue |= buffer.readByte() & 0xFF;
				longValue |= (buffer.readByte() & 0xFF) << 8;
			} else if (type == DataType.MEDIUM) {
				longValue |= (buffer.readByte() & 0xFF) << 16;
				longValue |= buffer.readByte() & 0xFF;
				longValue |= (buffer.readByte() & 0xFF) << 8;
			} else {
				throw new IllegalArgumentException("inversed middle endian can only be used with an integer/tri-byte");
			}
		} else {
			throw new IllegalArgumentException("unknown order");
		}
		return longValue;
	}

	public void getBytes(byte[] bytes) {
		checkByteAccess();
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = buffer.readByte();
		}
	}

	public void getBytes(DataTransformation transformation, byte[] bytes) {
		if (transformation == DataTransformation.NONE) {
			getBytesReverse(bytes);
		} else {
			for (int i = 0; i < bytes.length; i++) {
				bytes[i] = (byte) getSigned(DataType.BYTE, transformation);
			}
		}
	}

	public void getBytesReverse(byte[] bytes) {
		checkByteAccess();
		for (int i = bytes.length - 1; i >= 0; i--) {
			bytes[i] = buffer.readByte();
		}
	}

	public void getBytesReverse(DataTransformation transformation, byte[] bytes) {
		if (transformation == DataTransformation.NONE) {
			getBytesReverse(bytes);
		} else {
			for (int i = bytes.length - 1; i >= 0; i--) {
				bytes[i] = (byte) getSigned(DataType.BYTE, transformation);
			}
		}
	}

	private void checkByteAccess() {
		if (mode != AccessMode.BYTE_ACCESS) {
			throw new IllegalStateException("For byte-based calls to work, the mode must be byte access");
		}
	}

	private void checkBitAccess() {
		if (mode != AccessMode.BIT_ACCESS) {
			throw new IllegalStateException("For bit-based calls to work, the mode must be bit access");
		}
	}

	public int getBit() {
		return getBits(1);
	}

	public int getBits(int numBits) {
		if (numBits < 0 || numBits > 32) {
			throw new IllegalArgumentException("Number of bits must be between 1 and 32 inclusive");
		}

		checkBitAccess();

		int bytePos = bitIndex >> 3;
		int bitOffset = 8 - (bitIndex & 7);
		int value = 0;
		bitIndex += numBits;

		for (; numBits > bitOffset; bitOffset = 8) {
			value += (buffer.getByte(bytePos++) & BITMASKS[bitOffset]) << numBits - bitOffset;
			numBits -= bitOffset;
		}
		if (numBits == bitOffset) {
			value += buffer.getByte(bytePos) & BITMASKS[bitOffset];
		} else {
			value += buffer.getByte(bytePos) >> bitOffset - numBits & BITMASKS[numBits];
		}
		return value;
	}

}
