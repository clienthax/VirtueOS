package com.oldscape.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

class WorldMapRegion {
   public static final class213 field479;
   public static final class213 field480;
   private static final Coordinates field490;
   int field484;
   int field482;
   private class22 field483;
   private LinkedList<class46> field475;
   private int field485;
   private int field474;
   private List<MapIcon> mapIconList;
   private HashMap<Coordinates, MapIcon> mapIconPositions;
   private final HashMap mapFonts;

   static {
      field479 = new class213(37748736, 256);
      field480 = new class213(256, 256);
      field490 = new Coordinates();
   }

   WorldMapRegion(final int var1, final int var2, final int var3, final HashMap var4) {
      this.field484 = var1;
      this.field482 = var2;
      this.field475 = new LinkedList<>();
      this.mapIconList = new LinkedList<>();
      this.mapIconPositions = new HashMap<>();
      this.field485 = var3 | -16777216;
      this.mapFonts = var4;
   }

   static int method3291(final int var0, final int var1) {
      final Overlay var2 = class95.getOverlayDefinition(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else if(var2.texture >= 0) {
         final int var3 = class27.method247(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
         return Graphics3D.colorPalette[var3] | -16777216;
      } else if(var2.color == 16711935) {
         return var1;
      } else {
         final int var4 = var2.hue;
         int var5 = var2.saturation;
         final int var6 = var2.lightness;
         if(var6 > 179) {
            var5 /= 2;
         }

         if(var6 > 192) {
            var5 /= 2;
         }

         if(var6 > 217) {
            var5 /= 2;
         }

         if(var6 > 243) {
            var5 /= 2;
         }

         final int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
         final int var8 = class27.method247(var7, 96);
         return Graphics3D.colorPalette[var8] | -16777216;
      }
   }

   void method413(final int var1, final int var2, final int var3) {
      final int var5 = this.field484;
      final int var6 = this.field482;
      final int var7 = this.field474;
      final class213 var8 = field479;
      final long var9 = (var7 << 16 | var5 << 8 | var6);
      final SpritePixels spritePixels = (SpritePixels)var8.method3932(var9);
      if(spritePixels != null) {
         if(var3 == this.field474 * 64) {
            spritePixels.method5856(var1, var2);
         } else {
            spritePixels.method5879(var1, var2, var3, var3);
         }

      }
   }

   void method414(final class22 var1, final List<class25> var2) {
      this.mapIconPositions.clear();
      this.field483 = var1;
      this.method416(0, 0, 64, 64, this.field483);
      this.method417(var2);
   }

   void method415(final HashSet<class46> var1, final List<class25> var2) {
      this.mapIconPositions.clear();

      for (final class46 var4 : var1) {
         if (var4.method255() == this.field484 && var4.method256() == this.field482) {
            this.field475.add(var4);
            this.method416(var4.method681() * 8, var4.method682() * 8, 8, 8, var4);
         }
      }

      this.method417(var2);
   }

   private void method416(final int var1, final int var2, final int var3, final int var4, final WorldMapDecorationInfo var5) {
      for(int x = var1; x < var3 + var1; ++x) {
         label55:
         for(int y = var2; y < var2 + var4; ++y) {
            final Coordinates var8 = new Coordinates(0, x, y);

            for(int plane = 0; plane < var5.planes; ++plane) {
               final WorldMapDecoration[] worldMapDecorations = var5.decorations[plane][x][y];
               if(worldMapDecorations != null && worldMapDecorations.length != 0) {

                  for (final WorldMapDecoration worldMapDecoration : worldMapDecorations) {
                     final Area area = this.method445(worldMapDecoration.objectDefinitionId);
                     if (area != null) {
                        final Coordinates var15 = new Coordinates(plane, this.field484 * 64 + x, this.field482 * 64 + y);
                        final Coordinates var16;
                        if (this.field483 != null) {
                           var16 = new Coordinates(this.field483.field410 + plane, x + this.field483.field406 * 64, y + this.field483.field407 * 64);
                        } else {
                           final class46 var17 = (class46) var5;
                           var16 = new Coordinates(plane + var17.field410, x + var17.field406 * 64 + var17.method679() * 8, y + var17.field407 * 64 + var17.method680() * 8);
                        }

                        final MapIcon var18 = new MapIcon(area.id, var16, var15, this.method447(area));
                        this.mapIconPositions.put(var8, var18);
                        continue label55;
                     }
                  }
               }
            }
         }
      }

   }

   private void method417(final List<class25> var1) {

      for (final class25 var3 : var1) {
         if (var3.coordinates.x >> 6 == this.field484 && var3.coordinates.y >> 6 == this.field482) {
            final MapIcon var4 = new MapIcon(var3.areaId, var3.coordinates, var3.coordinates, this.method446(var3.areaId));
            this.mapIconList.add(var4);
         }
      }

   }

   void method444(final int var1, final class47 var2, final WorldMapRegion[] worldMapRegions, final IndexedSprite[] indexedSprites) {
      this.field474 = var1;
      if(this.field483 != null || !this.field475.isEmpty()) {
         final int var6 = this.field484;
         final int var7 = this.field482;
         final class213 var8 = field479;
         final long var9 = (var1 << 16 | var6 << 8 | var7);
         final SpritePixels var5 = (SpritePixels)var8.method3932(var9);
         if(var5 == null) {
            final class33 var18 = this.method426(this.field484, this.field482, worldMapRegions);
            final SpritePixels spritePixels = new SpritePixels(this.field474 * 64, this.field474 * 64);
            spritePixels.setRaster();
            if(this.field483 != null) {
               this.method421(var2, indexedSprites, var18);
            } else {
               this.method499(var2, indexedSprites, var18);
            }

            final int var10 = this.field484;
            final int var11 = this.field482;
            final int var12 = this.field474;
            final class213 var13 = field479;
            final long var15 = (var12 << 16 | var10 << 8 | var11);
            var13.method3936(spritePixels, var15, spritePixels.pixels.length * 4);
         }
      }
   }

   void method419(final int var1, final int var2, final int var3, HashSet<Integer> var4) {
      if(var4 == null) {
         var4 = new HashSet<>();
      }

      this.drawNonLinkMapIcons(var1, var2, var4, var3);
      this.drawMapLinks(var1, var2, var4, var3);
   }

   void drawFlashingMapIcons(final HashSet<Integer> var1, final int var2, final int var3) {

      for (final Object o : this.mapIconPositions.values()) {
         final MapIcon var5 = (MapIcon) o;
         if (var1.contains(var5.areaId)) {
            final Area var6 = Area.mapAreaType[var5.areaId];
            this.method436(var6, var5.screenX, var5.screenY, var2, var3);
         }
      }

      this.method430(var1, var2, var3);
   }

   private void method421(final class47 var1, final IndexedSprite[] var3, final class33 var4) {
      int var5;
      int var6;
      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method424(var5, var6, this.field483, var1, var4);
            this.method425(var5, var6, this.field483, var1);
         }
      }

      for(var5 = 0; var5 < 64; ++var5) {
         for(var6 = 0; var6 < 64; ++var6) {
            this.method412(var5, var6, this.field483, var3);
         }
      }

   }

