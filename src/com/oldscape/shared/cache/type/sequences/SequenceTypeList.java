/**
 * Copyright (c) Kyle Fricilone
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.shared.cache.type.sequences;

import com.oldscape.shared.cache.Archive;
import com.oldscape.shared.cache.Cache;
import com.oldscape.shared.cache.Constants;
import com.oldscape.shared.cache.ReferenceTable;
import com.oldscape.shared.cache.ReferenceTable.ChildEntry;
import com.oldscape.shared.cache.ReferenceTable.Entry;
import com.oldscape.shared.cache.type.CacheIndex;
import com.oldscape.shared.cache.type.ConfigArchive;
import com.oldscape.shared.cache.type.TypeList;
import com.oldscape.shared.cache.type.TypePrinter;
import com.oldscape.shared.utility.Preconditions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kyle Friz
 *
 * @since May 26, 2015
 */
public class SequenceTypeList implements TypeList<SequenceType> {

    private Logger logger = Logger.getLogger(SequenceTypeList.class.getName());

    private SequenceType[] seqs;

    @Override
    public void initialize(Cache cache) {
        int count = 0;
        try {
            ReferenceTable table = cache.getReferenceTable(CacheIndex.CONFIGS);
            Entry entry = table.getEntry(ConfigArchive.SEQUENCE);
            Archive archive = Archive.decode(cache.read(CacheIndex.CONFIGS, ConfigArchive.SEQUENCE).getData(),
                    entry.size());

            seqs = new SequenceType[entry.capacity()];
            for (int id = 0; id < entry.capacity(); id++) {
                ChildEntry child = entry.getEntry(id);
                if (child == null)
                    continue;

                ByteBuffer buffer = archive.getEntry(child.index());
                SequenceType type = new SequenceType(id);
                type.decode(buffer);
                seqs[id] = type;
                count++;
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error Loading SequenceType(s)!", e);
        }
        logger.info("Loaded " + count + " SequenceType(s)!");
    }

    @Override
    public SequenceType list(int id) {
        Preconditions.checkArgument(id >= 0, "ID can't be negative!");
        Preconditions.checkArgument(id < seqs.length, "ID can't be greater than the max sequence id!");
        return seqs[id];
    }

    @Override
    public void print() {
        File dir = new File(Constants.TYPE_PATH);

        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(Constants.TYPE_PATH, "sequences.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Arrays.stream(seqs).filter(Objects::nonNull).forEach((SequenceType t) -> {
                TypePrinter.print(t, writer);
            });
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return seqs.length;
    }

}
