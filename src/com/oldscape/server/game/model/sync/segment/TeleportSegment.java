package com.oldscape.server.game.model.sync.segment;

import com.oldscape.server.game.model.sync.block.SynchronizationBlockSet;
import com.oldscape.shared.model.Position;

/**
 * A {@link SynchronizationSegment} where the mob is teleported to a new
 * location.
 * 
 * @author Graham
 */
public final class TeleportSegment extends SynchronizationSegment {

	/**
	 * The start.
	 */
	private final Position start;
	
	/**
	 * The destination.
	 */
	private final Position destination;

	/**
	 * Creates the teleport segment.
	 * 
	 * @param blockSet
	 *            The block set.
	 * @param destination
	 *            The destination.
	 */
	public TeleportSegment(SynchronizationBlockSet blockSet,
			Position start, Position destination) {
		super(blockSet);
		this.start = start;
		this.destination = destination;
	}

	/**
	 * Gets the start.
	 * 
	 * @return The start.
	 */
	public Position getStart() {
		return start;
	}
	
	/**
	 * Gets the destination.
	 * 
	 * @return The destination.
	 */
	public Position getDestination() {
		return destination;
	}

	@Override
	public SegmentType getType() {
		return SegmentType.TELEPORT;
	}

}