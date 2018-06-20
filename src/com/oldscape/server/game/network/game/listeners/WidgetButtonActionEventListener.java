/**
 * Copyright (c) 2015 Kyle Friz
 * <p>
 * ChatCrownType is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
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
import com.oldscape.server.game.model.widget.WidgetId;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.model.player.DisplayMode;
import com.oldscape.shared.network.game.event.impl.WidgetButtonActionEvent;
import com.oldscape.shared.script.listeners.WidgetListener;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */
public class WidgetButtonActionEventListener implements EventListener<WidgetButtonActionEvent, GameSessionContext> {

    /**
     * FIXME: The majority of this should be handles from the JS Scripting system.
     */
    @Override
    public void onEvent(WidgetButtonActionEvent event, GameSessionContext context) {
        Player player = context.getPlayer();

        WidgetListener listener = context.getServer().getScriptManager().forWidget(event.getWidgetHash());
        if (listener != null) {
            listener.handle(context.getPlayer(), event.getWidgetHash(), event.getButtonHash(), event.getWidgetID(), event.getWidgetChildID(), event.getOpcode());
        }

        if (event.getWidgetHash() == 135) {
            switch (event.getButtonHash()) {
                /* Close */
                case 13:
                    player.sendCameraReset();
                    break;
            }
        }

        /**
         * World Map Interface
         */
        if (event.getWidgetHash() == WidgetId.WORLD_MAP_GROUP_ID) {
            switch (event.getButtonHash()) {
                /* Close Map [x] */
                case WidgetId.WorldMap.CLOSE:
                    player.sendCloseWidgetSub(WidgetId.FIXED_VIEWPORT_GROUP_ID, 22);

                    break;
            }
        }

        /**
         * Sidebar: Map Panel
         */
        if (event.getWidgetHash() == WidgetId.MINIMAP_GROUP_ID) {
            switch (event.getButtonHash()) {
                /* Map Button */
                case WidgetId.WorldMap.OPTION: // TODO: is this correct?
                    player.sendCS2Script(1749, new Object[]{865789592});//c -- guessing this is coords?
                    player.sendOpenWidgetSub(WidgetId.FIXED_VIEWPORT_GROUP_ID, WidgetId.FixedViewport.GAME_VIEWPORT, WidgetId.WORLD_MAP_GROUP_ID, true);
//					player.setInterfaceClickMask(595, 17, 0, 4, 2);//FIXME: Figure out.
                    break;
            }
        }

        /**
         * Sidebar: Logout Panel
         */
        if (event.getWidgetHash() == WidgetId.LOGOUT_PANEL_ID) {
            switch (event.getButtonHash()) {
                /* Logout Button */
                case WidgetId.LogoutPanel.LOGOUT_BUTTON:
                    player.logout();
                    break;
            }
        }

        /**
         * Lobby Screen
         */
        if (event.getWidgetHash() == WidgetId.LOGIN_CLICK_TO_PLAY_GROUP_ID) {
            switch (event.getButtonHash()) {
//                case 6: // TODO: This isnt used?
                case WidgetId.ClickToPlay.CLICK_TO_PLAY_BUTTON:
                    player.sendRootWidget(player.getDisplay().getId());

                    /* TODO: This should be handled better. */
                    /* TODO: Where does 165/161 come from? */

                    // Set Gameframe RESIZE with PANELS
                    if (player.getDisplay().equals(DisplayMode.RESIZE_PANELS)) { // TODO: Correct this.
                        player.sendWidgetMoveSubEvent(165, 1, DisplayMode.RESIZE_PANELS.getId(), 21);
                        player.sendWidgetMoveSubEvent(165, 5, DisplayMode.RESIZE_PANELS.getId(), 9);
                        player.sendWidgetMoveSubEvent(165, 2, DisplayMode.RESIZE_PANELS.getId(), 3);
                        player.sendWidgetMoveSubEvent(165, 3, DisplayMode.RESIZE_PANELS.getId(), 6);
                        player.sendWidgetMoveSubEvent(165, 6, DisplayMode.RESIZE_PANELS.getId(), 54);
                        player.sendWidgetMoveSubEvent(165, 7, DisplayMode.RESIZE_PANELS.getId(), 56);
                        player.sendWidgetMoveSubEvent(165, 8, DisplayMode.RESIZE_PANELS.getId(), 57);
                        player.sendWidgetMoveSubEvent(165, 9, DisplayMode.RESIZE_PANELS.getId(), 58);
                        player.sendWidgetMoveSubEvent(165, 10, DisplayMode.RESIZE_PANELS.getId(), 59);
                        player.sendWidgetMoveSubEvent(165, 11, DisplayMode.RESIZE_PANELS.getId(), 60);
                        player.sendWidgetMoveSubEvent(165, 12, DisplayMode.RESIZE_PANELS.getId(), 61);
                        player.sendWidgetMoveSubEvent(165, 13, DisplayMode.RESIZE_PANELS.getId(), 62);
                        player.sendWidgetMoveSubEvent(165, 14, DisplayMode.RESIZE_PANELS.getId(), 63);
                        player.sendWidgetMoveSubEvent(165, 15, DisplayMode.RESIZE_PANELS.getId(), 64);
                        player.sendWidgetMoveSubEvent(165, 16, DisplayMode.RESIZE_PANELS.getId(), 65);
                        player.sendWidgetMoveSubEvent(165, 17, DisplayMode.RESIZE_PANELS.getId(), 66);
                        player.sendWidgetMoveSubEvent(165, 18, DisplayMode.RESIZE_PANELS.getId(), 67);
                        player.sendWidgetMoveSubEvent(165, 19, DisplayMode.RESIZE_PANELS.getId(), 68);
                        player.sendWidgetMoveSubEvent(165, 20, DisplayMode.RESIZE_PANELS.getId(), 69);
                        player.sendWidgetMoveSubEvent(165, 21, DisplayMode.RESIZE_PANELS.getId(), 4);
                        player.sendWidgetMoveSubEvent(165, 22, DisplayMode.RESIZE_PANELS.getId(), 8);
                        player.sendWidgetMoveSubEvent(165, 23, DisplayMode.RESIZE_PANELS.getId(), 18);
                        player.sendWidgetMoveSubEvent(165, 4, DisplayMode.RESIZE_PANELS.getId(), 7);
                        player.sendVarp(1055, 256); // TODO: What is this doing?
                        player.sendCS2Script(917, new Object[]{-1, -1}); // TODO: What is this doing?

                        // Set Gameframe RESIZE
                    } else if (player.getDisplay().equals(DisplayMode.RESIZE)) {
                        player.sendWidgetMoveSubEvent(165, 1, DisplayMode.RESIZE.getId(), 19);
                        player.sendWidgetMoveSubEvent(165, 5, DisplayMode.RESIZE.getId(), 9);
                        player.sendWidgetMoveSubEvent(165, 2, DisplayMode.RESIZE.getId(), 3);
                        player.sendWidgetMoveSubEvent(165, 3, DisplayMode.RESIZE.getId(), 6);
                        player.sendWidgetMoveSubEvent(165, 6, DisplayMode.RESIZE.getId(), 56);
                        player.sendWidgetMoveSubEvent(165, 7, DisplayMode.RESIZE.getId(), 58);
                        player.sendWidgetMoveSubEvent(165, 8, DisplayMode.RESIZE.getId(), 59);
                        player.sendWidgetMoveSubEvent(165, 9, DisplayMode.RESIZE.getId(), 60);
                        player.sendWidgetMoveSubEvent(165, 10, DisplayMode.RESIZE.getId(), 61);
                        player.sendWidgetMoveSubEvent(165, 11, DisplayMode.RESIZE.getId(), 62);
                        player.sendWidgetMoveSubEvent(165, 12, DisplayMode.RESIZE.getId(), 63);
                        player.sendWidgetMoveSubEvent(165, 13, DisplayMode.RESIZE.getId(), 64);
                        player.sendWidgetMoveSubEvent(165, 14, DisplayMode.RESIZE.getId(), 65);
                        player.sendWidgetMoveSubEvent(165, 15, DisplayMode.RESIZE.getId(), 66);
                        player.sendWidgetMoveSubEvent(165, 16, DisplayMode.RESIZE.getId(), 67);
                        player.sendWidgetMoveSubEvent(165, 17, DisplayMode.RESIZE.getId(), 68);
                        player.sendWidgetMoveSubEvent(165, 18, DisplayMode.RESIZE.getId(), 69);
                        player.sendWidgetMoveSubEvent(165, 19, DisplayMode.RESIZE.getId(), 70);
                        player.sendWidgetMoveSubEvent(165, 20, DisplayMode.RESIZE.getId(), 71);
                        player.sendWidgetMoveSubEvent(165, 21, DisplayMode.RESIZE.getId(), 4);
                        player.sendWidgetMoveSubEvent(165, 22, DisplayMode.RESIZE.getId(), 8);
                        player.sendWidgetMoveSubEvent(165, 23, DisplayMode.RESIZE.getId(), 18);
                        player.sendWidgetMoveSubEvent(165, 4, DisplayMode.RESIZE.getId(), 7);
                        player.sendVarp(1055, 0); // TODO: What is this doing?

                        // Set Gameframe FIXED
                    } else {
                        player.sendVarp(1055, 267264); // TODO: What is this doing?
                        player.sendCloseWidgetSub(165, 27);
                        player.sendWidgetMoveSubEvent(165, 1, DisplayMode.FIXED.getId(), 24);
                        player.sendWidgetMoveSubEvent(165, 6, DisplayMode.FIXED.getId(), 21);
                        player.sendWidgetMoveSubEvent(165, 2, DisplayMode.FIXED.getId(), 14);
                        player.sendWidgetMoveSubEvent(165, 3, DisplayMode.FIXED.getId(), 16);
                        player.sendWidgetMoveSubEvent(165, 4, DisplayMode.FIXED.getId(), 17);
                        player.sendWidgetMoveSubEvent(165, 5, DisplayMode.FIXED.getId(), 18);
                        player.sendWidgetMoveSubEvent(165, 7, DisplayMode.FIXED.getId(), 64);
                        player.sendWidgetMoveSubEvent(165, 8, DisplayMode.FIXED.getId(), 66);
                        player.sendWidgetMoveSubEvent(165, 9, DisplayMode.FIXED.getId(), 67);
                        player.sendWidgetMoveSubEvent(165, 10, DisplayMode.FIXED.getId(), 68);
                        player.sendWidgetMoveSubEvent(165, 11, DisplayMode.FIXED.getId(), 69);
                        player.sendWidgetMoveSubEvent(165, 12, DisplayMode.FIXED.getId(), 70);
                        player.sendWidgetMoveSubEvent(165, 13, DisplayMode.FIXED.getId(), 71);
                        player.sendWidgetMoveSubEvent(165, 14, DisplayMode.FIXED.getId(), 72);
                        player.sendWidgetMoveSubEvent(165, 15, DisplayMode.FIXED.getId(), 73);
                        player.sendWidgetMoveSubEvent(165, 16, DisplayMode.FIXED.getId(), 74);
                        player.sendWidgetMoveSubEvent(165, 17, DisplayMode.FIXED.getId(), 75);
                        player.sendWidgetMoveSubEvent(165, 18, DisplayMode.FIXED.getId(), 76);
                        player.sendWidgetMoveSubEvent(165, 19, DisplayMode.FIXED.getId(), 77);
                        player.sendWidgetMoveSubEvent(165, 20, DisplayMode.FIXED.getId(), 78);
                        player.sendWidgetMoveSubEvent(165, 21, DisplayMode.FIXED.getId(), 79);
                        player.sendWidgetMoveSubEvent(165, 22, DisplayMode.FIXED.getId(), 15);
                        player.sendWidgetMoveSubEvent(165, 23, DisplayMode.FIXED.getId(), 19);
                        player.sendWidgetMoveSubEvent(165, 24, DisplayMode.FIXED.getId(), 11);
                        player.sendWidgetMoveSubEvent(165, 28, DisplayMode.FIXED.getId(), 22);
                    }
                    //TODO: Set Now Playing Track - This should be loaded by region player is in.
                    player.sendWidgetText(WidgetId.MUSIC_PANEL_ID, 5, "Harmony"); // TODO: is child 5?

                    player.setInGame(true);
                    break;
            }
        }
    }

}
