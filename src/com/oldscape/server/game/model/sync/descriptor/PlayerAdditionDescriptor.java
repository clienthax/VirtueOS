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
package com.oldscape.server.game.model.sync.descriptor;

import com.oldscape.server.game.model.sync.segment.PlayerAdditionSegment;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.event.Event;
import com.oldscape.shared.model.Position;
import com.oldscape.shared.network.game.GameFrameBuilder;

/**
 * @author Kyle Friz
 * @since Aug 29, 2015
 */
public class PlayerAdditionDescriptor extends SynchronizationDescriptor {

    /* (non-Javadoc)
     * @see com.oldscape.server.game.model.sync.Descriptor#encodeDescriptor(com.oldscape.server.game.model.player.Player, com.oldscape.server.game.model.sync.seg.SynchronizationSegment, com.oldscape.shared.network.game.GameFrameBuilder)
     */
    @Override
    public void encodeDescriptor(Event event, SynchronizationSegment segment, GameFrameBuilder builder) {
        Position position = ((PlayerAdditionSegment) segment).getPosition();
        boolean update = ((PlayerAdditionSegment) segment).isUpdate();

        builder.putBit(true);
        builder.putBits(2, 0);

        builder.putBit(update);
        if (update) {
            encodeRegion(builder, ((PlayerAdditionSegment) segment).getRegionHash(), position.toRegionPacked());
        }

        builder.putBits(6, position.getXInRegion());
        builder.putBits(6, position.getYInRegion());
        builder.putBit(true);
    }

}
