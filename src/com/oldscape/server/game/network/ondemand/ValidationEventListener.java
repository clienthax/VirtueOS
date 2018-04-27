package com.oldscape.server.game.network.ondemand;

import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.ondemand.UpdateStatusMessageEvent;
import com.oldscape.shared.network.ondemand.ValidationMessageEvent;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

/**
 * 
 * @author Sean
 * @author Graham
 *
 */
public final class ValidationEventListener implements EventListener<ValidationMessageEvent, OnDemandSessionContext> {

	@Override
	public void onEvent(ValidationMessageEvent validation, OnDemandSessionContext context) {

		int status;
		if ((validation.getVersion() == context.getServer().getContext().getMajor())) {
			status = UpdateStatusMessageEvent.STATUS_OK;
		} else {
			status = UpdateStatusMessageEvent.STATUS_OUT_OF_DATE;
		}

		Channel channel = context.getChannel();
		ChannelFuture future = channel.writeAndFlush(new UpdateStatusMessageEvent(status));
		if (status == UpdateStatusMessageEvent.STATUS_OK) {
			context.setHandshakeComplete(true);
		} else {
			future.addListener(ChannelFutureListener.CLOSE);
		}
	}

}
