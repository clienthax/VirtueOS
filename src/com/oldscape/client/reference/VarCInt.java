package com.oldscape.client.reference;

public class VarCInt extends CacheableNode {
    static final NodeCache field3475;
    static IndexDataBase field3476;

    static {
        field3475 = new NodeCache(64);
    }

    public boolean field3474;

    VarCInt() {
        this.field3474 = false;
    }

    static VarCInt method4414(final int var0) {
        VarCInt var1 = (VarCInt) field3475.get(var0);
        if (var1 == null) {
            final byte[] var2 = field3476.getConfigData(19, var0);
            var1 = new VarCInt();
            if (var2 != null) {
                var1.decode(new Buffer(var2));
            }

            field3475.put(var1, var0);
        }
        return var1;
    }

    static String method4785(final char var0, final int var1) {
        final char[] var2 = new char[var1];

        for (int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = var0;
        }

        return new String(var2);
    }

    private void decode(final Buffer buffer) {
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
            this.field3474 = true;
        }

    }
}
