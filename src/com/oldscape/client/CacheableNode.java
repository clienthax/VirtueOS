package com.oldscape.client;

public class CacheableNode extends Node {
   long field2658;
   public CacheableNode previous;
   public CacheableNode next;

   public void unlinkDual() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
