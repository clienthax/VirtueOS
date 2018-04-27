package com.sean.shared.network.ondemand;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author Graham
 * 
 */
public final class FileResponseEvent {

	/**
	 * The priority of the file.
	 */
	private final boolean priority;
	/**
	 * The index and file id.
	 */
	private final int type, file;

	/**
	 * The data of the file.
	 */
	private final ByteBuf container;

	public FileResponseEvent(boolean priority, int type, int file, ByteBuf container) {
		this.priority = priority;
		this.type = type;
		this.file = file;
		this.container = container;
	}

	public ByteBuf getContainer() {
		return container;
	}

	public int getFile() {
		return file;
	}

	public int getType() {
		return type;
	}

	public boolean isPriority() {
		return priority;
	}

}
