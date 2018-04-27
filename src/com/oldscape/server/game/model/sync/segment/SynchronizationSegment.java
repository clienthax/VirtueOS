package com.oldscape.server.game.model.sync.segment;

import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.model.sync.block.SynchronizationBlockSet;
import com.oldscape.server.game.model.sync.reference.Direction;
import com.oldscape.shared.model.Position;

/**
 * A segment contains a set of {@link SynchronizationBlock}s, {@link Direction}s
 * (or teleport {@link Position}s) and any other things required for the update
 * of a single player.
 * 
 * @author Graham
 */
public abstract class SynchronizationSegment {

	/**
	 * An empty {@link SynchronizationBlockSet}.
	 */
	protected static final SynchronizationBlockSet EMPTY_BLOCK_SET = new SynchronizationBlockSet();

	/**
	 * The {@link SynchronizationBlockSet}.
	 */
	private final SynchronizationBlockSet blockSet;

	/**
	 * Creates the segment.
	 * 
	 * @param blockSet
	 *            The block set.
	 */
	public SynchronizationSegment(SynchronizationBlockSet blockSet) {
		this.blockSet = blockSet;
	}

	/**
	 * Gets the block set.
	 * 
	 * @return The block set.
	 */
	public final SynchronizationBlockSet getBlockSet() {
		return blockSet;
	}

	/**
	 * Gets the type of segment.
	 * 
	 * @return The type of segment.
	 */
	public abstract SegmentType getType();

}