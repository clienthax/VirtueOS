package com.oldscape.client;

class class46 extends WorldMapDecorationInfo {
   static class320 field579;
   static int field578;
   private int field580;
   private int field575;
   private int field576;
   private int field577;

   void method677(final Buffer var1, final Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field498.field500) {
         throw new IllegalStateException("");
      } else {
         super.field410 = var2.readUnsignedByte();
         super.planes = var2.readUnsignedByte();
         super.field406 = var2.readUnsignedShort();
         super.field407 = var2.readUnsignedShort();
         this.field580 = var2.readUnsignedByte();
         this.field575 = var2.readUnsignedByte();
         super.field420 = var2.readUnsignedShort();
         super.field409 = var2.readUnsignedShort();
         this.field576 = var2.readUnsignedByte();
         this.field577 = var2.readUnsignedByte();
         super.planes = Math.min(super.planes, 4);
         super.worldMapUnderlayColors = new short[1][64][64];
         super.worldMapOverlayColors = new short[super.planes][64][64];
         super.worldMapOverlayShapes = new byte[super.planes][64][64];
         super.worldMapOverlayRotations = new byte[super.planes][64][64];
         super.decorations = new WorldMapDecoration[super.planes][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field493.field496) {
            throw new IllegalStateException("");
         } else {
            final int var4 = var1.readUnsignedByte();
            final int var5 = var1.readUnsignedByte();
            final int var6 = var1.readUnsignedByte();
            final int var7 = var1.readUnsignedByte();
            if(var4 == super.field420 && var5 == super.field409 && var6 == this.field576 && var7 == this.field577) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method251(var8 + this.field576 * 8, var9 + this.field577 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   boolean method678(final int var1, final int var2) {
      return var1 >= this.field576 * 8 && (var2 >= this.field577 * 8 && (var1 < this.field576 * 8 + 8 && var2 < this.field577 * 8 + 8));
   }

   int method679() {
      return this.field580;
   }

   int method680() {
      return this.field575;
   }

   int method681() {
      return this.field576;
   }

   int method682() {
      return this.field577;
   }

   public boolean equals(final Object var1) {
      if(!(var1 instanceof class46)) {
         return false;
      } else {
         final class46 var2 = (class46)var1;
         return (var2.field420 == super.field420 && super.field409 == var2.field409) && (this.field576 == var2.field576 && this.field577 == var2.field577);
      }
   }

   public int hashCode() {
      return super.field420 | super.field409 << 8 | this.field576 << 16 | this.field577 << 24;
   }

   static boolean method705(final int var0, final int var1, final int var2, final class178 var3, final CollisionData collisionData) {
      int var5 = var0;
      int var6 = var1;
      final byte var7 = 64;
      final byte var8 = 64;
      final int var9 = var0 - var7;
      final int var10 = var1 - var8;
      class177.field2285[var7][var8] = 99;
      class177.field2286[var7][var8] = 0;
      final byte var11 = 0;
      int var12 = 0;
      class177.field2290[var11] = var0;
      int var20 = var11 + 1;
      class177.field2287[var11] = var1;
      final int[][] var13 = collisionData.flags;

      while(true) {
         label304:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label281:
                     do {
                        if(var20 == var12) {
                           class177.field2283 = var5;
                           class177.field2289 = var6;
                           return false;
                        }

                        var5 = class177.field2290[var12];
                        var6 = class177.field2287[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - collisionData.x;
                        var15 = var6 - collisionData.y;
                        if(var3.vmethod3428(var2, var5, var6, collisionData)) {
                           class177.field2283 = var5;
                           class177.field2289 = var6;
                           return true;
                        }

                        var16 = class177.field2286[var18][var19] + 1;
                        if(var18 > 0 && class177.field2285[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2290[var20] = var5 - 1;
                                 class177.field2287[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18 - 1][var19] = 2;
                                 class177.field2286[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class177.field2285[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2290[var20] = var5 + 1;
                                 class177.field2287[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18 + 1][var19] = 8;
                                 class177.field2286[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class177.field2285[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2290[var20] = var5;
                                 class177.field2287[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18][var19 - 1] = 1;
                                 class177.field2286[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class177.field2285[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class177.field2290[var20] = var5;
                                 class177.field2287[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18][var19 + 1] = 4;
                                 class177.field2286[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class177.field2285[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class177.field2290[var20] = var5 - 1;
                                 class177.field2287[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18 - 1][var19 - 1] = 3;
                                 class177.field2286[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class177.field2285[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class177.field2290[var20] = var5 + 1;
                                 class177.field2287[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class177.field2285[var18 + 1][var19 - 1] = 9;
                                 class177.field2286[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class177.field2285[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label281;
                              }
                           }

                           class177.field2290[var20] = var5 - 1;
                           class177.field2287[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class177.field2285[var18 - 1][var19 + 1] = 6;
                           class177.field2286[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class177.field2285[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                  continue label304;
               }
            }

            class177.field2290[var20] = var5 + 1;
            class177.field2287[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class177.field2285[var18 + 1][var19 + 1] = 12;
            class177.field2286[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   static void method685(final Actor actor) {
      if(actor.rotation != 0) {
         if(actor.interacting != -1) {
            final Actor cachedActor;
            if(actor.interacting < 32768) {
               cachedActor = Client.cachedNPCs[actor.interacting];
            } else {
               cachedActor = Client.cachedPlayers[actor.interacting - 32768];
            }

            if(cachedActor != null) {
               final int var2 = actor.x - cachedActor.x;
               final int var3 = actor.y - cachedActor.y;
               if(var2 != 0 || var3 != 0) {
                  actor.orientation = (int)(Math.atan2(var2, var3) * 325.949D) & 2047;
               }
            } else if(actor.field1156) {
               actor.interacting = -1;
               actor.field1156 = false;
            }
         }

         if(actor.field1185 != -1 && (actor.queueSize == 0 || actor.field1158 > 0)) {
            actor.orientation = actor.field1185;
            actor.field1185 = -1;
         }

         final int var4 = actor.orientation - actor.angle & 2047;
         if(var4 == 0 && actor.field1156) {
            actor.interacting = -1;
            actor.field1156 = false;
         }

         if(var4 != 0) {
            ++actor.field1184;
            boolean var6;
            if(var4 > 1024) {
               actor.angle -= actor.rotation;
               var6 = true;
               if(var4 < actor.rotation || var4 > 2048 - actor.rotation) {
                  actor.angle = actor.orientation;
                  var6 = false;
               }

               if(actor.idlePoseAnimation == actor.poseAnimation && (actor.field1184 > 25 || var6)) {
                  if(actor.field1163 != -1) {
                     actor.poseAnimation = actor.field1163;
                  } else {
                     actor.poseAnimation = actor.walkingAnimation;
                  }
               }
            } else {
               actor.angle += actor.rotation;
               var6 = true;
               if(var4 < actor.rotation || var4 > 2048 - actor.rotation) {
                  actor.angle = actor.orientation;
                  var6 = false;
               }

               if(actor.idlePoseAnimation == actor.poseAnimation && (actor.field1184 > 25 || var6)) {
                  if(actor.field1164 != -1) {
                     actor.poseAnimation = actor.field1164;
                  } else {
                     actor.poseAnimation = actor.walkingAnimation;
                  }
               }
            }

            actor.angle &= 2047;
         } else {
            actor.field1184 = 0;
         }

      }
   }
}
