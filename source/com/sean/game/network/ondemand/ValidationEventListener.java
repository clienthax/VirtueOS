package com.sean.game.network.ondemand;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

import com.sean.shared.event.EventListener;
import com.sean.shared.network.ondemand.UpdateStatusMessageEvent;
import com.sean.shared.network.ondemand.ValidationMessageEvent;

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
		if ((validation.getVersion() == context.getServer().getContext().getMajor() )) {//TODO read from config
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
