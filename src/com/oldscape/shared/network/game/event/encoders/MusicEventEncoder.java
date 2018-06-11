package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.MusicEvent;
import io.netty.buffer.ByteBufAllocator;

public class MusicEventEncoder implements
        GameMessageEncoder<MusicEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, MusicEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.MUSIC, FrameType.FIXED);
        builder.put(DataType.SHORT, DataTransformation.ADD, event.getID());
        return builder.toGameFrame();
    }

}
