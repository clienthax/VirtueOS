package com.oldscape.client;

class class228 {
   static int port1;
   byte[] field2680;
   byte[] field2684;
   int field2676;
   int field2679;
   int field2677;
   int field2681;
   int field2682;
   int field2683;
   int field2678;

   public static class279 method4119(final int var0) {
      class279 var1 = (class279)class279.field3553.get(var0);
       if (var1 == null) {
           final byte[] var2 = class279.field3552.getConfigData(34, var0);
           var1 = new class279();
           if (var2 != null) {
               var1.method4937(new Buffer(var2));
           }

           var1.method4925();
           class279.field3553.put(var1, var0);
       }
       return var1;
   }

   public static int method4120(final CharSequence var0) {
      final int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
