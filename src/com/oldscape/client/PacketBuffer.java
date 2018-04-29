package com.oldscape.client;

public final class PacketBuffer extends Buffer {
   private static final int[] field2602;
   static IndexData indexTrack1;
   private ISAACCipher cipher;
   private int bitPosition;

   static {
      field2602 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(final int var1) {
      super(var1);
   }

   public void seed(final int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   public void setIsaacCipher(final ISAACCipher var1) {
      this.cipher = var1;
   }

   public void putOpcode(final int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   public boolean method3780() {
      final int var1 = super.payload[super.offset] - this.cipher.method3813() & 255;
      return var1 >= 128;
   }

   public int method3783() {
      final int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2602[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2602[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2602[var1];
      }

      return var4;
   }

   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   public int bitsAvail(final int var1) {
      return var1 * 8 - this.bitPosition;
   }

   static void menuAction(final int var0, final int var1, int var2, final int var3, final String var5, final int var6, final int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      final PacketNode var8;
      if(var2 == 1) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.field2393, Client.field957.field1484);
         var8.packetBuffer.method3550(class2.field16);
         var8.packetBuffer.method3528(var3 >> 14 & 32767);
         var8.packetBuffer.method3528(UrlRequester.selectedItemIndex);
         var8.packetBuffer.method3551(var0 + class138.baseX);
         var8.packetBuffer.method3559(BoundingBox.field251);
         var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3528(class23.baseY + var1);
         Client.field957.method2052(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.field2461, Client.field957.field1484);
         var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3561(class234.field2768);
         var8.packetBuffer.method3528(Client.field1025);
         var8.packetBuffer.putShort(class23.baseY + var1);
         var8.packetBuffer.method3528(var3 >> 14 & 32767);
         var8.packetBuffer.method3528(var0 + class138.baseX);
         Client.field957.method2052(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.OBJECT_ACTION_1, Client.field957.field1484);
         var8.packetBuffer.putShort(class23.baseY + var1);
         var8.packetBuffer.method3550(var0 + class138.baseX);
         var8.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         Client.field957.method2052(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.OBJECT_ACTION_2, Client.field957.field1484);
         var8.packetBuffer.putShort(var0 + class138.baseX);
         var8.packetBuffer.putShort(class23.baseY + var1);
         var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3528(var3 >> 14 & 32767);
         Client.field957.method2052(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.OBJECT_ACTION_3, Client.field957.field1484);
         var8.packetBuffer.method3551(var3 >> 14 & 32767);
         var8.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3551(class23.baseY + var1);
         var8.packetBuffer.putShort(var0 + class138.baseX);
         Client.field957.method2052(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.OBJECT_ACTION_4, Client.field957.field1484);
         var8.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.method3528(var0 + class138.baseX);
         var8.packetBuffer.method3550(class23.baseY + var1);
         Client.field957.method2052(var8);
      } else {
         final PacketNode var9;
         final NPC var16;
         if(var2 == 7) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2427, Client.field957.field1484);
               var9.packetBuffer.method3561(BoundingBox.field251);
               var9.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3550(var3);
               var9.packetBuffer.method3550(class2.field16);
               var9.packetBuffer.putShort(UrlRequester.selectedItemIndex);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 8) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2406, Client.field957.field1484);
               var9.packetBuffer.method3528(Client.field1025);
               var9.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3550(var3);
               var9.packetBuffer.putInt(class234.field2768);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 9) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.NPC_ACTION_1, Client.field957.field1484);
               var9.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3550(var3);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 10) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2474, Client.field957.field1484);
               var9.packetBuffer.method3528(var3);
               var9.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 11) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2458, Client.field957.field1484);
               var9.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3550(var3);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 12) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2473, Client.field957.field1484);
               var9.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShort(var3);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 13) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2454, Client.field957.field1484);
               var9.packetBuffer.method3528(var3);
               var9.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var9);
            }
         } else {
            final Player var18;
            if(var2 == 14) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field972 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = WorldMapRectangle.method280(ClientPacket.field2441, Client.field957.field1484);
                  var9.packetBuffer.putInt(BoundingBox.field251);
                  var9.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.putShort(class2.field16);
                  var9.packetBuffer.method3528(UrlRequester.selectedItemIndex);
                  var9.packetBuffer.method3551(var3);
                  Client.field957.method2052(var9);
               }
            } else if(var2 == 15) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field972 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = WorldMapRectangle.method280(ClientPacket.field2442, Client.field957.field1484);
                  var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.method3528(Client.field1025);
                  var9.packetBuffer.putInt(class234.field2768);
                  var9.packetBuffer.method3551(var3);
                  Client.field957.method2052(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2419, Client.field957.field1484);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3528(var0 + class138.baseX);
               var8.packetBuffer.method3551(var3);
               var8.packetBuffer.method3551(UrlRequester.selectedItemIndex);
               var8.packetBuffer.putShort(class2.field16);
               var8.packetBuffer.method3559(BoundingBox.field251);
               var8.packetBuffer.method3528(class23.baseY + var1);
               Client.field957.method2052(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2388, Client.field957.field1484);
               var8.packetBuffer.method3559(class234.field2768);
               var8.packetBuffer.putShort(class23.baseY + var1);
               var8.packetBuffer.putShort(Client.field1025);
               var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3550(var0 + class138.baseX);
               var8.packetBuffer.method3551(var3);
               Client.field957.method2052(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2453, Client.field957.field1484);
               var8.packetBuffer.method3528(class23.baseY + var1);
               var8.packetBuffer.method3550(var0 + class138.baseX);
               var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3550(var3);
               Client.field957.method2052(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2437, Client.field957.field1484);
               var8.packetBuffer.method3551(var0 + class138.baseX);
               var8.packetBuffer.method3550(var3);
               var8.packetBuffer.putShort(class23.baseY + var1);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2399, Client.field957.field1484);
               var8.packetBuffer.method3550(var0 + class138.baseX);
               var8.packetBuffer.method3528(var3);
               var8.packetBuffer.method3551(class23.baseY + var1);
               var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2416, Client.field957.field1484);
               var8.packetBuffer.method3528(var0 + class138.baseX);
               var8.packetBuffer.method3551(class23.baseY + var1);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2467, Client.field957.field1484);
               var8.packetBuffer.method3551(class23.baseY + var1);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3551(var0 + class138.baseX);
               Client.field957.method2052(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class255.region.method2997();
               } else {
                  class255.region.method2889(BoundingBox3DDrawMode.plane, var0, var1, true);
               }
            } else {
               final PacketNode var14;
               final Widget var22;
               if(var2 == 24) {
                  var22 = class44.getWidget(var1);
                  boolean var13 = true;
                  if(var22.contentType > 0) {
                     var13 = GZipDecompressor.method3461(var22);
                  }

                  if(var13) {
                     var14 = WorldMapRectangle.method280(ClientPacket.field2460, Client.field957.field1484);
                     var14.packetBuffer.putInt(var1);
                     Client.field957.method2052(var14);
                  }
               } else {
                  if(var2 == 25) {
                     var22 = FontName.getWidgetChild(var1, var0);
                     if(var22 != null) {
                        class154.method3156();
                        class55.method834(var1, var0, class250.method4502(GroundObject.getWidgetClickMask(var22)), var22.itemId);
                        Client.itemSelectionState = 0;
                        final String var24;
                        if(class250.method4502(GroundObject.getWidgetClickMask(var22)) == 0) {
                           var24 = null;
                        } else if(var22.targetVerb != null && !var22.targetVerb.trim().isEmpty()) {
                           var24 = var22.targetVerb;
                        } else {
                           var24 = null;
                        }

                        Client.field1092 = var24;
                        if(Client.field1092 == null) {
                           Client.field1092 = "Null";
                        }

                        if(var22.hasScript) {
                           Client.field1028 = var22.opBase + class45.getColTags(16777215);
                        } else {
                           Client.field1028 = class45.getColTags(65280) + var22.spellName + class45.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     var8 = WorldMapRectangle.method280(ClientPacket.field2428, Client.field957.field1484);
                     Client.field957.method2052(var8);

                     for(WidgetNode var17 = (WidgetNode)Client.componentTable.first(); var17 != null; var17 = (WidgetNode)Client.componentTable.next()) {
                        if(var17.owner == 0 || var17.owner == 3) {
                           class57.closeWidget(var17, true);
                        }
                     }

                     if(Client.field1033 != null) {
                        FontName.method5490(Client.field1033);
                        Client.field1033 = null;
                     }
                  } else {
                     final int var10;
                     final Widget var19;
                     if(var2 == 28) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2460, Client.field957.field1484);
                        var8.packetBuffer.putInt(var1);
                        Client.field957.method2052(var8);
                        var19 = class44.getWidget(var1);
                        if(var19.dynamicValues != null && var19.dynamicValues[0][0] == 5) {
                           var10 = var19.dynamicValues[0][1];
                           VarpStorage.clientVarps[var10] = 1 - VarpStorage.clientVarps[var10];
                           class18.method142(var10);
                        }
                     } else if(var2 == 29) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2460, Client.field957.field1484);
                        var8.packetBuffer.putInt(var1);
                        Client.field957.method2052(var8);
                        var19 = class44.getWidget(var1);
                        if(var19.dynamicValues != null && var19.dynamicValues[0][0] == 5) {
                           var10 = var19.dynamicValues[0][1];
                           if(VarpStorage.clientVarps[var10] != var19.field2936[0]) {
                              VarpStorage.clientVarps[var10] = var19.field2936[0];
                              class18.method142(var10);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1033 == null) {
                           TotalQuantityComparator.method98(var1, var0);
                           Client.field1033 = FontName.getWidgetChild(var1, var0);
                           FontName.method5490(Client.field1033);
                        }
                     } else if(var2 == 31) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2444, Client.field957.field1484);
                        var8.packetBuffer.method3559(BoundingBox.field251);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.method3550(class2.field16);
                        var8.packetBuffer.method3528(UrlRequester.selectedItemIndex);
                        var8.packetBuffer.method3551(var3);
                        var8.packetBuffer.method3528(var0);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2456, Client.field957.field1484);
                        var8.packetBuffer.method3559(class234.field2768);
                        var8.packetBuffer.method3559(var1);
                        var8.packetBuffer.method3551(var0);
                        var8.packetBuffer.method3550(Client.field1025);
                        var8.packetBuffer.putShort(var3);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2418, Client.field957.field1484);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.method3551(var3);
                        var8.packetBuffer.putShort(var0);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2440, Client.field957.field1484);
                        var8.packetBuffer.method3550(var0);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.method3551(var3);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2448, Client.field957.field1484);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.method3550(var0);
                        var8.packetBuffer.putShort(var3);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2383, Client.field957.field1484);
                        var8.packetBuffer.method3551(var3);
                        var8.packetBuffer.method3559(var1);
                        var8.packetBuffer.putShort(var0);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2436, Client.field957.field1484);
                        var8.packetBuffer.method3528(var3);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.putShort(var0);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           class154.method3156();
                           var22 = class44.getWidget(var1);
                           Client.itemSelectionState = 1;
                           UrlRequester.selectedItemIndex = var0;
                           BoundingBox.field251 = var1;
                           class2.field16 = var3;
                           FontName.method5490(var22);
                           Client.lastSelectedItemName = class45.getColTags(16748608) + ItemComposition.getItemDefinition(var3).name + class45.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2463, Client.field957.field1484);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.method3559(var1);
                           var8.packetBuffer.method3528(var0);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2446, Client.field957.field1484);
                           var8.packetBuffer.method3559(var1);
                           var8.packetBuffer.method3551(var3);
                           var8.packetBuffer.method3528(var0);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2439, Client.field957.field1484);
                           var8.packetBuffer.method3550(var3);
                           var8.packetBuffer.method3559(var1);
                           var8.packetBuffer.method3528(var0);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2426, Client.field957.field1484);
                           var8.packetBuffer.method3528(var3);
                           var8.packetBuffer.method3528(var0);
                           var8.packetBuffer.putInt(var1);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2449, Client.field957.field1484);
                           var8.packetBuffer.method3561(var1);
                           var8.packetBuffer.method3551(var3);
                           var8.packetBuffer.method3528(var0);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2401, Client.field957.field1484);
                              var9.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3551(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 45) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2424, Client.field957.field1484);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 46) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2407, Client.field957.field1484);
                              var9.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3528(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 47) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2431, Client.field957.field1484);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 48) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2425, Client.field957.field1484);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3551(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 49) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2472, Client.field957.field1484);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3551(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 50) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2391, Client.field957.field1484);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 51) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2387, Client.field957.field1484);
                              var9.packetBuffer.method3551(var3);
                              var9.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field957.method2052(var9);
                           }
                        } else {
                           label925: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var22 = FontName.getWidgetChild(var1, var0);
                                    if(var22 != null) {
                                       var9 = WorldMapRectangle.method280(ClientPacket.field2400, Client.field957.field1484);
                                       var9.packetBuffer.method3552(var1);
                                       var9.packetBuffer.method3561(class234.field2768);
                                       var9.packetBuffer.method3528(Client.field893);
                                       var9.packetBuffer.putShort(var22.itemId);
                                       var9.packetBuffer.method3528(var0);
                                       var9.packetBuffer.method3550(Client.field1025);
                                       Client.field957.method2052(var9);
                                    }
                                    break label925;
                                 }

                                 if(var2 == 1001) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field972 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = WorldMapRectangle.method280(ClientPacket.OBJECT_ACTION_5, Client.field957.field1484);
                                    var8.packetBuffer.method3528(class23.baseY + var1);
                                    var8.packetBuffer.method3528(var3 >> 14 & 32767);
                                    var8.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
                                    var8.packetBuffer.method3528(var0 + class138.baseX);
                                    Client.field957.method2052(var8);
                                    break label925;
                                 }

                                 if(var2 == 1002) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field972 = 0;
                                    var8 = WorldMapRectangle.method280(ClientPacket.field2412, Client.field957.field1484);
                                    var8.packetBuffer.method3550(var3 >> 14 & 32767);
                                    Client.field957.method2052(var8);
                                    break label925;
                                 }

                                 if(var2 == 1003) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field972 = 0;
                                    var16 = Client.cachedNPCs[var3];
                                    if(var16 != null) {
                                       NPCComposition var23 = var16.composition;
                                       if(var23.configs != null) {
                                          var23 = var23.transform();
                                       }

                                       if(var23 != null) {
                                          var14 = WorldMapRectangle.method280(ClientPacket.field2455, Client.field957.field1484);
                                          var14.packetBuffer.method3550(var23.id);
                                          Client.field957.method2052(var14);
                                       }
                                    }
                                    break label925;
                                 }

                                 if(var2 == 1004) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field972 = 0;
                                    var8 = WorldMapRectangle.method280(ClientPacket.field2438, Client.field957.field1484);
                                    var8.packetBuffer.method3528(var3);
                                    Client.field957.method2052(var8);
                                    break label925;
                                 }

                                 if(var2 == 1005) {
                                    var22 = class44.getWidget(var1);
                                    if(var22 != null && var22.itemQuantities[var0] >= 100000) {
                                       class57.sendGameMessage(27, "", var22.itemQuantities[var0] + " x " + ItemComposition.getItemDefinition(var3).name);
                                    } else {
                                       var9 = WorldMapRectangle.method280(ClientPacket.field2438, Client.field957.field1484);
                                       var9.packetBuffer.method3528(var3);
                                       Client.field957.method2052(var9);
                                    }

                                    Client.mouseCrosshair = 0;
                                    class2.field17 = class44.getWidget(var1);
                                    Client.pressedItemIndex = var0;
                                    break label925;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1011 || var2 == 1009 || var2 == 1008 || var2 == 1010 || var2 == 1012) {
                                       Preferences.renderOverview.onMapClicked(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label925;
                                 }
                              }

                              var22 = FontName.getWidgetChild(var1, var0);
                              if(var22 != null) {
                                 final int var20 = var22.itemId;
                                 final Widget var21 = FontName.getWidgetChild(var1, var0);
                                 if(var21 != null) {
                                    if(var21.onOpListener != null) {
                                       final ScriptEvent var11 = new ScriptEvent();
                                       var11.widget = var21;
                                       var11.field801 = var3;
                                       var11.string = var5;
                                       var11.objs = var21.onOpListener;
                                       AbstractSoundSystem.method2256(var11);
                                    }

                                    boolean var15 = true;
                                    if(var21.contentType > 0) {
                                       var15 = GZipDecompressor.method3461(var21);
                                    }

                                    if(var15 && DynamicObject.method2021(GroundObject.getWidgetClickMask(var21), var3 - 1)) {
                                       PacketNode var12;
                                       if(var3 == 1) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_1, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 2) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_2, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 3) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_3, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 4) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_4, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 5) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_5, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 6) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_6, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 7) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_7, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 8) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_8, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 9) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_9, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 10) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.BUTTON_ACTION_10, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if(Client.itemSelectionState != 0) {
         Client.itemSelectionState = 0;
         FontName.method5490(class44.getWidget(BoundingBox.field251));
      }

      if(Client.spellSelected) {
         class154.method3156();
      }

      if(class2.field17 != null && Client.mouseCrosshair == 0) {
         FontName.method5490(class2.field17);
      }

   }
}
