/**
 * Copyright (c) 2015 Kyle Friz
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.server.game.model.player;

import com.oldscape.server.game.GameWorld;
import com.oldscape.server.game.model.npc.Npc;
import com.oldscape.shared.model.Position;
import com.oldscape.shared.network.game.GameFrameBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kyle Friz
 * @since Aug 29, 2015
 */
public class Viewport {

    /**
     * The player that owns this viewport
     */
    private final Player player;

    /**
     * The player's list of local npcs.
     */
    private final List<Npc> localNpcs = new ArrayList<>();

    /**
     * The player's list of local players.
     */
    private final Player[] localPlayers = new Player[2048];

    /**
     * Represents an array of players' indices within the current player's view
     */
    private final int[] localPlayersIndexes = new int[2048];
    /**
     * Represents an array of players outside the current player's view
     */
    private final int[] outPlayersIndexes = new int[2048];
    /**
     * Represents an array of region hashes
     */
    private final int[] regionHashes = new int[2048];
    /**
     * Represents an array
     */
    private final byte[] slotFlags = new byte[2048];
    /**
     * Represents the movement types of all active players
     */
    private final byte[] movementTypes = new byte[2048];
    /**
     * Represents if the player has a large scene radius
     */
    private final boolean largeScene = false;
    /**
     * Represents the amount of local players within the current player's view
     */
    private int localPlayersIndexesCount = 0;
    /**
     * Represents an the amount of players outside the current player's view
     */
    private int outPlayersIndexesCount = 0;
    /**
     * Represents the amount of players added in the current tick
     */
    private int localAddedPlayers = 0;
    /**
     * The current maximum viewing distance of this player.
     */
    private int viewingDistance = 1;

    /**
     * A flag which indicates there are npcs that couldn't be added.
     */
    private boolean excessiveNpcs = false;

    /**
     * A flag which indicates there are players that couldn't be added.
     */
    private boolean excessivePlayers = false;

    /**
     * A flag which indicates if the viewport has been initialized.
     */
    private boolean initialized = false;

    public Viewport(Player player) {
        this.player = player;
    }

    public synchronized void initialize(GameFrameBuilder builder, GameWorld world) {
        localPlayersIndexesCount = 0;
        outPlayersIndexesCount = 0;

        localPlayers[player.getIndex()] = player;
        localPlayersIndexes[localPlayersIndexesCount++] = player.getIndex();

        builder.switchToBitAccess();
        builder.putBits(30, player.getPosition().toPositionPacked());
        for (int playerIndex = 1; playerIndex < GameWorld.MAXIMUM_PLAYERS; playerIndex++) {
            if (playerIndex != player.getIndex()) {
                Player player = world.getPlayers().get(playerIndex);
                builder.putBits(18, player != null ? player.getPosition().toRegionPacked() : 0);
                outPlayersIndexes[outPlayersIndexesCount++] = playerIndex;
            }
        }
        builder.switchToByteAccess();

        initialized = true;
    }

    public synchronized void refresh() {
        localPlayersIndexesCount = 0;
        outPlayersIndexesCount = 0;
        localAddedPlayers = 0;
        for (int playerIndex = 1; playerIndex < 2048; playerIndex++) {
            slotFlags[playerIndex] >>= 1;
            Player player = localPlayers[playerIndex];
            if (player == null) {
                outPlayersIndexes[outPlayersIndexesCount++] = playerIndex;
            } else {
                localPlayersIndexes[localPlayersIndexesCount++] = playerIndex;
            }
        }

        if (!excessivePlayers) {
            if (viewingDistance < Position.DEFAULT_DISTANCE) {
                viewingDistance++;
            }
        } else {
            if (viewingDistance > 1) {
                viewingDistance--;
            }
            excessivePlayers = false;
        }
    }

    public final boolean initialized() {
        return initialized;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the localNpcs
     */
    public List<Npc> getLocalNpcs() {
        return localNpcs;
    }

    /**
     * @param playerIndex
     * @return
     */
    public Player getLocalPlayer(int index) {
        return localPlayers[index];
    }

    /**
     * @param index
     * @param object
     */
    public void setLocalPlayer(int index, Player player) {
        localPlayers[index] = player;
    }

    /**
     * @return the localPlayersIndex
     */
    public int getLocalPlayersIndex(int index) {
        return localPlayersIndexes[index];
    }

    /**
     * @return the localPlayersIndexesCount
     */
    public int getLocalPlayersIndexesCount() {
        return localPlayersIndexesCount;
    }

    /**
     * @return the outPlayersIndex
     */
    public int getOutPlayersIndex(int index) {
        return outPlayersIndexes[index];
    }

    /**
     * @return the outPlayersIndexesCount
     */
    public int getOutPlayersIndexesCount() {
        return outPlayersIndexesCount;
    }

    /**
     * @param index the Index
     * @param hash the Hash
     * @return if they match
     */
    public boolean regionUpdate(int index, int hash) {
        return regionHashes[index] != hash;
    }

    /**
     * @param index the Index
     * @return the Hash
     */
    public int getRegionHash(int index) {
        return regionHashes[index];
    }

    /**
     * Sets the region hash
     * @param index the Index
     * @param hash the Hash
     */
    public void setRegionHash(int index, int hash) {
        regionHashes[index] = hash;
    }

    /**
     * @return the slotFlag
     */
    public byte getSlotFlag(int index) {
        return slotFlags[index];
    }

    public void setSlotFlag(int index, byte flag) {
        slotFlags[index] = flag;
    }

    /**
     * @return the movementType
     */
    public byte getMovementType(int index) {
        return movementTypes[index];
    }

    /**
     * @return the localAddedPlayers
     */
    public int getLocalAddedPlayers() {
        return localAddedPlayers;
    }

    /**
     * @return the largeScene
     */
    public boolean isLargeScene() {
        return largeScene;
    }

    /**
     * Checks if there are excessive npcs.
     *
     * @return {@code true} if so, {@code false} if not.
     */
    public boolean isExcessiveNpcsSet() {
        return excessiveNpcs;
    }

    /**
     * Checks if there are excessive players.
     *
     * @return {@code true} if so, {@code false} if not.
     */
    public boolean isExcessivePlayersSet() {
        return excessivePlayers;
    }

    /**
     * Sets the excessive npcs flag.
     */
    public void flagExcessiveNpcs() {
        excessiveNpcs = true;
    }

    /**
     * Sets the excessive players flag.
     */
    public void flagExcessivePlayers() {
        excessivePlayers = true;
    }

    /**
     * Gets this player's viewing distance.
     *
     * @return The viewing distance.
     */
    public int getViewingDistance() {
        return viewingDistance;
    }

    /**
     * Resets this player's viewing distance.
     */
    public void resetViewingDistance() {
        viewingDistance = 1;
    }

}
