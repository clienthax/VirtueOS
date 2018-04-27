/**
 * Copyright (c) 2014 RSE Studios
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
package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.InterfaceSetClickMaskEvent;

import io.netty.buffer.ByteBufAllocator;

public final class InterfaceSetClickMaskEventEncoder implements GameMessageEncoder<InterfaceSetClickMaskEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, InterfaceSetClickMaskEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.IF_SET_CLICK_MASK, FrameType.FIXED);

		builder.put(DataType.SHORT, DataTransformation.ADD, event.getFrom());
		builder.put(DataType.INT, DataOrder.INVERSED_MIDDLE, event.getSettings());
		builder.put(DataType.INT, event.getRoot() << 16 | event.getComponent());
		builder.put(DataType.SHORT, DataTransformation.ADD, event.getTo());

//		System.out.println(String.format("interfaceSetClickMask(%d, %d, %d, %d, %d)", event.getRoot(), event.getComponent(), event.getFrom(), event.getTo(), event.getSettings()));


		return builder.toGameFrame();
	}
}
