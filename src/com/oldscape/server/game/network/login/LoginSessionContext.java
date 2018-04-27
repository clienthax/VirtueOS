package com.oldscape.server.game.network.login;

import com.oldscape.server.game.Server;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.network.SessionEventContext;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.model.Response;
import com.oldscape.shared.network.login.LoginDecoder;
import com.oldscape.shared.network.login.LoginResponseEncoder;
import com.oldscape.shared.network.login.LoginResponseEvent;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPipeline;

/**
 * Created by sean on 17/07/14.
 */
public final class LoginSessionContext extends SessionEventContext {

	/**
	 * @see com.oldscape.server.game.network.SessionEventContext#SessionEventContext(io.netty.channel.Channel,
	 *      com.oldscape.server.game.Server)
	 */
	public LoginSessionContext(Channel channel, Server server) {
		super(channel, server);
		initialise();
	}

	/**
	 * Initialises the
	 * {@link com.oldscape.server.game.network.login.LoginSessionContext} .
	 */
	public void initialise() {
		Response response = Response.LOGIN_CONTINUE;

		ByteBuf buffer = channel.alloc().buffer(9).writeByte(response.getResponse())
				.writeLong((long) (Math.random() * Long.MAX_VALUE));
		ChannelFuture future = channel.writeAndFlush(buffer, channel.voidPromise()); // ok try now
		if (response != Response.LOGIN_CONTINUE) {
			future.addListener(ChannelFutureListener.CLOSE);
		}
	}

	/**
	 * Sends the status of a failed logging in to the client.
	 * 
	 * @param response
	 *            The response of why the login failed.
	 */
	public void sendLoginFailure(Response response) {
		write(new LoginResponseEvent(response)).addListener(ChannelFutureListener.CLOSE);
	}

	/**
	 * Sends the details of a successful login in.
	 * 
	 * @param player
	 *            The {@link com.oldscape.server.game.model.player.Player} of the
	 *            successful login.
	 */
	public void sendLoginSuccess(Player player) throws Exception {

		ChannelPipeline pipeline = channel.pipeline();

		onGameLogin(player, pipeline);
	}

	public void onGameLogin(Player player, ChannelPipeline pipeline) {

		channel.attr(server.getGameAttributeKey()).set(new GameSessionContext(channel, server, player));

		world.registerPlayer(player);

		channel.writeAndFlush(new LoginResponseEvent(player)).addListener((ChannelFutureListener) future -> {
			if (future.isSuccess()) {

				pipeline.remove(LoginDecoder.class.getName());
				pipeline.remove(LoginResponseEncoder.class);

				player.initGameFrameCodec();
				player.initialize();
				player.onLogin();
			}
		});
	}
}
