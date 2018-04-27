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
package com.sean.game.network.game.listeners;

import com.sean.game.model.player.Player;
import com.sean.game.network.game.GameSessionContext;
import com.sean.shared.event.EventListener;
import com.sean.shared.model.Position;
import com.sean.shared.network.game.event.impl.WalkEvent;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */
public class WalkEventListener implements EventListener<WalkEvent, GameSessionContext> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sean.shared.event.EventListener#onEvent(com.sean.shared.event.Event,
	 * com.sean.shared.event.EventContext)
	 */
	@Override
	public void onEvent(WalkEvent event, GameSessionContext context) {
		Player player = context.getPlayer();

		//Close any open interfaces
		player.sendCloseInterfaceSub(548, 22);

		player.getWalkingQueue().clear();
		player.getWalkingQueue().addStep(new Position((event.getX()), (event.getY()), player.getPosition().getHeight()), context.getServer().getRegionManager());
	}

}
