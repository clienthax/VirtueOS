package com.oldscape.client;

class class150 extends class297 {
   private final boolean field2143;

   public class150(final boolean var1) {
      this.field2143 = var1;
   }

   private int doCompare(final ChatPlayer var1, final ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2143?var1.getCurrentName().compareCleanName(var2.getCurrentName()):var2.getCurrentName().compareCleanName(var1.getCurrentName())): this.doCompare(var1, var2);
   }

   @Override
   public int compare(final Object var1, final Object var2) {
      return this.doCompare((ChatPlayer)var1, (ChatPlayer)var2);
   }

   public static void method3111() {
      class326.classInfos = new CombatInfoList();
   }

   public static int method3118(final byte[] var0, final int var1) {
      return ClanMember.method5252(var0, 0, var1);
   }

   public static VarPlayerType method3119(final int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get(var0);
      if (var1 == null) {
         final byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, var0);
      }
      return var1;
   }

   public static int parseInt(final CharSequence var0, final int var1) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         final int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            final char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            final int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   static synchronized void method3110(final byte[] var0) {
      if(var0.length == 100 && class195.field2583 < 1000) {
         class195.field2580[++class195.field2583 - 1] = var0;
      } else if(var0.length == 5000 && class195.field2579 < 250) {
         class195.field2581[++class195.field2579 - 1] = var0;
      } else if(var0.length == 30000 && class195.field2578 < 50) {
         class195.field2585[++class195.field2578 - 1] = var0;
      } else {
         if(class319.field3930 != null) {
            for(int var1 = 0; var1 < class195.field2584.length; ++var1) {
               if(var0.length == class195.field2584[var1] && OwnWorldComparator.field866[var1] < class319.field3930[var1].length) {
                  class319.field3930[var1][OwnWorldComparator.field866[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }
}
