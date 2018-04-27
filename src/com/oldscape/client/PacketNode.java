package com.oldscape.client;

public class PacketNode extends Node {

	static PacketNode[] packetBufferNodes;

	static int field2502;

	public ClientPacket clientPacket;

	public int field2503;

	public PacketBuffer packetBuffer;

	public int field2505;

	static {
		packetBufferNodes = new PacketNode[300];
		field2502 = 0;
	}

	public void method3436() {
		if (field2502 < packetBufferNodes.length) {
			packetBufferNodes[++field2502 - 1] = this;
		}
	}

	public static void method3442(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
		class229.field2687 = 1;
		class185.field2511 = var0;
		VertexNormal.field1931 = var1;
		GrandExchangeEvents.field284 = var2;
		class86.field1330 = var3;
		class229.field2692 = var4;
		class2.field11 = 10000;
	}
}
