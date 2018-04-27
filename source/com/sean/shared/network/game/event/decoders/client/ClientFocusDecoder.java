package com.sean.shared.network.game.event.decoders.client;

import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.GameFrameReader;
import com.sean.shared.network.game.event.GameMessageDecoder;
import com.sean.shared.network.game.event.impl.ClientFocusEvent;

public class ClientFocusDecoder implements GameMessageDecoder<ClientFocusEvent> {

    @Override
    public ClientFocusEvent decode(GameFrameReader frame) {
        boolean focused = frame.getUnsigned(DataType.BYTE) == 1;
        System.out.println("client focused "+focused);
        return new ClientFocusEvent(focused);
    }

}
