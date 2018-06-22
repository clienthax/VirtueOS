package com.oldscape.shared.network.game.event.decoders.widget;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.DoubleClickWorldMapEvent;

public class DoubleClickWorldMapDecoder implements GameMessageDecoder<DoubleClickWorldMapEvent> {

    @Override
    public DoubleClickWorldMapEvent decode(GameFrameReader frame) {
        int bitPack = (int) frame.getUnsigned(DataType.INT, DataOrder.LITTLE);

        return new DoubleClickWorldMapEvent(bitPack);
    }
}
