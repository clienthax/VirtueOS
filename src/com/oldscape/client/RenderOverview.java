package com.oldscape.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class RenderOverview {
   private static final FontName fontNameVerdana11;
   private static final FontName fontNameVerdana13;
   private static final FontName fontNameVerdana15;
   private IndexDataBase indexWorldMap;
   private Font font;
   private HashMap<Size, Font> mapFonts;
   private IndexedSprite[] field4063;
   private HashMap<String, WorldMapData> worldMapDataByIdentifier;
   private WorldMapData field4018;
   private WorldMapData worldMapData;
   private WorldMapData field4032;
   private WorldMapManager worldMapManager;
   private class333 field4043;
   private int worldMapX;
   private int worldMapY;
   private int field4025;
   private int field4026;
   private float worldMapZoom;
   private float worldMapZoomTarget;
   private int field4013;
   private int field4030;
   private int field4031;
   private int field4058;
   private int field4033;
   private int field4034;
   private boolean field4035;
   private HashSet<Integer> field4036;
   private int field4037;
   private int field4038;
   private int field4010;
   private int field4022;
   private int field4041;
   private int field4042;
   private long field4019;
   private int field4044;
   private int field4045;
   private boolean field4052;
   private HashSet<Integer> field4007;
   private HashSet<Integer> field4048;
   private HashSet<Integer> field4049;
   private HashSet<Integer> field4050;
   private boolean field4051;
   private int field4062;
   private final int[] field4061;
   private List<MapIcon> field4054;
   private Iterator<MapIcon> field4006;
   private HashSet<MapIcon> field4056;
   private Coordinates field4057;
   public boolean field4016;
   private SpritePixels field4047;
   private int field4060;
   private int field4039;
   private int field4014;
   private int field4029;

   static {
      fontNameVerdana11 = FontName.FontName_verdana_plain11;
      fontNameVerdana13 = FontName.FontName_verdana_plain13;
      fontNameVerdana15 = FontName.FontName_verdana_plain15;
   }

   public RenderOverview() {
      this.field4025 = -1;
      this.field4026 = -1;
      this.field4013 = -1;
      this.field4030 = -1;
      this.field4031 = -1;
      this.field4058 = -1;
      this.field4033 = 3;
      this.field4034 = 50;
      this.field4035 = false;
      this.field4036 = null;
      this.field4037 = -1;
      this.field4038 = -1;
      this.field4010 = -1;
      this.field4022 = -1;
      this.field4041 = -1;
      this.field4042 = -1;
      this.field4052 = true;
      this.field4007 = new HashSet<>();
      this.field4048 = new HashSet<>();
      this.field4049 = new HashSet<>();
      this.field4050 = new HashSet<>();
      this.field4051 = false;
      this.field4062 = 0;
      this.field4061 = new int[]{1008, 1009, 1010, 1011, 1012};
      this.field4056 = new HashSet<>();
      this.field4057 = null;
      this.field4016 = false;
      this.field4039 = -1;
      this.field4014 = -1;
      this.field4029 = -1;
   }

   public void method6006(final IndexDataBase indexWorldMap, final Font font, final HashMap<FontName, Font> fonts, final IndexedSprite[] mapScene) {
      this.field4063 = mapScene;
      this.indexWorldMap = indexWorldMap;
      this.font = font;
      this.mapFonts = new HashMap<>();
      this.mapFonts.put(Size.small, fonts.get(fontNameVerdana11));
      this.mapFonts.put(Size.medium, fonts.get(fontNameVerdana13));
      this.mapFonts.put(Size.large, fonts.get(fontNameVerdana15));
      this.field4043 = new class333(indexWorldMap);
      final int parent = this.indexWorldMap.getFile(MapCacheArchiveNames.DETAILS.name);
      final int[] children = this.indexWorldMap.getChilds(parent);
      this.worldMapDataByIdentifier = new HashMap<>(children.length);

       for (final int child : children) {
           final Buffer var8 = new Buffer(this.indexWorldMap.getConfigData(parent, child));
           final WorldMapData worldMapData = new WorldMapData();
           worldMapData.loadMapData(var8, child);
           this.worldMapDataByIdentifier.put(worldMapData.getIdentifier(), worldMapData);
           if (worldMapData.method325()) {
               this.field4018 = worldMapData;
           }
       }

      this.method6022(this.field4018);
      this.field4032 = null;
   }

   public int method6057() {
      return this.indexWorldMap.tryLoadRecordByNames(this.field4018.getIdentifier(), MapCacheArchiveNames.AREA.name)?100:this.indexWorldMap.archiveLoadPercentByName(this.field4018.getIdentifier());
   }

   public void method6008() {
      WorldMapRegion.field479.method3937(5);
      WorldMapRegion.field480.method3937(5);
   }

   public void method6009(final int var1, final int var2, final boolean var3, final int var4, final int var5, final int var6, final int var7) {
      if(this.field4043.method5997()) {
         this.method6012();
         this.method6013();
         if(var3) {
            final int var8 = (int)Math.ceil((var6 / this.worldMapZoom));
            final int var9 = (int)Math.ceil((var7 / this.worldMapZoom));
            final List<MapIcon> var10 = this.worldMapManager.method596(this.worldMapX - var8 / 2 - 1, this.worldMapY - var9 / 2 - 1, var8 / 2 + this.worldMapX + 1, var9 / 2 + this.worldMapY + 1, var4, var5, var6, var7, var1, var2);
            final HashSet<MapIcon> var11 = new HashSet<>();

            Iterator<MapIcon> mapIconIterator;
            MapIcon mapIcon;
            ScriptEvent scriptEvent;
            MapIconReference mapIconReference;
            for(mapIconIterator = var10.iterator(); mapIconIterator.hasNext(); AbstractSoundSystem.method2256(scriptEvent)) {
               mapIcon = mapIconIterator.next();
               var11.add(mapIcon);
               scriptEvent = new ScriptEvent();
               mapIconReference = new MapIconReference(mapIcon.areaId, mapIcon.field524, mapIcon.field532);
               scriptEvent.method1137(new Object[]{mapIconReference, var1, var2});
               if(this.field4056.contains(mapIcon)) {
                  scriptEvent.method1138(class245.field2966);
               } else {
                  scriptEvent.method1138(class245.field2968);
               }
            }

            mapIconIterator = this.field4056.iterator();

            while(mapIconIterator.hasNext()) {
               mapIcon = mapIconIterator.next();
               if(!var11.contains(mapIcon)) {
                  scriptEvent = new ScriptEvent();
                  mapIconReference = new MapIconReference(mapIcon.areaId, mapIcon.field524, mapIcon.field532);
                  scriptEvent.method1137(new Object[]{mapIconReference, var1, var2});
                  scriptEvent.method1138(class245.field2971);
                  AbstractSoundSystem.method2256(scriptEvent);
               }
            }

            this.field4056 = var11;
         }
      }
   }

   public void method6010(final int var1, final int var2, final boolean var3, final boolean var4) {
      final long var5 = class64.method1118();
      this.method6011(var1, var2, var4, var5);
      if(!this.method6017() && (var4 || var3)) {
         if(var4) {
            this.field4041 = var1;
            this.field4042 = var2;
            this.field4010 = this.worldMapX;
            this.field4022 = this.worldMapY;
         }

         if(this.field4010 != -1) {
            final int var7 = var1 - this.field4041;
            final int var8 = var2 - this.field4042;
            this.method6014(this.field4010 - (int)(var7 / this.worldMapZoomTarget), (int)(var8 / this.worldMapZoomTarget) + this.field4022, false);
         }
      } else {
         this.method6070();
      }

      if(var4) {
         this.field4019 = var5;
         this.field4044 = var1;
         this.field4045 = var2;
      }

   }

   private void method6011(final int var1, final int var2, final boolean var3, final long var4) {
      if(this.worldMapData != null) {
         final int var6 = (int)(this.worldMapX + ((var1 - this.field4031) - this.method6044() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         final int var7 = (int)(this.worldMapY - ((var2 - this.field4058) - this.method6045() * this.worldMapZoom / 2.0F) / this.worldMapZoom);
         this.field4057 = this.worldMapData.method322(var6 + this.worldMapData.getMinX() * 64, var7 + this.worldMapData.getMinY() * 64);
         if(this.field4057 != null && var3) {
            final boolean var8 = Client.rights >= 2;
            if(var8 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81]) {
               class19.method166(this.field4057.x, this.field4057.y, this.field4057.plane, false);
            } else {
               boolean var9 = true;
               if(this.field4052) {
                  final int var10 = var1 - this.field4044;
                  final int var11 = var2 - this.field4045;
                  if(var4 - this.field4019 > 500L || var10 < -25 || var10 > 25 || var11 < -25 || var11 > 25) {
                     var9 = false;
                  }
               }

               if(var9) {
                  final PacketNode var12 = WorldMapRectangle.method280(ClientPacket.field2409, Client.field957.field1484);
                  var12.packetBuffer.method3559(this.field4057.bitpack());
                  Client.field957.method2052(var12);
                  this.field4019 = 0L;
               }
            }
         }
      } else {
         this.field4057 = null;
      }

   }

   private void method6012() {
      if(BaseVarType.field25 != null) {
         this.worldMapZoom = this.worldMapZoomTarget;
      } else {
         if(this.worldMapZoom < this.worldMapZoomTarget) {
            this.worldMapZoom = Math.min(this.worldMapZoomTarget, this.worldMapZoom + this.worldMapZoom / 30.0F);
         }

         if(this.worldMapZoom > this.worldMapZoomTarget) {
            this.worldMapZoom = Math.max(this.worldMapZoomTarget, this.worldMapZoom - this.worldMapZoom / 30.0F);
         }

      }
   }

   private void method6013() {
      if(this.method6017()) {
         int var1 = this.field4025 - this.worldMapX;
         int var2 = this.field4026 - this.worldMapY;
         if(var1 != 0) {
            var1 /= Math.min(8, Math.abs(var1));
         }

         if(var2 != 0) {
            var2 /= Math.min(8, Math.abs(var2));
         }

         this.method6014(var1 + this.worldMapX, var2 + this.worldMapY, true);
         if(this.worldMapX == this.field4025 && this.field4026 == this.worldMapY) {
            this.field4025 = -1;
            this.field4026 = -1;
         }

      }
   }

   private void method6014(final int x, final int y, final boolean var3) {
      this.worldMapX = x;
      this.worldMapY = y;
      class64.method1118();
      if(var3) {
         this.method6070();
      }

   }

   private void method6070() {
      this.field4042 = -1;
      this.field4041 = -1;
      this.field4022 = -1;
      this.field4010 = -1;
   }

   private boolean method6017() {
      return this.field4025 != -1 && this.field4026 != -1;
   }

   public WorldMapData getWorldMapDataContainingCoord(final int var1, final int var2, final int var3) {
      final Iterator<WorldMapData> worldMapDataIterator = this.worldMapDataByIdentifier.values().iterator();

      WorldMapData var5;
      do {
         if(!worldMapDataIterator.hasNext()) {
            return null;
         }

         var5 = worldMapDataIterator.next();
      } while(!var5.containsCoord(var1, var2, var3));

      return var5;
   }

   public void method6018(final int var1, final int var2, final int var3, final boolean var4) {
      WorldMapData var5 = this.getWorldMapDataContainingCoord(var1, var2, var3);
      if(var5 == null) {
         if(!var4) {
            return;
         }

         var5 = this.field4018;
      }

      boolean var6 = false;
      if(var5 != this.field4032 || var4) {
         this.field4032 = var5;
         this.method6022(var5);
         var6 = true;
      }

      if(var6 || var4) {
         this.method6173(var1, var2, var3);
      }

   }

   public void method6019(final int var1) {
      final WorldMapData var2 = this.getWorldMapDataByFileId(var1);
      if(var2 != null) {
         this.method6022(var2);
      }

   }

   public int method6020() {
      return this.worldMapData == null?-1:this.worldMapData.getFileId();
   }

   public WorldMapData method6021() {
      return this.worldMapData;
   }

   private void method6022(final WorldMapData var1) {
      if(this.worldMapData == null || var1 != this.worldMapData) {
         this.initializeWorldMap(var1);
         this.method6173(-1, -1, -1);
      }
   }

   private void initializeWorldMap(final WorldMapData var1) {
      this.worldMapData = var1;
      this.worldMapManager = new WorldMapManager(this.field4063, this.mapFonts);
      this.field4043.method5995(this.worldMapData.getIdentifier());
   }

   public void method6024(final WorldMapData worldMapData, final Coordinates coords1, final Coordinates coords2, final boolean var4) {
      if(worldMapData != null) {
         if(this.worldMapData == null || worldMapData != this.worldMapData) {
            this.initializeWorldMap(worldMapData);
         }

         if(!var4 && this.worldMapData.containsCoord(coords1.plane, coords1.x, coords1.y)) {
            this.method6173(coords1.plane, coords1.x, coords1.y);
         } else {
            this.method6173(coords2.plane, coords2.x, coords2.y);
         }

      }
   }

   private void method6173(final int var1, final int var2, final int var3) {
      if(this.worldMapData != null) {
         int[] var4 = this.worldMapData.method321(var1, var2, var3);
         if(var4 == null) {
            var4 = this.worldMapData.method321(this.worldMapData.getPlane(), this.worldMapData.getWorldX(), this.worldMapData.getWorldY());
         }

         this.method6014(var4[0] - this.worldMapData.getMinX() * 64, var4[1] - this.worldMapData.getMinY() * 64, true);
         this.field4025 = -1;
         this.field4026 = -1;
         this.worldMapZoom = this.method6005(this.worldMapData.method338());
         this.worldMapZoomTarget = this.worldMapZoom;
         this.field4054 = null;
         this.field4006 = null;
         this.worldMapManager.method591();
      }
   }

   public void extractWorldmap(final int var1, final int var2, final int var3, final int var4, final int var5) {
      final int[] var6 = new int[4];
      Rasterizer2D.copyDrawRegion(var6);
      Rasterizer2D.setDrawRegion(var1, var2, var3 + var1, var2 + var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      final int var7 = this.field4043.method5998();
      if(var7 < 100) {
         this.method6097(var1, var2, var3, var4, var7);
      } else {
         if(!this.worldMapManager.method598()) {
            this.worldMapManager.load(this.indexWorldMap, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.method598()) {
               return;
            }
         }

         if(this.field4036 != null) {
            ++this.field4038;
            if(this.field4038 % this.field4034 == 0) {
               this.field4038 = 0;
               ++this.field4037;
            }

            if(this.field4037 >= this.field4033 && !this.field4035) {
               this.field4036 = null;
            }
         }

         final int var8 = (int)Math.ceil((var3 / this.worldMapZoom));
         final int var9 = (int)Math.ceil((var4 / this.worldMapZoom));
         this.worldMapManager.drawMapRegion(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var3 + var1, var2 + var4);
         boolean var10;
         if(!this.field4051) {
            var10 = false;
            if(var5 - this.field4062 > 100) {
               this.field4062 = var5;
               var10 = true;
            }

            this.worldMapManager.drawMapIcons(this.worldMapX - var8 / 2, this.worldMapY - var9 / 2, var8 / 2 + this.worldMapX, var9 / 2 + this.worldMapY, var1, var3 + var1, var2 + var4, this.field4050, this.field4036, this.field4038, this.field4034, var10);
         }

         this.method6028(var1, var2, var3, var4, var8, var9);
         var10 = Client.rights >= 2;
         if(var10 && this.field4016 && this.field4057 != null) {
            this.font.method5510("Coord: " + this.field4057, Rasterizer2D.draw_region_x + 10, Rasterizer2D.drawingAreaTop + 20, 16776960, -1);
         }

         this.field4013 = var8;
         this.field4030 = var9;
         this.field4031 = var1;
         this.field4058 = var2;
         Rasterizer2D.setDrawRegion(var6);
      }
   }

   private boolean method6027(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
      return this.field4047 == null || (this.field4047.width != var1 || this.field4047.height != var2 || (this.worldMapManager.field548 != this.field4060 || (this.field4029 != Client.field1135 || (var3 > 0 || var4 > 0 || (var3 + var1 < var5 || var2 + var4 < var6)))));
   }

   private void method6028(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
      if(BaseVarType.field25 != null) {
         final int var7 = 512 / (this.worldMapManager.field548 * 2);
         int var8 = var3 + 512;
         int var9 = var4 + 512;
         final float var10 = 1.0F;
         var8 = (int)(var8 / var10);
         var9 = (int)(var9 / var10);
         final int var11 = this.method6047() - var5 / 2 - var7;
         final int var12 = this.method6042() - var6 / 2 - var7;
         int var13 = var1 - (var7 + var11 - this.field4039) * this.worldMapManager.field548;
         int var14 = var2 - this.worldMapManager.field548 * (var7 - (var12 - this.field4014));
         if(this.method6027(var8, var9, var13, var14, var3, var4)) {
            if(this.field4047 != null && this.field4047.width == var8 && this.field4047.height == var9) {
               Arrays.fill(this.field4047.pixels, 0);
            } else {
               this.field4047 = new SpritePixels(var8, var9);
            }

            this.field4039 = this.method6047() - var5 / 2 - var7;
            this.field4014 = this.method6042() - var6 / 2 - var7;
            this.field4060 = this.worldMapManager.field548;
            BaseVarType.field25.method4689(this.field4039, this.field4014, this.field4047, this.field4060 / var10);
            this.field4029 = Client.field1135;
            var13 = var1 - (var11 + var7 - this.field4039) * this.worldMapManager.field548;
            var14 = var2 - this.worldMapManager.field548 * (var7 - (var12 - this.field4014));
         }

         Rasterizer2D.fillRectangle(var1, var2, var3, var4, 0, 128);
         if(var10 == 1.0F) {
            this.field4047.method5868(var13, var14, 192);
         } else {
            this.field4047.method5934(var13, var14, (int)(var10 * var8), (int)(var10 * var9), 192);
         }
      }

   }

   public void extractData(final int var1, final int var2, final int var3, final int var4) {
      if(this.field4043.method5997()) {
         if(!this.worldMapManager.method598()) {
            this.worldMapManager.load(this.indexWorldMap, this.worldMapData.getIdentifier(), Client.isMembers);
            if(!this.worldMapManager.method598()) {
               return;
            }
         }

         this.worldMapManager.method595(var1, var2, var3, var4, this.field4036, this.field4038, this.field4034);
      }
   }

   public void method6030(final int var1) {
      this.worldMapZoomTarget = this.method6005(var1);
   }

   private void method6097(final int var1, final int var2, final int var3, final int var4, final int var5) {
      final byte var6 = 20;
      final int var7 = var3 / 2 + var1;
      final int var8 = var4 / 2 + var2 - 18 - var6;
      Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, -16777216);
      Rasterizer2D.drawRectangle(var7 - 152, var8, 304, 34, -65536);
      Rasterizer2D.Rasterizer2D_fillRectangle(var7 - 150, var8 + 2, var5 * 3, 30, -65536);
      this.font.drawTextCentered("Loading...", var7, var6 + var8, -1, -1);
   }

   private float method6005(final int var1) {
      if (var1 == 25) return 1.0F;
      else if (var1 == 37) return 1.5F;
      else if (var1 == 50) return 2.0F;
      else if (var1 == 75) return 3.0F;
      else if (var1 == 100) return 4.0F;
      else return 8.0F;
   }

   public int method6033() {
      if (1.0D == this.worldMapZoomTarget) return 25;
      else if (1.5D == this.worldMapZoomTarget) return 37;
      else if (this.worldMapZoomTarget == 2.0D) return 50;
      else if (3.0D == this.worldMapZoomTarget) return 75;
      else return this.worldMapZoomTarget == 4.0D ? 100 : 200;
   }

   public void method6034() {
      this.field4043.method5996();
   }

   public boolean method6035() {
      return this.field4043.method5997();
   }

   public WorldMapData getWorldMapDataByFileId(final int var1) {
      final Iterator<WorldMapData> var2 = this.worldMapDataByIdentifier.values().iterator();

      WorldMapData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = var2.next();
      } while(var3.getFileId() != var1);

      return var3;
   }

   public void method6037(final int var1, final int var2) {
      if(this.worldMapData != null && this.worldMapData.method335(var1, var2)) {
         this.field4025 = var1 - this.worldMapData.getMinX() * 64;
         this.field4026 = var2 - this.worldMapData.getMinY() * 64;
      }
   }

   public void method6038(final int var1, final int var2) {
      if(this.worldMapData != null) {
         this.method6014(var1 - this.worldMapData.getMinX() * 64, var2 - this.worldMapData.getMinY() * 64, true);
         this.field4025 = -1;
         this.field4026 = -1;
      }
   }

   public void method6029(final int var1, final int var2, final int var3) {
      if(this.worldMapData != null) {
         final int[] var4 = this.worldMapData.method321(var1, var2, var3);
         if(var4 != null) {
            this.method6037(var4[0], var4[1]);
         }

      }
   }

   public void method6040(final int var1, final int var2, final int var3) {
      if(this.worldMapData != null) {
         final int[] var4 = this.worldMapData.method321(var1, var2, var3);
         if(var4 != null) {
            this.method6038(var4[0], var4[1]);
         }

      }
   }

   public int method6047() {
      return this.worldMapData == null?-1:this.worldMapX + this.worldMapData.getMinX() * 64;
   }

   public int method6042() {
      return this.worldMapData == null?-1:this.worldMapY + this.worldMapData.getMinY() * 64;
   }

   public Coordinates method6043() {
      return this.worldMapData == null?null:this.worldMapData.method322(this.method6047(), this.method6042());
   }

   public int method6044() {
      return this.field4013;
   }

   public int method6045() {
      return this.field4030;
   }

   public void method6118(final int var1) {
      if(var1 >= 1) {
         this.field4033 = var1;
      }

   }

   public void method6157() {
      this.field4033 = 3;
   }

   public void method6048(final int var1) {
      if(var1 >= 1) {
         this.field4034 = var1;
      }

   }

   public void method6141() {
      this.field4034 = 50;
   }

   public void method6106(final boolean var1) {
      this.field4035 = var1;
   }

   public void method6051(final int var1) {
      this.field4036 = new HashSet<>();
      this.field4036.add(var1);
      this.field4037 = 0;
      this.field4038 = 0;
   }

   public void method6134(final int var1) {
      this.field4036 = new HashSet<>();
      this.field4037 = 0;
      this.field4038 = 0;

      for(int var2 = 0; var2 < Area.mapAreaType.length; ++var2) {
         if(Area.mapAreaType[var2] != null && Area.mapAreaType[var2].field3473 == var1) {
            this.field4036.add(Area.mapAreaType[var2].id);
         }
      }

   }

   public void method6160() {
      this.field4036 = null;
   }

   public void method6054(final boolean var1) {
      this.field4051 = !var1;
   }

   public void method6055(final int var1, final boolean var2) {
      if(!var2) {
         this.field4007.add(var1);
      } else {
         this.field4007.remove(var1);
      }

      this.method6060();
   }

   public void method6056(final int var1, final boolean var2) {
      if(!var2) {
         this.field4048.add(var1);
      } else {
         this.field4048.remove(var1);
      }

      for(int var3 = 0; var3 < Area.mapAreaType.length; ++var3) {
         if(Area.mapAreaType[var3] != null && Area.mapAreaType[var3].field3473 == var1) {
            final int areaType = Area.mapAreaType[var3].id;
            if(!var2) {
               this.field4049.add(areaType);
            } else {
               this.field4049.remove(areaType);
            }
         }
      }

      this.method6060();
   }

   public boolean method6074() {
      return !this.field4051;
   }

   public boolean method6058(final int var1) {
      return !this.field4007.contains(var1);
   }

   public boolean method6059(final int var1) {
      return !this.field4048.contains(var1);
   }

   private void method6060() {
      this.field4050.clear();
      this.field4050.addAll(this.field4007);
      this.field4050.addAll(this.field4049);
   }

   public void method6077(final int var1, final int var2, final int var3, final int var4, final int var5, final int var6) {
      if(this.field4043.method5997()) {
         final int var7 = (int)Math.ceil((var3 / this.worldMapZoom));
         final int var8 = (int)Math.ceil((var4 / this.worldMapZoom));
         final List var9 = this.worldMapManager.method596(this.worldMapX - var7 / 2 - 1, this.worldMapY - var8 / 2 - 1, var7 / 2 + this.worldMapX + 1, var8 / 2 + this.worldMapY + 1, var1, var2, var3, var4, var5, var6);
         if(!var9.isEmpty()) {
            final Iterator var10 = var9.iterator();

            boolean var13;
            do {
               if(!var10.hasNext()) {
                  return;
               }

               final MapIcon var11 = (MapIcon)var10.next();
               final Area var12 = Area.mapAreaType[var11.areaId];
               var13 = false;

               for(int var14 = this.field4061.length - 1; var14 >= 0; --var14) {
                  if(var12.actions[var14] != null) {
                     TextureProvider.addMenuEntry(var12.actions[var14], var12.field3470, this.field4061[var14], var11.areaId, var11.field524.bitpack(), var11.field532.bitpack());
                     var13 = true;
                  }
               }
            } while(!var13);

         }
      }
   }

   public Coordinates method6062(final int var1, final Coordinates var2) {
      if(!this.field4043.method5997()) {
         return null;
      } else if(!this.worldMapManager.method598()) {
         return null;
      } else if(!this.worldMapData.method335(var2.x, var2.y)) {
         return null;
      } else {
         final HashMap<Integer, List<MapIcon>> var3 = this.worldMapManager.method612();
         final List<MapIcon> var4 = var3.get(var1);
         if(var4 != null && !var4.isEmpty()) {
            MapIcon var5 = null;
            int var6 = -1;
            final Iterator<MapIcon> var7 = var4.iterator();

            while(true) {
               MapIcon var8;
               int var11;
               do {
                  if(!var7.hasNext()) {
                     return var5.field532;
                  }

                  var8 = var7.next();
                  final int var9 = var8.field532.x - var2.x;
                  final int var10 = var8.field532.y - var2.y;
                  var11 = var10 * var10 + var9 * var9;
                  if(var11 == 0) {
                     return var8.field532;
                  }
               } while(var11 >= var6 && var5 != null);

               var5 = var8;
               var6 = var11;
            }
         } else {
            return null;
         }
      }
   }

   public void onMapClicked(final int var1, final int areaId, final Coordinates var3, final Coordinates var4) {
      final ScriptEvent var5 = new ScriptEvent();
      final MapIconReference var6 = new MapIconReference(areaId, var3, var4);
      var5.method1137(new Object[]{var6});
      switch(var1) {
      case 1008:
         var5.method1138(class245.field2976);
         break;
      case 1009:
         var5.method1138(class245.field2969);
         break;
      case 1010:
         var5.method1138(class245.field2965);
         break;
      case 1011:
         var5.method1138(class245.field2970);
         break;
      case 1012:
         var5.method1138(class245.field2967);
      }

      AbstractSoundSystem.method2256(var5);
   }

   public MapIcon method6064() {
      if(!this.field4043.method5997()) {
         return null;
      } else if(!this.worldMapManager.method598()) {
         return null;
      } else {
         final HashMap<Integer, List<MapIcon>> var1 = this.worldMapManager.method612();
         this.field4054 = new LinkedList<>();

         for (final List<MapIcon> var3 : var1.values()) {
            this.field4054.addAll(var3);
         }

         this.field4006 = this.field4054.iterator();
         return this.method6065();
      }
   }

   public MapIcon method6065() {
      return this.field4006 == null?null:(!this.field4006.hasNext()?null: this.field4006.next());
   }
}
