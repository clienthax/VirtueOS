package com.oldscape.server.game.network.ondemand;

import java.util.Deque;

import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.ondemand.FileRequestEvent;

/**
 * 
 * @author Sean
 * @author Graham
 *
 */
public final class FileRequestEventListener implements EventListener<FileRequestEvent, OnDemandSessionContext> {

	@Override
	public void onEvent(FileRequestEvent event, OnDemandSessionContext context) {
		if (context.isHandshakeComplete()) {
			Deque<FileRequestEvent> queue = context.getFileQueue();
			synchronized (queue) {
				if (event.isPriority()) {
					queue.addFirst(event);
				} else {
					queue.addLast(event);
				}
				if (context.isIdle()) {
					context.addContextToService();
					context.setIdle(false);
				}
			}
		}
	}
}
