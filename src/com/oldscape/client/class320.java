package com.oldscape.client;

class class320 {
   private static final class320 field3935;
   static final class320 field3933;
   private static final class320 field3934;
   final int id;

   static {
      field3935 = new class320(0);
      field3933 = new class320(1);
      field3934 = new class320(2);
   }

   private class320(final int var1) {
      this.id = var1;
   }

   static class320 method1(final int var0) {
      final class320[] var1 = method5386();

      for (final class320 var3 : var1) {
         if (var0 == var3.id) {
            return var3;
         }
      }

      return null;
   }

   static class320[] method5386() {
      return new class320[]{field3933, field3935, field3934};
   }

}
