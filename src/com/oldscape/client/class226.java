package com.oldscape.client;

import java.util.Iterator;

public class class226 implements Iterator {
   IterableDualNodeQueue field2671;
   CacheableNode field2672;
   CacheableNode field2673;

   class226(IterableDualNodeQueue var1) {
      this.field2673 = null;
      this.field2671 = var1;
      this.field2672 = this.field2671.sentinel.previous;
      this.field2673 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2672;
      if(var1 == this.field2671.sentinel) {
         var1 = null;
         this.field2672 = null;
      } else {
         this.field2672 = var1.previous;
      }

      this.field2673 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2673 == null) {
         throw new IllegalStateException();
      } else {
         this.field2673.unlinkDual();
         this.field2673 = null;
      }
   }

   public boolean hasNext() {
      return this.field2671.sentinel != this.field2672;
   }
}
