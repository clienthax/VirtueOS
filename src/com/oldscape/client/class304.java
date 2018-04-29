package com.oldscape.client;

public class class304 extends NameableContainer {
   private final JagexLoginType jagexLoginType;
   private int field3855;
   public final class220 field3856;

   public class304(final JagexLoginType var1) {
      super(400);
      this.field3855 = 1;
      this.field3856 = new class220();
      this.jagexLoginType = var1;
   }

   Nameable vmethod5454() {
      return new Friend();
   }

   Nameable[] vmethod5462(final int count) {
      return new Friend[count];
   }

   boolean method5414(final Name name, final boolean var2) {
      final Friend var3 = (Friend)this.method5307(name);
      return var3 != null && (!var2 || var3.world != 0);
   }

   void method5411(final Buffer var1, final int var2) {
      while(true) {
         if(var1.offset < var2) {
            final boolean var3 = var1.readUnsignedByte() == 1;
            final Name var4 = new Name(var1.readString(), this.jagexLoginType);
            final Name var5 = new Name(var1.readString(), this.jagexLoginType);
            final int var6 = var1.readUnsignedShort();
            final int var7 = var1.readUnsignedByte();
            final int var8 = var1.readUnsignedByte();
            final boolean var9 = (var8 & 2) != 0;
            final boolean var10 = (var8 & 1) != 0;
            if(var6 > 0) {
               var1.readString();
               var1.readUnsignedByte();
               var1.readInt();
            }

            var1.readString();
            if(var4.isCleanNameValid()) {
               Friend var11 = (Friend)this.method5327(var4);
               if(var3) {
                  final Friend var12 = (Friend)this.method5327(var5);
                  if(var12 != null && var12 != var11) {
                     if(var11 != null) {
                        this.method5311(var12);
                     } else {
                        var11 = var12;
                     }
                  }
               }

               if(var11 != null) {
                  this.method5316(var11, var4, var5);
                  if(var6 != var11.world) {
                     boolean var14 = true;

                     for(class308 var13 = (class308)this.field3856.method4061(); var13 != null; var13 = (class308)this.field3856.method4060()) {
                        if(var13.name.equals(var4)) {
                           if(var6 != 0 && var13.field3875 == 0) {
                              var13.method4067();
                              var14 = false;
                           } else if(var6 == 0 && var13.field3875 != 0) {
                              var13.method4067();
                              var14 = false;
                           }
                        }
                     }

                     if(var14) {
                        this.field3856.method4057(new class308(var4, var6));
                     }
                  }
               } else {
                  if(this.getCount() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.method5313(var4, var5);
               }

               if(var6 != var11.world) {
                  var11.field3845 = ++this.field3855 - 1;
                  if(var11.world == -1 && var6 == 0) {
                     var11.field3845 = -(var11.field3845 * -1152622641) * 488130351;
                  }

                  var11.world = var6;
               }

               var11.rank = var7;
               var11.field3862 = var9;
               var11.field3861 = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method5331();
         return;
      }
   }

   public static int method5422(final CharSequence var0, final int var1) {
      return class150.parseInt(var0, var1);
   }

   public static boolean method5423(final int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
