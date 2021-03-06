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

import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.LogoutEvent;

import io.netty.buffer.ByteBufAllocator;

public final class VarpRecacheEventEncoder implements GameMessageEncoder<LogoutEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, LogoutEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public GameFrame encode(ByteBufAllocator alloc, LogoutEvent event) {
//		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.VARP_RECACHE, FrameType.FIXED);
//		return builder.toGameFrame();
//	}
	
}
