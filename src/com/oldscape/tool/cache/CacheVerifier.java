package com.oldscape.tool.cache;

import com.oldscape.shared.cache.Cache;
import com.oldscape.shared.cache.Constants;
import com.oldscape.shared.cache.FileStore;
import com.oldscape.shared.cache.ReferenceTable;
import com.oldscape.shared.cache.ReferenceTable.Entry;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;

public final class CacheVerifier {

    public static void main(String[] args) throws IOException {
        try (Cache cache = new Cache(FileStore.open(Constants.CACHE_PATH))) {
            for (int type = 0; type < cache.getFileCount(255); type++) {
                ReferenceTable table = cache.getReferenceTable(type);
                for (int file = 0; file < table.capacity(); file++) {
                    Entry entry = table.getEntry(file);
                    if (entry == null)
                        continue;

                    ByteBuffer buffer;
                    try {
                        buffer = cache.getStore().read(type, file);
                    } catch (IOException ex) {
                        System.out.println(type + ":" + file + " error");
                        continue;
                    }

                    if (buffer.capacity() <= 2) {
                        System.out.println(type + ":" + file + " missing");
                        continue;
                    }

                    /* last two bytes are the version and shouldn't be included */
                    byte[] bytes = new byte[buffer.limit() - 2];
                    buffer.position(0);
                    buffer.get(bytes, 0, bytes.length);

                    CRC32 crc = new CRC32();
                    crc.update(bytes, 0, bytes.length);

                    if ((int) crc.getValue() != entry.getCrc()) {
                        System.out.println(type + ":" + file + " corrupt");
                    }

                    buffer.position(buffer.limit() - 2);
                    if ((buffer.getShort() & 0xFFFF) != entry.getVersion()) {
                        System.out.println(type + ":" + file + " out of date");
                    }
                }
            }
        }
    }

}