package com.oldscape.client.reference;

import java.io.IOException;
import java.io.OutputStream;

class GameSocket implements Runnable {
    private final Thread field2262;
    private final OutputStream field2263;
    private final int field2260;
    private final byte[] field2261;
    private int field2259;
    private int field2258;
    private IOException field2264;
    private boolean field2265;

    GameSocket(final OutputStream var1, final int var2) {
        this.field2259 = 0;
        this.field2258 = 0;
        this.field2263 = var1;
        this.field2260 = var2 + 1;
        this.field2261 = new byte[this.field2260];
        this.field2262 = new Thread(this);
        this.field2262.setDaemon(true);
        this.field2262.start();
    }

    private boolean method3373() {
        if (this.field2265) {
            try {
                this.field2263.close();
                if (this.field2264 == null) {
                    this.field2264 = new IOException("");
                }
            } catch (final IOException var2) {
                if (this.field2264 == null) {
                    this.field2264 = new IOException(var2);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    void read(final byte[] var1, final int var2, final int var3) throws IOException {
        if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
            synchronized (this) {
                if (this.field2264 != null) {
                    throw new IOException(this.field2264.toString());
                } else {
                    final int var5;
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
                            final int var6 = this.field2260 - this.field2258;
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
        } catch (final InterruptedException ignored) {
        }

    }

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
                    } catch (final IOException var11) {
                        this.field2264 = var11;
                        return;
                    }

                    if (this.method3373()) {
                        return;
                    }

                    try {
                        this.wait();
                    } catch (final InterruptedException ignored) {
                    }
                }
            }

            try {
                if (var1 + this.field2259 <= this.field2260) {
                    this.field2263.write(this.field2261, this.field2259, var1);
                } else {
                    final int var7 = this.field2260 - this.field2259;
                    this.field2263.write(this.field2261, this.field2259, var7);
                    this.field2263.write(this.field2261, 0, var1 - var7);
                }
            } catch (final IOException var10) {
                synchronized (this) {
                    this.field2264 = var10;
                    return;
                }
            }

            synchronized (this) {
                this.field2259 = (var1 + this.field2259) % this.field2260;
            }
        } while (!this.method3373());

    }
}
