package com.sean.shared.network.game.event.encoders;

import com.sean.game.model.sync.block.SynchronizationBlock;
import com.sean.game.model.sync.block.encode.SynchronizationBlockEncoder;
import com.sean.game.model.sync.descriptor.SynchronizationDescriptor;
import com.sean.game.model.sync.segment.SynchronizationSegment;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.NpcSynchronizationEvent;
import com.sean.shared.utility.SyncUtils;

import io.netty.buffer.ByteBufAllocator;

/**
 * A {@link MessageEncoder} for the {@link NpcSynchronizationEvent}.
 *
 * @author Major
 */
public final class NpcSynchronizationEventEncoder implements GameMessageEncoder<NpcSynchronizationEvent> {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.sean.shared.network.game.event.GameMessageEncoder#encode(io.netty
	 * .buffer.ByteBufAllocator, com.sean.shared.event.Event)
	 */
	@Override
	public GameFrame encode(ByteBufAllocator alloc, NpcSynchronizationEvent event) {
/*		GameFrameBuilder builder = new GameFrameBuilder(alloc,
				(event.isLargeScene() ? EncoderOpcode.NPC_SYNC_LARGE : EncoderOpcode.NPC_SYNC),
				FrameType.VARIABLE_SHORT);
		builder.switchToBitAccess();

		GameFrameBuilder blockBuilder = new GameFrameBuilder(alloc);
		builder.putBits(8, event.getLocalNpcCount());

		int flags = 0;
		SynchronizationDescriptor desc;
		SynchronizationBlock block;
		SynchronizationBlockEncoder encd;
		for (SynchronizationSegment segment : event.getSegments()) {

			desc = SyncUtils.getNpcDescriptor(segment.getType());
			desc.encodeDescriptor(event, segment, builder);

			for (int index = 0; index < 8; index++) {
				encd = SyncUtils.getNpcBlock(index);
				block = segment.getBlockSet().get(encd.getType());
				if (block != null) {
					System.out.println("encoding npc block "+encd.getType());
					encd.encodeBlock(block, blockBuilder, false);
					flags |= encd.getFlag(false);
				}
			}
		}

		if (blockBuilder.getLength() > 0) {
			builder.putBits(15, 32767);
			builder.switchToByteAccess();
			builder.put(DataType.BYTE, flags);
			builder.putRawBuilder(blockBuilder);
		} else {
			builder.switchToByteAccess();
		}

		blockBuilder.release();

		if(builder.getLength() == 0) {
			System.out.println("not sending 0 length update");
			return null;//prevent crashing client
		}

		return builder.toGameFrame();*/
return null;
	}

}