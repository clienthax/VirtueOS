/**
 * Copyright (c) 2015 Kyle Friz & Kayla
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
package com.oldscape.client.applet;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kyle Friz
 * @author Kayla
 * @date Apr 9, 2015
 */
public class GameApplet extends JFrame implements AppletStub {

    private static final long serialVersionUID = -2275232360198612326L;

    private String host;
    private Class<?> clnt;
    private Applet v_client;
    private Map<String, String> map;

    public GameApplet() throws Exception {
        super("VirtueOS - OSRS Private Server");
        setPreferredSize(new Dimension(783, 545));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        URLClassLoader loader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class<?> urlClass = URLClassLoader.class;
        Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
        method.setAccessible(true);
        method.invoke(loader, new Object[]{new File("./repository/applet/transformed.jar").toURI().toURL()});
    }

    public static void main(String[] args) throws Exception {
        GameApplet app = new GameApplet();
        app.startApplet();
    }

    public static void dumpCS2Scripts(Object[] params) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < params.length; i++) {
            Object obj = params[i];
            if (obj instanceof String) {
                builder.append("\"" + ((String) obj) + "\"" + ((i == params.length - 1) ? "" : ", "));
            } else {
                builder.append("" + (obj) + "" + ((i == params.length - 1) ? "" : ", "));
            }
        }
        System.out.println("player.sendCS2Script(" + params[0] + ", new Object[] { " + builder.toString() + " });");
    }

    private void startApplet() {
        try {
            clnt = Class.forName("com.oldscape.client");
            map = new HashMap<>();
            host = new String("http://127.0.0.1");

            map.put("1", "0");
            map.put("2", "5464");
            map.put("3", "");
            map.put("4", "301");
            map.put("5", "false");
            map.put("6", ".runescape.com");
            map.put("7", "true");
            map.put("8", "0");
            map.put("9", "http://www.runescape.com/g=oldscape/slr.ws?order=LPWM");
            map.put("10", "0");
            map.put("11", "0");
            map.put("12", "ElZAIrq5NpKN6D3mDdihco3oPeYN2KFy2DCquj7JMmECPmLrDP3Bnw");
            map.put("13", "5");
            map.put("14", "0");
            map.put("15", "1");
            map.put("16", "true");

            v_client = (Applet) clnt.getConstructor().newInstance();
            clnt.getSuperclass().getMethod("setStub", AppletStub.class).invoke(v_client, this);

            add(v_client);
            pack();
            setVisible(true);

            clnt.getMethod("init").invoke(v_client);
            clnt.getMethod("start").invoke(v_client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#appletResize(int, int)
     */
    @Override
    public void appletResize(int width, int height) {
        try {
            clnt.getSuperclass().getMethod("resize", Integer.class, Integer.class).invoke(v_client, width, height);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#getAppletContext()
     */
    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#getCodeBase()
     */
    @Override
    public URL getCodeBase() {
        try {
            return new URL(host);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#getDocumentBase()
     */
    @Override
    public URL getDocumentBase() {
        try {
            return new URL(host);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.applet.AppletStub#getParameter(java.lang.String)
     */
    @Override
    public String getParameter(String key) {
        return map.get(key);
    }

}
