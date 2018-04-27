package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.InterfaceCloseSubEvent;

import io.netty.buffer.ByteBufAllocator;

public class InterfaceCloseSubEventEncoder implements
		GameMessageEncoder<InterfaceCloseSubEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, InterfaceCloseSubEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_CLOSE_SUB, FrameType.FIXED);
		builder.put(DataType.INT, (event.getRoot() << 16 | event.getChild()));

		System.out.println(String.format("setInterfaceCloseSub(%d, %d)", event.getRoot(), event.getChild()));

		return builder.toGameFrame();
	}
}
