package com.oldscape.client;

public class class100 extends TaskDataNode {
   private final Deque field1497;
   private final Deque field1499;
   private int field1498;
   private int field1496;

   public class100() {
      this.field1497 = new Deque();
      this.field1499 = new Deque();
      this.field1498 = 0;
      this.field1496 = -1;
   }

   public final synchronized void method2059(final TaskDataNode var1) {
      this.field1497.addTail(var1);
   }

   public final synchronized void method2060(final TaskDataNode var1) {
      var1.unlink();
   }

   private void method2075() {
      if(this.field1498 > 0) {
         for(class112 var1 = (class112)this.field1499.getFront(); var1 != null; var1 = (class112)this.field1499.getNext()) {
            var1.field1610 -= this.field1498;
         }

         this.field1496 -= this.field1498;
         this.field1498 = 0;
      }

   }

   private void method2062(Node var1, final class112 var2) {
      while(this.field1499.head != var1 && ((class112)var1).field1610 <= var2.field1610) {
         var1 = var1.next;
      }

      Deque.method4011(var2, var1);
      this.field1496 = ((class112)this.field1499.head.next).field1610;
   }

   private void method2087(final class112 var1) {
      var1.unlink();
      var1.method2293();
      final Node var2 = this.field1499.head.next;
      if(var2 == this.field1499.head) {
         this.field1496 = -1;
      } else {
         this.field1496 = ((class112)var2).field1610;
      }

   }

   protected TaskDataNode vmethod4330() {
      return (TaskDataNode)this.field1497.getFront();
   }

   protected TaskDataNode vmethod4321() {
      return (TaskDataNode)this.field1497.getNext();
   }

   protected int vmethod4314() {
      return 0;
   }

   public final synchronized void vmethod4317(final int[] var1, int var2, int var3) {
      do {
         if(this.field1496 < 0) {
            this.method2089(var1, var2, var3);
            return;
         }

         if(var3 + this.field1498 < this.field1496) {
            this.field1498 += var3;
            this.method2089(var1, var2, var3);
            return;
         }

         final int var4 = this.field1496 - this.field1498;
         this.method2089(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1498 += var4;
         this.method2075();
         final class112 var5 = (class112)this.field1499.getFront();
         synchronized(var5) {
            final int var7 = var5.method2290();
            if(var7 < 0) {
               var5.field1610 = 0;
               this.method2087(var5);
            } else {
               var5.field1610 = var7;
               this.method2062(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   private void method2089(final int[] var1, final int var2, final int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1497.getFront(); var4 != null; var4 = (TaskDataNode)this.field1497.getNext()) {
         var4.method2495(var1, var2, var3);
      }

   }

   public final synchronized void vmethod4319(int var1) {
      do {
         if(this.field1496 < 0) {
            this.method2070(var1);
            return;
         }

         if(this.field1498 + var1 < this.field1496) {
            this.field1498 += var1;
            this.method2070(var1);
            return;
         }

         final int var2 = this.field1496 - this.field1498;
         this.method2070(var2);
         var1 -= var2;
         this.field1498 += var2;
         this.method2075();
         final class112 var3 = (class112)this.field1499.getFront();
         synchronized(var3) {
            final int var5 = var3.method2290();
            if(var5 < 0) {
               var3.field1610 = 0;
               this.method2087(var3);
            } else {
               var3.field1610 = var5;
               this.method2062(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   private void method2070(final int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1497.getFront(); var2 != null; var2 = (TaskDataNode)this.field1497.getNext()) {
         var2.vmethod4319(var1);
      }

   }
}
