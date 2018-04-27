package com.sean.game.model.sync.block;

import com.sean.game.model.sync.reference.Animation;

/**
 * The animation {@link SynchronizationBlock}. Both npcs and players can utilise
 * this block.
 * 
 * @author Graham
 */
public final class AnimationBlock extends SynchronizationBlock {

	/**
	 * The animation.
	 */
	private final Animation animation;

	/**
	 * Creates the animation block.
	 * 
	 * @param animation
	 *            The animation.
	 */
	AnimationBlock(Animation animation) {
		this.animation = animation;
	}

	/**
	 * Gets the {@link Animation}.
	 * 
	 * @return The animation.
	 */
	public Animation getAnimation() {
		return animation;
	}

	/* (non-Javadoc)
	 * @see com.sean.game.model.sync.block.SynchronizationBlock#getType()
	 */
	@Override
	public BlockType getType() {
		return BlockType.ANIMATION;
	}

}