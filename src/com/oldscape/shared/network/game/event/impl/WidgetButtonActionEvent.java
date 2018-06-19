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
public class WidgetButtonActionEvent implements Event {

    private int opcode;
    private int widgetHash;
    private int buttonHash;
    private int widgetID;
    private int widgetChildID;

    public WidgetButtonActionEvent(int opcode, int widgetHash, int buttonHash, int widgetID, int widgetChildID) {
        this.opcode = opcode;
        this.widgetHash = widgetHash;
        this.buttonHash = buttonHash;
        this.widgetID = widgetID;
        this.widgetChildID = widgetChildID;
    }

    public static int getActionForOpcode(int opcode) {
        if(opcode == 17) {
            return 1;
        }
        if(opcode == 38) {
            return 2;
        }
        if(opcode == 46) {
            return 3;
        }
        if(opcode == 41) {
            return 4;
        }
        if(opcode == 18) {
            return 5;
        }
        if(opcode == 14) {
            return 6;
        }
        if(opcode == 33) {
            return 7;
        }
        if(opcode == 96) {
            return 8;
        }
        if(opcode == 20) {
            return 9;
        }
        if(opcode == 95) {
            return 10;
        }
        return -1;
    }

    /**
     * @return the opcode
     */
    public int getOpcode() {
        return opcode;
    }

    /**
     * @return the widgetHash
     */
    public int getWidgetHash() {
        return widgetHash;
    }

    /**
     * @return the buttonHash
     */
    public int getButtonHash() {
        return buttonHash;
    }

    public int getWidgetID() {
        return widgetID;
    }

    public int getWidgetChildID() {
        return widgetChildID;
    }

}
