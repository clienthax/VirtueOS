package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.ExternalIPEvent;
import io.netty.buffer.ByteBufAllocator;

public class ExternalIPEventEncoder implements
        GameMessageEncoder<ExternalIPEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, ExternalIPEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.EXTERN_IP, FrameType.FIXED);

        builder.put(DataType.INT, DataOrder.LITTLE, event.getHash());

        return builder.toGameFrame();
    }
}
