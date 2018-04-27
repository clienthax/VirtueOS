package com.oldscape.client;
import java.math.BigInteger;

public class Buffer extends Node {

	static int[] crc32Table;

	static long[] crc64Table;

	public byte[] payload;

	public int offset;

	static {
		crc32Table = new int[256];

		int var2;
		for (int var1 = 0; var1 < 256; ++var1) {
			int var0 = var1;

			for (var2 = 0; var2 < 8; ++var2) {
				if ((var0 & 1) == 1) {
					var0 = var0 >>> 1 ^ -306674912;
				} else {
					var0 >>>= 1;
				}
			}

			crc32Table[var1] = var0;
		}

		crc64Table = new long[256];

		for (var2 = 0; var2 < 256; ++var2) {
			long var4 = var2;

			for (int var3 = 0; var3 < 8; ++var3) {
				if (1L == (var4 & 1L)) {
					var4 = var4 >>> 1 ^ -3932672073523589310L;
				} else {
					var4 >>>= 1;
				}
			}

			crc64Table[var2] = var4;
		}

	}

	public Buffer(int var1) {
		this.payload = GrandExchangeOffer.method127(var1);
		this.offset = 0;
	}

	public Buffer(byte[] var1) {
		this.payload = var1;
		this.offset = 0;
	}

	public void method3500() {
		if (this.payload != null) {
			class150.method3110(this.payload);
		}

		this.payload = null;
	}

