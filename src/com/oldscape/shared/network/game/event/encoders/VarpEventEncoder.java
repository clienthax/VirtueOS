package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.VarpEvent;

import io.netty.buffer.ByteBufAllocator;

public class VarpEventEncoder implements GameMessageEncoder<VarpEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, VarpEvent event) {
		GameFrameBuilder builder = null;

		if (event.isBit()) {
			//TODO ?
		} else {
			if (event.getState() <= Byte.MIN_VALUE
					|| event.getState() >= Byte.MAX_VALUE) {
				builder = new GameFrameBuilder(alloc, EncoderOpcode.VARP_LARGE, FrameType.FIXED);
				builder.put(DataType.INT, event.getState());
				builder.put(DataType.SHORT, event.getId());
//				System.out.println("varp large: id "+event.getId()+" state "+event.getState());

			} else {
				builder = new GameFrameBuilder(alloc, EncoderOpcode.VARP_SMALL, FrameType.FIXED);
				builder.put(DataType.SHORT, DataTransformation.ADD, event.getId());
				builder.put(DataType.BYTE, event.getState());

//				System.out.println("varp small: id "+event.getId()+" state "+event.getState());
			}
		}
		return builder.toGameFrame();
	}
}
