package com.oldscape.client.reference;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class class173 extends class169 implements Runnable {
    private final Socket socket;
    private final Signlink signlink;
    private final int bufferSize;
    private final int field2252;
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean field2245;
    private Task task;
    private byte[] buffer;
    private int field2251;
    private int field2240;
    private boolean field2249;

    class173(final Socket socket, final Signlink signlink, final int var3) throws IOException {
        this.field2245 = false;
        this.field2251 = 0;
        this.field2240 = 0;
        this.field2249 = false;
        this.signlink = signlink;
        this.socket = socket;
        this.bufferSize = var3;
        this.field2252 = var3 - 100;
        this.socket.setSoTimeout(30000);
        this.socket.setTcpNoDelay(true);
        this.socket.setReceiveBufferSize(65536);
        this.socket.setSendBufferSize(65536);
        this.inputStream = this.socket.getInputStream();
        this.outputStream = this.socket.getOutputStream();
    }

    public boolean vmethod3335(final int var1) throws IOException {
        return !this.field2245 && this.inputStream.available() >= var1;
    }

    public int getAvailable() throws IOException {
        return this.field2245 ? 0 : this.inputStream.available();
    }

    public int vmethod3349() throws IOException {
        return this.field2245 ? 0 : this.inputStream.read();
    }

    public int vmethod3348(final byte[] var1, int var2, int var3) throws IOException {
        if (this.field2245) {
            return 0;
        } else {
            final int var4;
            int var5;
            for (var4 = var3; var3 > 0; var3 -= var5) {
                var5 = this.inputStream.read(var1, var2, var3);
                if (var5 <= 0) {
                    throw new EOFException();
                }

                var2 += var5;
            }

            return var4;
        }
    }

    public void vmethod3337(final byte[] var1, final int var2, final int var3) throws IOException {
        this.method3336(var1, var2, var3);
    }

    public void vmethod3331() {
        if (!this.field2245) {
            synchronized (this) {
                this.field2245 = true;
                this.notifyAll();
            }

            if (this.task != null) {
                while (this.task.status == 0) {
                    ScriptVarType.method11(1L);
                }

                if (this.task.status == 1) {
                    try {
                        ((Thread) this.task.value).join();
                    } catch (final InterruptedException ignored) {
                    }
                }
            }

            this.task = null;
        }
    }

    private void method3336(final byte[] var1, final int var2, final int var3) throws IOException {
        if (!this.field2245) {
            if (this.field2249) {
                this.field2249 = false;
                throw new IOException();
            } else {
                if (this.buffer == null) {
                    this.buffer = new byte[this.bufferSize];
                }

                synchronized (this) {
                    for (int var5 = 0; var5 < var3; ++var5) {
                        this.buffer[this.field2240] = var1[var5 + var2];
                        this.field2240 = (this.field2240 + 1) % this.bufferSize;
                        if ((this.field2252 + this.field2251) % this.bufferSize == this.field2240) {
                            throw new IOException();
                        }
                    }

                    if (this.task == null) {
                        this.task = this.signlink.createRunnable(this, 3);
                    }

                    this.notifyAll();
                }
            }
        }
    }

    public void run() {
        try {
            while (true) {
                label84:
                {
                    final int var1;
                    final int var2;
                    synchronized (this) {
                        if (this.field2240 == this.field2251) {
                            if (this.field2245) {
                                break label84;
                            }

                            try {
                                this.wait();
                            } catch (final InterruptedException ignored) {
                            }
                        }

                        var2 = this.field2251;
                        if (this.field2240 >= this.field2251) {
                            var1 = this.field2240 - this.field2251;
                        } else {
                            var1 = this.bufferSize - this.field2251;
                        }
                    }

                    if (var1 <= 0) {
                        continue;
                    }

                    try {
                        this.outputStream.write(this.buffer, var2, var1);
                    } catch (final IOException var9) {
                        this.field2249 = true;
                    }

                    this.field2251 = (var1 + this.field2251) % this.bufferSize;

                    try {
                        if (this.field2251 == this.field2240) {
                            this.outputStream.flush();
                        }
                    } catch (final IOException var8) {
                        this.field2249 = true;
                    }
                    continue;
                }

                try {
                    if (this.inputStream != null) {
                        this.inputStream.close();
                    }

                    if (this.outputStream != null) {
                        this.outputStream.close();
                    }

                    if (this.socket != null) {
                        this.socket.close();
                    }
                } catch (final IOException ignored) {
                }

                this.buffer = null;
                break;
            }
        } catch (final Exception var12) {
            Signlink.processClientError(null, var12);
        }

    }

    protected void finalize() {
        this.vmethod3331();
    }
}
