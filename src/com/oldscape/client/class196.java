package com.oldscape.client;

public class class196 {
   static long field2587;

   static void method3744() {
      if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
         class90.field1386 = 1;
      } else {
         class90.field1386 = 0;
      }

   }

   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class167.dat2File != null) {
         var4 = new IndexFile(var0, class167.dat2File, Size.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, class19.indexStore255, var0, var1, var2, var3);
   }
}
