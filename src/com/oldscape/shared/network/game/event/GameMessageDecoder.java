package com.oldscape.shared.network.game.event;

import com.oldscape.shared.event.Event;
import com.oldscape.shared.network.game.GameFrameReader;

/**
 * Created by sean on 09/08/14.
 */
public interface GameMessageDecoder<T extends Event> {

	public T decode(GameFrameReader frame);

}
