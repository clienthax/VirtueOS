package com.oldscape.client;

public class Task {
   Task task;
   public volatile int status;
   int type;
   public int intArgument;
   Object objectArgument;
   public volatile Object value;

   Task() {
      this.status = 0;
   }
}
