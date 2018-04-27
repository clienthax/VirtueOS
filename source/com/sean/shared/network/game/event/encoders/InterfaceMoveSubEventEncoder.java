package com.sean.shared.network.game.event.encoders;

import com.sean.shared.network.game.DataOrder;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.InterfaceMoveSubEvent;

import io.netty.buffer.ByteBufAllocator;

public class InterfaceMoveSubEventEncoder implements
		GameMessageEncoder<InterfaceMoveSubEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, InterfaceMoveSubEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_MOVE_SUB, FrameType.FIXED);

		builder.put(DataType.INT, DataOrder.MIDDLE, (event.getToRoot() << 16 | event.getToChild()));
		builder.put(DataType.INT, DataOrder.INVERSED_MIDDLE, (event.getFromRoot() << 16 | event.getFromChild()));

		System.out.println(String.format("setInterfaceMoveSub(%d, %d, %d, %d)", event.getToRoot(), event.getToChild(), event.getFromRoot(), event.getFromChild()));

		return builder.toGameFrame();
	}
}
