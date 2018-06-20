package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.WidgetAnimEvent;
import io.netty.buffer.ByteBufAllocator;

public class WidgetAnimEventEncoder implements
        GameMessageEncoder<WidgetAnimEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, WidgetAnimEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_SET_ANIM, FrameType.FIXED);

        builder.put(DataType.SHORT, DataOrder.LITTLE, DataTransformation.ADD, event.getAnim());
        builder.put(DataType.INT, DataOrder.INVERSED_MIDDLE, (event.getWidget() << 16 | event.getChild()));

        return builder.toGameFrame();
    }
}
