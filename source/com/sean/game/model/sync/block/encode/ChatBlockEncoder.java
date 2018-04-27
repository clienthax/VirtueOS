/**
 * Copyright (c) 2015 Kyle Friz
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
package com.sean.game.model.sync.block.encode;

import com.sean.game.model.sync.block.BlockType;
import com.sean.game.model.sync.block.ChatBlock;
import com.sean.game.model.sync.block.SynchronizationBlock;
import com.sean.shared.network.game.DataType;
import com.sean.shared.network.game.GameFrameBuilder;

/**
 * @author Kyle Friz
 * @since  Aug 31, 2015
 */
public class ChatBlockEncoder extends SynchronizationBlockEncoder {

	public ChatBlockEncoder() {
		super(0x10, 0);
	}

	/* (non-Javadoc)
	 * @see com.sean.game.model.sync.block.encode.SynchronizationBlockEncoder#encodeBlock(com.sean.game.model.sync.block.SynchronizationBlock, com.sean.shared.network.game.GameFrameBuilder)
	 */
	@Override
	public void encodeBlock(SynchronizationBlock block, GameFrameBuilder builder, boolean player) {
		ChatBlock chat = (ChatBlock) block;
		byte[] bytes = chat.getCompressedMessage();
		builder.put(DataType.SHORT, chat.getTextEffects() << 8 | chat.getTextColor());
		builder.put(DataType.BYTE, chat.getPrivilegeLevel().ordinal());
		builder.put(DataType.BYTE, chat.isQuickChat() ? 1 : 0);
		builder.put(DataType.BYTE, bytes.length);
		builder.putBytes(bytes);
	}

	/* (non-Javadoc)
	 * @see com.sean.game.model.sync.block.encode.SynchronizationBlockEncoder#getType()
	 */
	@Override
	public BlockType getType() {
		return BlockType.CHAT;
	}
	
}
