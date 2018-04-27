/**
 * Copyright (c) 2015 Kyle Friz & Kayla Friz
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
package com.sean.shared.network.game.event.impl;

import com.sean.shared.event.Event;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since Jun 5, 2015
 */
public class InterfaceSetTextEvent implements Event {

	private final int root;
	private final int child;
	private final String message;
	
	public InterfaceSetTextEvent(int root, int child, String message) {
		this.root = root;
		this.child = child;
		this.message = message;
	}

	/**
	 * @return the root
	 */
	public int getRoot() {
		return root;
	}

	/**
	 * @return the child
	 */
	public int getChild() {
		return child;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	
}
