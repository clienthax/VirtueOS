package com.oldscape.client;
import java.io.IOException;
import java.io.OutputStream;

public class GameSocket implements Runnable {

	Thread field2262;

	OutputStream field2263;

	int field2260;

	byte[] field2261;

	int field2259;

	int field2258;

	IOException field2264;

	boolean field2265;

	GameSocket(OutputStream var1, int var2) {
		this.field2259 = 0;
		this.field2258 = 0;
		this.field2263 = var1;
		this.field2260 = var2 + 1;
		this.field2261 = new byte[this.field2260];
		this.field2262 = new Thread(this);
		this.field2262.setDaemon(true);
		this.field2262.start();
	}

	boolean method3373() {
		if (this.field2265) {
			try {
				this.field2263.close();
				if (this.field2264 == null) {
					this.field2264 = new IOException("");
				}
			} catch (IOException var2) {
				if (this.field2264 == null) {
					this.field2264 = new IOException(var2);
				}
			}

			return true;
		} else {
			return false;
		}
	}

	void read(byte[] var1, int var2, int var3) throws IOException {
		if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
			synchronized (this) {
				if (this.field2264 != null) {
					throw new IOException(this.field2264.toString());
				} else {
					int var5;
					if (this.field2259 <= this.field2258) {
						var5 = this.field2260 - this.field2258 + this.field2259 - 1;
					} else {
						var5 = this.field2259 - this.field2258 - 1;
					}

					if (var5 < var3) {
						throw new IOException("");
					} else {
						if (var3 + this.field2258 <= this.field2260) {
							System.arraycopy(var1, var2, this.field2261, this.field2258, var3);
						} else {
							int var6 = this.field2260 - this.field2258;
							System.arraycopy(var1, var2, this.field2261, this.field2258, var6);
							System.arraycopy(var1, var6 + var2, this.field2261, 0, var3 - var6);
						}

						this.field2258 = (var3 + this.field2258) % this.field2260;
						this.notifyAll();
					}
				}
			}
		} else {
			throw new IOException();
		}
	}

	void method3375() {
		synchronized (this) {
			this.field2265 = true;
			this.notifyAll();
		}

		try {
			this.field2262.join();
		} catch (InterruptedException var3) {
			;
		}

	}

	@Override
	public void run() {
		do {
			int var1;
			synchronized (this) {
				while (true) {
					if (this.field2264 != null) {
						return;
					}

					if (this.field2259 <= this.field2258) {
						var1 = this.field2258 - this.field2259;
					} else {
						var1 = this.field2260 - this.field2259 + this.field2258;
					}

					if (var1 > 0) {
						break;
					}

					try {
						this.field2263.flush();
					} catch (IOException var11) {
						this.field2264 = var11;
						return;
					}

					if (this.method3373()) {
						return;
					}

					try {
						this.wait();
					} catch (InterruptedException var12) {
						;
					}
				}
			}

			try {
				if (var1 + this.field2259 <= this.field2260) {
					this.field2263.write(this.field2261, this.field2259, var1);
				} else {
					int var7 = this.field2260 - this.field2259;
					this.field2263.write(this.field2261, this.field2259, var7);
					this.field2263.write(this.field2261, 0, var1 - var7);
				}
			} catch (IOException var10) {
				IOException var2 = var10;
				synchronized (this) {
					this.field2264 = var2;
					return;
				}
			}

			synchronized (this) {
				this.field2259 = (var1 + this.field2259) % this.field2260;
			}
		} while (!this.method3373());

	}
}
