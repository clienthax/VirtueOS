package com.oldscape.client;

import java.lang.management.GarbageCollectorMXBean;

class IndexStoreActionHandler implements Runnable {
   public static final Deque IndexStoreActionHandler_requestQueue;
   public static final Deque IndexStoreActionHandler_responseQueue;
   static IndexedSprite field3398;
   public static int field3401;
   public static final Object IndexStoreActionHandler_lock;
   static int field3399;
   static GarbageCollectorMXBean field3402;

   static {
      IndexStoreActionHandler_requestQueue = new Deque();
      IndexStoreActionHandler_responseQueue = new Deque();
      field3401 = 0;
      IndexStoreActionHandler_lock = new Object();
   }

   public void run() {
      try {
         while(true) {
            final FileSystem var1;
            synchronized(IndexStoreActionHandler_requestQueue) {
               var1 = (FileSystem)IndexStoreActionHandler_requestQueue.getFront();
            }

            Object var14;
            if(var1 != null) {
               if(var1.type == 0) {
                  var1.index.write((int)var1.hash, var1.field3367, var1.field3367.length);
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     var1.unlink();
                  }
               } else if(var1.type == 1) {
                  var1.field3367 = var1.index.read((int)var1.hash);
                  synchronized(IndexStoreActionHandler_requestQueue) {
                     IndexStoreActionHandler_responseQueue.addFront(var1);
                  }
               }

               synchronized(IndexStoreActionHandler_lock) {
                  if(field3401 <= 1) {
                     field3401 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  field3401 = 600;
               }
            } else {
               ScriptVarType.method11(100L);
               synchronized(IndexStoreActionHandler_lock) {
                  if(field3401 <= 1) {
                     field3401 = 0;
                     IndexStoreActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3401;
               }
            }
         }
      } catch (final Exception var13) {
         Signlink.processClientError(null, var13);
      }
   }

   static boolean method4629() {
      return class132.Viewport_containsMouse;
   }
}
