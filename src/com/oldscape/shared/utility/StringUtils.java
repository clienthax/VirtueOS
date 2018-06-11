package com.oldscape.shared.utility;

/**
 * Created by Sean on 13/02/2015.
 */
public class StringUtils {


    static final String replaceAll(String text, final String from, final String to) {
        for (int toReplaceIndex = text.indexOf(from); toReplaceIndex != -1; toReplaceIndex = text.indexOf(from, toReplaceIndex + to.length())) {
            text = new StringBuilder(text.substring(0, toReplaceIndex)).append(to).append(text.substring(toReplaceIndex + from.length())).toString();
        }
        return text;
    }

}
