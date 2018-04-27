package com.sean.game.network.login;

import com.sean.shared.event.EventListener;
import com.sean.shared.network.login.LoginResponseEvent;

/**
 * Created by Sean on 08/08/2014.
 */
public final class LoginResponseEventListener implements EventListener<LoginResponseEvent, LoginSessionContext> {

	@Override
	public void onEvent(LoginResponseEvent event, LoginSessionContext context) {
		context.sendLoginFailure(event.getResponse());
	}
}
