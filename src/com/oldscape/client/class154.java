package com.oldscape.client;

class class154 extends class297 {
   public static boolean[] validInterfaces;
   private final boolean field2158;

   public class154(final boolean var1) {
      this.field2158 = var1;
   }

   private int method3149(final ChatPlayer var1, final ChatPlayer var2) {
      if(var1.world != 0) {
         if(var2.world == 0) {
            return this.field2158?-1:1;
         }
      } else if(var2.world != 0) {
         return this.field2158?1:-1;
      }

      return this.doCompare(var1, var2);
   }

   public int compare(final Object var1, final Object var2) {
      return this.method3149((ChatPlayer)var1, (ChatPlayer)var2);
   }

   public static int method3157(final int var0, final int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   static void method3156() {
      if(Client.spellSelected) {
         final Widget var0 = FontName.getWidgetChild(class234.field2768, Client.field1025);
         if(var0 != null && var0.onTargetLeaveListener != null) {
            final ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.objs = var0.onTargetLeaveListener;
            AbstractSoundSystem.method2256(var1);
         }

         Client.spellSelected = false;
         FontName.method5490(var0);
      }
   }
}
