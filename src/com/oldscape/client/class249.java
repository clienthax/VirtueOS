package com.oldscape.client;

public class class249 {

	static final void method4501(String var0) {
		PacketNode var1 = WorldMapRectangle.method280(ClientPacket.field2471, Client.field957.field1484);
		var1.packetBuffer.putByte(WorldMapRegion.getLength(var0));
		var1.packetBuffer.putString(var0);
		Client.field957.method2052(var1);
	}
}
