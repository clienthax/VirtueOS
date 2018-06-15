package com.oldscape.shared.utility;

/**
 * Created by Sean on 13/02/2015.
 */
public class StringUtils {

    private static final char[] CHAR_ARRAY = new char[]{
            8364, 0, 8218, 65533, 8222, 8230, 8224, 8225, 65533, 8240, 65533, 8249,
            65533, 0, 711, 0, 0, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 65533,
            8482, 65533, 8250, 65533, 0, 731, 65533
    };

    public static String decodeString(byte[] buffer, int offset, int stringLength) {
        final char[] chars = new char[stringLength];
        int count = 0;
        for (int i = 0; i < stringLength; i++) {
            int length = buffer[i + offset] & 0xFF;
            if (length != 0) {
                if ((length >= 128) && (length < 160)) {
                    char ref = CHAR_ARRAY[length - 128];
                    if (ref == 0) {
                        ref = 63;
                    }
                    length = ref;
                }
                chars[count++] = (char) length;
            }
        }
        return new String(chars, 0, count);
    }

    public static final String replaceAll(String text, String from, String to) {
        for (int toReplaceIndex = text.indexOf(from); toReplaceIndex != -1; toReplaceIndex = text.indexOf(from, toReplaceIndex + to.length())) {
            text = new StringBuilder(text.substring(0, toReplaceIndex)).append(to).append(text.substring(toReplaceIndex + from.length())).toString();
        }
        return text;
    }

}
