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
package com.oldscape.tool.asm.transformers;

import java.util.Iterator;
import java.util.logging.Logger;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;

import com.oldscape.tool.asm.Transformer;
import com.oldscape.tool.asm.bytecode.Container;
import com.oldscape.tool.asm.bytecode.element.ClassElement;
import com.oldscape.tool.asm.bytecode.element.MethodElement;
import com.oldscape.tool.asm.bytecode.insn.InsnMatcher;
import com.oldscape.tool.asm.bytecode.insn.InsnNodeUtils;

/**
 * @author Kyle Friz
 * @since Apr 4, 2015
 */
public class IntegerBitwiseTransformer extends Transformer {

	/**
	 * The {@link Logger} instance
	 */
	private static Logger logger = Logger.getLogger(IntegerBitwiseTransformer.class.getName());

	public IntegerBitwiseTransformer(Container container) {
		super(container);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oldscape.tool.asm.Transformer#transform()
	 */
	@Override
	public void transform() {
		for (ClassElement element : container().elements()) {
			for (MethodElement method : element.methods()) {
				InsnMatcher matcher = new InsnMatcher(method.insn());
				for (Iterator<AbstractInsnNode[]> it = matcher
						.match("pushinstruction ((ISHL)|(ISHR)|(IUSHR))"); it
						.hasNext();) {
					AbstractInsnNode[] nodes = it.next();
					AbstractInsnNode node = nodes[0];
					if (node instanceof IntInsnNode
							|| node instanceof LdcInsnNode
							|| (node instanceof InsnNode && (node.getOpcode() >= Opcodes.ICONST_M1 && node
									.getOpcode() <= Opcodes.ICONST_5))) {
						long push = InsnNodeUtils.getNumericPushValue(node);
						long realpush = push & 0x1f;
						if (push != realpush) {
							method.insn().set(
									node,
									InsnNodeUtils
											.createNumericPushInsn(realpush));
							pInc(0);
						} else {
							tInc(0);
						}
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oldscape.tool.Transformer#log()
	 */
	@Override
	public void log() {
		logger.info("Fixed " + pointer(0) + " out of " + total(0) + " (" + percent(0) + "%) Integer Bitwise Operation(s).");
	}
}
