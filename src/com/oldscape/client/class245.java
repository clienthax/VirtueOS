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
   private static final class245 field2963;
   public static final class245 field2972;
   static int field2975;
   public final int ordinal;

   static {
      field2976 = new class245("", 10);
      field2969 = new class245("", 11);
      field2965 = new class245("", 12);
      field2970 = new class245("", 13);
      field2967 = new class245("", 14);
      field2968 = new class245("", 15, new ScriptVarType[]{ScriptVarType.field47, ScriptVarType.field47}, null);
      field2971 = new class245("", 16, new ScriptVarType[]{ScriptVarType.field47, ScriptVarType.field47}, null);
      field2966 = new class245("", 17, new ScriptVarType[]{ScriptVarType.field47, ScriptVarType.field47}, null);
      field2963 = new class245("", 73, true, true);
      field2972 = new class245("", 76, true, false);
   }

   private class245(final String var1, final int var2) {
      this(var1, var2, false, null, false, null);
   }

   private class245(final String var1, final int var2, final boolean var3, final ScriptVarType[] var4, final boolean var5, final ScriptVarType[] var6) {
      this.ordinal = var2;
   }

   private class245(final String var1, final int var2, final ScriptVarType[] var3, final ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   private class245(final String var1, final int var2, final boolean var3, final boolean var4) {
      this(var1, var2, var3, null, var4, null);
   }

   public int rsOrdinal() {
      return this.ordinal;
   }
}
