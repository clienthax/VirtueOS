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

import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.event.Event;
import com.oldscape.shared.network.game.GameFrameBuilder;

/**
 * @author Kyle Friz
 * @since Aug 28, 2015
 */
public abstract class SynchronizationDescriptor {

    public abstract void encodeDescriptor(Event event, SynchronizationSegment segment, GameFrameBuilder builder);

    protected void encodeRegion(GameFrameBuilder builder, int lastRegionHash, int currentRegionHash) {
        int lastRegionX = (lastRegionHash >> 8) & 0xff;
        int lastRegionY = 0xff & lastRegionHash;
        int lastPlane = (lastRegionHash >> 16) & 0x3;
        int currentRegionX = (currentRegionHash >> 8) & 0xff;
        int currentRegionY = 0xff & currentRegionHash;
        int currentPlane = (currentRegionHash >> 16) & 0x3;
        int planeOffset = currentPlane - lastPlane;
        if (lastRegionX == currentRegionX && lastRegionY == currentRegionY) {
            builder.putBits(2, 1);
            builder.putBits(2, (planeOffset & 0x3));
        } else if (Math.abs(currentRegionX - lastRegionX) <= 1 && Math.abs(currentRegionY - lastRegionY) <= 1) {
            int opcode;
            int dx = currentRegionX - lastRegionX;
            int dy = currentRegionY - lastRegionY;
            if (dx == -1 && dy == -1) {
                opcode = 0;
            } else if (dx == 1 && dy == -1) {
                opcode = 2;
            } else if (dx == -1 && dy == 1) {
                opcode = 5;
            } else if (dx == 1 && dy == 1) {
                opcode = 7;
            } else if (dy == -1) {
                opcode = 1;
            } else if (dx == -1) {
                opcode = 3;
            } else if (dx == 1) {
                opcode = 4;
            } else if (dy == 1) {
                opcode = 6;
            } else {
                throw new RuntimeException("Invalid delta value for map hash!");
            }
            builder.putBits(2, 2);
            builder.putBits(5, ((planeOffset & 0x3) << 3) + (opcode & 0x7));
        } else {
            int xOffset = currentRegionX - lastRegionX;
            int yOffset = currentRegionY - lastRegionY;
            builder.putBits(2, 3);
            builder.putBits(18, (yOffset & 0xff) + ((xOffset & 0xff) << 8) + ((planeOffset & 0x3) << 16));
        }
    }

}
