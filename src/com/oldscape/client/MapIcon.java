package com.oldscape.client;

public class MapIcon {
   public final int areaId;
   public final Coordinates field532;
   public final Coordinates field524;
   private final int width;
   private final int height;
   final MapLabel mapLabel;
   int screenX;
   int screenY;

   MapIcon(final int areaId, final Coordinates var2, final Coordinates var3, final MapLabel mapLabel) {
      this.areaId = areaId;
      this.field524 = var2;
      this.field532 = var3;
      this.mapLabel = mapLabel;
      final Area area = Area.mapAreaType[this.areaId];
      final SpritePixels spritePixels = area.getMapIcon();
      if(spritePixels != null) {
         this.width = spritePixels.width;
         this.height = spritePixels.height;
      } else {
         this.width = 0;
         this.height = 0;
      }

   }

   boolean method583(final int var1, final int var2) {
      return this.method580(var1, var2) || this.method581(var1, var2);
   }

   private boolean method580(final int var1, final int var2) {
      final Area area = Area.mapAreaType[this.areaId];
      switch(area.horizontalAlignment.value) {
      case 0:
         if(var1 < this.screenX - this.width / 2 || var1 > this.width / 2 + this.screenX) {
            return false;
         }
         break;
      case 1:
         if(var1 >= this.screenX && var1 < this.screenX + this.width) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.screenX - this.width || var1 > this.screenX) {
            return false;
         }
      }

      switch(area.verticalAlignment.value) {
      case 0:
         if(var2 <= this.screenY - this.height || var2 > this.screenY) {
            return false;
         }
         break;
      case 1:
         if(var2 < this.screenY - this.height / 2 || var2 > this.height / 2 + this.screenY) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.screenY || var2 >= this.screenY + this.height) {
            return false;
         }
      }

      return true;
   }

   private boolean method581(final int var1, final int var2) {
      return this.mapLabel != null && ((var1 >= this.screenX - this.mapLabel.field470 / 2 && var1 <= this.mapLabel.field470 / 2 + this.screenX) && (var2 >= this.screenY && var2 <= this.mapLabel.field469 + this.screenY));
   }

   public static void method587() {
      try {
         class167.dat2File.close();

         for(int var0 = 0; var0 < class37.idxCount; ++var0) {
            Size.idxFiles[var0].close();
         }

         class167.idx255File.close();
         class167.randomDat.close();
      } catch (final Exception ignored) {
      }

   }
}
