/**
 * Copyright (c) 2015 Kyle Friz & Kayla Friz
 * <p>
 * ChatCrownType is hereby granted, free of charge, to any person obtaining a copy
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
package com.oldscape.shared.script;

import com.oldscape.shared.script.listeners.*;
import com.oldscape.shared.utility.FileUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Kyle Friz
 * @author Kayla Friz
 * @since May 29, 2015
 */
public class ScriptManager {

    private Logger logger = Logger.getLogger(ScriptManager.class.getName());

    private Map<String, CommandListener> commandListeners = new HashMap<>();

    private Map<Integer, WidgetListener> widgetListeners = new HashMap<>();

    private Map<Integer, LocationListener> locationListeners = new HashMap<>();

    private Map<Integer, NpcListener> npcListeners = new HashMap<>();

    private Map<Integer, ObjectListener> objectListeners = new HashMap<>();

    public void initialize() {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine nashorn = engineManager.getEngineByName("nashorn");
        List<File> scripts = FileUtils.findFiles("./repository/scripts/", ".js");
        scripts.forEach((File script) -> {
            try {
                nashorn.eval(new FileReader(script));
                Invocable invoke = (Invocable) nashorn;
                invoke.invokeFunction("listen", this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        logger.info("Loaded " +
                (commandListeners.size() +
                locationListeners.size() +
                widgetListeners.size() +
                npcListeners.size() +
                objectListeners.size()
                ) +
                " Nashorn Script(s).");
    }

    public void setCommandListener(CommandListener listener, String... syntaxes) {
        Arrays.stream(syntaxes).forEach((String syntax) -> {
            commandListeners.put(syntax, listener);
        });
    }

    public CommandListener forSyntax(String syntax) {
        return commandListeners.get(syntax);
    }

    public void setWidgetListener(WidgetListener listener, Integer... ids) {
        Arrays.stream(ids).forEach((Integer id) -> {
            widgetListeners.put(id, listener);
        });
    }

    public WidgetListener forWidget(Integer id) {
        return widgetListeners.get(id);
    }

    public void setLocationListener(LocationListener listener, Integer... ids) {
        Arrays.stream(ids).forEach((Integer id) -> {
            locationListeners.put(id, listener);
        });
    }

    public LocationListener forLocation(Integer id) {
        return locationListeners.get(id);
    }

    public void setNpcListener(NpcListener listener, Integer... ids) {
        Arrays.stream(ids).forEach((Integer id) -> {
            npcListeners.put(id, listener);
        });
    }

    public NpcListener forNpc(Integer id) {
        return npcListeners.get(id);
    }

    public void setObjectListener(ObjectListener listener, Integer... ids) {
        Arrays.stream(ids).forEach((Integer id) -> {
            objectListeners.put(id, listener);
        });
    }

    public ObjectListener forObject(Integer id) {
        return objectListeners.get(id);
    }

}
