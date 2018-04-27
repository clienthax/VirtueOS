package com.oldscape.client;

public class Node {
   public long hash;
   public Node next;
   Node previous;

   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   public boolean linked() {
      return this.previous != null;
   }
}
