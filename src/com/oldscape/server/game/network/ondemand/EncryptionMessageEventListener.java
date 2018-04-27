package com.oldscape.server.game.network.ondemand;

import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.ondemand.UpdateEncryptionMessageEvent;
import com.oldscape.shared.network.ondemand.XorEncoder;

import io.netty.channel.Channel;

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
