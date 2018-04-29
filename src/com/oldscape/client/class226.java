package com.oldscape.client;

import java.util.Iterator;

class class226 implements Iterator {
   private final IterableDualNodeQueue field2671;
   private CacheableNode field2672;
   private CacheableNode field2673;

   class226(final IterableDualNodeQueue var1) {
      this.field2673 = null;
      this.field2671 = var1;
      this.field2672 = this.field2671.sentinel.previous;
   }

   public Object next() {
      CacheableNode node = this.field2672;
      if(node == this.field2671.sentinel) {
         node = null;
         this.field2672 = null;
      } else {
         this.field2672 = node.previous;
      }

      this.field2673 = node;
      return node;
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
