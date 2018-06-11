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
package com.oldscape.tool.asm.bytecode.refactor;

import org.objectweb.asm.commons.Remapper;

/**
 * @author Kyle Friz
 * @since Apr 6, 2015
 */
public class RefactorMapper extends Remapper {

    private Refactorer container;

    public RefactorMapper(Refactorer container) {
        this.container = container;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.objectweb.asm.commons.Remapper#map(java.lang.String)
     */
    @Override
    public String map(String type) {
        if (container.classes().containsKey(type))
            return container.classes().get(type).renName();

        return type;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.objectweb.asm.commons.Remapper#mapMethodName(java.langString,
     * java.lang.String, java.lang.String)
     */
    @Override
    public String mapMethodName(String owner, String name, String desc) {
        return name;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.objectweb.asm.commons.Remapper#mapFieldName(java.langString,
     * java.lang.String, java.lang.String)
     */
    @Override
    public String mapFieldName(String owner, String name, String desc) {
        return name;
    }

}
