package com.oldscape.client;

public class CombatInfo2 extends CacheableNode {
   public static IndexDataBase field3532;
   static IndexDataBase field3528;
   public static NodeCache field3524;
   public static NodeCache field3531;
   public int field3526;
   public int field3536;
   public int field3529;
   public int field3523;
   public int field3530;
   public int field3522;
   int field3533;
   int field3534;
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

   public void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3536 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3529 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3523 = 0;
      } else if(var2 == 5) {
         this.field3522 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3533 = var1.method3576();
      } else if(var2 == 8) {
         this.field3534 = var1.method3576();
      } else if(var2 == 11) {
         this.field3523 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3525 = var1.readUnsignedByte();
      }

   }

   public SpritePixels method4862() {
      if(this.field3533 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3531.get((long)this.field3533);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SoundTaskDataProvider.method817(field3528, this.field3533, 0);
            if(var1 != null) {
               field3531.put(var1, (long)this.field3533);
            }

            return var1;
         }
      }
   }

   public SpritePixels method4863() {
      if(this.field3534 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3531.get((long)this.field3534);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SoundTaskDataProvider.method817(field3528, this.field3534, 0);
            if(var1 != null) {
               field3531.put(var1, (long)this.field3534);
            }

            return var1;
         }
      }
   }

   public static class278 method4877(int var0) {
      class278 var1 = (class278)class278.field3546.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class278.field3547.getConfigData(11, var0);
         var1 = new class278();
         if(var2 != null) {
            var1.method4901(new Buffer(var2));
         }

         var1.method4900();
         class278.field3546.put(var1, (long)var0);
         return var1;
      }
   }

   static final void processPlayerUpdateFlags(PacketBuffer buffer, int playerIdx, Player player, int flags) {
      byte movementType = -1;
      int var5;
      int var6;
      int var9;
      int var10;

      //Animation
      if((flags & 1) != 0) {
         var5 = buffer.readUnsignedShort();
         if(var5 == 65535) {
            var5 = -1;
         }

         var6 = buffer.method3538();
         GameObject.method3083(player, var5, var6);
      }

      //Appearance
      if((flags & 2) != 0) {
         var5 = buffer.readUnsignedShortOb1();
         byte[] var23 = new byte[var5];
         Buffer var24 = new Buffer(var23);
         buffer.method3661(var23, 0, var5);
         class93.field1430[playerIdx] = var24;
         player.decodeApperance(var24);
      }

      //Force chat
      if((flags & 4) != 0) {
         player.overhead = buffer.readString();
         if(player.overhead.charAt(0) == '~') {
            player.overhead = player.overhead.substring(1);
            class57.sendGameMessage(2, player.name.getName(), player.overhead);
         } else if(player == SoundTaskDataProvider.localPlayer) {
            class57.sendGameMessage(2, player.name.getName(), player.overhead);
         }

         player.field1168 = false;
         player.field1174 = 0;
         player.field1175 = 0;
         player.overheadTextCyclesRemaining = 150;
      }

      //Chat masks
      if((flags & 8) != 0) {
         var5 = buffer.method3553();
         Permission[] var17 = new Permission[]{Permission.field3345, Permission.field3344, Permission.field3346, Permission.field3349, Permission.field3350, Permission.field3347};
         Permission var18 = (Permission)Permission.forOrdinal(var17, buffer.readUnsignedShortOb1());
         boolean var21 = buffer.readUnsignedByte() == 1;
         var9 = buffer.method3538();
         var10 = buffer.offset;
         if(player.name != null && player.composition != null) {
            boolean var22 = false;
            if(var18.field3352 && WorldMapRectangle.friendManager.isIgnored(player.name)) {
               var22 = true;
            }

            if(!var22 && Client.myPlayerIndex == 0 && !player.hidden) {
               class93.field1432.offset = 0;
               buffer.method3565(class93.field1432.payload, 0, var9);
               class93.field1432.offset = 0;
               String var19 = FontTypeFace.appendTags(class303.method5406(WallObject.method3061(class93.field1432)));
               player.overhead = var19.trim();
               player.field1174 = var5 >> 8;
               player.field1175 = var5 & 255;
               player.overheadTextCyclesRemaining = 150;
               player.field1168 = var21;
               player.field1157 = player != SoundTaskDataProvider.localPlayer && var18.field3352 && "" != Client.field1085 && var19.toLowerCase().indexOf(Client.field1085) == -1;
               int var13;
               if(var18.field3351) {
                  var13 = var21?91:1;
               } else {
                  var13 = var21?90:2;
               }

               if(var18.field3348 != -1) {
                  int var16 = var18.field3348;
                  String var15 = "<img=" + var16 + ">";
                  class57.sendGameMessage(var13, var15 + player.name.getName(), var19);
               } else {
                  class57.sendGameMessage(var13, player.name.getName(), var19);
               }
            }
         }

         buffer.offset = var10 + var9;
      }

      //Face position / change direction
      if((flags & 16) != 0) {
         player.field1185 = buffer.method3555();
         if(player.queueSize == 0) {
            player.orientation = player.field1185;
            player.field1185 = -1;
         }
      }

      //face entity
      if((flags & 64) != 0) {
         player.interacting = buffer.readUnsignedShort();
         if(player.interacting == 65535) {
            player.interacting = -1;
         }
      }

      //Hit masks
      if((flags & 128) != 0) {
         var5 = buffer.method3636();
         int var7;
         int var8;
         int var11;
         if(var5 > 0) {
            for(var6 = 0; var6 < var5; ++var6) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var7 = buffer.getUSmart();
               if(var7 == 32767) {
                  var7 = buffer.getUSmart();
                  var9 = buffer.getUSmart();
                  var8 = buffer.getUSmart();
                  var10 = buffer.getUSmart();
               } else if(var7 != 32766) {
                  var9 = buffer.getUSmart();
               } else {
                  var7 = -1;
               }

               var11 = buffer.getUSmart();
               player.method1657(var7, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var6 = buffer.method3538();
         if(var6 > 0) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = buffer.getUSmart();
               var9 = buffer.getUSmart();
               if(var9 != 32767) {
                  var10 = buffer.getUSmart();
                  var11 = buffer.method3538();
                  int var12 = var9 > 0?buffer.readUnsignedShortOb1():var11;
                  player.setCombatInfo(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  player.method1659(var8);
               }
            }
         }
      }

      //GFX
      if((flags & 256) != 0) {
         player.graphic = buffer.method3553();
         var5 = buffer.method3563();
         player.field1198 = var5 >> 16;
         player.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         player.spotAnimFrame = 0;
         player.spotAnimFrameCycle = 0;
         if(player.graphicsDelay > Client.gameCycle) {
            player.spotAnimFrame = -1;
         }

         if(player.graphic == 65535) {
            player.graphic = -1;
         }
      }

      //Movement mask
      if((flags & 512) != 0) {
         movementType = buffer.method3548();
      }

      //Forced movement
      if((flags & 1024) != 0) {
         player.field1203 = buffer.readByte();
         player.field1199 = buffer.method3725();
         player.field1200 = buffer.method3548();
         player.field1202 = buffer.method3634();
         player.field1166 = buffer.method3553() + Client.gameCycle;
         player.field1204 = buffer.method3554() + Client.gameCycle;
         player.field1171 = buffer.method3555();
         if(player.field860) {
            player.field1203 += player.field861;
            player.field1199 += player.field837;
            player.field1200 += player.field861;
            player.field1202 += player.field837;
            player.queueSize = 0;
         } else {
            player.field1203 += player.pathX[0];
            player.field1199 += player.pathY[0];
            player.field1200 += player.pathX[0];
            player.field1202 += player.pathY[0];
            player.queueSize = 1;
         }

         player.field1216 = 0;
      }

      //Context menu
      if((flags & 2048) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            player.actions[var5] = buffer.readString();
         }
      }

      if((flags & 4096) != 0) {
         class93.field1429[playerIdx] = buffer.method3634();
      }


      if(player.field860) {
         if(movementType == 127) {
            player.method1196(player.field861, player.field837);
         } else {
            byte var20;
            if(movementType != -1) {
               var20 = movementType;
            } else {
               var20 = class93.field1429[playerIdx];
            }

            player.method1195(player.field861, player.field837, var20);
         }
      }

   }
}
