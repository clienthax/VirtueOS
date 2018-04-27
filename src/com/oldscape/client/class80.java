package com.oldscape.client;

public final class class80 extends Node {
   static Deque field1263;
   int field1259;
   int field1265;
   int field1261;
   int field1269;
   int field1262;
   int field1273;
   int field1264;
   class115 field1266;
   int field1267;
   int field1268;
   int[] field1274;
   int field1270;
   class115 field1271;
   ObjectComposition field1272;

   static {
      field1263 = new Deque();
   }

   void method1794() {
      int var1 = this.field1264;
      ObjectComposition var2 = this.field1272.getImpostor();
      if(var2 != null) {
         this.field1264 = var2.ambientSoundId;
         this.field1273 = var2.int4 * 128;
         this.field1267 = var2.int5;
         this.field1268 = var2.int6;
         this.field1274 = var2.field3614;
      } else {
         this.field1264 = -1;
         this.field1273 = 0;
         this.field1267 = 0;
         this.field1268 = 0;
         this.field1274 = null;
      }

      if(var1 != this.field1264 && this.field1266 != null) {
         MouseInput.field727.method2060(this.field1266);
         this.field1266 = null;
      }

   }
}
