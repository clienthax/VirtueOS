package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.WidgetItemUpdateEvent;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 27, 2015
 */
public class WidgetItemUpdateEventEncoder implements GameMessageEncoder<WidgetItemUpdateEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, WidgetItemUpdateEvent event) {
        // TODO: Add.
        return null;
    }

//	@Override
//	public GameFrame encode(ByteBufAllocator alloc, WidgetItemUpdateEvent event) {
//		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.FULL_ITEMS, FrameType.VARIABLE_SHORT);
//		builder.put(DataType.INT, event.getWidgetId());
//		builder.put(DataType.SHORT, event.getChannelId());
//		builder.put(DataType.SHORT, event.getItems().length);
//		
//		for (Item item : event.getItems()) {		
//			int id = item == null ? -1 : item.getId();
//			int amount = item == null ? 0 : item.getAmount();
//
//			builder.put(DataType.SHORT, id + 1);
//
//			if (amount > 254) {
//				builder.put(DataType.BYTE, DataTransformation.NEGATE, 255);
//				builder.put(DataType.INT, DataOrder.INVERSED_MIDDLE, amount);
//			} else {
//				builder.put(DataType.BYTE, DataTransformation.NEGATE, amount);
//			}
//		}
//		
//		return builder.toGameFrame();
//	}
}
