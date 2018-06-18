package com.oldscape.server.game;

import com.oldscape.server.game.model.npc.Npc;
import com.oldscape.server.game.model.player.Player;
import com.oldscape.server.game.network.login.PlayerLoginContextPair;
import com.oldscape.shared.model.Response;
import com.oldscape.shared.utility.MobList;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by sean on 16/07/14.
 */
public final class GameWorld {

    /**
     * The maximum number of players in the world.
     */
    public static final int MAXIMUM_PLAYERS = 2048;

    /**
     * The maximum number of npcs in the world.
     */
    public static final int MAXIMUM_NPCS = Short.MAX_VALUE - 1;

    /**
     * The {@link java.util.Collection} of
     * {@link com.oldscape.server.game.model.player.Player}s in the server.
     */
    private final MobList<Player> players = new MobList<>(MAXIMUM_PLAYERS);

    /**
     * The {@link java.util.Collection} of {@link com.oldscape.server.game.model.npc.Npc}s
     * in the server.
     */
    private final MobList<Npc> npcs = new MobList<>(MAXIMUM_NPCS);

    /**
     * A {@link java.util.Queue} of {@link com.oldscape.server.game.model.player.Player}s
     * to remove.
     */
    private final Queue<Player> playersToRemove = new ConcurrentLinkedQueue<>();

    /**
     * The {@link java.util.Queue} of players awaiting login.
     */
    private final Queue<PlayerLoginContextPair> playersAwaitingLogin = new ConcurrentLinkedQueue<>();

    /**
     * The {@link java.util.Map} of pending login requests.
     */
    private final Map<Long, Response> pendingLoginRequests = new ConcurrentHashMap<>();

    Npc npc;

    /**
     * Adds a {@link com.oldscape.server.game.model.player.Player} to the players
     *
     * @param player The {@link com.oldscape.server.game.model.player.Player} to
     *               registerLobbyPlayer.
     */
    public void registerPlayer(Player player) {

        //TODO move to config
//        npcs.add(npc = new Npc(394, player.getPosition().getX() + 1, player.getPosition().getY() + 1));
        synchronized (players) {
            players.add(player);
        }
    }

    public void registerNpc(Npc mob) {
        synchronized (npcs) {
            npcs.add(mob);
        }
    }

    /**
     * Adds a {@link com.oldscape.server.game.model.player.Player} to the
     * {@code playersToRemove} to unregister a
     * {@link com.oldscape.server.game.model.player.Player}.
     *
     * @param player
     */
    public void removePlayer(Player player) {
        playersToRemove.add(player);
    }

    /**
     * Removes a {@link com.oldscape.server.game.model.player.Player} from the
     * {@link java.util.Collection} of {@link com.oldscape.server.game.model.player.Player}
     * .
     *
     * @param player The {@link com.oldscape.server.game.model.player.Player} to remove.
     */
    public void unregisterPlayer(Player player) {
        synchronized (players) {
            players.remove(player);
        }
    }

    public boolean contains(String username) {
        for (Player player : players) {
            if (player.getCredentials().getUserName().equals(username))
                return true;
        }
        return false;
    }

    public boolean full() {
        return players.size() == MAXIMUM_PLAYERS;
    }

    public Player getPlayerByEmailAddress(String name) {
        for (Player player : players)
            if (player.getCredentials().getEmailAddress().equals(name)) {
                return player;
            }
        return null;
    }

    /**
     * Gets the {@link java.util.Collection} of
     * {@link com.oldscape.server.game.model.player.Player}s.
     *
     * @return The {@code players}.
     */
    public MobList<Player> getPlayers() {
        return players;
    }

    /**
     * Gets the {@link java.util.Collection} of
     * {@link com.oldscape.server.game.model.npc.Npc}s.
     *
     * @return The {@code players}.
     */
    public MobList<Npc> getNpcs() {
        return npcs;
    }

    /**
     * Gets the {@link java.util.Queue} of
     * {@link com.oldscape.server.game.model.player.Player}s to remove from the server.
     *
     * @return The {@code playersToRemove}.
     */
    public Queue<Player> getPlayersToRemove() {
        return playersToRemove;
    }

    /**
     * Gets the {@link java.util.Queue} of
     * {@link com.oldscape.server.game.network.login.PlayerLoginContextPair}.
     *
     * @return The {@code playersAwaitingLogin}.
     */
    public Queue<PlayerLoginContextPair> getPlayersAwaitingLogin() {
        return playersAwaitingLogin;
    }

    /**
     * Gets the {@link java.util.Map} of login requests from the login server.
     *
     * @return The {@code pendingLoginRequests}.
     */
    public Map<Long, Response> getPendingLoginRequests() {
        return pendingLoginRequests;
    }
}
