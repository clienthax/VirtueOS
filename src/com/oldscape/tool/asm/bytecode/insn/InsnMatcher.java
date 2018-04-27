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
package com.oldscape.tool.asm.bytecode.insn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.util.Printer;

/**
 * A flexible instruction matcher, which uses regular expressions (as well as an
 * optional user-defined constraint) to locate sequences of instructions in an
 * {@link InsnList}.
 * 
 * @author Graham Edgecombe
 */
public final class InsnMatcher {

	/**
	 * A {@link Constraint} can check a match if additional criteria, that are
	 * not possible with regular expressions, must be used.
	 * 
	 * @author Graham Edgecombe
	 */
	public static interface Constraint {

		/**
		 * Checks if the match satisfies this constraint.
		 * 
		 * @param match
		 *            The instructions that were matched.
		 * @return {@code true} if so, {@code false} if not.
		 */
		public boolean satisfies(AbstractInsnNode[] match);

	}

	/**
	 * A {@link Constraint} which always satisfies every match.
	 */
	private static final Constraint SATISFY_ALL_CONSTRAINT = new Constraint() {

		@Override
		public boolean satisfies(AbstractInsnNode[] match) {
			return true;
		}

	};

	/**
	 * Contains groups of instructions which are converted to the appropriate
	 * regular expression automatically.
	 */
	private static final Map<String, int[]> groups = new HashMap<>();

