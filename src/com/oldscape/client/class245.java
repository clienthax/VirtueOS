package com.oldscape.client;

public class class245 implements class244 {

	public static final class245 field2976;

	public static final class245 field2969;

	public static final class245 field2965;

	public static final class245 field2970;

	public static final class245 field2967;

	public static final class245 field2968;

	public static final class245 field2971;

	public static final class245 field2966;

	static final class245 field2963;

	public static final class245 field2972;

	static int field2975;

	public final int field2973;

	static {
		field2976 = new class245("", 10);
		field2969 = new class245("", 11);
		field2965 = new class245("", 12);
		field2970 = new class245("", 13);
		field2967 = new class245("", 14);
		field2968 = new class245("", 15, new ScriptVarType[] { ScriptVarType.field47, ScriptVarType.field47 },
				(ScriptVarType[]) null);
		field2971 = new class245("", 16, new ScriptVarType[] { ScriptVarType.field47, ScriptVarType.field47 },
				(ScriptVarType[]) null);
		field2966 = new class245("", 17, new ScriptVarType[] { ScriptVarType.field47, ScriptVarType.field47 },
				(ScriptVarType[]) null);
		field2963 = new class245("", 73, true, true);
		field2972 = new class245("", 76, true, false);
	}

	class245(String var1, int var2) {
		this(var1, var2, false, (ScriptVarType[]) null, false, (ScriptVarType[]) null);
	}

	class245(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
		this.field2973 = var2;
	}

	class245(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
		this(var1, var2, var3 != null, var3, var4 != null, var4);
	}

	class245(String var1, int var2, boolean var3, boolean var4) {
		this(var1, var2, var3, (ScriptVarType[]) null, var4, (ScriptVarType[]) null);
	}

	@Override
	public int rsOrdinal() {
		return this.field2973;
	}
}
