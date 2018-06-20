package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.CameraRepositionEvent;
import io.netty.buffer.ByteBufAllocator;

public class CameraRepositionEventEncoder implements GameMessageEncoder<CameraRepositionEvent> {


    @Override
    public GameFrame encode(ByteBufAllocator alloc, CameraRepositionEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.CAMERA_REPOSITION, FrameType.FIXED);

        // TODO: This needs to be properly figured out before added anywhere else, currently only used in Signpost_18493.js
        builder.put(DataType.BYTE, event.getX());
        builder.put(DataType.BYTE, event.getPitch());
        builder.put(DataType.SHORT, event.getY());
        builder.put(DataType.BYTE, event.getZ());
        builder.put(DataType.BYTE, event.getYaw());

        System.out.println("cameraRepositionEvent: " + event.getX() + " " + event.getY() + " " + event.getZ() + " " + event.getPitch() + " " + event.getYaw());
        return builder.toGameFrame();
    }
}
