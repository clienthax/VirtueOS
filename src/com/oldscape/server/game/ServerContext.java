package com.oldscape.server.game;

import java.net.InetSocketAddress;

/**
 * Created by sean on 16/07/14.
 */
public final class ServerContext {

    /**
     * The {@link java.net.SocketAddress}.
     */
    private final InetSocketAddress address;

    /**
     * The major version of the runescape protocol.
     */
    private final int major;

    /**
     * The id of the world.
     */
    private final int worldId;

    /**
     * The login token
     */
    private String token;

    /**
     * Creates a new {@link com.oldscape.server.game.ServerContext}.
     *
     * @param address     The {@link java.net.SocketAddress}.
     * @param major       The major version of the protocol.
     * @param minor       The minor version of the protocol.
     * @param ondemandKey
     */
    public ServerContext(InetSocketAddress address, int major, int worldId, String token) {
        this.address = address;
        this.major = major;
        this.worldId = worldId;
        System.out.println(address + ", " + major + ", " + worldId);
    }

    /**
     * Gets the {@link java.net.SocketAddress}.
     *
     * @return The {@code address}.
     */
    public InetSocketAddress getAddress() {
        return address;
    }

    /**
     * Gets the major version of the protocol.
     *
     * @return The {@code major}.
     */
    public int getMajor() {
        return major;
    }

    /**
     * Gets the id of the world.
     *
     * @return The {@code worldId}.
     */
    public int getWorldId() {
        return worldId;
    }

    /**
     * Gets the login token
     *
     * @return The {@code token}.
     */
    public String getToken() {
        return token;
    }
}
