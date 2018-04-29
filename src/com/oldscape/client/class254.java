package com.oldscape.client;

public enum class254 implements Enumerated {
   field3324(6, 0),
   field3322(5, 1),
   field3323(2, 2),
   field3327(0, 3),
   field3325(3, 4),
   field3326(1, 5),
   field3321(4, 6),
   field3328(7, 7);

   public final int field3329;
   final int field3330;

   class254(final int var3, final int var4) {
      this.field3329 = var3;
      this.field3330 = var4;
   }

   public int rsOrdinal() {
      return this.field3330;
   }

   static int getSmoothNoise2D(final int var0, final int var1) {
      final int var2 = CacheFile.method2544(var0 - 1, var1 - 1) + CacheFile.method2544(var0 + 1, var1 - 1) + CacheFile.method2544(var0 - 1, var1 + 1) + CacheFile.method2544(1 + var0, 1 + var1);
      final int var3 = CacheFile.method2544(var0 - 1, var1) + CacheFile.method2544(var0 + 1, var1) + CacheFile.method2544(var0, var1 - 1) + CacheFile.method2544(var0, var1 + 1);
      final int var4 = CacheFile.method2544(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   static void method4508(final int var0, final int var1, final int var2, final int var3, final int objectId, final int var5, final int var6, final Region region, final CollisionData collisionData) {
      final ObjectComposition objectDefinition = GameCanvas.getObjectDefinition(objectId);
      final int var10;
      final int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = objectDefinition.width;
         var11 = objectDefinition.length;
      } else {
         var10 = objectDefinition.length;
         var11 = objectDefinition.width;
      }

      final int var12;
      final int var13;
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      final int var14;
      final int var15;
      if(var3 + var11 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (var11 + 1 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      final int[][] var16 = class62.tileHeights[var1];
      final int var17 = var16[var12][var15] + var16[var13][var14] + var16[var12][var14] + var16[var13][var15] >> 2;
      final int var18 = (var2 << 7) + (var10 << 6);
      final int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + var2 + (objectId << 14) + 0x40000000;//1073741824
      if(objectDefinition.int1 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(objectDefinition.supportItems == 1) {
         var21 += 256;
      }

      final Renderable renderable;
      if(var6 == 22) {
         if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
            renderable = objectDefinition.method4999(22, var5, var16, var18, var17, var19);
         } else {
            renderable = new DynamicObject(objectId, 22, var5, var1, var2, var3, objectDefinition.animationId, true, null);
         }

         region.groundObjectSpawned(var0, var2, var3, var17, renderable, var20, var21);
         if(objectDefinition.clipType == 1) {
            collisionData.method3385(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
               renderable = objectDefinition.method4999(var6, var5, var16, var18, var17, var19);
            } else {
               renderable = new DynamicObject(objectId, var6, var5, var1, var2, var3, objectDefinition.animationId, true, null);
            }

            region.method2862(var0, var2, var3, var17, 1, 1, renderable, 0, var20, var21);
            if(objectDefinition.clipType != 0) {
               collisionData.addObject(var2, var3, var10, var11, objectDefinition.blocksProjectile);
            }

         } else if(var6 == 0) {
            if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
               renderable = objectDefinition.method4999(0, var5, var16, var18, var17, var19);
            } else {
               renderable = new DynamicObject(objectId, 0, var5, var1, var2, var3, objectDefinition.animationId, true, null);
            }

            region.addBoundary(var0, var2, var3, var17, renderable, null, class62.field749[var5], 0, var20, var21);
            if(objectDefinition.clipType != 0) {
               collisionData.method3391(var2, var3, var6, var5, objectDefinition.blocksProjectile);
            }

         } else if(var6 == 1) {
            if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
               renderable = objectDefinition.method4999(1, var5, var16, var18, var17, var19);
            } else {
               renderable = new DynamicObject(objectId, 1, var5, var1, var2, var3, objectDefinition.animationId, true, null);
            }

            region.addBoundary(var0, var2, var3, var17, renderable, null, class62.field746[var5], 0, var20, var21);
            if(objectDefinition.clipType != 0) {
               collisionData.method3391(var2, var3, var6, var5, objectDefinition.blocksProjectile);
            }

         } else {
            final Renderable var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               final Renderable var23;
               if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
                  var23 = objectDefinition.method4999(2, var5 + 4, var16, var18, var17, var19);
                  var24 = objectDefinition.method4999(2, var27, var16, var18, var17, var19);
               } else {
                  var23 = new DynamicObject(objectId, 2, var5 + 4, var1, var2, var3, objectDefinition.animationId, true, null);
                  var24 = new DynamicObject(objectId, 2, var27, var1, var2, var3, objectDefinition.animationId, true, null);
               }

               region.addBoundary(var0, var2, var3, var17, var23, var24, class62.field749[var5], class62.field749[var27], var20, var21);
               if(objectDefinition.clipType != 0) {
                  collisionData.method3391(var2, var3, var6, var5, objectDefinition.blocksProjectile);
               }

            } else if(var6 == 3) {
               if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
                  renderable = objectDefinition.method4999(3, var5, var16, var18, var17, var19);
               } else {
                  renderable = new DynamicObject(objectId, 3, var5, var1, var2, var3, objectDefinition.animationId, true, null);
               }

               region.addBoundary(var0, var2, var3, var17, renderable, null, class62.field746[var5], 0, var20, var21);
               if(objectDefinition.clipType != 0) {
                  collisionData.method3391(var2, var3, var6, var5, objectDefinition.blocksProjectile);
               }

            } else if(var6 == 9) {
               if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
                  renderable = objectDefinition.method4999(var6, var5, var16, var18, var17, var19);
               } else {
                  renderable = new DynamicObject(objectId, var6, var5, var1, var2, var3, objectDefinition.animationId, true, null);
               }

               region.method2862(var0, var2, var3, var17, 1, 1, renderable, 0, var20, var21);
               if(objectDefinition.clipType != 0) {
                  collisionData.addObject(var2, var3, var10, var11, objectDefinition.blocksProjectile);
               }

            } else if(var6 == 4) {
               if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
                  renderable = objectDefinition.method4999(4, var5, var16, var18, var17, var19);
               } else {
                  renderable = new DynamicObject(objectId, 4, var5, var1, var2, var3, objectDefinition.animationId, true, null);
               }

