package com.oldscape.client;

class class250 {
   static int field3022;

   public static int method4502(final int var0) {
      return var0 >> 11 & 63;
   }

   static void method4503() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         final int var1 = var0.id;
         if(class189.loadWidget(var1)) {
            boolean var2 = true;
            final Widget[] var3 = MouseRecorder.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               final Widget var5 = class44.getWidget(var4);
               if(var5 != null) {
                  FontName.method5490(var5);
               }
            }
         }
      }

   }
}