	public void putByte(int var1) {
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public void putShort(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public void put24bitInt(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public void putInt(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 24);
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public void method3671(long var1) {
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 40));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 32));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 24));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 16));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 8));
		this.payload[++this.offset - 1] = (byte) ((int) var1);
	}

	public void putLong(long var1) {
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 56));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 48));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 40));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 32));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 24));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 16));
		this.payload[++this.offset - 1] = (byte) ((int) (var1 >> 8));
		this.payload[++this.offset - 1] = (byte) ((int) var1);
	}

	public void writeBooleanAsByte(boolean var1) {
		this.putByte(var1 ? 1 : 0);
	}

	public void putString(String var1) {
		int var2 = var1.indexOf(0);
		if (var2 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.offset += class28.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
			this.payload[++this.offset - 1] = 0;
		}
	}

	public void putJagString(String var1) {
		int var2 = var1.indexOf(0);
		if (var2 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.payload[++this.offset - 1] = 0;
			this.offset += class28.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
			this.payload[++this.offset - 1] = 0;
		}
	}

	public void putCESU8(CharSequence var1) {
		int var3 = var1.length();
		int var4 = 0;

		int var5;
		for (var5 = 0; var5 < var3; ++var5) {
			char var6 = var1.charAt(var5);
			if (var6 <= 127) {
				++var4;
			} else if (var6 <= 2047) {
				var4 += 2;
			} else {
				var4 += 3;
			}
		}

		this.payload[++this.offset - 1] = 0;
		this.putVarInt(var4);
		var4 = this.offset;
		byte[] var12 = this.payload;
		int var7 = this.offset;
		int var8 = var1.length();
		int var9 = var7;

		for (int var10 = 0; var10 < var8; ++var10) {
			char var11 = var1.charAt(var10);
			if (var11 <= 127) {
				var12[var9++] = (byte) var11;
			} else if (var11 <= 2047) {
				var12[var9++] = (byte) (192 | var11 >> 6);
				var12[var9++] = (byte) (128 | var11 & '?');
			} else {
				var12[var9++] = (byte) (224 | var11 >> '\f');
				var12[var9++] = (byte) (128 | var11 >> 6 & 63);
				var12[var9++] = (byte) (128 | var11 & '?');
			}
		}

		var5 = var9 - var7;
		this.offset = var5 + var4;
	}

	public void putBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			this.payload[++this.offset - 1] = var1[var4];
		}

	}

	public void putLengthInt(int var1) {
		this.payload[this.offset - var1 - 4] = (byte) (var1 >> 24);
		this.payload[this.offset - var1 - 3] = (byte) (var1 >> 16);
		this.payload[this.offset - var1 - 2] = (byte) (var1 >> 8);
		this.payload[this.offset - var1 - 1] = (byte) var1;
	}

	public void method3513(int var1) {
		this.payload[this.offset - var1 - 2] = (byte) (var1 >> 8);
		this.payload[this.offset - var1 - 1] = (byte) var1;
	}

	public void method3514(int var1) {
		this.payload[this.offset - var1 - 1] = (byte) var1;
	}

	public void putShortSmart(int var1) {
		if (var1 >= 0 && var1 < 128) {
			this.putByte(var1);
		} else if (var1 >= 0 && var1 < 32768) {
			this.putShort(var1 + 32768);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void putVarInt(int var1) {
		if ((var1 & -128) != 0) {
			if ((var1 & -16384) != 0) {
				if ((var1 & -2097152) != 0) {
					if ((var1 & -268435456) != 0) {
						this.putByte(var1 >>> 28 | 128);
					}

					this.putByte(var1 >>> 21 | 128);
				}

				this.putByte(var1 >>> 14 | 128);
			}

			this.putByte(var1 >>> 7 | 128);
		}

		this.putByte(var1 & 127);
	}

	public int readUnsignedByte() {
		return this.payload[++this.offset - 1] & 255;
	}

	public byte readByte() {
		return this.payload[++this.offset - 1];
	}

	public int readUnsignedShort() {
		this.offset += 2;
		return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
	}

	public int readShort() {
		this.offset += 2;
		int var1 = (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	public int read24BitInt() {
		this.offset += 3;
		return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255)
				+ ((this.payload[this.offset - 2] & 255) << 8);
	}

	public int readInt() {
		this.offset += 4;
		return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255)
				+ ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24);
	}

	public long readLong() {
		long var1 = this.readInt() & 4294967295L;
		long var3 = this.readInt() & 4294967295L;
		return var3 + (var1 << 32);
	}

	public boolean method3524() {
		return (this.readUnsignedByte() & 1) == 1;
	}

	public String getNullString() {
		if (this.payload[this.offset] == 0) {
			++this.offset;
			return null;
		} else {
			return this.readString();
		}
	}

	public String readString() {
		int var1 = this.offset;

		while (this.payload[++this.offset - 1] != 0) {
			;
		}

		int var2 = this.offset - var1 - 1;
		return var2 == 0 ? "" : ChatPlayer.getString(this.payload, var1, var2);
	}

	public String getJagString() {
		byte var1 = this.payload[++this.offset - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		} else {
			int var2 = this.offset;

			while (this.payload[++this.offset - 1] != 0) {
				;
			}

			int var3 = this.offset - var2 - 1;
			return var3 == 0 ? "" : ChatPlayer.getString(this.payload, var2, var3);
		}
	}

	public String getCESU8() {
		byte var1 = this.payload[++this.offset - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		} else {
			int var2 = this.readVarInt();
			if (var2 + this.offset > this.payload.length) {
				throw new IllegalStateException("");
			} else {
				byte[] var4 = this.payload;
				int var5 = this.offset;
				char[] var6 = new char[var2];
				int var7 = 0;
				int var8 = var5;

				int var11;
				for (int var9 = var2 + var5; var8 < var9; var6[var7++] = (char) var11) {
					int var10 = var4[var8++] & 255;
					if (var10 < 128) {
						if (var10 == 0) {
							var11 = 65533;
						} else {
							var11 = var10;
						}
					} else if (var10 < 192) {
						var11 = 65533;
					} else if (var10 < 224) {
						if (var8 < var9 && (var4[var8] & 192) == 128) {
							var11 = (var10 & 31) << 6 | var4[var8++] & 63;
							if (var11 < 128) {
								var11 = 65533;
							}
						} else {
							var11 = 65533;
						}
					} else if (var10 < 240) {
						if (var8 + 1 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128) {
							var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
							if (var11 < 2048) {
								var11 = 65533;
							}
						} else {
							var11 = 65533;
						}
					} else if (var10 < 248) {
						if (var8 + 2 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128
								&& (var4[var8 + 2] & 192) == 128) {
							var11 = (var10 & 7) << 18 | (var4[var8++] & 63) << 12 | (var4[var8++] & 63) << 6
									| var4[var8++] & 63;
							if (var11 >= 65536 && var11 <= 1114111) {
								var11 = 65533;
							} else {
								var11 = 65533;
							}
						} else {
							var11 = 65533;
						}
					} else {
						var11 = 65533;
					}
				}

				String var3 = new String(var6, 0, var7);
				this.offset += var2;
				return var3;
			}
		}
	}

	public void readBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			var1[var4] = this.payload[++this.offset - 1];
		}

	}

	public int readShortSmart() {
		int var1 = this.payload[this.offset] & 255;
		return var1 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - 49152;
	}

	public int getUSmart() {
		int var1 = this.payload[this.offset] & 255;
		return var1 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - 32768;
	}

	public int getLargeSmart() {
		return this.payload[this.offset] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUnsignedShort();
	}

	public int method3576() {
		if (this.payload[this.offset] < 0) {
			return this.readInt() & Integer.MAX_VALUE;
		} else {
			int var1 = this.readUnsignedShort();
			return var1 == 32767 ? -1 : var1;
		}
	}

	public int readVarInt() {
		byte var1 = this.payload[++this.offset - 1];

		int var2;
		for (var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
			var2 = (var2 | var1 & 127) << 7;
		}

		return var2 | var1;
	}

	public void encryptXtea2(int[] var1) {
		int var2 = this.offset / 8;
		this.offset = 0;

		for (int var3 = 0; var3 < var2; ++var3) {
			int var4 = this.readInt();
			int var5 = this.readInt();
			int var6 = 0;
			int var7 = -1640531527;

			for (int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
				var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
				var6 += var7;
			}

			this.offset -= 8;
			this.putInt(var4);
			this.putInt(var5);
		}

	}

	public void decryptXtea(int[] var1) {
		int var2 = this.offset / 8;
		this.offset = 0;

		for (int var3 = 0; var3 < var2; ++var3) {
			int var4 = this.readInt();
			int var5 = this.readInt();
			int var6 = -957401312;
			int var7 = -1640531527;

			for (int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
				var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
				var6 -= var7;
			}

			this.offset -= 8;
			this.putInt(var4);
			this.putInt(var5);
		}

	}

	public void encryptXtea(int[] var1, int var2, int var3) {
		int var4 = this.offset;
		this.offset = var2;
		int var5 = (var3 - var2) / 8;

		for (int var6 = 0; var6 < var5; ++var6) {
			int var7 = this.readInt();
			int var8 = this.readInt();
			int var9 = 0;
			int var10 = -1640531527;

			for (int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
				var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
				var9 += var10;
			}

			this.offset -= 8;
			this.putInt(var7);
			this.putInt(var8);
		}

		this.offset = var4;
	}

	public void decryptXtea(int[] var1, int var2, int var3) {
		int var4 = this.offset;
		this.offset = var2;
		int var5 = (var3 - var2) / 8;

		for (int var6 = 0; var6 < var5; ++var6) {
			int var7 = this.readInt();
			int var8 = this.readInt();
			int var9 = -957401312;
			int var10 = -1640531527;

			for (int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
				var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
				var9 -= var10;
			}

			this.offset -= 8;
			this.putInt(var7);
			this.putInt(var8);
		}

		this.offset = var4;
	}

	public void encryptRsa(BigInteger var1, BigInteger var2) {
		int var3 = this.offset;
		this.offset = 0;
		byte[] var4 = new byte[var3];
		this.readBytes(var4, 0, var3);
		BigInteger var5 = new BigInteger(var4);
		BigInteger var6 = var5.modPow(var1, var2);
		byte[] var7 = var6.toByteArray();
		this.offset = 0;
		this.putShort(var7.length);
		this.putBytes(var7, 0, var7.length);
	}

	public int putCrc(int var1) {
		int var2 = ClanMember.method5252(this.payload, var1, this.offset);
		this.putInt(var2);
		return var2;
	}

	public boolean checkCrc() {
		this.offset -= 4;
		int var1 = ClanMember.method5252(this.payload, 0, this.offset);
		int var2 = this.readInt();
		return var1 == var2;
	}

	public void method3541(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 + 128);
	}

	public void method3542(int var1) {
		this.payload[++this.offset - 1] = (byte) (0 - var1);
	}

	public void method3543(int var1) {
		this.payload[++this.offset - 1] = (byte) (128 - var1);
	}

	public int method3636() {
		return this.payload[++this.offset - 1] - 128 & 255;
	}

	public int method3538() {
		return 0 - this.payload[++this.offset - 1] & 255;
	}

	public int readUnsignedShortOb1() {
		return 128 - this.payload[++this.offset - 1] & 255;
	}

	public byte method3725() {
		return (byte) (this.payload[++this.offset - 1] - 128);
	}

	public byte method3548() {
		return (byte) (0 - this.payload[++this.offset - 1]);
	}

	public byte method3634() {
		return (byte) (128 - this.payload[++this.offset - 1]);
	}

	public void method3550(int var1) {
		this.payload[++this.offset - 1] = (byte) var1;
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
	}

	public void method3551(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) (var1 + 128);
	}

	public void method3528(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 + 128);
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
	}

	public int method3553() {
		this.offset += 2;
		return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
	}

	public int method3554() {
		this.offset += 2;
		return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
	}

	public int method3555() {
		this.offset += 2;
		return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
	}

	public int method3595() {
		this.offset += 2;
		int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	public int method3556() {
		this.offset += 2;
		int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	public void method3722(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) var1;
	}

	public int method3558() {
		this.offset += 3;
		return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 3] & 255) << 8)
				+ ((this.payload[this.offset - 2] & 255) << 16);
	}

	public void method3559(int var1) {
		this.payload[++this.offset - 1] = (byte) var1;
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) (var1 >> 24);
	}

	public void method3552(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
		this.payload[++this.offset - 1] = (byte) var1;
		this.payload[++this.offset - 1] = (byte) (var1 >> 24);
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
	}

	public void method3561(int var1) {
		this.payload[++this.offset - 1] = (byte) (var1 >> 16);
		this.payload[++this.offset - 1] = (byte) (var1 >> 24);
		this.payload[++this.offset - 1] = (byte) var1;
		this.payload[++this.offset - 1] = (byte) (var1 >> 8);
	}

	public int method3562() {
		this.offset += 4;
		return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8)
				+ ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
	}

	public int method3563() {
		this.offset += 4;
		return ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8)
				+ (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 1] & 255) << 16);
	}

	public int method3564() {
		this.offset += 4;
		return ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 16)
				+ (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 3] & 255) << 24);
	}

	public void method3565(byte[] var1, int var2, int var3) {
		for (int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
			var1[var4] = this.payload[++this.offset - 1];
		}

	}

	public void method3661(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			var1[var4] = (byte) (this.payload[++this.offset - 1] - 128);
		}

	}

	public static boolean method3727(String var0, int var1) {
		return CombatInfoListHolder.method1865(var0, var1, "openjs");
	}
}
