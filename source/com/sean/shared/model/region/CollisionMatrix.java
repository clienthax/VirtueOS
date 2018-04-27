/**
 * Copyright (c) 2015 Kyle Friz
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

import java.util.Arrays;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.sean.game.model.sync.reference.Direction;
import com.sean.shared.model.EntityType;

/**
 * A 2-dimensional adjacency matrix containing tile collision data.
 *
 * @author Major
 */
public final class CollisionMatrix {

	/**
	 * Indicates that all types of traversal are allowed.
	 */
	private static final byte ALL_ALLOWED = 0b0000_0000;

	/**
	 * Indicates that no types of traversal are allowed.
	 */
	private static final byte ALL_BLOCKED = (byte) 0b1111_1111;

	/**
	 * Creates an array of CollisionMatrix objects, all of the specified width and length.
	 *
	 * @param count The length of the array to create.
	 * @param width The width of each CollisionMatrix.
	 * @param length The length of each CollisionMatrix.
	 * @return The array of CollisionMatrix objects.
	 */
	public static CollisionMatrix[] createMatrices(int count, int width, int length) {
		CollisionMatrix[] matrices = new CollisionMatrix[count];
		Arrays.setAll(matrices, index -> new CollisionMatrix(width, length));
		return matrices;
	}

	/**
	 * The length of the matrix.
	 */
	private final int length;

	/**
	 * The collision matrix, as a {@code byte} array.
	 */
	private final byte[] matrix;

	/**
	 * The width of the matrix.
	 */
	private final int width;

	/**
	 * Creates the CollisionMatrix.
	 *
	 * @param width The width of the matrix.
	 * @param length The length of the matrix.
	 */
	public CollisionMatrix(int width, int length) {
		this.width = width;
		this.length = length;
		matrix = new byte[width * length];
	}

	/**
	 * Returns whether or not <strong>all</strong> of the specified {@link CollisionFlag}s are set for the specified
	 * coordinate pair.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param flags The CollisionFlags.
	 * @return {@code true} iff all of the CollisionFlags are set.
	 */
	public boolean all(int x, int y, CollisionFlag... flags) {
		for (CollisionFlag flag : flags) {
			if (!flagged(x, y, flag)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns whether or not <strong>any</strong> of the specified {@link CollisionFlag}s are set for the specified
	 * coordinate pair.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param flags The CollisionFlags.
	 * @return {@code true} iff any of the CollisionFlags are set.
	 */
	public boolean any(int x, int y, CollisionFlag... flags) {
		for (CollisionFlag flag : flags) {
			if (flagged(x, y, flag)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Completely blocks the tile at the specified coordinate pair.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 */
	public void block(int x, int y) {
		set(x, y, ALL_BLOCKED);
	}

	/**
	 * Clears (i.e. sets to {@code false}) the value of the specified {@link CollisionFlag} for the specified
	 * coordinate pair.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param flag The CollisionFlag.
	 */
	public void clear(int x, int y, CollisionFlag flag) {
		set(x, y, (byte) ~flag.asByte());
	}

	/**
	 * Returns whether or not the specified {@link CollisionFlag} is set for the specified coordinate pair.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param flag The CollisionFlag.
	 * @return {@code true} iff the CollisionFlag is set.
	 */
	public boolean flagged(int x, int y, CollisionFlag flag) {
		return (get(x, y) & flag.asByte()) != 0;
	}

	/**
	 * Gets the value of the specified tile.
	 *
	 * @param x The x coordinate of the tile.
	 * @param y The y coordinate of the tile.
	 * @return The value.
	 */
	public int get(int x, int y) {
		return matrix[indexOf(x, y)] & 0xFF;
	}

	/**
	 * Resets the cell of the specified coordinate pair.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 */
	public void reset(int x, int y) {
		set(x, y, ALL_ALLOWED);
	}

	/**
	 * Sets (i.e. sets to {@code true}) the value of the specified {@link CollisionFlag} for the specified coordinate
	 * pair.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param flag The CollisionFlag.
	 */
	public void set(int x, int y, CollisionFlag flag) {
		set(x, y, flag.asByte());
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("width", width).add("length", length)
				.add("matrix", Arrays.toString(matrix)).toString();
	}

	/**
	 * Returns whether or not an Entity of the specified {@link EntityType type} cannot traverse the tile at the
	 * specified coordinate pair.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param entity The {@link EntityType}.
	 * @param direction The {@link Direction} the Entity is approaching from.
	 * @return {@code true} iff the tile at the specified coordinate pair is not traversable.
	 */
	public boolean untraversable(int x, int y, EntityType entity, Direction direction) {
		CollisionFlag[] flags = CollisionFlag.forType(entity);
		int north = 0, east = 1, south = 2, west = 3;

		switch (direction) {
			case NORTH_WEST:
				return flagged(x, y, flags[south]) || flagged(x, y, flags[east]);
			case NORTH:
				return flagged(x, y, flags[south]);
			case NORTH_EAST:
				return flagged(x, y, flags[south]) || flagged(x, y, flags[west]);
			case EAST:
				return flagged(x, y, flags[west]);
			case SOUTH_EAST:
				return flagged(x, y, flags[north]) || flagged(x, y, flags[west]);
			case SOUTH:
				return flagged(x, y, flags[north]);
			case SOUTH_WEST:
				return flagged(x, y, flags[north]) || flagged(x, y, flags[east]);
			case WEST:
				return flagged(x, y, flags[east]);
			default:
				throw new IllegalArgumentException("Unrecognised direction " + direction + ".");
		}
	}

	/**
	 * Gets the index in the matrix for the specified coordinate pair.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @return The index.
	 * @throws ArrayIndexOutOfBoundsException If the specified coordinate pair does not fit in this matrix.
	 */
	private int indexOf(int x, int y) {
		Preconditions.checkElementIndex(x, width, "X coordinate must be [0, " + width + "), received " + x + ".");
		Preconditions.checkElementIndex(y, length, "Y coordinate must be [0, " + length + "), received " + y + ".");
		return y * width + x;
	}

	/**
	 * Sets the appropriate index for the specified coordinate pair to the specified value.
	 *
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param value The value.
	 */
	private void set(int x, int y, byte value) {
		matrix[indexOf(x, y)] = value;
	}

}
