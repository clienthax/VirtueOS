package com.oldscape.shared.model;

/**
 * Created by Sean on 20/12/2014.
 */
public final class Position {

	public static final int DEFAULT_DISTANCE = 15;

	public static enum RegionSize {
		
		DEFAULT(104), 
		LARGE(120), 
		XLARGE(136), 
		XXLARGE(168);

		private final int size;

		RegionSize(int size) {
			this.size = size;
		}

		public int getSize() {
			return size;
		}
	}

	private final RegionSize mapSize;

	private final int x;

	private final int y;

	private final int height;

	public Position(int x, int y, int height) {
		this(x, y, height, RegionSize.DEFAULT);
	}
	
	public Position(int x, int y, int height, RegionSize mapSize) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.mapSize = mapSize;
	}

	public Position(int localX, int localY, int height, int regionId, RegionSize mapSize) {
		this(localX + (((regionId >> 8) & 0xff) << 6), localX
				+ ((regionId & 0xff) << 6), height, mapSize);
	}

	public boolean withinDistance(Position tile, int distance) {
		if (tile.getHeight() != height)
			return false;
		int deltaX = tile.x - x, deltaY = tile.y - y;
		return deltaX <= distance && deltaX >= -distance && deltaY <= distance
				&& deltaY >= -distance;
	}

	public boolean withinDistance(Position position) {
		return withinDistance(position, DEFAULT_DISTANCE);
	}

	public int getLongestDelta(Position other) {
		int deltaX = Math.abs(getX() - other.getX());
		int deltaY = Math.abs(getY() - other.getY());
		return Math.max(deltaX, deltaY);
	}

	public int toRegionPacked() {
		return getRegionY() + (getRegionX() << 8) + (getHeight() << 16);
	}

	public int toPositionPacked() {
		return y + (x << 14) + (height << 28);
	}

	public int getXInRegion() {
		return x & 0x3F;
	}

	public int getYInRegion() {
		return y & 0x3F;
	}

	public int getLocalX() {
		return x - 8 * (getChunkX() - (mapSize.getSize() >> 4));
	}

	public int getLocalY() {
		return y - 8 * (getChunkY() - (mapSize.getSize() >> 4));
	}

	public int getLocalX(Position pos) {
		return x - 8 * (pos.getChunkX() - (mapSize.getSize() >> 4));
	}

	public int getLocalY(Position pos) {
		return y - 8 * (pos.getChunkY() - (mapSize.getSize() >> 4));
	}

	public int getChunkX() {
		return (x >> 3);
	}

	public int getChunkY() {
		return (y >> 3);
	}
	
	public int getRegionX() {
		return (x >> 6);
	}

	public int getRegionY() {
		return (y >> 6);
	}
	
	public int getRegionID() {
		return ((getRegionX() << 8) + getRegionY());
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public RegionSize getMapSize() {
		return mapSize;
	}
	
	@Override
	public String toString() {
		return "X: " + getX() + ", Y: " + getY() + ", Height: " + getHeight();
	}
}
