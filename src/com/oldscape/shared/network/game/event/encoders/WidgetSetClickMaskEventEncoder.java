/**
 * Copyright (c) 2014 RSE Studios
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
package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.WidgetSetClickMaskEvent;
import io.netty.buffer.ByteBufAllocator;

public final class WidgetSetClickMaskEventEncoder implements GameMessageEncoder<WidgetSetClickMaskEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, WidgetSetClickMaskEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_SET_CLICK_MASK, FrameType.FIXED);

        builder.put(DataType.INT, DataOrder.LITTLE, event.getRoot() << 16 | event.getComponent());
        builder.put(DataType.SHORT, DataOrder.LITTLE, event.getFrom());
        builder.put(DataType.INT, DataOrder.INVERSED_MIDDLE, event.getSettings());
        builder.put(DataType.SHORT, DataOrder.LITTLE, event.getTo());

        return builder.toGameFrame();
    }
}
