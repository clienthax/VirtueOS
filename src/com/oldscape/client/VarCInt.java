package com.oldscape.client;

public class VarCInt extends CacheableNode {
   static IndexDataBase field3476;
   static NodeCache field3475;
   public boolean field3474;

   static {
      field3475 = new NodeCache(64);
   }

   VarCInt() {
      this.field3474 = false;
   }

   void method4773(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4774(var1, var2);
      }
   }

   void method4774(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3474 = true;
      }

   }

   static String method4785(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
