package com.oldscape.client.reference;

final class Node2LinkedList {
    private final CacheableNode sentinel;

    public Node2LinkedList() {
        this.sentinel = new CacheableNode();
        this.sentinel.previous = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    static void method3860(final CacheableNode var0, final CacheableNode var1) {
        if (var0.next != null) {
            var0.unlinkDual();
        }

        var0.next = var1;
        var0.previous = var1.previous;
        var0.next.previous = var0;
        var0.previous.next = var0;
    }

    public void push(final CacheableNode var1) {
        if (var1.next != null) {
            var1.unlinkDual();
        }

        var1.next = this.sentinel.next;
        var1.previous = this.sentinel;
        var1.next.previous = var1;
        var1.previous.next = var1;
    }

    public void setHead(final CacheableNode var1) {
        if (var1.next != null) {
            var1.unlinkDual();
        }

        var1.next = this.sentinel;
        var1.previous = this.sentinel.previous;
        var1.next.previous = var1;
        var1.previous.next = var1;
    }

    CacheableNode pop() {
        final CacheableNode var1 = this.sentinel.previous;
        if (var1 == this.sentinel) {
            return null;
        } else {
            var1.unlinkDual();
            return var1;
        }
    }

    public CacheableNode peek() {
        final CacheableNode var1 = this.sentinel.previous;
        return var1 == this.sentinel ? null : var1;
    }

    void clear() {
        while (true) {
            final CacheableNode var1 = this.sentinel.previous;
            if (var1 == this.sentinel) {
                return;
            }

            var1.unlinkDual();
        }
    }
}
