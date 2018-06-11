package com.oldscape.client.reference;

class Identifiers {
    private final int[] table;

    public Identifiers(final int[] var1) {
        int var2;
        for (var2 = 1; var2 <= (var1.length >> 1) + var1.length; var2 <<= 1) {
        }

        this.table = new int[var2 + var2];

        int var3;
        for (var3 = 0; var3 < var2 + var2; ++var3) {
            this.table[var3] = -1;
        }

        int var4;
        for (var3 = 0; var3 < var1.length; this.table[var4 + var4 + 1] = var3++) {
            for (var4 = var1[var3] & var2 - 1; this.table[var4 + var4 + 1] != -1; var4 = var4 + 1 & var2 - 1) {
            }

            this.table[var4 + var4] = var1[var3];
        }

    }

    public int getFile(final int var1) {
        final int var2 = (this.table.length >> 1) - 1;
        int var3 = var1 & var2;

        while (true) {
            final int var4 = this.table[var3 + var3 + 1];
            if (var4 == -1) {
                return -1;
            }

            if (this.table[var3 + var3] == var1) {
                return var4;
            }

            var3 = var3 + 1 & var2;
        }
    }
}
