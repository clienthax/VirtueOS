package com.oldscape.client;

import java.net.URL;

public enum WorldMapDecorationType implements Enumerated {
   field2992(0, 0),
   field3003(1, 0),
   field2986(2, 0),
   field2989(3, 0),
   field2990(9, 2),
   field2991(4, 1),
   field2995(5, 1),
   field3006(6, 1),
   field2994(7, 1),
   field3009(8, 1),
   field2996(12, 2),
   field2997(13, 2),
   field3007(14, 2),
   field2999(15, 2),
   field3000(16, 2),
   field3001(17, 2),
   field3002(18, 2),
   field2987(19, 2),
   field3004(20, 2),
   field3005(21, 2),
   field2988(10, 2),
   field2993(11, 2),
   field3008(22, 3);

   public final int rsOrdinal;

   WorldMapDecorationType(final int var3, final int var4) {
      this.rsOrdinal = var3;
   }

   public int rsOrdinal() {
      return this.rsOrdinal;
   }

   static boolean loadWorlds() {
      try {
         if(Client.listFetcher == null) {
            Client.listFetcher = MapIconReference.urlRequester.request(new URL(Client.field876));
         } else if(Client.listFetcher.isDone()) {
            final byte[] var0 = Client.listFetcher.getResponse();
            final Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            World.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = World.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            WorldMapType1.method308(World.worldList, 0, World.worldList.length - 1, World.field1230, World.field1229);
            Client.listFetcher = null;
            return true;
         }
      } catch (final Exception var4) {
         var4.printStackTrace();
         Client.listFetcher = null;
      }

      return false;
   }

   public static void method4499() {
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
   }
}