	/**
	 * Populates the group map.
	 */
	static {
		groups.put("insnnode", new int[] { Opcodes.NOP, Opcodes.ACONST_NULL,
				Opcodes.ICONST_M1, Opcodes.ICONST_0, Opcodes.ICONST_1,
				Opcodes.ICONST_2, Opcodes.ICONST_3, Opcodes.ICONST_4,
				Opcodes.ICONST_5, Opcodes.LCONST_0, Opcodes.LCONST_1,
				Opcodes.FCONST_0, Opcodes.FCONST_1, Opcodes.FCONST_2,
				Opcodes.DCONST_0, Opcodes.DCONST_1, Opcodes.IALOAD,
				Opcodes.LALOAD, Opcodes.FALOAD, Opcodes.DALOAD, Opcodes.AALOAD,
				Opcodes.BALOAD, Opcodes.CALOAD, Opcodes.SALOAD,
				Opcodes.IASTORE, Opcodes.LASTORE, Opcodes.FASTORE,
				Opcodes.DASTORE, Opcodes.AASTORE, Opcodes.BASTORE,
				Opcodes.CASTORE, Opcodes.SASTORE, Opcodes.POP, Opcodes.POP2,
				Opcodes.DUP, Opcodes.DUP_X1, Opcodes.DUP_X2, Opcodes.DUP2,
				Opcodes.DUP2_X1, Opcodes.DUP2_X2, Opcodes.SWAP, Opcodes.IADD,
				Opcodes.LADD, Opcodes.FADD, Opcodes.DADD, Opcodes.ISUB,
				Opcodes.LSUB, Opcodes.FSUB, Opcodes.DSUB, Opcodes.IMUL,
				Opcodes.LMUL, Opcodes.FMUL, Opcodes.DMUL, Opcodes.IDIV,
				Opcodes.LDIV, Opcodes.FDIV, Opcodes.DDIV, Opcodes.IREM,
				Opcodes.LREM, Opcodes.FREM, Opcodes.DREM, Opcodes.INEG,
				Opcodes.LNEG, Opcodes.FNEG, Opcodes.DNEG, Opcodes.ISHL,
				Opcodes.LSHL, Opcodes.ISHR, Opcodes.LSHR, Opcodes.IUSHR,
				Opcodes.LUSHR, Opcodes.IAND, Opcodes.LAND, Opcodes.IOR,
				Opcodes.LOR, Opcodes.IXOR, Opcodes.LXOR, Opcodes.I2L,
				Opcodes.I2F, Opcodes.I2D, Opcodes.L2I, Opcodes.L2F,
				Opcodes.L2D, Opcodes.F2I, Opcodes.F2L, Opcodes.F2D,
				Opcodes.D2I, Opcodes.D2L, Opcodes.D2F, Opcodes.I2B,
				Opcodes.I2C, Opcodes.I2S, Opcodes.LCMP, Opcodes.FCMPL,
				Opcodes.FCMPG, Opcodes.DCMPL, Opcodes.DCMPG, Opcodes.IRETURN,
				Opcodes.LRETURN, Opcodes.FRETURN, Opcodes.DRETURN,
				Opcodes.ARETURN, Opcodes.RETURN, Opcodes.ARRAYLENGTH,
				Opcodes.ATHROW, Opcodes.MONITORENTER, Opcodes.MONITOREXIT });
		groups.put("intinsnnode", new int[] { Opcodes.BIPUSH, Opcodes.SIPUSH,
				Opcodes.NEWARRAY });
		groups.put("varinsnnode", new int[] { Opcodes.ILOAD, Opcodes.LLOAD,
				Opcodes.FLOAD, Opcodes.DLOAD, Opcodes.ALOAD, Opcodes.ISTORE,
				Opcodes.LSTORE, Opcodes.FSTORE, Opcodes.DSTORE, Opcodes.ASTORE,
				Opcodes.RET });
		groups.put("typeinsnnode", new int[] { Opcodes.NEW, Opcodes.ANEWARRAY,
				Opcodes.CHECKCAST, Opcodes.INSTANCEOF });
		groups.put("fieldinsnnode", new int[] { Opcodes.GETSTATIC,
				Opcodes.PUTSTATIC, Opcodes.GETFIELD, Opcodes.PUTFIELD });
		groups.put("methodinsnnode", new int[] { Opcodes.INVOKEVIRTUAL,
				Opcodes.INVOKESPECIAL, Opcodes.INVOKESTATIC,
				Opcodes.INVOKEINTERFACE, Opcodes.INVOKEDYNAMIC });
		groups.put("jumpinsnnode", new int[] { Opcodes.IFEQ, Opcodes.IFNE,
				Opcodes.IFLT, Opcodes.IFGE, Opcodes.IFGT, Opcodes.IFLE,
				Opcodes.IF_ICMPEQ, Opcodes.IF_ICMPNE, Opcodes.IF_ICMPLT,
				Opcodes.IF_ICMPGE, Opcodes.IF_ICMPGT, Opcodes.IF_ICMPLE,
				Opcodes.IF_ACMPEQ, Opcodes.IF_ACMPNE, Opcodes.GOTO,
				Opcodes.JSR, Opcodes.IFNULL, Opcodes.IFNONNULL });
		groups.put("ldcinsnnode", new int[] { Opcodes.LDC });
		groups.put("iincinsnnode", new int[] { Opcodes.IINC });
		groups.put("tableswitchinsnnode", new int[] { Opcodes.TABLESWITCH });
		groups.put("lookupswitchinsnnode", new int[] { Opcodes.LOOKUPSWITCH });
		groups.put("multianewarrayinsnnode",
				new int[] { Opcodes.MULTIANEWARRAY });

		// TODO perhaps have a wider variety of groups like BCEL does
		// (e.g. IfInstruction, ConstantPushInstruction, etc)
		groups.put("iconst", new int[] { Opcodes.ICONST_M1, Opcodes.ICONST_0,
				Opcodes.ICONST_1, Opcodes.ICONST_2, Opcodes.ICONST_3,
				Opcodes.ICONST_4, Opcodes.ICONST_5 });
		groups.put("pushinstruction", new int[] { Opcodes.ACONST_NULL,
				Opcodes.ALOAD, Opcodes.ILOAD, Opcodes.LLOAD, Opcodes.FLOAD,
				Opcodes.DLOAD, Opcodes.BIPUSH, Opcodes.SIPUSH, Opcodes.LDC,
				Opcodes.DUP, Opcodes.DUP2, Opcodes.GETSTATIC, Opcodes.LCONST_0,
				Opcodes.LCONST_1, Opcodes.FCONST_0, Opcodes.FCONST_1,
				Opcodes.FCONST_2, Opcodes.DCONST_0, Opcodes.DCONST_1 });
		groups.put("invokeinstruction", new int[] { Opcodes.INVOKEDYNAMIC,
				Opcodes.INVOKEINTERFACE, Opcodes.INVOKESPECIAL,
				Opcodes.INVOKESTATIC, Opcodes.INVOKEVIRTUAL });
		groups.put("ifinstruction", new int[] { Opcodes.IFEQ, Opcodes.IFNE,
				Opcodes.IFLT, Opcodes.IFGE, Opcodes.IFGT, Opcodes.IFLE,
				Opcodes.IF_ICMPEQ, Opcodes.IF_ICMPNE, Opcodes.IF_ICMPLT,
				Opcodes.IF_ICMPGE, Opcodes.IF_ICMPGT, Opcodes.IF_ICMPLE,
				Opcodes.IF_ACMPEQ, Opcodes.IF_ACMPNE, Opcodes.IFNULL,
				Opcodes.IFNONNULL });
	}

	/**
	 * Converts an instruction to character(s) used to build the regular
	 * expression.
	 * 
	 * @param name
	 *            The name of the instruction.
	 * @return The character(s) which represents this instruction.
	 * @throws IllegalArgumentException
	 *             if the name was not found.
	 */
	private static String insToChars(String name) {
		for (int i = 0; i < Printer.OPCODES.length; i++) {
			if (name.equalsIgnoreCase(Printer.OPCODES[i])) {
				return new String(new char[] { opcodeToChar(i) });
			}
		}

		int[] group = groups.get(name.toLowerCase());
		if (group != null) {
			StringBuilder bldr = new StringBuilder("(");
			for (int i = 0; i < group.length; i++) {
				bldr.append(opcodeToChar(group[i]));
				if (i != group.length - 1)
					bldr.append("|");
			}
			bldr.append(")");
			return bldr.toString();
		}

		if (name.equalsIgnoreCase("AbstractInsnNode")) {
			return ".";
		}

		throw new IllegalArgumentException(name + " is not an instruction.");
	}

