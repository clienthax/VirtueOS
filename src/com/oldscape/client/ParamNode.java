package com.oldscape.client;

public class ParamNode extends CacheableNode {
   public static IndexDataBase param_ref;
   static final NodeCache paramCache;
   static int field3551;
   private char paramType;
   public int intObj;
   public String stringObj;
   boolean field3550;

   static {
      paramCache = new NodeCache(64);
   }

   ParamNode() {
      this.field3550 = true;
   }

    public static ParamNode method4877(final int var0) {
       ParamNode var1 = (ParamNode) paramCache.get(var0);
        if (var1 == null) {
            final byte[] var2 = param_ref.getConfigData(11, var0);
            var1 = new ParamNode();
            if (var2 != null) {
                var1.read(new Buffer(var2));
            }

            var1.method4900();
            paramCache.put(var1, var0);
        }
        return var1;
    }

    void method4900() {
   }

   //Read params
   void read(final Buffer buffer) {
      while(true) {
         final int opcode = buffer.readUnsignedByte();
         if(opcode == 0) {
            /**
             * d 1539 true null
             * i 52 true null
             */
            System.out.println("ParamNode "+this.paramType +" "+this.intObj +" "+this.field3550+" "+this.stringObj);
            return;
         }

         this.readNext(buffer, opcode);
      }
   }

   //Something todo with the world map (atleast it reads on the world map load)
   private void readNext(final Buffer buffer, final int opcode) {
      if(opcode == 1) {
         final byte var4 = buffer.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class314.cp1252AsciiExtension[var5 - 128];
            if(var6 == 0) {
               var6 = '?';
            }

            var5 = var6;
         }

          this.paramType = (char)var5;
      } else if(opcode == 2) {
         this.intObj = buffer.readInt();
      } else if(opcode == 4) {
         this.field3550 = false;//Something to do with members items?
      } else if(opcode == 5) {
         this.stringObj = buffer.readString();//Some kind of object / item / npc defination depending on script being run?
      }
   }

   public boolean isStringParam() {
      return this.paramType == 's';
   }

   static void queueAnimationSound(final Sequence sequence, final int var1, final int var2, final int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field951 != 0) {
         if(sequence.field3759 != null && var1 < sequence.field3759.length) {
            final int var4 = sequence.field3759[var1];
            if(var4 != 0) {
               final int soundEffectId = var4 >> 8;
               final int var6 = var4 >> 4 & 7;
               final int var7 = var4 & 15;
               Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = soundEffectId;
               Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var6;
               Client.audioDelays[Client.queuedSoundEffectCount] = 0;
               Client.audioEffects[Client.queuedSoundEffectCount] = null;
               final int var8 = (var2 - 64) / 128;
               final int var9 = (var3 - 64) / 128;
               Client.soundLocations[Client.queuedSoundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.queuedSoundEffectCount;
            }
         }
      }
   }
}
