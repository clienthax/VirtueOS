package com.oldscape.client;

public abstract class TaskDataNode extends Node {
   volatile boolean field1660;
   TaskDataNode field1658;
   int field1659;
   AbstractIntegerNode0 data;

   protected TaskDataNode() {
      this.field1660 = true;
   }

   protected abstract TaskDataNode vmethod4330();

   protected abstract TaskDataNode vmethod4321();

   protected abstract int vmethod4314();

   protected abstract void vmethod4317(int[] var1, int var2, int var3);

   protected abstract void vmethod4319(int var1);

   int vmethod2491() {
      return 255;
   }

   final void method2495(int[] var1, int var2, int var3) {
      if(this.field1660) {
         this.vmethod4317(var1, var2, var3);
      } else {
         this.vmethod4319(var3);
      }

   }
}
