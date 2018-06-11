package com.oldscape.client.reference;

public class Deque {
    public final Node head;
    private Node current;

    public Deque() {
        this.head = new Node();
        this.head.next = this.head;
        this.head.previous = this.head;
    }

    public static void method4011(final Node var0, final Node var1) {
        if (var0.previous != null) {
            var0.unlink();
        }

        var0.previous = var1.previous;
        var0.next = var1;
        var0.previous.next = var0;
        var0.next.previous = var0;
    }

    public void clear() {
        while (true) {
            final Node var1 = this.head.next;
            if (var1 == this.head) {
                this.current = null;
                return;
            }

            var1.unlink();
        }
    }

    public void addFront(final Node var1) {
        if (var1.previous != null) {
            var1.unlink();
        }

        var1.previous = this.head.previous;
        var1.next = this.head;
        var1.previous.next = var1;
        var1.next.previous = var1;
    }

    public void addTail(final Node var1) {
        if (var1.previous != null) {
            var1.unlink();
        }

        var1.previous = this.head;
        var1.next = this.head.next;
        var1.previous.next = var1;
        var1.next.previous = var1;
    }

    public Node popFront() {
        final Node var1 = this.head.next;
        if (var1 == this.head) {
            return null;
        } else {
            var1.unlink();
            return var1;
        }
    }

    public Node popTail() {
        final Node var1 = this.head.previous;
        if (var1 == this.head) {
            return null;
        } else {
            var1.unlink();
            return var1;
        }
    }

    public Node getFront() {
        final Node var1 = this.head.next;
        if (var1 == this.head) {
            this.current = null;
            return null;
        } else {
            this.current = var1.next;
            return var1;
        }
    }

    public Node getTail() {
        final Node var1 = this.head.previous;
        if (var1 == this.head) {
            this.current = null;
            return null;
        } else {
            this.current = var1.previous;
            return var1;
        }
    }

    public Node getNext() {
        final Node var1 = this.current;
        if (var1 == this.head) {
            this.current = null;
            return null;
        } else {
            this.current = var1.next;
            return var1;
        }
    }

    public Node getPrevious() {
        final Node var1 = this.current;
        if (var1 == this.head) {
            this.current = null;
            return null;
        } else {
            this.current = var1.previous;
            return var1;
        }
    }
}
