package com.oldscape.client;

class Varbit extends CacheableNode {
   public static IndexDataBase varbit_ref;
   public static final NodeCache varbits;
   static int field3538;
   static byte[][] field3544;
   public int configId;
   public int leastSignificantBit;
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   static int getVarbit(final int var0) {
      Varbit varbit = (Varbit) varbits.get(var0);
      final Varbit var1;
       if (varbit == null) {
           final byte[] defaults = varbit_ref.getConfigData(14, var0);
           varbit = new Varbit();
           if (defaults != null) {
               varbit.decode(new Buffer(defaults));
           }

           varbits.put(varbit, var0);
       }
       var1 = varbit;

       final int configId = var1.configId;
      final int leastSignificantBit = var1.leastSignificantBit;
      final int mostSignificantBit = var1.mostSignificantBit;
      final int mask = VarpStorage.varpsMasks[mostSignificantBit - leastSignificantBit];
      return VarpStorage.clientVarps[configId] >> leastSignificantBit & mask;
   }

   public void decode(final Buffer buffer) {
      while(true) {
         final int opcode = buffer.readUnsignedByte();
         if(opcode == 0) {
            return;
         }

         this.readNext(buffer, opcode);
      }
   }

   private void readNext(final Buffer var1, final int opcode) {
      if(opcode == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

}
