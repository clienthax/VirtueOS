package com.oldscape.server.game.network.login;

import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.login.LoginResponseEvent;

/**
 * Created by Sean on 08/08/2014.
 */
public final class LoginResponseEventListener implements EventListener<LoginResponseEvent, LoginSessionContext> {

	@Override
	public void onEvent(LoginResponseEvent event, LoginSessionContext context) {
		context.sendLoginFailure(event.getResponse());
	}
}
