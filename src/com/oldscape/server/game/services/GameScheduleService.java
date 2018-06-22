package com.oldscape.server.game.services;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.oldscape.server.game.GameWorld;
import com.oldscape.server.game.Server;
import com.oldscape.server.game.model.entity.player.Player;
import com.oldscape.server.game.model.sync.ClientSynchronizer;
import com.oldscape.server.game.model.sync.ParallelClientSynchronizer;
import com.oldscape.server.game.network.login.PlayerLoginContextPair;

import java.util.concurrent.TimeUnit;

/**
 * Created by sean on 16/07/14.
 */
public final class GameScheduleService extends AbstractScheduledService {

    /**
     * The delay the game will schedule at.
     */
    private static final int SCHEDULE_DELAY = 600;

    /**
     * The maximum number of unregistrations of players per cycle.
     */
    private static final int MAXIMUM_UNREGISTERED_PER_CYCLE = 25;

    /**
     * The maximum number of registrations of players per cycle.
     */
    private static final int MAXIMUM_REGISTERED_PER_CYCLE = 25;
    /**
     * The {@link com.oldscape.server.game.Server} reference.
     */
    private final Server server;
    /**
     * The {@link com.oldscape.server.game.model.sync.ClientSynchronizer} reference.
     */
    private ClientSynchronizer synchronizer;

    /**
     * Creates a new {@link GameScheduleService}.
     *
     * @param server The {@link com.oldscape.server.game.Server} reference.
     */
    public GameScheduleService(Server server) {
        this.server = server;
        this.synchronizer = new ParallelClientSynchronizer(server);
    }

    @Override
    protected void runOneIteration() {

        try {

            GameWorld world = server.getGameWorld();

            int totalAdded = 0;
            PlayerLoginContextPair playerToLogin;
            while ((totalAdded < MAXIMUM_REGISTERED_PER_CYCLE)
                    && (playerToLogin = world.getPlayersAwaitingLogin().poll()) != null) {
                playerToLogin.getContext().sendLoginSuccess(playerToLogin.getPlayer());
                totalAdded++;
            }

            int totalRemoved = 0;
            Player playerToRemove;
            while ((totalRemoved < MAXIMUM_UNREGISTERED_PER_CYCLE)
                    && (playerToRemove = world.getPlayersToRemove().poll()) != null) {
                playerToRemove.onDisconnection();
                totalRemoved++;
            }

            world.getPlayers().stream().forEach((Player player) -> {
                player.getSessionContext().pulse();
            });

            synchronizer.synchronize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Scheduler scheduler() {
        return Scheduler.newFixedRateSchedule(SCHEDULE_DELAY, SCHEDULE_DELAY, TimeUnit.MILLISECONDS);
    }
}
