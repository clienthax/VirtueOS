package com.oldscape.shared.network.game.event.encoders;

import com.oldscape.shared.model.MessageType;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.FrameType;
import com.oldscape.shared.network.game.GameFrame;
import com.oldscape.shared.network.game.GameFrameBuilder;
import com.oldscape.shared.network.game.event.EncoderOpcode;
import com.oldscape.shared.network.game.event.GameMessageEncoder;
import com.oldscape.shared.network.game.event.impl.MessageEvent;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jul 24, 2015
 */
public class MessageEventEncoder implements
        GameMessageEncoder<MessageEvent> {

    @Override
    public GameFrame encode(ByteBufAllocator alloc, MessageEvent event) {
        GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.GAME_MESSAGE, FrameType.VARIABLE_BYTE);
        builder.putSmart(event.getType().getID());

        builder.put(DataType.BYTE, (event.getType() == MessageType.CHAT) ? 1 : 0);
        if (event.getType() == MessageType.CHAT)
            builder.putString(event.getFrom());

        builder.putString(event.getMessage());
        return builder.toGameFrame();
    }
}
