/**
 * Copyright (c) 2015 Kyle Friz & Kayla Friz
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
package com.sean.shared.model.region;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.common.primitives.Ints;
import com.sean.game.Server;
import net.openrs.cache.util.XTEAManager;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jun 30, 2015
 */
public class RegionManager {

	private final Logger logger = Logger.getLogger(RegionManager.class.getName());

	private Server server;
	private final Map<Integer, Region> regionLookup = new HashMap<Integer, Region>();

	public RegionManager(Server server) {
		this.server = server;
	}

	public void initialize() {
		try {
			XTEAManager.loadFromRuneLite();

			for (File file : new File("repository/xtea/maps/").listFiles()) {
				if (file.getName().endsWith(".txt")) {
					List<Integer> keys = new ArrayList<Integer>();
					Integer regionID = Integer.valueOf(file.getName().substring(0, file.getName().indexOf(".txt")));

//					int[] runeliteKeys = XTEAManager.lookupMap(regionID);
					Files.lines(Paths.get(".").resolve("repository/xtea/maps/" + file.getName()))
							.forEach((String line) -> {
								keys.add(Integer.valueOf(line));
							});

					int map = server.getCache().getFileId(5, "m" + (regionID >> 8) + "_" + (regionID & 0xFF));
					int land = server.getCache().getFileId(5, "l" + (regionID >> 8) + "_" + (regionID & 0xFF));
					Region region = new Region(regionID, keys);//keys

					if (map != -1) {
						region.loadTerrain(server.getCache().read(5, map).getData());
					}

					if (land != -1) {
						try {
							region.loadNodes(server.getCache().read(5, land, Ints.toArray(keys)).getData());
							/*System.out.println("Correct xtea :( Coords: (" + ((regionID >> 8)
									<< 6) + ", " + ((regionID & 0xFF) << 6) +
									"), Region ID: " + regionID);*/
						} catch (Exception e) {
							  System.out.println("Broken xtea :( Coords: (" + ((regionID >> 8)
							  << 6) + ", " + ((regionID & 0xFF) << 6) +
							  "), Region ID: " + regionID);
							  }
					}
					regionLookup.put(regionID, new Region(regionID, keys));
				}
			}
			logger.info("Loaded " + regionLookup.size() + " Region(s).");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final Region lookup(Integer id) {
		//Hax! --todo
		return regionLookup.get(id);
	}

}
