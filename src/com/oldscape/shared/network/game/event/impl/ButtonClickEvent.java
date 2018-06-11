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
package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */
public class ButtonClickEvent implements Event {

    private int opcode;
    private int interfaceID;
    private int buttonID;

    public ButtonClickEvent(int opcode, int interfaceID, int buttonID) {
        this.opcode = opcode;
        this.interfaceID = interfaceID;
        this.buttonID = buttonID;
    }

    /**
     * @return the opcode
     */
    public int getOpcode() {
        return opcode;
    }

    /**
     * @return the interfaceID
     */
    public int getInterfaceID() {
        return interfaceID;
    }

    /**
     * @return the buttonID
     */
    public int getButtonID() {
        return buttonID;
    }

}
