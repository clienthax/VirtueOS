package com.oldscape.shared.network.game.event.decoders.object;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.ObjectActionEvent;

public class ObjectThirdActionClickDecoder implements GameMessageDecoder<ObjectActionEvent> {

    @Override
    public ObjectActionEvent decode(GameFrameReader frame) {
        int object = (int) frame.getUnsigned(DataType.SHORT, DataOrder.BIG, DataTransformation.ADD);
        int type = (int) frame.getUnsigned(DataType.BYTE, DataTransformation.NEGATE);
        int y = (int) frame.getUnsigned(DataType.SHORT, DataOrder.BIG, DataTransformation.ADD);
        int x = (int) frame.getUnsigned(DataType.SHORT);

        System.out.println("objectActionEvent(2): " + object + " " + x + " " + y + " " + type);
        return new ObjectActionEvent(2, object, type, x, y);
    }

}
