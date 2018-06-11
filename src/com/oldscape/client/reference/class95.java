package com.oldscape.client.reference;

import java.util.HashMap;
import java.util.Map;

class class95 {
    static final Map<Integer, ChatLineBuffer> chatLineMap;
    static final IterableHashTable messages;
    static final IterableDualNodeQueue field1453;
    static int field1452;
    static int[] field1449;
    static IndexData indexWorldMap;

    static {
        chatLineMap = new HashMap<>();
        messages = new IterableHashTable(1024);
        field1453 = new IterableDualNodeQueue();
        field1452 = 0;
    }

    static Overlay getOverlayDefinition(final int overlayId) {
        Overlay overlay = (Overlay) Overlay.overlays.get(overlayId);
        if (overlay == null) {
            final byte[] configData = TotalQuantityComparator.overlay_ref.getConfigData(4, overlayId);
            overlay = new Overlay();
            if (configData != null) {
                overlay.decode(new Buffer(configData), overlayId);
            }

            overlay.post();
            Overlay.overlays.put(overlay, overlayId);
        }
        return overlay;
    }

}
