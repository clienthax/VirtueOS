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
package com.oldscape.tool.asm.bytecode.insn;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;

/**
 * Several utility methods related to instruction nodes.
 *
 * @author Graham Edgecombe
 */
public final class InsnNodeUtils {

    /**
     * Default private constructor to prevent instantiation.
     */
    private InsnNodeUtils() {

    }

    /**
     * Creates a numeric push instruction.
     *
     * @param num The number to push.
     * @return The instruction node.
     */
    public static AbstractInsnNode createNumericPushInsn(Number num) {
        long value = num.longValue();
        if (value == -1) {
            return new InsnNode(Opcodes.ICONST_M1);
        } else if (value == 0) {
            return new InsnNode(Opcodes.ICONST_0);
        } else if (value == 1) {
            return new InsnNode(Opcodes.ICONST_1);
        } else if (value == 2) {
            return new InsnNode(Opcodes.ICONST_2);
        } else if (value == 3) {
            return new InsnNode(Opcodes.ICONST_3);
        } else if (value == 4) {
            return new InsnNode(Opcodes.ICONST_4);
        } else if (value == 5) {
            return new InsnNode(Opcodes.ICONST_5);
        } else if (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE) {
            return new IntInsnNode(Opcodes.BIPUSH, (int) value);
        } else if (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) {
            return new IntInsnNode(Opcodes.SIPUSH, (int) value);
        } else if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
            return new LdcInsnNode((int) value);
        } else {
            return new LdcInsnNode(/* (long) */value);
        }
    }

    /**
     * Reads the value of a numeric push instruction (which can be an
     * {@code ICONST_*} instruction, an {@code BIPUSH} instruction, an
     * {@code SIPUSH} instruction or a {@code LDC_*} instruction.
     *
     * @param push The instruction node.
     * @return The numeric value.
     */
    public static long getNumericPushValue(AbstractInsnNode push) {
        if (push instanceof InsnNode) {
            switch (push.getOpcode()) {
                case Opcodes.ICONST_M1:
                    return -1;
                case Opcodes.ICONST_0:
                    return 0;
                case Opcodes.ICONST_1:
                    return 1;
                case Opcodes.ICONST_2:
                    return 2;
                case Opcodes.ICONST_3:
                    return 3;
                case Opcodes.ICONST_4:
                    return 4;
                case Opcodes.ICONST_5:
                    return 5;
                default:
                    throw new AssertionError();
            }
        } else if (push instanceof IntInsnNode) {
            return ((IntInsnNode) push).operand;
        } else {
            return ((Number) ((LdcInsnNode) push).cst).longValue();
        }
    }

    /**
     * Finds the next non-psuedo node following the specified node.
     *
     * @param node The node.
     * @return The next non-psuedo node, or {@code null} if the end of the
     * instruction list is reached.
     */
    public static AbstractInsnNode nextNonPsuedoNode(AbstractInsnNode node) {
        while ((node = node.getNext()) != null && node.getOpcode() == -1)
            ;
        return node;
    }

    /**
     * Finds the previous non-psuedo node following the specified node.
     *
     * @param node The node.
     * @return The previous non-psuedo node, or {@code null} if the start of the
     * instruction list is reached.
     */
    public static AbstractInsnNode previousNonPsuedoNode(AbstractInsnNode node) {
        while ((node = node.getPrevious()) != null && node.getOpcode() == -1)
            ;
        return node;
    }

    /**
     * Finds the next psuedo node following the specified node.
     *
     * @param node The node.
     * @return The next psuedo node, or {@code null} if the end of the
     * instruction list is reached.
     */
    public static AbstractInsnNode nextPsuedoNode(AbstractInsnNode node) {
        while ((node = node.getNext()) != null && node.getOpcode() != -1)
            ;
        return node;
    }

    /**
     * Finds the previous psuedo node following the specified node.
     *
     * @param node The node.
     * @return The previous psuedo node, or {@code null} if the start of the
     * instruction list is reached.
     */
    public static AbstractInsnNode previousPsuedoNode(AbstractInsnNode node) {
        while ((node = node.getPrevious()) != null && node.getOpcode() != -1)
            ;
        return node;
    }

}
