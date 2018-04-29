package com.oldscape.client;

class VarCString extends CacheableNode {

   static IndexDataBase field3481;
   static final NodeCache field3480;
   boolean field3479;

   static {
      field3480 = new NodeCache(64);
   }

   VarCString() {
      this.field3479 = false;
   }

   public void read(final Buffer buffer) {
      while(true) {
         final int opcode = buffer.readUnsignedByte();
         if(opcode == 0) {
            return;
         }

         this.readNext(opcode);
      }
   }

   private void readNext(final int var2) {
      if(var2 == 2) {
         this.field3479 = true;
      }

   }
}
