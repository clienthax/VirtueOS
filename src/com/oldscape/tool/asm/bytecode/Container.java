/**
 * Copyright (c) 2015 Kyle Friz
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.tool.asm.bytecode;

import com.google.common.io.ByteStreams;
import com.oldscape.tool.asm.bytecode.element.ClassElement;
import com.oldscape.tool.asm.bytecode.refactor.Refactorer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kyle Friz
 * @since Apr 4, 2015
 */
public class Container {

    /**
     * The {@link Logger} instance
     */
    private static Logger logger = Logger.getLogger(Container.class.getName());

    private boolean jar;
    private long revision;
    private String main_class;
    private Map<String, ClassElement> elements;
    private Map<String, ByteBuffer> others;

    private Refactorer refactorer;

    public Container(File file) {
        this.elements = new HashMap<>();
        this.others = new HashMap<>();

        this.refactorer = new Refactorer(this);

        try {
            if (file.getPath().endsWith(".jar")) {
                this.jar = true;

                try (JarFile jar = new JarFile(file)) {
                    if (jar.getManifest() != null)
                        this.main_class = jar.getManifest().getMainAttributes().getValue("Main-Class");

                    Enumeration<JarEntry> enumeration = jar.entries();
                    while (enumeration.hasMoreElements()) {
                        JarEntry next = enumeration.nextElement();
                        if (next.getName().endsWith(".class")) {
                            ClassReader reader = new ClassReader(jar.getInputStream(next));
                            ClassNode node = new ClassNode();
                            reader.accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
                            ClassElement element = new ClassElement(node);

                            elements.put(element.name(), element);
                        } else if (!next.getName().contains("META-INF")) {
                            others.put(next.getName(),
                                    ByteBuffer.wrap(ByteStreams.toByteArray(jar.getInputStream(next))));
                        }
                    }
                    jar.close();
                }
            } else if (file.getPath().endsWith(".class")) {
                this.jar = false;

                ClassReader reader = new ClassReader(new FileInputStream(file));
                ClassNode node = new ClassNode();
                reader.accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
                ClassElement element = new ClassElement(node);

                elements.put(element.name(), element);
            }
            logger.info("Loaded " + elements.size() + " Class(es).");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading class(es)!", e);
        }
    }

    public void save(File file) {
        try {
            if (jar) {
                Manifest manif = new Manifest();
                Attributes global = manif.getMainAttributes();

                global.put(Attributes.Name.MANIFEST_VERSION, "1.0.0");

                if (main_class != null)
                    global.put(Attributes.Name.MAIN_CLASS, main_class.replace("/", "."));
                else
                    global.put(Attributes.Name.MAIN_CLASS, "com.oldscape.tool.client");

                global.put(Attributes.Name.CLASS_PATH, ".");
                global.put(new Attributes.Name("Bundled-By"), "Friz Transformer");
                global.put(new Attributes.Name("Bundle-Version"), "1.0.0");

                try (JarOutputStream output = new JarOutputStream(new FileOutputStream(file), manif)) {
                    for (ClassElement element : elements.values()) {
                        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                        output.putNextEntry(new JarEntry(element.name().replaceAll("\\.", "/") + ".class"));
                        element.node().accept(writer);
                        output.write(writer.toByteArray());
                        output.closeEntry();
                    }
                    for (String key : others.keySet()) {
                        output.putNextEntry(new JarEntry(key));
                        output.write(others.get(key).array());
                        output.closeEntry();
                    }
                }
            } else {
                FileOutputStream output = new FileOutputStream(file);
                for (ClassElement element : elements.values()) {
                    ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                    element.node().accept(writer);
                    output.write(writer.toByteArray());
                }
                output.close();
            }
            logger.info("Saved " + elements.size() + " Class(es).");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error saving class(es)!", e);
        }
    }

    public Collection<ClassElement> elements() {
        return elements.values();
    }

    public Refactorer refactorer() {
        return refactorer;
    }

    /**
     * @param name
     * @param element
     */
    public void relocate(String name, ClassElement element) {
        if (elements.containsKey(name))
            elements.remove(name);

        elements.put(element.name(), element);
    }

    /**
     * @param name
     * @return
     */
    public ClassElement name(String name) {
        return elements.get(name);
    }

    /**
     * @return the revision
     */
    public long getRevision() {
        return revision;
    }

    /**
     * @param revision
     *            the revision to set
     */
    public void setRevision(long revision) {
        this.revision = revision;
    }

}
