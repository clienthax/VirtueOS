package com.oldscape.shared.network.game.event;

import com.oldscape.shared.event.Event;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * Created by sean on 09/08/14.
 */
public final class GameEventEncoder extends MessageToMessageEncoder<Event> {

    /**
     * The {@link com.oldscape.shared.network.game.event.GameEventRepository}.
     */
    private final GameEventRepository repository;

    /**
     * Creates a new {@link GameEventEncoder}.
     *
     * @param repository The {@link com.oldscape.shared.network.game.event.GameEventRepository}.
     */
    public GameEventEncoder(GameEventRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void encode(ChannelHandlerContext ctx, Event msg, List<Object> out) throws Exception {
        GameMessageEncoder<Event> encoder = (GameMessageEncoder<Event>) repository.getMessageEncoder(msg.getClass());
        if (encoder != null) {
            out.add(encoder.encode(ctx.alloc(), msg));
        }
    }
}
