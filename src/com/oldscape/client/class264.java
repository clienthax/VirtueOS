package com.oldscape.client;

import java.util.zip.CRC32;

public class class264 {
   public static class169 NetCache_socket;
   static int field3416;
   static HashTable NetCache_pendingPriorityWrites;
   public static int NetCache_pendingPriorityWritesCount;
   static HashTable NetCache_pendingPriorityResponses;
   public static int NetCache_pendingPriorityResponsesCount;
   static Node2LinkedList NetCache_pendingWritesQueue;
   static HashTable NetCache_pendingWrites;
   public static int NetCache_pendingWritesCount;
   static HashTable NetCache_pendingResponses;
   public static int NetCache_pendingResponsesCount;
   static boolean field3419;
   static Buffer NetCache_responseHeaderBuffer;
   static int field3426;
   static CRC32 NetCache_crc;
   static IndexData[] NetCache_indexCaches;
   static byte field3429;
   public static int field3430;
   public static int field3431;

   static {
      field3416 = 0;
      NetCache_pendingPriorityWrites = new HashTable(4096);
      NetCache_pendingPriorityWritesCount = 0;
      NetCache_pendingPriorityResponses = new HashTable(32);
      NetCache_pendingPriorityResponsesCount = 0;
      NetCache_pendingWritesQueue = new Node2LinkedList();
      NetCache_pendingWrites = new HashTable(4096);
      NetCache_pendingWritesCount = 0;
      NetCache_pendingResponses = new HashTable(4096);
      NetCache_pendingResponsesCount = 0;
      NetCache_responseHeaderBuffer = new Buffer(8);
      field3426 = 0;
      NetCache_crc = new CRC32();
      NetCache_indexCaches = new IndexData[256];
      field3429 = 0;
      field3430 = 0;
      field3431 = 0;
   }

   static final void method4683(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         OwnWorldComparator.method1247(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1151 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   static void method4682(byte[] var0, int var1) {
      if(Client.field908 == null) {
         Client.field908 = new byte[24];
      }

      class205.method3828(var0, var1, Client.field908, 0, 24);
   }
}
