/**
 * Copyright (c) 2014 RSE Studios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sean.shared.network.game.event.encoders;

import com.sean.game.model.player.Player;
import com.sean.game.model.sync.task.PlayerSynchronizationTask;
import io.netty.buffer.ByteBufAllocator;

import java.util.List;

import com.sean.game.Server;
import com.sean.shared.network.game.DataOrder;
import com.sean.shared.network.game.DataTransformation;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.FrameType;
import com.sean.shared.network.game.GameFrame;
import com.sean.shared.network.game.GameFrameBuilder;
import com.sean.shared.network.game.event.EncoderOpcode;
import com.sean.shared.network.game.event.GameMessageEncoder;
import com.sean.shared.network.game.event.impl.RegionUpdateEvent;

public final class RegionUpdateEventEncoder implements GameMessageEncoder<RegionUpdateEvent> {

	private final Server server;

	public RegionUpdateEventEncoder(Server server) {
		this.server = server;
	}

	@Override
	public GameFrame encode(ByteBufAllocator alloc, RegionUpdateEvent event) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, EncoderOpcode.REGION_STATIC, FrameType.VARIABLE_SHORT);

		if (event.isFullUpdateRequired()) {
			builder.putRawBuilder(event.getBuilder());
		}

		int chunkX = event.getCurrentPosition().getChunkX();
		int chunkY = event.getCurrentPosition().getChunkY();

		boolean forceSend = false;
		if ((48 == chunkX / 8 || chunkX / 8 == 49) && chunkY / 8 == 48) {
			forceSend = true;
		}

		if (48 == chunkX / 8 && chunkY / 8 == 148) {
			forceSend = true;
		}

		builder.put(DataType.SHORT, DataOrder.LITTLE, DataTransformation.ADD, chunkY);
		builder.put(DataType.SHORT, DataTransformation.ADD, chunkX);
		builder.put(DataType.SHORT, 9);

		System.out.println("chunkY "+chunkY+" chunkX "+chunkX+" 9");

		GameFrameBuilder xtea = new GameFrameBuilder(alloc);
		for (int xCalc = (chunkX - 6) / 8; xCalc <= (6 + chunkX) / 8; ++xCalc) {
			for (int yCalc = (chunkY - 6) / 8; yCalc <= (6 + chunkY) / 8; ++yCalc) {
				int region = yCalc + (xCalc << 8);
				if (!forceSend
						|| yCalc != 49 && 149 != yCalc && 147 != yCalc && xCalc != 50 && (xCalc != 49 || yCalc != 47)) {
					List<Integer> keys = server.getRegionManager().lookup(region).getKeys();
					keys.forEach((Integer key) -> xtea.put(DataType.INT, key));
//					keys.forEach((Integer key) -> System.out.println("xtea "+key));
				}
			}
		}

		builder.putRawBuilder(xtea);

		return builder.toGameFrame();
	}
}
