package com.oldscape.client;

public class class281 extends CacheableNode {
   static IndexDataBase field3585;
   public static NodeCache field3568;
   public static NodeCache field3569;
   public static NodeCache field3570;
   int field3573;
   public int field3574;
   public int field3575;
   int field3576;
   int field3578;
   int field3580;
   int field3579;
   public int field3571;
   public int field3581;
   public int field3582;
   String field3583;
   public int field3588;
   public int field3584;
   public int[] field3586;
   int field3587;
   int field3567;

   static {
      field3568 = new NodeCache(64);
      field3569 = new NodeCache(64);
      field3570 = new NodeCache(20);
   }

   class281() {
      this.field3573 = -1;
      this.field3574 = 16777215;
      this.field3575 = 70;
      this.field3576 = -1;
      this.field3578 = -1;
      this.field3580 = -1;
      this.field3579 = -1;
      this.field3571 = 0;
      this.field3581 = 0;
      this.field3582 = -1;
      this.field3583 = "";
      this.field3588 = -1;
      this.field3584 = 0;
      this.field3587 = -1;
      this.field3567 = -1;
   }

   void method4965(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4961(var1, var2);
      }
   }

   void method4961(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3573 = var1.method3576();
      } else if(var2 == 2) {
         this.field3574 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3576 = var1.method3576();
      } else if(var2 == 4) {
         this.field3580 = var1.method3576();
      } else if(var2 == 5) {
         this.field3578 = var1.method3576();
      } else if(var2 == 6) {
         this.field3579 = var1.method3576();
      } else if(var2 == 7) {
         this.field3571 = var1.readShort();
      } else if(var2 == 8) {
         this.field3583 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3575 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3581 = var1.readShort();
      } else if(var2 == 11) {
         this.field3582 = 0;
      } else if(var2 == 12) {
         this.field3588 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3584 = var1.readShort();
      } else if(var2 == 14) {
         this.field3582 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3587 = var1.readUnsignedShort();
         if(this.field3587 == 65535) {
            this.field3587 = -1;
         }

         this.field3567 = var1.readUnsignedShort();
         if(this.field3567 == 65535) {
            this.field3567 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3586 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3586[var5] = var1.readUnsignedShort();
            if(this.field3586[var5] == 65535) {
               this.field3586[var5] = -1;
            }
         }

         this.field3586[var4 + 1] = var3;
      }

   }

   public final class281 method4962() {
      int var1 = -1;
      if(this.field3587 != -1) {
         var1 = DynamicObject.getVarbit(this.field3587);
      } else if(this.field3567 != -1) {
         var1 = class237.clientVarps[this.field3567];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3586.length - 1) {
         var2 = this.field3586[var1];
      } else {
         var2 = this.field3586[this.field3586.length - 1];
      }

      return var2 != -1?Huffman.method3457(var2):null;
   }

   public String method4963(int var1) {
      String var2 = this.field3583;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + ScriptVarType.method19(var1, false) + var2.substring(var3 + 2);
      }
   }

   public SpritePixels method4968() {
      if(this.field3576 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3569.get((long)this.field3576);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SoundTaskDataProvider.method817(class5.field35, this.field3576, 0);
            if(var1 != null) {
               field3569.put(var1, (long)this.field3576);
            }

            return var1;
         }
      }
   }

   public SpritePixels method4991() {
      if(this.field3578 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3569.get((long)this.field3578);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SoundTaskDataProvider.method817(class5.field35, this.field3578, 0);
            if(var1 != null) {
               field3569.put(var1, (long)this.field3578);
            }

            return var1;
         }
      }
   }

   public SpritePixels method4966() {
      if(this.field3580 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3569.get((long)this.field3580);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SoundTaskDataProvider.method817(class5.field35, this.field3580, 0);
            if(var1 != null) {
               field3569.put(var1, (long)this.field3580);
            }

            return var1;
         }
      }
   }

   public SpritePixels method4981() {
      if(this.field3579 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3569.get((long)this.field3579);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SoundTaskDataProvider.method817(class5.field35, this.field3579, 0);
            if(var1 != null) {
               field3569.put(var1, (long)this.field3579);
            }

            return var1;
         }
      }
   }

   public Font method4970() {
      if(this.field3573 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3570.get((long)this.field3573);
         if(var1 != null) {
            return var1;
         } else {
            var1 = FontName.method5488(class5.field35, class156.field2167, this.field3573, 0);
            if(var1 != null) {
               field3570.put(var1, (long)this.field3573);
            }

            return var1;
         }
      }
   }
}
