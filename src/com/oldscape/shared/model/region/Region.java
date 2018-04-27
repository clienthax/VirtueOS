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
package com.oldscape.shared.model.region;

import java.nio.ByteBuffer;
import java.util.List;

import com.oldscape.shared.model.Position;
import com.oldscape.shared.utility.BufferUtils;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jun 30, 2015
 */
public class Region {

	/**
	 * A bit flag that indicates that the tile at the current Position is blocked.
	 */
	private static final int BLOCKED_TILE = 1;

	/**
	 * A bit flag that indicates that the tile at the current Position is a bridge
	 * tile.
	 */
	private static final int BRIDGE_TILE = 2;

	private final int regionID;
	private final List<Integer> keys;
	private final CollisionMatrix[] matrices;

	public Region(int id, List<Integer> keys) {
		this.regionID = id;
		this.keys = keys;
		this.matrices = CollisionMatrix.createMatrices(4, 8, 8);
	}

	/**
	 * Decodes terrain data stored in the specified {@link ByteBuffer}.
	 *
	 * @param buffer
	 *            The ByteBuffer.
	 */
	public void loadTerrain(ByteBuffer buf) {
		for (int height = 0; height < 4; height++) {
			for (int localX = 0; localX < 64; localX++) {
				for (int localY = 0; localY < 64; localY++) {
					int attributes = 0;

					while (true) {
						int attributeId = buf.get() & 0xFF;

						if (attributeId == 0) {
							decodeAttributes(attributes, ((regionID >> 8 & 0xFF) * 64) + localX,
									((regionID & 0xFF) * 64) + localY, height);
							break;
						} else if (attributeId == 1) {
							buf.get();
							decodeAttributes(attributes, ((regionID >> 8 & 0xFF) * 64) + localX,
									((regionID & 0xFF) * 64) + localY, height);
							break;
						} else if (attributeId <= 49) {
							buf.get();
						} else if (attributeId <= 81) {
							attributes = attributeId - 49;
						}
					}
				}
			}
		}
	}

	/**
	 * Decodes object data stored in the specified {@link ByteBuffer}.
	 *
	 * @param buffer
	 *            The ByteBuffer.
	 */
	@SuppressWarnings("unused")
	public void loadNodes(ByteBuffer buffer) {
		int id = -1;
		int idOffset = BufferUtils.getUnsignedSmart(buffer);

		while (idOffset != 0) {
			id += idOffset;

			int packed = 0;
			int positionOffset = BufferUtils.getUnsignedSmart(buffer);

			while (positionOffset != 0) {
				packed += positionOffset - 1;

				int localY = packed & 0x3F;
				int localX = packed >> 6 & 0x3F;
				int height = packed >> 12 & 0x3;

				int attributes = buffer.get() & 0xFF;
				int type = attributes >> 2;
				int orientation = attributes & 0x3;
				Position position = new Position(((regionID >> 8 & 0xFF) * 64) + localX,
						((regionID & 0xFF) * 64) + localY, height);

				// GameObject object = new StaticGameObject(world, id, position,
				// type, orientation);
				// objects.add(object);

				// block(object, position);
				positionOffset = BufferUtils.getUnsignedSmart(buffer);
			}

			idOffset = BufferUtils.getUnsignedSmart(buffer);
		}
	}

	/**
	 * Decodes the attributes of a terrain file, blocking the tile if necessary.
	 *
	 * @param attributes
	 *            The terrain attributes.
	 * @param x
	 *            The x coordinate of the tile the attributes belong to.
	 * @param y
	 *            The y coordinate of the tile the attributes belong to.
	 * @param height
	 *            The level level of the tile the attributes belong to.
	 */
	private void decodeAttributes(int attributes, int x, int y, int height) {
		boolean block = false;
		if ((attributes & BLOCKED_TILE) != 0) {
			block = true;
		}

		if ((attributes & BRIDGE_TILE) != 0) {
			if (height > 0) {
				block = true;
				height--;
			}
		}

		if (block) {
			int localX = x % 8, localY = y % 8;
			matrices[height].block(localX, localY);
		}
	}

	/**
	 * @param height
	 *            the Height Level
	 * @return the Matrix
	 */
	public CollisionMatrix getMatrix(int height) {
		return matrices[height];
	}

	/**
	 * @return the regionID
	 */
	public final int getRegionID() {
		return regionID;
	}

	/**
	 * @return the keys
	 */
	public final List<Integer> getKeys() {
		return keys;
	}
}
