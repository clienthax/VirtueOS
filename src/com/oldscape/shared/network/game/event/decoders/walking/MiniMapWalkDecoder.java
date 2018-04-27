package com.oldscape.shared.network.game.event.decoders.walking;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.WalkEvent;

public class MiniMapWalkDecoder implements GameMessageDecoder<WalkEvent> {
	
	@Override
	public WalkEvent decode(GameFrameReader frame) {
		int type = (int) frame.getUnsigned(DataType.BYTE, DataTransformation.NEGATE);
		int posY = (int) frame.getUnsigned(DataType.SHORT, DataOrder.LITTLE);//, DataOrder.LITTLE
		int posX = (int) frame.getUnsigned(DataType.SHORT, DataTransformation.ADD);

		System.out.println("minimap click "+type+" y"+posY+" x"+posX+" ");
		return new WalkEvent(posX, posY, type);
	}

}
