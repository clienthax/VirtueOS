package com.oldscape.client;

class class66 {
   static Widget[] field785;

   static String method1132(final byte[] var0, final int var1, final int var2) {
      final StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         final int var5 = var0[var4] & 255;
         var3.append(class317.field3926[var5 >>> 2]);
         if(var4 < var2 - 1) {
            final int var6 = var0[var4 + 1] & 255;
            var3.append(class317.field3926[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               final int var7 = var0[var4 + 2] & 255;
               var3.append(class317.field3926[(var6 & 15) << 2 | var7 >>> 6]).append(class317.field3926[var7 & 63]);
            } else {
               var3.append(class317.field3926[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class317.field3926[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}
