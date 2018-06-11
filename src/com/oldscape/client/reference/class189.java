package com.oldscape.client.reference;

import java.util.HashMap;

class class189 {
    static IndexData indexTrack2;

    static {
        new HashMap();
    }

    static boolean loadWidget(final int var0) {
        if (class154.validInterfaces[var0]) {
            return true;
        } else if (!UrlRequest.widgetIndex.containsFile(var0)) {
            return false;
        } else {
            final int var1 = UrlRequest.widgetIndex.fileCount(var0);
            if (var1 != 0) {
                if (MouseRecorder.widgets[var0] == null) {
                    MouseRecorder.widgets[var0] = new Widget[var1];
                }

                for (int var2 = 0; var2 < var1; ++var2) {
                    if (MouseRecorder.widgets[var0][var2] == null) {
                        final byte[] var3 = UrlRequest.widgetIndex.getConfigData(var0, var2);
                        if (var3 != null) {
                            MouseRecorder.widgets[var0][var2] = new Widget();
                            MouseRecorder.widgets[var0][var2].id = var2 + (var0 << 16);
                            if (var3[0] == -1) {
                                MouseRecorder.widgets[var0][var2].decodeActive(new Buffer(var3));
                            } else {
                                MouseRecorder.widgets[var0][var2].decode(new Buffer(var3));
                            }
                        }
                    }
                }

            }
            class154.validInterfaces[var0] = true;
            return true;
        }
    }
}
