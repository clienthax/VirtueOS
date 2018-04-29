package com.oldscape.client;

class class25 {
   final int areaId;
   final Coordinates coordinates;

   class25(final int areaId, final Coordinates coordinates) {
      this.areaId = areaId;
      this.coordinates = coordinates;
   }

   public static void setMouseIdleTicks(final int mouseIdleTicks) {
      MouseInput.mouseIdleTicks = mouseIdleTicks;
   }

   public static void method201() {
      Widget.field2817.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2819.reset();
   }

   static void method202(final Widget widget, final int var1, final int var2) {
      final class236 var4 = widget.method4425(false);
      if(var4 != null) {
         if(Client.field1099 < 3) {
            class7.compass.method5875(var1, var2, var4.width, var4.height, 25, 25, Client.mapAngle, 256, var4.field2774, var4.field2771);
         } else {
            Rasterizer2D.method5737(var1, var2, 0, var4.field2774, var4.field2771);
         }

      }
   }
}
