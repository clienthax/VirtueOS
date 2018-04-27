package com.oldscape.client;

public class MapIcon {
   public final int areaId;
   public final Coordinates field532;
   public final Coordinates field524;
   final int field525;
   final int field526;
   final MapLabel field527;
   int screenX;
   int screenY;

   MapIcon(int var1, Coordinates var2, Coordinates var3, MapLabel var4) {
      this.areaId = var1;
      this.field524 = var2;
      this.field532 = var3;
      this.field527 = var4;
      Area var5 = Area.mapAreaType[this.areaId];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field525 = var6.width;
         this.field526 = var6.height;
      } else {
         this.field525 = 0;
         this.field526 = 0;
      }

   }

   boolean method583(int var1, int var2) {
      return this.method580(var1, var2)?true:this.method581(var1, var2);
   }

   boolean method580(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.areaId];
      switch(var3.horizontalAlignment.value) {
      case 0:
         if(var1 < this.screenX - this.field525 / 2 || var1 > this.field525 / 2 + this.screenX) {
            return false;
         }
         break;
      case 1:
         if(var1 >= this.screenX && var1 < this.screenX + this.field525) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.screenX - this.field525 || var1 > this.screenX) {
            return false;
         }
      }

      switch(var3.verticalAlignment.value) {
      case 0:
         if(var2 <= this.screenY - this.field526 || var2 > this.screenY) {
            return false;
         }
         break;
      case 1:
         if(var2 < this.screenY - this.field526 / 2 || var2 > this.field526 / 2 + this.screenY) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.screenY || var2 >= this.screenY + this.field526) {
            return false;
         }
      }

      return true;
   }

   boolean method581(int var1, int var2) {
      return this.field527 == null?false:(var1 >= this.screenX - this.field527.field470 / 2 && var1 <= this.field527.field470 / 2 + this.screenX?var2 >= this.screenY && var2 <= this.field527.field469 + this.screenY:false);
   }

   public static void method587() {
      try {
         class167.dat2File.close();

         for(int var0 = 0; var0 < class37.idxCount; ++var0) {
            Size.idxFiles[var0].close();
         }

         class167.idx255File.close();
         class167.randomDat.close();
      } catch (Exception var2) {
      }

   }
}
