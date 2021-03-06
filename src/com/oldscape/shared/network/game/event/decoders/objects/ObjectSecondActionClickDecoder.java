package com.oldscape.shared.network.game.event.decoders.objects;

import com.oldscape.shared.network.game.DataOrder;
import com.oldscape.shared.network.game.DataTransformation;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.ObjectClickEvent;

public class ObjectSecondActionClickDecoder implements GameMessageDecoder<ObjectClickEvent> {

	@Override
	public ObjectClickEvent decode(GameFrameReader frame) {
		int y = (int) frame.getUnsigned(DataType.SHORT);
		int x = (int) frame.getUnsigned(DataType.SHORT);
		int type = (int) frame.getUnsigned(DataType.BYTE, DataTransformation.ADD);
		int object = (int) frame.getUnsigned(DataType.SHORT, DataOrder.LITTLE, DataTransformation.ADD);

		System.out.println("secondclick X: "+x+", Y:"+y+", type:"+type+" obj:"+object);
		return new ObjectClickEvent(1, object, x, y);
	}

}
