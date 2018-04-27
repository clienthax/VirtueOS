package com.sean.game.network.ondemand;

import com.sean.shared.event.EventListener;
import com.sean.shared.network.ondemand.LoginStateEvent;

/**
 * 
 * @author Sean
 * @author Graham
 *
 */
public final class LoginStateEventListener implements EventListener<LoginStateEvent, OnDemandSessionContext> {

	@Override
	public void onEvent(LoginStateEvent event, OnDemandSessionContext context) {
		if (context.isHandshakeComplete()) {
			if (event.getValue() != 0L) {
				context.getChannel().close();
			}
		}
	}
}
