package com.oldscape.client;

import java.lang.ref.SoftReference;

public class class219 extends class224 {
   SoftReference field2659;

   class219(Object var1, int var2) {
      super(var2);
      this.field2659 = new SoftReference(var1);
   }

   Object vmethod4084() {
      return this.field2659.get();
   }

   boolean vmethod4087() {
      return true;
   }
}
