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
package com.oldscape.tool.asm;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import com.oldscape.tool.asm.bytecode.Container;
import com.oldscape.tool.asm.transformers.FrameDumpTransformer;
import com.oldscape.tool.asm.transformers.IntegerBitwiseTransformer;
import com.oldscape.tool.asm.transformers.LdcTransformer;
import com.oldscape.tool.asm.transformers.LongBitwiseTransformer;
import com.oldscape.tool.asm.transformers.refactor.ClassTransformer;

/**
 * @author Kyle Friz
 * @since Apr 4, 2015
 */
public class Application {

	/**
	 * The {@link Logger} instance
	 */
	private static Logger logger = Logger
			.getLogger(Application.class.getName());

	public static void main(String[] args) {
		logger.info("Intializing Friz Transformer!");

		Container container = new Container(new File("repository/applet/gamepack.jar"));
		List<Transformer> transformers = Collections.
				synchronizedList(new ArrayList<>());

		synchronized (transformers) {
			transformers.add(new FrameDumpTransformer(container));
			transformers.add(new IntegerBitwiseTransformer(container));
			transformers.add(new LongBitwiseTransformer(container));
			transformers.add(new LdcTransformer(container, true, true, true));
			transformers.add(new ClassTransformer(container));
		}

		synchronized (transformers) {
			Iterator<Transformer> iterator = transformers.iterator();
			while (iterator.hasNext()) {
				Transformer transformer = iterator.next();
				transformer.transform();
				transformer.log();
			}
		}

		synchronized (container) {
			container.refactorer().transform();
		}

		container.save(new File("repository/applet/transformed.jar"));

		logger.info("Finished Friz Transformer!");
	}
}
