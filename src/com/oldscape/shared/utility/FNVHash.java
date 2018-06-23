/**
 * Copyright (c) 2015 Virtue Studios
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
package com.oldscape.shared.utility;

import java.math.BigInteger;

/**
 * Generates Fowler-Noll-Vo hashes, which comes in 32 and 64 bit flavors
 * <p>
 * FNV_1: multiply xor FNV_1a: xor multiply
 *
 * @author Jake Douglas
 * @author Kyle Friz
 */
public class FNVHash {

    /**
     * The FNV Basis 32-Bit hash
     */
    private static final BigInteger INIT32 = new BigInteger("811c9dc5", 16);

    /**
     * The FNV Basis 64-Bit hash
     */
    private static final BigInteger INIT64 = new BigInteger("cbf29ce484222325", 16);

    /**
     * The FNV Prime for 32-Bit hashes
     */
    private static final BigInteger PRIME32 = new BigInteger("01000193", 16);

    /**
     * The FNV Prime for 64-Bit hashes
     */
    private static final BigInteger PRIME64 = new BigInteger("100000001b3", 16);

    /**
     * The FNV Mod for 64-Bit hashes
     */
    private static final BigInteger MOD32 = new BigInteger("2").pow(32);

    /**
     * The FNV Mod for 64-Bit hashes
     */
    private static final BigInteger MOD64 = new BigInteger("2").pow(64);

    /**
     * Generates a FNV_1 32-Bit hash
     *
     * @param string The String to hash
     * @return The BigInteger hash
     */
    public static String fnv1_32(String string) {
        BigInteger hash = INIT32;

        for (byte b : string.getBytes()) {
            hash = hash.multiply(PRIME32).mod(MOD32);
            hash = hash.xor(BigInteger.valueOf(b & 0xff));
        }

        return new String(hash.toByteArray());
    }

    /**
     * Generates a FNV_1 64-Bit hash
     *
     * @param string The String to hash
     * @return The BigInteger hash
     */
    public static String fnv1_64(String string) {
        BigInteger hash = INIT64;

        for (byte b : string.getBytes()) {
            hash = hash.multiply(PRIME64).mod(MOD64);
            hash = hash.xor(BigInteger.valueOf(b & 0xff));
        }

        return new String(hash.toByteArray());
    }

    /**
     * Generates a FNV_1a 32-Bit hash
     *
     * @param string The String to hash
     * @return The BigInteger hash
     */
    public static String fnv1a_32(String string) {
        BigInteger hash = INIT32;

        for (byte b : string.getBytes()) {
            hash = hash.xor(BigInteger.valueOf(b & 0xff));
            hash = hash.multiply(PRIME32).mod(MOD32);
        }

        return new String(hash.toByteArray());
    }

    /**
     * Generates a FNV_1a 64-Bit hash
     *
     * @param string The String to hash
     * @return The BigInteger hash
     */
    public static String fnv1a_64(String string) {
        BigInteger hash = INIT64;

        for (byte b : string.getBytes()) {
            hash = hash.xor(BigInteger.valueOf(b & 0xff));
            hash = hash.multiply(PRIME64).mod(MOD64);
        }

        return new String(hash.toByteArray());
    }
}