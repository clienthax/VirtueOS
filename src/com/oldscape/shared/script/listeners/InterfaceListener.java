/**
 * Copyright (c) 2015 Kyle Friz & Kayla Friz
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
package com.oldscape.shared.script.listeners;

import com.oldscape.server.game.model.player.Player;

/**
 * 
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 29, 2015
 */
public interface InterfaceListener {

	/**
	 * Gets the widget ids which are bound to this listener
	 * 
	 * @return an array of integers containing the ids to bind to
	 */
	public int[] getIDs();

	/**
	 * Called whenever a player clicks a button on the widget
	 * 
	 * @param player
	 *            The player who clicked the button
	 * @param interfaceId
	 *            The id of the widget clicked
	 * @param buttonId
	 *            The id of the button clicked
	 * @param itemId
	 *            The id of the item clicked, or 65535 if there was no item
	 * @param slotId
	 *            The slot within the component which was clicked, or 65535 if the
	 *            component has no slots
	 * @param option
	 *            The option selected. Ranges from 1 to 10
	 * @return True if the interaction was handled, false otherwise
	 */
	public boolean handle(Player player, int interfaceId, int buttonId, int itemId, int slotId, int option);

}
