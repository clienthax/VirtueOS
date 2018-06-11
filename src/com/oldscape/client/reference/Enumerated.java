package com.oldscape.client.reference;

public interface Enumerated {

    static Enumerated forOrdinal(final Enumerated[] enumerateds, final int var1) {
        for (final Enumerated var4 : enumerateds) {
            if (var1 == var4.rsOrdinal()) {
                return var4;
            }
        }

        return null;
    }

    int rsOrdinal();
}
