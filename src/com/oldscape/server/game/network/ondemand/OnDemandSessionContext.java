package com.oldscape.server.game.network.ondemand;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Logger;

import com.oldscape.server.game.Server;
import com.oldscape.server.game.network.SessionEventContext;
import com.oldscape.server.game.services.OnDemandService;
import com.oldscape.shared.network.ondemand.FileRequestEvent;
import com.oldscape.shared.network.ondemand.FileResponseEvent;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

/**
 * Created by sean on 23/07/14.
 */
public final class OnDemandSessionContext extends SessionEventContext {

	/**
	 * THe {@link java.util.logging.Logger} dedicated to this class.
	 */
	private static final Logger logger = Logger.getLogger(OnDemandService.class.getName());

	/**
	 * THe {@link java.util.Deque} of
	 * {@link com.oldscape.shared.network.ondemand.FileRequestEvent}s.
	 */
	private final Deque<FileRequestEvent> fileQueue = new ArrayDeque<>();

	/**
	 * THe idle flag.
	 */
	private boolean idle = true;

	/**
	 * THe handshake complete flag.
	 */
	private boolean handshakeComplete = false;

	/**
	 * The {@link OnDemandService}.
	 */
	private final OnDemandService service;

	/**
	 * @see com.oldscape.server.game.network.SessionEventContext
	 */
	public OnDemandSessionContext(Channel channel, Server server) {
		super(channel, server);
		this.service = server.getOnDemandService();
	}

	/**
	 * Processes the file requests.
	 * 
	 * @throws IOException
	 *             The exception thrown if an i/o error occurs.
	 */
	public void processFileQueue() throws IOException {
		FileRequestEvent request;
		synchronized (fileQueue) {
			request = fileQueue.pop();
			if (fileQueue.isEmpty()) {
				idle = true;
			} else {
				service.addOnDemandContext(this);
				idle = false;
			}
		}
		if (request != null) {
			int type = request.getType();
			int file = request.getFile();
			ByteBuf buf;
			try {
				if (type == 255 && file == 255) {
					buf = Unpooled.wrappedBuffer(server.getChecksumBuffer());
				} else {
					buf = Unpooled.wrappedBuffer(server.getCache().getStore().read(type, file));

					if (type != 255 && (buf.readableBytes() > 1))
						buf = buf.slice(0, buf.readableBytes() - 2);
				}
				channel.writeAndFlush(new FileResponseEvent(request.isPriority(), type, file, buf));
			} catch (Exception ex) {
				logger.warning("Failed to service file request " + type + ", " + file + ".");
			}
		}
	}

	/**
	 * Gets the {@link Deque} of {@link FileRequestEvent}s.
	 * 
	 * @return The {@code fileQueue}.
	 */
	public Deque<FileRequestEvent> getFileQueue() {
		return fileQueue;
	}

	/**
	 * Returns the {@code idle} flag.
	 * 
	 * @return The {@code idle}.
	 */
	public boolean isIdle() {
		return idle;
	}

	/**
	 * Returns the {@code handshakeComplete} flag.
	 * 
	 * @return The {@code handshakeComplete}
	 */
	public boolean isHandshakeComplete() {
		return handshakeComplete;
	}

	/**
	 * Sets the {@code idle} flag.
	 * 
	 * @param idle
	 *            the {@code idle} flag to set.
	 */
	public void setIdle(boolean idle) {
		this.idle = idle;
	}

	/**
	 * Sets the {@code handshakeComplete} flag.
	 * 
	 * @param handshakeComplete
	 *            the handshakeComplete to set
	 */
	public void setHandshakeComplete(boolean handshakeComplete) {
		this.handshakeComplete = handshakeComplete;
	}

	/**
	 * Adds this {@link com.oldscape.server.game.network.ondemand.OnDemandSessionContext}
	 * to the {@link com.oldscape.server.game.services.OnDemandService}.
	 */
	public void addContextToService() {
		service.addOnDemandContext(this);
	}
}
