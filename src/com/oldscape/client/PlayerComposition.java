package com.oldscape.client;

class PlayerComposition {
   public static short[] colorsToFind;
   public static short[][] colorsToReplace;
   private static final int[] field2796;
   static final NodeCache field2797;
   public static short[] colorsToFind2;
   public static short[][] colorsToReplace2;
   static boolean gameFocused;
   private int[] equipmentIds;
   private int[] bodyPartColours;
   public boolean isFemale;
   public int transformedNpcId;
   private long hash;
   private long field2793;

   static {
      field2796 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2797 = new NodeCache(260);
   }

   public void method4396(int[] var1, final int[] var2, final boolean var3, final int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3519; ++var6) {
               final KitDefinition var7 = IndexFile.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == (var3?7:0) + var5) {
                  var1[field2796[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.transformedNpcId = var4;
      this.setHash();
   }

   public void method4379(final int var1, final boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2796[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3519 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3519) {
                     var3 = 0;
                  }
               }

               var4 = IndexFile.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || (this.isFemale?7:0) + var1 != var4.bodyPartId);

            this.equipmentIds[field2796[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   public void method4406(final int var1, final boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = colorsToReplace[var1].length - 1;
            }

            var4 = var1 != 4 || var3 < 8;
         } while(!var4);
      } else {
         do {
            ++var3;
            if(var3 >= colorsToReplace[var1].length) {
               var3 = 0;
            }

             var4 = var1 != 4 || var3 < 8;
         } while(!var4);
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   public void method4386(final boolean var1) {
      if(this.isFemale != var1) {
         this.method4396(null, this.bodyPartColours, var1, -1);
      }
   }

   public void method4398(final Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         final int var3 = this.equipmentIds[field2796[var2]];
         if(var3 == 0) {
            var1.putByte(-1);
         } else {
            var1.putByte(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.putByte(this.bodyPartColours[var2]);
      }

   }

   private void setHash() {
      final long var1 = this.hash;
      final int var3 = this.equipmentIds[5];
      final int var4 = this.equipmentIds[9];
      this.equipmentIds[5] = var4;
      this.equipmentIds[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if(this.equipmentIds[var5] >= 256) {
            this.hash += (this.equipmentIds[var5] - 256);
         }
      }

      if(this.equipmentIds[0] >= 256) {
         this.hash += (this.equipmentIds[0] - 256 >> 4);
      }

      if(this.equipmentIds[1] >= 256) {
         this.hash += (this.equipmentIds[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += this.bodyPartColours[var5];
      }

      this.hash <<= 1;
      this.hash += (this.isFemale?1:0);
      this.equipmentIds[5] = var3;
      this.equipmentIds[9] = var4;
      if(var1 != 0L && this.hash != var1) {
         field2797.remove(var1);
      }

   }

   public Model getModel(final Sequence var1, final int var2, final Sequence var3, final int var4) {
      if(this.transformedNpcId != -1) {
         return NPCComposition.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if((var1 != null) && ((var1.leftHandItem >= 0) || (var1.rightHandItem >= 0))) {
            var7 = new int[12];

             System.arraycopy(this.equipmentIds, 0, var7, 0, 12);

            if(var1.leftHandItem >= 0) {
               var5 += (var1.leftHandItem - this.equipmentIds[5] << 40);
               var7[5] = var1.leftHandItem;
            }

            if(var1.rightHandItem >= 0) {
               var5 += (var1.rightHandItem - this.equipmentIds[3] << 48);
               var7[3] = var1.rightHandItem;
            }
         }

         Model var8 = (Model)field2797.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if((var11 >= 256) && (var11 < 512) && !IndexFile.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if((var11 >= 512) && !ItemComposition.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2793) {
                  var8 = (Model)field2797.get(this.field2793);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               final ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = IndexFile.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = ItemComposition.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               final ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < colorsToReplace[var13].length) {
                     var18.recolor(colorsToFind[var13], colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < colorsToReplace2[var13].length) {
                     var18.recolor(colorsToFind2[var13], colorsToReplace2[var13][this.bodyPartColours[var13]]);
                  }
               }

               var8 = var18.light(64, 850, -30, -50, -30);
               field2797.put(var8, var5);
               this.field2793 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            final Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.applyTransformations(var8, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.transformActorModel(var8, var2);
            } else {
               var17 = var3.transformActorModel(var8, var4);
            }

            return var17;
         }
      }
   }

   ModelData method4384() {
      if(this.transformedNpcId != -1) {
         return NPCComposition.getNpcDefinition(this.transformedNpcId).method5148();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !IndexFile.getKitDefinition(var3 - 256).method4839()) {
               var1 = true;
            }

            if(var3 >= 512 && !ItemComposition.getItemDefinition(var3 - 512).method5066(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            final ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipmentIds[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = IndexFile.getKitDefinition(var5 - 256).method4837();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = ItemComposition.getItemDefinition(var5 - 512).method5062(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            final ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < colorsToReplace[var5].length) {
                  var8.recolor(colorsToFind[var5], colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < colorsToReplace2[var5].length) {
                  var8.recolor(colorsToFind2[var5], colorsToReplace2[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   public int method4385() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + NPCComposition.getNpcDefinition(this.transformedNpcId).id;
   }

   static String method4408(final int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}
