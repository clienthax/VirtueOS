package com.oldscape.shared.network.game;

import io.netty.buffer.ByteBuf;

public final class GameFrame {

	private final int opcode;
	private final FrameType type;
	private final ByteBuf payload;

	public GameFrame(int opcode, FrameType type, ByteBuf payload) {
		if (type == FrameType.RAW)
			throw new IllegalArgumentException();

		this.opcode = opcode;
		this.type = type;
		this.payload = payload;
	}

	public int getOpcode() {
		return opcode;
	}

	public FrameType getType() {
		return type;
	}

	public ByteBuf getPayload() {
		return payload;
	}

}
