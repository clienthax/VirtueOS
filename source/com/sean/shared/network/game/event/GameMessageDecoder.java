package com.sean.shared.network.game.event;

import com.sean.shared.event.Event;
import com.sean.shared.network.game.GameFrameReader;

/**
 * Created by sean on 09/08/14.
 */
public interface GameMessageDecoder<T extends Event> {

	public T decode(GameFrameReader frame);

}