   private void method499(final class47 var1, final IndexedSprite[] var2, final class33 var3) {
      Iterator<class46> var4 = this.field475.iterator();

      class46 var5;
      int var6;
      int var7;
      while(var4.hasNext()) {
         var5 = var4.next();

         for(var6 = var5.method681() * 8; var6 < var5.method681() * 8 + 8; ++var6) {
            for(var7 = var5.method682() * 8; var7 < var5.method682() * 8 + 8; ++var7) {
               this.method424(var6, var7, var5, var1, var3);
               this.method425(var6, var7, var5, var1);
            }
         }
      }

      var4 = this.field475.iterator();

      while(var4.hasNext()) {
         var5 = var4.next();

         for(var6 = var5.method681() * 8; var6 < var5.method681() * 8 + 8; ++var6) {
            for(var7 = var5.method682() * 8; var7 < var5.method682() * 8 + 8; ++var7) {
               this.method412(var6, var7, var5, var2);
            }
         }
      }

   }

   private void method412(final int var1, final int var2, final WorldMapDecorationInfo var3, final IndexedSprite[] var5) {
      this.method433(var1, var2, var3);
      this.method432(var1, var2, var3, var5);
   }

   private void method424(final int var1, final int var2, final WorldMapDecorationInfo var3, final class47 var4, final class33 var5) {
      final int var6 = var3.worldMapUnderlayColors[0][var1][var2] - 1;
      final int var7 = var3.worldMapOverlayColors[0][var1][var2] - 1;
      if(var6 == -1 && var7 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, this.field485);
      }

