package com.oldscape.client.reference;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class Preferences {
    private static final int field1249;
    static RenderOverview renderOverview;
    static short[] field1248;

    static {
        field1249 = 6;
    }

    boolean hideRoofs;
    boolean muted;
    int screenType;
    String rememberedUsername;
    boolean hideUsername;
    LinkedHashMap<Integer, Integer> preferences;

    Preferences() {
        this.screenType = 1;
        this.rememberedUsername = null;
        this.hideUsername = false;
        this.preferences = new LinkedHashMap<>();
        this.method1727();
    }

    Preferences(final Buffer var1) {
        this.screenType = 1;
        this.rememberedUsername = null;
        this.hideUsername = false;
        this.preferences = new LinkedHashMap<>();
        if (var1 != null && var1.payload != null) {
            final int var2 = var1.readUnsignedByte();
            if (var2 >= 0 && var2 <= field1249) {
                if (var1.readUnsignedByte() == 1) {
                    this.hideRoofs = true;
                }

                if (var2 > 1) {
                    this.muted = var1.readUnsignedByte() == 1;
                }

                if (var2 > 3) {
                    this.screenType = var1.readUnsignedByte();
                }

                if (var2 > 2) {
                    final int var3 = var1.readUnsignedByte();

                    for (int var4 = 0; var4 < var3; ++var4) {
                        final int var5 = var1.readInt();
                        final int var6 = var1.readInt();
                        this.preferences.put(var5, var6);
                    }
                }

                if (var2 > 4) {
                    this.rememberedUsername = var1.getNullString();
                }

                if (var2 > 5) {
                    this.hideUsername = var1.readUnsignedByteAsBool();
                }
            } else {
                this.method1727();
            }
        } else {
            this.method1727();
        }

    }

    private void method1727() {
    }

    Buffer serialize() {
        final Buffer buffer = new Buffer(100);
        buffer.putByte(field1249);
        buffer.putByte(this.hideRoofs ? 1 : 0);
        buffer.putByte(this.muted ? 1 : 0);
        buffer.putByte(this.screenType);
        buffer.putByte(this.preferences.size());

        for (final Entry<Integer, Integer> entry : this.preferences.entrySet()) {
            buffer.putInt(entry.getKey());
            buffer.putInt(entry.getValue());
        }

        buffer.putString(this.rememberedUsername != null ? this.rememberedUsername : "");
        buffer.writeBooleanAsByte(this.hideUsername);
        return buffer;
    }
}
