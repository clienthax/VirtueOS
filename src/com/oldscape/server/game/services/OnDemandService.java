package com.oldscape.server.game.services;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.common.util.concurrent.AbstractService;
import com.oldscape.server.game.network.ondemand.OnDemandSessionContext;

/**
 * 
 * @author Sean
 *
 */
public final class OnDemandService extends AbstractService implements Runnable {

	/**
	 * THe {@link java.util.concurrent.ExecutorService} set with the amount of
	 * available processors the computer has.
	 */
	private final ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	/**
	 * A {@link java.util.concurrent.BlockingDeque} of pending
	 * {@link com.oldscape.server.game.network.ondemand.OnDemandSessionContext}s.
	 */
	private final BlockingDeque<OnDemandSessionContext> pendingContexts = new LinkedBlockingDeque<>();

	/**
	 * The {@link java.util.concurrent.atomic.AtomicBoolean} for the running of the
	 * service.
	 */
	private final AtomicBoolean running = new AtomicBoolean(true);

	@Override
	protected void doStart() {
		service.submit(this);
	}

	@Override
	public void run() {
		while (running.get()) {
			try {
				OnDemandSessionContext context = pendingContexts.take();
				context.processFileQueue();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doStop() {
		running.set(false);
		service.shutdownNow();
	}

	/**
	 * Adds a
	 * {@link com.oldscape.server.game.network.ondemand.OnDemandSessionContext} to
	 * the {@code pendingContexts}.
	 * 
	 * @param session
	 *            THe
	 *            {@link com.oldscape.server.game.network.ondemand.OnDemandSessionContext}
	 *            to registerLobbyPlayer.
	 */
	public void addOnDemandContext(OnDemandSessionContext session) {
		pendingContexts.add(session);
	}
}
