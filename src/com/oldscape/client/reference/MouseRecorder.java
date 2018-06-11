package com.oldscape.client.reference;

class MouseRecorder implements Runnable {
    public static Widget[][] widgets;
    static int[] field819;
    static IndexData indexMaps;
    static IndexData indexCache15;
    final Object lock;
    final int[] xs;
    final int[] ys;
    boolean isRunning;
    int index;

    MouseRecorder() {
        this.isRunning = true;
        this.lock = new Object();
        this.index = 0;
        this.xs = new int[500];
        this.ys = new int[500];
    }

    static void method1145() {
        if (WorldMapDecorationType.loadWorlds()) {
            class90.worldSelectShown = true;
        }

    }

    public void run() {
        for (; this.isRunning; ScriptVarType.method11(50L)) {
            synchronized (this.lock) {
                if (this.index < 500) {
                    this.xs[this.index] = MouseInput.mouseLastX;
                    this.ys[this.index] = MouseInput.mouseLastY;
                    ++this.index;
                }
            }
        }

    }
}
