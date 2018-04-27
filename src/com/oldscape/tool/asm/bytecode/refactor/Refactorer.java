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
package com.oldscape.tool.asm.bytecode.refactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.RemappingClassAdapter;
import org.objectweb.asm.tree.ClassNode;

import com.oldscape.tool.asm.bytecode.Container;
import com.oldscape.tool.asm.bytecode.element.ClassElement;

/**
 * @author Kyle Friz
 * @since Apr 6, 2015
 */
public class Refactorer {

	private Container container;
	private RefactorMapper mapper;
	private Map<String, ClassMapping> sortedClasses;

	/**
	 * @param container
	 */
	public Refactorer(Container container) {
		this.container = container;
		this.sortedClasses = new HashMap<>();
		this.mapper = new RefactorMapper(this);
	}

	public void transform() {
		Map<String, ClassElement> refactored = new HashMap<>();
		for (ClassElement el : container().elements()) {
			String oldName = el.name();
			ClassReader cr = new ClassReader(getClassNodeBytes(el.node()));
			ClassWriter cw = new ClassWriter(cr, 0);
			RemappingClassAdapter rca = new RemappingClassAdapter(cw, mapper);
			cr.accept(rca, ClassReader.EXPAND_FRAMES);
			cr = new ClassReader(cw.toByteArray());
			ClassNode cn = new ClassNode();
			cr.accept(cn, 0);
			refactored.put(oldName, new ClassElement(cn));
		}
		
		List<String> map = new ArrayList<String>();
		for (ClassMapping factor : sortedClasses.values()) {
			map.add(new String(factor.obfName() + " -> " + factor.renName()));
		}
		
		for (Map.Entry<String, ClassElement> factor : refactored.entrySet()) {
			container.relocate(factor.getKey(), factor.getValue());
		}
	}

	private byte[] getClassNodeBytes(ClassNode cn) {
		ClassWriter cw = new ClassWriter(0);
		cn.accept(cw);
		return cw.toByteArray();
	}

	public Container container() {
		return container;
	}

	public Map<String, ClassMapping> classes() {
		return sortedClasses;
	}

	public void relocateClass(ClassElement el, String ref) {
		sortedClasses.put(el.name(), new ClassMapping(el.name(), ref));
	}
}
