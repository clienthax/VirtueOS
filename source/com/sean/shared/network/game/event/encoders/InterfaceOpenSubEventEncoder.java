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
import com.sean.shared.network.game.event.impl.InterfaceOpenSubEvent;

/**
 * @author Tom
 *
 */
public class InterfaceOpenSubEventEncoder implements
		GameMessageEncoder<InterfaceOpenSubEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, InterfaceOpenSubEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_OPEN_SUB, FrameType.FIXED);

		builder.put(DataType.INT, DataOrder.MIDDLE, event.getRootInterfaceId() << 16 | event.getChildId());
		builder.put(DataType.BYTE, DataTransformation.SUBTRACT, event.isClickable() ? 1 : 0);
		builder.put(DataType.SHORT, DataOrder.LITTLE, event.getInterfaceId());

//		System.out.println(""+(event.getRootInterfaceId() << 16 | event.getChildId()));

		System.out.println(String.format("setInterfaceOpenSub(%d, %d, %d, %b)", event.getRootInterfaceId(), event.getChildId(), event.getInterfaceId(), event.isClickable()));


		return builder.toGameFrame();
	}
}
