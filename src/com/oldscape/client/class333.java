package com.oldscape.client;

public class class333 {
   String field4000;
   IndexDataBase field4003;
   int field4004;
   boolean field4005;

   class333(IndexDataBase var1) {
      this.field4004 = 0;
      this.field4005 = false;
      this.field4003 = var1;
   }

   void method5995(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field4000) {
            this.field4000 = var1;
            this.field4004 = 0;
            this.field4005 = false;
            this.method5996();
         }
      }
   }

   int method5996() {
      if(this.field4004 < 25) {
         if(!this.field4003.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, this.field4000)) {
            return this.field4004;
         }

         this.field4004 = 25;
      }

      if(this.field4004 == 25) {
         if(!this.field4003.tryLoadRecordByNames(this.field4000, MapCacheArchiveNames.AREA.name)) {
            return 25 + this.field4003.archiveLoadPercentByName(this.field4000) * 25 / 100;
         }

         this.field4004 = 50;
      }

      if(this.field4004 == 50) {
         if(this.field4003.method4599(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field4000) && !this.field4003.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, this.field4000)) {
            return 50;
         }

         this.field4004 = 75;
      }

      if(this.field4004 == 75) {
         if(!this.field4003.tryLoadRecordByNames(this.field4000, MapCacheArchiveNames.LABELS.name)) {
            return 75;
         }

         this.field4004 = 100;
         this.field4005 = true;
      }

      return this.field4004;
   }

   boolean method5997() {
      return this.field4005;
   }

   int method5998() {
      return this.field4004;
   }
}
