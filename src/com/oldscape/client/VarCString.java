package com.oldscape.client;

public class VarCString extends CacheableNode {
   public static IndexDataBase field3481;
   public static NodeCache field3480;
   public boolean field3479;

   static {
      field3480 = new NodeCache(64);
   }

   public VarCString() {
      this.field3479 = false;
   }

   public void method4787(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4788(var1, var2);
      }
   }

   void method4788(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3479 = true;
      }

   }
}
