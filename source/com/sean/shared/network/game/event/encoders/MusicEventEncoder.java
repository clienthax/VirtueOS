package com.sean.shared.network.game.event.encoders;

import com.sean.shared.network.game.DataTransformation;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.MusicEvent;

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
