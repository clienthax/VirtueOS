package com.oldscape.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class WorldMapManager {
   private boolean loaded;
   private boolean loading;
   private class45 field549;
   private SpritePixels field560;
   private HashMap<Integer, List<MapIcon>> field550;
   private WorldMapRegion[][] mapRegions;
   private final HashMap<Integer, class47> field546;
   private final IndexedSprite[] field553;
   private final HashMap mapFonts;
   private int field557;
   private int field556;
   private int field554;
   private int field558;
   public int field548;

   public WorldMapManager(final IndexedSprite[] var1, final HashMap var2) {
      this.loaded = false;
      this.loading = false;
      this.field546 = new HashMap<>();
      this.field548 = 0;
      this.field553 = var1;
      this.mapFonts = var2;
   }

    static int getTileHeight(final int var0, final int var1, final int var2) {
       final int x = var0 >> 7;
       final int y = var1 >> 7;
       if(x >= 0 && y >= 0 && x <= 103 && y <= 103) {
          int var5 = var2;
          if(var2 < 3 && (class62.tileSettings[1][x][y] & 2) == 2) {
             var5 = var2 + 1;
          }

          final int var6 = var0 & 127;
          final int var7 = var1 & 127;
          final int var8 = (128 - var6) * class62.tileHeights[var5][x][y] + class62.tileHeights[var5][x + 1][y] * var6 >> 7;
          final int var9 = class62.tileHeights[var5][x][y + 1] * (128 - var6) + class62.tileHeights[var5][x + 1][y + 1] * var6 >> 7;
          return var8 * (128 - var7) + var7 * var9 >> 7;
       } else {
          return 0;
       }
    }

    public void load(final IndexDataBase var1, final String var2, final boolean var3) {
      if(!this.loading) {
         this.loaded = false;
         this.loading = true;
         System.nanoTime();
         final int var4 = var1.getFile(MapCacheArchiveNames.DETAILS.name);
         final int var5 = var1.getChild(var4, var2);
         final Buffer var6 = new Buffer(var1.takeRecordByNames(MapCacheArchiveNames.DETAILS.name, var2));
         final Buffer var7 = new Buffer(var1.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, var2));
         final Buffer var8 = new Buffer(var1.takeRecordByNames(var2, MapCacheArchiveNames.AREA.name));
         System.nanoTime();
         System.nanoTime();
         this.field549 = new class45();

         try {
            this.field549.method669(var6, var8, var7, var5, var3);
         } catch (final IllegalStateException var20) {
            return;
         }

         this.field549.getWorldX();
         this.field549.getPlane();
         this.field549.getWorldY();
         this.field557 = this.field549.getMinX() * 64;
         this.field556 = this.field549.getMinY() * 64;
         this.field554 = (this.field549.getMaxX() - this.field549.getMinX() + 1) * 64;
         this.field558 = (this.field549.getMaxY() - this.field549.getMinY() + 1) * 64;
         final int var17 = this.field549.getMaxX() - this.field549.getMinX() + 1;
         final int var10 = this.field549.getMaxY() - this.field549.getMinY() + 1;
         System.nanoTime();
         System.nanoTime();
         WorldMapRegion.field479.method3938();
         WorldMapRegion.field480.method3938();
         this.mapRegions = new WorldMapRegion[var17][var10];

         for (final Object aField572 : this.field549.field572) {
            final class22 var12 = (class22) aField572;
            final int var13 = var12.field406;
            final int var14 = var12.field407;
            final int var15 = var13 - this.field549.getMinX();
            final int var16 = var14 - this.field549.getMinY();
            this.mapRegions[var15][var16] = new WorldMapRegion(var13, var14, this.field549.method352(), this.mapFonts);
            this.mapRegions[var15][var16].method414(var12, this.field549.field571);
         }

         for(int var18 = 0; var18 < var17; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.mapRegions[var18][var19] == null) {
                  this.mapRegions[var18][var19] = new WorldMapRegion(this.field549.getMinX() + var18, this.field549.getMinY() + var19, this.field549.method352(), this.mapFonts);
                  this.mapRegions[var18][var19].method415(this.field549.field570, this.field549.field571);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4599(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2)) {
            final byte[] var21 = var1.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2);
            this.field560 = class185.method3448(var21);
         }

         System.nanoTime();
         var1.method4566();
         var1.reset();
         this.loaded = true;
      }
   }

   public final void method591() {
      this.field550 = null;
   }

   public final void drawMapRegion(final int var1, final int var2, final int var3, final int var4, final int var5, final int var7, final int var8) {
      final int[] var9 = Rasterizer2D.graphicsPixels;
      final int var10 = Rasterizer2D.graphicsPixelsWidth;
      final int var11 = Rasterizer2D.graphicsPixelsHeight;
      final int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      final WorldMapRectangle var13 = this.getRegionRectForViewport(var1, var2, var3, var4);
      final float var14 = this.method601(var7 - var5, var3 - var1);
      final int var15 = (int)Math.ceil(var14);
      this.field548 = var15;
      if(!this.field546.containsKey(var15)) {
         final class47 var16 = new class47(var15);
         var16.method734();
         this.field546.put(var15, var16);
      }

      final WorldMapRegion[] var22 = new WorldMapRegion[8];

      int var17;
      int var18;
      for(var17 = var13.worldMapRegionX; var17 < var13.worldMapRegionWidth + var13.worldMapRegionX; ++var17) {
         for(var18 = var13.worldMapRegionY; var18 < var13.worldMapRegionY + var13.worldMapRegionHeight; ++var18) {
            this.method594(var17, var18, var22);
            this.mapRegions[var17][var18].method444(var15, this.field546.get(var15), var22, this.field553);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field557 + var1;
      final int var19 = var2 + this.field556;

      for(int var20 = var13.worldMapRegionX; var20 < var13.worldMapRegionWidth + var13.worldMapRegionX; ++var20) {
         for(int var21 = var13.worldMapRegionY; var21 < var13.worldMapRegionHeight + var13.worldMapRegionY; ++var21) {
            this.mapRegions[var20][var21].method413(var5 + var17 * (this.mapRegions[var20][var21].field484 * 64 - var18) / 64, var8 - var17 * (this.mapRegions[var20][var21].field482 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   public final void drawMapIcons(final int var1, final int var2, final int var3, final int var4, final int var5, final int var7, final int var8, final HashSet<Integer> var9, final HashSet<Integer> var10, final int var11, final int var12, final boolean var13) {
      final WorldMapRectangle var14 = this.getRegionRectForViewport(var1, var2, var3, var4);
      final float var15 = this.method601(var7 - var5, var3 - var1);
      final int var16 = (int)(64.0F * var15);
      final int var17 = this.field557 + var1;
      final int var18 = var2 + this.field556;

      int var19;
      int var20;
      for(var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionWidth + var14.worldMapRegionX; ++var19) {
         for(var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionY + var14.worldMapRegionHeight; ++var20) {
            if(var13) {
               this.mapRegions[var19][var20].method441();
            }

            this.mapRegions[var19][var20].method419(var5 + var16 * (this.mapRegions[var19][var20].field484 * 64 - var17) / 64, var8 - var16 * (this.mapRegions[var19][var20].field482 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionWidth + var14.worldMapRegionX; ++var19) {
            for(var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionY + var14.worldMapRegionHeight; ++var20) {
               this.mapRegions[var19][var20].drawFlashingMapIcons(var10, var11, var12);
            }
         }
      }

   }

   private void method594(final int var1, final int var2, final WorldMapRegion[] var3) {
      final boolean var4 = var1 <= 0;
      final boolean var5 = var1 >= this.mapRegions.length - 1;
      final boolean var6 = var2 <= 0;
      final boolean var7 = var2 >= this.mapRegions[0].length - 1;
      if(var7) {
         var3[class254.field3324.rsOrdinal()] = null;
      } else {
         var3[class254.field3324.rsOrdinal()] = this.mapRegions[var1][var2 + 1];
      }

      var3[class254.field3322.rsOrdinal()] = !var7 && !var5?this.mapRegions[var1 + 1][var2 + 1]:null;
      var3[class254.field3328.rsOrdinal()] = !var7 && !var4?this.mapRegions[var1 - 1][var2 + 1]:null;
      var3[class254.field3323.rsOrdinal()] = var5?null:this.mapRegions[var1 + 1][var2];
      var3[class254.field3321.rsOrdinal()] = var4?null:this.mapRegions[var1 - 1][var2];
      var3[class254.field3325.rsOrdinal()] = var6?null:this.mapRegions[var1][var2 - 1];
      var3[class254.field3327.rsOrdinal()] = !var6 && !var5?this.mapRegions[var1 + 1][var2 - 1]:null;
      var3[class254.field3326.rsOrdinal()] = !var6 && !var4?this.mapRegions[var1 - 1][var2 - 1]:null;
   }

   public void method595(final int var1, final int var2, final int var3, final int var4, final HashSet var5, final int var6, final int var7) {
      if(this.field560 != null) {
         this.field560.method5860(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field550 == null) {
               this.method600();
            }

            final Iterator var8 = var5.iterator();

            while(true) {
               List<MapIcon> var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  final int var9 = (Integer) var8.next();
                  var10 = this.field550.get(var9);
               } while(var10 == null);

               for (final MapIcon mapIcon : var10) {
                  final int var13 = var3 * (mapIcon.field532.x - this.field557) / this.field554;
                  final int var14 = var4 - (mapIcon.field532.y - this.field556) * var4 / this.field558;
                  Rasterizer2D.method5720(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   public List<MapIcon> method596(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final int var7, final int var8, final int var9, final int var10) {
      final LinkedList<MapIcon> var11 = new LinkedList<>();
       if (this.loaded) {
           final WorldMapRectangle var12 = this.getRegionRectForViewport(var1, var2, var3, var4);
           final float var13 = this.method601(var7, var3 - var1);
           final int var14 = (int) (64.0F * var13);
           final int var15 = this.field557 + var1;
           final int var16 = var2 + this.field556;

           for (int var17 = var12.worldMapRegionX; var17 < var12.worldMapRegionX + var12.worldMapRegionWidth; ++var17) {
               for (int var18 = var12.worldMapRegionY; var18 < var12.worldMapRegionHeight + var12.worldMapRegionY; ++var18) {
                   final List<MapIcon> var19 = this.mapRegions[var17][var18].method469(var5 + var14 * (this.mapRegions[var17][var18].field484 * 64 - var15) / 64, var8 + var6 - var14 * (this.mapRegions[var17][var18].field482 * 64 - var16 + 64) / 64, var14, var9, var10);
                   if (!var19.isEmpty()) {
                       var11.addAll(var19);
                   }
               }
           }

       }
       return var11;
   }

   private WorldMapRectangle getRegionRectForViewport(final int var1, final int var2, final int var3, final int var4) {
      final WorldMapRectangle var5 = new WorldMapRectangle(this);
      final int var6 = this.field557 + var1;
      final int var7 = var2 + this.field556;
      final int var8 = var3 + this.field557;
      final int var9 = var4 + this.field556;
      final int var10 = var6 / 64;
      final int var11 = var7 / 64;
      final int var12 = var8 / 64;
      final int var13 = var9 / 64;
      var5.worldMapRegionWidth = var12 - var10 + 1;
      var5.worldMapRegionHeight = var13 - var11 + 1;
      var5.worldMapRegionX = var10 - this.field549.getMinX();
      var5.worldMapRegionY = var11 - this.field549.getMinY();
      if(var5.worldMapRegionX < 0) {
         var5.worldMapRegionWidth += var5.worldMapRegionX;
         var5.worldMapRegionX = 0;
      }

      if(var5.worldMapRegionX > this.mapRegions.length - var5.worldMapRegionWidth) {
         var5.worldMapRegionWidth = this.mapRegions.length - var5.worldMapRegionX;
      }

      if(var5.worldMapRegionY < 0) {
         var5.worldMapRegionHeight += var5.worldMapRegionY;
         var5.worldMapRegionY = 0;
      }

      if(var5.worldMapRegionY > this.mapRegions[0].length - var5.worldMapRegionHeight) {
         var5.worldMapRegionHeight = this.mapRegions[0].length - var5.worldMapRegionY;
      }

      var5.worldMapRegionWidth = Math.min(var5.worldMapRegionWidth, this.mapRegions.length);
      var5.worldMapRegionHeight = Math.min(var5.worldMapRegionHeight, this.mapRegions[0].length);
      return var5;
   }

   public boolean method598() {
      return this.loaded;
   }

   public HashMap<Integer, List<MapIcon>> method612() {
      this.method600();
      return this.field550;
   }

   private void method600() {
      if(this.field550 == null) {
         this.field550 = new HashMap<>();
      }

      this.field550.clear();

       for (final WorldMapRegion[] mapRegion : this.mapRegions) {
          for (final WorldMapRegion aMapRegion : mapRegion) {
             final List<MapIcon> var3 = aMapRegion.method511();

             for (final MapIcon var5 : var3) {
                if (!this.field550.containsKey(var5.areaId)) {
                   final LinkedList<MapIcon> var6 = new LinkedList<>();
                   var6.add(var5);
                   this.field550.put(var5.areaId, var6);
                } else {
                   final List<MapIcon> var7 = this.field550.get(var5.areaId);
                   var7.add(var5);
                }
             }
          }
       }

   }

   private float method601(final int var1, final int var2) {
      final float var3 = (float)var1 / var2;
      if(var3 > 8.0F) {
         return 8.0F;
      } else if(var3 < 1.0F) {
         return 1.0F;
      } else {
         final int var4 = Math.round(var3);
         return Math.abs(var4 - var3) < 0.05F? var4 :var3;
      }
   }

   public static IndexedSprite[] getIndexedSprites(final IndexDataBase var0, final String var1, final String var2) {
      final int var3 = var0.getFile(var1);
      final int var4 = var0.getChild(var3, var2);
      final IndexedSprite[] var5;
      if(!RunException.method3215(var0, var3, var4)) {
         var5 = null;
      } else {
         final IndexedSprite[] var7 = new IndexedSprite[class332.indexedSpriteCount];

         for(int var8 = 0; var8 < class332.indexedSpriteCount; ++var8) {
            final IndexedSprite var9 = var7[var8] = new IndexedSprite();
            var9.originalWidth = class332.indexedSpriteWidth;
            var9.originalHeight = class332.indexedSpriteHeight;
            var9.offsetX = class332.indexedSpriteOffsetXs[var8];
            var9.offsetY = class332.indexedSpriteOffsetYs[var8];
            var9.width = class332.indexSpriteWidths[var8];
            var9.height = class332.indexedSpriteHeights[var8];
            var9.palette = class332.indexedSpritePalette;
            var9.pixels = class332.spritePixels[var8];
         }

         class332.clearSprites();
         var5 = var7;
      }

      return var5;
   }

   static void method627(final Player player, final boolean var1) {
      if(player != null && player.hasConfig() && !player.hidden) {
         final int var2 = player.playerId << 14;
         player.isLowDetail = (Client.lowMemory && class93.playerIndexesCount > 50 || class93.playerIndexesCount > 200) && var1 && player.idlePoseAnimation == player.poseAnimation;

         final int var3 = player.x >> 7;
         final int var4 = player.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(player.model != null && Client.gameCycle >= player.animationCycleStart && Client.gameCycle < player.animationCycleEnd) {
               player.isLowDetail = false;
               player.field842 = getTileHeight(player.x, player.y, BoundingBox3DDrawMode.plane);
               player.field1161 = Client.gameCycle;
               class255.region.method2871(BoundingBox3DDrawMode.plane, player.x, player.y, player.field842, player, player.angle, var2, player.field849, player.field850, player.field851, player.field852);
            } else {
               if((player.x & 127) == 64 && (player.y & 127) == 64) {
                  if(Client.field966[var3][var4] == Client.field1137) {
                     return;
                  }

                  Client.field966[var3][var4] = Client.field1137;
               }

               player.field842 = getTileHeight(player.x, player.y, BoundingBox3DDrawMode.plane);
               player.field1161 = Client.gameCycle;
               class255.region.method2863(BoundingBox3DDrawMode.plane, player.x, player.y, player.field842, 60, player, player.angle, var2, player.field1159);
            }
         }
      }

   }
}
