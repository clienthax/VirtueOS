package com.oldscape.client;
import java.util.HashMap;
import java.util.Map;

public class class95 {

	static final Map chatLineMap;

	static final IterableHashTable messages;

	static final IterableDualNodeQueue field1453;

	static int field1452;

	static int[] field1449;

	static IndexData indexWorldMap;

	static {
		chatLineMap = new HashMap();
		messages = new IterableHashTable(1024);
		field1453 = new IterableDualNodeQueue();
		field1452 = 0;
	}

	public static Overlay getOverlayDefinition(int var0) {
		Overlay var1 = (Overlay) Overlay.overlays.get(var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = TotalQuantityComparator.overlay_ref.getConfigData(4, var0);
			var1 = new Overlay();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.post();
			Overlay.overlays.put(var1, var0);
			return var1;
		}
	}
}
