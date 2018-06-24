package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.server.game.model.entity.player.inv.SlottedItem;
import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.SlottedItemsUpdateEvent;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 27, 2015
 */
public class SlottedItemsUpdateEventEncoder implements GameMessageEncoder<SlottedItemsUpdateEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, SlottedItemsUpdateEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.SLOT_ITEMS, FrameType.VARIABLE_SHORT);
		builder.put(DataType.INT, event.getWidgetId());
		builder.put(DataType.SHORT, event.getChannelId());

		for (SlottedItem item : event.getItems()) {
			builder.putSmart(item.getSlot());

			int id = item == null ? -1 : item.getId();
			int amount = item == null ? 0 : item.getAmount();

			builder.put(DataType.SHORT, id + 1);

			if (amount > 254) {
				builder.put(DataType.BYTE,255);
				builder.put(DataType.INT, amount);
			} else {
				builder.put(DataType.BYTE, amount);
			}
		}

		return builder.toGameFrame();
	}

}
