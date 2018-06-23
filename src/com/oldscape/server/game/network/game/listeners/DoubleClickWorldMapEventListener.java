package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.entity.player.Player;
import com.oldscape.server.game.model.entity.player.account.Permission;
import com.oldscape.server.game.model.map.Position;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.game.event.impl.DoubleClickWorldMapEvent;

public class DoubleClickWorldMapEventListener implements EventListener<DoubleClickWorldMapEvent, GameSessionContext> {
    @Override
    public void onEvent(DoubleClickWorldMapEvent event, GameSessionContext context) {
        Player player = context.getPlayer();

        /**
         * Nobody is quite sure what this function is for so for now we will use it as
         * an Administrator teleporting system.
         */
        if(player.getCredentials().getPermission() == Permission.ADMINISTRATOR) {
            player.teleport(new Position(event.getX(), event.getY(), event.getZ()));
            System.out.println(event.getX() + " " + event.getY() + " " + event.getZ());
        } else {
            /* Do nothing */
        }
    }
}
