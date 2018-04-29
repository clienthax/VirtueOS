package com.oldscape.client;

import java.util.LinkedList;

abstract class WorldMapDecorationInfo {
   int field406;
   int field407;
   int field420;
   int field409;
   int field410;
   int planes;
   short[][][] worldMapUnderlayColors;
   short[][][] worldMapOverlayColors;
   byte[][][] worldMapOverlayShapes;
   byte[][][] worldMapOverlayRotations;
   WorldMapDecoration[][][][] decorations;

   WorldMapDecorationInfo() {
      new LinkedList();
   }

   void method251(final int x, final int y, final Buffer buffer) {
      final int flags = buffer.readUnsignedByte();
      if(flags != 0) {
         if((flags & 1) != 0) {
            this.readMapUnderAndOverlays(x, y, buffer, flags);
         } else {
            this.readMapDecorationsAndOverlays(x, y, buffer, flags);
         }
      }
   }

   private void readMapUnderAndOverlays(final int x, final int y, final Buffer buffer, final int flags) {
      final boolean hasOverlays = (flags & 2) != 0;
      if(hasOverlays) {
         this.worldMapOverlayColors[0][x][y] = (short)buffer.readUnsignedByte();
      }

      this.worldMapUnderlayColors[0][x][y] = (short)buffer.readUnsignedByte();
   }

   private void readMapDecorationsAndOverlays(final int x, final int y, final Buffer buffer, final int flags) {
      final int levels = ((flags & 24) >> 3) + 1;
      final boolean hasOverlays = (flags & 2) != 0;
      final boolean hasMinimapObjectDecorations = (flags & 4) != 0;

      this.worldMapUnderlayColors[0][x][y] = (short)buffer.readUnsignedByte();//62 95 96 94 48 0 63 65 -- unsure..

      if(hasOverlays) {
         final int planes = buffer.readUnsignedByte();

         for(int plane = 0; plane < planes; ++plane) {
            final int var10 = buffer.readUnsignedByte();
            if(var10 != 0) {
               this.worldMapOverlayColors[plane][x][y] = (short)var10;
               final int var11 = buffer.readUnsignedByte();
               this.worldMapOverlayShapes[plane][x][y] = (byte)(var11 >> 2);//0-11
               this.worldMapOverlayRotations[plane][x][y] = (byte)(var11 & 3);//0-3
            }
         }
      }

      if(hasMinimapObjectDecorations) {//Object models on world map viewer
         for(int plane = 0; plane < levels; ++plane) {
            final int decorationCount = buffer.readUnsignedByte();
            if(decorationCount != 0) {
               final WorldMapDecoration[] worldMapDecorations = this.decorations[plane][x][y] = new WorldMapDecoration[decorationCount];

               for(int idx = 0; idx < decorationCount; ++idx) {
                  final int objectId = buffer.method3576();
                  final int bitpackedDecorationRotation = buffer.readUnsignedByte();
                  worldMapDecorations[idx] = new WorldMapDecoration(objectId, bitpackedDecorationRotation >> 2, bitpackedDecorationRotation & 3);
               }
            }
         }
      }

   }

   int method269(final int x, final int y) {
      if (x < 64 && y < 64) {
         if (x >= 0 && y >= 0) {
            return this.worldMapUnderlayColors[0][x][y] - 1;
         } else {
            return -1;
         }
      } else return -1;
   }

   int method255() {
      return this.field420;
   }

   int method256() {
      return this.field409;
   }

   static IterableHashTable readStringIntParameters(final Buffer buffer, IterableHashTable hashTable) {
      final int var2 = buffer.readUnsignedByte();
      int var3;
      if(hashTable == null) {
         var3 = GraphicsObject.nextPowerOfTwo(var2);
         hashTable = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         final boolean var4 = buffer.readUnsignedByte() == 1;
         final int var5 = buffer.read24BitInt();
         final Object var6;
         if(var4) {
            var6 = new ObjectNode(buffer.readString());
         } else {
            var6 = new IntegerNode(buffer.readInt());
         }

         hashTable.put((Node)var6, var5);
      }

      return hashTable;
   }

   @SuppressWarnings("unused")
   public static boolean method268() {
      final ClassInfo var0 = (ClassInfo)class326.classInfos.last();
      return var0 != null;
   }

