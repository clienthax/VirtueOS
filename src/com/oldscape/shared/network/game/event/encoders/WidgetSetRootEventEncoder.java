package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.WidgetSetRootEvent;
import io.netty.buffer.ByteBufAllocator;

public class WidgetSetRootEventEncoder implements GameMessageEncoder<WidgetSetRootEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, WidgetSetRootEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_ROOT, FrameType.FIXED);

        builder.put(DataType.SHORT, DataTransformation.ADD, event.getWidgetId());

        return builder.toGameFrame();
    }
}
