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
package com.oldscape.tool.asm.bytecode.element;

import org.objectweb.asm.tree.FieldNode;

import java.lang.reflect.Modifier;

/**
 * @author Kyle Friz
 * @since Apr 4, 2015
 */
public class FieldElement {

    private ClassElement parent;
    private FieldNode node;

    public FieldElement(ClassElement parent, FieldNode node) {
        this.parent = parent;
        this.node = node;
    }

    public ClassElement parent() {
        return parent;
    }

    public FieldNode node() {
        return node;
    }

    public String name() {
        return node.name;
    }

    public String desc() {
        return node.desc;
    }

    public String sign() {
        return node.signature;
    }

    public Object val() {
        return node.value;
    }

    public boolean isPublic() {
        return Modifier.isPublic(node.access);
    }

    public boolean isPrivate() {
        return Modifier.isPrivate(node.access);
    }

    public boolean isFinal() {
        return Modifier.isFinal(node.access);
    }

    public boolean isStatic() {
        return Modifier.isStatic(node.access);
    }

    public boolean isProtected() {
        return Modifier.isProtected(node.access);
    }

    public boolean isTransient() {
        return Modifier.isTransient(node.access);
    }

    public boolean isVolatile() {
        return Modifier.isVolatile(node.access);
    }

    @Override
    public String toString() {
        return parent.name() + "." + node.name + "#" + node.desc;
    }

}
