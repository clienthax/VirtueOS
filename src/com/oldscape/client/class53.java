package com.oldscape.client;

import java.applet.Applet;

import netscape.javascript.JSObject;

class class53 {
   public static Object method824(final Applet var0, final String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }

   public static Object method820(final Applet var0, final String var1, final Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }
}
