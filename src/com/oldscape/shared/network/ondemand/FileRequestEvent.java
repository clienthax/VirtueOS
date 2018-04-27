package com.oldscape.shared.network.ondemand;

import com.oldscape.shared.event.Event;

/**
 * 
 * @author Graham
 * 
 */
public final class FileRequestEvent implements Event {

	/**
	 * The priority of the file requested.
	 */
	private final boolean priority;

	/**
	 * The type of file and the file that is requested.
	 */
	private final int type, file;

	/**
	 * Creates a new FileRequest.
	 * 
	 * @param priority
	 *            The priority of the file.
	 * @param type
	 *            The type of file.
	 * @param file
	 *            The file id requested.
	 */
	public FileRequestEvent(boolean priority, int type, int file) {
		this.priority = priority;
		this.type = type;
		this.file = file;
	}

	/**
	 * Gets the file id.
	 * 
	 * @return The file.
	 */
	public int getFile() {
		return file;
	}

	/**
	 * Gets the type of file.
	 * 
	 * @return The type.
	 */
	public int getType() {
		return type;
	}

	/**
	 * Is the file a priority or not.
	 * 
	 * @return The priority.
	 */
	public boolean isPriority() {
		return priority;
	}
}
