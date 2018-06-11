/**
 * Copyright (c) 2015 Kyle Friz & Kayla Friz
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
package com.oldscape.shared.script.listeners;

import com.oldscape.server.game.model.player.Player;
import com.oldscape.shared.model.player.Permission;

/**
 *
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 29, 2015
 */
public interface CommandListener {

    /**
     * Called when this command is executed.
     *
     * @param syntax
     *            The syntax of the command.
     * @param player
     *            The player.
     * @param args
     *            The arguments
     * @return True if the command was handled, false otherwise
     */
    boolean handle(Player player, String syntax, String[] args);

    /**
     * Returns a string array of possible command names that could trigger this
     * event.
     *
     * @return The possible array of syntaxes.
     */
    String[] getPossibleSyntaxes();

    /**
     * Returns the required permission for this command
     *
     * @return The required permission
     */
    public Permission getPermission();
}
