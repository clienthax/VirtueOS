package com.sean.game.network.login;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPipeline;

import com.sean.game.Server;
import com.sean.game.model.player.Player;
import com.sean.game.network.SessionEventContext;
import com.sean.game.network.game.GameSessionContext;
import com.sean.shared.model.Response;
import com.sean.shared.network.login.LoginDecoder;
import com.sean.shared.network.login.LoginResponseEncoder;
import com.sean.shared.network.login.LoginResponseEvent;

/**
 * Created by sean on 17/07/14.
 */
public final class LoginSessionContext extends SessionEventContext {

	/**
	 * @see com.sean.game.network.SessionEventContext#SessionEventContext(io.netty.channel.Channel,
	 *      com.sean.game.Server)
	 */
	public LoginSessionContext(Channel channel, Server server) {
		super(channel, server);
		initialise();
	}

	/**
	 * Initialises the {@link com.sean.game.network.login.LoginSessionContext} .
	 */
	public void initialise() {
		Response response = Response.LOGIN_CONTINUE;

		ByteBuf buffer = channel.alloc().buffer(9).writeByte(response.getResponse()).writeLong((long) (Math.random() * Long.MAX_VALUE));
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
	 *            The {@link com.sean.game.model.player.Player} of the
	 *            successful login.
	 */
	public void sendLoginSuccess(Player player) throws Exception {

		ChannelPipeline pipeline = channel.pipeline();

		onGameLogin(player, pipeline);
	}

	public void onGameLogin(Player player, ChannelPipeline pipeline) {

		channel.attr(server.getGameAttributeKey()).set(new GameSessionContext(channel, server, player));

		world.registerPlayer(player);

		channel.writeAndFlush(new LoginResponseEvent((Player) player)).addListener((ChannelFutureListener) future -> {
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
