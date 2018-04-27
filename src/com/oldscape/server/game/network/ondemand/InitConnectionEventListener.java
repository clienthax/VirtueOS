package com.oldscape.server.game.network.ondemand;

import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.ondemand.InitConnectionEvent;

/**
 * 
 * @author Sean
 * @author Graham
 *
 */
public final class InitConnectionEventListener implements EventListener<InitConnectionEvent, OnDemandSessionContext> {

	@Override
	public void onEvent(InitConnectionEvent event, OnDemandSessionContext context) {
		if (context.isHandshakeComplete()) {
			if (event.getValue() != 3) {
				context.getChannel().close();
			}
		}
	}
}
