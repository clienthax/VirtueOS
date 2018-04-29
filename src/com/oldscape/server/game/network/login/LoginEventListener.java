package com.oldscape.server.game.network.login;

import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.model.Response;
import com.oldscape.shared.network.login.LoginEvent;

/**
 * Created by sean on 17/07/14.
 */
public final class LoginEventListener implements EventListener<LoginEvent, LoginSessionContext> {

	@Override
	public void onEvent(LoginEvent event, LoginSessionContext context) {

		if (event.getMajor() != context.getServer().getContext().getMajor()) {//TODO load from config
			context.sendLoginFailure(Response.SERVER_UPDATED);
			System.out.println("Wrong client version");
		}

		if (!event.getToken().equals("ElZAIrq5NpKN6D3mDdihco3oPeYN2KFy2DCquj7JMmECPmLrDP3Bnw")) {//TODO load from config
			context.sendLoginFailure(Response.SERVER_UPDATED);
			System.out.println("Wrong client token");
		}

		for (int index = 1; index < event.getCrcValues().length; index++) {

			if (context.getServer().getChecksumTable().getEntry(index - 1).getCrc() != event.getCrcValues()[index]) {
				//TODO this doesn't seem right, we should be sending this to the client right?
				context.sendLoginFailure(Response.SERVER_UPDATED);
				System.out.println("Invalid crcs");
				return;
			}
		}

		context.getServer().getLoadService().addLoginTransaction(new LoginTransaction(event, context));

	}

}
