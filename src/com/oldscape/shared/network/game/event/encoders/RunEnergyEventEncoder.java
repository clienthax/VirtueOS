package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.RunEnergyEvent;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author Tom
 */
public class RunEnergyEventEncoder implements GameMessageEncoder<RunEnergyEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, RunEnergyEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.RUN_ENERGY, FrameType.FIXED);
        builder.put(DataType.BYTE, event.getAmount());
        return builder.toGameFrame();
    }

}
