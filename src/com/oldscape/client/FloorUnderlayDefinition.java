package com.oldscape.client;

public class FloorUnderlayDefinition extends CacheableNode {
   static IndexDataBase underlay_ref;
   static final NodeCache underlays;
    private int rgbColor;
   int hue;
   int saturation;
   int lightness;
   int hueMultiplier;

   static {
      underlays = new NodeCache(64);
   }

   FloorUnderlayDefinition() {
      this.rgbColor = 0;
   }

   static FloorUnderlayDefinition getUnderlayDefinition(final int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition) underlays.get(var0);
       if (var1 == null) {
           final byte[] var2 = underlay_ref.getConfigData(1, var0);
           var1 = new FloorUnderlayDefinition();
           if (var2 != null) {
               var1.decode(new Buffer(var2));
           }

           var1.post();
           underlays.put(var1, var0);
       }
       return var1;
   }

   void post() {
      this.setHSL(this.rgbColor);
   }

   void decode(final Buffer buffer) {
      while(true) {
         final int var3 = buffer.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.processOpcode(buffer, var3);
      }
   }

   private void processOpcode(final Buffer buffer, final int var2) {
      if(var2 == 1) {
         this.rgbColor = buffer.read24BitInt();
      }

   }

   private void setHSL(final int var1) {
      final double var2 = (var1 >> 16 & 255) / 256.0D;
      final double var4 = (var1 >> 8 & 255) / 256.0D;
      final double var6 = (var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      final double var16 = (var10 + var8) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.saturation = (int)(256.0D * var14);
      this.lightness = (int)(256.0D * var16);
      if(this.saturation < 0) {
         this.saturation = 0;
      } else if(this.saturation > 255) {
         this.saturation = 255;
      }

      if(this.lightness < 0) {
         this.lightness = 0;
      } else if(this.lightness > 255) {
         this.lightness = 255;
      }

      if(var16 > 0.5D) {
         this.hueMultiplier = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.hueMultiplier = (int)(var16 * var14 * 512.0D);
      }

      if(this.hueMultiplier < 1) {
         this.hueMultiplier = 1;
      }

      this.hue = (int)(this.hueMultiplier * var12);
   }

   static void runScript(final ScriptEvent scriptEvent, final int var1) {
      final Object[] objArgs = scriptEvent.objs;
      Script script;
      int var20;
      if(class279.method4922(scriptEvent.field800)) {
         class20.scriptMapIconReference = (MapIconReference)objArgs[0];
         final Area var4 = Area.mapAreaType[class20.scriptMapIconReference.areaId];
         script = class178.method3431(scriptEvent.field800, var4.id, var4.field3473);
      } else {
         var20 = (Integer) objArgs[0];
         script = WorldMapDecoration.method313(var20);
      }

      if(script != null) {
         Cs2Methods.intStackSize = 0;
         KeyFocusListener.scriptStringStackSize = 0;
         var20 = -1;
         int[] var5 = script.instructions;
         int[] var6 = script.intOperands;
         final byte var7 = -1;
         class81.scriptStackCount = 0;

         int var10;
         try {
            class81.scriptLocalInts = new int[script.localIntCount];
            int var8 = 0;
            class81.scriptLocalStrings = new String[script.localStringCount];
            int var9 = 0;

            int var11;
            String var21;
            for(var10 = 1; var10 < objArgs.length; ++var10) {
               if(objArgs[var10] instanceof Integer) {
                  var11 = (Integer) objArgs[var10];
                  if(var11 == -2147483647) {
                     var11 = scriptEvent.field799;
                  }

                  if(var11 == -2147483646) {
                     var11 = scriptEvent.field798;
                  }

                  if(var11 == -2147483645) {
                     var11 = scriptEvent.widget != null?scriptEvent.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = scriptEvent.field801;
                  }

                  if(var11 == -2147483643) {
                     var11 = scriptEvent.widget != null?scriptEvent.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = scriptEvent.field802 != null?scriptEvent.field802.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = scriptEvent.field802 != null?scriptEvent.field802.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = scriptEvent.pressedKey;
                  }

                  if(var11 == -2147483639) {
                     var11 = scriptEvent.typedKey;
                  }

                  class81.scriptLocalInts[var8++] = var11;
               } else if(objArgs[var10] instanceof String) {
                  var21 = (String)objArgs[var10];
                  if(var21.equals("event_opbase")) {
                     var21 = scriptEvent.string;
                  }

                  class81.scriptLocalStrings[var9++] = var21;
               }
            }

            var10 = 0;
            class81.field1288 = scriptEvent.field806;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label316:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var20;
                                                                                          final int var31 = var5[var20];
                                                                                          final int var26;
                                                                                          if(var31 < 100) {
                                                                                             if(var31 != 0) {
                                                                                                if(var31 != 1) {
                                                                                                   if(var31 != 2) {
                                                                                                      if(var31 != 3) {
                                                                                                         if(var31 != 6) {
                                                                                                            if(var31 != 7) {
                                                                                                               if(var31 != 8) {
                                                                                                                  if(var31 != 9) {
                                                                                                                     if(var31 != 10) {
                                                                                                                        if(var31 != 21) {
                                                                                                                           if(var31 != 25) {
                                                                                                                              if(var31 != 27) {
                                                                                                                                 if(var31 != 31) {
                                                                                                                                    if(var31 != 32) {
                                                                                                                                       if(var31 != 33) {
                                                                                                                                          if(var31 != 34) {
                                                                                                                                             if(var31 != 35) {
                                                                                                                                                if(var31 != 36) {
                                                                                                                                                   int var22;
                                                                                                                                                   if(var31 != 37) {
                                                                                                                                                      if(var31 != 38) {
                                                                                                                                                         if(var31 != 39) {
                                                                                                                                                            if(var31 != 40) {
                                                                                                                                                               if(var31 != 42) {
                                                                                                                                                                  if(var31 != 43) {
                                                                                                                                                                     if(var31 == 44) {
                                                                                                                                                                        var11 = var6[var20] >> 16;
                                                                                                                                                                        var26 = var6[var20] & 65535;
                                                                                                                                                                        final int var27 = class81.intStack[--Cs2Methods.intStackSize];
                                                                                                                                                                        if(var27 >= 0 && var27 <= 5000) {
                                                                                                                                                                           class81.field1282[var11] = var27;
                                                                                                                                                                           byte var35 = -1;
                                                                                                                                                                           if(var26 == 105) {
                                                                                                                                                                              var35 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var22 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var22 >= var27) {
                                                                                                                                                                                 continue label316;
                                                                                                                                                                              }

                                                                                                                                                                              class81.cs2Arrays[var11][var22] = var35;
                                                                                                                                                                              ++var22;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var31 == 45) {
                                                                                                                                                                        var11 = var6[var20];
                                                                                                                                                                        var26 = class81.intStack[--Cs2Methods.intStackSize];
                                                                                                                                                                        if(var26 < 0 || var26 >= class81.field1282[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.intStack[++Cs2Methods.intStackSize - 1] = class81.cs2Arrays[var11][var26];
                                                                                                                                                                     } else if(var31 == 46) {
                                                                                                                                                                        var11 = var6[var20];
                                                                                                                                                                        Cs2Methods.intStackSize -= 2;
                                                                                                                                                                        var26 = class81.intStack[Cs2Methods.intStackSize];
                                                                                                                                                                        if(var26 < 0 || var26 >= class81.field1282[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.cs2Arrays[var11][var26] = class81.intStack[Cs2Methods.intStackSize + 1];
                                                                                                                                                                     } else if(var31 == 47) {
                                                                                                                                                                        var21 = SceneTilePaint.varcs.getVarcString(var6[var20]);
                                                                                                                                                                        if(var21 == null) {
                                                                                                                                                                           var21 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var21;
                                                                                                                                                                     } else if(var31 == 48) {
                                                                                                                                                                        SceneTilePaint.varcs.putVarcString(var6[var20], class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var31 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        final IterableHashTable var39 = script.switches[var6[var20]];
                                                                                                                                                                        final IntegerNode var34 = (IntegerNode)var39.get(class81.intStack[--Cs2Methods.intStackSize]);
                                                                                                                                                                        if(var34 != null) {
                                                                                                                                                                           var20 += var34.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     SceneTilePaint.varcs.putVarc(var6[var20], class81.intStack[--Cs2Methods.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class81.intStack[++Cs2Methods.intStackSize - 1] = SceneTilePaint.varcs.getVarc(var6[var20]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var6[var20];
                                                                                                                                                               final Script var33 = WorldMapDecoration.method313(var11);
                                                                                                                                                               final int[] var32 = new int[var33.localIntCount];
                                                                                                                                                               final String[] var25 = new String[var33.localStringCount];

                                                                                                                                                               for(var22 = 0; var22 < var33.intStackCount; ++var22) {
                                                                                                                                                                  var32[var22] = class81.intStack[var22 + (Cs2Methods.intStackSize - var33.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var22 = 0; var22 < var33.stringStackCount; ++var22) {
                                                                                                                                                                  var25[var22] = class81.scriptStringStack[var22 + (KeyFocusListener.scriptStringStackSize - var33.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               Cs2Methods.intStackSize -= var33.intStackCount;
                                                                                                                                                               KeyFocusListener.scriptStringStackSize -= var33.stringStackCount;
                                                                                                                                                               final ScriptState var36 = new ScriptState();
                                                                                                                                                               var36.invokedFromScript = script;
                                                                                                                                                               var36.invokedFromPc = var20;
                                                                                                                                                               var36.savedLocalInts = class81.scriptLocalInts;
                                                                                                                                                               var36.savedLocalStrings = class81.scriptLocalStrings;
                                                                                                                                                               class81.scriptStack[++class81.scriptStackCount - 1] = var36;
                                                                                                                                                               script = var33;
                                                                                                                                                               var5 = var33.instructions;
                                                                                                                                                               var6 = var33.intOperands;
                                                                                                                                                               var20 = -1;
                                                                                                                                                               class81.scriptLocalInts = var32;
                                                                                                                                                               class81.scriptLocalStrings = var25;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --KeyFocusListener.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --Cs2Methods.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var6[var20];
                                                                                                                                                      KeyFocusListener.scriptStringStackSize -= var11;
                                                                                                                                                      final String[] var13 = class81.scriptStringStack;
                                                                                                                                                      final int var14 = KeyFocusListener.scriptStringStackSize;
                                                                                                                                                      final String var12;
                                                                                                                                                      if(var11 == 0) {
                                                                                                                                                         var12 = "";
                                                                                                                                                      } else if(var11 == 1) {
                                                                                                                                                         final String var15 = var13[var14];
                                                                                                                                                         if(var15 == null) {
                                                                                                                                                            var12 = "null";
                                                                                                                                                         } else {
                                                                                                                                                            var12 = var15;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         var22 = var11 + var14;
                                                                                                                                                         int var16 = 0;

                                                                                                                                                         for(int var17 = var14; var17 < var22; ++var17) {
                                                                                                                                                            final String var18 = var13[var17];
                                                                                                                                                            if(var18 == null) {
                                                                                                                                                               var16 += 4;
                                                                                                                                                            } else {
                                                                                                                                                               var16 += var18.length();
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         final StringBuilder var23 = new StringBuilder(var16);

                                                                                                                                                         for(int var24 = var14; var24 < var22; ++var24) {
                                                                                                                                                            final String var19 = var13[var24];
                                                                                                                                                            if(var19 == null) {
                                                                                                                                                               var23.append("null");
                                                                                                                                                            } else {
                                                                                                                                                               var23.append(var19);
                                                                                                                                                            }
                                                                                                                                                         }

                                                                                                                                                         var12 = var23.toString();
                                                                                                                                                      }

                                                                                                                                                      class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var12;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class81.scriptLocalStrings[var6[var20]] = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = class81.scriptLocalStrings[var6[var20]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class81.scriptLocalInts[var6[var20]] = class81.intStack[--Cs2Methods.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++Cs2Methods.intStackSize - 1] = class81.scriptLocalInts[var6[var20]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       Cs2Methods.intStackSize -= 2;
                                                                                                                                       if(class81.intStack[Cs2Methods.intStackSize] >= class81.intStack[Cs2Methods.intStackSize + 1]) {
                                                                                                                                          var20 += var6[var20];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    Cs2Methods.intStackSize -= 2;
                                                                                                                                    if(class81.intStack[Cs2Methods.intStackSize] <= class81.intStack[Cs2Methods.intStackSize + 1]) {
                                                                                                                                       var20 += var6[var20];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var6[var20];
                                                                                                                                 class315.method5614(var11, class81.intStack[--Cs2Methods.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var6[var20];
                                                                                                                              class81.intStack[++Cs2Methods.intStackSize - 1] = Varbit.getVarbit(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class81.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           final ScriptState var38 = class81.scriptStack[--class81.scriptStackCount];
                                                                                                                           script = var38.invokedFromScript;
                                                                                                                           var5 = script.instructions;
                                                                                                                           var6 = script.intOperands;
                                                                                                                           var20 = var38.invokedFromPc;
                                                                                                                           class81.scriptLocalInts = var38.savedLocalInts;
                                                                                                                           class81.scriptLocalStrings = var38.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        Cs2Methods.intStackSize -= 2;
                                                                                                                        if(class81.intStack[Cs2Methods.intStackSize] > class81.intStack[Cs2Methods.intStackSize + 1]) {
                                                                                                                           var20 += var6[var20];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     Cs2Methods.intStackSize -= 2;
                                                                                                                     if(class81.intStack[Cs2Methods.intStackSize] < class81.intStack[Cs2Methods.intStackSize + 1]) {
                                                                                                                        var20 += var6[var20];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  Cs2Methods.intStackSize -= 2;
                                                                                                                  if(class81.intStack[Cs2Methods.intStackSize] == class81.intStack[Cs2Methods.intStackSize + 1]) {
                                                                                                                     var20 += var6[var20];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               Cs2Methods.intStackSize -= 2;
                                                                                                               if(class81.intStack[Cs2Methods.intStackSize] != class81.intStack[Cs2Methods.intStackSize + 1]) {
                                                                                                                  var20 += var6[var20];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var20 += var6[var20];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = script.stringOperands[var20];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var6[var20];
                                                                                                      VarpStorage.clientVarps[var11] = class81.intStack[--Cs2Methods.intStackSize];
                                                                                                      class18.method142(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var6[var20];
                                                                                                   class81.intStack[++Cs2Methods.intStackSize - 1] = VarpStorage.clientVarps[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class81.intStack[++Cs2Methods.intStackSize - 1] = var6[var20];
                                                                                             }
                                                                                          } else {
                                                                                             final boolean var37;
                                                                                             var37 = script.intOperands[var20] == 1;

                                                                                             var26 = Cs2Methods.processCs2Opcode(var31, var37);
                                                                                             switch(var26) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
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
                     }
                  }
               }
            }
         } catch (final Exception var30) {
            final StringBuilder var29 = new StringBuilder(30);
            var29.append("").append(script.hash).append(" ");

            for(var10 = class81.scriptStackCount - 1; var10 >= 0; --var10) {
               var29.append("").append(class81.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var29.append("").append(var7);
            Signlink.processClientError(var29.toString(), var30);
         }
      }
   }
}
