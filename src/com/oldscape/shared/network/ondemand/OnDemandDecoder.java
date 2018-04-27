package com.oldscape.shared.network.ondemand;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 
 * @author Sean
 * @author Graham
 *
 */
public final class OnDemandDecoder extends ByteToMessageDecoder {

	/**
	 * @author Graham
	 */
	private enum State {
		
		READ_VERSION, 
		READ_REQUEST
	}

	/**
	 * The value the decoding is currently set.
	 */
	private State state = State.READ_VERSION;

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
		if (buffer.readableBytes() < 4)
			return;
		if (state == State.READ_VERSION) {
			state = State.READ_REQUEST;
			int version = buffer.readInt();
			out.add(new ValidationMessageEvent(version));
		} else {
			int opcode = buffer.readUnsignedByte();
			if (opcode == 0 || opcode == 1) {
				int uid = buffer.readUnsignedMedium();
				out.add(new FileRequestEvent(opcode == 1, (uid >> 16), (uid & 0xFFFF)));
			} else if (opcode == 2 || opcode == 3) {
				int value = buffer.readUnsignedMedium();
				out.add(new LoginStateEvent(opcode == 2, value));
			} else if (opcode == 4) {
				int key = buffer.readUnsignedByte();
				buffer.readUnsignedShort();
				out.add(new UpdateEncryptionMessageEvent(key));
			} else if (opcode == 6) {
				int val = buffer.readUnsignedMedium();
				out.add(new InitConnectionEvent(val));
			} else if (opcode == 7) {
				int val = buffer.readUnsignedMedium();
				out.add(new DropConnectionEvent(val));
			}
		}
	}
}
