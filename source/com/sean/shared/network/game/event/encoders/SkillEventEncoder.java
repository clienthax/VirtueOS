package com.sean.shared.network.game.event.encoders;

import io.netty.buffer.ByteBufAllocator;

import com.sean.shared.network.game.DataOrder;
import com.sean.shared.network.game.DataTransformation;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.SkillEvent;

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
