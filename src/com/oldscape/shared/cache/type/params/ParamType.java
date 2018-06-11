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
package com.oldscape.shared.cache.type.params;

import com.oldscape.shared.cache.type.Type;
import com.oldscape.shared.utility.ByteBufferUtils;

import java.nio.ByteBuffer;

/**
 *
 * Created by Kyle Fricilone on Jun 1, 2017.
 */
public class ParamType implements Type {

    private final int id;
    public int defaultInt;
    public String defaultString;
    boolean autoDisable = true;
    char stackType;

    public ParamType(int id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.oldscape.shared.cache.type.Type#decode(java.nio.ByteBuffer)
     */
    @Override
    public void decode(ByteBuffer buffer) {
        while (true) {
            int opcode = buffer.get() & 0xFF;
            if (opcode == 0)
                break;

            if (opcode == 1) {
                stackType = ByteBufferUtils.getJagexChar(buffer);
            } else if (opcode == 2) {
                defaultInt = buffer.getInt();
            } else if (opcode == 4) {
                autoDisable = false;
            } else if (opcode == 5) {
                defaultString = ByteBufferUtils.getString(buffer);
            }

        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.oldscape.shared.cache.type.Type#encode()
     */
    @Override
    public ByteBuffer encode() {
        ByteBuffer buffer = ByteBuffer.allocate(1132);
        return (ByteBuffer) buffer.flip();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.oldscape.shared.cache.type.Type#encode317()
     */
    @Override
    public ByteBuffer encode317() {
        ByteBuffer buffer = ByteBuffer.allocate(1132);
        return (ByteBuffer) buffer.flip();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.oldscape.shared.cache.type.Type#getID()
     */
    @Override
    public int getID() {
        return id;
    }

}
