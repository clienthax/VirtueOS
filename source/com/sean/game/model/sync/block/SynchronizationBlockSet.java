package com.sean.game.model.sync.block;

import java.util.HashMap;
import java.util.Map;

/**
 * A specialized collection of {@link SynchronizationBlock}s.
 * 
 * @author Graham
 */
public final class SynchronizationBlockSet implements Cloneable {

	/**
	 * A {@link Map} of {@link SynchronizationBlock}s.
	 */
	private final Map<BlockType, SynchronizationBlock> blocks = new HashMap<>(12);

	/**
	 * Adds a {@link SynchronizationBlock}.
	 * 
	 * @param block
	 *            The block to add.
	 */
	public void add(SynchronizationBlock block) {
		blocks.put(block.getType(), block);
	}

	/**
	 * Clears the set.
	 */
	public void clear() {
		blocks.clear();
	}

	@Override
	public SynchronizationBlockSet clone() {
		SynchronizationBlockSet copy = new SynchronizationBlockSet();
		copy.blocks.putAll(blocks);
		return copy;
	}

	/**
	 * Gets a {@link SynchronizationBlock} from this set.
	 * 
	 * @param <T>
	 *            The type of block.
	 * @param clazz
	 *            The block's class.
	 * @return The block.
	 */
	public SynchronizationBlock get(BlockType type) {
		return blocks.get(type);
	}

	/**
	 * Removes a {@link SynchronizationBlock} from this set.
	 * 
	 * @param clazz
	 *            The block's class.
	 * @return The removed block.
	 */
	public SynchronizationBlock remove(BlockType type) {
		return blocks.remove(type);
	}
	
	/**
	 * Gets the size of this set.
	 * 
	 * @return The size.
	 */
	public int size() {
		return blocks.size();
	}

}