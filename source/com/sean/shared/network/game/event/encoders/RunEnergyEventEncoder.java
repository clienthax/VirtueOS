package com.sean.shared.network.game.event.encoders;

import io.netty.buffer.ByteBufAllocator;

import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.RunEnergyEvent;

/**
 * @author Tom
 *
 */
public class RunEnergyEventEncoder implements GameMessageEncoder<RunEnergyEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, RunEnergyEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.RUN_ENERGY, FrameType.FIXED);
		builder.put(DataType.BYTE, event.getAmount());
		return builder.toGameFrame();
	}
	
}
