package com.oldscape.client.reference;

class VarCString extends CacheableNode {

    static final NodeCache field3480;
    static IndexDataBase field3481;

    static {
        field3480 = new NodeCache(64);
    }

    boolean field3479;

    VarCString() {
        this.field3479 = false;
    }

    public void read(final Buffer buffer) {
        while (true) {
            final int opcode = buffer.readUnsignedByte();
            if (opcode == 0) {
                return;
            }

            this.readNext(opcode);
        }
    }

    private void readNext(final int var2) {
        if (var2 == 2) {
            this.field3479 = true;
        }

    }
}
