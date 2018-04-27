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
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

import com.oldscape.tool.asm.Transformer;
import com.oldscape.tool.asm.bytecode.Container;
import com.oldscape.tool.asm.bytecode.element.ClassElement;
import com.oldscape.tool.asm.bytecode.element.FieldElement;
import com.oldscape.tool.asm.bytecode.element.MethodElement;
import com.oldscape.tool.asm.bytecode.insn.InsnMatcher;
import com.oldscape.tool.asm.bytecode.insn.InsnNodeUtils;

/**
 * @author Kyle Friz
 * @date May 13, 2015
 */
public class SystemPrintTransformer extends Transformer {

	/**
	 * The {@link Logger} instance
	 */
	private static Logger logger = Logger.getLogger(SystemPrintTransformer.class.getName());

	/**
	 * @param container
	 */
	public SystemPrintTransformer(Container container) {
		super(container);
	}

	String[] ePatterns = new String[] {
			"ALOAD GETFIELD ALOAD DUP GETFIELD LDC IADD DUP_X1 PUTFIELD LDC IMUL ICONST_1 ISUB ILOAD ALOAD GETFIELD LDC INVOKEVIRTUAL IADD I2B BASTORE",
			"ALOAD GETFIELD ALOAD DUP GETFIELD LDC IADD DUP_X1 PUTFIELD LDC IMUL ICONST_1 ISUB ALOAD GETFIELD LDC INVOKEVIRTUAL ILOAD IADD I2B BASTORE",
			"ALOAD GETFIELD LDC ALOAD DUP GETFIELD IADD DUP_X1 PUTFIELD LDC IMUL ICONST_1 ISUB ILOAD ALOAD GETFIELD LDC INVOKEVIRTUAL IADD I2B BASTORE",
			"ALOAD GETFIELD LDC ALOAD DUP GETFIELD IADD DUP_X1 PUTFIELD LDC IMUL ICONST_1 ISUB ALOAD GETFIELD LDC INVOKEVIRTUAL ILOAD IADD I2B BASTORE" };