	/**
	 * Converts an opcode to a character. This adds 32768 to the operation code
	 * so that the character is well above the latin character set, which avoids
	 * the use of characters with special meaning in the regular expression
	 * syntax.
	 * 
	 * @param opcode
	 *            The opcode.
	 * @return The character.
	 */
	private static char opcodeToChar(int opcode) {
		return (char) (opcode + 32768);
	}

	/**
	 * Converts a readable pattern which uses instruction mnemonics to the
	 * internal character-based format used when actually attempting to find
	 * matches.
	 * 
	 * @param expr
	 *            The readable pattern.
	 * @return The 'compiled' pattern.
	 */
	private static String compilePattern(String expr) {
		StringBuilder pat = new StringBuilder();
		StringBuilder name = new StringBuilder();
		char[] chars = expr.toCharArray();
		for (char c : chars) {
			if (Character.isLetterOrDigit(c) || c == '_') {
				name.append(c);
			} else {
				if (name.length() > 0) {
					pat.append(insToChars(name.toString()));
					name = new StringBuilder();
				}
				if (!Character.isWhitespace(c)) {
					pat.append(c);
				}
			}
		}
		if (name.length() > 0)
			pat.append(insToChars(name.toString()));
		return pat.toString();
	}

	/**
	 * The instruction list this matcher is matching against.
	 */
	private final InsnList list;

	/**
	 * Creates a new instruction matcher.
	 * 
	 * @param list
	 *            The instruction list this matcher is matching against.
	 */
	public InsnMatcher(InsnList list) {
		this.list = list;
	}

	/**
	 * Matches the specified expression with no constraint.
	 * 
	 * @param expr
	 *            The expression.
	 * @return An {@link Iterator} of {@code {@link AbstractInsnNode}[]}.
	 */
	public Iterator<AbstractInsnNode[]> match(String expr) {
		return match(expr, SATISFY_ALL_CONSTRAINT, false);
	}

	/**
	 * Matches the specified expression with the additional constraint.
	 * 
	 * @param expr
	 *            The expression.
	 * @param constraint
	 *            The constraint.
	 * @return An {@link Iterator} of {@code {@link AbstractInsnNode}[]}.
	 */
	public Iterator<AbstractInsnNode[]> match(String expr, Constraint constraint) {
		return match(expr, constraint, false);
	}

	/**
	 * Matches the specified expression with no constraint. The instruction list
	 * is searched in reverse.
	 * 
	 * @param expr
	 *            The expression.
	 * @return An {@link Iterator} of {@code {@link AbstractInsnNode}[]}.
	 */
	public Iterator<AbstractInsnNode[]> reverseMatch(String expr) {
		return match(expr, SATISFY_ALL_CONSTRAINT, true);
	}

	/**
	 * Matches the specified expression with the additional constraint. The
	 * instruction list is searched in reverse.
	 * 
	 * @param expr
	 *            The expression.
	 * @param constraint
	 *            The constraint.
	 * @return An {@link Iterator} of {@code {@link AbstractInsnNode}[]}.
	 */
	public Iterator<AbstractInsnNode[]> reverseMatch(String expr,
			Constraint constraint) {
		return match(expr, constraint, false);
	}

	/**
	 * Matches the specified expression with the additional constraint.
	 * 
	 * @param expr
	 *            The expression.
	 * @param constraint
	 *            The constraint.
	 * @param reverse
	 *            If the list should be reversed.
	 * @return An {@link Iterator} of {@code {@link AbstractInsnNode}[]}.
	 */
	@SuppressWarnings("unchecked")
	private Iterator<AbstractInsnNode[]> match(String expr,
			Constraint constraint, boolean reverse) {
		List<AbstractInsnNode[]> matches = new ArrayList<>();
		String charList = listToChars();
		if (reverse)
			charList = new StringBuilder(charList).reverse().toString();

		Pattern regex = Pattern.compile(compilePattern(expr));
		Matcher matcher = regex.matcher(charList);

		while (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			AbstractInsnNode[] match = new AbstractInsnNode[end - start];

			int ptr = 0;
			for (Iterator<AbstractInsnNode> it = list.iterator(); it.hasNext();) {
				AbstractInsnNode node = it.next();
				if (node.getOpcode() != -1) {
					if (ptr >= start && ptr < end) {
						match[ptr - start] = node;
					}
					ptr++;
				}
			}

			if (constraint.satisfies(match))
				matches.add(match);
		}

		return matches.iterator();
	}

	/**
	 * Converts the instruction list to the internal character format.
	 * 
	 * @return The string of characters which represent this instruction list.
	 */
	@SuppressWarnings("unchecked")
	private String listToChars() {
		StringBuilder bldr = new StringBuilder();
		for (Iterator<AbstractInsnNode> it = list.iterator(); it.hasNext();) {
			int opcode = it.next().getOpcode();
			if (opcode != -1)
				bldr.append(opcodeToChar(opcode));
		}
		return bldr.toString();
	}

}
