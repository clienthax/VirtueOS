package com.oldscape.client;

public class MouseRecorder implements Runnable {
   public static Widget[][] widgets;
   static int[] field819;
   static IndexData indexMaps;
   static IndexData indexCache15;
   boolean isRunning;
   Object lock;
   int index;
   int[] xs;
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; ScriptVarType.method11(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.mouseLastX;
               this.ys[this.index] = MouseInput.mouseLastY;
               ++this.index;
            }
         }
      }

   }

   static void method1145() {
      if(WorldMapDecorationType.loadWorlds()) {
         class90.worldSelectShown = true;
      }

   }
}
