package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.WidgetMoveSubEvent;
import io.netty.buffer.ByteBufAllocator;

public class WidgetMoveSubEventEncoder implements
        GameMessageEncoder<WidgetMoveSubEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, WidgetMoveSubEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_MOVE_SUB, FrameType.FIXED);

        builder.put(DataType.INT, DataOrder.MIDDLE, (event.getToRoot() << 16 | event.getToChild()));
        builder.put(DataType.INT, DataOrder.INVERSED_MIDDLE, (event.getFromRoot() << 16 | event.getFromChild()));

        return builder.toGameFrame();
    }
}
