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
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.model.player.DisplayMode;
import com.oldscape.shared.network.game.event.impl.ClientDimensionsEvent;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */
public class ClientDimensionsEventListener implements EventListener<ClientDimensionsEvent, GameSessionContext> {

    @Override
    public void onEvent(ClientDimensionsEvent event, GameSessionContext context) {
        Player player = context.getPlayer();
        if (player.isInGame()) {
            if (event.isResizeable()) {
                if (player.getDisplay().equals(DisplayMode.FIXED)) {
                    if (player.isSidePanels()) {
                        player.setDisplay(DisplayMode.RESIZE_PANELS);
                        player.sendSetRootWidget(player.getDisplay().getId());
                        player.sendSetWidgetMoveSubEvent(548, 20, 164, 21);
                        player.sendSetWidgetMoveSubEvent(548, 18, 164, 9);
                        player.sendSetWidgetMoveSubEvent(548, 12, 164, 3);
                        player.sendSetWidgetMoveSubEvent(548, 14, 164, 6);
                        player.sendSetWidgetMoveSubEvent(548, 60, 164, 54);
                        player.sendSetWidgetMoveSubEvent(548, 62, 164, 56);
                        player.sendSetWidgetMoveSubEvent(548, 63, 164, 57);
                        player.sendSetWidgetMoveSubEvent(548, 64, 164, 58);
                        player.sendSetWidgetMoveSubEvent(548, 65, 164, 59);
                        player.sendSetWidgetMoveSubEvent(548, 66, 164, 60);
                        player.sendSetWidgetMoveSubEvent(548, 67, 164, 61);
                        player.sendSetWidgetMoveSubEvent(548, 68, 164, 62);
                        player.sendSetWidgetMoveSubEvent(548, 69, 164, 63);
                        player.sendSetWidgetMoveSubEvent(548, 70, 164, 64);
                        player.sendSetWidgetMoveSubEvent(548, 71, 164, 65);
                        player.sendSetWidgetMoveSubEvent(548, 72, 164, 66);
                        player.sendSetWidgetMoveSubEvent(548, 73, 164, 67);
                        player.sendSetWidgetMoveSubEvent(548, 74, 164, 68);
                        player.sendSetWidgetMoveSubEvent(548, 75, 164, 69);
                        player.sendSetWidgetMoveSubEvent(548, 13, 164, 4);
                        player.sendSetWidgetMoveSubEvent(548, 16, 164, 8);
                        player.sendSetWidgetMoveSubEvent(548, 9, 164, 18);
                        player.sendSetWidgetMoveSubEvent(548, 15, 164, 7);
                    } else {
                        player.setDisplay(DisplayMode.RESIZE);
                        player.sendSetRootWidget(player.getDisplay().getId());
                        player.sendSetWidgetMoveSubEvent(548, 20, 161, 19);
                        player.sendSetWidgetMoveSubEvent(548, 18, 161, 9);
                        player.sendSetWidgetMoveSubEvent(548, 12, 161, 3);
                        player.sendSetWidgetMoveSubEvent(548, 14, 161, 6);
                        player.sendSetWidgetMoveSubEvent(548, 60, 161, 56);
                        player.sendSetWidgetMoveSubEvent(548, 62, 161, 58);
                        player.sendSetWidgetMoveSubEvent(548, 63, 161, 59);
                        player.sendSetWidgetMoveSubEvent(548, 64, 161, 60);
                        player.sendSetWidgetMoveSubEvent(548, 65, 161, 61);
                        player.sendSetWidgetMoveSubEvent(548, 66, 161, 62);
                        player.sendSetWidgetMoveSubEvent(548, 67, 161, 63);
                        player.sendSetWidgetMoveSubEvent(548, 68, 161, 64);
                        player.sendSetWidgetMoveSubEvent(548, 69, 161, 65);
                        player.sendSetWidgetMoveSubEvent(548, 70, 161, 66);
                        player.sendSetWidgetMoveSubEvent(548, 71, 161, 67);
                        player.sendSetWidgetMoveSubEvent(548, 72, 161, 68);
                        player.sendSetWidgetMoveSubEvent(548, 73, 161, 69);
                        player.sendSetWidgetMoveSubEvent(548, 74, 161, 70);
                        player.sendSetWidgetMoveSubEvent(548, 75, 161, 71);
                        player.sendSetWidgetMoveSubEvent(548, 13, 161, 4);
                        player.sendSetWidgetMoveSubEvent(548, 16, 161, 8);
                        player.sendSetWidgetMoveSubEvent(548, 9, 161, 18);
                        player.sendSetWidgetMoveSubEvent(548, 15, 161, 7);
                    }
                } else if (player.getDisplay().equals(DisplayMode.RESIZE)) {
                    player.setDisplay(DisplayMode.RESIZE_PANELS);
                    player.sendSetRootWidget(player.getDisplay().getId());
                    player.sendSetWidgetMoveSubEvent(161, 19, 164, 21);
                    player.sendSetWidgetMoveSubEvent(161, 9, 164, 9);
                    player.sendSetWidgetMoveSubEvent(161, 3, 164, 3);
                    player.sendSetWidgetMoveSubEvent(161, 6, 164, 6);
                    player.sendSetWidgetMoveSubEvent(161, 56, 164, 54);
                    player.sendSetWidgetMoveSubEvent(161, 58, 164, 56);
                    player.sendSetWidgetMoveSubEvent(161, 59, 164, 57);
                    player.sendSetWidgetMoveSubEvent(161, 60, 164, 58);
                    player.sendSetWidgetMoveSubEvent(161, 61, 164, 59);
                    player.sendSetWidgetMoveSubEvent(161, 62, 164, 60);
                    player.sendSetWidgetMoveSubEvent(161, 63, 164, 61);
                    player.sendSetWidgetMoveSubEvent(161, 64, 164, 62);
                    player.sendSetWidgetMoveSubEvent(161, 65, 164, 63);
                    player.sendSetWidgetMoveSubEvent(161, 66, 164, 64);
                    player.sendSetWidgetMoveSubEvent(161, 67, 164, 65);
                    player.sendSetWidgetMoveSubEvent(161, 68, 164, 66);
                    player.sendSetWidgetMoveSubEvent(161, 69, 164, 67);
                    player.sendSetWidgetMoveSubEvent(161, 70, 164, 68);
                    player.sendSetWidgetMoveSubEvent(161, 71, 164, 69);
                    player.sendSetWidgetMoveSubEvent(161, 4, 164, 4);
                    player.sendSetWidgetMoveSubEvent(161, 8, 164, 8);
                    player.sendSetWidgetMoveSubEvent(161, 18, 164, 18);
                    player.sendSetWidgetMoveSubEvent(161, 7, 164, 7);
                } else {
                    player.setDisplay(DisplayMode.RESIZE);
                    player.sendSetRootWidget(player.getDisplay().getId());
                    player.sendSetWidgetMoveSubEvent(164, 21, 161, 19);
                    player.sendSetWidgetMoveSubEvent(164, 9, 161, 9);
                    player.sendSetWidgetMoveSubEvent(164, 3, 161, 3);
                    player.sendSetWidgetMoveSubEvent(164, 6, 161, 6);
                    player.sendSetWidgetMoveSubEvent(164, 54, 161, 56);
                    player.sendSetWidgetMoveSubEvent(164, 56, 161, 58);
                    player.sendSetWidgetMoveSubEvent(164, 57, 161, 59);
                    player.sendSetWidgetMoveSubEvent(164, 58, 161, 60);
                    player.sendSetWidgetMoveSubEvent(164, 59, 161, 61);
                    player.sendSetWidgetMoveSubEvent(164, 60, 161, 62);
                    player.sendSetWidgetMoveSubEvent(164, 61, 161, 63);
                    player.sendSetWidgetMoveSubEvent(164, 62, 161, 64);
                    player.sendSetWidgetMoveSubEvent(164, 63, 161, 65);
                    player.sendSetWidgetMoveSubEvent(164, 64, 161, 66);
                    player.sendSetWidgetMoveSubEvent(164, 65, 161, 67);
                    player.sendSetWidgetMoveSubEvent(164, 66, 161, 68);
                    player.sendSetWidgetMoveSubEvent(164, 67, 161, 69);
                    player.sendSetWidgetMoveSubEvent(164, 68, 161, 70);
                    player.sendSetWidgetMoveSubEvent(164, 69, 161, 71);
                    player.sendSetWidgetMoveSubEvent(164, 4, 161, 4);
                    player.sendSetWidgetMoveSubEvent(164, 8, 161, 8);
                    player.sendSetWidgetMoveSubEvent(164, 18, 161, 18);
                    player.sendSetWidgetMoveSubEvent(164, 7, 161, 7);
                }
            } else {
                if (player.getDisplay().equals(DisplayMode.RESIZE_PANELS)) {
                    player.setDisplay(DisplayMode.FIXED);
                    player.sendSetRootWidget(player.getDisplay().getId());
                    player.sendSetWidgetMoveSubEvent(164, 21, 548, 20);
                    player.sendSetWidgetMoveSubEvent(164, 9, 548, 18);
                    player.sendSetWidgetMoveSubEvent(164, 3, 548, 12);
                    player.sendSetWidgetMoveSubEvent(164, 6, 548, 14);
                    player.sendSetWidgetMoveSubEvent(164, 54, 548, 60);
                    player.sendSetWidgetMoveSubEvent(164, 56, 548, 62);
                    player.sendSetWidgetMoveSubEvent(164, 57, 548, 63);
                    player.sendSetWidgetMoveSubEvent(164, 58, 548, 64);
                    player.sendSetWidgetMoveSubEvent(164, 59, 548, 65);
                    player.sendSetWidgetMoveSubEvent(164, 60, 548, 66);
                    player.sendSetWidgetMoveSubEvent(164, 61, 548, 67);
                    player.sendSetWidgetMoveSubEvent(164, 62, 548, 68);
                    player.sendSetWidgetMoveSubEvent(164, 63, 548, 69);
                    player.sendSetWidgetMoveSubEvent(164, 64, 548, 70);
                    player.sendSetWidgetMoveSubEvent(164, 65, 548, 71);
                    player.sendSetWidgetMoveSubEvent(164, 66, 548, 72);
                    player.sendSetWidgetMoveSubEvent(164, 67, 548, 73);
                    player.sendSetWidgetMoveSubEvent(164, 68, 548, 74);
                    player.sendSetWidgetMoveSubEvent(164, 69, 548, 75);
                    player.sendSetWidgetMoveSubEvent(164, 4, 548, 13);
                    player.sendSetWidgetMoveSubEvent(164, 8, 548, 16);
                    player.sendSetWidgetMoveSubEvent(164, 18, 548, 9);
                    player.sendSetWidgetMoveSubEvent(164, 7, 548, 15);
                } else {
                    player.setDisplay(DisplayMode.FIXED);
                    player.sendSetRootWidget(player.getDisplay().getId());
                    player.sendSetWidgetMoveSubEvent(161, 19, 548, 20);
                    player.sendSetWidgetMoveSubEvent(161, 9, 548, 18);
                    player.sendSetWidgetMoveSubEvent(161, 3, 548, 12);
                    player.sendSetWidgetMoveSubEvent(161, 6, 548, 14);
                    player.sendSetWidgetMoveSubEvent(161, 56, 548, 60);
                    player.sendSetWidgetMoveSubEvent(161, 58, 548, 62);
                    player.sendSetWidgetMoveSubEvent(161, 59, 548, 63);
                    player.sendSetWidgetMoveSubEvent(161, 60, 548, 64);
                    player.sendSetWidgetMoveSubEvent(161, 61, 548, 65);
                    player.sendSetWidgetMoveSubEvent(161, 62, 548, 66);
                    player.sendSetWidgetMoveSubEvent(161, 63, 548, 67);
                    player.sendSetWidgetMoveSubEvent(161, 64, 548, 68);
                    player.sendSetWidgetMoveSubEvent(161, 65, 548, 69);
                    player.sendSetWidgetMoveSubEvent(161, 66, 548, 70);
                    player.sendSetWidgetMoveSubEvent(161, 67, 548, 71);
                    player.sendSetWidgetMoveSubEvent(161, 68, 548, 72);
                    player.sendSetWidgetMoveSubEvent(161, 69, 548, 73);
                    player.sendSetWidgetMoveSubEvent(161, 70, 548, 74);
                    player.sendSetWidgetMoveSubEvent(161, 71, 548, 75);
                    player.sendSetWidgetMoveSubEvent(161, 4, 548, 13);
                    player.sendSetWidgetMoveSubEvent(161, 8, 548, 16);
                    player.sendSetWidgetMoveSubEvent(161, 18, 548, 9);
                    player.sendSetWidgetMoveSubEvent(161, 7, 548, 15);
                }
            }
        }
    }

}
