package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.npc.Npc;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.model.player.inv.ContainerConstants;
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

		Npc npc = player.getViewport().getLocalNpcs().get(event.getIndex() -1);
		System.out.println(npc.getId());

		if(npc.getId() == 394) {
			player.sendOpenInterfaceSub(548, 21, 12, false);

			player.sendVarp(115, 0);
					//player.sendItems(ContainerConstants.BANK_ID, 95, player.getBank().getItems());
			//player.sendItems(ContainerConstants.INVENTORY_CHANNEL, 93, player.getInventory().getItems());
					//setItemContainer(player.getLootingBag().getItems(), 516).
							/*player.sendInterfaceSetClickMask(0, 815, 1312766, 786455);//bankOptions
					player.sendInterfaceSetClickMask(825, 833, 2, 786455);
					player.sendInterfaceSetClickMask(834, 843, 1048576, 786455);
					player.sendInterfaceSetClickMask(10, 10, 1048706, 786453);
					player.sendInterfaceSetClickMask(11, 19, 1179842, 786453);
					player.sendInterfaceSetClickMask(0, 27, 1181438, 983043);//interfaceOptions
					player.sendInterfaceSetClickMask(0, 27, 1054, 983050);
					player.sendInterfaceSetClickMask(1, 816, 2, 786478);
					player.sendInterfaceSetClickMask(0, 3, 2, 786481);
					player.sendCS2Script(917, -2, -1);*/
					player.sendOpenInterfaceSub(161, 66, 15, false);
					player.sendCS2Script(1495, 786487, 786450, "Non-members' capacity: 400<br>+8 for your PIN<br>+8 for your Authenticator");


			player.sendSetInterfaceText(12, 18, ContainerConstants.BANK_CAPACITY+"");

			int[] tabItems = player.getBankTabItems();

			int varpOne = 0;
			int varpTwo = 0;
			int varpThree = 0;

			varpOne += tabItems[0];
			varpOne += tabItems[1]<<10;
			varpOne += tabItems[2]<<20;

			varpTwo += tabItems[3];
			varpTwo += tabItems[4]<<10;
			varpTwo += tabItems[5]<<20;
			varpTwo += tabItems[6]<<30;

			varpThree += tabItems[7];
			varpThree += tabItems[8]<<10;
			varpThree += tabItems[9]<<20;

			if(false)
			{
				varpTwo += 1 << 30;//if placeholders are enabled
			}

			player.sendVarp(867, varpOne);
			player.sendVarp(867, varpOne);
			player.sendVarp(867, varpOne);

			player.sendVarp(1052, varpTwo);
			player.sendVarp(1052, varpTwo);
			player.sendVarp(1052, varpTwo);

			player.sendVarp(1053, varpThree);
			player.sendVarp(1053, varpThree);
			player.sendVarp(1053, varpThree);

		}


	}

}
