package com.oldscape.shared.network.game.event.decoders.widget;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.ContinueButtonEvent;

public class ContinueButtonDecoder  implements GameMessageDecoder<ContinueButtonEvent> {

    @Override
    public ContinueButtonEvent decode(GameFrameReader frame) {

        int button = (int) frame.getUnsigned(DataType.SHORT);
        int widget = (int) frame.getUnsigned(DataType.INT, DataOrder.LITTLE);

        System.out.println("continueButtonEvent: " + (widget >> 16) + " " + (widget & 0xFFFF) + " " + button);

        return new ContinueButtonEvent((widget >> 16), (widget & 0xFFFF), button);
    }

}
