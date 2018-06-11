package com.oldscape.shared.network.game;

import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.utility.BufferUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public final class GameFrameBuilder {

    private static final int[] BITMASKS = {0x0, 0x1, 0x3, 0x7, 0xf, 0x1f, 0x3f, 0x7f, 0xff, 0x1ff, 0x3ff, 0x7ff, 0xfff,
            0x1fff, 0x3fff, 0x7fff, 0xffff, 0x1ffff, 0x3ffff, 0x7ffff, 0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff,
            0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff, -1};

    private final int opcode;
    private final FrameType type;
    private final ByteBufAllocator alloc;
    private final ByteBuf buffer;
    private AccessMode mode = AccessMode.BYTE_ACCESS;
    private int bitIndex;

    public GameFrameBuilder(ByteBufAllocator alloc) {
        this(alloc, EncoderOpcode.RAW, FrameType.RAW);
    }

    public GameFrameBuilder(ByteBufAllocator alloc, EncoderOpcode opcode, FrameType type) {
        this.alloc = alloc;
        this.buffer = alloc.buffer();
        this.opcode = opcode.getOpcode();
        this.type = type;
    }

    public GameFrame toGameFrame() {
        if (type == FrameType.RAW)
            throw new IllegalStateException("Raw builders cannot be converted to frames");

        if (mode != AccessMode.BYTE_ACCESS)
            throw new IllegalStateException("Must be in byte access mode to convert to a packet");

        return new GameFrame(opcode, type, buffer);
    }

    public void release() {
        buffer.release();
    }

    public ByteBufAllocator getAllocator() {
        return alloc;
    }

    public int getLength() {
        checkByteAccess();
        return buffer.writerIndex();
    }

    public void switchToByteAccess() {
        if (mode == AccessMode.BYTE_ACCESS) {
            throw new IllegalStateException("Already in byte access mode");
        }
        mode = AccessMode.BYTE_ACCESS;
        buffer.writerIndex((bitIndex + 7) / 8);
    }

    public void switchToBitAccess() {
        if (mode == AccessMode.BIT_ACCESS) {
            throw new IllegalStateException("Already in bit access mode");
        }
        mode = AccessMode.BIT_ACCESS;
        bitIndex = buffer.writerIndex() * 8;
    }

    /**
     * Puts a standard data type with the specified value.
     *
     * @param type  The data type.
     * @param value The value.
     * @throws IllegalStateException if this reader is not in byte access mode.
     */
    public void put(DataType type, Number value) {
        put(type, DataOrder.BIG, DataTransformation.NONE, value);
    }

    /**
     * Puts a standard data type with the specified value and byte order.
     *
     * @param type  The data type.
     * @param order The byte order.
     * @param value The value.
     * @throws IllegalStateException    if this reader is not in byte access mode.
     * @throws IllegalArgumentException if the combination is invalid.
     */
    public void put(DataType type, DataOrder order, Number value) {
        put(type, order, DataTransformation.NONE, value);
    }

    /**
     * Puts a standard data type with the specified value and transformation.
     *
     * @param type           The type.
     * @param transformation The transformation.
     * @param value          The value.
     * @throws IllegalStateException    if this reader is not in byte access mode.
     * @throws IllegalArgumentException if the combination is invalid.
     */
    public void put(DataType type, DataTransformation transformation, Number value) {
        put(type, DataOrder.BIG, transformation, value);
    }

    /**
     * Puts a standard data type with the specified value, byte order and
     * transformation.
     *
     * @param type           The data type.
     * @param order          The byte order.
     * @param transformation The transformation.
     * @param value          The value.
     * @throws IllegalStateException    if this reader is not in byte access mode.
     * @throws IllegalArgumentException if the combination is invalid.
     */
    public void put(DataType type, DataOrder order, DataTransformation transformation, Number value) {
        checkByteAccess();
        long longValue = value.longValue();
        int length = type.getBytes();

        if (order == DataOrder.BIG) {
            for (int i = length - 1; i >= 0; i--) {
                if (i == 0 && transformation != DataTransformation.NONE) {
                    if (transformation == DataTransformation.ADD) {
                        buffer.writeByte((byte) (longValue + 128));
                    } else if (transformation == DataTransformation.NEGATE) {
                        buffer.writeByte((byte) (-longValue));
                    } else if (transformation == DataTransformation.SUBTRACT) {
                        buffer.writeByte((byte) (128 - longValue));
                    } else {
                        throw new IllegalArgumentException("unknown transformation");
                    }
                } else {
                    buffer.writeByte((byte) (longValue >> (i * 8)));
                }
            }
        } else if (order == DataOrder.LITTLE) {
            for (int i = 0; i < length; i++) {
                if (i == 0 && transformation != DataTransformation.NONE) {
                    if (transformation == DataTransformation.ADD) {
                        buffer.writeByte((byte) (longValue + 128));
                    } else if (transformation == DataTransformation.NEGATE) {
                        buffer.writeByte((byte) (-longValue));
                    } else if (transformation == DataTransformation.SUBTRACT) {
                        buffer.writeByte((byte) (128 - longValue));
                    } else {
                        throw new IllegalArgumentException("unknown transformation");
                    }
                } else {
                    buffer.writeByte((byte) (longValue >> (i * 8)));
                }
            }
        } else if (order == DataOrder.MIDDLE) {

            if (transformation != DataTransformation.NONE) {
                throw new IllegalArgumentException("middle endian cannot be transformed");
            }
            if (type == DataType.INT) {
                buffer.writeByte((byte) (longValue >> 8));
                buffer.writeByte((byte) longValue);
                buffer.writeByte((byte) (longValue >> 24));
                buffer.writeByte((byte) (longValue >> 16));
            } else if (type == DataType.MEDIUM) {
                buffer.writeByte((byte) (longValue >> 8));
                buffer.writeByte((byte) (longValue >> 16));
                buffer.writeByte((byte) longValue);
            } else {
                throw new IllegalArgumentException("middle endian can only be used with an integer/tri-byte");
            }

        } else if (order == DataOrder.INVERSED_MIDDLE) {
            if (transformation != DataTransformation.NONE) {
                throw new IllegalArgumentException("inversed middle endian cannot be transformed");
            }
            if (type == DataType.INT) {
                buffer.writeByte((byte) (longValue >> 16));
                buffer.writeByte((byte) (longValue >> 24));
                buffer.writeByte((byte) longValue);
                buffer.writeByte((byte) (longValue >> 8));
            } else if (type == DataType.MEDIUM) {
                buffer.writeByte((byte) (longValue >> 16));
                buffer.writeByte((byte) longValue);
                buffer.writeByte((byte) (longValue >> 8));
            } else {
                throw new IllegalArgumentException("inversed middle endian can only be used with an integer/tri-byte");
            }
        } else {
            throw new IllegalArgumentException("unknown order");
        }
    }

    /**
     * Puts a string into the buffer.
     *
     * @param str The string.
     */
    public void putString(String str) {
        checkByteAccess();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            buffer.writeByte((byte) c);
        }
        buffer.writeByte(0);
    }

    /**
     * Puts a {@link java.lang.String} into the buffer.
     *
     * @param str The string.
     */
    public void putJagString(String str) {
        BufferUtils.putJagString(buffer, str);
    }

    /**
     * Puts a smart into the buffer.
     *
     * @param value The value.
     */
    public void putSmart(int value) {
        checkByteAccess();
        if (value < Byte.MAX_VALUE) {
            buffer.writeByte(value);
        } else {
            buffer.writeShort(value);
        }
    }

    /**
     * Puts a big smart into the buffer.
     *
     * @param value The value.
     */
    public void putBigSmart(int value) {
        checkByteAccess();
        if (value < Short.MAX_VALUE) {
            buffer.writeShort(value);
        } else {
            buffer.writeInt(value - Integer.MAX_VALUE - 1);
        }
    }

    /**
     * Puts the bytes into the buffer.
     *
     * @param bytes The byte array.
     * @throws IllegalStateException if the builder is not in byte access mode.
     */
    public void putBytes(byte[] bytes) {
        putBytes(DataTransformation.NONE, bytes);
    }

    /**
     * Puts the specified byte array into the buffer in reverse
     *
     * @param bytes The byte array.
     * @throws IllegalStateException if the builder is not in byte access mode.
     */
    public void putBytesReverse(byte[] bytes) {
        putBytesReverse(DataTransformation.NONE, bytes);
    }

    /**
     * Puts a raw builder. Both builders (this and parameter) must be in byte
     * access mode.
     *
     * @param builder The builder.
     */
    public void putRawBuilder(GameFrameBuilder builder) {
        putRawBuilder(DataTransformation.NONE, builder);
    }

    /**
     * Puts a raw builder in reverse. Both builders (this and parameter) must be
     * in byte access mode.
     *
     * @param builder The builder.
     */
    public void putRawBuilderReverse(GameFrameBuilder builder) {
        putRawBuilderReverse(DataTransformation.NONE, builder);
    }

    /**
     * Puts a raw builder. Both builders (this and parameter) must be in byte
     * access mode.
     *
     * @param builder The builder.
     */
    public void putRawBuilder(DataTransformation transformation, GameFrameBuilder builder) {
        checkByteAccess();
        if (builder.type != FrameType.RAW) {
            throw new IllegalArgumentException("Builder must be raw!");
        }
        builder.checkByteAccess();
        putBytes(transformation, builder.buffer);
    }

    /**
     * Puts the bytes from the specified buffer into this packet's buffer.
     *
     * @param buffer The source {@link io.netty.buffer.ByteBuf}.
     * @throws IllegalStateException if the builder is not in byte access mode.
     */
    public void putBytes(DataTransformation transformation, ByteBuf buffer) {
        byte[] bytes = new byte[buffer.readableBytes()];
        buffer.markReaderIndex();
        try {
            buffer.readBytes(bytes);
        } finally {
            buffer.resetReaderIndex();
        }
        putBytes(transformation, bytes);
    }

    /**
     * Puts the bytes into the buffer with the specified transformation.
     *
     * @param transformation The transformation.
     * @param bytes          The byte array.
     * @throws IllegalStateException if the builder is not in byte access mode.
     */
    public void putBytes(DataTransformation transformation, byte[] bytes) {
        if (transformation == DataTransformation.NONE) {
            buffer.writeBytes(bytes);
        } else {
            for (byte b : bytes) {
                put(DataType.BYTE, transformation, b);
            }
        }
    }

    /**
     * Puts a raw builder in reverse. Both builders (this and parameter) must be
     * in byte access mode.
     *
     * @param builder The builder.
     */
    public void putRawBuilderReverse(DataTransformation transformation, GameFrameBuilder builder) {
        checkByteAccess();
        if (builder.type != FrameType.RAW) {
            throw new IllegalArgumentException("Builder must be raw!");
        }
        builder.checkByteAccess();
        putBytesReverse(transformation, builder.buffer);
    }

    /**
     * Puts the bytes from the specified buffer into this packet's buffer, in
     * reverse.
     *
     * @param buffer The source {@link io.netty.buffer.ByteBuf}.
     * @throws IllegalStateException if the builder is not in byte access mode.
     */
    public void putBytesReverse(DataTransformation transformation, ByteBuf buffer) {
        byte[] bytes = new byte[buffer.readableBytes()];
        buffer.markReaderIndex();
        try {
            buffer.readBytes(bytes);
        } finally {
            buffer.resetReaderIndex();
        }
        putBytesReverse(transformation, bytes);
    }

    /**
     * Puts the specified byte array into the buffer in reverse with the
     * specified transformation.
     *
     * @param transformation The transformation.
     * @param bytes          The byte array.
     * @throws IllegalStateException if the builder is not in byte access mode.
     */
    public void putBytesReverse(DataTransformation transformation, byte[] bytes) {
        for (int i = bytes.length - 1; i >= 0; i--) {
            if (transformation == DataTransformation.NONE) {
                buffer.writeByte(bytes[i]);
            } else {
                put(DataType.BYTE, transformation, bytes[i]);
            }
        }
    }

    /**
     * Puts a single bit into the buffer. If {@code flag} is {@code true}, the
     * value of the bit is {@code 1}. If {@code flag} is {@code false}, the
     * value of the bit is {@code 0}.
     *
     * @param flag The flag.
     * @throws IllegalStateException if the builder is not in bit access mode.
     */
    public void putBit(boolean flag) {
        putBit(flag ? 1 : 0);
    }

    /**
     * Puts a single bit into the buffer with the value {@code value}.
     *
     * @param value The value.
     * @throws IllegalStateException if the builder is not in bit access mode.
     */
    public void putBit(int value) {
        putBits(1, value);
    }

    /**
     * Puts {@code numBits} into the buffer with the value {@code value}.
     *
     * @param numBits The number of bits to put into the buffer.
     * @param value   The value.
     * @throws IllegalStateException    if the builder is not in bit access mode.
     * @throws IllegalArgumentException if the number of bits is not between 1 and 31 inclusive.
     */
    public void putBits(int numBits, int value) {
        if (numBits <= 0 || numBits > 32) {
            throw new IllegalArgumentException("Number of bits must be between 1 and 31 inclusive");
        }
        checkBitAccess();
        int bytePos = bitIndex >> 3;
        buffer.writerIndex(bytePos + 1);
        if (buffer.writableBytes() < ((numBits + 7) / 8)) {
            buffer.capacity(buffer.capacity() * 2);
        }
        int bitOffset = 8 - (bitIndex & 0x7);
        bitIndex += numBits;
        for (; numBits > bitOffset; bitOffset = 8) {
            int tmp = buffer.getByte(bytePos);
            tmp &= ~BITMASKS[bitOffset];
            tmp |= (value >> (numBits - bitOffset)) & BITMASKS[bitOffset];
            buffer.setByte(bytePos++, tmp);
            numBits -= bitOffset;
        }
        if (numBits == bitOffset) {
            int tmp = buffer.getByte(bytePos);
            tmp &= ~BITMASKS[bitOffset];
            tmp |= value & BITMASKS[bitOffset];
            buffer.setByte(bytePos, tmp);
        } else {
            int tmp = buffer.getByte(bytePos);
            tmp &= ~(BITMASKS[numBits] << (bitOffset - numBits));
            tmp |= (value & BITMASKS[numBits]) << (bitOffset - numBits);
            buffer.setByte(bytePos, tmp);
        }
    }

    /**
     * Checks that this builder is in the byte access mode.
     *
     * @throws IllegalStateException if the builder is not in byte access mode.
     */
    private void checkByteAccess() {
        if (mode != AccessMode.BYTE_ACCESS) {
            throw new IllegalStateException("For byte-based calls to work, the mode must be byte access");
        }
    }

    /**
     * Checks that this builder is in the bit access mode.
     *
     * @throws IllegalStateException if the builder is not in bit access mode.
     */
    private void checkBitAccess() {
        if (mode != AccessMode.BIT_ACCESS) {
            throw new IllegalStateException("For bit-based calls to work, the mode must be bit access");
        }
    }

}
