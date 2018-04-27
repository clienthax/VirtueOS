package com.oldscape.client;
import java.io.EOFException;

public class Varcs {

	boolean[] varcSerials;

	boolean[] varcstringSerials;

	int[] varcs;

	String[] varcstrings;

	boolean changed;

	long field1446;

	Varcs() {
		this.changed = false;
		this.varcs = new int[Size.configsIndex.fileCount(19)];
		this.varcstrings = new String[Size.configsIndex.fileCount(15)];
		this.varcSerials = new boolean[this.varcs.length];

		int var1;
		for (var1 = 0; var1 < this.varcs.length; ++var1) {
			VarCInt var2 = class241.method4414(var1);
			this.varcSerials[var1] = var2.field3474;
		}

		this.varcstringSerials = new boolean[this.varcstrings.length];

		for (var1 = 0; var1 < this.varcstrings.length; ++var1) {
			VarCString var3 = (VarCString) VarCString.field3480.get(var1);
			VarCString var5;
			if (var3 != null) {
				var5 = var3;
			} else {
				byte[] var4 = VarCString.field3481.getConfigData(15, var1);
				var3 = new VarCString();
				if (var4 != null) {
					var3.method4787(new Buffer(var4));
				}

				VarCString.field3480.put(var3, var1);
				var5 = var3;
			}

			this.varcstringSerials[var1] = var5.field3479;
		}

		for (var1 = 0; var1 < this.varcs.length; ++var1) {
			this.varcs[var1] = -1;
		}

		this.deserialize();
	}

	void putVarc(int var1, int var2) {
		this.varcs[var1] = var2;
		if (this.varcSerials[var1]) {
			this.changed = true;
		}

	}

	int getVarc(int var1) {
		return this.varcs[var1];
	}

	void putVarcString(int var1, String var2) {
		this.varcstrings[var1] = var2;
		if (this.varcstringSerials[var1]) {
			this.changed = true;
		}

	}

	String getVarcString(int var1) {
		return this.varcstrings[var1];
	}

	void reset() {
		int var1;
		for (var1 = 0; var1 < this.varcs.length; ++var1) {
			if (!this.varcSerials[var1]) {
				this.varcs[var1] = -1;
			}
		}

		for (var1 = 0; var1 < this.varcstrings.length; ++var1) {
			if (!this.varcstringSerials[var1]) {
				this.varcstrings[var1] = null;
			}
		}

	}

	FileOnDisk getVarPrefs(boolean var1) {
		return NPC.getPreferencesFile("2", class265.field3435.name, var1);
	}

	void serialize() {
		FileOnDisk var1 = this.getVarPrefs(true);

		try {
			int var2 = 3;
			int var3 = 0;

			int var4;
			for (var4 = 0; var4 < this.varcs.length; ++var4) {
				if (this.varcSerials[var4] && this.varcs[var4] != -1) {
					var2 += 6;
					++var3;
				}
			}

			var2 += 2;
			var4 = 0;

			for (int var5 = 0; var5 < this.varcstrings.length; ++var5) {
				if (this.varcstringSerials[var5] && this.varcstrings[var5] != null) {
					var2 += 2 + WorldMapRegion.getLength(this.varcstrings[var5]);
					++var4;
				}
			}

			Buffer var9 = new Buffer(var2);
			var9.putByte(1);
			var9.putShort(var3);

			int var6;
			for (var6 = 0; var6 < this.varcs.length; ++var6) {
				if (this.varcSerials[var6] && this.varcs[var6] != -1) {
					var9.putShort(var6);
					var9.putInt(this.varcs[var6]);
				}
			}

			var9.putShort(var4);

			for (var6 = 0; var6 < this.varcstrings.length; ++var6) {
				if (this.varcstringSerials[var6] && this.varcstrings[var6] != null) {
					var9.putShort(var6);
					var9.putString(this.varcstrings[var6]);
				}
			}

			var1.write(var9.payload, 0, var9.offset);
		} catch (Exception var17) {
			;
		} finally {
			try {
				var1.close();
			} catch (Exception var16) {
				;
			}

		}

		this.changed = false;
		this.field1446 = class64.method1118();
	}

	void deserialize() {
		FileOnDisk var1 = this.getVarPrefs(false);

		label192: {
			try {
				byte[] var2 = new byte[(int) var1.length()];

				int var4;
				for (int var3 = 0; var3 < var2.length; var3 += var4) {
					var4 = var1.read(var2, var3, var2.length - var3);
					if (var4 == -1) {
						throw new EOFException();
					}
				}

				Buffer var13 = new Buffer(var2);
				if (var13.payload.length - var13.offset >= 1) {
					int var14 = var13.readUnsignedByte();
					if (var14 < 0 || var14 > 1) {
						return;
					}

					int var15 = var13.readUnsignedShort();

					int var7;
					int var8;
					int var9;
					for (var7 = 0; var7 < var15; ++var7) {
						var8 = var13.readUnsignedShort();
						var9 = var13.readInt();
						if (this.varcSerials[var8]) {
							this.varcs[var8] = var9;
						}
					}

					var7 = var13.readUnsignedShort();
					var8 = 0;

					while (true) {
						if (var8 >= var7) {
							break label192;
						}

						var9 = var13.readUnsignedShort();
						String var10 = var13.readString();
						if (this.varcstringSerials[var9]) {
							this.varcstrings[var9] = var10;
						}

						++var8;
					}
				}
			} catch (Exception var24) {
				break label192;
			} finally {
				try {
					var1.close();
				} catch (Exception var23) {
					;
				}

			}

			return;
		}

		this.changed = false;
	}

	void process() {
		if (this.changed && this.field1446 < class64.method1118() - 60000L) {
			this.serialize();
		}

	}

	boolean changed() {
		return this.changed;
	}

	public static void method1993() {
		class278.field3546.reset();
	}
}
