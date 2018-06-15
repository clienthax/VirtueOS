package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.WidgetOpenSubEvent;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author Tom
 */
public class WidgetOpenSubEventEncoder implements
        GameMessageEncoder<WidgetOpenSubEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, WidgetOpenSubEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_OPEN_SUB, FrameType.FIXED);

        builder.put(DataType.INT, DataOrder.MIDDLE, event.getRootWidgetId() << 16 | event.getChildId());
        builder.put(DataType.BYTE, DataTransformation.SUBTRACT, event.isClickable() ? 1 : 0);
        builder.put(DataType.SHORT, DataOrder.LITTLE, event.getWidgetId());

        return builder.toGameFrame();
    }
}
