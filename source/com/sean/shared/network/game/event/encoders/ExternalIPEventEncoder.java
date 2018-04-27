package com.sean.shared.network.game.event.encoders;

import io.netty.buffer.ByteBufAllocator;

import com.sean.shared.network.game.DataOrder;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.ExternalIPEvent;

public class ExternalIPEventEncoder implements
		GameMessageEncoder<ExternalIPEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, ExternalIPEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.EXTERN_IP, FrameType.FIXED);
		builder.put(DataType.INT, DataOrder.LITTLE, event.getHash());
		return builder.toGameFrame();
	}
}
