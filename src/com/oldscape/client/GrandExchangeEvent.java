package com.oldscape.client;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class GrandExchangeEvent {

	static int field300;

	static int[] field298;

	static Task socket;

	static int field301;

	public final int world;

	public final long field292;

	public final GrandExchangeOffer grandExchangeOffer;

	String string1;

	String string2;

	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.string1 = var1.readString();
		this.string2 = var1.readString();
		this.world = var1.readUnsignedShort();
		this.field292 = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method109(2);
		this.grandExchangeOffer.method104(var2);
		this.grandExchangeOffer.price = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.quantitySold = 0;
		this.grandExchangeOffer.spent = 0;
		this.grandExchangeOffer.itemId = var3;
	}

	public String method81() {
		return this.string1;
	}

	public String method79() {
		return this.string2;
	}

	static long method89() {
		try {
			URL var0 = new URL(VerticalAlignment.method4715("services", false) + "m=accountappeal/login.ws");
			URLConnection var1 = var0.openConnection();
			var1.setRequestProperty("connection", "close");
			var1.setDoInput(true);
			var1.setDoOutput(true);
			var1.setConnectTimeout(5000);
			OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
			var2.write("data1=req");
			var2.flush();
			InputStream var3 = var1.getInputStream();
			Buffer var4 = new Buffer(new byte[1000]);

			do {
				int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
				if (var5 == -1) {
					var4.offset = 0;
					long var7 = var4.readLong();
					return var7;
				}

				var4.offset += var5;
			} while (var4.offset < 1000);

			return 0L;
		} catch (Exception var9) {
			return 0L;
		}
	}

	public static int method83(char var0, int var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		return var2;
	}

	static final void method85(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
		Buffer var5 = new Buffer(var0);
		int var6 = -1;

		while (true) {
			int var7 = var5.getUSmart();
			if (var7 == 0) {
				return;
			}

			var6 += var7;
			int var8 = 0;

			while (true) {
				int var9 = var5.getUSmart();
				if (var9 == 0) {
					break;
				}

				var8 += var9 - 1;
				int var10 = var8 & 63;
				int var11 = var8 >> 6 & 63;
				int var12 = var8 >> 12;
				int var13 = var5.readUnsignedByte();
				int var14 = var13 >> 2;
				int var15 = var13 & 3;
				int var16 = var11 + var1;
				int var17 = var10 + var2;
				if (var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
					int var18 = var12;
					if ((class62.tileSettings[1][var16][var17] & 2) == 2) {
						var18 = var12 - 1;
					}

					CollisionData var19 = null;
					if (var18 >= 0) {
						var19 = var4[var18];
					}

					class44.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
				}
			}
		}
	}

	static final void method90(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field936) {
			Client.field919 = 32;
		} else {
			Client.field919 = 0;
		}

		Client.field936 = false;
		int var7;
		if (MouseInput.mouseCurrentButton == 1
				|| !MapIconReference.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				FontName.method5490(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				FontName.method5490(var0);
			} else if (var5 >= var1 - Client.field919 && var5 < Client.field919 + var1 + 16 && var6 >= var2 + 16
					&& var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				FontName.method5490(var0);
				Client.field936 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				FontName.method5490(var0);
			}
		}

	}

	static final void method80(String var0) {
		if (GameEngine.clanMemberManager != null) {
			PacketNode var1 = WorldMapRectangle.method280(ClientPacket.field2392, Client.field957.field1484);
			var1.packetBuffer.putByte(WorldMapRegion.getLength(var0));
			var1.packetBuffer.putString(var0);
			Client.field957.method2052(var1);
		}
	}

	static void method88() {
		Client.field957.method2052(WorldMapRectangle.method280(ClientPacket.field2477, Client.field957.field1484));
		Client.field960 = 0;
	}
}
