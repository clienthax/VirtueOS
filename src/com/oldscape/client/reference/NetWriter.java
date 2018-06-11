package com.oldscape.client.reference;

import java.io.IOException;

public class NetWriter {
    final PacketBuffer packetBuffer;
    private final CombatInfoList packetBufferNodes;
    private final Buffer buffer;
    public ISAACCipher field1484;
    ServerPacket serverPacket;
    int packetLength;
    boolean field1489;
    int field1480;
    int field1485;
    ServerPacket field1495;
    ServerPacket field1492;
    ServerPacket field1493;
    private class169 rssocket;
    private int field1482;

    NetWriter() {
        this.packetBufferNodes = new CombatInfoList();
        this.field1482 = 0;
        this.buffer = new Buffer(5000);
        this.packetBuffer = new PacketBuffer(40000);
        this.serverPacket = null;
        this.packetLength = 0;
        this.field1489 = true;
        this.field1480 = 0;
        this.field1485 = 0;
    }

    final void method2038() {
        this.packetBufferNodes.method3970();
        this.field1482 = 0;
    }

    final void method2039() throws IOException {
        if (this.rssocket != null && this.field1482 > 0) {
            this.buffer.offset = 0;

            while (true) {
                final PacketNode var1 = (PacketNode) this.packetBufferNodes.last();
                if (var1 == null || var1.field2505 > this.buffer.payload.length - this.buffer.offset) {
                    this.rssocket.vmethod3337(this.buffer.payload, 0, this.buffer.offset);
                    this.field1485 = 0;
                    break;
                }

                this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2505);
                this.field1482 -= var1.field2505;
                var1.unlink();
                var1.packetBuffer.method3500();
                var1.method3436();
            }
        }

    }

    public final void method2052(final PacketNode var1) {
        this.packetBufferNodes.addFirst(var1);
        var1.field2505 = var1.packetBuffer.offset;
        var1.packetBuffer.offset = 0;
        this.field1482 += var1.field2505;
    }

    void close() {
        if (this.rssocket != null) {
            this.rssocket.vmethod3331();
            this.rssocket = null;
        }

    }

    void method2043() {
        this.rssocket = null;
    }

    class169 getSocket() {
        return this.rssocket;
    }

    void setSocket(final class169 var1) {
        this.rssocket = var1;
    }
}
