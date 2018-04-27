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
package com.friz.asm.bytecode.element;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

/**
 * @author Kyle Friz
 * @since Apr 4, 2015
 */
public class ClassElement {

	private ClassNode node;
	private List<InterfaceElement> interfaces;
	private List<MethodElement> methods;
	private List<FieldElement> fields;

	public ClassElement(ClassNode node) {
		this.node = node;
		this.interfaces = new ArrayList<>();
		this.methods = new ArrayList<>();
		this.fields = new ArrayList<>();

		for (Object i : node.interfaces) {
			interfaces.add(new InterfaceElement((String) i));
		}

		for (Object m : node.methods) {
			methods.add(new MethodElement(this, (MethodNode) m));
		}

		for (Object f : node.fields) {
			fields.add(new FieldElement(this, (FieldNode) f));
		}

	}

	public ClassNode node() {
		return node;
	}

	public String name() {
		return node.name;
	}

	public String superName() {
		return node.superName;
	}

	public List<InterfaceElement> interfaces() {
		return interfaces;
	}

	public List<MethodElement> methods() {
		return methods;
	}

	public boolean containsMethod(String name, String desc) {
		for (MethodElement element : methods) {
			if (element.name().equals(name) && element.desc().equals(desc))
				return true;

		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public void addMethod(MethodElement method) {
		methods.add(method);
		node.methods.add(method.node());
	}

	public void removeMethod(MethodElement method, boolean safe) {
		if (safe)
			methods.remove(method);

		node.methods.remove(method.node());
	}

	public List<FieldElement> fields() {
		return fields;
	}

	public boolean containsField(String name, String desc) {
		for (FieldElement element : fields) {
			if (element.name().equals(name) && element.desc().equals(desc))
				return true;

		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public void addField(FieldElement field) {
		fields.add(field);
		node.fields.add(field.node());
	}

	public void removeField(FieldElement field, boolean safe) {
		if (safe)
			fields.remove(field);

		node.fields.remove(field.node());
	}

	/**
	 * Refreshes Interfaces/Methods/Fields after an unsafe concurrent operation
	 * was performed
	 */
	public void refresh() {
		this.interfaces = new ArrayList<>();
		this.methods = new ArrayList<>();
		this.fields = new ArrayList<>();

		for (Object i : node.interfaces) {
			interfaces.add(new InterfaceElement((String) i));
		}

		for (Object m : node.methods) {
			methods.add(new MethodElement(this, (MethodNode) m));
		}

		for (Object f : node.fields) {
			fields.add(new FieldElement(this, (FieldNode) f));
		}
	}

	public boolean isPublic() {
		return Modifier.isPublic(node.access);
	}

	public boolean isPrivate() {
		return Modifier.isPrivate(node.access);
	}

	public boolean isFinal() {
		return Modifier.isFinal(node.access);
	}

	public boolean isStatic() {
		return Modifier.isStatic(node.access);
	}

	public boolean isStrict() {
		return Modifier.isStrict(node.access);
	}

	public boolean isProtected() {
		return Modifier.isProtected(node.access);
	}

	public boolean isAbstract() {
		return Modifier.isAbstract(node.access);
	}

	public boolean isInterface() {
		return Modifier.isInterface(node.access);
	}

}
