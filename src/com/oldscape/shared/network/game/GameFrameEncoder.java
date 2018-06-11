package com.oldscape.shared.network.game;

import com.oldscape.shared.utility.IsaacRandom;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public final class GameFrameEncoder extends MessageToByteEncoder<GameFrame> {

    private final IsaacRandom random;

    public GameFrameEncoder(IsaacRandom random) {
        this.random = random;
    }

    @Override
    public void encode(ChannelHandlerContext ctx, GameFrame frame, ByteBuf buf) throws Exception {
        FrameType type = frame.getType();
        ByteBuf payload = frame.getPayload();

        int opcode = frame.getOpcode();

        buf.writeByte(opcode + random.nextInt());

        if (type == FrameType.VARIABLE_BYTE)
            buf.writeByte(payload.writerIndex());

        else if (type == FrameType.VARIABLE_SHORT)
            buf.writeShort(payload.writerIndex());

        buf.writeBytes(payload);

//		System.out.println(opcode + " " + type + " " + payload );

        payload.release();
    }

}
