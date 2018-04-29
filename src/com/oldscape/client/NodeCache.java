package com.oldscape.client;

public final class NodeCache {

   private CacheableNode field2638;
   private final int capacity;
   private int remainingCapacity;
   private final HashTable table;
   private final Node2LinkedList list;

   public NodeCache(final int var1) {
      this.field2638 = new CacheableNode();
      this.list = new Node2LinkedList();
      this.capacity = var1;
      this.remainingCapacity = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
      }

      this.table = new HashTable(var2);
   }

   public CacheableNode get(final long var1) {
      final CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         this.list.push(var3);
      }

      return var3;
   }

   public void remove(final long var1) {
      final CacheableNode var3 = (CacheableNode)this.table.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.remainingCapacity;
      }

   }

   public void put(final CacheableNode var1, final long var2) {
      if(this.remainingCapacity == 0) {
         CacheableNode var4 = this.list.pop();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.field2638) {
            var4 = this.list.pop();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.remainingCapacity;
      }

      this.table.put(var1, var2);
      this.list.push(var1);
   }

   public void reset() {
      this.list.clear();
      this.table.clear();
      this.field2638 = new CacheableNode();
      this.remainingCapacity = this.capacity;
   }
}