      int var8 = 16711935;
      if(var7 != -1) {
         var8 = method3291(var7, this.field485);
      }

      if(var7 > -1 && var3.worldMapOverlayShapes[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, var8);
      } else {
         final int var9 = this.method431(var1, var2, var3, var5);
         if(var7 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, var9);
         } else {
            var4.method707(this.field474 * var1, this.field474 * (63 - var2), var9, var8, this.field474, this.field474, var3.worldMapOverlayShapes[0][var1][var2], var3.worldMapOverlayRotations[0][var1][var2]);
         }
      }
   }

   private void method425(final int var1, final int var2, final WorldMapDecorationInfo var3, final class47 var4) {
      for(int var5 = 1; var5 < var3.planes; ++var5) {
         final int var6 = var3.worldMapOverlayColors[var5][var1][var2] - 1;
         if(var6 > -1) {
            final int var7 = method3291(var6, this.field485);
            if(var3.worldMapOverlayShapes[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field474 * var1, this.field474 * (63 - var2), this.field474, this.field474, var7);
            } else {
               var4.method707(this.field474 * var1, this.field474 * (63 - var2), 0, var7, this.field474, this.field474, var3.worldMapOverlayShapes[var5][var1][var2], var3.worldMapOverlayRotations[var5][var1][var2]);
            }
         }
      }

   }

   private class33 method426(final int var1, final int var2, final WorldMapRegion[] worldMapRegions) {
      final class213 var5 = field480;
      final long var6 = (var1 << 8 | var2);
      final class33 var4 = (class33)var5.method3932(var6);
      class33 var8 = var4;
      if(var4 == null) {
         var8 = this.method534(worldMapRegions);
         BoundingBox3DDrawMode.method55(var8, var1, var2);
      }

      return var8;
   }

   private class33 method534(final WorldMapRegion[] worldMapRegions) {
      final class44 var2 = new class44(64, 64);
      if(this.field483 != null) {
         this.method491(0, 0, 64, 64, this.field483, var2);
      } else {

         for (final class46 var4 : this.field475) {
            this.method491(var4.method681() * 8, var4.method682() * 8, 8, 8, var4, var2);
         }
      }

      this.method500(worldMapRegions, var2);
      final class33 var5 = new class33();
      var5.method407(var2);
      return var5;
   }

   private void method500(final WorldMapRegion[] worldMapRegions, final class44 var2) {

      for (final class254 var7 : new class254[]{class254.field3321, class254.field3322, class254.field3326, class254.field3328, class254.field3327, class254.field3324, class254.field3325, class254.field3323}) {
         if (worldMapRegions[var7.rsOrdinal()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch (var7.field3329) {
               case 0:
                  var13 = 59;
                  var11 = 5;
                  var8 = 59;
                  var10 = 5;
                  break;
               case 1:
                  var12 = 59;
                  var13 = 59;
                  var10 = 5;
                  var11 = 5;
                  break;
               case 2:
                  var8 = 59;
                  var10 = 5;
                  break;
               case 3:
                  var13 = 59;
                  var11 = 5;
                  break;
               case 4:
                  var12 = 59;
                  var10 = 5;
                  break;
               case 5:
                  var9 = 59;
                  var11 = 5;
                  var8 = 59;
                  var10 = 5;
                  break;
               case 6:
                  var9 = 59;
                  var11 = 5;
                  break;
               case 7:
                  var9 = 59;
                  var11 = 5;
                  var12 = 59;
                  var10 = 5;
            }

            this.method526(var12, var13, var8, var9, var10, var11, worldMapRegions[var7.rsOrdinal()], var2);
         }
      }

   }

   private void method491(final int var1, final int var2, final int var3, final int var4, final WorldMapDecorationInfo var5, final class44 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            final int var9 = var5.worldMapUnderlayColors[0][var7][var8] - 1;
            if(var9 != -1) {
               final FloorUnderlayDefinition underlayDefinition = FloorUnderlayDefinition.getUnderlayDefinition(var9);
               var6.method656(var7, var8, 5, underlayDefinition);
            }
         }
      }

   }

   private void method526(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6, final WorldMapRegion worldMapRegion, final class44 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            final int var11 = worldMapRegion.method451(var9 + var1, var10 + var2);
            if(var11 != -1) {
               final FloorUnderlayDefinition var12 = FloorUnderlayDefinition.getUnderlayDefinition(var11);
               var8.method656(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   private int method431(final int var1, final int var2, final WorldMapDecorationInfo var3, final class33 var4) {
      return var3.worldMapUnderlayColors[0][var1][var2] == 0?this.field485:var4.method402(var1, var2);
   }

   private void method432(final int var1, final int var2, final WorldMapDecorationInfo var3, final IndexedSprite[] sprites) {
      for(int var5 = 0; var5 < var3.planes; ++var5) {
         final WorldMapDecoration[] worldMapDecorations = var3.decorations[var5][var1][var2];
         if(worldMapDecorations != null && worldMapDecorations.length != 0) {

            for (final WorldMapDecoration var9 : worldMapDecorations) {
               if (!class64.method1112(var9.decoration)) {
                  final int var11 = var9.decoration;
                  final boolean var10 = var11 == WorldMapDecorationType.field3008.rsOrdinal;
                  if (!var10) {
                     continue;
                  }
               }

               final ObjectComposition objectDefinition = GameCanvas.getObjectDefinition(var9.objectDefinitionId);
               if (objectDefinition.mapSceneId != -1) {
                  if (objectDefinition.mapSceneId != 46 && objectDefinition.mapSceneId != 52) {
                     sprites[objectDefinition.mapSceneId].method5827(this.field474 * var1, this.field474 * (63 - var2), this.field474 * 2, this.field474 * 2);
                  } else {
                     sprites[objectDefinition.mapSceneId].method5827(this.field474 * var1, this.field474 * (63 - var2), this.field474 * 2 + 1, this.field474 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   private void method433(final int var1, final int var2, final WorldMapDecorationInfo var3) {
      for(int var4 = 0; var4 < var3.planes; ++var4) {
         final WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if(var5 != null && var5.length != 0) {

            for (final WorldMapDecoration var8 : var5) {
               final int var10 = var8.decoration;
               final boolean var9 = var10 >= WorldMapDecorationType.field2992.rsOrdinal && var10 <= WorldMapDecorationType.field2989.rsOrdinal || var10 == WorldMapDecorationType.field2990.rsOrdinal;
               if (var9) {
                  final ObjectComposition var11 = GameCanvas.getObjectDefinition(var8.objectDefinitionId);
                  final int var12 = var11.int1 != 0 ? -3407872 : -3355444;
                  if (var8.decoration == WorldMapDecorationType.field2992.rsOrdinal) {
                     this.method466(var1, var2, var8.rotation, var12);
                  }

                  if (var8.decoration == WorldMapDecorationType.field2986.rsOrdinal) {
                     this.method466(var1, var2, var8.rotation, -3355444);
                     this.method466(var1, var2, var8.rotation + 1, var12);
                  }

                  if (var8.decoration == WorldMapDecorationType.field2989.rsOrdinal) {
                     if (var8.rotation == 0) {
                        Rasterizer2D.method5731(this.field474 * var1, this.field474 * (63 - var2), 1, var12);
                     }

                     if (var8.rotation == 1) {
                        Rasterizer2D.method5731(this.field474 + this.field474 * var1 - 1, this.field474 * (63 - var2), 1, var12);
                     }

                     if (var8.rotation == 2) {
                        Rasterizer2D.method5731(this.field474 * var1 + this.field474 - 1, this.field474 * (63 - var2) + this.field474 - 1, 1, var12);
                     }

                     if (var8.rotation == 3) {
                        Rasterizer2D.method5731(this.field474 * var1, this.field474 * (63 - var2) + this.field474 - 1, 1, var12);
                     }
                  }

                  if (var8.decoration == WorldMapDecorationType.field2990.rsOrdinal) {
                     final int var13 = var8.rotation % 2;
                     int var14;
                     if (var13 == 0) {
                        for (var14 = 0; var14 < this.field474; ++var14) {
                           Rasterizer2D.method5731(var14 + this.field474 * var1, (64 - var2) * this.field474 - 1 - var14, 1, var12);
                        }
                     } else {
                        for (var14 = 0; var14 < this.field474; ++var14) {
                           Rasterizer2D.method5731(var14 + this.field474 * var1, var14 + this.field474 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   private void drawNonLinkMapIcons(final int var1, final int var2, final HashSet<Integer> var3, final int var4) {
      final float var5 = var4 / 64.0F;
      final float var6 = var5 / 2.0F;

      for (final Entry<Coordinates, MapIcon> coordinatesMapIconEntry : this.mapIconPositions.entrySet()) {
         final Coordinates var9 = coordinatesMapIconEntry.getKey();
         final int var10 = (int) (var1 + var5 * var9.x - var6);
         final int var11 = (int) ((var2 + var4) - var5 * var9.y - var6);
         final MapIcon mapIcon = coordinatesMapIconEntry.getValue();
         if (mapIcon != null) {
            mapIcon.screenX = var10;
            mapIcon.screenY = var11;
            final Area var13 = Area.mapAreaType[mapIcon.areaId];
            if (!var3.contains(var13.getId())) {
               this.method468(mapIcon, var10, var11, var5);
            }
         }
      }

   }

   private void method430(final HashSet<Integer> var1, final int var2, final int var3) {
      for (final MapIcon mapIcon : this.mapIconList) {
         final Area area = Area.mapAreaType[mapIcon.areaId];
         if (area != null && var1.contains(area.getId())) {
            this.method436(area, mapIcon.screenX, mapIcon.screenY, var2, var3);
         }
      }

   }

   private void method436(final Area area, final int var2, final int var3, final int var4, final int var5) {
      final SpritePixels icon = area.getMapIcon();
      if(icon != null) {
         icon.drawAt(var2 - icon.width / 2, var3 - icon.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5720(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5720(var2, var3, 7, 16777215, 256);
         }

      }
   }

   private void method468(final MapIcon mapIcon, final int var2, final int var3, final float var4) {
      final Area var5 = Area.mapAreaType[mapIcon.areaId];
      this.method449(var5, var2, var3);
      this.method439(mapIcon, var5, var2, var3, var4);
   }

   private void method449(final Area area, final int var2, final int var3) {
      final SpritePixels icon = area.getMapIcon();
      if(icon != null) {
         final int var5 = this.method437(icon, area.horizontalAlignment);
         final int var6 = this.method471(icon, area.verticalAlignment);
         icon.drawAt(var5 + var2, var3 + var6);
      }

   }

   private void method439(final MapIcon mapIcon, final Area area, final int var3, final int var4, final float var5) {
      if(mapIcon.mapLabel != null) {
         if(mapIcon.mapLabel.fontSize.method192(var5)) {
            final Font var6 = (Font)this.mapFonts.get(mapIcon.mapLabel.fontSize);
            var6.method5514(mapIcon.mapLabel.text, var3 - mapIcon.mapLabel.field470 / 2, var4, mapIcon.mapLabel.field470, mapIcon.mapLabel.field469, -16777216 | area.textColor, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   private void drawMapLinks(final int var1, final int var2, final HashSet<Integer> var3, final int var4) {
      final float var5 = var4 / 64.0F;

      for (final MapIcon mapIcon : this.mapIconList) {
         final int var8 = mapIcon.field532.x % 64;
         final int var9 = mapIcon.field532.y % 64;
         mapIcon.screenX = (int) (var5 * var8 + var1);
         mapIcon.screenY = (int) (var2 + var5 * (63 - var9));
         if (!var3.contains(mapIcon.areaId)) {
            this.method468(mapIcon, mapIcon.screenX, mapIcon.screenY, var5);
         }
      }

   }

   void method441() {
      if(this.field483 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method442(var1, var2, this.field483);
            }
         }
      } else {

         for (final class46 var6 : this.field475) {
            for (int var3 = var6.method681() * 8; var3 < var6.method681() * 8 + 8; ++var3) {
               for (int var4 = var6.method682() * 8; var4 < var6.method682() * 8 + 8; ++var4) {
                  this.method442(var3, var4, var6);
               }
            }
         }
      }

   }

   private void method442(final int x, final int y, final WorldMapDecorationInfo var3) {
      field490.set(0, x, y);

      for(int var4 = 0; var4 < var3.planes; ++var4) {
         final WorldMapDecoration[] worldMapDecorations = var3.decorations[var4][x][y];
         if(worldMapDecorations != null && worldMapDecorations.length != 0) {

            for (final WorldMapDecoration worldMapDecoration : worldMapDecorations) {
               final Area area = this.method445(worldMapDecoration.objectDefinitionId);
               if (area != null) {
                  MapIcon mapIcon = this.mapIconPositions.get(field490);
                  if (mapIcon != null) {
                     if (area.id != mapIcon.areaId) {
                        final MapIcon var16 = new MapIcon(area.id, mapIcon.field524, mapIcon.field532, this.method447(area));
                        this.mapIconPositions.put(new Coordinates(field490), var16);
                        mapIcon = var16;
                     }

                     final int var15 = mapIcon.field524.plane - mapIcon.field532.plane;
                     mapIcon.field532.plane = var4;
                     mapIcon.field524.plane = var15 + var4;
                     return;
                  }

                  final Coordinates var11 = new Coordinates(var4, this.field484 * 64 + x, this.field482 * 64 + y);
                  Coordinates var12 = null;
                  if (this.field483 != null) {
                     var12 = new Coordinates(this.field483.field410 + var4, this.field483.field406 * 64 + x, y + this.field483.field407 * 64);
                  } else {

                     for (final class46 var14 : this.field475) {
                        if (var14.method678(x, y)) {
                           var12 = new Coordinates(var4 + var14.field410, var14.field406 * 64 + x + var14.method679() * 8, var14.field407 * 64 + y + var14.method680() * 8);
                           break;
                        }
                     }
                  }

                  if (var12 != null) {
                     mapIcon = new MapIcon(area.id, var12, var11, this.method447(area));
                     this.mapIconPositions.put(new Coordinates(field490), mapIcon);
                     return;
                  }
               }
            }
         }
      }

      this.mapIconPositions.remove(field490);
   }

   private int method437(final SpritePixels spritePixels, final HorizontalAlignment alignment) {
      switch(alignment.value) {
      case 0:
         return -spritePixels.width / 2;
      case 2:
         return 0;
      default:
         return -spritePixels.width;
      }
   }

   private int method471(final SpritePixels spritePixels, final VerticalAlignment alignment) {
      switch(alignment.value) {
      case 0:
         return 0;
      case 1:
         return -spritePixels.height / 2;
      default:
         return -spritePixels.height;
      }
   }

   private Area method445(final int var1) {
      ObjectComposition var2 = GameCanvas.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   private MapLabel method446(final int var1) {
      final Area var2 = Area.mapAreaType[var1];
      return this.method447(var2);
   }

   private MapLabel method447(final Area var1) {
      if(var1.name != null && this.mapFonts != null && this.mapFonts.get(Size.small) != null) {
         final Size sizeFromId = Size.getSizeFromId(var1.fontSizeId);
         if(sizeFromId == null) {
            return null;
         } else {
            final Font font = (Font)this.mapFonts.get(sizeFromId);
            if(font == null) {
               return null;
            } else {
               final int var4 = font.method5508(var1.name, 1000000);
               final String[] var5 = new String[var4];
               font.method5580(var1.name, null, var5);
               final int var6 = var5.length * font.verticalSpace / 2;
               int var7 = 0;

               for (final String var10 : var5) {
                  final int var11 = font.getTextWidth(var10);
                  if (var11 > var7) {
                     var7 = var11;
                  }
               }

               return new MapLabel(var1.name, var7, var6, sizeFromId);
            }
         }
      } else {
         return null;
      }
   }

   List<MapIcon> method469(final int var1, final int var2, final int var3, final int var4, final int var5) {
      final LinkedList<MapIcon> var6 = new LinkedList<>();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator<MapIcon> var7 = this.mapIconPositions.values().iterator();

            MapIcon var8;
            while(var7.hasNext()) {
               var8 = var7.next();
               if(var8.method583(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.mapIconList.iterator();

            while(var7.hasNext()) {
               var8 = var7.next();
               if(var8.method583(var4, var5)) {
                  var6.add(var8);
               }
            }

         }
          return var6;
      } else {
         return var6;
      }
   }

   List<MapIcon> method511() {//getmapicons?
      final LinkedList<MapIcon> var1 = new LinkedList<>();
      var1.addAll(this.mapIconList);
      var1.addAll(this.mapIconPositions.values());
      return var1;
   }

   private void method466(final int var1, final int var2, int var3, final int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5797(this.field474 * var1, this.field474 * (63 - var2), this.field474, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5731(this.field474 * var1, this.field474 * (63 - var2), this.field474, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5797(this.field474 * var1 + this.field474 - 1, this.field474 * (63 - var2), this.field474, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5731(this.field474 * var1, this.field474 * (63 - var2) + this.field474 - 1, this.field474, var4);
      }

   }

   private int method451(final int var1, final int var2) {
      if(this.field483 != null) {
         return this.field483.method269(var1, var2);
      } else {
         if(!this.field475.isEmpty()) {

            for (final class46 var4 : this.field475) {
               if (var4.method678(var1, var2)) {
                  return var4.method269(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   static class233 method536(final IndexDataBase var0, final int var1) {
      final byte[] var2 = var0.takeRecordFlat(var1);
      return var2 == null?null:new class233(var2);
   }

   public static int getLength(final String var0) {
      return var0.length() + 1;
   }

   static void method535(int var0, int var1, int var2, int var3, final boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1118 - Client.field1120) * var5 / 100 + Client.field1120;
      final int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      final int var9;
      final short var15;
      if(var7 < Client.field1123) {
         var15 = Client.field1123;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1122) {
            var6 = Client.field1122;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field911) {
         var15 = Client.field911;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1121) {
            var6 = Client.field1121;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1104 - Client.field1018) * var5 / 100 + Client.field1018;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         final int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            final int var11 = var10 * 32 + 15 + 128;
            final int var12 = var11 * 3 + 600;
            final int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.buildVisibilityMaps(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   static void updateNpcs(final boolean var0, final PacketBuffer var1) {
      Client.field990 = 0;
      Client.pendingNpcFlagsCount = 0;
      final PacketBuffer var2 = Client.field957.packetBuffer;
      var2.bitAccess();
      int var3 = var2.getBits(8);
      int var4;
      if(var3 < Client.npcIndexesCount) {
         for(var4 = var3; var4 < Client.npcIndexesCount; ++var4) {
            Client.field1027[++Client.field990 - 1] = Client.npcIndices[var4];
         }
      }

      if(var3 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var4 = 0; var4 < var3; ++var4) {
            final int var5 = Client.npcIndices[var4];
            final NPC var6 = Client.cachedNPCs[var5];
            final int var7 = var2.getBits(1);
            if(var7 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
               var6.npcCycle = Client.gameCycle;
            } else {
               final int var8 = var2.getBits(2);
               if(var8 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                  var6.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
               } else {
                  final int var9;
                  final int var10;
                  if(var8 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1873(var9, (byte)1);
                     var10 = var2.getBits(1);
                     if(var10 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1873(var9, (byte)2);
                     var10 = var2.getBits(3);
                     var6.method1873(var10, (byte)2);
                     final int var11 = var2.getBits(1);
                     if(var11 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 3) {
                     Client.field1027[++Client.field990 - 1] = var5;
                  }
               }
            }
         }

         WorldMapDecorationInfo.method274(var0, var1);
         UrlRequester.method3091(var1);

         int var12;
         for(var12 = 0; var12 < Client.field990; ++var12) {
            var3 = Client.field1027[var12];
            if(Client.cachedNPCs[var3].npcCycle != Client.gameCycle) {
               Client.cachedNPCs[var3].composition = null;
               Client.cachedNPCs[var3] = null;
            }
         }

         if(var1.offset != Client.field957.packetLength) {
            throw new RuntimeException(var1.offset + "," + Client.field957.packetLength);
         } else {
            for(var12 = 0; var12 < Client.npcIndexesCount; ++var12) {
               if(Client.cachedNPCs[Client.npcIndices[var12]] == null) {
                  throw new RuntimeException(var12 + "," + Client.npcIndexesCount);
               }
            }

         }
      }
   }

   static Widget method533(final Widget var0) {
      Widget var1 = Widget.method4692(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }
}
