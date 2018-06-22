package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.model.sync.block.encode.SynchronizationBlockEncoder;
import com.oldscape.server.game.model.sync.descriptor.SynchronizationDescriptor;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.network.game.*;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.PlayerSynchronizationEvent;
import com.oldscape.server.game.model.sync.Sync;
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

        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.PLAYER_SYNC, FrameType.VARIABLE_SHORT);

        GameFrameBuilder blockBuilder = new GameFrameBuilder(alloc);

        int flags = 0;
        SynchronizationDescriptor desc;
        SynchronizationBlock block;
        SynchronizationBlockEncoder encd;

        for (SynchronizationSegment segment : event.getSegments()) {

            desc = Sync.getPlayerDescriptor(segment.getType());
            desc.encodeDescriptor(event, segment, builder);

            for (int index = 0; index < 12; index++) {
                encd = Sync.getPlayerBlock(index);
                block = segment.getBlockSet().get(encd.getType()); //FIXME: Why is this null? When #encd isn't..
                if (block != null) {
                    System.out.println("PlayerSynchronizationEventEncoder: " + encd.getType());
                    encd.encodeBlock(block, blockBuilder, true);
                    flags |= encd.getFlag(true);
                }
            }
        }
        if (blockBuilder.getLength() > 0) {
            if (flags >= 0x100) {
                builder.put(DataType.SHORT, DataOrder.LITTLE, (flags | 32));
            } else {
                builder.put(DataType.BYTE, flags);
            }

            builder.putRawBuilder(blockBuilder);
        }

        if (builder.getLength() == 0) {
            return null;
        }

        blockBuilder.release();

        return builder.toGameFrame();
    }

}