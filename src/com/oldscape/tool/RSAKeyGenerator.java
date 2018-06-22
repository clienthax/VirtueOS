/**
 * Copyright (c) 2014 Virtue Studios
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
package com.oldscape.tool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * @author Im Frizzy <skype:kfriz1998>
 * @since Jul 19, 2014
 */
public class RSAKeyGenerator {

    /**
     * The location of the file which will contain the private key.
     */
    private static String privateFile = "./RSAPrivateKeys.txt";

    /**
     * The location of the file which will contain the public key.
     */
    private static String publicFile = "./RSAPublicKeys.txt";

    /**
     * NOTE: Do not use initialize(512), ondemand does not work then
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            KeyFactory ondemand_factory = KeyFactory.getInstance("RSA");
            KeyPairGenerator ondemand_keygen = KeyPairGenerator.getInstance("RSA");
            ondemand_keygen.initialize(2048);// 15360
            KeyPair ondemand_keypair = ondemand_keygen.genKeyPair();

            KeyFactory login_factory = KeyFactory.getInstance("RSA");
            KeyPairGenerator login_keygen = KeyPairGenerator.getInstance("RSA");
            login_keygen.initialize(2048);
            KeyPair login_keypair = login_keygen.genKeyPair();

            RSAPrivateKeySpec ondemand_privateSpec = ondemand_factory.getKeySpec(ondemand_keypair.getPrivate(), RSAPrivateKeySpec.class);

            RSAPublicKeySpec ondemand_publicSpec = ondemand_factory.getKeySpec(ondemand_keypair.getPublic(), RSAPublicKeySpec.class);

            RSAPrivateKeySpec login_privateSpec = login_factory.getKeySpec(login_keypair.getPrivate(), RSAPrivateKeySpec.class);

            RSAPublicKeySpec login_publicSpec = login_factory.getKeySpec(login_keypair.getPublic(), RSAPublicKeySpec.class);

            writeKey(privateFile, ondemand_privateSpec.getModulus(), ondemand_privateSpec.getPrivateExponent(), login_privateSpec.getModulus(), login_privateSpec.getPrivateExponent());

            writeKey(publicFile, ondemand_publicSpec.getModulus(), ondemand_publicSpec.getPublicExponent(), login_publicSpec.getModulus(), login_publicSpec.getPublicExponent());

        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the key (public/private) to the specified file.
     *
     * @param file     The file.
     * @param modulus  The modulus of the key.
     * @param exponent The exponent of the key.
     */
    public static void writeKey(String file, BigInteger ondemand_modulus, BigInteger ondemand_exponent,
                                BigInteger login_modulus, BigInteger login_exponent) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("/**");
            writer.newLine();
            writer.write(" * The OnDemand Modulus RSA Key");
            writer.newLine();
            writer.write(" */");
            writer.newLine();
            writer.write("public static final BigInteger ONDEMAND_MODULUS = new BigInteger(\"" + ondemand_modulus.toString() + "\");");
            writer.newLine();
            writer.newLine();
            writer.write("/**");
            writer.newLine();
            writer.write(" * The OnDemand Exponent RSA Key");
            writer.newLine();
            writer.write(" */");
            writer.newLine();
            writer.write("public static final BigInteger ONDEMAND_EXPONENT = new BigInteger(\"" + ondemand_exponent.toString() + "\");");
            writer.newLine();
            writer.newLine();
            writer.write("/**");
            writer.newLine();
            writer.write(" * The Login Modulus RSA Key");
            writer.newLine();
            writer.write(" */");
            writer.newLine();
            writer.write("public static final BigInteger LOGIN_MODULUS = new BigInteger(\"" + login_modulus.toString() + "\");");
            writer.newLine();
            writer.newLine();
            writer.write("/**");
            writer.newLine();
            writer.write(" * The Login Exponent RSA Key");
            writer.newLine();
            writer.write(" */");
            writer.newLine();
            writer.write("public static final BigInteger LOGIN_EXPONENT = new BigInteger(\"" + login_exponent.toString() + "\");");
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}