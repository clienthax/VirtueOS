package com.oldscape.client;
import java.awt.Image;
import java.util.Comparator;

final class TotalQuantityComparator implements Comparator {

	static int field302;

	public static IndexDataBase overlay_ref;

	static Image field304;

	int method94(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity ? -1
				: (var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity ? 0 : 1);
	}

	@Override
	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@Override
	public int compare(Object var1, Object var2) {
		return this.method94((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
	}

	static void method98(int var0, int var1) {
		PacketNode var2 = WorldMapRectangle.method280(ClientPacket.field2405, Client.field957.field1484);
		var2.packetBuffer.putShort(var1);
		var2.packetBuffer.method3559(var0);
		Client.field957.method2052(var2);
	}
}
