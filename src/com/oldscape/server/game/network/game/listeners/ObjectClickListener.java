package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.model.Position;
import com.oldscape.shared.network.game.event.impl.ObjectClickEvent;

/**
 * 
 * @author Giovanni
 *
 */
public class ObjectClickListener implements EventListener<ObjectClickEvent, GameSessionContext> {

	@Override
	public void onEvent(ObjectClickEvent event, GameSessionContext context) {
		System.out.println("object clicked");
		Player player = context.getPlayer();
		player.getWalkingQueue()
				.addStep(new Position((event.getX()), (event.getY()), player.getPosition().getHeight()));
		// TODO: Handle the action of the object here

	}

}
