package com.oldscape.server.game.network.ondemand;

import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.ondemand.LoginStateEvent;

/**
 * @author Sean
 * @author Graham
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
