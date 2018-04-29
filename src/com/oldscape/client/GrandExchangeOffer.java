package com.oldscape.client;

public class GrandExchangeOffer {
   static int cameraPitch;
   private byte state;
   public int itemId;
   public int price;
   public int totalQuantity;
   public int quantitySold;
   public int spent;

   public GrandExchangeOffer() {
   }

   public GrandExchangeOffer(final Buffer var1) {
      this.state = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   public int status() {
      return this.state & 7;
   }

   public int type() {
      return (this.state & 8) == 8?1:0;
   }

   void method109(final int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   void method104(final int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   static synchronized byte[] method127(final int var0) {
      return class195.method3729(var0);
   }

   static void method125(final Actor actor) {
      actor.poseAnimation = actor.idlePoseAnimation;
      if(actor.queueSize == 0) {
         actor.field1158 = 0;
      } else {
         if(actor.animation != -1 && actor.actionAnimationDisable == 0) {
            final Sequence sequence = CombatInfo1.getAnimation(actor.animation);
            if(actor.field1216 > 0 && sequence.precedenceAnimating == 0) {
               ++actor.field1158;
               return;
            }

            if(actor.field1216 <= 0 && sequence.priority == 0) {
               ++actor.field1158;
               return;
            }
         }

         final int var10 = actor.x;
         final int var2 = actor.y;
         final int x = actor.pathX[actor.queueSize - 1] * 128 + actor.size * 64;
         final int y = actor.pathY[actor.queueSize - 1] * 128 + actor.size * 64;
         if(var10 < x) {
            if(var2 < y) {
               actor.orientation = 1280;
            } else if(var2 > y) {
               actor.orientation = 1792;
            } else {
               actor.orientation = 1536;
            }
         } else if(var10 > x) {
            if(var2 < y) {
               actor.orientation = 768;
            } else if(var2 > y) {
               actor.orientation = 256;
            } else {
               actor.orientation = 512;
            }
         } else if(var2 < y) {
            actor.orientation = 1024;
         } else if(var2 > y) {
            actor.orientation = 0;
         }

         final byte var5 = actor.pathTraversed[actor.queueSize - 1];
         if(x - var10 <= 256 && x - var10 >= -256 && y - var2 <= 256 && y - var2 >= -256) {
            int var6 = actor.orientation - actor.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = actor.rotate180Animation;
            if(var6 >= -256 && var6 <= 256) {
               var7 = actor.walkingAnimation;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = actor.rotate90LeftAnimation;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = actor.rotate90RightAnimation;
            }

            if(var7 == -1) {
               var7 = actor.walkingAnimation;
            }

            actor.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(actor instanceof NPC) {
               var9 = ((NPC)actor).composition.isClickable;
            }

            if(var9) {
               if(actor.angle != actor.orientation && actor.interacting == -1 && actor.rotation != 0) {
                  var8 = 2;
               }

               if(actor.queueSize > 2) {
                  var8 = 6;
               }

               if(actor.queueSize > 3) {
                  var8 = 8;
               }

            } else {
               if(actor.queueSize > 1) {
                  var8 = 6;
               }

               if(actor.queueSize > 2) {
                  var8 = 8;
               }

            }
             if(actor.field1158 > 0 && actor.queueSize > 1) {
                var8 = 8;
                --actor.field1158;
             }

             if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && actor.poseAnimation == actor.walkingAnimation && actor.field1169 != -1) {
               actor.poseAnimation = actor.field1169;
            }

            if(var10 != x || var2 != y) {
               if(var10 < x) {
                  actor.x += var8;
                  if(actor.x > x) {
                     actor.x = x;
                  }
               } else if(var10 > x) {
                  actor.x -= var8;
                  if(actor.x < x) {
                     actor.x = x;
                  }
               }

               if(var2 < y) {
                  actor.y += var8;
                  if(actor.y > y) {
                     actor.y = y;
                  }
               } else if(var2 > y) {
                  actor.y -= var8;
                  if(actor.y < y) {
                     actor.y = y;
                  }
               }
            }

            if(x == actor.x && y == actor.y) {
               --actor.queueSize;
               if(actor.field1216 > 0) {
                  --actor.field1216;
               }
            }

         } else {
            actor.x = x;
            actor.y = y;
            --actor.queueSize;
            if(actor.field1216 > 0) {
               --actor.field1216;
            }

         }
      }
   }
}
