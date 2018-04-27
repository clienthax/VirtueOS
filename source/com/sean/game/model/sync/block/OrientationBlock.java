package com.sean.game.model.sync.block;

import com.sean.shared.model.Position;

/**
 * The turn to position {@link SynchronizationBlock}. Both players and npcs can
 * utilise this block.
 * 
 * @author Graham
 */
public final class OrientationBlock extends SynchronizationBlock {

	/**
	 * The position to turn to.
	 */
	private final Position current;
	
	/**
	 * The position to turn to.
	 */
	private final Position position;

	/**
	 * Creates the turn to position block.
	 * 
	 * @param position
	 *            The position to turn to.
	 */
	OrientationBlock(Position position) {
		this.current = null;
		this.position = position;
	}
	
	/**
	 * Creates the turn to position block.
	 * 
	 * @param position
	 *            The position to turn to.
	 */
	OrientationBlock(Position position, Position current) {
		this.current = current;
		this.position = position;
	}

	/**
	 * Gets the {@link Position} to turn to.
	 * 
	 * @return The position to turn to.
	 */
	public Position getCurrent() {
		return current;
	}
	
	/**
	 * Gets the {@link Position} to turn to.
	 * 
	 * @return The position to turn to.
	 */
	public Position getPosition() {
		return position;
	}
	
	/* (non-Javadoc)
	 * @see com.sean.game.model.sync.block.SynchronizationBlock#getType()
	 */
	@Override
	public BlockType getType() {
		return BlockType.ORIENTATION;
	}

}