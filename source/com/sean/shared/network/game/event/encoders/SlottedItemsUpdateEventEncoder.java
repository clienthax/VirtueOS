package com.sean.shared.network.game.event.encoders;

import io.netty.buffer.ByteBufAllocator;

import com.sean.game.model.player.inv.SlottedItem;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.SlottedItemsUpdateEvent;

/**
 * 
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 27, 2015
 */
public class SlottedItemsUpdateEventEncoder implements GameMessageEncoder<SlottedItemsUpdateEvent> {

	@Override
	public GameFrame encode(ByteBufAllocator alloc, SlottedItemsUpdateEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public GameFrame encode(ByteBufAllocator alloc, SlottedItemsUpdateEvent event) {
//		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.SLOT_ITEMS, FrameType.VARIABLE_SHORT);
//		builder.put(DataType.INT, event.getInterfaceID());
//		builder.put(DataType.SHORT, event.getChannelID());
//
//		for (SlottedItem item : event.getItems()) {
//			builder.putSmart(item.getSlot());
//
//			int id = item == null ? -1 : item.getId();
//			int amount = item == null ? 0 : item.getAmount();
//
//			builder.put(DataType.SHORT, id + 1);
//
//			if (amount > 254) {
//				builder.put(DataType.BYTE, 255);
//				builder.put(DataType.INT, amount);
//			} else {
//				builder.put(DataType.BYTE, amount);
//			}
//		}
//
//		return builder.toGameFrame();
//	}
	
}
