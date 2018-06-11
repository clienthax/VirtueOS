package com.oldscape.client.reference;

class class236 extends CacheableNode {

    final int width;
    final int height;
    final int[] field2771;
    final int[] field2774;

    class236(final int width, final int height, final int[] var3, final int[] var4) {
        this.width = width;
        this.height = height;
        this.field2771 = var3;
        this.field2774 = var4;
    }

    static void method4345(final Widget[] widgets, final int id) {
        for (final Widget widget : widgets) {
            if (widget != null) {
                if (widget.type == 0) {
                    if (widget.children != null) {
                        method4345(widget.children, id);
                    }

                    final WidgetNode widgetNode = (WidgetNode) Client.componentTable.get(widget.id);
                    if (widgetNode != null) {
                        DynamicObject.method2026(widgetNode.id, id);
                    }
                }

                ScriptEvent scriptEvent;
                if (id == 0 && widget.onDialogAbortListener != null) {
                    scriptEvent = new ScriptEvent();
                    scriptEvent.widget = widget;
                    scriptEvent.objs = widget.onDialogAbortListener;
                    AbstractSoundSystem.method2256(scriptEvent);
                }

                if (id == 1 && widget.onSubChangeListener != null) {
                    if (widget.index >= 0) {
                        final Widget var6 = class44.getWidget(widget.id);
                        if (var6 == null || var6.children == null || widget.index >= var6.children.length || widget != var6.children[widget.index]) {
                            continue;
                        }
                    }

                    scriptEvent = new ScriptEvent();
                    scriptEvent.widget = widget;
                    scriptEvent.objs = widget.onSubChangeListener;
                    AbstractSoundSystem.method2256(scriptEvent);
                }
            }
        }

    }

    boolean method4346(final int var1, final int var2) {
        if (var2 >= 0 && var2 < this.field2774.length) {
            final int var3 = this.field2774[var2];
            return var1 >= var3 && var1 <= var3 + this.field2771[var2];
        }

        return false;
    }
}
