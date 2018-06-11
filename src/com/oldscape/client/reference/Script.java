package com.oldscape.client.reference;

class Script extends CacheableNode {
    static final NodeCache field1459;
    static int field1455;

    static {
        field1459 = new NodeCache(128);
    }

    int[] instructions;
    int[] intOperands;
    String[] stringOperands;
    int localIntCount;
    int localStringCount;
    int intStackCount;
    int stringStackCount;
    IterableHashTable[] switches;

    IterableHashTable[] method2016(final int var1) {
        return new IterableHashTable[var1];
    }
}
