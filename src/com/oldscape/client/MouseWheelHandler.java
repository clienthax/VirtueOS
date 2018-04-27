package com.oldscape.client;

import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class MouseWheelHandler implements MouseWheel, MouseWheelListener {
   int rotation;

   MouseWheelHandler() {
      this.rotation = 0;
   }

   void addTo(Component var1) {
      var1.addMouseWheelListener(this);
   }

   void removeFrom(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized int useRotation() {
      int var1 = this.rotation;
      this.rotation = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.rotation += var1.getWheelRotation();
   }
}
