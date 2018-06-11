package com.oldscape.shared.network.game.event;

import com.oldscape.shared.event.Event;
import com.oldscape.shared.network.game.GameFrame;
import io.netty.buffer.ByteBufAllocator;

/**
 * Created by sean on 09/08/14.
 */
public interface GameMessageEncoder<E extends Event> {

    /**
     * Encodes a type of {@link com.oldscape.shared.event.Event} into a
     * {@link com.oldscape.shared.network.game.GameFrame}.
     *
     * @param alloc The {@link io.netty.buffer.ByteBufAllocator}.
     * @param event The type of {@link com.oldscape.shared.event.Event} to encode.
     * @return The encoded {@link com.oldscape.shared.event.Event} as a
     * {@link com.oldscape.shared.network.game.GameFrame}.
     */
    public GameFrame encode(ByteBufAllocator alloc, E event);

}
