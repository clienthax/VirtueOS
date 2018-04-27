package com.sean.game.model.sync;

import com.sean.game.Server;

/**
 * The {@link ClientSynchronizer} manages the update sequence which keeps
 * clients synchronized with the in-game world. There are two implementations
 * distributed with Apollo: {@link SequentialClientSynchronizer} which is
 * optimized for a single-core/single-processor machine and
 * {@link ParallelClientSynchronizer} which is optimized for a multi-processor/
 * multi-core machines.
 * <p>
 * To switch between the two synchronizer implementations, edit the
 * {@code synchronizers.xml} configuration file. The default implementation is
 * currently {@link ParallelClientSynchronizer} as the vast majority of machines
 * today have two or more cores.
 * 
 * @author Graham
 */
public abstract class ClientSynchronizer {

	/**
	 * The {@link com.sean.game.Server} reference.
	 */
	protected Server server;

	/**
	 * Creates a new {@link ClientSynchronizer}.
	 * 
	 * @param server
	 *            The {@link com.sean.game.Server} reference.
	 */
	public ClientSynchronizer(Server server) {
		this.server = server;
	}

	/**
	 * Synchronizes the state of the clients with the state of the server.
	 */
	public abstract void synchronize();

}