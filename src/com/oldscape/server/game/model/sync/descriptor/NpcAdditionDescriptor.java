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

import com.oldscape.server.game.model.sync.segment.NpcAdditionSegment;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.event.Event;
import com.oldscape.server.game.model.region.Position;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.impl.NpcSynchronizationEvent;

/**
 * @author Kyle Friz
 * @since Aug 30, 2015
 */
public class NpcAdditionDescriptor extends SynchronizationDescriptor {//class28 method274

    /* (non-Javadoc)
     * @see com.oldscape.server.game.model.sync.Descriptor#encodeDescriptor(com.oldscape.server.game.model.account.Player, com.oldscape.server.game.model.sync.seg.SynchronizationSegment, com.oldscape.shared.network.game.GameFrameBuilder)
     */
    @Override
    public void encodeDescriptor(Event event, SynchronizationSegment segment, GameFrameBuilder builder) {
        boolean updateRequired = segment.getBlockSet().size() > 0;
        Position npc = ((NpcSynchronizationEvent) event).getPosition();
        Position other = ((NpcAdditionSegment) segment).getPosition();
        int deltaY = other.getY() - npc.getY();
        int deltaX = other.getX() - npc.getX();

        if (((NpcSynchronizationEvent) event).isLargeScene()) {
            if (deltaX < 127) {
                deltaX += 256;
            }
            if (deltaY < 127) {
                deltaY += 256;
            }
        } else {
            if (deltaX < 15) {
                deltaX += 32;
            }
            if (deltaY < 15) {
                deltaY += 32;
            }
        }

        builder.putBits(15, ((NpcAdditionSegment) segment).getIndex());
        builder.putBits(1, updateRequired ? 1 : 0);
        builder.putBits((((NpcSynchronizationEvent) event).isLargeScene() ? 8 : 5), deltaX);
        builder.putBits(3, 0);//orientation
        builder.putBits(14, ((NpcAdditionSegment) segment).getNpcId());
        builder.putBits((((NpcSynchronizationEvent) event).isLargeScene() ? 8 : 5), deltaY);
        builder.putBits(1, 0); // discard walking queue

    }

}
