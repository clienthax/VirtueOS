package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.SkillEvent;
import io.netty.buffer.ByteBufAllocator;

public class SkillEventEncoder implements GameMessageEncoder<SkillEvent> {


    @Override
    public GameFrame encode(ByteBufAllocator alloc, SkillEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.SKILL, FrameType.FIXED);
        builder.put(DataType.INT, DataOrder.LITTLE, event.getXp());
        builder.put(DataType.BYTE, DataTransformation.NEGATE, event.getId());
        builder.put(DataType.BYTE, DataTransformation.ADD, event.getLvl());
        return builder.toGameFrame();
    }

}
