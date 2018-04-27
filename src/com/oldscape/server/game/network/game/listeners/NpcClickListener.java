package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.npc.Npc;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.game.event.impl.NpcActionEvent;

/**
 * 
 * @author Giovanni
 *
 */
public class NpcClickListener implements EventListener<NpcActionEvent, GameSessionContext> {

	@Override
	public void onEvent(NpcActionEvent event, GameSessionContext context) {
		System.out.println("npc clicked");
		Player player = context.getPlayer();
		// TODO: Handle the action of the npc here

		Npc npc = player.getViewport().getLocalNpcs().get(event.getIndex() - 1);
		System.out.println(npc.getId());

		if (npc.getId() == 394) {
			player.sendCS2Script(917, new Object[] { -1, -2 });// ii
			player.sendOpenInterfaceSub(548, 21, 12, false);
			player.sendOpenInterfaceSub(161, 66, 15, false);
		}

	}

}
