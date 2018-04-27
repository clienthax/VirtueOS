package com.oldscape.client;

public class Sequence extends CacheableNode {

	static IndexDataBase seq_ref;

	static IndexDataBase skel_ref;

	static IndexDataBase skin_ref;

	static NodeCache sequences;

	static NodeCache skeletons;

	public int[] frameIDs;

	int[] field3758;

	public int[] frameLengths;

	public int[] field3759;

	public int frameStep;

	int[] interleaveLeave;

	public boolean stretches;

	public int forcedPriority;

	public int leftHandItem;

	public int rightHandItem;

	public int maxLoops;

	public int precedenceAnimating;

	public int priority;

	public int replyMode;

	static {
		sequences = new NodeCache(64);
		skeletons = new NodeCache(100);
	}

	Sequence() {
		this.frameStep = -1;
		this.stretches = false;
		this.forcedPriority = 5;
		this.leftHandItem = -1;
		this.rightHandItem = -1;
		this.maxLoops = 99;
		this.precedenceAnimating = -1;
		this.priority = -1;
		this.replyMode = 2;
	}

	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.readNext(var1, var2);
		}
	}

	void readNext(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.readUnsignedShort();
			this.frameLengths = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameLengths[var4] = var1.readUnsignedShort();
			}

			this.frameIDs = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIDs[var4] = var1.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIDs[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 2) {
			this.frameStep = var1.readUnsignedShort();
		} else if (var2 == 3) {
			var3 = var1.readUnsignedByte();
			this.interleaveLeave = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.interleaveLeave[var4] = var1.readUnsignedByte();
			}

			this.interleaveLeave[var3] = 9999999;
		} else if (var2 == 4) {
			this.stretches = true;
		} else if (var2 == 5) {
			this.forcedPriority = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.leftHandItem = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.rightHandItem = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.maxLoops = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.precedenceAnimating = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.priority = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.replyMode = var1.readUnsignedByte();
		} else if (var2 == 12) {
			var3 = var1.readUnsignedByte();
			this.field3758 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3758[var4] = var1.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3758[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 13) {
			var3 = var1.readUnsignedByte();
			this.field3759 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3759[var4] = var1.read24BitInt();
			}
		}

	}

	void post() {
		if (this.precedenceAnimating == -1) {
			if (this.interleaveLeave != null) {
				this.precedenceAnimating = 2;
			} else {
				this.precedenceAnimating = 0;
			}
		}

		if (this.priority == -1) {
			if (this.interleaveLeave != null) {
				this.priority = 2;
			} else {
				this.priority = 0;
			}
		}

	}

	public Model transformActorModel(Model var1, int var2) {
		var2 = this.frameIDs[var2];
		Frames var3 = Item.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedModel(true);
		} else {
			Model var4 = var1.toSharedModel(!var3.method3063(var2));
			var4.method2695(var3, var2);
			return var4;
		}
	}

	Model transformObjectModel(Model var1, int var2, int var3) {
		var2 = this.frameIDs[var2];
		Frames var4 = Item.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var4 == null) {
			return var1.toSharedModel(true);
		} else {
			Model var5 = var1.toSharedModel(!var4.method3063(var2));
			var3 &= 3;
			if (var3 == 1) {
				var5.rotateY270Ccw();
			} else if (var3 == 2) {
				var5.rotateY180Ccw();
			} else if (var3 == 3) {
				var5.rotateY90Ccw();
			}

			var5.method2695(var4, var2);
			if (var3 == 1) {
				var5.rotateY90Ccw();
			} else if (var3 == 2) {
				var5.rotateY180Ccw();
			} else if (var3 == 3) {
				var5.rotateY270Ccw();
			}

			return var5;
		}
	}

	Model transformSpotAnimModel(Model var1, int var2) {
		var2 = this.frameIDs[var2];
		Frames var3 = Item.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSpotAnimModel(true);
		} else {
			Model var4 = var1.toSharedSpotAnimModel(!var3.method3063(var2));
			var4.method2695(var3, var2);
			return var4;
		}
	}

	public Model applyTransformations(Model var1, int var2, Sequence var3, int var4) {
		var2 = this.frameIDs[var2];
		Frames var5 = Item.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIDs[var4];
			Frames var6 = Item.getFrames(var4 >> 16);
			var4 &= 65535;
			Model var7;
			if (var6 == null) {
				var7 = var1.toSharedModel(!var5.method3063(var2));
				var7.method2695(var5, var2);
				return var7;
			} else {
				var7 = var1.toSharedModel(!var5.method3063(var2) & !var6.method3063(var4));
				var7.method2745(var5, var2, var6, var4, this.interleaveLeave);
				return var7;
			}
		}
	}

	public Model method5180(Model var1, int var2) {
		int var3 = this.frameIDs[var2];
		Frames var4 = Item.getFrames(var3 >> 16);
		var3 &= 65535;
		if (var4 == null) {
			return var1.toSharedModel(true);
		} else {
			Frames var5 = null;
			int var6 = 0;
			if (this.field3758 != null && var2 < this.field3758.length) {
				var6 = this.field3758[var2];
				var5 = Item.getFrames(var6 >> 16);
				var6 &= 65535;
			}

			Model var7;
			if (var5 != null && var6 != 65535) {
				var7 = var1.toSharedModel(!var4.method3063(var3) & !var5.method3063(var6));
				var7.method2695(var4, var3);
				var7.method2695(var5, var6);
				return var7;
			} else {
				var7 = var1.toSharedModel(!var4.method3063(var3));
				var7.method2695(var4, var3);
				return var7;
			}
		}
	}
}
