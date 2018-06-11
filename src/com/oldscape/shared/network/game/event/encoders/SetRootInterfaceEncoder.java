package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.SetRootInterfaceEvent;
import io.netty.buffer.ByteBufAllocator;

public class SetRootInterfaceEncoder implements GameMessageEncoder<SetRootInterfaceEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, SetRootInterfaceEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_ROOT, FrameType.FIXED);
        builder.put(DataType.SHORT, DataTransformation.ADD, event.getInterfaceId());
//		System.out.println("root interface "+event.getInterfaceId());

        return builder.toGameFrame();
    }
}
