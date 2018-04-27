package com.oldscape.server.game.model.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadFactory;

import com.oldscape.server.game.Server;
import com.oldscape.server.game.model.npc.Npc;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.model.sync.task.NpcSynchronizationTask;
import com.oldscape.server.game.model.sync.task.PhasedSynchronizationTask;
import com.oldscape.server.game.model.sync.task.PlayerSynchronizationTask;
import com.oldscape.server.game.model.sync.task.PostNpcSynchronizationTask;
import com.oldscape.server.game.model.sync.task.PostPlayerSynchronizationTask;
import com.oldscape.server.game.model.sync.task.PreNpcSynchronizationTask;
import com.oldscape.server.game.model.sync.task.PrePlayerSynchronizationTask;
import com.oldscape.server.game.model.sync.task.SynchronizationTask;
import com.oldscape.shared.utility.MobList;
import com.oldscape.shared.utility.NamedThreadFactory;

/**
 * An implementation of {@link ClientSynchronizer} which runs in a thread pool.
 * A {@link Phaser} is used to ensure that the synchronization is complete,
 * allowing control to return to the {@link GameService} that started the
 * synchronization. This class will scale well with machines that have multiple
 * cores/processors. The {@link SequentialClientSynchronizer} will work better
 * on machines with a single core/processor, however, both classes will work.
 * 
 * @author Graham
 * @author Major
 */
public final class ParallelClientSynchronizer extends ClientSynchronizer {

	/**
	 * The executor service.
	 */
	private final ExecutorService executor;

	/**
	 * The phaser.
	 */
	private final Phaser phaser = new Phaser(1);

	/**
	 * Creates the parallel client synchronizer backed by a thread pool with a
	 * number of threads equal to the number of processing cores available (this
	 * is found by the {@link Runtime#availableProcessors()} method.
	 */
	public ParallelClientSynchronizer(Server server) {
		super(server);
		int processors = Runtime.getRuntime().availableProcessors();
		ThreadFactory factory = new NamedThreadFactory("ClientSynchronizer");
		executor = Executors.newFixedThreadPool(processors, factory);
	}

	@Override
	public void synchronize() {
		MobList<Player> players = server.getGameWorld().getPlayers();
		MobList<Npc> npcs = server.getGameWorld().getNpcs();
		int playerCount = players.size();
		int npcCount = npcs.size();

		phaser.bulkRegister(playerCount);
		for (Player player : players) {
			SynchronizationTask task = new PrePlayerSynchronizationTask(player);
			executor.submit(new PhasedSynchronizationTask(phaser, task));
		}
		phaser.arriveAndAwaitAdvance();

		phaser.bulkRegister(npcCount);
		for (Npc npc : npcs) {
			SynchronizationTask task = new PreNpcSynchronizationTask(npc);
			executor.submit(new PhasedSynchronizationTask(phaser, task));
		}
		phaser.arriveAndAwaitAdvance();

		phaser.bulkRegister(playerCount);
		for (Player player : players) {
			SynchronizationTask task = new PlayerSynchronizationTask(server, player);
			executor.submit(new PhasedSynchronizationTask(phaser, task));
		}
		phaser.arriveAndAwaitAdvance();

		phaser.bulkRegister(playerCount);
		for (Player player : players) {
			SynchronizationTask task = new NpcSynchronizationTask(server, player);
			executor.submit(new PhasedSynchronizationTask(phaser, task));
		}
		phaser.arriveAndAwaitAdvance();

		phaser.bulkRegister(playerCount);
		for (Player player : players) {
			SynchronizationTask task = new PostPlayerSynchronizationTask(player);
			executor.submit(new PhasedSynchronizationTask(phaser, task));
		}
		phaser.arriveAndAwaitAdvance();

		phaser.bulkRegister(npcCount);
		for (Npc npc : npcs) {
			SynchronizationTask task = new PostNpcSynchronizationTask(npc);
			executor.submit(new PhasedSynchronizationTask(phaser, task));
		}
		phaser.arriveAndAwaitAdvance();
	}

}