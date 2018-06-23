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
package com.oldscape.shared.network.game.event.impl;

import com.oldscape.server.game.model.entity.npc.Npc;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.event.Event;
import com.oldscape.server.game.model.map.Position;

import java.util.List;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */
public class NpcSynchronizationEvent implements Event {

    /**
     * The amount of local npc.
     */
    private final int localNpcs;

    /**
     * The npc's position.
     */
    private final Position position;

    /**
     * A flag if the npc update is using a large scene
     */
    private final boolean largeScene;

    /**
     * A list of segments.
     */
    private final List<SynchronizationSegment> segments;

    /**
     * Creates a new {@link NpcSynchronizationMessage}.
     *
     * @param position  The position of the {@link Npc}.
     * @param segments  The list of segments.
     * @param localNpcs The amount of local npc.
     */
    public NpcSynchronizationEvent(Position position,
                                   List<SynchronizationSegment> segments, int localNpcs, boolean large) {
        this.position = position;
        this.segments = segments;
        this.localNpcs = localNpcs;
        this.largeScene = large;
    }

    /**
     * Gets the number of local npc.
     *
     * @return The number of local npc.
     */
    public int getLocalNpcCount() {
        return localNpcs;
    }

    /**
     * Gets the npc's position.
     *
     * @return The npc's position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Gets the flag if using a large scene
     *
     * @return The flag
     */
    public boolean isLargeScene() {
        return largeScene;
    }

    /**
     * Gets the synchronization segments.
     *
     * @return The segments.
     */
    public List<SynchronizationSegment> getSegments() {
        return segments;
    }

}
