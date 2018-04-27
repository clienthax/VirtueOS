package com.oldscape.client;

public class Name implements Comparable {

	String name;

	String cleanName;

	public Name(String var1, JagexLoginType var2) {
		this.name = var1;
		this.cleanName = class57.method861(var1, var2);
	}

	public String getName() {
		return this.name;
	}

	public boolean isCleanNameValid() {
		return this.cleanName != null;
	}

	public int compareCleanName(Name var1) {
		return this.cleanName == null ? (var1.cleanName == null ? 0 : 1)
				: (var1.cleanName == null ? -1 : this.cleanName.compareTo(var1.cleanName));
	}

	@Override
	public boolean equals(Object var1) {
		if (var1 instanceof Name) {
			Name var2 = (Name) var1;
			return this.cleanName == null ? var2.cleanName == null
					: (var2.cleanName == null ? false
							: (this.hashCode() != var2.hashCode() ? false : this.cleanName.equals(var2.cleanName)));
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.cleanName == null ? 0 : this.cleanName.hashCode();
	}

	@Override
	public String toString() {
		return this.getName();
	}

	@Override
	public int compareTo(Object var1) {
		return this.compareCleanName((Name) var1);
	}

	public static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
		return var0.equals("B") ? Byte.TYPE
				: (var0.equals("I") ? Integer.TYPE
						: (var0.equals("S") ? Short.TYPE
								: (var0.equals("J") ? Long.TYPE
										: (var0.equals("Z") ? Boolean.TYPE
												: (var0.equals("F") ? Float.TYPE
														: (var0.equals("D") ? Double.TYPE
																: (var0.equals("C") ? Character.TYPE
																		: (var0.equals("void") ? Void.TYPE
																				: Class.forName(var0)))))))));
	}
}
