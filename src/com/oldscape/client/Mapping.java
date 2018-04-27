package com.oldscape.client;

public class Mapping {

	int field1664;

	int mux;

	int[] submapFloors;

	int[] field1662;

	Mapping() {
		class104.getInt(16);
		this.field1664 = class104.getBit() != 0 ? class104.getInt(4) + 1 : 1;
		if (class104.getBit() != 0) {
			class104.getInt(8);
		}

		class104.getInt(2);
		if (this.field1664 > 1) {
			this.mux = class104.getInt(4);
		}

		this.submapFloors = new int[this.field1664];
		this.field1662 = new int[this.field1664];

		for (int var1 = 0; var1 < this.field1664; ++var1) {
			class104.getInt(8);
			this.submapFloors[var1] = class104.getInt(8);
			this.field1662[var1] = class104.getInt(8);
		}

	}
}
