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
package com.oldscape.tool.asm.transformers;

import com.oldscape.tool.asm.Transformer;
import com.oldscape.tool.asm.bytecode.Container;
import com.oldscape.tool.asm.bytecode.element.ClassElement;
import com.oldscape.tool.asm.bytecode.element.MethodElement;
import com.oldscape.tool.asm.bytecode.insn.InsnMatcher;
import com.oldscape.tool.asm.bytecode.insn.InsnNodeUtils;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;

import java.util.Iterator;
import java.util.logging.Logger;

/**
 * @author Kyle Friz
 * @since Mar 13, 2015
 */
public class LdcTransformer extends Transformer {

    /**
     * The {@link Logger} instance
     */
    private static Logger logger = Logger.getLogger(LdcTransformer.class.getName());

    private final boolean rsa;
    private final boolean cache;
    private final boolean others;

    public LdcTransformer(Container container, boolean r, boolean c, boolean o) {
        super(container);
        this.rsa = r;
        this.cache = c;
        this.others = o;
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
                for (Iterator<AbstractInsnNode[]> it = matcher.match("LDC"); it.hasNext(); ) {
                    LdcInsnNode node = (LdcInsnNode) it.next()[0];

                    if (rsa) {

                        /** Changes Jagex's Modulus RSA Key */
                        if (String.valueOf(node.cst).length() > 250) {

                            /**
                             * Note: You could also just change the BIPUSH of
                             * 16, to 10, since 10 is the default radix
                             */

                            /**
                             * Finds the BIPUSH Insn to remove the radix Jagex
                             * uses
                             */
                            AbstractInsnNode next = InsnNodeUtils.nextNonPsuedoNode(node);
                            if (next instanceof IntInsnNode) {
                                if (((IntInsnNode) next).getOpcode() == Opcodes.BIPUSH) {

                                    /**
                                     * Finds the BigInteger.<init>(String,
                                     * Integer) Constructor, to remove the radix
                                     * parameter
                                     */
                                    AbstractInsnNode nextNode = InsnNodeUtils.nextNonPsuedoNode(next);
                                    if (nextNode instanceof MethodInsnNode) {
                                        MethodInsnNode invoke = (MethodInsnNode) nextNode;

                                        /**
                                         * Changes the description of the
                                         * constructor's parameters
                                         */
                                        if (invoke.desc.equals("(Ljava/lang/String;I)V")) {
                                            invoke.desc = "(Ljava/lang/String;)V";
                                        }
                                    }

                                    /**
                                     * Removes the BIPUSH Insn from the method,
                                     * remove the radix
                                     */
                                    method.insn().remove(next);
                                    pInc(0);
                                }
                            }

                            /**
                             * Replaces the Ldc Insn containing Jagex's Modulus
                             * RSA Key
                             */
                            method.insn().set(node, new LdcInsnNode(
                                    "165865706435016682110653568563251120094278686912987295809145491806194715902716739338411927793058925228087565434562948389222225588420069703784252638483569608159614392485969864899137973999614056797405232846059198315441808544524190866210655169682670028293787208173603935453834899795395794572295868565624049196373"));
                            pInc(0);

                            /** Changes Jagex's Exponent RSA Key */
                        } else if (node.cst.equals("65537")) {

                            /**
                             * Note: You could also just change the BIPUSH of
                             * 16, to 10, since 10 is the default radix
                             */

                            /**
                             * Finds the BIPUSH Insn to remove the radix Jagex
                             * uses
                             */
                            AbstractInsnNode next = InsnNodeUtils.nextNonPsuedoNode(node);
                            if (next instanceof IntInsnNode) {
                                if (((IntInsnNode) next).getOpcode() == Opcodes.BIPUSH) {

                                    /**
                                     * Finds the BigInteger.<init>(String,
                                     * Integer) Constructor, to remove the radix
                                     * parameter
                                     */
                                    AbstractInsnNode nextNode = InsnNodeUtils.nextNonPsuedoNode(next);
                                    if (nextNode instanceof MethodInsnNode) {
                                        MethodInsnNode invoke = (MethodInsnNode) nextNode;

                                        /**
                                         * Changes the description of the
                                         * constructor's parameters
                                         */
                                        if (invoke.desc.equals("(Ljava/lang/String;I)V")) {
                                            invoke.desc = "(Ljava/lang/String;)V";
                                        }
                                    }

                                    /**
                                     * Removes the BIPUSH Insn from the method,
                                     * remove the radix
                                     */
                                    method.insn().remove(next);
                                    pInc(0);
                                }
                            }

                            /**
                             * Replaces the Ldc Insn containing Jagex's Exponent
                             * RSA Key
                             */
                            method.insn().set(node, new LdcInsnNode("65537"));
                            pInc(0);
                        } else {
                            tInc(0);
                        }

                    }

                    if (cache) {

                        /** Changes Jagex's cache directory */
                        if (node.cst.equals("jagexcache")) {
                            method.insn().set(node, new LdcInsnNode("virtuecache"));
                            pInc(0);

                            /** Changes the name of the GameType */
                        } else if (node.cst.equals("oldschool")) {
                            method.insn().set(node, new LdcInsnNode("virtueos"));
                            pInc(0);

                            /** Changes the name of the GameType */
                        } else if (node.cst.equals("runescape")) {
                            method.insn().set(node, new LdcInsnNode("virtuers"));
                            pInc(0);
                        } else if (node.cst.equals("jagex_cl_oldschool_")) {
                            method.insn().set(node, new LdcInsnNode("vs_cl_virtueos_"));
                            pInc(0);
                        } else if (node.cst.equals("jagex_cl_runescape_")) {
                            method.insn().set(node, new LdcInsnNode("vs_cl_virtuers_"));
                            pInc(0);
                        }

                    }

                    if (others) {

                        /** Changes the OSRS Create Account Link */
                        if (node.cst.equals("m=account-creation/g=oldscape/create_account_funnel.ws")) {

                            method.insn().set(node, new LdcInsnNode("/register-link"));
                            pInc(0);

                        } else if (node.cst.equals("secure")) {
                            method.insn().set(node, new LdcInsnNode(""));
                        } else if (node.cst.equals(".mechscape.com")) {

                            method.insn().set(node, new LdcInsnNode("127.0.0.1"));

                            /** Changes the site URL the client uses */
                        } else if (node.cst.equals("runescape.com")) {

                            if (node.getNext().getOpcode() != Opcodes.ASTORE)
                                continue;

                            /**
                             * Removes the extra parameters Jagex uses for
                             * secure connections on Creating a New Account
                             */

                            /**
                             * The start index to begin removing instructions
                             */
                            int beginIndex = -1;

                            /**
                             * The ending index to stop removing instructions
                             */
                            int endIndex = -1;

                            /**
                             * Loops through the method's instruction list, to
                             * find the being and ending index
                             */
                            for (AbstractInsnNode insn : method.insn().toArray()) {
                                if (insn instanceof LdcInsnNode) {
                                    LdcInsnNode ldc = (LdcInsnNode) insn;
                                    if (ldc.cst.equals("/l=")) {

                                        beginIndex = method.insn().indexOf(ldc) - 1;
                                    } else if (ldc.cst.equals(".")) {

                                        /** Removes the dot */
                                        ldc.cst = "";
                                    } else if (ldc.cst.equals("/")) {

                                        /**
                                         * +1 beacause of the MethodInsnNode
                                         * called after this, to add an Ldc to
                                         * the StringBuidler
                                         */
                                        endIndex = method.insn().indexOf(ldc) + 1;
                                    }
                                }
                            }

                            /**
                             * Loops gathers all the instructions, from the
                             * starting index to the ending index
                             */
                            AbstractInsnNode[] nodes = new AbstractInsnNode[endIndex - beginIndex];
                            for (int i = beginIndex; i < endIndex; i++)
                                nodes[i - beginIndex] = method.insn().get(i);

                            /**
                             * Loops through the instructions grabbed and
                             * removes them
                             */
                            for (AbstractInsnNode insn : nodes) {
                                method.insn().remove(insn);
                                pInc(0);
                            }

                            method.insn().set(node, new LdcInsnNode("localhost"));
                            pInc(0);
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
        logger.info("Changed " + pointer(0) + " out of " + total(0) + " (" + percent(0) + "%) Instructions.");
    }
}
