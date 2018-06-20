package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.WidgetNpcHeadEvent;
import io.netty.buffer.ByteBufAllocator;

public class WidgetNpcHeadEventEncoder implements
        GameMessageEncoder<WidgetNpcHeadEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, WidgetNpcHeadEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_SET_NPC_HEAD, FrameType.FIXED);

        builder.put(DataType.INT, DataOrder.MIDDLE, (event.getWidget() << 16 | event.getChild()));
        builder.put(DataType.SHORT, event.getNpc());

        return builder.toGameFrame();
    }

}
