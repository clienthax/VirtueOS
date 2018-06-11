package com.oldscape.client.reference;

public class MapCacheArchiveNames {
    public static final MapCacheArchiveNames DETAILS;
    public static final MapCacheArchiveNames COMPOSITE_MAP;
    public static final MapCacheArchiveNames COMPOSITE_TEXTURE;
    public static final MapCacheArchiveNames AREA;
    public static final MapCacheArchiveNames LABELS;
    public static BufferProvider rasterProvider;
    static IndexData vorbisIndex;

    static {
        DETAILS = new MapCacheArchiveNames("details");
        COMPOSITE_MAP = new MapCacheArchiveNames("compositemap");
        COMPOSITE_TEXTURE = new MapCacheArchiveNames("compositetexture");
        AREA = new MapCacheArchiveNames("area");
        LABELS = new MapCacheArchiveNames("labels");
    }

    public final String name;

    private MapCacheArchiveNames(final String var1) {
        this.name = var1;
    }

    static void method588() {
        for (int var0 = 0; var0 < class93.playerIndexesCount; ++var0) {
            final Player var1 = Client.cachedPlayers[class93.playerIndices[var0]];
            var1.method1191();
        }

    }
}
