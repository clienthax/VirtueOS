/**
 * Copyright (c) 2015 Kyle Friz
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.model.player.DisplayMode;
import com.oldscape.shared.network.game.event.impl.ButtonClickEvent;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */
public class ButtonClickEventListener implements EventListener<ButtonClickEvent, GameSessionContext> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oldscape.shared.event.EventListener#onEvent(com.oldscape.shared.event.Event,
	 * com.oldscape.shared.event.EventContext)
	 */
	@Override
	public void onEvent(ButtonClickEvent event, GameSessionContext context) {
		Player player = context.getPlayer();
		 System.out.println("buttonclickevent "+event.getInterfaceID() + ", " +
		 event.getButtonID());

		 if(event.getInterfaceID() == 595) {//worldmap
		 	switch (event.getButtonID()) {
				case 34://close map X
					player.sendCloseInterfaceSub(548, 22);
					break;
			}
		 }

		 if(event.getInterfaceID() == 160) {//minimap panel
		 	switch (event.getButtonID()) {
				case 36://Map button
					player.sendCS2Script(1749, new Object[]{865789592});//c -- guessing this is coords?
					player.sendOpenInterfaceSub(548, 22, 595, true);
//					player.setInterfaceClickMask(595, 17, 0, 4, 2);//TODO
					break;
			}
		 }

		 if(event.getInterfaceID() == 182) {//Settings tab
		 	switch (event.getButtonID()) {
				case 8://Logout button
					player.logout();
					break;
			}
		 }

		if (event.getInterfaceID() == 378 && (event.getButtonID() == 6 || event.getButtonID() == 75)) {//Click here to play
			player.sendSetRootInterface(player.getDisplay().getId());
			if (player.getDisplay().equals(DisplayMode.RESIZE_PANELS)) {//todo
				player.sendSetInterfaceMoveSubEvent(165, 1, 164, 21);
				player.sendSetInterfaceMoveSubEvent(165, 5, 164, 9);
				player.sendSetInterfaceMoveSubEvent(165, 2, 164, 3);
				player.sendSetInterfaceMoveSubEvent(165, 3, 164, 6);
				player.sendSetInterfaceMoveSubEvent(165, 6, 164, 54);
				player.sendSetInterfaceMoveSubEvent(165, 7, 164, 56);
				player.sendSetInterfaceMoveSubEvent(165, 8, 164, 57);
				player.sendSetInterfaceMoveSubEvent(165, 9, 164, 58);
				player.sendSetInterfaceMoveSubEvent(165, 10, 164, 59);
				player.sendSetInterfaceMoveSubEvent(165, 11, 164, 60);
				player.sendSetInterfaceMoveSubEvent(165, 12, 164, 61);
				player.sendSetInterfaceMoveSubEvent(165, 13, 164, 62);
				player.sendSetInterfaceMoveSubEvent(165, 14, 164, 63);
				player.sendSetInterfaceMoveSubEvent(165, 15, 164, 64);
				player.sendSetInterfaceMoveSubEvent(165, 16, 164, 65);
				player.sendSetInterfaceMoveSubEvent(165, 17, 164, 66);
				player.sendSetInterfaceMoveSubEvent(165, 18, 164, 67);
				player.sendSetInterfaceMoveSubEvent(165, 19, 164, 68);
				player.sendSetInterfaceMoveSubEvent(165, 20, 164, 69);
				player.sendSetInterfaceMoveSubEvent(165, 21, 164, 4);
				player.sendSetInterfaceMoveSubEvent(165, 22, 164, 8);
				player.sendSetInterfaceMoveSubEvent(165, 23, 164, 18);
				player.sendSetInterfaceMoveSubEvent(165, 4, 164, 7);
				player.sendVarp(1055, 256);
				player.sendCS2Script(917, new Object[] { -1, -1 });
			} else if (player.getDisplay().equals(DisplayMode.RESIZE)) {// RESIZE
				player.sendSetInterfaceMoveSubEvent(165, 1, 161, 19);
				player.sendSetInterfaceMoveSubEvent(165, 5, 161, 9);
				player.sendSetInterfaceMoveSubEvent(165, 2, 161, 3);
				player.sendSetInterfaceMoveSubEvent(165, 3, 161, 6);
				player.sendSetInterfaceMoveSubEvent(165, 6, 161, 56);
				player.sendSetInterfaceMoveSubEvent(165, 7, 161, 58);
				player.sendSetInterfaceMoveSubEvent(165, 8, 161, 59);
				player.sendSetInterfaceMoveSubEvent(165, 9, 161, 60);
				player.sendSetInterfaceMoveSubEvent(165, 10, 161, 61);
				player.sendSetInterfaceMoveSubEvent(165, 11, 161, 62);
				player.sendSetInterfaceMoveSubEvent(165, 12, 161, 63);
				player.sendSetInterfaceMoveSubEvent(165, 13, 161, 64);
				player.sendSetInterfaceMoveSubEvent(165, 14, 161, 65);
				player.sendSetInterfaceMoveSubEvent(165, 15, 161, 66);
				player.sendSetInterfaceMoveSubEvent(165, 16, 161, 67);
				player.sendSetInterfaceMoveSubEvent(165, 17, 161, 68);
				player.sendSetInterfaceMoveSubEvent(165, 18, 161, 69);
				player.sendSetInterfaceMoveSubEvent(165, 19, 161, 70);
				player.sendSetInterfaceMoveSubEvent(165, 20, 161, 71);
				player.sendSetInterfaceMoveSubEvent(165, 21, 161, 4);
				player.sendSetInterfaceMoveSubEvent(165, 22, 161, 8);
				player.sendSetInterfaceMoveSubEvent(165, 23, 161, 18);
				player.sendSetInterfaceMoveSubEvent(165, 4, 161, 7);
				player.sendVarp(1055, 0);
			} else {
				player.sendVarp(1055, 267264);
				player.sendCloseInterfaceSub(165, 27);

				player.sendSetInterfaceMoveSubEvent(165, 1, 548, 24);
				player.sendSetInterfaceMoveSubEvent(165, 6, 548, 21);
				player.sendSetInterfaceMoveSubEvent(165, 2, 548, 14);
				player.sendSetInterfaceMoveSubEvent(165, 3, 548, 16);
				player.sendSetInterfaceMoveSubEvent(165, 7, 548, 64);
				player.sendSetInterfaceMoveSubEvent(165, 8, 548, 66);
				player.sendSetInterfaceMoveSubEvent(165, 9, 548, 67);
				player.sendSetInterfaceMoveSubEvent(165, 10, 548, 68);
				player.sendSetInterfaceMoveSubEvent(165, 11, 548, 69);
				player.sendSetInterfaceMoveSubEvent(165, 12, 548, 70);
				player.sendSetInterfaceMoveSubEvent(165, 13, 548, 71);
				player.sendSetInterfaceMoveSubEvent(165, 14, 548, 72);
				player.sendSetInterfaceMoveSubEvent(165, 15, 548, 73);
				player.sendSetInterfaceMoveSubEvent(165, 16, 548, 74);
				player.sendSetInterfaceMoveSubEvent(165, 17, 548, 75);
				player.sendSetInterfaceMoveSubEvent(165, 18, 548, 76);
				player.sendSetInterfaceMoveSubEvent(165, 19, 548, 77);
				player.sendSetInterfaceMoveSubEvent(165, 20, 548, 78);
				player.sendSetInterfaceMoveSubEvent(165, 21, 548, 79);
				player.sendSetInterfaceMoveSubEvent(165, 22, 548, 15);
				player.sendSetInterfaceMoveSubEvent(165, 23, 548, 19);
				player.sendSetInterfaceMoveSubEvent(165, 24, 548, 11);
				player.sendSetInterfaceMoveSubEvent(165, 4, 548, 17);
				player.sendSetInterfaceMoveSubEvent(165, 5, 548, 18);
				player.sendSetInterfaceMoveSubEvent(165, 28, 548, 22);

			}
			player.sendSetInterfaceText(239, 5, "Harmony");
			player.setInGame(true);
		}
	}

}
