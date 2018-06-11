/**
 * Copyright (c) Kyle Fricilone
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
package com.oldscape.tool.cache;

import com.oldscape.shared.cache.Cache;
import com.oldscape.shared.cache.Constants;
import com.oldscape.shared.cache.FileStore;
import com.oldscape.shared.cache.type.TypeListManager;

import java.io.IOException;

/**
 * @author Kyle Friz
 * @since Jan 23, 2016
 */
public class TypeDumper {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Cache cache = new Cache(FileStore.open(Constants.CACHE_PATH))) {
            TypeListManager.initialize(cache);
            TypeListManager.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
