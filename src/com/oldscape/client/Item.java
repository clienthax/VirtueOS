package com.oldscape.client;

public final class Item extends Renderable {

	public static int currentPressedKey;

	int id;

	int quantity;

	@Override
	protected final Model getModel() {
		return class47.getItemDefinition(this.id).getModel(this.quantity);
	}

	public static void method1951(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
		Sequence.seq_ref = var0;
		Sequence.skel_ref = var1;
		Sequence.skin_ref = var2;
	}

	static Frames getFrames(int var0) {
		Frames var1 = (Frames) Sequence.skeletons.get(var0);
		if (var1 != null) {
			return var1;
		} else {
			IndexDataBase var3 = Sequence.skel_ref;
			IndexDataBase var4 = Sequence.skin_ref;
			boolean var5 = true;
			int[] var6 = var3.getChilds(var0);

			for (int var7 = 0; var7 < var6.length; ++var7) {
				byte[] var8 = var3.getChild(var0, var6[var7]);
				if (var8 == null) {
					var5 = false;
				} else {
					int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
					byte[] var10 = var4.getChild(var9, 0);
					if (var10 == null) {
						var5 = false;
					}
				}
			}

			Frames var2;
			if (!var5) {
				var2 = null;
			} else {
				try {
					var2 = new Frames(var3, var4, var0, false);
				} catch (Exception var12) {
					var2 = null;
				}
			}

			if (var2 != null) {
				Sequence.skeletons.put(var2, var0);
			}

			return var2;
		}
	}
}
