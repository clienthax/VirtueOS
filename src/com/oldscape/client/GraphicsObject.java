package com.oldscape.client;

import java.io.IOException;

final class GraphicsObject extends Renderable {
   public static Track1 field1300;
   private final int id;
   final int startCycle;
   final int level;
   final int x;
   final int y;
   final int height;
   private Sequence field1298;
   private int field1292;
   private int field1304;
   boolean finished;

   GraphicsObject(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7) {
      this.field1292 = 0;
      this.field1304 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      final int var8 = Spotanim.getSpotAnimType(this.id).field3497;
      if(var8 != -1) {
         this.finished = false;
         this.field1298 = CombatInfo1.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   final void method1851(final int var1) {
      if(!this.finished) {
         this.field1304 += var1;

         while(this.field1304 > this.field1298.frameLengths[this.field1292]) {
            this.field1304 -= this.field1298.frameLengths[this.field1292];
            ++this.field1292;
            if(this.field1292 >= this.field1298.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   protected final Model getModel() {
      final Spotanim var1 = Spotanim.getSpotAnimType(this.id);
      final Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1292);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2;
   }

   public static void sendConInfo(final boolean var0) {
      if(class264.NetCache_socket != null) {
         try {
            final Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class264.NetCache_socket.vmethod3337(var1.payload, 0, 4);
         } catch (final IOException var4) {
            try {
               class264.NetCache_socket.vmethod3331();
            } catch (final Exception ignored) {
            }

            ++class264.field3431;
            class264.NetCache_socket = null;
         }

      }
   }

   public static int nextPowerOfTwo(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
