package com.oldscape.server.game.model.sync.segment;

/**
 * A {@link SynchronizationSegment} which removes a npc.
 * 
 * @author Graham
 */
public final class PlayerSkipSegment extends SynchronizationSegment {

	/**
	 * The amount of players to skip
	 */
	private final int count;
	
	/**
	 * Creates the skip player segment.
	 */
	public PlayerSkipSegment(int count) {
		super(EMPTY_BLOCK_SET);
		this.count = count;
	}
	
	/**
	 * @return the Count
	 */
	public final int getCount() {
		return count;
	}

	@Override
	public SegmentType getType() {
		return SegmentType.SKIP;
	}

}