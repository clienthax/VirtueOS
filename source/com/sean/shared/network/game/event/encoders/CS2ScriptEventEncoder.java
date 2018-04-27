package com.sean.shared.network.game.event.encoders;

import io.netty.buffer.ByteBufAllocator;

import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.CS2ScriptEvent;

public final class CS2ScriptEventEncoder implements GameMessageEncoder<CS2ScriptEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, CS2ScriptEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.CS2_SCRIPT, FrameType.VARIABLE_SHORT);
		String paramString = event.getParamsAsString();
		builder.putString(paramString);
		if (event.getParams() != null) {
			int parameter = 0;
			for (int var = event.getParams().length - 1; var >= 0; var--) {
				if (paramString.charAt(var) == 's') {
					builder.putString((String) event.getParams()[parameter++]);
				} else {
					Object param = event.getParams()[parameter++];
					if (param instanceof Integer) {
						builder.put(DataType.INT, (Integer) param);
					} else {
						builder.put(DataType.INT, Double.valueOf(param.toString()).intValue());
					}
				}
			}
		}
		builder.put(DataType.INT, event.getId());
		return builder.toGameFrame();
	}
}