   public static int encodeStringCp1252(final CharSequence var0, final int var1, final int var2, final byte[] var3, final int var4) {
      final int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         final char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   static void method275() {
      for(int idx = 0; idx < Client.queuedSoundEffectCount; ++idx) {
         --Client.audioDelays[idx];
         if(Client.audioDelays[idx] >= -10) {
            SoundEffect audioEffect = Client.audioEffects[idx];
            if(audioEffect == null) {
               audioEffect = SoundEffect.getTrack(class55.indexCache4, Client.queuedSoundEffectIDs[idx], 0);
               if(audioEffect == null) {
                  continue;
               }

               Client.audioDelays[idx] += audioEffect.calculateDelay();
               Client.audioEffects[idx] = audioEffect;
            }

            if(Client.audioDelays[idx] < 0) {
               final int var2;
               if(Client.soundLocations[idx] != 0) {
                  final int var3 = (Client.soundLocations[idx] & 255) * 128;
                  final int var4 = Client.soundLocations[idx] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - Client.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  final int var6 = Client.soundLocations[idx] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - Client.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.audioDelays[idx] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field951 / var3;
               } else {
                  var2 = Client.field1075;
               }

               if(var2 > 0) {
                  final RawAudioNode var10 = audioEffect.method2124().applyResampler(WorldMapDecoration.field446);
                  final class115 var11 = class115.method2317(var10, 100, var2);
                  var11.method2320(Client.unknownSoundValues1[idx] - 1);
                  MouseInput.field727.method2059(var11);
               }

               Client.audioDelays[idx] = -100;
            }
         } else {
            --Client.queuedSoundEffectCount;

            for(int var1 = idx; var1 < Client.queuedSoundEffectCount; ++var1) {
               Client.queuedSoundEffectIDs[var1] = Client.queuedSoundEffectIDs[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.unknownSoundValues1[var1] = Client.unknownSoundValues1[var1 + 1];
               Client.audioDelays[var1] = Client.audioDelays[var1 + 1];
               Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
            }

            --idx;
         }
      }

      if(Client.field1102) {
         final boolean var12;
         if(class229.field2687 != 0) {
            var12 = true;
         } else {
            var12 = class229.field2690.method4151();
         }

         if(!var12) {
            if(Client.field996 != 0 && Client.field1026 != -1) {
               PacketNode.method3442(PacketBuffer.indexTrack1, Client.field1026, 0, Client.field996, false);
            }

            Client.field1102 = false;
         }
      }

   }

   static void method274(final boolean var0, final PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field957.packetLength) >= 27) {
            final int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               final NPC cachedNPC = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               cachedNPC.npcCycle = Client.gameCycle;
               final int var5 = var1.getBits(1);
               if(var5 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               int var6;
               if(var0) {
                  var6 = var1.getBits(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = var1.getBits(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               final int var7 = Client.field995[var1.getBits(3)];
               if(var3) {
                  cachedNPC.orientation = cachedNPC.angle = var7;
               }

               cachedNPC.composition = NPCComposition.getNpcDefinition(var1.getBits(14));
               int var8;
               if(var0) {
                  var8 = var1.getBits(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = var1.getBits(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               final int var9 = var1.getBits(1);
               cachedNPC.size = cachedNPC.composition.size;
               cachedNPC.rotation = cachedNPC.composition.rotation;
               if(cachedNPC.rotation == 0) {
                  cachedNPC.angle = 0;
               }

               cachedNPC.walkingAnimation = cachedNPC.composition.walkingAnimation;
               cachedNPC.rotate180Animation = cachedNPC.composition.rotate180Animation;
               cachedNPC.rotate90RightAnimation = cachedNPC.composition.rotate90RightAnimation;
               cachedNPC.rotate90LeftAnimation = cachedNPC.composition.rotate90LeftAnimation;
               cachedNPC.idlePoseAnimation = cachedNPC.composition.standingAnimation;
               cachedNPC.field1163 = cachedNPC.composition.field3716;
               cachedNPC.field1164 = cachedNPC.composition.field3714;
               cachedNPC.method1874(Client.localPlayer.pathX[0] + var6, Client.localPlayer.pathY[0] + var8, var9 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}
