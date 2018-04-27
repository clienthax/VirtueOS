package com.oldscape.client;

public class LoginPacket implements class179 {
   public static final LoginPacket field2488;
   static final LoginPacket field2483;
   public static final LoginPacket field2485;
   public static final LoginPacket field2486;
   static final LoginPacket[] field2484;
   public final int id;

   static {
      field2488 = new LoginPacket(14, 0);
      field2483 = new LoginPacket(15, 4);
      field2485 = new LoginPacket(16, -2);
      field2486 = new LoginPacket(18, -2);
      field2484 = new LoginPacket[32];
      LoginPacket[] var0 = BoundingBox2D.method37();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2484[var0[var1].id] = var0[var1];
      }

   }

   LoginPacket(int var1, int var2) {
      this.id = var1;
   }
}
