package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.CameraResetEvent;
import io.netty.buffer.ByteBufAllocator;

public class CameraResetEventEncoder implements GameMessageEncoder<CameraResetEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, CameraResetEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.CAMERA_RESET, FrameType.FIXED);

        return builder.toGameFrame();
    }

}
