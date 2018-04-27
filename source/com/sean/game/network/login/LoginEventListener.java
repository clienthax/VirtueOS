package com.sean.game.network.login;

import com.sean.shared.event.EventListener;
import com.sean.shared.model.Response;
import com.sean.shared.network.login.LoginEvent;
//import com.sean.rs3.shared.db.DatabaseTransaction;
//import com.sean.rs3.game.db.GameAccountTransaction;
//import com.sean.rs3.game.db.LobbyAccountTransaction;

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

		if (!event.getToken().equals("p1cxIGuofoL*Cxh6XInci7jdO6eoWyjw4JDOroxQCWofrlANnxj8Eg")) {//TODO load from config
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
