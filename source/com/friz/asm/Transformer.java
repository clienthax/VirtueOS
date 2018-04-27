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
package com.friz.asm;

import java.text.DecimalFormat;

import com.friz.asm.bytecode.Container;

/**
 * @author Kyle Friz
 * @since Apr 4, 2015
 */
public abstract class Transformer {

	private Container container;

	private DecimalFormat form = new DecimalFormat("###,###.##");

	private int[] pointers = new int[6];
	private int[] totals = new int[6];

	public Transformer(Container container) {
		this.container = container;
	}

	public abstract void transform();

	public abstract void log();

	public Container container() {
		return container;
	}

	public void pInc(int index) {
		pointers[index]++;
		totals[index]++;
	}

	public void tInc(int index) {
		totals[index]++;
	}

	public String pointer(int index) {
		return form.format(pointers[index]);
	}

	public String total(int index) {
		return form.format(totals[index]);
	}

	public String percent(int pointer) {
		return percent(pointer, 0);
	}

	public String percent(int pointer, int total) {
		return form.format((((double) pointers[pointer] / totals[total]) * 100));
	}

}
