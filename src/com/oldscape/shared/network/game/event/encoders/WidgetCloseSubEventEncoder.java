package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.WidgetCloseSubEvent;
import io.netty.buffer.ByteBufAllocator;

public class WidgetCloseSubEventEncoder implements
        GameMessageEncoder<WidgetCloseSubEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, WidgetCloseSubEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_CLOSE_SUB, FrameType.FIXED);

        builder.put(DataType.INT, (event.getRoot() << 16 | event.getChild()));

        return builder.toGameFrame();
    }
}
