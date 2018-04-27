package com.sean.game.network.game.listeners;

import com.sean.game.model.npc.Npc;
import com.sean.game.model.player.Player;
import com.sean.game.network.game.GameSessionContext;
import com.sean.shared.event.EventListener;
import com.sean.shared.model.Position;
import com.sean.shared.network.game.event.impl.NpcActionEvent;
import com.sean.shared.network.game.event.impl.ObjectClickEvent;

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

		Npc npc = player.getViewport().getLocalNpcs().get(event.getIndex() -1);
		System.out.println(npc.getId());

		if(npc.getId() == 394) {
			player.sendCS2Script(917, new Object[]{-1, -2});//ii
			player.sendOpenInterfaceSub(548, 21, 12, false);
			player.sendOpenInterfaceSub(161, 66, 15, false);
		}


	}

}
