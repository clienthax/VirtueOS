package com.oldscape.client;

public final class WorldMapRectangle {
   public static FriendManager friendManager;
   int worldMapRegionWidth;
   int worldMapRegionHeight;
   int worldMapRegionX;
   int worldMapRegionY;
   // $FF: synthetic field
   final WorldMapManager this$0;

   WorldMapRectangle(WorldMapManager var1) {
      this.this$0 = var1;
   }

   public static PacketNode method280(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2 = ServerPacket.method3433();
      var2.clientPacket = var0;
      var2.field2503 = var0.packetLength;
      if(var2.field2503 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2503 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2503 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2503 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2505 = 0;
      return var2;
   }

   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class18.method146(var3):var3;
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   static void method279(int var0, String var1) {
      int var2 = class93.playerIndexesCount;
      int[] var3 = class93.playerIndices;
      boolean var4 = false;
      Name var5 = new Name(var1, GZipDecompressor.loginType);

      for(int var6 = 0; var6 < var2; ++var6) {
         Player var7 = Client.cachedPlayers[var3[var6]];
         if(var7 != null && var7 != SoundTaskDataProvider.localPlayer && var7.name != null && var7.name.equals(var5)) {
            PacketNode var8;
            if(var0 == 1) {
               var8 = method280(ClientPacket.field2401, Client.field957.field1484);
               var8.packetBuffer.method3542(0);
               var8.packetBuffer.method3551(var3[var6]);
               Client.field957.method2052(var8);
            } else if(var0 == 4) {
               var8 = method280(ClientPacket.field2431, Client.field957.field1484);
               var8.packetBuffer.putByte(0);
               var8.packetBuffer.putShort(var3[var6]);
               Client.field957.method2052(var8);
            } else if(var0 == 6) {
               var8 = method280(ClientPacket.field2472, Client.field957.field1484);
               var8.packetBuffer.putByte(0);
               var8.packetBuffer.method3551(var3[var6]);
               Client.field957.method2052(var8);
            } else if(var0 == 7) {
               var8 = method280(ClientPacket.field2391, Client.field957.field1484);
               var8.packetBuffer.putShort(var3[var6]);
               var8.packetBuffer.method3542(0);
               Client.field957.method2052(var8);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class57.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
