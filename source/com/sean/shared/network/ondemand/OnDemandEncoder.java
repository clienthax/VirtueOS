package com.sean.shared.network.ondemand;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.openrs.cache.Sector;

/**
 * 
 * @author Sean
 * @author Graham
 *
 */
public final class OnDemandEncoder extends MessageToByteEncoder<Object> {

	/**
	 * The remaining bytes after the header.
	 */
	private static final int BYTES_REMAINING_AFTER_HEADER = Sector.DATA_SIZE - 8;

	/**
	 * The remaining bytes after the block.
	 */
	private static final int BYTES_REMAINING_AFTER_BLOCK = Sector.DATA_SIZE - 1;

	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf buffer) throws Exception {
		if (msg instanceof FileResponseEvent) {
			FileResponseEvent response = (FileResponseEvent) msg;
			ByteBuf container = response.getContainer();
			int type = response.getType();
			int file = response.getFile();
			int settings = container.readUnsignedByte();
			int size = container.readInt();
			// if (!response.isPriority())
			// settings |= 0x80;

			buffer.writeByte(type);
			buffer.writeShort(file);
			buffer.writeByte(settings);
			buffer.writeInt(size);

			int bytes = container.readableBytes();
			if (bytes > BYTES_REMAINING_AFTER_HEADER)
				bytes = BYTES_REMAINING_AFTER_HEADER;

			buffer.writeBytes(container.readBytes(bytes));

			for (;;) {
				bytes = container.readableBytes();
				if (bytes == 0)
					break;
				else if (bytes > BYTES_REMAINING_AFTER_BLOCK)
					bytes = BYTES_REMAINING_AFTER_BLOCK;

				buffer.writeByte(0xFF);
				buffer.writeBytes(container.readBytes(bytes));
			}
		} else if (msg instanceof UpdateStatusMessageEvent) {
			UpdateStatusMessageEvent status = (UpdateStatusMessageEvent) msg;
			buffer.writeByte(status.getStatus());
		}
	}

}
