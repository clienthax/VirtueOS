package com.oldscape.client;

public class class298 extends NameableContainer {
   static int[] mapRegions;
   final JagexLoginType field3835;

   public class298(JagexLoginType var1) {
      super(400);
      this.field3835 = var1;
   }

   Nameable vmethod5454() {
      return new Ignore();
   }

   Nameable[] vmethod5462(int var1) {
      return new Ignore[var1];
   }

   public void method5294(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3835);//current name
            Name var6 = new Name(var1.readString(), this.field3835);//previous name
//            System.out.println(var5.name+", "+var6.name);
            var1.readString();
            if(var5 != null && var5.isCleanNameValid()) {
               Ignore var7 = (Ignore)this.method5327(var5);
               if(var4) {
                  Ignore var8 = (Ignore)this.method5327(var6);
                  if(var8 != null && var7 != var8) {
                     if(var7 != null) {
                        this.method5311(var8);
                     } else {
                        var7 = var8;
                     }
                  }
               }

               if(var7 != null) {
                  this.method5316(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  int var9 = this.getCount();
                  var7 = (Ignore)this.method5313(var5, var6);
                  var7.field3844 = var9;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }
}
