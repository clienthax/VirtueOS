package com.oldscape.client;

import java.awt.FontMetrics;

class ChatLineBuffer {
   static FontMetrics field1479;
   private final MessageNode[] lines;
   private int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   MessageNode addMessage(final int var1, final String var2, final String var3, final String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   MessageNode getMessage(final int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   int size() {
      return this.length;
   }
}
