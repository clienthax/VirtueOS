package com.oldscape.server.game.network;

import com.oldscape.server.game.Server;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.server.game.network.login.LoginSessionContext;
import com.oldscape.server.game.network.ondemand.OnDemandSessionContext;
import com.oldscape.shared.event.Event;
import com.oldscape.shared.network.HandshakeEvent;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.Attribute;

/**
 * Created by sean on 16/07/14.
 */
public final class GameChannelHandler extends SimpleChannelInboundHandler<Event> {

	private final Server server;

	public GameChannelHandler(Server server) {
		this.server = server;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Event msg) throws Exception {
		Attribute<SessionEventContext> attribute = ctx.channel().attr(server.getGameAttributeKey());
		if (attribute.get() == null) {
			HandshakeEvent handshake = (HandshakeEvent) msg;
			switch (handshake.getState()) {
			case ON_DEMAND:
				attribute.set(new OnDemandSessionContext(ctx.channel(), server));
				break;

			case LOGIN:
				attribute.set(new LoginSessionContext(ctx.channel(), server));
				break;

			default:
				throw new IllegalArgumentException("No Handshake " + handshake.getState() + " supported");
			}
		} else {
			/**
			 * If the {@link io.netty.util.Attribute} is set as
			 * {@link com.oldscape.server.rs3.game.net.game.GameSessionContext} we
			 * registerLobbyPlayer the {@link com.oldscape.server.rs3.shared.event.Event}s
			 * to a queue and poll the events every 600ms, otherwise we just
			 * publish events straight away.
			 */
			if (attribute.get() instanceof GameSessionContext) {
				((GameSessionContext) attribute.get()).add(msg);
			} else {
				server.getGameEventHub().publish(msg, attribute.get());
			}
		}
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) {
		Object context = ctx.channel().attr(server.getGameAttributeKey()).get();
		if (context instanceof GameSessionContext) {
			((GameSessionContext) context).onDisconnection();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		if (!(cause.getMessage().contains("An established connection was aborted")
				|| cause.getMessage().contains("An existing connection")))
			cause.printStackTrace();

		ctx.close();
	}
}
