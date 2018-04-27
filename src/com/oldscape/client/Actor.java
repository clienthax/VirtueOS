package com.oldscape.client;

public abstract class Actor extends Renderable {
   int x;
   int y;
   int angle;
   boolean field1159;
   int field1172;
   int field1161;
   int idlePoseAnimation;
   int field1163;
   int field1164;
   int field1165;
   int field1209;
   int field1167;
   int field1177;
   int field1169;
   String overhead;
   boolean field1168;
   boolean field1157;
   int overheadTextCyclesRemaining;
   int field1174;
   int field1175;
   byte field1176;
   int[] field1180;
   int[] hitsplatTypes;
   int[] hitsplatCycles;
   int[] field1183;
   int[] field1181;
   CombatInfoList combatInfoList;
   int interacting;
   boolean field1156;
   int field1185;
   int poseAnimation;
   int poseFrame;
   int poseFrameCycle;
   int animation;
   int actionFrame;
   int actionFrameCycle;
   int actionAnimationDisable;
   int field1193;
   int graphic;
   int spotAnimFrame;
   int spotAnimFrameCycle;
   int graphicsDelay;
   int field1198;
   int field1203;
   int field1200;
   int field1199;
   int field1202;
   int field1166;
   int field1204;
   int field1171;
   int npcCycle;
   int logicalHeight;
   int orientation;
   int field1184;
   int field1205;
   int queueSize;
   int[] pathX;
   int[] pathY;
   byte[] pathTraversed;
   int field1158;
   int field1216;

   Actor() {
      this.field1159 = false;
      this.field1172 = 1;
      this.idlePoseAnimation = -1;
      this.field1163 = -1;
      this.field1164 = -1;
      this.field1165 = -1;
      this.field1209 = -1;
      this.field1167 = -1;
      this.field1177 = -1;
      this.field1169 = -1;
      this.overhead = null;
      this.field1157 = false;
      this.overheadTextCyclesRemaining = 100;
      this.field1174 = 0;
      this.field1175 = 0;
      this.field1176 = 0;
      this.field1180 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1183 = new int[4];
      this.field1181 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1156 = false;
      this.field1185 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.poseFrameCycle = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.actionFrameCycle = 0;
      this.actionAnimationDisable = 0;
      this.field1193 = 0;
      this.graphic = -1;
      this.spotAnimFrame = 0;
      this.spotAnimFrameCycle = 0;
      this.npcCycle = 0;
      this.logicalHeight = 200;
      this.field1184 = 0;
      this.field1205 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.field1158 = 0;
      this.field1216 = 0;
   }

   boolean hasConfig() {
      return false;
   }

   final void method1655() {
      this.queueSize = 0;
      this.field1216 = 0;
   }

   final void method1657(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.hitsplatCycles[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class281 var12 = Huffman.method3457(var1);
         var10 = var12.field3588;
         var11 = var12.field3575;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.hitsplatCycles[0];
         } else if(var10 == 1) {
            var14 = this.hitsplatTypes[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.hitsplatCycles[var13] < var14) {
                  var9 = var13;
                  var14 = this.hitsplatCycles[var13];
               }
            } else if(var10 == 1 && this.hitsplatTypes[var13] < var14) {
               var9 = var13;
               var14 = this.hitsplatTypes[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field1176 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1176;
            this.field1176 = (byte)((this.field1176 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1180[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1183[var9] = var3;
         this.field1181[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   final void setCombatInfo(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3524.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3532.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.read(new Buffer(var9));
         }

         CombatInfo2.field3524.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3529;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.last(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         ++var12;
         if(var13.combatInfo2.field3526 == var8.field3526) {
            var13.method1859(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3536 <= var8.field3536) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3529 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3529;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.addLast(var13);
         } else {
            CombatInfoList.method3987(var13, var14);
         }

         var13.method1859(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   final void method1659(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3524.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3532.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.read(new Buffer(var4));
         }

         CombatInfo2.field3524.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.last(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
