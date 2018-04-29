package com.oldscape.client;

class CombatInfo2 extends CacheableNode {
   public static IndexDataBase field3532;
   static IndexDataBase field3528;
   public static final NodeCache field3524;
   public static final NodeCache field3531;
   public int field3526;
   public int field3536;
   public int field3529;
   public int field3523;
   public int field3530;
   public int field3522;
   private int field3533;
   private int field3534;
   public int healthScale;
   public int field3525;

   static {
      field3524 = new NodeCache(64);
      field3531 = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3536 = 255;
      this.field3529 = 255;
      this.field3523 = -1;
      this.field3530 = 1;
      this.field3522 = 70;
      this.field3533 = -1;
      this.field3534 = -1;
      this.healthScale = 30;
      this.field3525 = 0;
   }

   public void read(final Buffer var1) {
      while(true) {
         final int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.processOpcode(var1, var2);
      }
   }

   private void processOpcode(final Buffer buffer, final int opcode) {
      if(opcode == 1) {
         buffer.readUnsignedShort();
      } else if(opcode == 2) {
         this.field3536 = buffer.readUnsignedByte();
      } else if(opcode == 3) {
         this.field3529 = buffer.readUnsignedByte();
      } else if(opcode == 4) {
         this.field3523 = 0;
      } else if(opcode == 5) {
         this.field3522 = buffer.readUnsignedShort();
      } else if(opcode == 6) {
         buffer.readUnsignedByte();
      } else if(opcode == 7) {
         this.field3533 = buffer.method3576();
      } else if(opcode == 8) {
         this.field3534 = buffer.method3576();
      } else if(opcode == 11) {
         this.field3523 = buffer.readUnsignedShort();
      } else if(opcode == 14) {
         this.healthScale = buffer.readUnsignedByte();
      } else if(opcode == 15) {
         this.field3525 = buffer.readUnsignedByte();
      }

   }

   public SpritePixels method4862() {
      if(this.field3533 < 0) {
         return null;
      } else {
         SpritePixels spritePixels = (SpritePixels)field3531.get(this.field3533);
          if (spritePixels == null) {
              spritePixels = class332.method817(field3528, this.field3533, 0);
              if (spritePixels != null) {
                  field3531.put(spritePixels, this.field3533);
              }

          }
          return spritePixels;
      }
   }

   public SpritePixels method4863() {
      if(this.field3534 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3531.get(this.field3534);
          if (var1 == null) {
              var1 = class332.method817(field3528, this.field3534, 0);
              if (var1 != null) {
                  field3531.put(var1, this.field3534);
              }

          }
          return var1;
      }
   }

}
