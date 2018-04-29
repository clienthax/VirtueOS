package com.oldscape.client;

class SoundTask implements Runnable {
   static java.awt.Font font_helvetica_bold13;
   final AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            final AbstractSoundSystem system = this.systems[var1];
            if(system != null) {
               system.method2197();
            }
         }
      } catch (final Exception var4) {
         Signlink.processClientError(null, var4);
      }

   }

   public static void method2270(final Buffer buffer, final int var1) {
      if(class167.randomDat != null) {
         try {
            class167.randomDat.seek(0L);
            class167.randomDat.write(buffer.payload, var1, 24);
         } catch (final Exception ignored) {
         }
      }

   }

   static void worldToScreen(int var0, int var1, final int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = WorldMapManager.getTileHeight(var0, var1, BoundingBox3DDrawMode.plane) - var2;
         var0 -= Player.cameraX;
         var3 -= GameObject.cameraZ;
         var1 -= class20.cameraY;
         final int pitchSine = Graphics3D.SINE[GrandExchangeOffer.cameraPitch];
         final int pitchCosine = Graphics3D.COSINE[GrandExchangeOffer.cameraPitch];
         final int yawSine = Graphics3D.SINE[Client.cameraYaw];
         final int yawCosine = Graphics3D.COSINE[Client.cameraYaw];
         int var8 = yawSine * var1 + var0 * yawCosine >> 16;
         var1 = yawCosine * var1 - var0 * yawSine >> 16;
         var0 = var8;
         var8 = var3 * pitchCosine - pitchSine * var1 >> 16;
         var1 = pitchCosine * var1 + pitchSine * var3 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportWidth / 2;
            Client.screenY = Client.viewportHeight / 2 + var8 * Client.scale / var1;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }
}
