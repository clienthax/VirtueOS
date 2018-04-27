package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
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
