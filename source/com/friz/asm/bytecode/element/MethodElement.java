/**
 * Copyright (c) 2015 Kyle Friz
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.friz.asm.bytecode.element;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

import com.friz.asm.bytecode.Container;

/**
 * @author Kyle Friz
 * @since Apr 4, 2015
 */
public class MethodElement {

	private Map<AbstractInsnNode, InsnList> listsToAdd = new HashMap<>();
	private ClassElement parent;
	private MethodNode node;

	public MethodElement(ClassElement parent, MethodNode node) {
		this.parent = parent;
		this.node = node;
	}

	public ClassElement parent() {
		return parent;
	}

	public MethodNode node() {
		return node;
	}

	public String name() {
		return node.name;
	}

	public String desc() {
		return node.desc;
	}

	/**
	 * Note: InsnList is not Thread Safe
	 * @return
	 */
	public InsnList insn() {
		return node.instructions;
	}
	
	public AbstractInsnNode[] insnList() {
		AbstractInsnNode[] src = node.instructions.toArray();
		AbstractInsnNode[] dest = new AbstractInsnNode[src.length];
		System.arraycopy(src, 0, dest, 0, src.length);
		return dest;
	}
	
	public void queue(AbstractInsnNode node, InsnList list) {
		listsToAdd.put(node, list);
	}
	
	public void insert() {
		listsToAdd.entrySet().forEach((Map.Entry<AbstractInsnNode, InsnList> set) -> {
			node.instructions.insert(set.getKey(), set.getValue());
		});
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

	public boolean isStrict() {
		return Modifier.isStrict(node.access);
	}

	public boolean isProtected() {
		return Modifier.isProtected(node.access);
	}

	public boolean isAbstract() {
		return Modifier.isAbstract(node.access);
	}

	public boolean isNative() {
		return Modifier.isNative(node.access);
	}

	public boolean isSynchronized() {
		return Modifier.isSynchronized(node.access);
	}

	public int parameterCount() {
		String[] descs = desc().split("(|)");
		boolean clazz = false;
		boolean array = false;
		int count = 0;
		descLoop: for (String desc : descs) {
			for (char c : desc.toCharArray()) {
				if (clazz) {
					if (c == ';') {
						clazz = false;
						count++;
					}
					continue;
				} else if (array) {
					if (c != '[') {
						array = false;
						count++;
					}
					continue;
				}
				switch (c) {
				case 'L':
					clazz = true;
					break;
				case '[':
					array = true;
					break;
				case '(':
					break;
				case ')':
					break descLoop;
				default:
					count++;
					break;
				}
			}
		}
		return count;
	}
	
    public boolean isInherited(Container container) {
    	ClassElement super_ = container.name(parent.node().superName);
        while (super_ != null) {
            if (super_.containsMethod(name(), desc())) {
                return true;
            }
            super_ = container.name(super_.node().superName);
        }
        return false;
    }
    
    @Override
    public String toString() {
    	return parent.name() + "." + node.name + "#" + node.desc;
    }
}
