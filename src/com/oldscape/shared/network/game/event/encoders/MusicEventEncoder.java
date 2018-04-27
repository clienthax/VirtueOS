package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
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
