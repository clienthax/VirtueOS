package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.model.sync.block.encode.SynchronizationBlockEncoder;
import com.oldscape.server.game.model.sync.descriptor.SynchronizationDescriptor;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.PlayerSynchronizationEvent;
import com.oldscape.shared.utility.SyncUtils;
import io.netty.buffer.ByteBufAllocator;

/**
 * A {@link GameMessageEncoder} for the {@link PlayerSynchronizationEvent}.
 *
 * @author Graham
 * @author Major
 */
public final class PlayerSynchronizationEventEncoder implements GameMessageEncoder<PlayerSynchronizationEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, PlayerSynchronizationEvent event) {

//		if(1 == 1)
//			return null;//todo 168

        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.PLAYER_SYNC, FrameType.VARIABLE_SHORT);

        GameFrameBuilder blockBuilder = new GameFrameBuilder(alloc);

        int flags = 0;
        SynchronizationDescriptor desc;
        SynchronizationBlock block;
        SynchronizationBlockEncoder encd;
        for (SynchronizationSegment segment : event.getSegments()) {
            desc = SyncUtils.getPlayerDescriptor(segment.getType());
            desc.encodeDescriptor(event, segment, builder);
            for (int index = 0; index < 12; index++) {
                encd = SyncUtils.getPlayerBlock(index);
                block = segment.getBlockSet().get(encd.getType());
                if (block != null) {
                    encd.encodeBlock(block, blockBuilder, true);
                    flags |= encd.getFlag(true);
                }
            }
        }
        if (blockBuilder.getLength() > 0) {
            if (flags >= 0x100) {//256 0x100
//				System.out.println("sending flags as short "+(flags| 32));
                builder.put(DataType.SHORT, DataOrder.LITTLE, (flags | 32));//TODO update per revision
            } else {
                System.out.println("sending flags as byte");
                builder.put(DataType.BYTE, flags);
            }

            builder.putRawBuilder(blockBuilder);
        }

        blockBuilder.release();

        if (builder.getLength() == 0) {
            //(new Throwable()).printStackTrace();
            return null;//fucking bail out!
        }

        return builder.toGameFrame();
    }

}