package com.oldscape.shared.network.game;

import com.oldscape.shared.utility.IsaacRandom;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.logging.Logger;

enum State {READ_OPCODE, READ_SIZE, READ_PAYLOAD};

public final class GameFrameDecoder extends ByteToMessageDecoder {

    public static final int[] PACKET_SIZES = new int[]{ //tODO update between revisions -- 168
            16,
            -2, -1, 3, 3, 4, 7, -2, 3, -1, 15,
            7, -1, -1, 8, 14, 7, 8, 8, 4, 8, 3, 6, 11, 0, 1, -1, 0, 10, 2, 15, -1, -1, 8, 9, 8, 13, 3, 8, -1, 9, 8, 3, 8, 11, 13, 8, 3, 3, 4, -1, -1, 13, 2, 7, 2, 8, 5, 7, 9, 7, 16, 3, 8, 6, 8, 8, -1, 7, 0, 8, 3, 3, 4, 9, 2, 0, 4, -1, -1, 8, 3, 16, 7, 7, 8, 7, -1, -1, 3, 8, 3, -1, -1, -2, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    private final IsaacRandom random;
    public Logger logger = Logger.getLogger(GameFrameDecoder.class.getName());
    private State state = State.READ_OPCODE;
    private FrameType type;

    private int opcode, size;

    public GameFrameDecoder(IsaacRandom random) {
        this.random = random;
    }

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out)
            throws Exception {
        if (state == State.READ_OPCODE) {
            if (!buf.isReadable())
                return;

            opcode = (buf.readByte() - random.nextInt()) & 0xFF;
            size = PACKET_SIZES[opcode];

            if (size == -2) {
                type = FrameType.VARIABLE_SHORT;
            } else if (size == -1) {
                type = FrameType.VARIABLE_BYTE;
            } else {
                type = FrameType.FIXED;
            }

            if (size == -3) {
                //type = FrameType.FIXED;
                //size = buf.readableBytes();
                throw new IllegalStateException("Illegal Opcode: [" + opcode + "]");
            }

            state = type != FrameType.FIXED ? State.READ_SIZE
                    : State.READ_PAYLOAD;
        }

        if (state == State.READ_SIZE) {
            if (!buf.isReadable())
                return;

            if (type == FrameType.VARIABLE_BYTE) {
                size = buf.readUnsignedByte();
            } else if (type == FrameType.VARIABLE_SHORT) {
                if (buf.readableBytes() >= 2) {
                    size = buf.readUnsignedShort();
                }
            }

            state = State.READ_PAYLOAD;
        }

        if (state == State.READ_PAYLOAD) {
            if (buf.readableBytes() < size)
                return;

            ByteBuf payload = buf.readBytes(size);
            state = State.READ_OPCODE;

            out.add(new GameFrame(opcode, type, payload));
        }
    }

}