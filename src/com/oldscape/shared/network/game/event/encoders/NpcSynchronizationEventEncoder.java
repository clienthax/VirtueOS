package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.server.game.model.sync.block.encode.SynchronizationBlockEncoder;
import com.oldscape.server.game.model.sync.descriptor.SynchronizationDescriptor;
import com.oldscape.server.game.model.sync.segment.SynchronizationSegment;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.NpcSynchronizationEvent;
import com.oldscape.server.game.model.sync.Sync;
import io.netty.buffer.ByteBufAllocator;

/**
 * A {@link GameMessageEncoder} for the {@link NpcSynchronizationEvent}.
 *
 * @author Major
 */
public final class NpcSynchronizationEventEncoder implements GameMessageEncoder<NpcSynchronizationEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, NpcSynchronizationEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, (event.isLargeScene() ? EncoderOpcode.NPC_SYNC_LARGE : EncoderOpcode.NPC_SYNC), FrameType.VARIABLE_SHORT);
        builder.switchToBitAccess();

        GameFrameBuilder blockBuilder = new GameFrameBuilder(alloc);
        builder.putBits(8, event.getLocalNpcCount());

        int flags = 0;
        SynchronizationDescriptor desc;
        SynchronizationBlock block;
        SynchronizationBlockEncoder encd;
        for (SynchronizationSegment segment : event.getSegments()) {

            desc = Sync.getNpcDescriptor(segment.getType());
            desc.encodeDescriptor(event, segment, builder);

            for (int index = 0; index < 7; index++) {
                encd = Sync.getNpcBlock(index);
                block = segment.getBlockSet().get(encd.getType());
                if (block != null) {
                    System.out.println("NpcSynchronizationEventEncoder: " + encd.getType());
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

        if (builder.getLength() == 0) {
            return null;
        }

        return builder.toGameFrame();
    }

}