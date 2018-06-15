/**
 * Copyright (c) 2014 Virtue Studios
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
package com.oldscape.shared.utility;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 29, 2015
 */
public class FileUtils {

    /**
     * Returns an array of classes in a specified package
     *
     * @param packageName The package name to get the classes of
     * @return An array of classes in the package
     */
    @SuppressWarnings({"rawtypes"})
    public static Class[] getClasses(String packageName) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            assert classLoader != null;
            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);
            List<File> dirs = new ArrayList<File>();
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                dirs.add(new File(resource.getFile().replaceAll("%20", " ")));
            }
            ArrayList<Class> classes = new ArrayList<Class>();
            for (File directory : dirs) {
                classes.addAll(findClasses(directory, packageName));
            }
            return classes.toArray(new Class[classes.size()]);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * Finds a list of classes in a specified directory
     *
     * @param directory   The directory to look in
     * @param packageName The name of the package that contains the classes
     * @return The {@code List} of classes
     */
    @SuppressWarnings("rawtypes")
    private static List<Class> findClasses(File directory, String packageName) {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class") && !file.getName().contains("$")) {
                try {
                    classes.add(Class
                            .forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
                } catch (Throwable e) {

                }
            }
        }
        return classes;
    }

    public static List<File> findFilesByName(File directory, String name) {
        List<File> files = new ArrayList<File>();
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                files.addAll(findFiles(file, name));
            } else if (file.getName().equalsIgnoreCase(name)) {
                files.add(file);
            }
        }
        return files;
    }

    public static List<File> findFiles(String directory, String extention) {
        return findFiles(new File(directory), extention);
    }

    public static List<File> findFiles(File directory, String extention) {
        List<File> files = new ArrayList<File>();
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    assert !file.getName().contains(".");
                    files.addAll(findFiles(file, extention));
                } else if (file.getName().endsWith(extention)) {
                    files.add(file);
                }
            }
        }
        return files;
    }
}
