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
package com.oldscape.tool.asm.transformers.refactor;

import com.oldscape.tool.asm.Transformer;
import com.oldscape.tool.asm.bytecode.Container;
import com.oldscape.tool.asm.bytecode.element.ClassElement;
import com.oldscape.tool.asm.bytecode.element.MethodElement;

import java.util.logging.Logger;

/**
 * @author Kyle Friz
 * @since Apr 5, 2015
 */
public class ClassTransformer extends Transformer {

    /**
     * The {@link Logger} instance
     */
    private static Logger logger = Logger.getLogger(ClassTransformer.class.getName());

    public ClassTransformer(Container container) {
        super(container);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.oldscape.tool.asm.Transformer#transform()
     */
    @Override
    public void transform() {
        classLoop:
        for (ClassElement element : container().elements()) {

            tInc(0);

            for (MethodElement method : element.methods()) {
                if (method.isNative()) {
                    pInc(1);
                    continue classLoop;
                }
            }

            pInc(2);
            String newName = "com/oldscape/" + element.name();

            container().refactorer().relocateClass(element, newName);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.oldscape.tool.Transformer#log()
     */
    @Override
    public void log() {
        logger.info("Renamed " + pointer(2) + " Classes out of " + total(0) + " (" + percent(2) + "%) Classes");
        logger.info("Skipped " + pointer(1) + " Native Class(es) out of " + total(0) + " (" + percent(1) + "%) Class(es)");
    }
}
