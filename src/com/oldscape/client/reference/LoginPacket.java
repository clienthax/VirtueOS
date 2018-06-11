package com.oldscape.client.reference;

public class LoginPacket implements class179 {
    public static final LoginPacket field2488;
    public static final LoginPacket field2485;
    public static final LoginPacket field2486;
    static final LoginPacket field2483;
    private static final LoginPacket[] field2484;

    static {
        field2488 = new LoginPacket(14, 0);
        field2483 = new LoginPacket(15, 4);
        field2485 = new LoginPacket(16, -2);
        field2486 = new LoginPacket(18, -2);
        field2484 = new LoginPacket[32];
        final LoginPacket[] var0 = BoundingBox2D.method37();

        for (final LoginPacket aVar0 : var0) {
            field2484[aVar0.id] = aVar0;
        }

    }

    public final int id;

    private LoginPacket(final int var1, final int var2) {
        this.id = var1;
    }
}