	String[] dPatterns = new String[] {
			"((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)|(IMUL)) ((IMUL)|(IALOAD)) ((IALOAD)|(LDC)) IMUL PUTSTATIC IINC ICONST_M1 LDC",
			"((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)|(IMUL)) ((IMUL)|(IALOAD)) ((IALOAD)|(LDC)) IMUL PUTSTATIC IINC ICONST_M1 GETSTATIC LDC",
			"((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)|(IMUL)) ((IMUL)|(IALOAD)) ((IALOAD)|(LDC)) IMUL PUTSTATIC IINC LDC",
			"((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)) ((LDC)|(GETSTATIC)|(IMUL)) ((IMUL)|(IALOAD)) ((IALOAD)|(LDC)) IMUL PUTSTATIC IINC GETSTATIC LDC" };

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oldscape.tool.asm.Transformer#transform()
	 */
	@Override
	public void transform() {
		/** Loops through all the classes */
		for (ClassElement element : container().elements()) {
			/** Loops through all the methods of each class */
			for (MethodElement method : element.methods()) {
				/** Invokes a new Instruction Regex matcher */
				InsnMatcher matcher = new InsnMatcher(method.insn());
				/** Matches the instruction regex, returns an Iterator */
				Iterator<AbstractInsnNode[]> it;
				/** Prints the Outbound Frame */
				/** Class: RSBitBuffer, Method: writeCipheredByte(I,I)V */
				int eMatch = 0;
				do {
					it = matcher.match(ePatterns[eMatch]);
					eMatch++;

					if (eMatch == ePatterns.length)
						break;

				} while (!it.hasNext());
				if (it.hasNext()) {
					/** Grabs the array of AbstractInsn */
					AbstractInsnNode[] nodes = it.next();

					/** Begining index */
					// AbstractInsnNode begin = nodes[nodes.length - 1];
					/** Buffer's Pointer field location */
					FieldInsnNode pointFld = (nodes[4] instanceof FieldInsnNode ? (FieldInsnNode) nodes[4]
							: (FieldInsnNode) nodes[5]);
					/** Pointer's multiplicative inverse */
					LdcInsnNode pointInv = (LdcInsnNode) nodes[9];

					if (!element.containsField("lastFrame", "I")) {
						FieldNode fieldF = new FieldNode(Opcodes.ASM5, Opcodes.ACC_PRIVATE, "lastFrame", "I", null, new Integer(0));
						FieldElement fF = new FieldElement(element, fieldF);
						element.addField(fF);
					}
					// TODO Size Calculation needs work
					if (!element.containsField("lastPointer", "I")) {
						FieldNode fieldP = new FieldNode(Opcodes.ASM5, Opcodes.ACC_PRIVATE, "lastPointer", "I", null, new Integer(0));
						FieldElement fP = new FieldElement(element, fieldP);
						element.addField(fP);
					}

					/** Invokes a new InsnList */
					InsnList printList = new InsnList();
					/** Grabs the print IO Stream */
					printList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
					/** Invokes a new StringBuilder reference */
					printList.add(new TypeInsnNode(Opcodes.NEW, "java/lang/StringBuilder"));
					/** Duplicate the object reference */
					printList.add(new InsnNode(Opcodes.DUP));
					/** Inserts a String into the print message */
					printList.add(new LdcInsnNode("OutboundFrame: "));
					/** Invokes the <init> constructor */
					printList.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false));
					/** Loads local variable one, ALOAD_0 */
					printList.add(new VarInsnNode(Opcodes.ALOAD, 0));
					/**
					 * Gets the lastFrame field, used for dumping the opcode
					 * with its calculated size
					 */
					printList.add(new FieldInsnNode(Opcodes.GETFIELD, element.name(), "lastFrame", "I"));
					/** Appends the last opcode to the builder */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
					/** Adds the comma ldc */
					printList.add(new LdcInsnNode(", "));
					/** Appends the comma */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
					/** Loads local variable one, ALOAD_0 */
					printList.add(new VarInsnNode(Opcodes.ALOAD, 0));
					/** Gets the Buffer's pointer field */
					printList.add(new FieldInsnNode(Opcodes.GETFIELD, pointFld.owner, pointFld.name, pointFld.desc));
					/** Adds the pointers multiplicative inverse */
					printList.add(new LdcInsnNode(pointInv.cst));
					/** Multiplies the two Integers */
					printList.add(new InsnNode(Opcodes.IMUL));
					/** Loads local variable one, ALOAD_0 */
					printList.add(new VarInsnNode(Opcodes.ALOAD, 0));
					/**
					 * Gets the lastPointer field, used to calculate the size
					 */
					printList.add(new FieldInsnNode(Opcodes.GETFIELD, element.name(), "lastPointer", "I"));
					/**
					 * Subtracts the current buffer's pointer from the last
					 * pointer, in theory, resulting in the size from start of
					 * packet to end
					 */
					printList.add(new InsnNode(Opcodes.ISUB));
					/** Appends the size to the builder */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append",
							"(I)Ljava/lang/StringBuilder;", false));
					/** Casts the StringBuilder into a String */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString",
							"()Ljava/lang/String;", false));
					/** Invokes the println method */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println",
							"(Ljava/lang/String;)V", false));
					/** Inserts the InsnList to the beginning of the method */
					// method.insn().insertBefore(method.insn().getFirst(),
					// printList);

					/** Invokes a new InsnList */
					InsnList putList = new InsnList();
					/** Loads local variable zero, ALOAD_0 */
					putList.add(new VarInsnNode(Opcodes.ALOAD, 0));
					/** Loads local Integer value from variable one, ILOAD_1 */
					putList.add(new VarInsnNode(Opcodes.ILOAD, 1));
					/**
					 * Sets the value of the lastFrame, from the loaded
					 * variables
					 */
					putList.add(new FieldInsnNode(Opcodes.PUTFIELD, element.name(), "lastFrame", "I"));
					/** Loads local variable zero, ALOAD_0 */
					putList.add(new VarInsnNode(Opcodes.ALOAD, 0));
					/** Loads local variable zero, ALOAD_0 */
					putList.add(new VarInsnNode(Opcodes.ALOAD, 0));
					/** Gets the Buffer's pointer field */
					putList.add(new FieldInsnNode(Opcodes.GETFIELD, pointFld.owner, pointFld.name, pointFld.desc));
					/** Adds the pointers multiplicative inverse */
					putList.add(new LdcInsnNode(pointInv.cst));
					/** Multiplies the two Integers */
					putList.add(new InsnNode(Opcodes.IMUL));
					/**
					 * Sets the value of the lastSize, from the calculated
					 * pointer
					 */
					putList.add(new FieldInsnNode(Opcodes.PUTFIELD, element.name(), "lastPointer", "I"));
					/**
					 * Inserts the InsnList starting at index 20 of the nodes
					 */
					// method.insn().insert(begin, putList);
					pInc(0);
				} else {
					tInc(0);
				}

				/** Prints the Inbound Frame */
				/** Class: FrameDecoder, Method: decode(I)Z */
				int dMatch = 0;
				do {
					it = matcher.match(dPatterns[dMatch]);
					dMatch++;
				} while (!it.hasNext() && (dMatch < dPatterns.length));
				if (it.hasNext()) {
					/** Grabs the array of AbstractInsn */
					AbstractInsnNode[] nodes = it.next();

					/** Beginning index */
					AbstractInsnNode begin = nodes[8];
					/** Opcode Field Multiplicative Inverse */
					LdcInsnNode opcodeInv = (nodes[1] instanceof LdcInsnNode ? (LdcInsnNode) nodes[1] : (nodes[2] instanceof LdcInsnNode ? (LdcInsnNode) nodes[2] : (LdcInsnNode) nodes[3]));
					/** Opcode Field location */
					FieldInsnNode opcodeFld = (nodes[2] instanceof FieldInsnNode ? (FieldInsnNode) nodes[2] : (nodes[1] instanceof FieldInsnNode ? (FieldInsnNode) nodes[1] : (FieldInsnNode) nodes[3]));
					/** Size Field Multiplicative Inverse */
					LdcInsnNode sizeInv = (LdcInsnNode) nodes[nodes.length - 1];
					/** Size Field location */
					FieldInsnNode sizeFld = (FieldInsnNode) nodes[7];
					/** The Next Label Node, used for the JumpInsnNode */
					LabelNode labelNode = (LabelNode) begin.getNext();

					/** Invokes a new InsnList */
					InsnList printList = new InsnList();

					/** Inserts the Frame Opcode Inverse Multiplier */
					printList.add(new LdcInsnNode(opcodeInv.cst));
					/** Gets the Frame Opcode field */
					printList.add(new FieldInsnNode(Opcodes.GETSTATIC, opcodeFld.owner, opcodeFld.name, opcodeFld.desc));
					/** Multiplies the Frame Opcode integer value */
					printList.add(new InsnNode(Opcodes.IMUL));
					/** The Opcode of the InboundFrame to ignore */
					printList.add(new IntInsnNode(Opcodes.SIPUSH, -3));
					/**
					 * The IF NOT EQUAL comparison, with the correct Jump Label
					 */
					printList.add(new JumpInsnNode(Opcodes.IF_ICMPEQ, labelNode));

					/** Grabs the print IO Stream */
					printList.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
					/** Invokes a new StringBuilder reference */
					printList.add(new TypeInsnNode(Opcodes.NEW, "java/lang/StringBuilder"));
					/** Duplicate the object reference */
					printList.add(new InsnNode(Opcodes.DUP));
					/** Inserts a String into the print message */
					printList.add(new LdcInsnNode("InboundFrame: "));
					/** Invokes the <init> constructor */
					printList.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V", false));
					/** Inserts the Frame Opcode Inverse Multiplier */
					printList.add(new LdcInsnNode(opcodeInv.cst));
					/** Gets the Frame Opcode field */
					printList.add(new FieldInsnNode(Opcodes.GETSTATIC, opcodeFld.owner, opcodeFld.name, opcodeFld.desc));
					/** Multiplies the Frame Opcode integer value */
					printList.add(new InsnNode(Opcodes.IMUL));
					/** Appends the local variable to the string builder */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
					/** Adds the comma ldc */
					printList.add(new LdcInsnNode(", "));
					/** Appends the comma to the builder */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false));
					/** Inserts the Frame Size Inverse Multiplier */
					printList.add(new LdcInsnNode(sizeInv.cst));
					/** Gets the Frame Size field */
					printList.add(new FieldInsnNode(Opcodes.GETSTATIC, sizeFld.owner, sizeFld.name, sizeFld.desc));
					/** Multiplies the Frame Size integer value */
					printList.add(new InsnNode(Opcodes.IMUL));
					/** Appends the local variable to the string builder */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false));
					/** Casts the StringBuilder into a String */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false));
					/** Invokes the println method */
					printList.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));

					/** Inserts the InsnList starting at index 8 of the nodes */
					method.insn().insert(begin, printList);
					pInc(1);
				} else {
					tInc(1);
				}

				/** Prints the XTEA Keys */
				/** Class: ?, Method: decodeMapFrame(Z, B)V */
				it = matcher.match("GETSTATIC ILOAD ILOAD IASTORE GETSTATIC ILOAD GETSTATIC NEW DUP");
				if (it.hasNext()) {
					/** Grabs the array of AbstractInsn */
					AbstractInsnNode[] nodes = it.next();

					/** Begining index */
					// AbstractInsnNode begin = nodes[0];
					/** Region pointer variable location */
					VarInsnNode rPoint = (VarInsnNode) nodes[1];
					/** RegionID variable location */
					VarInsnNode region = (VarInsnNode) nodes[2];

					/** Matches the xtea keys array */
					Iterator<AbstractInsnNode[]> xIt = matcher.match("MULTIANEWARRAY PUTSTATIC");
					/** Grabs the XTEA Array field location */
					FieldInsnNode keys = (FieldInsnNode) xIt.next()[1];

					/** Invokes a new InsnList */
					InsnList printList = new InsnList();
					/** Loads the RegionID that was calculated by the client */
					printList.add(new VarInsnNode(Opcodes.ILOAD, region.var));
					/** Gets the xtea keys array */
					printList.add(new FieldInsnNode(Opcodes.GETSTATIC, keys.owner, keys.name, keys.desc));
					/**
					 * Loads the Region Pointer, used to select the XTEA Array
					 * for the specified region
					 */
					printList.add(new VarInsnNode(Opcodes.ILOAD, rPoint.var));
					/**
					 * Retrieves the XTEA Array for the specified Region Pointer
					 * val
					 */
					printList.add(new InsnNode(Opcodes.AALOAD));
					/** Invokes the dump methods */
					printList.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "com/friz/applet/GameApplet", "dumpMap",
							"(I[I)V", false));
					/** Inserts the InsnList starting at index 0 of the nodes */
					// method.insn().insertBefore(begin, printList);
					pInc(2);
				} else {
					tInc(2);
				}

				it = matcher.match("NEW DUP ICONST INVOKESPECIAL ASTORE ALOAD BIPUSH");
				while (it.hasNext()) {
					AbstractInsnNode revision = method.insn().get(method.insn().indexOf(it.next()[6]) + 4);
					container().setRevision(InsnNodeUtils.getNumericPushValue(revision));
				}

			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oldscape.tool.asm.Transformer#log()
	 */
	@Override
	public void log() {
		logger.info("Added " + pointer(0) + " out of " + total(0) + " (" + percent(0) + "%) OutboundFrame Print(s)");
		logger.info("Added " + pointer(1) + " out of " + total(1) + " (" + percent(1) + "%) InboundFrame Print(s)");
		logger.info("Added " + pointer(2) + " out of " + total(2) + " (" + percent(2) + "%) XTEA Print(s)");
	}

}
