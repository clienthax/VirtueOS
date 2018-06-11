package com.oldscape.shared.network.ondemand;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Sean
 * @author Graham
 */
public final class XorEncoder extends MessageToByteEncoder<ByteBuf> {

    private int key = 0;

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public void encode(ChannelHandlerContext ctx, ByteBuf in, ByteBuf out) {
        while (in.isReadable()) {
            out.writeByte(in.readUnsignedByte() ^ key);
        }
    }
}
