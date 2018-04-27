package com.sean.shared.network.login;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import com.sean.game.model.player.Player;
import com.sean.shared.model.Response;

/**
 * Created by sean on 23/07/14.
 */
public final class LoginResponseEncoder extends MessageToByteEncoder<LoginResponseEvent> {

	@Override
	protected void encode(ChannelHandlerContext ctx, LoginResponseEvent msg, ByteBuf buffer) throws Exception {

		Response response = msg.getResponse();

		Player player = msg.getPlayer();

		buffer.writeByte(response.getResponse());

		if (response.equals(Response.LOGIN_OK)) {

			buffer.writeBoolean(false);

			buffer.writeByte(0);
			buffer.writeByte(0);
			buffer.writeByte(0);
			buffer.writeByte(0);

			buffer.writeByte(player.getCredentials().getPermission().ordinal());

			buffer.writeBoolean(false);

			buffer.writeShort(player.getIndex());

			buffer.writeByte(1);
		}
	}
}
