package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.VarpEvent;
import io.netty.buffer.ByteBufAllocator;

public class VarpEventEncoder implements GameMessageEncoder<VarpEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, VarpEvent event) {
        GameFrameBuilder builder = null;

        if (event.isBit()) {
            //FIXME: ?
        } else {
            if (event.getState() <= Byte.MIN_VALUE || event.getState() >= Byte.MAX_VALUE) {
                builder = new GameFrameBuilder(alloc, EncoderOpcode.VARP_LARGE, FrameType.FIXED);
                builder.put(DataType.INT, event.getState());
                builder.put(DataType.SHORT, event.getId());
            } else {
                builder = new GameFrameBuilder(alloc, EncoderOpcode.VARP_SMALL, FrameType.FIXED);
                builder.put(DataType.SHORT, DataTransformation.ADD, event.getId());
                builder.put(DataType.BYTE, event.getState());
            }
        }

        return builder.toGameFrame();
    }
}
