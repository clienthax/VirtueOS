package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public class WidgetAnimEvent implements Event {

    int widget;

    int child;

    int anim;

    public WidgetAnimEvent(int widget, int child, int anim) {
        this.widget = widget;
        this.child = child;
        this.anim = anim;
    }

    public int getWidget() {
        return widget;
    }

    public int getChild() {
        return child;
    }

    public int getAnim() {
        return anim;
    }
}
