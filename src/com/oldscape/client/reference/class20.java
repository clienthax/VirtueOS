package com.oldscape.client.reference;

class class20 {
    static int field336;
    static MapIconReference scriptMapIconReference;
    static Font font_p12full;
    static int cameraY;

    static void addChatMessage(final int var0, final String var1, final String var2, final String var3) {
        ChatLineBuffer chatLineBuffer = class95.chatLineMap.get(var0);
        if (chatLineBuffer == null) {
            chatLineBuffer = new ChatLineBuffer();
            class95.chatLineMap.put(var0, chatLineBuffer);
        }

        final MessageNode messageNode = chatLineBuffer.addMessage(var0, var1, var2, var3);
        class95.messages.put(messageNode, messageNode.id);
        class95.field1453.add(messageNode);
        Client.chatCycle = Client.cycleCntr;
    }

    static void runWidgetOnLoadListener(final int var0) {
        if (var0 != -1) {
            if (class189.loadWidget(var0)) {
                final Widget[] var1 = MouseRecorder.widgets[var0];

                for (final Widget var3 : var1) {
                    if (var3.onLoadListener != null) {
                        final ScriptEvent var4 = new ScriptEvent();
                        var4.widget = var3;
                        var4.objs = var3.onLoadListener;
                        FloorUnderlayDefinition.runScript(var4, 5000000);
                    }
                }

            }
        }
    }
}
