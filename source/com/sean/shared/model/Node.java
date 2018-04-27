package com.sean.shared.model;

/**
 * Created by sean on 16/07/14.
 */
public abstract class Node {

	/**
	 * The index of the node in the collection.
	 */
	protected int index;

	/**
	 * Initialises the {@link com.sean.shared.model.Node}.
	 */
	public abstract void initialize();

	/**
	 * Gets the index of the node.
	 * 
	 * @return The {@code index}.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the index.
	 * 
	 * @param index
	 *            The index to set.
	 */
	public void setIndex(int index) {
		this.index = index;
	}
}
