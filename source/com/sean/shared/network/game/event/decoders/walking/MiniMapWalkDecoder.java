package com.sean.shared.network.game.event.decoders.walking;

import com.sean.shared.network.game.DataOrder;
import com.sean.shared.network.game.DataTransformation;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.GameFrameReader;
import com.sean.shared.network.game.event.GameMessageDecoder;
import com.sean.shared.network.game.event.impl.WalkEvent;

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
