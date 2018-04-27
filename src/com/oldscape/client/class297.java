package com.oldscape.client;
import java.util.Comparator;

public abstract class class297 implements Comparator {

	static byte[][][] field3831;

	Comparator field3832;

	final void method5283(Comparator var1) {
		if (this.field3832 == null) {
			this.field3832 = var1;
		} else if (this.field3832 instanceof class297) {
			((class297) this.field3832).method5283(var1);
		}

	}

	protected final int method5282(Nameable var1, Nameable var2) {
		return this.field3832 == null ? 0 : this.field3832.compare(var1, var2);
	}

	@Override
	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public static String method5290(CharSequence var0) {
		int var1 = var0.length();
		StringBuilder var2 = new StringBuilder(var1);

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.'
					&& var4 != '-' && var4 != '*' && var4 != '_') {
				if (var4 == ' ') {
					var2.append('+');
				} else {
					byte var5 = Client.charToByteCp1252(var4);
					var2.append('%');
					int var6 = var5 >> 4 & 15;
					if (var6 >= 10) {
						var2.append((char) (var6 + 55));
					} else {
						var2.append((char) (var6 + 48));
					}

					var6 = var5 & 15;
					if (var6 >= 10) {
						var2.append((char) (var6 + 55));
					} else {
						var2.append((char) (var6 + 48));
					}
				}
			} else {
				var2.append(var4);
			}
		}

		return var2.toString();
	}
}
