/**
* Copyright (c) Kyle Fricilone
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.tool.cache.type.items;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.oldscape.tool.cache.Archive;
import com.oldscape.tool.cache.Cache;
import com.oldscape.tool.cache.Constants;
import com.oldscape.tool.cache.ReferenceTable;
import com.oldscape.tool.cache.ReferenceTable.ChildEntry;
import com.oldscape.tool.cache.ReferenceTable.Entry;
import com.oldscape.tool.cache.type.CacheIndex;
import com.oldscape.tool.cache.type.ConfigArchive;
import com.oldscape.tool.cache.type.TypeList;
import com.oldscape.tool.cache.type.TypePrinter;
import com.oldscape.tool.util.Preconditions;

/**
 * @author Kyle Friz
 * 
 * @since May 27, 2015
 */
public class ItemTypeList implements TypeList<ItemType> {

	private ItemType[] items;

	private Logger logger = Logger.getLogger(ItemTypeList.class.getName());

	@Override
	public void initialize(Cache cache) {
		int count = 0;
		try {
			ReferenceTable table = cache.getReferenceTable(CacheIndex.CONFIGS);
			Entry entry = table.getEntry(ConfigArchive.ITEM);
			Archive archive = Archive.decode(cache.read(CacheIndex.CONFIGS, ConfigArchive.ITEM).getData(),
					entry.size());

			items = new ItemType[entry.capacity()];
			for (int id = 0; id < entry.capacity(); id++) {
				ChildEntry child = entry.getEntry(id);
				if (child == null)
					continue;

				ByteBuffer buffer = archive.getEntry(child.index());
				ItemType type = new ItemType(id);
				type.decode(buffer);
				items[id] = type;
				count++;
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error Loading ItemType(s)!", e);
		}
		logger.info("Loaded " + count + " ItemType(s)!");
	}

	@Override
	public ItemType list(int id) {
		Preconditions.checkArgument(id >= 0, "ID can't be negative!");
		Preconditions.checkArgument(id < items.length, "ID can't be greater than the max item id!");
		return items[id];
	}

	@Override
	public void print() {
	      
	      File dir = new File(Constants.TYPE_PATH);

	      if (!dir.exists()) {
	            dir.mkdir();
	      }
	      
		File file = new File(Constants.TYPE_PATH, "items.txt");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			Arrays.stream(items).filter(Objects::nonNull).forEach((ItemType t) -> {
				TypePrinter.print(t, writer);
			});
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int size() {
		return items.length;
	}

}
