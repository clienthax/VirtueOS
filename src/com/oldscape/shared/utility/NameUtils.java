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
package com.oldscape.shared.utility;

/**
 * @author Im Frizzy <skype:kfriz1998>
 * @since Sep 30, 2014
 */
public class NameUtils {

    static char[] characters = {'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static long hash(CharSequence name) {
        long hash = 0L;
        int size = name.length();
        for (int index = 0; index < size; index++) {
            hash *= 37L;
            char c = name.charAt(index);
            if (c >= 'A' && c <= 'Z') {
                hash += '\001' + c - 'A';
            } else if (c >= 'a' && c <= 'z') {
                hash += '\001' + c - 'a';
            } else if (c >= '0' && c <= '9') {
                hash += c + '\033' - '0';
            }
            if (hash >= 177917621779460413L) {
                break;
            }
        }
        for (/**/; 0L == hash % 37L && 0L != hash; hash /= 37L) {
            /* empty */
        }
        return hash;
    }

    public static String unhash(long hash) {
        if (hash <= 0L || hash >= 6582952005840035281L) {
            return null;
        }
        if (hash % 37L == 0L) {
            return null;
        }
        int size = 0;
        for (long l_13_ = hash; 0L != l_13_; l_13_ /= 37L) {
            size++;
        }
        StringBuilder name = new StringBuilder(size);
        while (hash != 0L) {
            long l_14_ = hash;
            hash /= 37L;
            char c = characters[(int) (l_14_ - hash * 37L)];
            if (c == '_') {
                int prevIndex = name.length() - 1;
                name.setCharAt(prevIndex, Character.toUpperCase(name.charAt(prevIndex)));
                c = '\u00a0';
            }
            name.append(c);
        }
        name.reverse();
        name.setCharAt(0, Character.toUpperCase(name.charAt(0)));
        return name.toString();
    }

    /**
     * Formats a requested {@link String} for protocol services.
     *
     * @param string The {@link String} to format.
     * @return The {@link String}.
     */
    public static String protocol(String name) {
        if (name == null) {
            return null;
        }
        StringBuilder output = new StringBuilder();
        name = name.trim();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                output.append(Character.toLowerCase(c));
            } else if (c >= 'a' && c <= 'z') {
                output.append(c);
            } else if (c >= '0' && c <= '9') {
                output.append(c);
            } else {
                output.append('_');
            }
        }
        if (output.length() == 0) {
            return null;
        }
        return output.toString();
    }

    /**
     * Formats a requested {@link String} for display services.
     *
     * @param name The {@link String} to format.
     * @return The {@link String}.
     */
    public static String display(String name) {
        if (name == null) {
            return "";
        }
        name = name.replaceAll("_", " ").toLowerCase();
        StringBuilder displayName = new StringBuilder();
        boolean wasSpace = true;
        for (int i = 0; i < name.length(); i++) {
            if (wasSpace) {
                displayName.append(("" + name.charAt(i)).toUpperCase());
                wasSpace = false;
            } else {
                displayName.append(name.charAt(i));
            }
            if (name.charAt(i) == ' ') {
                wasSpace = true;
            }
        }
        return displayName.toString();
    }
}
