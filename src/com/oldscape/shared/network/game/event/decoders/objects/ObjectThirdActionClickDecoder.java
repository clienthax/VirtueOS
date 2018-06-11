package com.oldscape.shared.network.game.event.decoders.objects;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.ObjectClickEvent;

public class ObjectThirdActionClickDecoder implements GameMessageDecoder<ObjectClickEvent> {

    @Override
    public ObjectClickEvent decode(GameFrameReader frame) {
        int object = (int) frame.getUnsigned(DataType.SHORT, DataOrder.BIG, DataTransformation.ADD);
        int type = (int) frame.getUnsigned(DataType.BYTE, DataTransformation.NEGATE);
        int y = (int) frame.getUnsigned(DataType.SHORT, DataOrder.BIG, DataTransformation.ADD);
        int x = (int) frame.getUnsigned(DataType.SHORT);

        System.out.println("thirdclick X: " + x + ", Y:" + y + ", type:" + type + " obj:" + object);
        return new ObjectClickEvent(2, object, x, y);
    }

}
