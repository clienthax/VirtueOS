/**
 * Copyright (c) 2015 Kyle Friz & Kayla Friz
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
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
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 22, 2015
 */
public class TextFormat {

    public static String formatLastLogin(long days) {
        if (days == 0)
            return "Earlier Today<col=000000>.";
        else if (days == 1)
            return "Yesterday<col=000000>.";

        return days + "<col=000000> Days Ago.";
    }

    public static String formatMembershipLeft(long days) {
        if (days == 0 || days < 0)
            return "You are not a member.";

        return String.valueOf(days);
    }

}
