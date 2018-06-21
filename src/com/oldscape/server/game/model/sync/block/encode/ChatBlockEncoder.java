package com.oldscape.server.game.model.sync.block.encode;

import com.oldscape.server.game.model.sync.block.BlockType;
import com.oldscape.server.game.model.sync.block.ChatBlock;
import com.oldscape.server.game.model.sync.block.SynchronizationBlock;
import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameBuilder;

public class ChatBlockEncoder extends SynchronizationBlockEncoder {

    public ChatBlockEncoder() {
        super(8, 0);
    }

    @Override
    public void encodeBlock(SynchronizationBlock block, GameFrameBuilder builder, boolean player) {
        ChatBlock chat = (ChatBlock) block;
        int length = chat.getMessage().length();
        byte[] bytes = chat.getCompressedMessage();
        builder.put(DataType.SHORT, DataOrder.LITTLE, chat.getTextEffects() << 8 | chat.getTextColor());
        builder.put(DataType.BYTE, DataTransformation.SUBTRACT, chat.getCrownType().ordinal());
        builder.put(DataType.BYTE, chat.isAutoChat() ? 1 : 0);
        builder.put(DataType.BYTE, DataTransformation.NEGATE, bytes.length + (length >= 0x80 ? 2 : 1));
        builder.putSmart(length);
        builder.putBytes(bytes);
    }

    @Override
    public BlockType getType() {
        return BlockType.CHAT;
    }

}
