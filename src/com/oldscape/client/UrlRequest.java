package com.oldscape.client;

import java.net.URL;

public class UrlRequest {
   public static IndexDataBase widgetIndex;
   public static short[][] field2135;
   static Widget field2137;
   final URL url;
   volatile boolean isDone0;
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   public boolean isDone() {
      return this.isDone0;
   }

   public byte[] getResponse() {
      return this.response0;
   }
}
