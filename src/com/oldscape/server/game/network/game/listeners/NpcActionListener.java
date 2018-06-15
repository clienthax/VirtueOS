package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.npc.Npc;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.game.event.impl.NpcActionEvent;
import com.oldscape.shared.script.listeners.NpcListener;

public class NpcActionListener implements EventListener<NpcActionEvent, GameSessionContext> {

    @Override
    public void onEvent(NpcActionEvent event, GameSessionContext context) {
        Player player = context.getPlayer();

        Npc npc = player.getViewport().getLocalNpcs().get(event.getIndex() - 1);

        NpcListener listener = context.getServer().getScriptManager().forNpc(npc.getId());

        /**
         * Only add to this if impossible to create an NpcListener Script.
         */

        if (listener != null) {
            listener.handle(context.getPlayer(), npc.getId(), event.getOption());
        }

    }

}
