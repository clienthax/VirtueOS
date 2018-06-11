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

import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.server.game.model.sync.segment.TeleportSegment;
import com.oldscape.shared.event.Event;
import com.oldscape.shared.model.Position;
import com.oldscape.shared.network.game.GameFrameBuilder;

/**
 * @author Kyle Friz
 * @since Aug 30, 2015
 */
public class PlayerTeleportDescriptor extends SynchronizationDescriptor {

    /* (non-Javadoc)
     * @see com.oldscape.server.game.model.sync.Descriptor#encodeDescriptor(com.oldscape.server.game.model.player.Player, com.oldscape.server.game.model.sync.seg.SynchronizationSegment, com.oldscape.shared.network.game.GameFrameBuilder)
     */
    @Override
    public void encodeDescriptor(Event event, SynchronizationSegment segment, GameFrameBuilder builder) {
        Position start = ((TeleportSegment) segment).getStart();
        Position destination = ((TeleportSegment) segment).getDestination();

        System.out.println("start x" + start.getX() + " y" + start.getY() + " z" + start.getHeight());
        System.out.println("destination x" + destination.getX() + " y" + destination.getY() + " z" + destination.getHeight());

        int xOff = destination.getX() - start.getX();
        int yOff = destination.getY() - start.getY();
        int zOff = destination.getHeight() - start.getHeight();

        boolean exterior = (Math.abs(xOff) > 15 || Math.abs(yOff) > 15);//Actually needs to be 15

        builder.putBit(true);
        builder.putBit(segment.getBlockSet().size() > 0);
        builder.putBits(2, 3);

        builder.putBit(exterior);

        System.out.println("sending teleport " + exterior + " x" + xOff + " y" + yOff + " z" + zOff);

        if (exterior) {//TODO seems to read incorrectly on client 3: if negatice*
            builder.putBits(30, (yOff & 0x3fff) + ((xOff & 0x3fff) << 14) + ((zOff & 0x3) << 28));
        } else {
            //builder.putBits(12, (yOff) + (xOff << 5) + ((zOff & 0x3) << 10));
            //Interior 168
            /**
             *
             Kris - Today at 6:48 PM
             Perhaps xOff/yOff exceeds the allowed value. There's no bitwise and operator in the 12-bit loc hash.
             You should change both yOff/xOff to yOff & 0x1F, same with xOff.
             */
            builder.putBits(12,
                    (yOff & 0x1F)
                            + ((xOff & 0x1F) << 5)
                            + ((zOff & 0x3) << 10)
            );
        }
    }

}
