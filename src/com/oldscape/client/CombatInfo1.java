package com.oldscape.client;

class CombatInfo1 extends Node {
   static MachineInfo platformInfo;
   int cycle;
   int healthRatio;
   int health;
   int int2;

   CombatInfo1(final int var1, final int var2, final int var3, final int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   void set(final int var1, final int var2, final int var3, final int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   public static Sequence getAnimation(final int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get(var0);
       if (var1 == null) {
           final byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
           var1 = new Sequence();
           if (var2 != null) {
               var1.decode(new Buffer(var2));
           }

           var1.post();
           Sequence.sequences.put(var1, var0);
       }
       return var1;
   }

   static void method1672() {

      for (final Object message : class95.messages) {
         final MessageNode var1 = (MessageNode) message;
         var1.method1162();
      }

   }

   public static void method1677(final int var0, final boolean var1, final int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         AbstractSoundSystem.sampleRate = var0;
         AbstractSoundSystem.audioHighMemory = var1;
         Varbit.field3538 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   static boolean method1679() {
      return Client.field1016 || KeyFocusListener.keyPressed[81];
   }
}
