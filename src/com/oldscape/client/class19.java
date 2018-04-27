package com.oldscape.client;

import java.util.Comparator;

final class class19 implements Comparator {
   static IndexFile indexStore255;
   static SpritePixels[] mapMarkers;

   int method155(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field292 < var2.field292?-1:(var1.field292 == var2.field292?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method155((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public static int method167(String var0) {
      return var0.length() + 2;
   }

   public static void method166(int var0, int var1, int var2, boolean var3) {
      PacketNode var4 = WorldMapRectangle.method280(ClientPacket.field2457, Client.field957.field1484);
      var4.packetBuffer.method3559(var3?Client.field970:0);
      var4.packetBuffer.method3528(var0);
      var4.packetBuffer.method3543(var2);
      var4.packetBuffer.putShort(var1);
      Client.field957.method2052(var4);
   }
}
