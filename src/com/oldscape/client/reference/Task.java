package com.oldscape.client.reference;

public class Task {
    public volatile int status;
    public int intArgument;
    public volatile Object value;
    Task task;
    int type;
    Object objectArgument;

    Task() {
        this.status = 0;
    }
}
