package com.oldscape.client;

import java.applet.Applet;

import netscape.javascript.JSObject;

public class class53 {
   public static Object method824(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }

   public static Object method820(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }
}
