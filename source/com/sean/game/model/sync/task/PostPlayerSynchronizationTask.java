package com.sean.game.model.sync.task;

import com.sean.game.model.player.Player;
import com.sean.game.model.sync.block.SynchronizationBlock;

/**
 * A {@link SynchronizationTask} which does post-synchronization work for the
 * specified {@link Player}.
 * 
 * @author Graham
 */
public final class PostPlayerSynchronizationTask extends SynchronizationTask {

	/**
	 * The player.
	 */
	private final Player player;

	/**
	 * Creates the {@link PostPlayerSynchronizationTask} for the specified
	 * player.
	 * 
	 * @param player
	 *            The player.
	 */
	public PostPlayerSynchronizationTask(Player player) {
		this.player = player;
	}

	@Override
	public void run() {
		if(player.isTeleporting()) {
			player.setTeleporting(false);
			player.addBlock(SynchronizationBlock.createMovementTypeBlock(player.getWalkingQueue().runningQueue(), player.isTeleporting()));//TODO is this the best way to do this?
		}

		player.setRegionChange(false);
		player.resetBlockSet();
		player.getViewport().refresh();
	}

}