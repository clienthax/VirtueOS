package com.oldscape.server.game.model.player.inv;

import com.oldscape.server.game.model.player.Player;

/**
 * An {@link ContainerListener} which synchronizes the state of the server's
 * inventory with the client's.
 * 
 * @author Graham
 */
public final class SynchronizationContainerListener extends ContainerAdapter {

	/**
	 * The interface id.
	 */
	private final int interfaceId;
	
	/**
	 * The channel id.
	 */
	private final int channel;

	/**
	 * The player.
	 */
	private final Player player;

	/**
	 * Creates the synchronization inventory listener.
	 * 
	 * @param player
	 *            The player.
	 * @param interfaceId
	 *            The interface id.
	 */
	public SynchronizationContainerListener(Player player, int interfaceId, int channel) {
		this.player = player;
		this.interfaceId = interfaceId;
		this.channel = channel;
	}

	@Override
	public void itemsUpdated(ItemContainer inventory) {
		player.sendItems(interfaceId, channel, inventory.getItems());
	}

	@Override
	public void itemUpdated(ItemContainer inventory, int slot, Item item) {
		player.sendSlottedItems(interfaceId, channel, new SlottedItem(slot, item));
	}

}