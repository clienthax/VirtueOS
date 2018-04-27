package com.sean.game.network.ondemand;

import com.sean.shared.event.EventListener;
import com.sean.shared.network.ondemand.DropConnectionEvent;

/**
 * 
 * @author Sean
 * @author Graham
 *
 */
public final class DropConnectionEventListener implements EventListener<DropConnectionEvent, OnDemandSessionContext> {

	@Override
	public void onEvent(DropConnectionEvent event, OnDemandSessionContext context) {
		if (context.isHandshakeComplete()) {
			if (event.getValue() == 0L) {
				context.getFileQueue().clear();
			} else {
				context.getChannel().close();
			}
		}
	}
}
