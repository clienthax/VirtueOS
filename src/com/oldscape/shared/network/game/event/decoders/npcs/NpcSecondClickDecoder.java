package com.oldscape.shared.network.game.event.decoders.npcs;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.NpcActionEvent;

public class NpcSecondClickDecoder implements GameMessageDecoder<NpcActionEvent> {

    @Override
    public NpcActionEvent decode(GameFrameReader frame) {

        int index = (int) frame.getUnsigned(DataType.SHORT, DataOrder.LITTLE, DataTransformation.ADD);
        int type = (int) frame.getUnsigned(DataType.BYTE, DataTransformation.ADD);//todo

        System.out.println("npcclick " + type + " " + index);
        return new NpcActionEvent(2, index);
    }

}
