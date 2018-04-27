package com.sean.shared.network.game.event.encoders;

import io.netty.buffer.ByteBufAllocator;

import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.InterfaceSetTextEvent;

/**
 * 
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 24, 2015
 */
public class InterfaceSetTextEventEncoder implements GameMessageEncoder<InterfaceSetTextEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, InterfaceSetTextEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_SET_TEXT, FrameType.VARIABLE_SHORT);
		builder.putString(event.getMessage());
		builder.put(DataType.INT, event.getRoot() << 16 | event.getChild());
		return builder.toGameFrame();
	}
}
