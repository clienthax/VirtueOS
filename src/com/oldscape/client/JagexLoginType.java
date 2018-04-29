package com.oldscape.client;

public class JagexLoginType {
   public static final JagexLoginType field4069;
   private static final JagexLoginType field4065;
   private static final JagexLoginType field4072;
   private static final JagexLoginType field4067;
   private static final JagexLoginType field4066;
   private static final JagexLoginType field4075;
   private static final JagexLoginType field4064;
   private static final JagexLoginType field4071;
   public static final JagexLoginType field4070;
   public final int field4073;
   private final String identifier;

   static {
      field4069 = new JagexLoginType(8, 0, "", "");
      field4065 = new JagexLoginType(1, 1, "", "");
      field4072 = new JagexLoginType(0, 2, "", "");
      field4067 = new JagexLoginType(2, 3, "", "");
      field4066 = new JagexLoginType(3, 4, "", "");
      field4075 = new JagexLoginType(6, 5, "", "");
      field4064 = new JagexLoginType(7, 6, "", "");
      field4071 = new JagexLoginType(5, 7, "", "");
      field4070 = new JagexLoginType(4, -1, "", "", true, new JagexLoginType[]{field4069, field4065, field4072, field4066, field4067});
   }

   private JagexLoginType(final int var1, final int var2, final String var3, final String var4) {
      this.field4073 = var1;
      this.identifier = var4;
   }

   private JagexLoginType(final int var1, final int var2, final String var3, final String var4, final boolean var5, final JagexLoginType[] var6) {
      this.field4073 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
