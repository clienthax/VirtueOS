package com.oldscape.client;

public class class151 extends class297 {
   static IndexData indexSprites;
   final boolean field2147;

   public class151(boolean var1) {
      this.field2147 = var1;
   }

   int method3123(ChatPlayer var1, ChatPlayer var2) {
      if(Client.world == var1.world) {
         if(var2.world != Client.world) {
            return this.field2147?-1:1;
         }
      } else if(var2.world == Client.world) {
         return this.field2147?1:-1;
      }

      return this.method5282(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3123((ChatPlayer)var1, (ChatPlayer)var2);
   }

   public static void method3130(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      class289.field3777 = VarPlayerType.varplayer_ref.fileCount(16);
   }
}
