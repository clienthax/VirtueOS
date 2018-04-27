package com.oldscape.client;

import java.io.IOException;

public class ScriptEvent extends Node {
   Object[] objs;
   boolean boolean1;
   Widget widget;
   int field799;
   int field798;
   int field801;
   Widget field802;
   int pressedKey;
   int typedKey;
   String string;
   int field806;
   class245 field800;

   public ScriptEvent() {
      this.field800 = class245.field2972;
   }

   public void method1137(Object[] var1) {
      this.objs = var1;
   }

   public void method1138(class245 var1) {
      this.field800 = var1;
   }

   public static void method1143(class169 var0, boolean var1) {
      if(class264.NetCache_socket != null) {
         try {
            class264.NetCache_socket.vmethod3331();
         } catch (Exception var6) {
         }

         class264.NetCache_socket = null;
      }

      class264.NetCache_socket = var0;
      GraphicsObject.sendConInfo(var1);
      class264.NetCache_responseHeaderBuffer.offset = 0;
      class49.currentRequest = null;
      class47.NetCache_responseArchiveBuffer = null;
      class264.field3426 = 0;

      while(true) {
         FileRequest var2 = (FileRequest)class264.NetCache_pendingPriorityResponses.first();
         if(var2 == null) {
            while(true) {
               var2 = (FileRequest)class264.NetCache_pendingResponses.first();
               if(var2 == null) {
                  if(class264.field3429 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.putByte(4);
                        var7.putByte(class264.field3429);
                        var7.putShort(0);
                        class264.NetCache_socket.vmethod3337(var7.payload, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class264.NetCache_socket.vmethod3331();
                        } catch (Exception var4) {
                        }

                        ++class264.field3431;
                        class264.NetCache_socket = null;
                     }
                  }

                  class264.field3416 = 0;
                  BoundingBox3DDrawMode.field270 = class64.method1118();
                  return;
               }

               class264.NetCache_pendingWritesQueue.setHead(var2);
               class264.NetCache_pendingWrites.put(var2, var2.hash);
               ++class264.NetCache_pendingWritesCount;
               --class264.NetCache_pendingResponsesCount;
            }
         }

         class264.NetCache_pendingPriorityWrites.put(var2, var2.hash);
         ++class264.NetCache_pendingPriorityWritesCount;
         --class264.NetCache_pendingPriorityResponsesCount;
      }
   }

   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class93.field1439[++class93.field1438 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.playerId = var1;
            if(class93.field1430[var1] != null) {
               var6.decodeApperance(class93.field1430[var1]);
            }

            var6.orientation = class93.Players_orientations[var1];
            var6.interacting = class93.Players_targetIndices[var1];
            var7 = class93.Players_regions[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class93.field1429[var1];
            var6.field856 = (byte)var8;
            var6.method1196((var9 << 13) + var3 - class138.baseX, (var10 << 13) + var4 - class23.baseY);
            var6.field860 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class93.Players_regions[var1];
         class93.Players_regions[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class93.Players_regions[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class93.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class93.Players_regions[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class93.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }

   static final void method1141(int var0) {
      int[] var1 = BoundingBox2D.minimapSprite.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class62.tileSettings[var0][var5][var3] & 24) == 0) {
               class255.region.drawTile(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class255.region.drawTile(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      BoundingBox2D.minimapSprite.setRaster();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class62.tileSettings[var0][var6][var5] & 24) == 0) {
               MessageNode.drawObject(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               MessageNode.drawObject(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1093 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class255.region.getGroundObjectHash(BoundingBox3DDrawMode.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = GameCanvas.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.mapIcons[Client.field1093] = Area.mapAreaType[var8].getMapIcon(false);
                  Client.field1094[Client.field1093] = var5;
                  Client.field1095[Client.field1093] = var6;
                  ++Client.field1093;
               }
            }
         }
      }

      MapCacheArchiveNames.rasterProvider.setRaster();
   }
}
