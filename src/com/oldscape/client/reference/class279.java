package com.oldscape.client.reference;

class class279 extends CacheableNode {
    static final NodeCache field3553;
    static IndexDataBase field3552;

    static {
        field3553 = new NodeCache(64);
    }

    private IterableHashTable field3554;

    static boolean method4922(final class245 var0) {
        return class245.field2976 == var0 || class245.field2969 == var0 || class245.field2965 == var0 || class245.field2970 == var0 || class245.field2967 == var0 || class245.field2968 == var0 || class245.field2971 == var0 || class245.field2966 == var0;
    }

    void method4925() {
    }

    void method4937(final Buffer var1) {
        while (true) {
            final int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.method4923(var1, var2);
        }
    }

    private void method4923(final Buffer var1, final int var2) {
        if (var2 == 249) {
            this.field3554 = WorldMapDecorationInfo.readStringIntParameters(var1, this.field3554);
        }

    }

    int method4924(final int id, final int defaultValue) {
        final IterableHashTable hashTable = this.field3554;
        final int value;
        if (hashTable == null) {
            value = defaultValue;
        } else {
            final IntegerNode integerNode = (IntegerNode) hashTable.get(id);
            if (integerNode == null) {
                value = defaultValue;
            } else {
                value = integerNode.value;
            }
        }

        return value;
    }

    String method4932(final int var1, final String var2) {
        return WorldMapType1.method309(this.field3554, var1, var2);
    }
}
