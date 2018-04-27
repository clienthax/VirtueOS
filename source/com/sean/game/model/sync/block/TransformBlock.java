package com.sean.game.model.sync.block;

/**
 * The transform {@link SynchronizationBlock}. Only npcs can utilise this block.
 * 
 * @author Major
 */
public final class TransformBlock extends SynchronizationBlock {

	/**
	 * The id to transform to.
	 */
	private final int id;

	/**
	 * Creates a new transform block.
	 * 
	 * @param id
	 *            The id.
	 */
	TransformBlock(int id) {
		this.id = id;
	}

	/**
	 * Gets the id of the npc to transform into.
	 * 
	 * @return The id.
	 */
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.sean.game.model.sync.block.SynchronizationBlock#getType()
	 */
	@Override
	public BlockType getType() {
		return BlockType.TRANSFORM;
	}

}