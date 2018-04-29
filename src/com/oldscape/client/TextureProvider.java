package com.oldscape.client;

public class TextureProvider implements ITextureLoader {
   private final Texture[] textures;
   private Deque deque;
   private final int maxSize;
   private int size;
   private double brightness;
   private int width;
   private final IndexDataBase sprites;

   public TextureProvider(final IndexDataBase var1, final IndexDataBase var2, final int var3, final double var4, final int var6) {
      this.deque = new Deque();
      this.size = 0;
      this.brightness = 1.0D;
      this.width = 128;
      this.sprites = var2;
      this.maxSize = var3;
      this.size = this.maxSize;
      this.brightness = var4;
      this.width = var6;
      final int[] var7 = var1.getChilds(0);
       this.textures = new Texture[var1.fileCount(0)];

       for (final int aVar7 : var7) {
           final Buffer var10 = new Buffer(var1.getConfigData(0, aVar7));
           this.textures[aVar7] = new Texture(var10);
       }

   }

   public int method2572() {
      int var1 = 0;
      int var2 = 0;
      final Texture[] var3 = this.textures;

       for (final Texture var5 : var3) {
           if (var5 != null && var5.fileIds != null) {
               var1 += var5.fileIds.length;
               final int[] var6 = var5.fileIds;

               for (final int var8 : var6) {
                   if (this.sprites.method4615(var8)) {
                       ++var2;
                   }
               }
           }
       }

      if(var1 == 0) {
         return 0;
      } else {
         return var2 * 100 / var1;
      }
   }

   public void brightness(final double var1) {
      this.brightness = var1;
      this.reset();
   }

   public int[] load(final int var1) {
      final Texture var2 = this.textures[var1];
      if(var2 != null) {
         if(var2.pixels != null) {
            this.deque.addTail(var2);
            var2.loaded = true;
            return var2.pixels;
         }

         final boolean var3 = var2.method2675(this.brightness, this.width, this.sprites);
         if(var3) {
            if(this.size == 0) {
               final Texture var4 = (Texture)this.deque.popTail();
               var4.resetPixels();
            } else {
               --this.size;
            }

            this.deque.addTail(var2);
            var2.loaded = true;
            return var2.pixels;
         }
      }

      return null;
   }

   @Override
   public int getAverageTextureRGB(final int textureId) {
      return this.textures[textureId] != null?this.textures[textureId].field1803:0;
   }

   @Override
   public boolean vmethod3069(final int textureId) {
      return this.textures[textureId].field1806;
   }

   @Override
   public boolean isLowMem(final int var1) {
      return this.width == 64;
   }

   public void reset() {
       for (final Texture texture : this.textures) {
           if (texture != null) {
               texture.resetPixels();
           }
       }

      this.deque = new Deque();
      this.size = this.maxSize;
   }

   public void checkTextures(final int var1) {
       for (final Texture var3 : this.textures) {
           if (var3 != null && var3.field1810 != 0 && var3.loaded) {
               var3.method2674(var1);
               var3.loaded = false;
           }
       }

   }

   public static void method2592(final IndexDataBase var0) {
      VarCInt.field3476 = var0;
   }

   public static void addMenuEntry(final String var0, final String var1, final int var2, final int var3, final int var4, final int var5) {
      final boolean var12 = false;
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         Client.menuBooleanArray[Client.menuOptionCount] = var12;
         ++Client.menuOptionCount;
      }

   }
}
