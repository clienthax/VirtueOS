package com.oldscape.client;

public class NPCComposition extends CacheableNode {
   public static IndexDataBase NpcDefinition_indexCache;
   public static IndexDataBase NpcDefinition_modelIndexCache;
   static final NodeCache npcs;
   static final NodeCache npcModelCache;
   public int id;
   public String name;
   public int size;
   private int[] models;
   private int[] additionalModels;
   public int standingAnimation;
   public int field3716;
   public int field3714;
   public int walkingAnimation;
   public int rotate180Animation;
   public int rotate90RightAnimation;
   public int rotate90LeftAnimation;
   private short[] colors;
   private short[] modifiedColors;
   private short[] textureToReplace;
   private short[] textureToReplaceWith;
   public String[] actions;
   public boolean isMinimapVisible;
   public int combatLevel;
   private int widthScale;
   private int heightScale;
   public boolean isVisible;
   private int ambient;
   private int contrast;
   public int headIcon;
   public int rotation;
   public int[] configs;
   private int varpIndex;
   private int varp32Index;
   public boolean field3724;
   public boolean isClickable;
   public boolean field3738;
   private IterableHashTable params;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.size = 1;
      this.standingAnimation = -1;
      this.field3716 = -1;
      this.field3714 = -1;
      this.walkingAnimation = -1;
      this.rotate180Animation = -1;
      this.rotate90RightAnimation = -1;
      this.rotate90LeftAnimation = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.ambient = 0;
      this.contrast = 0;
      this.headIcon = -1;
      this.rotation = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3724 = true;
      this.isClickable = true;
      this.field3738 = false;
   }

    public static NPCComposition getNpcDefinition(final int var0) {
       NPCComposition var1 = (NPCComposition) npcs.get(var0);
        if (var1 == null) {
            final byte[] var2 = NpcDefinition_indexCache.getConfigData(9, var0);
            var1 = new NPCComposition();
            var1.id = var0;
            if (var2 != null) {
                var1.decode(new Buffer(var2));
            }

            var1.post();
            npcs.put(var1, var0);
        }
        return var1;
    }

    void post() {
   }

   void decode(final Buffer var1) {
      while(true) {
         final int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   private void readNext(final Buffer var1, final int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 12) {
         this.size = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.standingAnimation = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.walkingAnimation = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3716 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3714 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.walkingAnimation = var1.readUnsignedShort();
         this.rotate180Animation = var1.readUnsignedShort();
         this.rotate90RightAnimation = var1.readUnsignedShort();
         this.rotate90LeftAnimation = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.colors = new short[var3];
         this.modifiedColors = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.colors[var4] = (short)var1.readUnsignedShort();
            this.modifiedColors[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.textureToReplace = new short[var3];
         this.textureToReplaceWith = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.textureToReplace[var4] = (short)var1.readUnsignedShort();
            this.textureToReplaceWith[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.additionalModels = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.additionalModels[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.ambient = var1.readByte();
      } else if(var2 == 101) {
         this.contrast = var1.readByte();
      } else if(var2 == 102) {
         this.headIcon = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.rotation = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3724 = false;//hasactions ?
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3738 = true;
         } else if(var2 == 249) {
            this.params = WorldMapDecorationInfo.readStringIntParameters(var1, this.params);
         }
      } else {
         this.varpIndex = var1.readUnsignedShort();
         if(this.varpIndex == 65535) {
            this.varpIndex = -1;
         }

         this.varp32Index = var1.readUnsignedShort();
         if(this.varp32Index == 65535) {
            this.varp32Index = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == 65535) {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }

   public final Model getModel(final Sequence action, final int actionFrame, final Sequence pose, final int poseFrame) {
      if(this.configs != null) {
         final NPCComposition npcComposition = this.transform();
         return npcComposition == null?null:npcComposition.getModel(action, actionFrame, pose, poseFrame);
      } else {
         Model model = (Model)npcModelCache.get(this.id);
         if(model == null) {
            boolean var6 = false;

             for (final int modelID : this.models) {
                 if (!NpcDefinition_modelIndexCache.tryLoadRecord(modelID, 0)) {
                     var6 = true;
                 }
             }

            if(var6) {
               return null;
            }

            final ModelData[] modelDatas = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               modelDatas[var9] = ModelData.method2645(NpcDefinition_modelIndexCache, this.models[var9], 0);
            }

            final ModelData modelData;
            if(modelDatas.length == 1) {
               modelData = modelDatas[0];
            } else {
               modelData = new ModelData(modelDatas, modelDatas.length);
            }

            if(this.colors != null) {
               for(var9 = 0; var9 < this.colors.length; ++var9) {
                  modelData.recolor(this.colors[var9], this.modifiedColors[var9]);
               }
            }

            if(this.textureToReplace != null) {
               for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
                  modelData.method2613(this.textureToReplace[var9], this.textureToReplaceWith[var9]);
               }
            }

            model = modelData.light(this.ambient + 64, this.contrast * 5 + 850, -30, -50, -30);
            npcModelCache.put(model, this.id);
         }

         final Model var10;
         if(action != null && pose != null) {
            var10 = action.applyTransformations(model, actionFrame, pose, poseFrame);
         } else if(action != null) {
            var10 = action.transformActorModel(model, actionFrame);
         } else if(pose != null) {
            var10 = pose.transformActorModel(model, poseFrame);
         } else {
            var10 = model.toSharedModel(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   public final ModelData method5148() {
      if(this.configs != null) {
         final NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method5148();
      } else if(this.additionalModels == null) {
         return null;
      } else {
         boolean var5 = false;

          for (final int additionalModel : this.additionalModels) {
              if (!NpcDefinition_modelIndexCache.tryLoadRecord(additionalModel, 0)) {
                  var5 = true;
              }
          }

         if(var5) {
            return null;
         } else {
            final ModelData[] var6 = new ModelData[this.additionalModels.length];

            for(int var3 = 0; var3 < this.additionalModels.length; ++var3) {
               var6[var3] = ModelData.method2645(NpcDefinition_modelIndexCache, this.additionalModels[var3], 0);
            }

            final ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.colors != null) {
               for(var4 = 0; var4 < this.colors.length; ++var4) {
                  var7.recolor(this.colors[var4], this.modifiedColors[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var7.method2613(this.textureToReplace[var4], this.textureToReplaceWith[var4]);
               }
            }

            return var7;
         }
      }
   }

   public final NPCComposition transform() {
      int varp = -1;
      if(this.varpIndex != -1) {
         varp = Varbit.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         varp = VarpStorage.clientVarps[this.varp32Index];
      }

      final int id;
      if(varp >= 0 && varp < this.configs.length - 1) {
         id = this.configs[varp];
      } else {
         id = this.configs[this.configs.length - 1];
      }

      return id != -1?getNpcDefinition(id):null;
   }

   public boolean method5123() {
      if(this.configs == null) {
         return true;
      } else {
         int varp = -1;
         if(this.varpIndex != -1) {
            varp = Varbit.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            varp = VarpStorage.clientVarps[this.varp32Index];
         }

         return varp >= 0 && varp < this.configs.length?this.configs[varp] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   public int method5124(final int var1, final int var2) {
      final IterableHashTable var4 = this.params;
      final int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         final IntegerNode var5 = (IntegerNode)var4.get(var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.value;
         }
      }

      return var3;
   }

   public String method5125(final int var1, final String var2) {
      return WorldMapType1.method309(this.params, var1, var2);
   }
}
