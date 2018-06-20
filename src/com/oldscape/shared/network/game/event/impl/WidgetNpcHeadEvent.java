package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public class WidgetNpcHeadEvent implements Event {

    private int widget;

    private int child;

    private int npc;

    public WidgetNpcHeadEvent(int widget, int child, int npc) {
        this.widget = widget;
        this.child = child;
        this.npc = npc;
    }

    public int getWidget() {
        return widget;
    }

    public int getChild() {
        return child;
    }

    public int getNpc() {
        return npc;
    }

}
