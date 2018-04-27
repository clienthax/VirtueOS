package com.sean.game.network.ondemand;

import io.netty.channel.Channel;

import com.sean.shared.event.EventListener;
import com.sean.shared.network.ondemand.UpdateEncryptionMessageEvent;
import com.sean.shared.network.ondemand.XorEncoder;

/**
 * 
 * @author Sean
 * @author Graham
 *
 */
public class EncryptionMessageEventListener
		implements EventListener<UpdateEncryptionMessageEvent, OnDemandSessionContext> {

	@Override
	public void onEvent(UpdateEncryptionMessageEvent event, OnDemandSessionContext context) {
		if (context.isHandshakeComplete()) {
			Channel channel = context.getChannel();
			XorEncoder encoder = channel.pipeline().get(XorEncoder.class);
			encoder.setKey(event.getKey());
		}
	}
}
