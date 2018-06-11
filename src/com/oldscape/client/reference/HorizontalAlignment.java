package com.oldscape.client.reference;

public enum HorizontalAlignment implements Enumerated {
    field3698(2, 0),
    field3702(0, 1),
    field3699(1, 2);

    public final int value;
    final int id;

    HorizontalAlignment(final int var3, final int var4) {
        this.value = var3;
        this.id = var4;
    }

    public int rsOrdinal() {
        return this.id;
    }
}
