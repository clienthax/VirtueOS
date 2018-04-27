package com.sean.game.model.player.inv;

/**
 * Holds {@link ItemContainer}-related constants.
 * 
 * @author Graham
 */
public final class ContainerConstants {

	/**
	 * The capacity of the bank.
	 */
	public static final int BANK_CAPACITY = 352;

	/**
	 * The capacity of the equipment inventory.
	 */
	public static final int EQUIPMENT_CAPACITY = 14;

	/**
	 * The capacity of the inventory.
	 */
	public static final int INVENTORY_CAPACITY = 28;

	/**
	 * The equipment interface id.
	 */
	public static final int EQUIPMENT_ID = -1328;
	
	public static final int BANK_ID = -1329;

	/**
	 * The inventory interface id.
	 */
	public static final int INVENTORY_ID = 9764864;

	public static final int INVENTORY_CHANNEL = 93;
	
	public static final int EQUIPMENT_CHANNEL = 94;
	
	public static final int BANK_CHANNEL = 95;
	
	/**
	 * The bank full message.
	 */
	public static final String FULL_BANK_MESSAGE = "Not enough bank space.";

	/**
	 * The inventory full message.
	 */
	public static final String FULL_INVENTORY_MESSAGE = "Not enough inventory space.";
	
	/**
	 * Default private constructor to prevent instantiation.
	 */
	private ContainerConstants() {

	}

}