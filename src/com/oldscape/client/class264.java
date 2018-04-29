package com.oldscape.client;

import java.util.zip.CRC32;

class class264 {
   static class169 NetCache_socket;
   static int field3416;
   static final HashTable NetCache_pendingPriorityWrites;
   static int NetCache_pendingPriorityWritesCount;
   static final HashTable NetCache_pendingPriorityResponses;
   static int NetCache_pendingPriorityResponsesCount;
   static final Node2LinkedList NetCache_pendingWritesQueue;
   static final HashTable NetCache_pendingWrites;
   static int NetCache_pendingWritesCount;
   static final HashTable NetCache_pendingResponses;
   static int NetCache_pendingResponsesCount;
   static boolean field3419;
   static final Buffer NetCache_responseHeaderBuffer;
   static int field3426;
   static final CRC32 NetCache_crc;
   static final IndexData[] NetCache_indexCaches;
   static byte field3429;
   static int field3430;
   static int field3431;

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

   static void method4683(final int spawnPlane, final int x, final int y, final int spawnType, final int spawnId, final int var5, final int spawnOrientation, final int spawnDelay, final int spawnHitpoints) {
      PendingSpawn spawn = null;

      for(PendingSpawn pendingSpawn = (PendingSpawn)Client.pendingSpawns.getFront(); pendingSpawn != null; pendingSpawn = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(spawnPlane == pendingSpawn.level && pendingSpawn.x == x && y == pendingSpawn.y && spawnType == pendingSpawn.type) {
            spawn = pendingSpawn;
            break;
         }
      }

      if(spawn == null) {
         spawn = new PendingSpawn();
         spawn.level = spawnPlane;
         spawn.type = spawnType;
         spawn.x = x;
         spawn.y = y;
         OwnWorldComparator.method1247(spawn);
         Client.pendingSpawns.addFront(spawn);
      }

      spawn.id = spawnId;
      spawn.field1151 = var5;
      spawn.orientation = spawnOrientation;
      spawn.delay = spawnDelay;
      spawn.hitpoints = spawnHitpoints;
   }

   static void method4682(final byte[] var0, final int var1) {
      if(Client.field908 == null) {
         Client.field908 = new byte[24];
      }

      class205.method3828(var0, var1, Client.field908, 0, 24);
   }
}
