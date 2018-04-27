package com.oldscape.client;

public class MapLabel {
   public static int canvasWidth;
   String text;
   int field470;
   int field469;
   Size fontSize;

   MapLabel(String var1, int var2, int var3, Size var4) {
      this.text = var1;
      this.field470 = var2;
      this.field469 = var3;
      this.fontSize = var4;
   }

   static final int method410() {
      return class132.Viewport_mouseY;
   }

   static final void method411(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1072[var4] = true;
         }
      }

   }
}
