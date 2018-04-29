package com.oldscape.client;

class DynamicObject extends Renderable {
   private final int id;
   private final int type;
   private final int orientation;
   private final int level;
   private final int sceneX;
   private final int sceneY;
   private Sequence animation;
   private int animFrame;
   private int animCycleCount;

   DynamicObject(final int id, final int type, final int orientation, final int level, final int sceneX, final int sceneY, final int animation, final boolean var8, final Renderable renderable) {
      this.id = id;
      this.type = type;
      this.orientation = orientation;
      this.level = level;
      this.sceneX = sceneX;
      this.sceneY = sceneY;
      if(animation != -1) {
         this.animation = CombatInfo1.getAnimation(animation);
         this.animFrame = 0;
         this.animCycleCount = Client.gameCycle - 1;
         if(this.animation.replyMode == 0 && renderable instanceof DynamicObject) {
            final DynamicObject dynamicObject = (DynamicObject)renderable;
            if(dynamicObject.animation == this.animation) {
               this.animFrame = dynamicObject.animFrame;
               this.animCycleCount = dynamicObject.animCycleCount;
               return;
            }
         }

         if(var8 && this.animation.frameStep != -1) {
            this.animFrame = (int)(Math.random() * this.animation.frameIDs.length);
            this.animCycleCount -= (int)(Math.random() * this.animation.frameLengths[this.animFrame]);
         }
      }

   }

   protected final Model getModel() {
      if(this.animation != null) {
         int var1 = Client.gameCycle - this.animCycleCount;
         if(var1 > 100 && this.animation.frameStep > 0) {
            var1 = 100;
         }

         label55: {
            do {
               do {
                  if(var1 <= this.animation.frameLengths[this.animFrame]) {
                     break label55;
                  }

                  var1 -= this.animation.frameLengths[this.animFrame];
                  ++this.animFrame;
               } while(this.animFrame < this.animation.frameIDs.length);

               this.animFrame -= this.animation.frameStep;
            } while(this.animFrame >= 0 && this.animFrame < this.animation.frameIDs.length);

            this.animation = null;
         }

         this.animCycleCount = Client.gameCycle - var1;
      }

      ObjectComposition objectDefinition = GameCanvas.getObjectDefinition(this.id);
      if(objectDefinition.impostorIds != null) {
         objectDefinition = objectDefinition.getImpostor();
      }

      if(objectDefinition == null) {
         return null;
      } else {
         final int x;
         final int y;
         if(this.orientation != 1 && this.orientation != 3) {
            x = objectDefinition.width;
            y = objectDefinition.length;
         } else {
            x = objectDefinition.length;
            y = objectDefinition.width;
         }

         final int var4 = (x >> 1) + this.sceneX;
         final int var5 = (x + 1 >> 1) + this.sceneX;
         final int var6 = (y >> 1) + this.sceneY;
         final int var7 = (y + 1 >> 1) + this.sceneY;
         final int[][] tileHeight = class62.tileHeights[this.level];
         final int var9 = tileHeight[var5][var7] + tileHeight[var4][var7] + tileHeight[var4][var6] + tileHeight[var5][var6] >> 2;
         final int var10 = (this.sceneX << 7) + (x << 6);
         final int var11 = (this.sceneY << 7) + (y << 6);
         return objectDefinition.method5000(this.type, this.orientation, tileHeight, var10, var9, var11, this.animation, this.animFrame);
      }
   }

   public static boolean method2021(final int var0, final int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   static void method2024(final int var0, final int var1) {
      final int[] var2 = new int[4];
      final int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1230[var5] != var0) {
            var2[var4] = World.field1230[var5];
            var3[var4] = World.field1229[var5];
            ++var4;
         }
      }

      World.field1230 = var2;
      World.field1229 = var3;
      WorldMapType1.method308(World.worldList, 0, World.worldList.length - 1, World.field1230, World.field1229);
   }

   static void method2026(final int var0, final int var1) {
      if(class189.loadWidget(var0)) {
         class236.method4345(MouseRecorder.widgets[var0], var1);
      }
   }
}
