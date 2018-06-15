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
package com.oldscape.shared.network.game.event.decoders.client;

import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.ClientDimensionsEvent;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 18, 2015
 */
public class ClientDimensionsDecoder implements GameMessageDecoder<ClientDimensionsEvent> {

    @Override
    public ClientDimensionsEvent decode(GameFrameReader frame) {
        boolean resizable = frame.getUnsigned(DataType.BYTE) == 2;
        int width = (int) frame.getUnsigned(DataType.SHORT);
        int height = (int) frame.getUnsigned(DataType.SHORT);

        return new ClientDimensionsEvent(frame.getOpcode(), resizable, width, height);
    }

}
