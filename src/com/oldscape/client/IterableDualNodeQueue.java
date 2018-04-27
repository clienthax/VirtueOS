package com.oldscape.client;

import java.util.Iterator;

public class IterableDualNodeQueue implements Iterable {
   public CacheableNode sentinel;
   CacheableNode field2674;

   public IterableDualNodeQueue() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   public void clear() {
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.unlinkDual();
      }

   }

   public void add(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   CacheableNode method4104() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.unlinkDual();
         return var1;
      }
   }

   CacheableNode method4118() {
      return this.method4106((CacheableNode)null);
   }

   CacheableNode method4106(CacheableNode var1) {
      CacheableNode var2;
      if(var1 == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
         this.field2674 = null;
         return null;
      } else {
         this.field2674 = var2.previous;
         return var2;
      }
   }

   CacheableNode method4107() {
      CacheableNode var1 = this.field2674;
      if(var1 == this.sentinel) {
         this.field2674 = null;
         return null;
      } else {
         this.field2674 = var1.previous;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class226(this);
   }
}
