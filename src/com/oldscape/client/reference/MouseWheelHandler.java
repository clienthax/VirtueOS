package com.oldscape.client.reference;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class MouseWheelHandler implements MouseWheel, MouseWheelListener {
    private int rotation;

    MouseWheelHandler() {
        this.rotation = 0;
    }

    void addTo(final Component var1) {
        var1.addMouseWheelListener(this);
    }

    void removeFrom(final Component var1) {
        var1.removeMouseWheelListener(this);
    }

    public synchronized int useRotation() {
        final int var1 = this.rotation;
        this.rotation = 0;
        return var1;
    }

    public synchronized void mouseWheelMoved(final MouseWheelEvent var1) {
        this.rotation += var1.getWheelRotation();
    }
}
