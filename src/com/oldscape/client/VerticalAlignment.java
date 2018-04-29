package com.oldscape.client;

public enum VerticalAlignment implements Enumerated {
   field3442(0, 0),
   field3440(1, 1),
   field3439(2, 2);

   public final int value;
   final int field3443;

   VerticalAlignment(final int var3, final int var4) {
      this.value = var3;
      this.field3443 = var4;
   }

   public int rsOrdinal() {
      return this.field3443;
   }

   static String method4715(String var0, final boolean var1) {
      final String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class55.sessionToken != null) {
         var3 = "/p=" + class55.sessionToken;
      }

      final String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + WidgetNode.field795 + var3 + "/";
   }
}
