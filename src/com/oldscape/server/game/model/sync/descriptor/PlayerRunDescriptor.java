/**
 * Copyright (c) 2015 Kyle Friz
 * <p>
 * ChatCrownType is hereby granted, free of charge, to any person obtaining a copy
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
package com.oldscape.server.game.model.sync.descriptor;

import com.oldscape.server.game.model.sync.reference.Direction;
import com.oldscape.server.game.model.sync.segment.MovementSegment;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.event.Event;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.utility.SyncUtils;

/**
 * @author Kyle Friz
 * @since Aug 30, 2015
 */
public class PlayerRunDescriptor extends SynchronizationDescriptor {

    @Override
    public void encodeDescriptor(Event event, SynchronizationSegment segment, GameFrameBuilder builder) {
        Direction first = ((MovementSegment) segment).getDirections()[0];
        Direction second = ((MovementSegment) segment).getDirections()[0];
        int dX = SyncUtils.getDirX(first.toInteger(), second.toInteger());
        int dY = SyncUtils.getDirY(first.toInteger(), second.toInteger());
        int opcode = SyncUtils.getPlayerRunningDirection(dX, dY);


        builder.putBit(true);
        builder.putBit(segment.getBlockSet().size() > 0);
        builder.putBits(2, 2);
        builder.putBits(4, opcode);
    }

}
