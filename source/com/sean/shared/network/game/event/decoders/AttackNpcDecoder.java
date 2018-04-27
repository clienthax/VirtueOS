package com.sean.shared.network.game.event.decoders;

import com.sean.shared.network.game.DataTransformation;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.GameFrameReader;
import com.sean.shared.network.game.event.GameMessageDecoder;
import com.sean.shared.network.game.event.impl.AttackNpcEvent;

public class AttackNpcDecoder implements GameMessageDecoder<AttackNpcEvent> {

	@Override
	public AttackNpcEvent decode(GameFrameReader frame) {
		// the index of the npc the player is trying to attack.
		int npcIndex = (int) frame.getUnsigned(DataType.SHORT, DataTransformation.ADD);
		// TODO: figure out what this boolean means: aBoolArray818[82]
		boolean bool = (boolean) (frame.getUnsigned(DataType.BYTE) == 1);// Force Run?
		return new AttackNpcEvent(bool, npcIndex);
	}

}
