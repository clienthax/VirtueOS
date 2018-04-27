package com.oldscape.shared.utility;

/**
 * @author Graham
 */
public final class Base37Utils {

	public static String decodeBase37(long value) {
		char[] chars = new char[12];
		int pos = 0;
		while (value != 0) {
			int remainder = (int) (value % 37);
			value /= 37;

			char c;
			if (remainder >= 1 && remainder <= 26)
				c = (char) ('a' + remainder - 1);
			else if (remainder >= 27 && remainder <= 36)
				c = (char) ('0' + remainder - 27);
			else
				c = '_';

			chars[chars.length - pos++ - 1] = c;
		}
		return new String(chars, chars.length - pos, pos);
	}

	public static long encodeBase37(String str) {
		int len = str.length();
		if (len > 12)
			throw new IllegalArgumentException("String too long.");

		long value = 0;
		for (int pos = 0; pos < len; pos++) {
			char c = str.charAt(pos);
			value *= 37;

			if (c >= 'A' && c <= 'Z')
				value += c - 'A' + 1;
			else if (c >= 'a' && c <= 'z')
				value += c - 'a' + 1;
			else if (c >= '0' && c <= '9')
				value += c - '0' + 27;
			else if (c != ' ' && c != '_')
				throw new IllegalArgumentException("Illegal character in string: " + c + ".");
		}

		while (value != 0 && (value % 37) == 0)
			value /= 37;

		return value;
	}
}
