package com.oldscape.shared.network.game.event;

import com.oldscape.shared.event.Event;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameReader;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * Created by sean on 09/08/14.
 */
public final class GameEventDecoder extends MessageToMessageDecoder<GameFrame> {

    /**
     * The {@link GameEventRepository}.
     */
    private final GameEventRepository repository;

    /**
     * Creates a new {@link com.oldscape.shared.network.game.event.GameEventDecoder}
     * .
     *
     * @param repository The {@link GameEventRepository}.
     */
    public GameEventDecoder(GameEventRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void decode(ChannelHandlerContext ctx, GameFrame msg, List<Object> out) throws Exception {
        GameMessageDecoder<Event> decoder = (GameMessageDecoder<Event>) repository.getMessageDecoder(msg.getOpcode());

        if (decoder == null) {

            System.err.println("No Decoder for: " + msg.getOpcode() + ", " + msg.getPayload().readableBytes());

            return;
        } else {
            //System.err.println("Decoder for: " + msg.getOpcode() + ", " + msg.getPayload().readableBytes()+" "+decoder.getClass().getCanonicalName());
        }
        out.add(decoder.decode(new GameFrameReader(msg)));
    }
}
