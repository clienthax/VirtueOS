package com.oldscape.shared.network.game.event.decoders.object;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.ObjectActionEvent;

public class ObjectFirstActionClickDecoder implements GameMessageDecoder<ObjectActionEvent> {

    @Override
    public ObjectActionEvent decode(GameFrameReader frame) {
        int y = (int) frame.getUnsigned(DataType.SHORT);
        int x = (int) frame.getUnsigned(DataType.SHORT, DataOrder.LITTLE);
        int type = (int) frame.getUnsigned(DataType.BYTE, DataTransformation.SUBTRACT);
        int object = (int) frame.getUnsigned(DataType.SHORT);

        System.out.println("objectActionEvent(0): " + x + ", Y:" + y + ", type:" + type + " obj:" + object);
        return new ObjectActionEvent(0, object, x, y);
    }

}
