package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.SetRootWigetEvent;
import io.netty.buffer.ByteBufAllocator;

public class SetRootWidgetEncoder implements GameMessageEncoder<SetRootWigetEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, SetRootWigetEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_ROOT, FrameType.FIXED);

        builder.put(DataType.SHORT, DataTransformation.ADD, event.getWidgetId());

        return builder.toGameFrame();
    }
}
