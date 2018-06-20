package com.oldscape.shared.network.game.event.impl;

import com.oldscape.shared.event.Event;

public class ContinueButtonEvent implements Event {

    int widget;

    int child;

    int button; // ?

    public ContinueButtonEvent(int widget, int child, int button) {
        this.widget = widget;
        this.child = child;
        this.button = button;
    }

    public int getWidget() {
        return widget;
    }

    public int getChild() {
        return child;
    }

    public int getButton() {
        return button;
    }

}
