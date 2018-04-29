package com.oldscape.client;

class Enum extends CacheableNode {
   static IndexDataBase EnumDefinition_indexCache;
   static final NodeCache EnumDefinition_cached;
   char keyType;
   char valType;
   String defaultString;
   int defaultInt;
   public int size;
   int[] keys;
   int[] intVals;
   String[] stringVals;

   static {
      EnumDefinition_cached = new NodeCache(64);
   }

   Enum() {
      this.defaultString = "null";
      this.size = 0;
   }

    static void method409(final IndexDataBase var0) {
       EnumDefinition_indexCache = var0;
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

   private void readNext(final Buffer buffer, final int opcode) {
      if(opcode == 1) {
         this.keyType = (char)buffer.readUnsignedByte();
      } else if(opcode == 2) {
         this.valType = (char)buffer.readUnsignedByte();
      } else if(opcode == 3) {
         this.defaultString = buffer.readString();
      } else if(opcode == 4) {
         this.defaultInt = buffer.readInt();
      } else if(opcode == 5) {
            this.size = buffer.readUnsignedShort();
            this.keys = new int[this.size];
            this.stringVals = new String[this.size];

            for(int i = 0; i < this.size; ++i) {
               this.keys[i] = buffer.readInt();
               this.stringVals[i] = buffer.readString();
            }
      } else if(opcode == 6) {
            this.size = buffer.readUnsignedShort();
            this.keys = new int[this.size];
            this.intVals = new int[this.size];

            for(int i = 0; i < this.size; ++i) {
               this.keys[i] = buffer.readInt();
               this.intVals[i] = buffer.readInt();
            }
      }
   }

   public int method4957() {
      return this.size;
   }

   public static String method4958(final CharSequence var0) {
      return VarCInt.method4785('*', var0.length());
   }
}
