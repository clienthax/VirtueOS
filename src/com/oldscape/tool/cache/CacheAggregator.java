package com.oldscape.tool.cache;

import com.oldscape.shared.cache.Cache;
import com.oldscape.shared.cache.Constants;
import com.oldscape.shared.cache.FileStore;
import com.oldscape.shared.cache.ReferenceTable;
import com.oldscape.shared.cache.ReferenceTable.Entry;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;

public final class CacheAggregator {

    public static void main(String[] args) throws IOException {
        try (Cache otherCache = new Cache(FileStore.open(Constants.CACHEO_PATH));
             Cache cache = new Cache(FileStore.open(Constants.CACHE_PATH))) {
            for (int type = 0; type < cache.getFileCount(255); type++) {
                ReferenceTable otherTable = otherCache.getReferenceTable(type);
                ReferenceTable table = cache.getReferenceTable(type);
                for (int file = 0; file < table.capacity(); file++) {
                    Entry entry = table.getEntry(file);
                    if (entry == null)
                        continue;

                    if (isRepackingRequired(cache, entry, type, file)) {
                        Entry otherEntry = otherTable.getEntry(file);
                        if (entry.getVersion() == otherEntry.getVersion() && entry.getCrc() == otherEntry.getCrc()) {
                            cache.getStore().write(type, file, otherCache.getStore().read(type, file));
                        }
                    }
                }
            }
        }
    }

    private static boolean isRepackingRequired(Cache store, Entry entry, int type, int file) {
        ByteBuffer buffer;
        try {
            buffer = store.getStore().read(type, file);
        } catch (IOException ex) {
            return true;
        }

        if (buffer.capacity() <= 2) {
            return true;
        }

        /* last two bytes are the version and shouldn't be included */
        byte[] bytes = new byte[buffer.limit() - 2];
        buffer.position(0);
        buffer.get(bytes, 0, bytes.length);

        CRC32 crc = new CRC32();
        crc.update(bytes, 0, bytes.length);

        if ((int) crc.getValue() != entry.getCrc()) {
            return true;
        }

        buffer.position(buffer.limit() - 2);
        if ((buffer.getShort() & 0xFFFF) != entry.getVersion()) {
            return true;
        }

        return false;
    }

}