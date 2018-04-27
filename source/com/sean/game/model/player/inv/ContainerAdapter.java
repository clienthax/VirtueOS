package com.sean.game.model.player.inv;

/**
 * An adapter for the {@link ContainerListener}.
 * 
 * @author Graham
 */
public abstract class ContainerAdapter implements ContainerListener {

	@Override
	public void capacityExceeded(ItemContainer inventory) {

	}

	@Override
	public void itemsUpdated(ItemContainer inventory) {

	}

	@Override
	public void itemUpdated(ItemContainer inventory, int slot, Item item) {

	}

}