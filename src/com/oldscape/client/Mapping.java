package com.oldscape.client;

class Mapping {
   final int field1664;
   int mux;
   final int[] submapFloors;
   final int[] field1662;

   Mapping() {
      Instrument.getInt(16);
      this.field1664 = Instrument.getBit() != 0?Instrument.getInt(4) + 1:1;
      if(Instrument.getBit() != 0) {
         Instrument.getInt(8);
      }

      Instrument.getInt(2);
      if(this.field1664 > 1) {
         this.mux = Instrument.getInt(4);
      }

      this.submapFloors = new int[this.field1664];
      this.field1662 = new int[this.field1664];

      for(int var1 = 0; var1 < this.field1664; ++var1) {
         Instrument.getInt(8);
         this.submapFloors[var1] = Instrument.getInt(8);
         this.field1662[var1] = Instrument.getInt(8);
      }

   }
}
