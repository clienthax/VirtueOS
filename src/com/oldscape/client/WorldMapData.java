package com.oldscape.client;

import java.util.Iterator;
import java.util.LinkedList;

public class WorldMapData {
   static String[] cacheLocations;
   static long field463;
   private int fileId;
   private String identifier;
   private String name;
   private int field454;
   private int field451;
   private Coordinates coordinates;
   int minX;
   int maxX;
   int minY;
   int maxY;
   private boolean field458;
   private LinkedList<WorldMapSectionBase> worldMapSectionBases;

   public WorldMapData() {
      this.fileId = -1;
      this.field454 = -1;
      this.field451 = -1;
      this.coordinates = null;
      this.minX = Integer.MAX_VALUE;
      this.maxX = 0;
      this.minY = Integer.MAX_VALUE;
      this.maxY = 0;
      this.field458 = false;
   }

   public void loadMapData(final Buffer buffer, final int fileId) {
      this.fileId = fileId;
      this.identifier = buffer.readString();
      this.name = buffer.readString();
      this.coordinates = new Coordinates(buffer.readInt());
      this.field454 = buffer.readInt();
      buffer.readUnsignedByte();
      this.field458 = buffer.readUnsignedByte() == 1;
      this.field451 = buffer.readUnsignedByte();
      final int var3 = buffer.readUnsignedByte();
      this.worldMapSectionBases = new LinkedList<>();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.worldMapSectionBases.add(this.method318(buffer));
      }

      this.method323();
   }

   private WorldMapSectionBase method318(final Buffer buffer) {
      final int ordinal = buffer.readUnsignedByte();
      final class27 var3 = (class27) Enumerated.forOrdinal(class27.method243(), ordinal);

      final WorldMapSectionBase worldMapSectionBase;
      switch(var3.field403) {
      case 0:
         worldMapSectionBase = new WorldMapType3();
         break;
      case 1:
         worldMapSectionBase = new WorldMapType2();
         break;
      case 2:
         worldMapSectionBase = new WorldMapType4();
         break;
      case 3:
         worldMapSectionBase = new WorldMapType1();
         break;
      default:
         throw new IllegalStateException("");
      }

      worldMapSectionBase.decode(buffer);
      return worldMapSectionBase;
   }

   public boolean containsCoord(final int var1, final int var2, final int var3) {
      final Iterator<WorldMapSectionBase> iterator = this.worldMapSectionBases.iterator();

      WorldMapSectionBase worldMapSectionBase;
      do {
         if(!iterator.hasNext()) {
            return false;
         }

         worldMapSectionBase = iterator.next();
      } while(!worldMapSectionBase.containsCoord(var1, var2, var3));

      return true;
   }

   public boolean method335(final int worldX, final int worldY) {
      final int regionX = worldX / 64;
      final int regionY = worldY / 64;
      if(regionX >= this.minX && regionX <= this.maxX) {
         if(regionY >= this.minY && regionY <= this.maxY) {
            final Iterator<WorldMapSectionBase> iterator = this.worldMapSectionBases.iterator();

            WorldMapSectionBase worldMapSectionBase;
            do {
               if(!iterator.hasNext()) {
                  return false;
               }

               worldMapSectionBase = iterator.next();
            } while(!worldMapSectionBase.vmethod768(worldX, worldY));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   int[] method321(final int plane, final int worldX, final int worldY) {
      final Iterator<WorldMapSectionBase> iterator = this.worldMapSectionBases.iterator();

      WorldMapSectionBase worldMapSectionBase;
      do {
         if(!iterator.hasNext()) {
            return null;
         }

         worldMapSectionBase = iterator.next();
      } while(!worldMapSectionBase.containsCoord(plane, worldX, worldY));

      return worldMapSectionBase.vmethod753(plane, worldX, worldY);
   }

   Coordinates method322(final int var1, final int var2) {
      final Iterator<WorldMapSectionBase> iterator = this.worldMapSectionBases.iterator();

      WorldMapSectionBase worldMapSectionBase;
      do {
         if(!iterator.hasNext()) {
            return null;
         }

         worldMapSectionBase = iterator.next();
      } while(!worldMapSectionBase.vmethod768(var1, var2));

      return worldMapSectionBase.vmethod758(var1, var2);
   }

   private void method323() {
      for (final WorldMapSectionBase var2 : this.worldMapSectionBases) {
         var2.vmethod767(this);
      }
   }

   public int getFileId() {
      return this.fileId;
   }

   public boolean method325() {
      return this.field458;
   }

   public String getIdentifier() {
      return this.identifier;
   }

   public String getName() {
      return this.name;
   }

   int method352() {
      return this.field454;
   }

   public int method338() {
      return this.field451;
   }

   public int getMinX() {
      return this.minX;
   }

   public int getMaxX() {
      return this.maxX;
   }

   public int getMinY() {
      return this.minY;
   }

   public int getMaxY() {
      return this.maxY;
   }

   public int getWorldX() {
      return this.coordinates.x;
   }

   public int getPlane() {
      return this.coordinates.plane;
   }

   public int getWorldY() {
      return this.coordinates.y;
   }

   public Coordinates getCoords() {
      return new Coordinates(this.coordinates);
   }

   public static void method398(final Model var0, final int var1) {
      for(int var2 = 0; var2 < var0.indicesCount; ++var2) {
         if(var0.field1862[var2] != -2) {
            final int var3 = var0.indices1[var2];
            final int var4 = var0.indices2[var2];
            final int var5 = var0.indices3[var2];
            final int var6 = Model.modelViewportYs[var3];
            final int var7 = Model.modelViewportYs[var4];
            final int var8 = Model.modelViewportYs[var5];
            method399(Model.modelViewportXs[var3], Model.modelViewportXs[var4], Model.modelViewportXs[var5], var6, var7, var8, var1);
         }
      }

   }

   private static void method399(final int var0, final int var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
      final int xMin = Math.min(var3, Math.min(var4, var5)) - var6;
      final int xMax = Math.max(var3, Math.max(var4, var5)) + var6;
      final int yMin = Math.min(var0, Math.min(var1, var2)) - var6;
      final int yMax = Math.max(var0, Math.max(var1, var2)) + var6;
      class149.method3104(xMin, yMin, xMax, yMax, -49088);
   }

}
