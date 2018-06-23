package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.entity.player.Player;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.server.game.model.map.Position;
import com.oldscape.shared.network.game.event.impl.ObjectActionEvent;
import com.oldscape.shared.script.listeners.ObjectListener;

/**
 * @author Giovanni
 */
public class ObjectActionListener implements EventListener<ObjectActionEvent, GameSessionContext> {

    @Override
    public void onEvent(ObjectActionEvent event, GameSessionContext context) {
        Player player = context.getPlayer();
        Position objectPosition = new Position((event.getX()), (event.getY()), player.getPosition().getZ());

        player.getWalkingQueue().addStep(objectPosition);

        while(!player.getPosition().withinDistance(objectPosition, 1)) {
            ObjectListener listener = context.getServer().getScriptManager().forObject(event.getObject());
            if (listener != null) {
                listener.handle(context.getPlayer(), event.getActionSlot(), event.getObject(), event.getType(), event.getX(), event.getY());
            }
        }
    }

}