               region.addBoundaryDecoration(var0, var2, var3, var17, renderable, null, class62.field749[var5], 0, 0, 0, var20, var21);
            } else {
               final int var28;
               if(var6 == 5) {
                  var27 = 16;
                  var28 = region.getWallObjectHash(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = GameCanvas.getObjectDefinition(var28 >> 14 & 32767).decorDisplacement;
                  }

                  if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
                     var24 = objectDefinition.method4999(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(objectId, 4, var5, var1, var2, var3, objectDefinition.animationId, true, null);
                  }

                  region.addBoundaryDecoration(var0, var2, var3, var17, var24, null, class62.field749[var5], 0, var27 * class62.field738[var5], var27 * class62.field740[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var28 = region.getWallObjectHash(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = GameCanvas.getObjectDefinition(var28 >> 14 & 32767).decorDisplacement / 2;
                  }

                  if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
                     var24 = objectDefinition.method4999(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(objectId, 4, var5 + 4, var1, var2, var3, objectDefinition.animationId, true, null);
                  }

                  region.addBoundaryDecoration(var0, var2, var3, var17, var24, null, 256, var5, var27 * class62.field752[var5], var27 * class62.field750[var5], var20, var21);
               } else if(var6 == 7) {
                  var28 = var5 + 2 & 3;
                  if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
                     renderable = objectDefinition.method4999(4, var28 + 4, var16, var18, var17, var19);
                  } else {
                     renderable = new DynamicObject(objectId, 4, var28 + 4, var1, var2, var3, objectDefinition.animationId, true, null);
                  }

                  region.addBoundaryDecoration(var0, var2, var3, var17, renderable, null, 256, var28, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var28 = region.getWallObjectHash(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = GameCanvas.getObjectDefinition(var28 >> 14 & 32767).decorDisplacement / 2;
                  }

                  final int var26 = var5 + 2 & 3;
                  final Renderable var25;
                  if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
                     var24 = objectDefinition.method4999(4, var5 + 4, var16, var18, var17, var19);
                     var25 = objectDefinition.method4999(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(objectId, 4, var5 + 4, var1, var2, var3, objectDefinition.animationId, true, null);
                     var25 = new DynamicObject(objectId, 4, var26 + 4, var1, var2, var3, objectDefinition.animationId, true, null);
                  }

                  region.addBoundaryDecoration(var0, var2, var3, var17, var24, var25, 256, var5, var27 * class62.field752[var5], var27 * class62.field750[var5], var20, var21);
               }
            }
         }
      } else {
         if(objectDefinition.animationId == -1 && objectDefinition.impostorIds == null) {
            renderable = objectDefinition.method4999(10, var5, var16, var18, var17, var19);
         } else {
            renderable = new DynamicObject(objectId, 10, var5, var1, var2, var3, objectDefinition.animationId, true, null);
         }

         if(renderable != null) {
            region.method2862(var0, var2, var3, var17, var10, var11, renderable, var6 == 11?256:0, var20, var21);
         }

         if(objectDefinition.clipType != 0) {
            collisionData.addObject(var2, var3, var10, var11, objectDefinition.blocksProjectile);
         }

      }
   }
}
