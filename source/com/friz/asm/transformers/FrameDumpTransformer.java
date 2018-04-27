/**
 * Copyright (c) 2015 Kyle Friz & Kayla Friz
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
package com.friz.asm.transformers;

import java.util.Iterator;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

import com.friz.asm.Transformer;
import com.friz.asm.bytecode.Container;
import com.friz.asm.bytecode.element.ClassElement;
import com.friz.asm.bytecode.element.MethodElement;
import com.friz.asm.bytecode.insn.InsnMatcher;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 20, 2015
 */
public class FrameDumpTransformer extends Transformer {

	/**
	 * @param container
	 */
	public FrameDumpTransformer(Container container) {
		super(container);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.friz.asm.Transformer#transform()
	 */
	@Override
	public void transform() {

		for (ClassElement element : container().elements()) {

			if (element.name().equals("n")) {

				for (MethodElement method : element.methods()) {

					if (method.name().equals("bp")) {

						InsnMatcher matcher = new InsnMatcher(method.insn());

						Iterator<AbstractInsnNode[]> it;

						// Varp Small
						it = matcher.match("GETSTATIC LDC IMUL SIPUSH IF_ICMPNE");
						while (it.hasNext()) {
							AbstractInsnNode[] nodes = it.next();
							if (((IntInsnNode) nodes[3]).operand == 189) {
								InsnList printList = new InsnList();
								VarInsnNode key = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 16);
								VarInsnNode value = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 20);
								printList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
								printList.add(new TypeInsnNode(Opcodes.NEW, "java/lang/StringBuilder"));
								printList.add(new InsnNode(Opcodes.DUP));
								printList.add(new LdcInsnNode("player.sendVarp("));
								printList.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, key.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, value.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(");"));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder",
										"append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder",
										"toString", "()Ljava/lang/String;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream",
										"println", "(Ljava/lang/String;)V", false));
								method.queue(value, printList);
							}
						}

						// Varp Large
						it = matcher.match("BIPUSH GETSTATIC LDC IMUL IF_ICMPNE");
						while (it.hasNext()) {
							AbstractInsnNode[] nodes = it.next();
							if (((IntInsnNode) nodes[0]).operand == 217) {
								InsnList printList = new InsnList();
								VarInsnNode key = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 12);
								VarInsnNode value = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 8);
								printList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
								printList.add(new TypeInsnNode(Opcodes.NEW, "java/lang/StringBuilder"));
								printList.add(new InsnNode(Opcodes.DUP));
								printList.add(new LdcInsnNode("player.sendVarp("));
								printList.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, key.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, value.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(");"));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
								method.queue(key, printList);
							}
						}

						// Root Interface
						it = matcher.match("SIPUSH LDC GETSTATIC IMUL IF_ICMPNE");
						while (it.hasNext()) {
							AbstractInsnNode[] nodes = it.next();
							if (((IntInsnNode) nodes[0]).operand == 129) { //was 161
								InsnList printList = new InsnList();
								VarInsnNode id = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 16);
								printList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
								printList.add(new TypeInsnNode(Opcodes.NEW, "java/lang/StringBuilder"));
								printList.add(new InsnNode(Opcodes.DUP));
								printList.add(new LdcInsnNode("player.sendSetRootInterface("));
								printList.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, id.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(");"));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
								method.queue(id, printList);
							}
						}

						// Interface
						it = matcher.match("BIPUSH GETSTATIC LDC IMUL IF_ICMPNE");
						while (it.hasNext()) {
							AbstractInsnNode[] nodes = it.next();
							if (((IntInsnNode) nodes[0]).operand == 111) {
								Label label1 = new Label();
								Label label2 = new Label();
								InsnList printList = new InsnList();
								VarInsnNode hash = (VarInsnNode) method.insn()
										.get(method.insn().indexOf(nodes[0]) + 16);
								VarInsnNode id = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 20);
								VarInsnNode hidden = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 24);
								printList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
								printList.add(new TypeInsnNode(Opcodes.NEW, "java/lang/StringBuilder"));
								printList.add(new InsnNode(Opcodes.DUP));
								printList.add(new LdcInsnNode("player.sendOpenInterfaceSub("));
								printList.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, hash.var));
								printList.add(new IntInsnNode(Opcodes.BIPUSH, 16));
								printList.add(new InsnNode(Opcodes.ISHR));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, hash.var));
								printList.add(new LdcInsnNode(0xFFFF));
								printList.add(new InsnNode(Opcodes.IAND));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, id.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, hidden.var));
								printList.add(new InsnNode(Opcodes.ICONST_1));
								printList.add(new JumpInsnNode(Opcodes.IF_ICMPNE, new LabelNode(label1)));
								printList.add(new InsnNode(Opcodes.ICONST_1));
								printList.add(new JumpInsnNode(Opcodes.GOTO, new LabelNode(label2)));
								printList.add(new LabelNode(label1));
								printList.add(new InsnNode(Opcodes.ICONST_0));
								printList.add(new LabelNode(label2));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Z)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(");"));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
								method.queue(hidden, printList);
							}
						}

						// Interface Transform
						it = matcher.match("SIPUSH GETSTATIC LDC IMUL IF_ICMPNE");
						while (it.hasNext()) {
							AbstractInsnNode[] nodes = it.next();
							if (((IntInsnNode) nodes[0]).operand == 78) {
								InsnList printList = new InsnList();
								VarInsnNode from = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 16);
								VarInsnNode to = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 20);
								printList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
								printList.add(new TypeInsnNode(Opcodes.NEW, "java/lang/StringBuilder"));
								printList.add(new InsnNode(Opcodes.DUP));
								printList.add(new LdcInsnNode("player.sendInterfaceTransform("));
								printList.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, from.var));
								printList.add(new IntInsnNode(Opcodes.BIPUSH, 16));
								printList.add(new InsnNode(Opcodes.ISHR));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, from.var));
								printList.add(new LdcInsnNode(0xFFFF));
								printList.add(new InsnNode(Opcodes.IAND));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, to.var));
								printList.add(new IntInsnNode(Opcodes.BIPUSH, 16));
								printList.add(new InsnNode(Opcodes.ISHR));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, to.var));
								printList.add(new LdcInsnNode(0xFFFF));
								printList.add(new InsnNode(Opcodes.IAND));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(");"));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
								method.queue(to, printList);
							}
						}

						// Interface Text
						it = matcher.match("LDC GETSTATIC IMUL SIPUSH IF_ICMPNE");
						while (it.hasNext()) {
							AbstractInsnNode[] nodes = it.next();
							if (((IntInsnNode) nodes[3]).operand == 244) {
								InsnList printList = new InsnList();
								VarInsnNode hash = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 16);
								VarInsnNode text = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 20);
								printList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
								printList.add(new TypeInsnNode(Opcodes.NEW, "java/lang/StringBuilder"));
								printList.add(new InsnNode(Opcodes.DUP));
								printList.add(new LdcInsnNode("player.sendSetInterfaceText("));
								printList.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, hash.var));
								printList.add(new IntInsnNode(Opcodes.BIPUSH, 16));
								printList.add(new InsnNode(Opcodes.ISHR));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, hash.var));
								printList.add(new LdcInsnNode(0xFFFF));
								printList.add(new InsnNode(Opcodes.IAND));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", \""));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ALOAD, text.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode("\");"));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
								method.queue(text, printList);
							}
						}

						// Interface Settings
						it = matcher.match("SIPUSH LDC GETSTATIC IMUL IF_ICMPNE");
						while (it.hasNext()) {
							AbstractInsnNode[] nodes = it.next();
							if (((IntInsnNode) nodes[0]).operand == 169) {
								InsnList printList = new InsnList();
								VarInsnNode to = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 16);
								VarInsnNode settings = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 34);
								VarInsnNode hash = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 38);
								VarInsnNode from = (VarInsnNode) method.insn().get(method.insn().indexOf(nodes[0]) + 42);
								printList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
								printList.add(new TypeInsnNode(Opcodes.NEW, "java/lang/StringBuilder"));
								printList.add(new InsnNode(Opcodes.DUP));
								printList.add(new LdcInsnNode("player.sendInterfaceSetClickMask("));
								printList.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, hash.var));
								printList.add(new IntInsnNode(Opcodes.BIPUSH, 16));
								printList.add(new InsnNode(Opcodes.ISHR));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, hash.var));
								printList.add(new LdcInsnNode(0xFFFF));
								printList.add(new InsnNode(Opcodes.IAND));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, from.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, to.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(", "));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new VarInsnNode(Opcodes.ILOAD, settings.var));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
								printList.add(new LdcInsnNode(");"));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false));
								printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
								method.queue(from, printList);
							}
						}

						// CS2 Scripts
						it = matcher.match("LDC GETSTATIC IMUL BIPUSH IF_ICMPNE");
						while (it.hasNext()) {
							AbstractInsnNode[] nodes = it.next();
							if (((IntInsnNode) nodes[3]).operand == 42) {
								InsnList printList = new InsnList();
								AbstractInsnNode node = nodes[0];
								while ((node = node.getNext()) != null && node.getOpcode() != Opcodes.ANEWARRAY)
									;
								VarInsnNode params = (VarInsnNode) node.getNext();

								Iterator<AbstractInsnNode[]> xIt = matcher.match("GETSTATIC BIPUSH INVOKEVIRTUAL INVOKESPECIAL AASTORE");
								while (xIt.hasNext()) {
									AbstractInsnNode[] arrays = xIt.next();
									if (((IntInsnNode) arrays[1]).operand == -110) {
										printList.add(new VarInsnNode(Opcodes.ALOAD, params.var));
										printList.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "com/friz/applet/GameApplet", "dumpCS2Scripts", "([Ljava/lang/Object;)V", false));
										method.queue(arrays[4], printList);
									}
								}

							}
						}

						method.insert();
					}

				}

			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.friz.asm.Transformer#log()
	 */
	@Override
	public void log() {
		// TODO Auto-generated method stub

	}

}
