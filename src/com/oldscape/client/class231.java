package com.oldscape.client;

public class class231 extends Node {
   int field2734;
   class233 field2722;
   RawAudioNode field2729;
   class228 field2724;
   int field2725;
   int field2726;
   int field2727;
   int field2728;
   int field2733;
   int field2730;
   int field2721;
   int field2732;
   int field2731;
   int field2735;
   int field2740;
   int field2736;
   int field2737;
   int field2738;
   class115 field2739;
   int field2723;
   int field2741;

   void method4262() {
      this.field2722 = null;
      this.field2729 = null;
      this.field2724 = null;
      this.field2739 = null;
   }

   static long method4261(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 'A' && var5 <= 'Z') {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 'a' && var5 <= 'z') {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= '0' && var5 <= '9') {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }

   static final void method4265(String var0) {
      StringBuilder var10000 = (new StringBuilder()).append(var0);
      Object var10001 = null;
      String var1 = var10000.append(" is already on your ignore list").toString();
      class57.sendGameMessage(30, "", var1);
   }
}
