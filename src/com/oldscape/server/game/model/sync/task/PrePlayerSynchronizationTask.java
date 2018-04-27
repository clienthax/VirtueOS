package com.oldscape.server.game.model.sync.task;

import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.shared.model.Position;

/**
 * A {@link SynchronizationTask} which does pre-synchronization work for the
 * specified {@link Player}.
 * 
 * @author Graham
 */
public final class PrePlayerSynchronizationTask extends SynchronizationTask {

	/**
	 * The player.
	 */
	private final Player player;

	/**
	 * Creates the {@link PrePlayerSynchronizationTask} for the specified player.
	 * 
	 * @param player
	 *            The player.
	 */
	public PrePlayerSynchronizationTask(Player player) {
		this.player = player;
	}

	/**
	 * Checks if a sector update is required.
	 * 
	 * @return {@code true} if so, {@code false} otherwise.
	 */
	private boolean needsRegionUpdate() {
		Position current = player.getPosition();
		Position last = player.getLastPosition();

		int deltaX = current.getLocalX(last);
		int deltaY = current.getLocalY(last);

		return deltaX < 16 || deltaX >= 88 || deltaY < 16 || deltaY >= 88;
	}

	@Override
	public void run() {
		player.getWalkingQueue().pulse();

		if (player.isTeleporting()) {
			player.getViewport().resetViewingDistance();
			player.addBlock(SynchronizationBlock.createMovementTypeBlock(player.getWalkingQueue().runningQueue(),
					player.isTeleporting()));// TODO is this the best way to do this?
		}

		if (!player.hasLastKnownPosition() || needsRegionUpdate()) {
			player.setRegionChange(true);

			Position position = player.getPosition();
			System.out.println("Sending position " + position.toString());
			if (!player.hasLastKnownPosition() || !player.isTeleporting())
				player.setLastPosition(position);
			player.sendRegionUpdate(position);
		}
	}

}