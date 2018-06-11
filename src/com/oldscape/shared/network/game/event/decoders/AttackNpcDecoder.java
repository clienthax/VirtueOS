package com.oldscape.shared.network.game.event.decoders;

import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.AttackNpcEvent;

public class AttackNpcDecoder implements GameMessageDecoder<AttackNpcEvent> {

    @Override
    public AttackNpcEvent decode(GameFrameReader frame) {
        // the index of the npc the player is trying to attack.
        int npcIndex = (int) frame.getUnsigned(DataType.SHORT, DataTransformation.ADD);
        // TODO: figure out what this boolean means: aBoolArray818[82]
        boolean bool = frame.getUnsigned(DataType.BYTE) == 1;// Force Run?
        return new AttackNpcEvent(bool, npcIndex);
    }

}
