/**
 * Copyright (c) 2015 Kyle Friz
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
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
import com.oldscape.shared.model.Position;
import com.oldscape.shared.network.game.event.impl.WalkEvent;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */
public class WalkEventListener implements EventListener<WalkEvent, GameSessionContext> {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.oldscape.shared.event.EventListener#onEvent(com.oldscape.shared.event.Event,
     * com.oldscape.shared.event.EventContext)
     */
    @Override
    public void onEvent(WalkEvent event, GameSessionContext context) {
        Player player = context.getPlayer();

        /* Close any open Interfaces */
        // TODO: add a check for any widget not including Gameframe.
        player.sendCloseWidgetSub(548, 22);

        if (event.getType() == 0) {
            player.getWalkingQueue().clear();
            player.getWalkingQueue().addStep(new Position((event.getX()), (event.getY()), player.getPosition().getHeight()), context.getServer().getRegionManager());
        } else {
            player.teleport(new Position((event.getX()), (event.getY()), player.getPosition().getHeight()));
        }
    }

}
