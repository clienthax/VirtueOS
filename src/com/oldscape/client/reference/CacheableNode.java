package com.oldscape.client.reference;

public class CacheableNode extends Node {
    public CacheableNode previous;
    public CacheableNode next;
    long field2658;

    public void unlinkDual() {
        if (this.next != null) {
            this.next.previous = this.previous;
            this.previous.next = this.next;
            this.previous = null;
            this.next = null;
        }
    }
}
