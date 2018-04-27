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
package com.oldscape.shared.network.game.event.decoders.chat;

import com.oldscape.server.game.Server;
import com.oldscape.shared.network.game.DataType;
import com.oldscape.shared.network.game.GameFrameReader;
import com.oldscape.shared.network.game.event.GameMessageDecoder;
import com.oldscape.shared.network.game.event.impl.PublicChatMessage;

public class PublicChatDecoder implements GameMessageDecoder<PublicChatMessage> {

	private static  final char[] CHAR_ARRAY = new char[] {
			8364, 0, 8218, 65533, 8222, 8230, 8224, 8225, 65533, 8240, 65533, 8249, 65533, 0, 711, 0, 0, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 65533, 8482, 65533, 8250, 65533, 0, 731, 65533
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.oldscape.shared.network.game.event.GameMessageDecoder#decode(com.oldscape.server
	 * .shared.network.game.GameFrameReader)
	 */
	@SuppressWarnings("unused")
	@Override
	public PublicChatMessage decode(GameFrameReader frame) {

		int meh2 = (int) frame.getUnsigned(DataType.BYTE);//unsure
		int color = (int) frame.getUnsigned(DataType.BYTE);
		int effect = (int) frame.getUnsigned(DataType.BYTE);
		int decompressedLength = frame.getUnsignedSmart();
		int compressedLength = frame.getLength();

		byte[] compressedData = new byte[compressedLength];
		byte[] decompressedData = new byte[decompressedLength];

		frame.getBytes(compressedData);
		Server.getServer().getHuffman().decompress(compressedData, 0, decompressedData, 0, decompressedLength);
		String chatMessage = decodeString(decompressedData, 0, decompressedLength);

		return new PublicChatMessage(chatMessage, compressedData, color, effect);
	}


	//From kris on discord
	public static String decodeString(final byte[] buffer, final int offset, final int length) {
		final char[] chars_0 = new char[length];
		int int_2 = 0;
		for (int int_3 = 0; int_3 < length; int_3++) {
			int int_4 = buffer[int_3 + offset] & 0xFF;
			if (int_4 != 0) {
				if ((int_4 >= 128) && (int_4 < 160)) {
					char char_0 = CHAR_ARRAY[int_4 - 128];
					if (char_0 == 0) {
						char_0 = 63;
					}
					int_4 = char_0;
				}
				chars_0[int_2++] = (char) int_4;
			}
		}

		return new String(chars_0, 0, int_2);
	}
}
