package com.oldscape.shared.network.handshake;

import com.oldscape.shared.network.HandshakeEvent;
import com.oldscape.shared.network.login.LoginDecoder;
import com.oldscape.shared.network.login.LoginResponseEncoder;
import com.oldscape.shared.network.ondemand.OnDemandDecoder;
import com.oldscape.shared.network.ondemand.OnDemandEncoder;
import com.oldscape.shared.network.ondemand.XorEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by sean on 23/07/14.
 */
public final class HandshakeDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
        if (buffer.isReadable()) {
            int id = buffer.readUnsignedByte();
            HandshakeEvent.HandshakeState state = HandshakeEvent.HandshakeState.getState(id);
            ChannelPipeline pipeline = ctx.pipeline();

            switch (state) {

                case LOGIN:
                    pipeline.addLast(new LoginResponseEncoder());
                    pipeline.addBefore("handler", LoginDecoder.class.getName(), new LoginDecoder());
                    break;

                case ON_DEMAND:
                    pipeline.addLast(new OnDemandEncoder(), new XorEncoder());
                    pipeline.addBefore("handler", OnDemandDecoder.class.getName(), new OnDemandDecoder());
                    break;

                default:
                    throw new IllegalArgumentException("Invalid service id.");
            }

            HandshakeEvent message = new HandshakeEvent(state);

            out.add(message);

            if (buffer.isReadable()) {
                out.add(buffer.readBytes(buffer.readableBytes()));
            }

            pipeline.remove(HandshakeDecoder.class);

        }
    }

}
