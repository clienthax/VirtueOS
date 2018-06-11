/**
 * Copyright (c) Kyle Fricilone
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
package com.oldscape.shared.cache.type.varclients;

import com.oldscape.shared.cache.type.Type;

import java.nio.ByteBuffer;

/**
 * @author Kyle Friz
 *
 * @since May 26, 2015
 */
public class VarClientType implements Type {

    private final int id;
    private boolean serialize;

    public VarClientType(int id) {
        this.id = id;
        this.serialize = false;
    }

    @Override
    public void decode(ByteBuffer buffer) {
        while (true) {
            int opcode = buffer.get() & 0xFF;
            if (opcode == 0)
                return;

            if (opcode == 2)
                serialize = true;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.oldscape.shared.cache.type.Type#encode()
     */
    @Override
    public ByteBuffer encode() {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        if (serialize) {
            buffer.put((byte) 2);
        }

        buffer.put((byte) 0);
        return (ByteBuffer) buffer.flip();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.oldscape.shared.cache.type.Type#encode317()
     */
    @Override
    public ByteBuffer encode317() {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        if (serialize) {
            buffer.put((byte) 2);
        }

        buffer.put((byte) 0);
        return (ByteBuffer) buffer.flip();
    }

    @Override
    public int getID() {
        return id;
    }

    public boolean isSerialize() {
        return serialize;
    }

}
