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
package com.oldscape.shared.network.game.event.decoders.walking;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.WalkEvent;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */
public class WalkDecoder implements GameMessageDecoder<WalkEvent> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oldscape.shared.network.game.event.GameMessageDecoder#decode(com.oldscape.server
	 * .shared.network.game.GameFrameReader)
	 */
	@Override
	public WalkEvent decode(GameFrameReader frame) {
		int type = (int) frame.getUnsigned(DataType.BYTE, DataTransformation.NEGATE);
		int posY = (int) frame.getUnsigned(DataType.SHORT, DataOrder.LITTLE);//, DataOrder.LITTLE
		int posX = (int) frame.getUnsigned(DataType.SHORT, DataTransformation.ADD);

		System.out.println("walkevent  "+posY+" "+posX+" "+type);
		return new WalkEvent(posX, posY, type);
	}

}
